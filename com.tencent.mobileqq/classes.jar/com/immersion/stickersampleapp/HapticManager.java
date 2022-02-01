package com.immersion.stickersampleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.immersion.touchsensesdk.HapticMediaPlayer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
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
  private static final String b;
  private static HapticManager c = new HapticManager(BaseApplicationImpl.sApplication);
  boolean a = false;
  private final List<HapticManager.HapticEffect> d = new ArrayList();
  private HashMap<Integer, String> e;
  private HapticMediaPlayer f;
  private Context g;
  private ImmerIConnectionProxy h;
  private boolean i = false;
  private boolean j = false;
  private HapticManager.InitHMPRunnable k = null;
  private HapticManager.ClockTask l = new HapticManager.ClockTask(this);
  private HapticManager.DisposeTask m = new HapticManager.DisposeTask(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PokeItemHelper.c());
    localStringBuilder.append("poke/immersion_source/libTouchSenseSDK.so");
    b = localStringBuilder.toString();
  }
  
  private HapticManager(Context paramContext)
  {
    this.g = paramContext;
    this.h = new ImmerIConnectionProxy();
    this.k = new HapticManager.InitHMPRunnable(this);
  }
  
  private HapticManager.HapticEffect a(String paramString)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        HapticManager.HapticEffect localHapticEffect = (HapticManager.HapticEffect)localIterator.next();
        if (HapticManager.HapticEffect.c(localHapticEffect).equals(paramString)) {
          return localHapticEffect;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  private String a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 13
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore 11
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 12
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore 6
    //   30: aload_0
    //   31: getfield 93	com/immersion/stickersampleapp/HapticManager:g	Landroid/content/Context;
    //   34: invokevirtual 143	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   37: iload_1
    //   38: invokevirtual 149	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   41: astore 5
    //   43: aload 6
    //   45: astore 7
    //   47: aload 10
    //   49: astore 8
    //   51: aload 11
    //   53: astore 9
    //   55: aload 12
    //   57: astore_3
    //   58: aload 5
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 93	com/immersion/stickersampleapp/HapticManager:g	Landroid/content/Context;
    //   66: astore 14
    //   68: aload 6
    //   70: astore 7
    //   72: aload 10
    //   74: astore 8
    //   76: aload 11
    //   78: astore 9
    //   80: aload 12
    //   82: astore_3
    //   83: aload 5
    //   85: astore 4
    //   87: new 34	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   94: astore 15
    //   96: aload 6
    //   98: astore 7
    //   100: aload 10
    //   102: astore 8
    //   104: aload 11
    //   106: astore 9
    //   108: aload 12
    //   110: astore_3
    //   111: aload 5
    //   113: astore 4
    //   115: aload 15
    //   117: aload_2
    //   118: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 6
    //   124: astore 7
    //   126: aload 10
    //   128: astore 8
    //   130: aload 11
    //   132: astore 9
    //   134: aload 12
    //   136: astore_3
    //   137: aload 5
    //   139: astore 4
    //   141: aload 15
    //   143: ldc 151
    //   145: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 6
    //   151: astore 7
    //   153: aload 10
    //   155: astore 8
    //   157: aload 11
    //   159: astore 9
    //   161: aload 12
    //   163: astore_3
    //   164: aload 5
    //   166: astore 4
    //   168: aload 14
    //   170: aload 15
    //   172: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: iconst_0
    //   176: invokevirtual 155	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   179: astore 6
    //   181: aload 6
    //   183: astore 7
    //   185: aload 6
    //   187: astore 8
    //   189: aload 6
    //   191: astore 9
    //   193: aload 6
    //   195: astore_3
    //   196: aload 5
    //   198: astore 4
    //   200: aload 5
    //   202: invokevirtual 161	java/io/InputStream:available	()I
    //   205: istore_1
    //   206: iload_1
    //   207: ifle +65 -> 272
    //   210: aload 6
    //   212: astore 7
    //   214: aload 6
    //   216: astore 8
    //   218: aload 6
    //   220: astore 9
    //   222: aload 6
    //   224: astore_3
    //   225: aload 5
    //   227: astore 4
    //   229: aload 6
    //   231: aload 13
    //   233: iconst_0
    //   234: aload 5
    //   236: aload 13
    //   238: invokevirtual 165	java/io/InputStream:read	([B)I
    //   241: invokevirtual 171	java/io/FileOutputStream:write	([BII)V
    //   244: aload 6
    //   246: astore 7
    //   248: aload 6
    //   250: astore 8
    //   252: aload 6
    //   254: astore 9
    //   256: aload 6
    //   258: astore_3
    //   259: aload 5
    //   261: astore 4
    //   263: aload 5
    //   265: invokevirtual 161	java/io/InputStream:available	()I
    //   268: istore_1
    //   269: goto -63 -> 206
    //   272: aload 6
    //   274: astore 7
    //   276: aload 6
    //   278: astore 8
    //   280: aload 6
    //   282: astore 9
    //   284: aload 6
    //   286: astore_3
    //   287: aload 5
    //   289: astore 4
    //   291: aload 6
    //   293: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   296: aload 6
    //   298: astore 7
    //   300: aload 6
    //   302: astore 8
    //   304: aload 6
    //   306: astore 9
    //   308: aload 6
    //   310: astore_3
    //   311: aload 5
    //   313: astore 4
    //   315: aload 5
    //   317: invokevirtual 175	java/io/InputStream:close	()V
    //   320: aload 6
    //   322: ifnull +16 -> 338
    //   325: aload 6
    //   327: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   330: goto +8 -> 338
    //   333: astore_3
    //   334: aload_3
    //   335: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   338: aload 5
    //   340: ifnull +203 -> 543
    //   343: aload 5
    //   345: invokevirtual 175	java/io/InputStream:close	()V
    //   348: goto +195 -> 543
    //   351: astore 6
    //   353: goto +25 -> 378
    //   356: astore 6
    //   358: goto +75 -> 433
    //   361: astore 6
    //   363: goto +125 -> 488
    //   366: astore_2
    //   367: aconst_null
    //   368: astore 4
    //   370: goto +231 -> 601
    //   373: astore 6
    //   375: aconst_null
    //   376: astore 5
    //   378: aload 7
    //   380: astore_3
    //   381: aload 5
    //   383: astore 4
    //   385: ldc 180
    //   387: iconst_2
    //   388: aload 6
    //   390: iconst_0
    //   391: anewarray 4	java/lang/Object
    //   394: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   397: aload 7
    //   399: ifnull +16 -> 415
    //   402: aload 7
    //   404: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   407: goto +8 -> 415
    //   410: astore_3
    //   411: aload_3
    //   412: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   415: aload 5
    //   417: ifnull +126 -> 543
    //   420: aload 5
    //   422: invokevirtual 175	java/io/InputStream:close	()V
    //   425: goto +118 -> 543
    //   428: astore 6
    //   430: aconst_null
    //   431: astore 5
    //   433: aload 8
    //   435: astore_3
    //   436: aload 5
    //   438: astore 4
    //   440: ldc 180
    //   442: iconst_2
    //   443: aload 6
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   452: aload 8
    //   454: ifnull +16 -> 470
    //   457: aload 8
    //   459: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   462: goto +8 -> 470
    //   465: astore_3
    //   466: aload_3
    //   467: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   470: aload 5
    //   472: ifnull +71 -> 543
    //   475: aload 5
    //   477: invokevirtual 175	java/io/InputStream:close	()V
    //   480: goto +63 -> 543
    //   483: astore 6
    //   485: aconst_null
    //   486: astore 5
    //   488: aload 9
    //   490: astore_3
    //   491: aload 5
    //   493: astore 4
    //   495: ldc 180
    //   497: iconst_2
    //   498: aload 6
    //   500: iconst_0
    //   501: anewarray 4	java/lang/Object
    //   504: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   507: aload 9
    //   509: ifnull +16 -> 525
    //   512: aload 9
    //   514: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   517: goto +8 -> 525
    //   520: astore_3
    //   521: aload_3
    //   522: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   525: aload 5
    //   527: ifnull +16 -> 543
    //   530: aload 5
    //   532: invokevirtual 175	java/io/InputStream:close	()V
    //   535: goto +8 -> 543
    //   538: astore_3
    //   539: aload_3
    //   540: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   543: aload_0
    //   544: getfield 93	com/immersion/stickersampleapp/HapticManager:g	Landroid/content/Context;
    //   547: invokevirtual 189	android/content/Context:getFilesDir	()Ljava/io/File;
    //   550: astore_3
    //   551: new 34	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   558: astore 4
    //   560: aload 4
    //   562: aload_3
    //   563: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   566: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 4
    //   572: getstatic 197	java/io/File:separator	Ljava/lang/String;
    //   575: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload 4
    //   581: aload_2
    //   582: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 4
    //   588: ldc 151
    //   590: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 4
    //   596: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: areturn
    //   600: astore_2
    //   601: aload_3
    //   602: ifnull +15 -> 617
    //   605: aload_3
    //   606: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   609: goto +8 -> 617
    //   612: astore_3
    //   613: aload_3
    //   614: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   617: aload 4
    //   619: ifnull +16 -> 635
    //   622: aload 4
    //   624: invokevirtual 175	java/io/InputStream:close	()V
    //   627: goto +8 -> 635
    //   630: astore_3
    //   631: aload_3
    //   632: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   635: goto +5 -> 640
    //   638: aload_2
    //   639: athrow
    //   640: goto -2 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	HapticManager
    //   0	643	1	paramInt	int
    //   0	643	2	paramString	String
    //   26	285	3	localObject1	Object
    //   333	2	3	localIOException1	IOException
    //   380	1	3	localObject2	Object
    //   410	2	3	localIOException2	IOException
    //   435	1	3	localObject3	Object
    //   465	2	3	localIOException3	IOException
    //   490	1	3	localObject4	Object
    //   520	2	3	localIOException4	IOException
    //   538	2	3	localIOException5	IOException
    //   550	56	3	localFile	File
    //   612	2	3	localIOException6	IOException
    //   630	2	3	localIOException7	IOException
    //   60	563	4	localObject5	Object
    //   41	490	5	localInputStream	java.io.InputStream
    //   28	298	6	localFileOutputStream	java.io.FileOutputStream
    //   351	1	6	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   356	1	6	localIOException8	IOException
    //   361	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   373	16	6	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   428	16	6	localIOException9	IOException
    //   483	16	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   14	389	7	localObject6	Object
    //   17	441	8	localObject7	Object
    //   20	493	9	localObject8	Object
    //   8	146	10	localObject9	Object
    //   11	147	11	localObject10	Object
    //   23	139	12	localObject11	Object
    //   5	232	13	arrayOfByte	byte[]
    //   66	103	14	localContext	Context
    //   94	77	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   325	330	333	java/io/IOException
    //   62	68	351	java/lang/ArrayIndexOutOfBoundsException
    //   87	96	351	java/lang/ArrayIndexOutOfBoundsException
    //   115	122	351	java/lang/ArrayIndexOutOfBoundsException
    //   141	149	351	java/lang/ArrayIndexOutOfBoundsException
    //   168	181	351	java/lang/ArrayIndexOutOfBoundsException
    //   200	206	351	java/lang/ArrayIndexOutOfBoundsException
    //   229	244	351	java/lang/ArrayIndexOutOfBoundsException
    //   263	269	351	java/lang/ArrayIndexOutOfBoundsException
    //   291	296	351	java/lang/ArrayIndexOutOfBoundsException
    //   315	320	351	java/lang/ArrayIndexOutOfBoundsException
    //   62	68	356	java/io/IOException
    //   87	96	356	java/io/IOException
    //   115	122	356	java/io/IOException
    //   141	149	356	java/io/IOException
    //   168	181	356	java/io/IOException
    //   200	206	356	java/io/IOException
    //   229	244	356	java/io/IOException
    //   263	269	356	java/io/IOException
    //   291	296	356	java/io/IOException
    //   315	320	356	java/io/IOException
    //   62	68	361	java/io/FileNotFoundException
    //   87	96	361	java/io/FileNotFoundException
    //   115	122	361	java/io/FileNotFoundException
    //   141	149	361	java/io/FileNotFoundException
    //   168	181	361	java/io/FileNotFoundException
    //   200	206	361	java/io/FileNotFoundException
    //   229	244	361	java/io/FileNotFoundException
    //   263	269	361	java/io/FileNotFoundException
    //   291	296	361	java/io/FileNotFoundException
    //   315	320	361	java/io/FileNotFoundException
    //   30	43	366	finally
    //   30	43	373	java/lang/ArrayIndexOutOfBoundsException
    //   402	407	410	java/io/IOException
    //   30	43	428	java/io/IOException
    //   457	462	465	java/io/IOException
    //   30	43	483	java/io/FileNotFoundException
    //   512	517	520	java/io/IOException
    //   343	348	538	java/io/IOException
    //   420	425	538	java/io/IOException
    //   475	480	538	java/io/IOException
    //   530	535	538	java/io/IOException
    //   62	68	600	finally
    //   87	96	600	finally
    //   115	122	600	finally
    //   141	149	600	finally
    //   168	181	600	finally
    //   200	206	600	finally
    //   229	244	600	finally
    //   263	269	600	finally
    //   291	296	600	finally
    //   315	320	600	finally
    //   385	397	600	finally
    //   440	452	600	finally
    //   495	507	600	finally
    //   605	609	612	java/io/IOException
    //   622	627	630	java/io/IOException
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HapticManager", 4, "HapticManager doRequest so zip");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = (IEarlyDownloadService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IEarlyDownloadService.class, "");
      if (localObject != null)
      {
        localObject = (PokeResHandler)((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.poke.res_0625");
        if (localObject != null)
        {
          if (paramBoolean)
          {
            XmlData localXmlData = ((PokeResHandler)localObject).h();
            localXmlData.loadState = 0;
            EarlyDataFactory.a(localXmlData, new String[0]);
          }
          ((PokeResHandler)localObject).a(false);
        }
      }
    }
  }
  
  public static HapticManager b()
  {
    try
    {
      HapticManager localHapticManager = c;
      return localHapticManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean e(int paramInt)
  {
    if (!a()) {
      return false;
    }
    return paramInt >= 0;
  }
  
  private void f()
  {
    try
    {
      i();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("HapticManager", 2, "start create HapticMediaPlayer");
        }
        this.f = HapticMediaPlayer.create(this.g, "d449069abbf775f15a17602efed01328f36864b2c5af513c946db5ae4b2e7c03", "Rc#aX%L*", "tkcn.pmtvmimmersion.com", this.h);
        if (this.f != null)
        {
          int n = this.f.getPlayerInfo(40);
          if (n != 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error creating HapticMediaPlayer. Error: ");
            localStringBuilder.append((String)this.e.get(Integer.valueOf(n)));
            throw new Exception(localStringBuilder.toString());
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("HapticManager", 2, "HapticMediaPlayer create fail");
          QLog.e("HapticManager", 2, localUnsatisfiedLinkError.getMessage());
        }
        this.i = false;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("HapticManager", 2, "HapticMediaPlayer create fail 1");
          QLog.e("HapticManager", 2, localException.getMessage());
        }
      }
      return;
    }
    finally {}
  }
  
  private void g()
  {
    ??? = this.f;
    if (??? != null) {
      ((HapticMediaPlayer)???).dispose();
    }
    if (this.d != null)
    {
      d();
      synchronized (this.d)
      {
        this.d.clear();
      }
    }
    ??? = this.e;
    if (??? != null) {
      ((HashMap)???).clear();
    }
    this.f = null;
    this.a = false;
  }
  
  private void h()
  {
    int[] arrayOfInt = new int[9];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131230763;
    int[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 2131230762;
    int[] tmp18_12 = tmp12_6;
    tmp18_12[2] = 2131230764;
    int[] tmp24_18 = tmp18_12;
    tmp24_18[3] = 2131230765;
    int[] tmp30_24 = tmp24_18;
    tmp30_24[4] = 2131230766;
    int[] tmp36_30 = tmp30_24;
    tmp36_30[5] = 2131230767;
    int[] tmp42_36 = tmp36_30;
    tmp42_36[6] = 2131230768;
    int[] tmp49_42 = tmp42_36;
    tmp49_42[7] = 2131230769;
    int[] tmp56_49 = tmp49_42;
    tmp56_49[8] = 2131230770;
    tmp56_49;
    String[] arrayOfString = new String[9];
    int n = 0;
    arrayOfString[0] = "chat_item_for_qq666";
    arrayOfString[1] = "chat_item_for_likeplus";
    arrayOfString[2] = "chat_item_for_qqbixin_light";
    arrayOfString[3] = "chat_item_for_qqbixin_strong";
    arrayOfString[4] = "chat_item_for_qqheartbroken";
    arrayOfString[5] = "chat_item_for_qqlikenew";
    arrayOfString[6] = "chat_item_for_qqpokenew";
    arrayOfString[7] = "chat_item_for_qqultnew";
    arrayOfString[8] = "chat_item_for_sticker40";
    while (n < arrayOfInt.length)
    {
      ??? = a(arrayOfInt[n], arrayOfString[n]);
      int i1 = this.f.addResource((String)???, 1);
      synchronized (this.d)
      {
        this.d.add(new HapticManager.HapticEffect(this, arrayOfString[n], i1));
        n += 1;
      }
    }
  }
  
  private void i()
  {
    this.e = new HashMap();
    this.e.put(Integer.valueOf(0), "SUCCESS");
    this.e.put(Integer.valueOf(2), "MISSING_PERMISSIONS");
    this.e.put(Integer.valueOf(1), "INVALID_PARAMETER");
    this.e.put(Integer.valueOf(-1), "INVALID_PARAMETER");
    this.e.put(Integer.valueOf(-2), "INVALID_URI");
    this.e.put(Integer.valueOf(-3), "INVALID_EFFECT");
    this.e.put(Integer.valueOf(-5), "OUT_OF_MEMORY");
    this.e.put(Integer.valueOf(-7), "IO_ERROR");
    this.e.put(Integer.valueOf(-9), "HAPT_NOT_READY");
    this.e.put(Integer.valueOf(-10), "TOO_MANY_EFFECTS");
    this.e.put(Integer.valueOf(-11), "PLAYER_NOT_INITIALIZED");
    this.e.put(Integer.valueOf(3), "INVALID_CREDENTIALS");
    this.e.put(Integer.valueOf(-12), "TOO_MANY_CONCURRENT_EFFECTS");
    this.e.put(Integer.valueOf(-13), "INVALID_STATE");
    this.e.put(Integer.valueOf(-14), "LIB_VERSION_NOT_FOUND");
  }
  
  private boolean j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HapticManager", 2, "HapticMediaPlayer start check so");
    }
    this.i = false;
    Object localObject1 = new File(b);
    Object localObject2 = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HapticManager", 2, "getFilesDir is null");
      }
      return false;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((File)localObject2).getParent());
    ((StringBuilder)localObject3).append("/immer");
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = new File((String)localObject2);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("libTouchSenseSDK.so");
    localObject2 = new File(((StringBuilder)localObject3).toString());
    if ((((File)localObject2).exists()) || ((((File)localObject1).exists()) && (a((File)localObject1, (File)localObject2)))) {
      try
      {
        localObject3 = com.tencent.qphone.base.util.BaseApplication.getContext().getSharedPreferences("early_qq.android.poke.res_0625", 0);
        localObject1 = ((SharedPreferences)localObject3).getString("SoMD5", "");
        long l1 = ((SharedPreferences)localObject3).getLong("SoLength", 0L);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("somd5 : ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("\nsolength :");
          ((StringBuilder)localObject3).append(l1);
          QLog.e("HapticManager", 2, ((StringBuilder)localObject3).toString());
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 != 0L))
        {
          if ((((String)localObject1).equals(MD5FileUtil.a((File)localObject2))) && (((File)localObject2).length() == l1))
          {
            System.load(((File)localObject2).getAbsolutePath());
            if (QLog.isColorLevel()) {
              QLog.e("HapticManager", 2, "HapticMediaPlayer so load success");
            }
            this.i = true;
            return true;
          }
          a(true);
          ((File)localObject2).delete();
          return false;
        }
        a(false);
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
        }
        localUnsatisfiedLinkError.printStackTrace();
        this.i = false;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HapticManager", 2, "HapticMediaPlayer so load fail");
        }
        this.i = false;
        localIOException.printStackTrace();
      }
    }
    a(true);
    return false;
  }
  
  public int a(String paramString, int paramInt)
  {
    paramInt = a(paramString, paramInt, false);
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("effectName", paramString);
    StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()).collectPerformance(null, "pokeEffectSucessRate", bool, 0L, 0L, localHashMap, "");
    ThreadManager.getSubThreadHandler().removeCallbacks(this.l);
    ThreadManager.getSubThreadHandler().postDelayed(this.l, 60000L);
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playEffect: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TouchEffect", 2, ((StringBuilder)localObject).toString());
    }
    if (!a()) {
      return -1;
    }
    c();
    Object localObject = a(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No effect added with name ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("HapticManager", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    d();
    int n = HapticManager.HapticEffect.a((HapticManager.HapticEffect)localObject);
    if (n < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid resource id for effect with name ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("! Error code returned = ");
        ((StringBuilder)localObject).append((String)this.e.get(Integer.valueOf(n)));
        QLog.d("TouchEffect", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resource id:");
      localStringBuilder.append(n);
      QLog.d("TouchEffect", 2, localStringBuilder.toString());
    }
    paramInt = this.f.play(n, paramInt);
    if (paramInt < 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error while playing haptic effect with name ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("! Error returned = ");
        ((StringBuilder)localObject).append((String)this.e.get(Integer.valueOf(paramInt)));
        QLog.d("HapticManager", 2, ((StringBuilder)localObject).toString());
        return paramInt;
      }
    }
    else
    {
      HapticManager.HapticEffect.a((HapticManager.HapticEffect)localObject, paramInt);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("effect id:");
        paramString.append(HapticManager.HapticEffect.b((HapticManager.HapticEffect)localObject));
        QLog.d("TouchEffect", 2, paramString.toString());
      }
    }
    return paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!e(paramInt1)) {
      return;
    }
    if (!a(paramInt1)) {
      return;
    }
    this.f.update(paramInt1, paramInt2);
  }
  
  public void a(String paramString1, String arg2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("add effect from sd card, effectName: ");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(".");
      QLog.d("HapticManager", 2, ((StringBuilder)???).toString());
    }
    if (!new File(???).exists())
    {
      ??? = new StringBuilder();
      ???.append("vas poke shock file ");
      ???.append(paramString1);
      ???.append(" not exists.");
      QLog.i("HapticManager", 1, ???.toString());
      return;
    }
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        if (HapticManager.HapticEffect.c((HapticManager.HapticEffect)localIterator.next()).equals(paramString1)) {
          return;
        }
      }
      ??? = this.f;
      if (??? != null)
      {
        int n = ((HapticMediaPlayer)???).addResource(???, 1);
        synchronized (this.d)
        {
          this.d.add(new HapticManager.HapticEffect(this, paramString1, n));
          ??? = new StringBuilder();
          ???.append("vas poke shock file ");
          ???.append(paramString1);
          ???.append(" load success.");
          QLog.i("HapticManager", 1, ???.toString());
          return;
        }
      }
      ??? = new StringBuilder();
      ???.append("vas poke shock file ");
      ???.append(paramString1);
      ???.append(" load failure, because mHapticMediaPlayer is null.");
      QLog.i("HapticManager", 1, ???.toString());
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public boolean a()
  {
    try
    {
      HapticMediaPlayer localHapticMediaPlayer = this.f;
      boolean bool = true;
      if (localHapticMediaPlayer == null) {
        if (!this.i)
        {
          if (!this.j)
          {
            this.j = true;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
              ThreadManager.post(this.k, 10, null, false);
            } else {
              this.k.run();
            }
          }
        }
        else {
          f();
        }
      }
      localHapticMediaPlayer = this.f;
      if (localHapticMediaPlayer == null) {
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  public boolean a(int paramInt)
  {
    return (a()) && (this.f.getEffectInfo(paramInt, 51) == 21);
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_2
    //   10: invokevirtual 614	java/io/File:createNewFile	()Z
    //   13: pop
    //   14: new 616	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 619	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: new 167	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 620	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore 5
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_2
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 621	java/io/FileInputStream:read	([B)I
    //   44: istore_3
    //   45: iload_3
    //   46: ifle +14 -> 60
    //   49: aload 5
    //   51: aload_2
    //   52: iconst_0
    //   53: iload_3
    //   54: invokevirtual 171	java/io/FileOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_1
    //   64: invokevirtual 622	java/io/FileInputStream:close	()V
    //   67: goto +8 -> 75
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   75: aload 5
    //   77: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   87: iload 4
    //   89: ireturn
    //   90: astore_2
    //   91: goto +80 -> 171
    //   94: astore_2
    //   95: goto +15 -> 110
    //   98: astore_2
    //   99: aload 7
    //   101: astore 5
    //   103: goto +68 -> 171
    //   106: astore_2
    //   107: aconst_null
    //   108: astore 5
    //   110: aload_1
    //   111: astore 6
    //   113: aload 5
    //   115: astore_1
    //   116: goto +16 -> 132
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: aload 7
    //   124: astore 5
    //   126: goto +45 -> 171
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_2
    //   133: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   136: aload 6
    //   138: ifnull +16 -> 154
    //   141: aload 6
    //   143: invokevirtual 622	java/io/FileInputStream:close	()V
    //   146: goto +8 -> 154
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_2
    //   165: aload_1
    //   166: astore 5
    //   168: aload 6
    //   170: astore_1
    //   171: aload_1
    //   172: ifnull +15 -> 187
    //   175: aload_1
    //   176: invokevirtual 622	java/io/FileInputStream:close	()V
    //   179: goto +8 -> 187
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   187: aload 5
    //   189: ifnull +16 -> 205
    //   192: aload 5
    //   194: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   197: goto +8 -> 205
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   205: goto +5 -> 210
    //   208: aload_2
    //   209: athrow
    //   210: goto -2 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	HapticManager
    //   0	213	1	paramFile1	File
    //   0	213	2	paramFile2	File
    //   44	10	3	n	int
    //   7	81	4	bool	boolean
    //   31	162	5	localObject1	Object
    //   4	165	6	localFile	File
    //   1	122	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	70	java/io/IOException
    //   75	80	82	java/io/IOException
    //   158	162	82	java/io/IOException
    //   33	39	90	finally
    //   39	45	90	finally
    //   49	57	90	finally
    //   33	39	94	java/io/IOException
    //   39	45	94	java/io/IOException
    //   49	57	94	java/io/IOException
    //   23	33	98	finally
    //   23	33	106	java/io/IOException
    //   9	23	119	finally
    //   9	23	129	java/io/IOException
    //   141	146	149	java/io/IOException
    //   132	136	164	finally
    //   175	179	182	java/io/IOException
    //   192	197	200	java/io/IOException
  }
  
  public void b(int paramInt)
  {
    if (!e(paramInt)) {
      return;
    }
    this.f.pause(paramInt);
  }
  
  public void c()
  {
    if (this.a) {
      return;
    }
    try
    {
      if (a())
      {
        h();
        this.a = true;
      }
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    if (!e(paramInt)) {
      return;
    }
    this.f.resume(paramInt);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TouchEffect", 2, "stopAll");
    }
    if (this.f == null) {
      return;
    }
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        int n = HapticManager.HapticEffect.b((HapticManager.HapticEffect)localIterator.next());
        if ((n > 0) && (a(n))) {
          d(n);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopEffect: ");
      localStringBuilder.append(paramInt);
      QLog.d("TouchEffect", 2, localStringBuilder.toString());
    }
    if (this.f == null) {
      return;
    }
    if (!e(paramInt)) {
      return;
    }
    this.f.stop(paramInt);
  }
  
  public void e()
  {
    try
    {
      this.h.setConnection(null);
      g();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.stickersampleapp.HapticManager
 * JD-Core Version:    0.7.0.1
 */