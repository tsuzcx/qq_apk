package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.observer.AccountObserver;

public class QuickLoginActivity
  extends BaseActivity
{
  ListView jdField_a_of_type_AndroidWidgetListView;
  SimpleAdapter jdField_a_of_type_AndroidWidgetSimpleAdapter;
  ArrayList<HashMap<String, String>> jdField_a_of_type_JavaUtilArrayList;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new QuickLoginActivity.2(this);
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131374753));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    c();
    b();
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap1 = (HashMap)localIterator.next();
      HashMap localHashMap2 = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localHashMap1.get("qq"));
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localHashMap1.get("password"));
      localHashMap2.put("text", localStringBuilder.toString());
      localArrayList.add(localHashMap2);
    }
    this.jdField_a_of_type_AndroidWidgetSimpleAdapter = new SimpleAdapter(this, localArrayList, 2131558459, new String[] { "text" }, new int[] { 2131369114 });
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetSimpleAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new QuickLoginActivity.1(this));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 62	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 121	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   12: invokevirtual 126	java/io/File:getPath	()Ljava/lang/String;
    //   15: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_1
    //   20: ldc 128
    //   22: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: new 123	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 134	java/io/File:exists	()Z
    //   42: ifeq +171 -> 213
    //   45: new 136	java/io/BufferedReader
    //   48: dup
    //   49: new 138	java/io/InputStreamReader
    //   52: dup
    //   53: new 140	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   64: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +79 -> 155
    //   79: aload_2
    //   80: astore_1
    //   81: aload_3
    //   82: ldc 77
    //   84: invokevirtual 156	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   87: astore_3
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: arraylength
    //   92: iconst_2
    //   93: if_icmpne +52 -> 145
    //   96: aload_2
    //   97: astore_1
    //   98: new 59	java/util/HashMap
    //   101: dup
    //   102: invokespecial 60	java/util/HashMap:<init>	()V
    //   105: astore 4
    //   107: aload_2
    //   108: astore_1
    //   109: aload 4
    //   111: ldc 65
    //   113: aload_3
    //   114: iconst_0
    //   115: aaload
    //   116: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_2
    //   121: astore_1
    //   122: aload 4
    //   124: ldc 79
    //   126: aload_3
    //   127: iconst_1
    //   128: aaload
    //   129: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_2
    //   134: astore_1
    //   135: aload_0
    //   136: getfield 37	com/tencent/mobileqq/activity/QuickLoginActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   139: aload 4
    //   141: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: aload_2
    //   146: astore_1
    //   147: aload_2
    //   148: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   151: astore_3
    //   152: goto -77 -> 75
    //   155: aload_2
    //   156: invokevirtual 159	java/io/BufferedReader:close	()V
    //   159: return
    //   160: astore_3
    //   161: goto +12 -> 173
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: goto +28 -> 195
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_2
    //   173: aload_2
    //   174: astore_1
    //   175: aload_3
    //   176: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   179: aload_2
    //   180: ifnull +33 -> 213
    //   183: aload_2
    //   184: invokevirtual 159	java/io/BufferedReader:close	()V
    //   187: return
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore_2
    //   195: aload_1
    //   196: ifnull +15 -> 211
    //   199: aload_1
    //   200: invokevirtual 159	java/io/BufferedReader:close	()V
    //   203: goto +8 -> 211
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   211: aload_2
    //   212: athrow
    //   213: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	QuickLoginActivity
    //   7	168	1	localObject1	java.lang.Object
    //   188	12	1	localIOException1	java.io.IOException
    //   206	2	1	localIOException2	java.io.IOException
    //   67	89	2	localBufferedReader	java.io.BufferedReader
    //   164	1	2	localObject2	java.lang.Object
    //   172	12	2	localObject3	java.lang.Object
    //   194	18	2	localObject4	java.lang.Object
    //   74	78	3	localObject5	java.lang.Object
    //   160	1	3	localIOException3	java.io.IOException
    //   170	6	3	localIOException4	java.io.IOException
    //   105	35	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   70	75	160	java/io/IOException
    //   81	88	160	java/io/IOException
    //   90	96	160	java/io/IOException
    //   98	107	160	java/io/IOException
    //   109	120	160	java/io/IOException
    //   122	133	160	java/io/IOException
    //   135	145	160	java/io/IOException
    //   147	152	160	java/io/IOException
    //   45	68	164	finally
    //   45	68	170	java/io/IOException
    //   155	159	188	java/io/IOException
    //   183	187	188	java/io/IOException
    //   70	75	194	finally
    //   81	88	194	finally
    //   90	96	194	finally
    //   98	107	194	finally
    //   109	120	194	finally
    //   122	133	194	finally
    //   135	145	194	finally
    //   147	152	194	finally
    //   175	179	194	finally
    //   199	203	206	java/io/IOException
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558458);
    a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */