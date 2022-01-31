package com.tencent.mobileqq.activity;

import adtl;
import adtm;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.observer.AccountObserver;

public class QuickLoginActivity
  extends BaseActivity
{
  ListView jdField_a_of_type_AndroidWidgetListView;
  SimpleAdapter jdField_a_of_type_AndroidWidgetSimpleAdapter;
  public ArrayList<HashMap<String, String>> a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adtm(this);
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131373996));
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
      localHashMap2.put("text", (String)localHashMap1.get("qq") + " " + (String)localHashMap1.get("password"));
      localArrayList.add(localHashMap2);
    }
    this.jdField_a_of_type_AndroidWidgetSimpleAdapter = new SimpleAdapter(this, localArrayList, 2131558427, new String[] { "text" }, new int[] { 2131368545 });
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetSimpleAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new adtl(this));
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 117	java/io/File
    //   3: dup
    //   4: new 64	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 123	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   14: invokevirtual 126	java/io/File:getPath	()Ljava/lang/String;
    //   17: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 128
    //   22: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 134	java/io/File:exists	()Z
    //   36: ifeq +121 -> 157
    //   39: new 136	java/io/BufferedReader
    //   42: dup
    //   43: new 138	java/io/InputStreamReader
    //   46: dup
    //   47: new 140	java/io/FileInputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   58: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore_2
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +79 -> 149
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: ldc 79
    //   78: invokevirtual 156	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: arraylength
    //   86: iconst_2
    //   87: if_icmpne +52 -> 139
    //   90: aload_2
    //   91: astore_1
    //   92: new 59	java/util/HashMap
    //   95: dup
    //   96: invokespecial 60	java/util/HashMap:<init>	()V
    //   99: astore 4
    //   101: aload_2
    //   102: astore_1
    //   103: aload 4
    //   105: ldc 67
    //   107: aload_3
    //   108: iconst_0
    //   109: aaload
    //   110: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload_2
    //   115: astore_1
    //   116: aload 4
    //   118: ldc 81
    //   120: aload_3
    //   121: iconst_1
    //   122: aaload
    //   123: invokevirtual 89	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: pop
    //   127: aload_2
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 37	com/tencent/mobileqq/activity/QuickLoginActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   133: aload 4
    //   135: invokevirtual 93	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   145: astore_3
    //   146: goto -77 -> 69
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 159	java/io/BufferedReader:close	()V
    //   157: return
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   163: return
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   173: aload_2
    //   174: ifnull -17 -> 157
    //   177: aload_2
    //   178: invokevirtual 159	java/io/BufferedReader:close	()V
    //   181: return
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 159	java/io/BufferedReader:close	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_1
    //   202: aload_1
    //   203: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   206: goto -7 -> 199
    //   209: astore_2
    //   210: goto -19 -> 191
    //   213: astore_3
    //   214: goto -47 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	QuickLoginActivity
    //   31	110	1	localObject1	java.lang.Object
    //   158	2	1	localIOException1	java.io.IOException
    //   168	1	1	localObject2	java.lang.Object
    //   182	2	1	localIOException2	java.io.IOException
    //   190	6	1	localObject3	java.lang.Object
    //   201	2	1	localIOException3	java.io.IOException
    //   61	117	2	localBufferedReader	java.io.BufferedReader
    //   188	12	2	localObject4	java.lang.Object
    //   209	1	2	localObject5	java.lang.Object
    //   68	78	3	localObject6	java.lang.Object
    //   164	6	3	localIOException4	java.io.IOException
    //   213	1	3	localIOException5	java.io.IOException
    //   99	35	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   153	157	158	java/io/IOException
    //   39	62	164	java/io/IOException
    //   177	181	182	java/io/IOException
    //   39	62	188	finally
    //   195	199	201	java/io/IOException
    //   64	69	209	finally
    //   75	82	209	finally
    //   84	90	209	finally
    //   92	101	209	finally
    //   103	114	209	finally
    //   116	127	209	finally
    //   129	139	209	finally
    //   141	146	209	finally
    //   169	173	209	finally
    //   64	69	213	java/io/IOException
    //   75	82	213	java/io/IOException
    //   84	90	213	java/io/IOException
    //   92	101	213	java/io/IOException
    //   103	114	213	java/io/IOException
    //   116	127	213	java/io/IOException
    //   129	139	213	java/io/IOException
    //   141	146	213	java/io/IOException
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558426);
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */