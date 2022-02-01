package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel
  extends DataSetObservable
{
  static final String ATTRIBUTE_ACTIVITY = "activity";
  static final String ATTRIBUTE_TIME = "time";
  static final String ATTRIBUTE_WEIGHT = "weight";
  static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  static final String LOG_TAG = "ActivityChooserModel";
  static final String TAG_HISTORICAL_RECORD = "historical-record";
  static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  private final List<ActivityChooserModel.ActivityResolveInfo> mActivities = new ArrayList();
  private ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivityChooserModel.ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter();
  boolean mCanReadHistoricalData = true;
  final Context mContext;
  private final List<ActivityChooserModel.HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(".xml");
      this.mHistoryFileName = paramContext.toString();
      return;
    }
    this.mHistoryFileName = paramString;
  }
  
  private boolean addHistoricalRecord(ActivityChooserModel.HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }
  
  private void ensureConsistentState()
  {
    boolean bool1 = loadActivitiesIfNeeded();
    boolean bool2 = readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if ((bool1 | bool2))
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel2 = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      ActivityChooserModel localActivityChooserModel1 = localActivityChooserModel2;
      if (localActivityChooserModel2 == null)
      {
        localActivityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel1);
      }
      return localActivityChooserModel1;
    }
  }
  
  private boolean loadActivitiesIfNeeded()
  {
    boolean bool = this.mReloadActivities;
    int i = 0;
    if ((bool) && (this.mIntent != null))
    {
      this.mReloadActivities = false;
      this.mActivities.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int j = localList.size();
      while (i < j)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        this.mActivities.add(new ActivityChooserModel.ActivityResolveInfo(localResolveInfo));
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void persistHistoricalDataIfNeeded()
  {
    if (this.mReadShareHistoryCalled)
    {
      if (!this.mHistoricalRecordsChanged) {
        return;
      }
      this.mHistoricalRecordsChanged = false;
      if (!TextUtils.isEmpty(this.mHistoryFileName)) {
        new ActivityChooserModel.PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName });
      }
      return;
    }
    throw new IllegalStateException("No preceding call to #readHistoricalData");
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int j = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (j <= 0) {
      return;
    }
    this.mHistoricalRecordsChanged = true;
    int i = 0;
    while (i < j)
    {
      ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)this.mHistoricalRecords.remove(0);
      i += 1;
    }
  }
  
  private boolean readHistoricalDataIfNeeded()
  {
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
      return true;
    }
    return false;
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 116	androidx/appcompat/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 141	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 254	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 260	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc_w 262
    //   21: invokeinterface 268 3 0
    //   26: iconst_0
    //   27: istore_1
    //   28: iload_1
    //   29: iconst_1
    //   30: if_icmpeq +18 -> 48
    //   33: iload_1
    //   34: iconst_2
    //   35: if_icmpeq +13 -> 48
    //   38: aload_3
    //   39: invokeinterface 271 1 0
    //   44: istore_1
    //   45: goto -17 -> 28
    //   48: ldc 42
    //   50: aload_3
    //   51: invokeinterface 274 1 0
    //   56: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +126 -> 185
    //   62: aload_0
    //   63: getfield 93	androidx/appcompat/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   66: astore 4
    //   68: aload 4
    //   70: invokeinterface 187 1 0
    //   75: aload_3
    //   76: invokeinterface 271 1 0
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_1
    //   84: if_icmpne +12 -> 96
    //   87: aload_2
    //   88: ifnull +218 -> 306
    //   91: aload_2
    //   92: invokevirtual 282	java/io/FileInputStream:close	()V
    //   95: return
    //   96: iload_1
    //   97: iconst_3
    //   98: if_icmpeq -23 -> 75
    //   101: iload_1
    //   102: iconst_4
    //   103: if_icmpne +6 -> 109
    //   106: goto -31 -> 75
    //   109: ldc 39
    //   111: aload_3
    //   112: invokeinterface 274 1 0
    //   117: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +54 -> 174
    //   123: aload 4
    //   125: new 241	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
    //   128: dup
    //   129: aload_3
    //   130: aconst_null
    //   131: ldc 8
    //   133: invokeinterface 286 3 0
    //   138: aload_3
    //   139: aconst_null
    //   140: ldc 11
    //   142: invokeinterface 286 3 0
    //   147: invokestatic 292	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: aload_3
    //   151: aconst_null
    //   152: ldc 14
    //   154: invokeinterface 286 3 0
    //   159: invokestatic 298	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   162: invokespecial 301	androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   165: invokeinterface 149 2 0
    //   170: pop
    //   171: goto -96 -> 75
    //   174: new 248	org/xmlpull/v1/XmlPullParserException
    //   177: dup
    //   178: ldc_w 303
    //   181: invokespecial 304	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: new 248	org/xmlpull/v1/XmlPullParserException
    //   188: dup
    //   189: ldc_w 306
    //   192: invokespecial 304	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: astore_3
    //   197: goto +110 -> 307
    //   200: astore_3
    //   201: getstatic 308	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   204: astore 4
    //   206: new 130	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   213: astore 5
    //   215: aload 5
    //   217: ldc_w 310
    //   220: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 5
    //   226: aload_0
    //   227: getfield 141	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   230: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 4
    //   236: aload 5
    //   238: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload_3
    //   242: invokestatic 316	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   245: pop
    //   246: aload_2
    //   247: ifnull +59 -> 306
    //   250: goto -159 -> 91
    //   253: astore_3
    //   254: getstatic 308	androidx/appcompat/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   257: astore 4
    //   259: new 130	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   266: astore 5
    //   268: aload 5
    //   270: ldc_w 310
    //   273: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 5
    //   279: aload_0
    //   280: getfield 141	androidx/appcompat/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   283: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 4
    //   289: aload 5
    //   291: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: aload_3
    //   295: invokestatic 316	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   298: pop
    //   299: aload_2
    //   300: ifnull +6 -> 306
    //   303: goto -212 -> 91
    //   306: return
    //   307: aload_2
    //   308: ifnull +7 -> 315
    //   311: aload_2
    //   312: invokevirtual 282	java/io/FileInputStream:close	()V
    //   315: aload_3
    //   316: athrow
    //   317: astore_2
    //   318: return
    //   319: astore_2
    //   320: return
    //   321: astore_2
    //   322: goto -7 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	ActivityChooserModel
    //   27	77	1	i	int
    //   11	301	2	localFileInputStream	java.io.FileInputStream
    //   317	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   319	1	2	localIOException1	java.io.IOException
    //   321	1	2	localIOException2	java.io.IOException
    //   15	136	3	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   196	1	3	localObject1	Object
    //   200	42	3	localIOException3	java.io.IOException
    //   253	63	3	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   66	222	4	localObject2	Object
    //   213	77	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	26	196	finally
    //   38	45	196	finally
    //   48	75	196	finally
    //   75	82	196	finally
    //   109	171	196	finally
    //   174	185	196	finally
    //   185	196	196	finally
    //   201	246	196	finally
    //   254	299	196	finally
    //   12	26	200	java/io/IOException
    //   38	45	200	java/io/IOException
    //   48	75	200	java/io/IOException
    //   75	82	200	java/io/IOException
    //   109	171	200	java/io/IOException
    //   174	185	200	java/io/IOException
    //   185	196	200	java/io/IOException
    //   12	26	253	org/xmlpull/v1/XmlPullParserException
    //   38	45	253	org/xmlpull/v1/XmlPullParserException
    //   48	75	253	org/xmlpull/v1/XmlPullParserException
    //   75	82	253	org/xmlpull/v1/XmlPullParserException
    //   109	171	253	org/xmlpull/v1/XmlPullParserException
    //   174	185	253	org/xmlpull/v1/XmlPullParserException
    //   185	196	253	org/xmlpull/v1/XmlPullParserException
    //   0	12	317	java/io/FileNotFoundException
    //   91	95	319	java/io/IOException
    //   311	315	321	java/io/IOException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty()))
    {
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
      return true;
    }
    return false;
  }
  
  public Intent chooseActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null) {
        return null;
      }
      ensureConsistentState();
      Object localObject2 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
      localObject2 = new ComponentName(((ActivityChooserModel.ActivityResolveInfo)localObject2).resolveInfo.activityInfo.packageName, ((ActivityChooserModel.ActivityResolveInfo)localObject2).resolveInfo.activityInfo.name);
      Intent localIntent1 = new Intent(this.mIntent);
      localIntent1.setComponent((ComponentName)localObject2);
      if (this.mActivityChoserModelPolicy != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2)) {
          return null;
        }
      }
      addHistoricalRecord(new ActivityChooserModel.HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    int i;
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      List localList = this.mActivities;
      int j = localList.size();
      i = 0;
      if (i < j)
      {
        if (((ActivityChooserModel.ActivityResolveInfo)localList.get(i)).resolveInfo == paramResolveInfo) {
          return i;
        }
      }
      else {
        return -1;
      }
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivityChooserModel.ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter) {
        return;
      }
      this.mActivitySorter = paramActivitySorter;
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = localActivityResolveInfo2.weight - localActivityResolveInfo1.weight + 5.0F;
          addHistoricalRecord(new ActivityChooserModel.HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt) {
        return;
      }
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent) {
        return;
      }
      this.mIntent = paramIntent;
      this.mReloadActivities = true;
      ensureConsistentState();
      return;
    }
  }
  
  public void setOnChooseActivityListener(ActivityChooserModel.OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0.1
 */