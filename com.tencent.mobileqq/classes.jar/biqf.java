import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import dov.com.qq.im.ae.config.CameraPeakServiceHandler.2;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class biqf
  extends biqb
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = biqf.class.getSimpleName();
  }
  
  public biqf(PeakAppInterface paramPeakAppInterface)
  {
    super(paramPeakAppInterface);
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 29	java/io/File
    //   3: dup
    //   4: getstatic 34	biic:b	Ljava/lang/String;
    //   7: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 41	java/io/File:exists	()Z
    //   17: ifne +9 -> 26
    //   20: aload 6
    //   22: invokevirtual 44	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 46	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   33: aload 6
    //   35: invokevirtual 51	java/io/File:getPath	()Ljava/lang/String;
    //   38: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: getstatic 58	java/io/File:separator	Ljava/lang/String;
    //   44: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   50: invokevirtual 67	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc 69
    //   55: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 9
    //   63: new 46	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   70: aload 6
    //   72: invokevirtual 51	java/io/File:getPath	()Ljava/lang/String;
    //   75: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 58	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   87: invokevirtual 67	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: ldc 69
    //   92: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 10
    //   100: aload_1
    //   101: ifnonnull +6 -> 107
    //   104: ldc 74
    //   106: areturn
    //   107: aload_1
    //   108: invokevirtual 80	android/graphics/Bitmap:getWidth	()I
    //   111: istore 4
    //   113: aload_1
    //   114: invokevirtual 83	android/graphics/Bitmap:getHeight	()I
    //   117: istore_3
    //   118: iload_3
    //   119: istore_2
    //   120: iload_3
    //   121: sipush 250
    //   124: if_icmple +7 -> 131
    //   127: sipush 250
    //   130: istore_2
    //   131: iload 4
    //   133: istore_3
    //   134: iload 4
    //   136: sipush 250
    //   139: if_icmple +7 -> 146
    //   142: sipush 250
    //   145: istore_3
    //   146: aconst_null
    //   147: astore 7
    //   149: aconst_null
    //   150: astore 8
    //   152: new 85	java/io/BufferedOutputStream
    //   155: dup
    //   156: new 87	java/io/FileOutputStream
    //   159: dup
    //   160: aload 9
    //   162: invokestatic 92	bbdj:a	(Ljava/lang/String;)Ljava/io/File;
    //   165: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   168: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   171: astore 6
    //   173: aload 6
    //   175: astore 7
    //   177: aload_1
    //   178: getstatic 104	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   181: bipush 100
    //   183: aload 6
    //   185: invokevirtual 108	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   188: pop
    //   189: aload 6
    //   191: ifnull +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   199: aload_1
    //   200: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   203: ifne +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 117	android/graphics/Bitmap:recycle	()V
    //   210: aload_0
    //   211: aload 9
    //   213: aload 10
    //   215: iload_3
    //   216: iload_2
    //   217: invokestatic 122	bbdr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   220: iconst_0
    //   221: istore 5
    //   223: iload_3
    //   224: istore 4
    //   226: iload_2
    //   227: istore_3
    //   228: iload 5
    //   230: istore_2
    //   231: new 29	java/io/File
    //   234: dup
    //   235: aload 10
    //   237: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 125	java/io/File:length	()J
    //   245: ldc2_w 126
    //   248: lcmp
    //   249: ifle +344 -> 593
    //   252: iload_2
    //   253: bipush 10
    //   255: if_icmpge +338 -> 593
    //   258: iload 4
    //   260: i2d
    //   261: ldc2_w 128
    //   264: dmul
    //   265: d2i
    //   266: istore 4
    //   268: iload_3
    //   269: i2d
    //   270: ldc2_w 128
    //   273: dmul
    //   274: d2i
    //   275: istore_3
    //   276: aload_0
    //   277: aload 9
    //   279: aload 10
    //   281: bipush 100
    //   283: iload 4
    //   285: invokestatic 135	java/lang/Math:max	(II)I
    //   288: bipush 100
    //   290: iload_3
    //   291: invokestatic 135	java/lang/Math:max	(II)I
    //   294: invokestatic 122	bbdr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   297: iload_2
    //   298: iconst_1
    //   299: iadd
    //   300: istore_2
    //   301: goto -70 -> 231
    //   304: astore 6
    //   306: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   309: new 46	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   316: ldc 137
    //   318: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 6
    //   323: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: goto -136 -> 199
    //   338: astore 8
    //   340: aconst_null
    //   341: astore 6
    //   343: aload 6
    //   345: astore 7
    //   347: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: new 46	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   357: ldc 137
    //   359: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 8
    //   364: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   367: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 6
    //   378: ifnull +8 -> 386
    //   381: aload 6
    //   383: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   386: aload_1
    //   387: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   390: ifne -180 -> 210
    //   393: aload_1
    //   394: invokevirtual 117	android/graphics/Bitmap:recycle	()V
    //   397: goto -187 -> 210
    //   400: astore 6
    //   402: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   405: new 46	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   412: ldc 137
    //   414: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 6
    //   419: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   422: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -45 -> 386
    //   434: astore 7
    //   436: aload 8
    //   438: astore 6
    //   440: aload 7
    //   442: astore 8
    //   444: aload 6
    //   446: astore 7
    //   448: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   451: new 46	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   458: ldc 137
    //   460: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 8
    //   465: invokevirtual 145	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   468: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 6
    //   479: ifnull +8 -> 487
    //   482: aload 6
    //   484: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   487: aload_1
    //   488: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   491: ifne -281 -> 210
    //   494: aload_1
    //   495: invokevirtual 117	android/graphics/Bitmap:recycle	()V
    //   498: goto -288 -> 210
    //   501: astore 6
    //   503: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: new 46	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   513: ldc 137
    //   515: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 6
    //   520: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   523: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: goto -45 -> 487
    //   535: astore_0
    //   536: aload 7
    //   538: ifnull +8 -> 546
    //   541: aload 7
    //   543: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   546: aload_1
    //   547: invokevirtual 114	android/graphics/Bitmap:isRecycled	()Z
    //   550: ifne +7 -> 557
    //   553: aload_1
    //   554: invokevirtual 117	android/graphics/Bitmap:recycle	()V
    //   557: aload_0
    //   558: athrow
    //   559: astore 6
    //   561: getstatic 16	biqf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   564: new 46	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   571: ldc 137
    //   573: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 6
    //   578: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   581: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 144	bizq:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: goto -44 -> 546
    //   593: aload_1
    //   594: invokevirtual 125	java/io/File:length	()J
    //   597: ldc2_w 126
    //   600: lcmp
    //   601: ifle +6 -> 607
    //   604: ldc 74
    //   606: areturn
    //   607: aload 10
    //   609: areturn
    //   610: astore_0
    //   611: goto -75 -> 536
    //   614: astore 8
    //   616: goto -172 -> 444
    //   619: astore 8
    //   621: goto -278 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	paramContext	android.content.Context
    //   0	624	1	paramBitmap	Bitmap
    //   119	182	2	i	int
    //   117	174	3	j	int
    //   111	173	4	k	int
    //   221	8	5	m	int
    //   10	185	6	localObject1	Object
    //   304	18	6	localException1	java.lang.Exception
    //   341	41	6	localObject2	Object
    //   400	18	6	localException2	java.lang.Exception
    //   438	45	6	localObject3	Object
    //   501	18	6	localException3	java.lang.Exception
    //   559	18	6	localException4	java.lang.Exception
    //   147	199	7	localObject4	Object
    //   434	7	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   446	96	7	localObject5	Object
    //   150	1	8	localObject6	Object
    //   338	99	8	localException5	java.lang.Exception
    //   442	22	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   614	1	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   619	1	8	localException6	java.lang.Exception
    //   61	217	9	str1	String
    //   98	510	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   194	199	304	java/lang/Exception
    //   152	173	338	java/lang/Exception
    //   381	386	400	java/lang/Exception
    //   152	173	434	java/lang/OutOfMemoryError
    //   482	487	501	java/lang/Exception
    //   152	173	535	finally
    //   448	477	535	finally
    //   541	546	559	java/lang/Exception
    //   177	189	610	finally
    //   347	376	610	finally
    //   177	189	614	java/lang/OutOfMemoryError
    //   177	189	619	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramString = SafeBitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      Bundle localBundle = paramToServiceMsg.extraData;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localBundle.putByteArray("Rawdata", localByteArrayOutputStream.toByteArray());
    }
    send(paramToServiceMsg);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    notifyUI(4, paramFromServiceMsg.isSuccess(), paramObject);
    if (!paramFromServiceMsg.isSuccess())
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getFont fail: " + paramFromServiceMsg);
      ThreadManager.getUIHandler().post(new CameraPeakServiceHandler.2(this));
    }
    paramObject = (GetFontDataRsp)paramObject;
    bizc localbizc = bizc.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetFontData")) {}
    for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetFontData")).longValue();; l1 = 0L)
    {
      localbizc.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetFontData", paramObject.Code);
      return;
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetImgValidStatusRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = paramObject.ValidStatus;; i = -2)
    {
      long l1;
      if ((paramFromServiceMsg != null) && (paramObject != null))
      {
        bizc localbizc = bizc.a();
        int j = paramFromServiceMsg.getResultCode();
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetImgValidStatus"))
        {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetImgValidStatus")).longValue();
          localbizc.a(j, String.valueOf(l2 - l1), "CameraModuleSvc.GetImgValidStatus", paramObject.Code);
        }
      }
      else
      {
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
          break label138;
        }
      }
      label138:
      for (boolean bool = true;; bool = false)
      {
        notifyUI(5, bool, Integer.valueOf(i));
        return;
        l1 = 0L;
        break;
      }
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetOnlineUserNumRsp)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      notifyUI(3, true, Integer.valueOf(paramObject.OnlineUserNum));
    }
    bizc localbizc = bizc.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetOnlineUserNum")) {}
    for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetOnlineUserNum")).longValue();; l1 = 0L)
    {
      localbizc.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetOnlineUserNum", paramObject.Code);
      return;
    }
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!(paramObject instanceof GetRecommandTextByEmotionRsp)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    GetRecommandTextByEmotionRsp localGetRecommandTextByEmotionRsp = (GetRecommandTextByEmotionRsp)paramObject;
    String str;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      localArrayList = localGetRecommandTextByEmotionRsp.RecTexts;
      str = localGetRecommandTextByEmotionRsp.Emo;
      paramObject = localGetRecommandTextByEmotionRsp.UiNumConfig;
    }
    for (;;)
    {
      try
      {
        paramObject = new JSONObject(paramObject);
        bool = true;
        if ((paramFromServiceMsg != null) && (localGetRecommandTextByEmotionRsp != null))
        {
          bizc localbizc = bizc.a();
          int i = paramFromServiceMsg.getResultCode();
          long l2 = System.currentTimeMillis();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetRecommandTextByEmotion"))
          {
            l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetRecommandTextByEmotion")).longValue();
            localbizc.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionRsp.Code);
          }
        }
        else
        {
          notifyUI(1, bool, new bisc(localArrayList, str, paramObject));
          return;
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        paramObject = null;
        continue;
        long l1 = 0L;
        continue;
      }
      paramObject = null;
      str = null;
      boolean bool = false;
    }
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    paramObject = (GetTextValidStatusRsp)paramObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      if (paramObject.ValidStatus == 0) {
        bool1 = true;
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      bizc localbizc;
      int i;
      long l2;
      if ((paramFromServiceMsg != null) && (paramObject != null))
      {
        localbizc = bizc.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (!this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetTextValidStatus")) {
          break label124;
        }
      }
      label124:
      for (long l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetTextValidStatus")).longValue();; l1 = 0L)
      {
        localbizc.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetTextValidStatus", paramObject.Code);
        notifyUI(2, bool2, Boolean.valueOf(bool1));
        return;
      }
      bool1 = false;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!bbev.a())
    {
      LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
      e(null, new ArrayList());
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetRecommandTextByEmotion", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetRecommandTextByEmotion");
    if (paramBitmap != null)
    {
      Bundle localBundle = localToServiceMsg.extraData;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localBundle.putByteArray("Rawdata", localByteArrayOutputStream.toByteArray());
    }
    send(localToServiceMsg);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    super.a(paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!bbev.a())
    {
      LogUtils.w("111", "[reqFontData] no network....");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetFontData", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetFontData");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("FontName", paramString1);
    localBundle.putString("Content", paramString2);
    send(localToServiceMsg);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetImgValidStatus");
    paramString = SafeBitmapFactory.decodeFile(paramString);
    String str = AETakeFacePhotoPreviewFragment.a();
    if ((str != null) && (str.length() > 0))
    {
      a(localToServiceMsg, str);
      return;
    }
    biyg.a(paramString, new biqg(this, localToServiceMsg));
  }
  
  public void c()
  {
    if (!bbev.a())
    {
      LogUtils.w("111", "[reqOnlineUserNum] no network....");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetOnlineUserNum", Long.valueOf(System.currentTimeMillis()));
    send(new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetOnlineUserNum"));
  }
  
  public void c(String paramString)
  {
    if (!bbev.a())
    {
      LogUtils.w("111", "[reqTextValidStatus] no network....");
      f(null, null);
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetTextValidStatus", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetTextValidStatus");
    localToServiceMsg.extraData.putString("EmoText", paramString);
    send(localToServiceMsg);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return biqh.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetRecommandTextByEmotion")) {
      e(paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      super.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetTextValidStatus"))
      {
        f(paramFromServiceMsg, paramObject);
      }
      else
      {
        if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
        {
          a(paramFromServiceMsg, paramObject);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetOnlineUserNum")) {
          d(paramFromServiceMsg, paramObject);
        } else if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetFontData")) {
          b(paramFromServiceMsg, paramObject);
        } else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) {
          c(paramFromServiceMsg, paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqf
 * JD-Core Version:    0.7.0.1
 */