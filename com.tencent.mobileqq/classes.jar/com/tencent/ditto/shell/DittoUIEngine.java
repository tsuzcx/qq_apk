package com.tencent.ditto.shell;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.content.res.DittoResources;
import com.tencent.ditto.reflect.DittoValue.GLOBAL;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.FileUtils;
import com.tencent.ditto.utils.Log;
import com.tencent.ditto.widget.DittoButtonArea;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DittoUIEngine
{
  private static float DENSITY = 0.0F;
  private static final String HABO_UPDATE_JSON_FILE_CMD = "tencent.ditto.updateLayoutFile";
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static float SCREEN_HEIGHT = 0.0F;
  private static float SCREEN_WIDTH = 0.0F;
  private static final String TAG = "DittoUIEngine";
  private static boolean needLoadFromSdcard = true;
  private static volatile DittoValue.GLOBAL outerGlobalData;
  private static volatile DittoUIEngine sInstance;
  private Map<String, String> fileMd5 = null;
  private final Map<String, List<DittoArea>> inflatedAreaBuffer = new HashMap();
  private final HashMap<String, JSONObject> jsonCache = new HashMap();
  private Context mContext;
  private DittoResources mDittoResources;
  private Map<String, String> mJsonContentMap;
  private Map<String, String> mJsonMd5Map;
  private Class mRClass;
  private DittoUIEngine.IReporter mReporter;
  private final Map<String, Integer> resourceIdCache = new ConcurrentHashMap();
  private String subDirectoryPath = "";
  
  public DittoUIEngine()
  {
    DittoLog.v(DittoButtonArea.class.toString());
  }
  
  private void clearCanvasUIFileInfo()
  {
    try
    {
      Map localMap = this.fileMd5;
      if (localMap != null) {
        localMap.clear();
      }
      return;
    }
    finally {}
  }
  
  private void createVersionFile(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.mContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.subDirectoryPath);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("version");
    localObject = new File(((StringBuilder)localObject).toString(), paramString);
    File localFile = ((File)localObject).getParentFile();
    if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs()))
    {
      DittoLog.e(String.format("create version file:%s failed", new Object[] { paramString }));
      return;
    }
    try
    {
      if (!((File)localObject).createNewFile())
      {
        DittoLog.e(String.format("create version file:%s failed", new Object[] { paramString }));
        return;
      }
    }
    catch (IOException localIOException)
    {
      DittoLog.e("DITTO_UI", String.format("create version file:%s failed", new Object[] { paramString }), localIOException);
    }
  }
  
  public static DittoUIEngine g()
  {
    try
    {
      if (sInstance == null) {
        synchronized (INSTANCE_LOCK)
        {
          if (sInstance == null) {
            sInstance = new DittoUIEngine();
          }
        }
      }
      ??? = sInstance;
      return ???;
    }
    finally {}
  }
  
  private JSONObject generateBuffer(String paramString1, String arg2)
  {
    JSONObject localJSONObject = new JSONObject(???);
    synchronized (this.inflatedAreaBuffer)
    {
      if (this.inflatedAreaBuffer.containsKey(paramString1)) {
        this.inflatedAreaBuffer.remove(paramString1);
      }
      Object localObject = new ArrayList();
      this.inflatedAreaBuffer.put(paramString1, localObject);
      DittoUIEngine.FakeHost localFakeHost = new DittoUIEngine.FakeHost(this);
      int i = 0;
      while (i < 6)
      {
        ((List)localObject).add(inflateDittoArea(localFakeHost, localJSONObject, null));
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generated area buffer:");
      ((StringBuilder)localObject).append(paramString1);
      DittoLog.i(((StringBuilder)localObject).toString());
      return localJSONObject;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private Map<String, String> generateFileMd5()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(g().mContext.getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.subDirectoryPath);
        ((StringBuilder)localObject1).append(File.separator);
        localObject1 = new File(((StringBuilder)localObject1).toString());
        Object localObject2;
        Object localObject3;
        if (((File)localObject1).exists())
        {
          localObject1 = ((File)localObject1).listFiles();
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            int j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject2 = localObject1[i];
              localObject3 = FileUtils.getMd5ByFile((File)localObject2);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Layout File from sd card:");
              localStringBuilder.append(((File)localObject2).getName());
              localStringBuilder.append(" md5:");
              localStringBuilder.append((String)localObject3);
              DittoLog.w("DITTO_UI", localStringBuilder.toString());
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label320;
              }
              localConcurrentHashMap.put(((File)localObject2).getName(), localObject3);
              break label320;
            }
          }
        }
        localObject1 = this.mJsonMd5Map;
        if (localObject1 != null)
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            localObject2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              continue;
            }
            localConcurrentHashMap.put(localObject2, localObject3);
            continue;
          }
        }
        return localConcurrentHashMap;
      }
      catch (Exception localException)
      {
        DittoLog.e("DITTO_UI", "", localException);
      }
      label320:
      i += 1;
    }
  }
  
  public static DittoValue.GLOBAL getOuterGlobalData()
  {
    return outerGlobalData;
  }
  
  public static float getScreenHeight()
  {
    return SCREEN_HEIGHT;
  }
  
  public static float getScreenWidth()
  {
    return SCREEN_WIDTH;
  }
  
  private DittoArea inflateDittoArea(DittoHost paramDittoHost, JSONObject paramJSONObject, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = DittoAreaEnv.findAreaClass(paramJSONObject.getString("class"));
    Object localObject2 = paramJSONObject.getJSONObject("shell");
    ArrayMap localArrayMap = new ArrayMap();
    localObject2 = LayoutAttrSet.createFrom((JSONObject)localObject2, new DittoUIEngine.1(this, localArrayMap));
    int i = 0;
    localObject1 = (DittoArea)((Class)localObject1).getConstructor(new Class[] { DittoHost.class, LayoutAttrSet.class }).newInstance(new Object[] { paramDittoHost, localObject2 });
    ((DittoArea)localObject1).doneInflate();
    if ((((DittoArea)localObject1).getId() != null) && (paramDittoUIEngineInflateListener != null)) {
      paramDittoUIEngineInflateListener.didInflatedArea((DittoArea)localObject1, ((DittoArea)localObject1).getId());
    }
    if (paramJSONObject.has("children"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("children");
      if (paramJSONObject != null)
      {
        localObject2 = (DittoAreaGroup)localObject1;
        int j = paramJSONObject.length();
        while (i < j)
        {
          DittoArea localDittoArea = inflateDittoArea(paramDittoHost, paramJSONObject.getJSONObject(i), paramDittoUIEngineInflateListener);
          if (localDittoArea != null) {
            ((DittoAreaGroup)localObject2).addChild(localDittoArea);
          }
          i += 1;
        }
      }
    }
    if ((paramDittoUIEngineInflateListener != null) && (localArrayMap.size() != 0)) {
      paramDittoUIEngineInflateListener.setOutKVCSet((DittoArea)localObject1, localArrayMap);
    }
    return localObject1;
  }
  
  private boolean isFirstBoot(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.subDirectoryPath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("version");
    return new File(localStringBuilder.toString(), paramString).exists() ^ true;
  }
  
  /* Error */
  private JSONObject loadJsonObject(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 371	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 165	org/json/JSONObject
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +94 -> 109
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 374	com/tencent/ditto/shell/DittoUIEngine:loadLayoutContent	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: ifnull +80 -> 109
    //   32: new 165	org/json/JSONObject
    //   35: dup
    //   36: aload 4
    //   38: invokespecial 167	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 64	com/tencent/ditto/shell/DittoUIEngine:jsonCache	Ljava/util/HashMap;
    //   46: aload_1
    //   47: aload_3
    //   48: invokevirtual 375	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_3
    //   53: areturn
    //   54: astore 4
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: astore_3
    //   61: goto +10 -> 71
    //   64: astore_3
    //   65: goto +6 -> 71
    //   68: astore_3
    //   69: aconst_null
    //   70: astore_2
    //   71: new 102	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   78: astore 4
    //   80: aload 4
    //   82: aload_1
    //   83: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 4
    //   89: ldc_w 377
    //   92: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 153
    //   98: aload 4
    //   100: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: astore_3
    //   109: aload_3
    //   110: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	DittoUIEngine
    //   0	111	1	paramString	String
    //   11	97	2	localObject1	Object
    //   13	48	3	localObject2	Object
    //   64	1	3	localException1	Exception
    //   68	36	3	localException2	Exception
    //   108	2	3	localObject3	Object
    //   23	14	4	str	String
    //   54	5	4	localException3	Exception
    //   78	21	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   42	52	54	java/lang/Exception
    //   18	25	64	java/lang/Exception
    //   32	42	64	java/lang/Exception
    //   0	12	68	java/lang/Exception
  }
  
  /* Error */
  private String loadLayoutContent(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 102	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: invokestatic 207	com/tencent/ditto/shell/DittoUIEngine:g	()Lcom/tencent/ditto/shell/DittoUIEngine;
    //   18: getfield 91	com/tencent/ditto/shell/DittoUIEngine:mContext	Landroid/content/Context;
    //   21: invokevirtual 109	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_0
    //   43: getfield 59	com/tencent/ditto/shell/DittoUIEngine:subDirectoryPath	Ljava/lang/String;
    //   46: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: getstatic 121	java/io/File:separator	Ljava/lang/String;
    //   55: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: new 111	java/io/File
    //   62: dup
    //   63: aload 4
    //   65: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aload_1
    //   69: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: astore 4
    //   74: aload 4
    //   76: invokevirtual 134	java/io/File:exists	()Z
    //   79: ifeq +135 -> 214
    //   82: aload 4
    //   84: invokevirtual 380	java/io/File:isFile	()Z
    //   87: ifeq +127 -> 214
    //   90: new 102	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   97: astore 5
    //   99: new 382	java/io/FileInputStream
    //   102: dup
    //   103: aload 4
    //   105: invokespecial 385	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: astore_1
    //   109: new 387	java/io/BufferedReader
    //   112: dup
    //   113: new 389	java/io/InputStreamReader
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 392	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   121: invokespecial 395	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore 4
    //   126: aload_1
    //   127: astore_2
    //   128: aload 4
    //   130: astore_3
    //   131: aload 4
    //   133: invokevirtual 398	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +19 -> 159
    //   143: aload_1
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: aload 5
    //   150: aload 6
    //   152: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: goto -30 -> 126
    //   159: aload_1
    //   160: astore_2
    //   161: aload 4
    //   163: astore_3
    //   164: aload 5
    //   166: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 401	java/lang/String:trim	()Ljava/lang/String;
    //   172: astore 5
    //   174: aload 4
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: aload 5
    //   181: astore_1
    //   182: goto +64 -> 246
    //   185: astore_2
    //   186: aload_1
    //   187: astore 5
    //   189: aload 4
    //   191: astore_1
    //   192: aload_2
    //   193: astore 4
    //   195: goto +98 -> 293
    //   198: astore_3
    //   199: goto +155 -> 354
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_2
    //   206: aload_1
    //   207: astore 5
    //   209: aload_2
    //   210: astore_1
    //   211: goto +82 -> 293
    //   214: aload_0
    //   215: getfield 403	com/tencent/ditto/shell/DittoUIEngine:mJsonContentMap	Ljava/util/Map;
    //   218: astore 4
    //   220: aload 4
    //   222: ifnull +20 -> 242
    //   225: aload 4
    //   227: aload_1
    //   228: invokeinterface 404 2 0
    //   233: checkcast 141	java/lang/String
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: goto +7 -> 246
    //   242: aconst_null
    //   243: astore_1
    //   244: aload_1
    //   245: astore_2
    //   246: aload_3
    //   247: ifnull +10 -> 257
    //   250: aload_3
    //   251: invokevirtual 407	java/io/BufferedReader:close	()V
    //   254: goto +3 -> 257
    //   257: aload_1
    //   258: astore_3
    //   259: aload_2
    //   260: ifnull +81 -> 341
    //   263: aload_2
    //   264: invokevirtual 410	java/io/InputStream:close	()V
    //   267: aload_1
    //   268: areturn
    //   269: ldc 153
    //   271: ldc 57
    //   273: aload_2
    //   274: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_1
    //   278: areturn
    //   279: astore_3
    //   280: aconst_null
    //   281: astore_1
    //   282: goto +72 -> 354
    //   285: astore 4
    //   287: aconst_null
    //   288: astore 5
    //   290: aload 5
    //   292: astore_1
    //   293: aload 5
    //   295: astore_2
    //   296: aload_1
    //   297: astore_3
    //   298: ldc 153
    //   300: ldc 57
    //   302: aload 4
    //   304: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_1
    //   308: ifnull +10 -> 318
    //   311: aload_1
    //   312: invokevirtual 407	java/io/BufferedReader:close	()V
    //   315: goto +3 -> 318
    //   318: aload 5
    //   320: ifnull +19 -> 339
    //   323: aload 5
    //   325: invokevirtual 410	java/io/InputStream:close	()V
    //   328: goto +11 -> 339
    //   331: ldc 153
    //   333: ldc 57
    //   335: aload_1
    //   336: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   339: aconst_null
    //   340: astore_3
    //   341: aload_3
    //   342: areturn
    //   343: astore_1
    //   344: aload_3
    //   345: astore 4
    //   347: aload_1
    //   348: astore_3
    //   349: aload_2
    //   350: astore_1
    //   351: aload 4
    //   353: astore_2
    //   354: aload_2
    //   355: ifnull +10 -> 365
    //   358: aload_2
    //   359: invokevirtual 407	java/io/BufferedReader:close	()V
    //   362: goto +3 -> 365
    //   365: aload_1
    //   366: ifnull +18 -> 384
    //   369: aload_1
    //   370: invokevirtual 410	java/io/InputStream:close	()V
    //   373: goto +11 -> 384
    //   376: ldc 153
    //   378: ldc 57
    //   380: aload_1
    //   381: invokestatic 156	com/tencent/ditto/utils/DittoLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: goto +5 -> 389
    //   387: aload_3
    //   388: athrow
    //   389: goto -2 -> 387
    //   392: astore_2
    //   393: goto -124 -> 269
    //   396: astore_1
    //   397: goto -66 -> 331
    //   400: astore_1
    //   401: goto -25 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	DittoUIEngine
    //   0	404	1	paramString	String
    //   1	178	2	str1	String
    //   185	8	2	localIOException1	IOException
    //   205	154	2	localObject1	Object
    //   392	1	2	localException	Exception
    //   3	174	3	localObject2	Object
    //   198	53	3	localObject3	Object
    //   258	1	3	str2	String
    //   279	1	3	localObject4	Object
    //   297	91	3	str3	String
    //   11	183	4	localObject5	Object
    //   202	1	4	localIOException2	IOException
    //   218	8	4	localMap	Map
    //   285	18	4	localIOException3	IOException
    //   345	7	4	str4	String
    //   97	227	5	localObject6	Object
    //   136	15	6	str5	String
    // Exception table:
    //   from	to	target	type
    //   131	138	185	java/io/IOException
    //   148	156	185	java/io/IOException
    //   164	174	185	java/io/IOException
    //   109	126	198	finally
    //   109	126	202	java/io/IOException
    //   4	109	279	finally
    //   214	220	279	finally
    //   225	237	279	finally
    //   4	109	285	java/io/IOException
    //   214	220	285	java/io/IOException
    //   225	237	285	java/io/IOException
    //   131	138	343	finally
    //   148	156	343	finally
    //   164	174	343	finally
    //   298	307	343	finally
    //   250	254	392	java/lang/Exception
    //   263	267	392	java/lang/Exception
    //   311	315	396	java/lang/Exception
    //   323	328	396	java/lang/Exception
    //   358	362	400	java/lang/Exception
    //   369	373	400	java/lang/Exception
  }
  
  private void modifyInflatedArea(DittoArea paramDittoArea, DittoHost paramDittoHost, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    paramDittoArea.setHost(paramDittoHost);
    if (paramDittoUIEngineInflateListener != null) {
      paramDittoUIEngineInflateListener.didInflatedArea(paramDittoArea, paramDittoArea.getId());
    }
    if ((paramDittoArea instanceof DittoAreaGroup))
    {
      paramDittoArea = (DittoAreaGroup)paramDittoArea;
      int j = paramDittoArea.getChildCount();
      int i = 0;
      while (i < j)
      {
        modifyInflatedArea(paramDittoArea.getChildAt(i), paramDittoHost, paramDittoUIEngineInflateListener);
        i += 1;
      }
    }
  }
  
  private void preloadJsonObjects()
  {
    loadJsonObject("qzone_canvas_ui_titleview.json");
    loadJsonObject("qzone_canvas_ui_feedcontent.json");
    loadJsonObject("qzone_canvas_ui_birthday_card.json");
  }
  
  public static void setOuterGlobalData(DittoValue.GLOBAL paramGLOBAL)
  {
    outerGlobalData = paramGLOBAL;
  }
  
  public void addResourceIdCache(String paramString, int paramInt)
  {
    this.resourceIdCache.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void clearAllAreaCache()
  {
    new DittoArea(new DittoUIEngine.FakeHost(this), null).clearAllAreaCache();
  }
  
  public void clearCache()
  {
    clearCanvasUIFileInfo();
    clearRichTextAreaCache();
  }
  
  public void clearRichTextAreaCache()
  {
    new DittoArea(new DittoUIEngine.FakeHost(this), null).clearRichTextAreaCache();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public float getDensity()
  {
    return DENSITY;
  }
  
  public DittoResources getDittoResources()
  {
    return this.mDittoResources;
  }
  
  public Map<String, String> getDittoUIFileInfo()
  {
    try
    {
      if (this.fileMd5 == null) {
        this.fileMd5 = generateFileMd5();
      }
      return this.fileMd5;
    }
    finally {}
  }
  
  public String getFileMd5(String paramString)
  {
    getDittoUIFileInfo();
    synchronized (this.fileMd5)
    {
      if (this.fileMd5.containsKey(paramString))
      {
        paramString = (String)this.fileMd5.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  public DittoUIEngine.IReporter getReporter()
  {
    return this.mReporter;
  }
  
  public int getResourceId(String paramString)
  {
    if (this.resourceIdCache.containsKey(paramString)) {
      return ((Integer)this.resourceIdCache.get(paramString)).intValue();
    }
    if (this.mRClass != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      String[] arrayOfString = paramString.split("/");
      if (arrayOfString.length != 2)
      {
        DittoLog.e(String.format("reference string:%s of incorrect format", new Object[] { paramString }));
        return 0;
      }
      try
      {
        localObject = arrayOfString[0].substring(1, arrayOfString[0].length());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mRClass.getName());
        localStringBuilder.append("$");
        localStringBuilder.append((String)localObject);
        int i = Class.forName(localStringBuilder.toString()).getDeclaredField(arrayOfString[1]).getInt(null);
        this.resourceIdCache.put(paramString, Integer.valueOf(i));
        return i;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get resource id err:");
        ((StringBuilder)localObject).append(localException.getMessage());
        ((StringBuilder)localObject).append("  idString:");
        ((StringBuilder)localObject).append(paramString);
        DittoLog.e("DITTO_UI", ((StringBuilder)localObject).toString(), localException);
      }
    }
    return 0;
  }
  
  public DittoArea inflateDittoArea(DittoHost paramDittoHost, String paramString, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener)
  {
    return inflateDittoArea(paramDittoHost, paramString, paramDittoUIEngineInflateListener, false);
  }
  
  public DittoArea inflateDittoArea(DittoHost paramDittoHost, String paramString, DittoUIEngine.DittoUIEngineInflateListener paramDittoUIEngineInflateListener, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      synchronized (this.inflatedAreaBuffer)
      {
        if (!this.inflatedAreaBuffer.containsKey(paramString)) {
          break label304;
        }
        List localList = (List)this.inflatedAreaBuffer.get(paramString);
        if (localList.size() == 0) {
          break label304;
        }
        localDittoArea = (DittoArea)localList.get(0);
        localList.remove(0);
        if (localList.size() == 0) {
          this.inflatedAreaBuffer.remove(paramString);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("area buffer used:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("buffer remained:");
        localStringBuilder.append(localList.size());
        DittoLog.i(localStringBuilder.toString());
      }
      DittoArea localDittoArea = null;
      if (localDittoArea != null)
      {
        modifyInflatedArea(localDittoArea, paramDittoHost, paramDittoUIEngineInflateListener);
        return localDittoArea;
      }
      if (localDittoArea == null)
      {
        if (paramBoolean) {}
        try
        {
          paramString = new JSONObject(paramString);
          break label212;
          paramString = loadJsonObject(paramString);
          label212:
          paramDittoHost = inflateDittoArea(paramDittoHost, paramString, paramDittoUIEngineInflateListener);
          return paramDittoHost;
        }
        catch (Exception paramDittoHost)
        {
          paramString = new StringBuilder();
          paramString.append("inflate err:");
          paramString.append(paramDittoHost.getMessage());
          DittoLog.e("DITTO_UI", paramString.toString(), paramDittoHost);
          return null;
        }
        catch (InvocationTargetException paramDittoHost)
        {
          paramString = new StringBuilder();
          paramString.append("inflate err:");
          paramString.append(paramDittoHost.getTargetException().getMessage());
          DittoLog.e("DITTO_UI", paramString.toString(), paramDittoHost.getTargetException());
        }
      }
      return null;
      label304:
      localDittoArea = null;
    }
  }
  
  public View inflateView(Context paramContext, String paramString, ViewGroup paramViewGroup)
  {
    try
    {
      paramContext = inflateView(paramContext, loadJsonObject(paramString), paramViewGroup);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("inflate err:");
      paramString.append(paramContext.getMessage());
      DittoLog.e("DITTO_UI", paramString.toString(), paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("inflate err:");
      paramString.append(paramContext.getTargetException().getMessage());
      DittoLog.e("DITTO_UI", paramString.toString(), paramContext.getTargetException());
    }
    return null;
  }
  
  public View inflateView(Context paramContext, JSONObject paramJSONObject, ViewGroup paramViewGroup)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = paramJSONObject.getString("View");
    boolean bool = "merge".equals(localObject1);
    int m = 0;
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    int j;
    if (!bool) {
      if ("include".equals(localObject1))
      {
        localObject2 = LayoutAttrSet.createFrom(paramJSONObject.getJSONObject("shell"));
        localObject1 = ((LayoutAttrSet)localObject2).getAttr("layout", "");
        localObject2 = ((LayoutAttrSet)localObject2).getAttr("id", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = getResourceId((String)localObject1);
          LayoutInflater.from(paramContext).inflate(i, paramViewGroup);
          if (paramViewGroup != null)
          {
            localObject1 = paramViewGroup.getChildAt(paramViewGroup.getChildCount() - 1);
            paramViewGroup = (ViewGroup)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label638;
            }
            paramViewGroup = (ViewGroup)localObject1;
            if (localObject1 == null) {
              break label638;
            }
            ((View)localObject1).setId(getResourceId((String)localObject2));
            paramViewGroup = (ViewGroup)localObject1;
            break label638;
          }
        }
        paramViewGroup = null;
      }
      else
      {
        paramViewGroup = DittoAreaEnv.findAreaClass((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("inflateView name:");
        ((StringBuilder)localObject2).append((String)localObject1);
        DittoLog.i("DITTO_UI", ((StringBuilder)localObject2).toString());
        localObject2 = LayoutAttrSet.createFrom(paramJSONObject.getJSONObject("shell"));
        paramViewGroup = paramViewGroup.getConstructor(new Class[] { Context.class, AttributeSet.class }).newInstance(new Object[] { paramContext, null });
        if ((paramViewGroup instanceof ViewStub))
        {
          localObject1 = (View)paramViewGroup;
          paramViewGroup = (ViewStub)paramViewGroup;
          localObject3 = ((LayoutAttrSet)localObject2).getAttr("id", "");
          localObject4 = ((LayoutAttrSet)localObject2).getAttr("inflatedId", "");
          String str = ((LayoutAttrSet)localObject2).getAttr("layout", "");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            i = getResourceId((String)localObject3);
          } else {
            i = 0;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject4)) {
            j = getResourceId((String)localObject4);
          } else {
            j = 0;
          }
          int k;
          if (!TextUtils.isEmpty(str)) {
            k = getResourceId(str);
          } else {
            k = 0;
          }
          paramViewGroup.setId(i);
          paramViewGroup.setInflatedId(j);
          paramViewGroup.setLayoutResource(k);
        }
        else
        {
          paramViewGroup = (View)paramViewGroup;
          localObject1 = ((LayoutAttrSet)localObject2).id;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramViewGroup.setId(getResourceId((String)localObject1));
          }
          localObject1 = paramViewGroup;
          if (((LayoutAttrSet)localObject2).mAttrs.containsKey("visibility"))
          {
            localObject3 = ((LayoutAttrSet)localObject2).getAttr("visibility", "visible");
            if (TextUtils.equals("visible", (CharSequence)localObject3))
            {
              paramViewGroup.setVisibility(0);
              localObject1 = paramViewGroup;
            }
            else if (TextUtils.equals("gone", (CharSequence)localObject3))
            {
              paramViewGroup.setVisibility(8);
              localObject1 = paramViewGroup;
            }
            else
            {
              localObject1 = paramViewGroup;
              if (TextUtils.equals("invisible", (CharSequence)localObject3))
              {
                paramViewGroup.setVisibility(4);
                localObject1 = paramViewGroup;
              }
            }
          }
        }
        paramViewGroup = new ViewGroup.MarginLayoutParams(((LayoutAttrSet)localObject2).width, ((LayoutAttrSet)localObject2).height);
        paramViewGroup.leftMargin = ((LayoutAttrSet)localObject2).leftMargin;
        paramViewGroup.topMargin = ((LayoutAttrSet)localObject2).topMargin;
        paramViewGroup.rightMargin = ((LayoutAttrSet)localObject2).rightMargin;
        paramViewGroup.bottomMargin = ((LayoutAttrSet)localObject2).bottomMargin;
        ((View)localObject1).setLayoutParams(paramViewGroup);
        ((View)localObject1).setPadding(((LayoutAttrSet)localObject2).leftPadding, ((LayoutAttrSet)localObject2).topPadding, ((LayoutAttrSet)localObject2).rightPadding, ((LayoutAttrSet)localObject2).bottomPadding);
        paramViewGroup = (ViewGroup)localObject1;
        if ((localObject1 instanceof LinearLayout))
        {
          ((LinearLayout)localObject1).setOrientation(((LayoutAttrSet)localObject2).orientation);
          paramViewGroup = (ViewGroup)localObject1;
        }
      }
    }
    label638:
    if ((paramJSONObject.has("children")) && ((paramViewGroup instanceof ViewGroup)))
    {
      localObject1 = paramJSONObject.getJSONArray("children");
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)paramViewGroup;
        j = ((JSONArray)localObject1).length();
        i = m;
        while (i < j)
        {
          localObject3 = inflateView(paramContext, ((JSONArray)localObject1).getJSONObject(i), (ViewGroup)localObject2);
          if ((localObject3 != null) && (((View)localObject3).getParent() == null))
          {
            localObject4 = (ViewGroup.MarginLayoutParams)((View)localObject3).getLayoutParams();
            if (localObject4 != null)
            {
              if ((localObject2 instanceof LinearLayout))
              {
                paramJSONObject = new LinearLayout.LayoutParams(((ViewGroup.MarginLayoutParams)localObject4).width, ((ViewGroup.MarginLayoutParams)localObject4).height);
                paramJSONObject.leftMargin = ((ViewGroup.MarginLayoutParams)localObject4).leftMargin;
                paramJSONObject.topMargin = ((ViewGroup.MarginLayoutParams)localObject4).topMargin;
                paramJSONObject.rightMargin = ((ViewGroup.MarginLayoutParams)localObject4).rightMargin;
                paramJSONObject.bottomMargin = ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin;
              }
              else if ((localObject2 instanceof RelativeLayout))
              {
                paramJSONObject = new RelativeLayout.LayoutParams(((ViewGroup.MarginLayoutParams)localObject4).width, ((ViewGroup.MarginLayoutParams)localObject4).height);
                paramJSONObject.leftMargin = ((ViewGroup.MarginLayoutParams)localObject4).leftMargin;
                paramJSONObject.topMargin = ((ViewGroup.MarginLayoutParams)localObject4).topMargin;
                paramJSONObject.rightMargin = ((ViewGroup.MarginLayoutParams)localObject4).rightMargin;
                paramJSONObject.bottomMargin = ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin;
              }
              else
              {
                paramJSONObject = null;
              }
              if (paramJSONObject != null) {
                ((ViewGroup)localObject2).addView((View)localObject3, paramJSONObject);
              }
            }
            else
            {
              ((ViewGroup)localObject2).addView((View)localObject3);
            }
          }
          i += 1;
        }
      }
    }
    return paramViewGroup;
  }
  
  public void init(Context paramContext, Log paramLog)
  {
    this.mContext = paramContext;
    DittoLog.setLog(paramLog);
    paramContext = this.mContext.getResources().getDisplayMetrics();
    DENSITY = paramContext.density;
    SCREEN_WIDTH = paramContext.widthPixels;
    SCREEN_HEIGHT = paramContext.heightPixels;
  }
  
  public void initExtra(DittoResources paramDittoResources, DittoUIEngine.IReporter paramIReporter, String paramString1, String paramString2, Class paramClass, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    Context localContext = this.mContext;
    if (localContext == null)
    {
      DittoLog.e("DittoUIEngine", "initExtra error! context is null!");
      return;
    }
    this.mDittoResources = paramDittoResources;
    this.mReporter = paramIReporter;
    this.subDirectoryPath = paramString2;
    if ((!TextUtils.isEmpty(paramString1)) && (isFirstBoot(paramString1)))
    {
      paramDittoResources = new StringBuilder();
      paramDittoResources.append(localContext.getFilesDir().getAbsolutePath());
      paramDittoResources.append(File.separator);
      paramDittoResources.append(paramString2);
      paramDittoResources.append(File.separator);
      paramDittoResources = paramDittoResources.toString();
      if (paramDittoResources != null) {
        FileUtils.deleteFile(new File(paramDittoResources));
      }
      paramIReporter = new StringBuilder();
      paramIReporter.append("Clean the storage field when updated:");
      paramIReporter.append(paramDittoResources);
      DittoLog.i(paramIReporter.toString());
      createVersionFile(paramString1);
    }
    this.mRClass = paramClass;
    this.mJsonContentMap = paramMap1;
    this.mJsonMd5Map = paramMap2;
    preloadJsonObjects();
  }
  
  public void updateLayoutFile(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      try
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append(g().mContext.getFilesDir().getAbsolutePath());
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append(this.subDirectoryPath);
        ((StringBuilder)???).append(File.separator);
        File localFile = new File(((StringBuilder)???).toString());
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        ??? = null;
        Iterator localIterator = paramMap.entrySet().iterator();
        for (paramMap = (Map<String, String>)???; localIterator.hasNext(); paramMap = (Map<String, String>)???) {
          for (;;)
          {
            ??? = (Map.Entry)localIterator.next();
            String str1 = (String)((Map.Entry)???).getKey();
            String str2 = (String)((Map.Entry)???).getValue();
            try
            {
              if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
                break;
              }
              ??? = generateBuffer(str1, str2);
              synchronized (this.jsonCache)
              {
                this.jsonCache.put(str1, ???);
                ??? = new File(localFile.getPath(), str1);
                if (((File)???).exists()) {
                  ((File)???).delete();
                }
                ((File)???).createNewFile();
                ??? = new FileOutputStream((File)???);
                try
                {
                  ((FileOutputStream)???).write(str2.getBytes());
                  ((FileOutputStream)???).close();
                  paramMap = FileUtils.getMd5ByFile((File)???);
                  synchronized (this.fileMd5)
                  {
                    this.fileMd5.put(str1, paramMap);
                    ??? = new StringBuilder();
                    ((StringBuilder)???).append("update Layout File:");
                    ((StringBuilder)???).append(str1);
                    ((StringBuilder)???).append(" md5:");
                    ((StringBuilder)???).append(paramMap);
                    paramMap = ((StringBuilder)???).toString();
                    DittoLog.i(paramMap);
                    getReporter().haboReport("tencent.ditto.updateLayoutFile", 0, paramMap, 1);
                  }
                  localObject3 = finally;
                }
                catch (Exception localException2)
                {
                  paramMap = (Map<String, String>)???;
                }
              }
              try
              {
                int j;
                int i;
                paramMap.close();
                ??? = paramMap;
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  Map<String, String> localMap = paramMap;
                }
              }
            }
            catch (Exception localException3)
            {
              j = -1;
              if ((localException3 instanceof JSONException))
              {
                i = -61442;
              }
              else
              {
                i = j;
                if (Build.VERSION.SDK_INT >= 19)
                {
                  i = j;
                  if ((localException3 instanceof ReflectiveOperationException)) {
                    i = -61441;
                  }
                }
              }
              ??? = new StringBuilder();
              ((StringBuilder)???).append("update file error! ");
              ((StringBuilder)???).append(str1);
              ((StringBuilder)???).append(" -- ");
              ((StringBuilder)???).append(str2);
              ((StringBuilder)???).append("Exception:");
              ((StringBuilder)???).append(localException3.getMessage());
              DittoLog.e("DITTO_UI", ((StringBuilder)???).toString(), localException3);
              getReporter().haboReport("tencent.ditto.updateLayoutFile", i, DittoLog.getTraceString(localException3), 1);
              ??? = paramMap;
              if (paramMap == null) {}
            }
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        DittoLog.e("DITTO_UI", "updateLayoutFile error!", paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine
 * JD-Core Version:    0.7.0.1
 */