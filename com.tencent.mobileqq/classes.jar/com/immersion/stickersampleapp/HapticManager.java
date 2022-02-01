package com.immersion.stickersampleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.immersion.touchsensesdk.HapticMediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class HapticManager
{
  private static HapticManager jdField_a_of_type_ComImmersionStickersampleappHapticManager = new HapticManager(BaseApplicationImpl.sApplication);
  private static final String jdField_a_of_type_JavaLangString = PokeItemHelper.a() + "poke/immersion_source/libTouchSenseSDK.so";
  private Context jdField_a_of_type_AndroidContentContext;
  private HapticManager.ClockTask jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask = new HapticManager.ClockTask(this);
  private HapticManager.DisposeTask jdField_a_of_type_ComImmersionStickersampleappHapticManager$DisposeTask = new HapticManager.DisposeTask(this);
  private HapticManager.InitHMPRunnable jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable = null;
  private ImmerIConnectionProxy jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy;
  private HapticMediaPlayer jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  private final List<HapticManager.HapticEffect> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  private HapticManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy = new ImmerIConnectionProxy();
    this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable = new HapticManager.InitHMPRunnable(this);
  }
  
  private HapticManager.HapticEffect a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        HapticManager.HapticEffect localHapticEffect = (HapticManager.HapticEffect)localIterator.next();
        if (HapticManager.HapticEffect.a(localHapticEffect).equals(paramString)) {
          return localHapticEffect;
        }
      }
      return null;
    }
  }
  
  public static HapticManager a()
  {
    try
    {
      HapticManager localHapticManager = jdField_a_of_type_ComImmersionStickersampleappHapticManager;
      return localHapticManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private String a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore_3
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore 12
    //   30: aload_0
    //   31: getfield 83	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   34: invokevirtual 134	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   37: iload_1
    //   38: invokevirtual 140	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   41: astore 11
    //   43: aload 11
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload 10
    //   53: astore_3
    //   54: aload_0
    //   55: getfield 83	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   58: new 24	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   65: aload_2
    //   66: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 142
    //   71: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: iconst_0
    //   78: invokevirtual 146	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   81: astore 6
    //   83: aload 5
    //   85: astore 4
    //   87: aload 6
    //   89: astore_3
    //   90: aload 6
    //   92: astore 7
    //   94: aload 6
    //   96: astore 8
    //   98: aload 6
    //   100: astore 9
    //   102: aload 5
    //   104: invokevirtual 152	java/io/InputStream:available	()I
    //   107: istore_1
    //   108: iload_1
    //   109: ifle +65 -> 174
    //   112: aload 5
    //   114: astore 4
    //   116: aload 6
    //   118: astore_3
    //   119: aload 6
    //   121: astore 7
    //   123: aload 6
    //   125: astore 8
    //   127: aload 6
    //   129: astore 9
    //   131: aload 6
    //   133: aload 12
    //   135: iconst_0
    //   136: aload 5
    //   138: aload 12
    //   140: invokevirtual 156	java/io/InputStream:read	([B)I
    //   143: invokevirtual 162	java/io/FileOutputStream:write	([BII)V
    //   146: aload 5
    //   148: astore 4
    //   150: aload 6
    //   152: astore_3
    //   153: aload 6
    //   155: astore 7
    //   157: aload 6
    //   159: astore 8
    //   161: aload 6
    //   163: astore 9
    //   165: aload 5
    //   167: invokevirtual 152	java/io/InputStream:available	()I
    //   170: istore_1
    //   171: goto -63 -> 108
    //   174: aload 5
    //   176: astore 4
    //   178: aload 6
    //   180: astore_3
    //   181: aload 6
    //   183: astore 7
    //   185: aload 6
    //   187: astore 8
    //   189: aload 6
    //   191: astore 9
    //   193: aload 6
    //   195: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   198: aload 5
    //   200: astore 4
    //   202: aload 6
    //   204: astore_3
    //   205: aload 6
    //   207: astore 7
    //   209: aload 6
    //   211: astore 8
    //   213: aload 6
    //   215: astore 9
    //   217: aload 5
    //   219: invokevirtual 166	java/io/InputStream:close	()V
    //   222: aload 6
    //   224: ifnull +8 -> 232
    //   227: aload 6
    //   229: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   232: aload 5
    //   234: ifnull +8 -> 242
    //   237: aload 5
    //   239: invokevirtual 166	java/io/InputStream:close	()V
    //   242: aload_0
    //   243: getfield 83	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   246: invokevirtual 170	android/content/Context:getFilesDir	()Ljava/io/File;
    //   249: astore_3
    //   250: new 24	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   257: aload_3
    //   258: invokevirtual 175	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   261: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: getstatic 178	java/io/File:separator	Ljava/lang/String;
    //   267: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_2
    //   271: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 142
    //   276: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: areturn
    //   283: astore_3
    //   284: aload_3
    //   285: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   288: goto -56 -> 232
    //   291: astore_3
    //   292: aload_3
    //   293: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   296: goto -54 -> 242
    //   299: astore 6
    //   301: aconst_null
    //   302: astore 5
    //   304: aload_3
    //   305: astore 9
    //   307: aload 5
    //   309: astore 4
    //   311: aload 9
    //   313: astore_3
    //   314: ldc 183
    //   316: iconst_2
    //   317: aload 6
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   326: aload 9
    //   328: ifnull +8 -> 336
    //   331: aload 9
    //   333: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   336: aload 5
    //   338: ifnull -96 -> 242
    //   341: aload 5
    //   343: invokevirtual 166	java/io/InputStream:close	()V
    //   346: goto -104 -> 242
    //   349: astore_3
    //   350: aload_3
    //   351: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   354: goto -112 -> 242
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   362: goto -26 -> 336
    //   365: astore 6
    //   367: aconst_null
    //   368: astore 5
    //   370: aload 4
    //   372: astore 8
    //   374: aload 5
    //   376: astore 4
    //   378: aload 8
    //   380: astore_3
    //   381: ldc 183
    //   383: iconst_2
    //   384: aload 6
    //   386: iconst_0
    //   387: anewarray 4	java/lang/Object
    //   390: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   393: aload 8
    //   395: ifnull +8 -> 403
    //   398: aload 8
    //   400: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   403: aload 5
    //   405: ifnull -163 -> 242
    //   408: aload 5
    //   410: invokevirtual 166	java/io/InputStream:close	()V
    //   413: goto -171 -> 242
    //   416: astore_3
    //   417: aload_3
    //   418: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   421: goto -179 -> 242
    //   424: astore_3
    //   425: aload_3
    //   426: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   429: goto -26 -> 403
    //   432: astore 6
    //   434: aconst_null
    //   435: astore_3
    //   436: aload 5
    //   438: astore 7
    //   440: aload_3
    //   441: astore 5
    //   443: aload 5
    //   445: astore 4
    //   447: aload 7
    //   449: astore_3
    //   450: ldc 183
    //   452: iconst_2
    //   453: aload 6
    //   455: iconst_0
    //   456: anewarray 4	java/lang/Object
    //   459: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   462: aload 7
    //   464: ifnull +8 -> 472
    //   467: aload 7
    //   469: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   472: aload 5
    //   474: ifnull -232 -> 242
    //   477: aload 5
    //   479: invokevirtual 166	java/io/InputStream:close	()V
    //   482: goto -240 -> 242
    //   485: astore_3
    //   486: aload_3
    //   487: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   490: goto -248 -> 242
    //   493: astore_3
    //   494: aload_3
    //   495: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   498: goto -26 -> 472
    //   501: astore_2
    //   502: aconst_null
    //   503: astore 4
    //   505: aload 6
    //   507: astore_3
    //   508: aload_3
    //   509: ifnull +7 -> 516
    //   512: aload_3
    //   513: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   516: aload 4
    //   518: ifnull +8 -> 526
    //   521: aload 4
    //   523: invokevirtual 166	java/io/InputStream:close	()V
    //   526: aload_2
    //   527: athrow
    //   528: astore_3
    //   529: aload_3
    //   530: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   533: goto -17 -> 516
    //   536: astore_3
    //   537: aload_3
    //   538: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   541: goto -15 -> 526
    //   544: astore_2
    //   545: goto -37 -> 508
    //   548: astore 6
    //   550: goto -107 -> 443
    //   553: astore 6
    //   555: goto -181 -> 374
    //   558: astore 6
    //   560: goto -253 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	HapticManager
    //   0	563	1	paramInt	int
    //   0	563	2	paramString	String
    //   22	236	3	localObject1	Object
    //   283	2	3	localIOException1	IOException
    //   291	14	3	localIOException2	IOException
    //   313	1	3	localObject2	Object
    //   349	2	3	localIOException3	IOException
    //   357	2	3	localIOException4	IOException
    //   380	1	3	localObject3	Object
    //   416	2	3	localIOException5	IOException
    //   424	2	3	localIOException6	IOException
    //   435	15	3	localObject4	Object
    //   485	2	3	localIOException7	IOException
    //   493	2	3	localIOException8	IOException
    //   507	6	3	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   528	2	3	localIOException9	IOException
    //   536	2	3	localIOException10	IOException
    //   1	521	4	localObject5	Object
    //   4	474	5	localObject6	Object
    //   7	221	6	localFileOutputStream	java.io.FileOutputStream
    //   299	19	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   365	20	6	localIOException11	IOException
    //   432	74	6	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   548	1	6	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
    //   553	1	6	localIOException12	IOException
    //   558	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   13	455	7	localObject7	Object
    //   16	383	8	localObject8	Object
    //   19	313	9	localObject9	Object
    //   10	42	10	localObject10	Object
    //   41	3	11	localInputStream	java.io.InputStream
    //   28	111	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   227	232	283	java/io/IOException
    //   237	242	291	java/io/IOException
    //   30	43	299	java/io/FileNotFoundException
    //   341	346	349	java/io/IOException
    //   331	336	357	java/io/IOException
    //   30	43	365	java/io/IOException
    //   408	413	416	java/io/IOException
    //   398	403	424	java/io/IOException
    //   30	43	432	java/lang/ArrayIndexOutOfBoundsException
    //   477	482	485	java/io/IOException
    //   467	472	493	java/io/IOException
    //   30	43	501	finally
    //   512	516	528	java/io/IOException
    //   521	526	536	java/io/IOException
    //   54	83	544	finally
    //   102	108	544	finally
    //   131	146	544	finally
    //   165	171	544	finally
    //   193	198	544	finally
    //   217	222	544	finally
    //   314	326	544	finally
    //   381	393	544	finally
    //   450	462	544	finally
    //   54	83	548	java/lang/ArrayIndexOutOfBoundsException
    //   102	108	548	java/lang/ArrayIndexOutOfBoundsException
    //   131	146	548	java/lang/ArrayIndexOutOfBoundsException
    //   165	171	548	java/lang/ArrayIndexOutOfBoundsException
    //   193	198	548	java/lang/ArrayIndexOutOfBoundsException
    //   217	222	548	java/lang/ArrayIndexOutOfBoundsException
    //   54	83	553	java/io/IOException
    //   102	108	553	java/io/IOException
    //   131	146	553	java/io/IOException
    //   165	171	553	java/io/IOException
    //   193	198	553	java/io/IOException
    //   217	222	553	java/io/IOException
    //   54	83	558	java/io/FileNotFoundException
    //   102	108	558	java/io/FileNotFoundException
    //   131	146	558	java/io/FileNotFoundException
    //   165	171	558	java/io/FileNotFoundException
    //   193	198	558	java/io/FileNotFoundException
    //   217	222	558	java/io/FileNotFoundException
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 4, "HapticManager doRequest so zip");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = (EarlyDownloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (localObject != null)
      {
        localObject = (PokeResHandler)((EarlyDownloadManager)localObject).a("qq.android.poke.res_0625");
        if (localObject != null)
        {
          if (paramBoolean)
          {
            XmlData localXmlData = ((PokeResHandler)localObject).a();
            localXmlData.loadState = 0;
            EarlyDataFactory.a(localXmlData, new String[0]);
          }
          ((PokeResHandler)localObject).a(false);
        }
      }
    }
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HapticManager", 2, "HapticMediaPlayer start check so");
    }
    this.b = false;
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HapticManager", 2, "getFilesDir is null");
      }
      return false;
    }
    localObject2 = ((File)localObject2).getParent() + "/immer";
    Object localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    localObject2 = new File((String)localObject2 + File.separator + "libTouchSenseSDK.so");
    if ((((File)localObject2).exists()) || ((((File)localObject1).exists()) && (a((File)localObject1, (File)localObject2)))) {}
    try
    {
      localObject1 = com.tencent.qphone.base.util.BaseApplication.getContext().getSharedPreferences("early_qq.android.poke.res_0625", 0);
      localObject3 = ((SharedPreferences)localObject1).getString("SoMD5", "");
      l = ((SharedPreferences)localObject1).getLong("SoLength", 0L);
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "somd5 : " + (String)localObject3 + "\nsolength :" + l);
      }
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (l == 0L))
      {
        a(false);
        return false;
      }
    }
    catch (IOException localIOException)
    {
      long l;
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
      }
      this.b = false;
      localIOException.printStackTrace();
      a(true);
      return false;
      if ((!((String)localObject3).equals(MD5FileUtil.a((File)localObject2))) || (((File)localObject2).length() != l))
      {
        a(true);
        ((File)localObject2).delete();
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
        }
        localUnsatisfiedLinkError.printStackTrace();
        this.b = false;
      }
      System.load(((File)localObject2).getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.e("HapticManager", 2, "HapticMediaPlayer so load success");
      }
      this.b = true;
    }
    return true;
  }
  
  private boolean b(int paramInt)
  {
    if (!a()) {}
    while (paramInt < 0) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 352	com/immersion/stickersampleapp/HapticManager:g	()V
    //   6: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: ldc 183
    //   14: iconst_2
    //   15: ldc_w 354
    //   18: invokestatic 257	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 83	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   26: ldc_w 356
    //   29: ldc_w 358
    //   32: ldc_w 360
    //   35: aload_0
    //   36: getfield 88	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy	Lcom/immersion/stickersampleapp/ImmerIConnectionProxy;
    //   39: invokestatic 366	com/immersion/touchsensesdk/HapticMediaPlayer:create	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/immersion/touchsensesdk/AsyncConnectionProxy;)Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   42: putfield 368	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   45: aload_0
    //   46: getfield 368	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   49: ifnull +84 -> 133
    //   52: aload_0
    //   53: getfield 368	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer	Lcom/immersion/touchsensesdk/HapticMediaPlayer;
    //   56: bipush 40
    //   58: invokevirtual 372	com/immersion/touchsensesdk/HapticMediaPlayer:getPlayerInfo	(I)I
    //   61: istore_1
    //   62: iload_1
    //   63: ifeq +70 -> 133
    //   66: new 349	java/lang/Exception
    //   69: dup
    //   70: new 24	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 374
    //   80: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 376	com/immersion/stickersampleapp/HapticManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: iload_1
    //   88: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: invokevirtual 388	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 116	java/lang/String
    //   97: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 389	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: astore_2
    //   108: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +22 -> 133
    //   114: ldc 183
    //   116: iconst_2
    //   117: ldc_w 391
    //   120: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: ldc 183
    //   125: iconst_2
    //   126: aload_2
    //   127: invokevirtual 394	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   130: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +22 -> 162
    //   143: ldc 183
    //   145: iconst_2
    //   146: ldc_w 396
    //   149: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: ldc 183
    //   154: iconst_2
    //   155: aload_2
    //   156: invokevirtual 397	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   159: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: iconst_0
    //   164: putfield 65	com/immersion/stickersampleapp/HapticManager:b	Z
    //   167: goto -34 -> 133
    //   170: astore_2
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	HapticManager
    //   61	27	1	i	int
    //   107	20	2	localException	java.lang.Exception
    //   136	20	2	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   170	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	21	107	java/lang/Exception
    //   21	62	107	java/lang/Exception
    //   66	107	107	java/lang/Exception
    //   6	21	136	java/lang/UnsatisfiedLinkError
    //   21	62	136	java/lang/UnsatisfiedLinkError
    //   66	107	136	java/lang/UnsatisfiedLinkError
    //   2	6	170	finally
    //   6	21	170	finally
    //   21	62	170	finally
    //   66	107	170	finally
    //   108	133	170	finally
    //   137	162	170	finally
    //   162	167	170	finally
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null) {
      this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.dispose();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      b();
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer = null;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  private void f()
  {
    int i = 0;
    int[] arrayOfInt = new int[9];
    int[] tmp8_7 = arrayOfInt;
    tmp8_7[0] = 2131230723;
    int[] tmp14_8 = tmp8_7;
    tmp14_8[1] = 2131230722;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131230724;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131230725;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131230726;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131230727;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 2131230728;
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 2131230729;
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 2131230730;
    tmp58_51;
    String[] arrayOfString = new String[9];
    arrayOfString[0] = "chat_item_for_qq666";
    arrayOfString[1] = "chat_item_for_likeplus";
    arrayOfString[2] = "chat_item_for_qqbixin_light";
    arrayOfString[3] = "chat_item_for_qqbixin_strong";
    arrayOfString[4] = "chat_item_for_qqheartbroken";
    arrayOfString[5] = "chat_item_for_qqlikenew";
    arrayOfString[6] = "chat_item_for_qqpokenew";
    arrayOfString[7] = "chat_item_for_qqultnew";
    arrayOfString[8] = "chat_item_for_sticker40";
    while (i < arrayOfInt.length)
    {
      ??? = a(arrayOfInt[i], arrayOfString[i]);
      int j = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource((String)???, 1);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.add(new HapticManager.HapticEffect(this, arrayOfString[i], j));
        i += 1;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "SUCCESS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "MISSING_PERMISSIONS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "INVALID_PARAMETER");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), "INVALID_PARAMETER");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), "INVALID_URI");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-3), "INVALID_EFFECT");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-5), "OUT_OF_MEMORY");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-7), "IO_ERROR");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-9), "HAPT_NOT_READY");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-10), "TOO_MANY_EFFECTS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-11), "PLAYER_NOT_INITIALIZED");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "INVALID_CREDENTIALS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-12), "TOO_MANY_CONCURRENT_EFFECTS");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-13), "INVALID_STATE");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-14), "LIB_VERSION_NOT_FOUND");
  }
  
  public int a(String paramString, int paramInt)
  {
    boolean bool = false;
    paramInt = a(paramString, paramInt, false);
    if (paramInt > 0) {
      bool = true;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("effectName", paramString);
    StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, "pokeEffectSucessRate", bool, 0L, 0L, localHashMap, "");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$ClockTask, 60000L);
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "playEffect: " + paramString);
    }
    if (!a()) {
      return -1;
    }
    a();
    HapticManager.HapticEffect localHapticEffect = a(paramString);
    if (localHapticEffect == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "No effect added with name " + paramString);
      }
      return -1;
    }
    b();
    int i = HapticManager.HapticEffect.a(localHapticEffect);
    if (i < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "Invalid resource id for effect with name " + paramString + "! Error code returned = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "resource id:" + i);
    }
    paramInt = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.play(i, paramInt);
    if (paramInt < 0) {
      if (QLog.isColorLevel()) {
        QLog.d("HapticManager", 2, "Error while playing haptic effect with name " + paramString + "! Error returned = " + (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
      }
    }
    for (;;)
    {
      return paramInt;
      HapticManager.HapticEffect.a(localHapticEffect, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("TouchEffect", 2, "effect id:" + HapticManager.HapticEffect.b(localHapticEffect));
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      if (a())
      {
        f();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (!b(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.pause(paramInt) == 0) {
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!b(paramInt1)) {}
    while ((!a(paramInt1)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.update(paramInt1, paramInt2) == 0)) {
      return;
    }
  }
  
  public void a(String paramString1, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 2, "add effect from sd card, effectName: " + paramString1 + ".");
    }
    if (!new File(???).exists())
    {
      QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " not exists.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (HapticManager.HapticEffect.a((HapticManager.HapticEffect)localIterator.next()).equals(paramString1)) {
          return;
        }
      }
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer != null)
    {
      int i = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.addResource(???, 1);
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.add(new HapticManager.HapticEffect(this, paramString1, i));
        QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load success.");
        return;
      }
    }
    QLog.i("HapticManager", 1, "vas poke shock file " + paramString1 + " load failure, because mHapticMediaPlayer is null.");
  }
  
  public boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null)
        {
          if (this.b) {
            break label81;
          }
          if (!this.c)
          {
            this.c = true;
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
              continue;
            }
            ThreadManager.post(this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable, 10, null, false);
          }
        }
        HapticMediaPlayer localHapticMediaPlayer = this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer;
        if (localHapticMediaPlayer == null) {
          break label88;
        }
        return bool;
        this.jdField_a_of_type_ComImmersionStickersampleappHapticManager$InitHMPRunnable.run();
        continue;
        d();
      }
      finally {}
      label81:
      continue;
      label88:
      bool = false;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (a()) && (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.getEffectInfo(paramInt, 51) == 21);
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 619	java/io/File:createNewFile	()Z
    //   13: pop
    //   14: new 621	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 624	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: new 158	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 625	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_2
    //   39: aload 6
    //   41: aload_2
    //   42: invokevirtual 626	java/io/FileInputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: ifle +54 -> 101
    //   50: aload_1
    //   51: aload_2
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 162	java/io/FileOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore 7
    //   62: aload 6
    //   64: astore_2
    //   65: aload 7
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 627	java/io/FileInputStream:close	()V
    //   82: iload 5
    //   84: istore 4
    //   86: aload_1
    //   87: ifnull +11 -> 98
    //   90: aload_1
    //   91: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   94: iload 5
    //   96: istore 4
    //   98: iload 4
    //   100: ireturn
    //   101: iconst_1
    //   102: istore 4
    //   104: aload 6
    //   106: ifnull +8 -> 114
    //   109: aload 6
    //   111: invokevirtual 627	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: ifnull -17 -> 98
    //   118: aload_1
    //   119: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   144: goto -62 -> 82
    //   147: astore_1
    //   148: aload_1
    //   149: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 7
    //   160: astore_2
    //   161: aload 6
    //   163: ifnull +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 627	java/io/FileInputStream:close	()V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 165	java/io/FileOutputStream:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   188: goto -17 -> 171
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   196: goto -17 -> 179
    //   199: astore_1
    //   200: aload 7
    //   202: astore_2
    //   203: goto -42 -> 161
    //   206: astore 7
    //   208: aload_1
    //   209: astore_2
    //   210: aload 7
    //   212: astore_1
    //   213: goto -52 -> 161
    //   216: astore 7
    //   218: aload_2
    //   219: astore 6
    //   221: aload_1
    //   222: astore_2
    //   223: aload 7
    //   225: astore_1
    //   226: goto -65 -> 161
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_1
    //   233: aload 8
    //   235: astore_2
    //   236: goto -167 -> 69
    //   239: astore 7
    //   241: aconst_null
    //   242: astore_1
    //   243: aload 6
    //   245: astore_2
    //   246: aload 7
    //   248: astore 6
    //   250: goto -181 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	HapticManager
    //   0	253	1	paramFile1	File
    //   0	253	2	paramFile2	File
    //   45	9	3	i	int
    //   84	19	4	bool1	boolean
    //   7	88	5	bool2	boolean
    //   22	145	6	localObject1	Object
    //   181	3	6	localIOException1	IOException
    //   219	1	6	localFile	File
    //   229	15	6	localIOException2	IOException
    //   248	1	6	localIOException3	IOException
    //   1	1	7	localObject2	Object
    //   60	141	7	localIOException4	IOException
    //   206	5	7	localObject3	Object
    //   216	8	7	localObject4	Object
    //   239	8	7	localIOException5	IOException
    //   4	230	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	39	60	java/io/IOException
    //   39	46	60	java/io/IOException
    //   50	57	60	java/io/IOException
    //   118	122	124	java/io/IOException
    //   109	114	131	java/io/IOException
    //   78	82	139	java/io/IOException
    //   90	94	147	java/io/IOException
    //   9	24	154	finally
    //   166	171	181	java/io/IOException
    //   175	179	191	java/io/IOException
    //   24	33	199	finally
    //   33	39	206	finally
    //   39	46	206	finally
    //   50	57	206	finally
    //   69	74	216	finally
    //   9	24	229	java/io/IOException
    //   24	33	239	java/io/IOException
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopAll");
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        int i = HapticManager.HapticEffect.b((HapticManager.HapticEffect)localIterator.next());
        if ((i > 0) && (a(i))) {
          c(i);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!b(paramInt)) {}
    while (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.resume(paramInt) == 0) {
      return;
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ComImmersionStickersampleappImmerIConnectionProxy.setConnection(null);
      e();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopEffect: " + paramInt);
    }
    if (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer == null) {}
    while ((!b(paramInt)) || (this.jdField_a_of_type_ComImmersionTouchsensesdkHapticMediaPlayer.stop(paramInt) == 0)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.HapticManager
 * JD-Core Version:    0.7.0.1
 */