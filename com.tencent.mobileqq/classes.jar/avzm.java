import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.camera.CameraPeakServiceHandler.2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class avzm
  extends avzi
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = avzm.class.getSimpleName();
  }
  
  public avzm(PeakAppInterface paramPeakAppInterface)
  {
    super(paramPeakAppInterface);
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 29	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 36	ajed:aU	Ljava/lang/String;
    //   10: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 42
    //   15: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   21: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: ldc 53
    //   26: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 9
    //   34: new 29	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 36	ajed:aU	Ljava/lang/String;
    //   44: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 58
    //   49: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   55: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: ldc 53
    //   60: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 10
    //   68: aload_1
    //   69: ifnonnull +6 -> 75
    //   72: ldc 60
    //   74: areturn
    //   75: aload_1
    //   76: invokevirtual 66	android/graphics/Bitmap:getWidth	()I
    //   79: istore 4
    //   81: aload_1
    //   82: invokevirtual 69	android/graphics/Bitmap:getHeight	()I
    //   85: istore_3
    //   86: iload_3
    //   87: istore_2
    //   88: iload_3
    //   89: sipush 250
    //   92: if_icmple +7 -> 99
    //   95: sipush 250
    //   98: istore_2
    //   99: iload 4
    //   101: istore_3
    //   102: iload 4
    //   104: sipush 250
    //   107: if_icmple +7 -> 114
    //   110: sipush 250
    //   113: istore_3
    //   114: new 71	java/io/BufferedOutputStream
    //   117: dup
    //   118: new 73	java/io/FileOutputStream
    //   121: dup
    //   122: aload 9
    //   124: invokestatic 78	bace:a	(Ljava/lang/String;)Ljava/io/File;
    //   127: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   130: invokespecial 84	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   133: astore 7
    //   135: aload 7
    //   137: astore 6
    //   139: ldc 86
    //   141: iconst_2
    //   142: new 29	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   149: ldc 88
    //   151: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   157: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload 7
    //   168: astore 6
    //   170: aload_1
    //   171: getstatic 100	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   174: bipush 100
    //   176: aload 7
    //   178: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   181: pop
    //   182: aload 7
    //   184: astore 6
    //   186: ldc 86
    //   188: iconst_2
    //   189: new 29	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   196: ldc 106
    //   198: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   204: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 7
    //   215: ifnull +8 -> 223
    //   218: aload 7
    //   220: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   223: aload_1
    //   224: invokevirtual 113	android/graphics/Bitmap:isRecycled	()Z
    //   227: ifne +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   234: aload_0
    //   235: aload 9
    //   237: aload 10
    //   239: iload_3
    //   240: iload_2
    //   241: invokestatic 121	bacm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   244: ldc 86
    //   246: iconst_2
    //   247: new 29	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   254: ldc 123
    //   256: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   262: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: iconst_0
    //   272: istore 5
    //   274: iload_3
    //   275: istore 4
    //   277: iload_2
    //   278: istore_3
    //   279: iload 5
    //   281: istore_2
    //   282: new 125	java/io/File
    //   285: dup
    //   286: aload 10
    //   288: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: astore_1
    //   292: aload_1
    //   293: invokevirtual 131	java/io/File:length	()J
    //   296: ldc2_w 132
    //   299: lcmp
    //   300: ifle +396 -> 696
    //   303: iload_2
    //   304: bipush 10
    //   306: if_icmpge +390 -> 696
    //   309: iload 4
    //   311: i2d
    //   312: ldc2_w 134
    //   315: dmul
    //   316: d2i
    //   317: istore 4
    //   319: iload_3
    //   320: i2d
    //   321: ldc2_w 134
    //   324: dmul
    //   325: d2i
    //   326: istore_3
    //   327: ldc 86
    //   329: iconst_2
    //   330: new 29	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   337: ldc 137
    //   339: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   345: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_0
    //   355: aload 9
    //   357: aload 10
    //   359: bipush 100
    //   361: iload 4
    //   363: invokestatic 143	java/lang/Math:max	(II)I
    //   366: bipush 100
    //   368: iload_3
    //   369: invokestatic 143	java/lang/Math:max	(II)I
    //   372: invokestatic 121	bacm:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   375: ldc 86
    //   377: iconst_2
    //   378: new 29	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   385: ldc 145
    //   387: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   393: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   396: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 94	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: iload_2
    //   403: iconst_1
    //   404: iadd
    //   405: istore_2
    //   406: goto -124 -> 282
    //   409: astore 6
    //   411: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   414: new 29	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   421: ldc 147
    //   423: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 6
    //   428: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   431: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -217 -> 223
    //   443: astore 8
    //   445: aconst_null
    //   446: astore 7
    //   448: aload 7
    //   450: astore 6
    //   452: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   455: new 29	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   462: ldc 147
    //   464: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 8
    //   469: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   472: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 7
    //   483: ifnull +8 -> 491
    //   486: aload 7
    //   488: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   491: aload_1
    //   492: invokevirtual 113	android/graphics/Bitmap:isRecycled	()Z
    //   495: ifne -261 -> 234
    //   498: aload_1
    //   499: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   502: goto -268 -> 234
    //   505: astore 6
    //   507: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   510: new 29	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   517: ldc 147
    //   519: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 6
    //   524: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   527: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto -45 -> 491
    //   539: astore 8
    //   541: aconst_null
    //   542: astore 7
    //   544: aload 7
    //   546: astore 6
    //   548: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   551: new 29	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   558: ldc 147
    //   560: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 8
    //   565: invokevirtual 155	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   568: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload 7
    //   579: ifnull +8 -> 587
    //   582: aload 7
    //   584: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   587: aload_1
    //   588: invokevirtual 113	android/graphics/Bitmap:isRecycled	()Z
    //   591: ifne -357 -> 234
    //   594: aload_1
    //   595: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   598: goto -364 -> 234
    //   601: astore 6
    //   603: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   606: new 29	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   613: ldc 147
    //   615: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 6
    //   620: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   623: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: goto -45 -> 587
    //   635: astore_0
    //   636: aconst_null
    //   637: astore 6
    //   639: aload 6
    //   641: ifnull +8 -> 649
    //   644: aload 6
    //   646: invokevirtual 109	java/io/BufferedOutputStream:close	()V
    //   649: aload_1
    //   650: invokevirtual 113	android/graphics/Bitmap:isRecycled	()Z
    //   653: ifne +7 -> 660
    //   656: aload_1
    //   657: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   660: aload_0
    //   661: athrow
    //   662: astore 6
    //   664: getstatic 16	avzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   667: new 29	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   674: ldc 147
    //   676: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 6
    //   681: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   684: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 154	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: goto -44 -> 649
    //   696: aload_1
    //   697: invokevirtual 131	java/io/File:length	()J
    //   700: ldc2_w 132
    //   703: lcmp
    //   704: ifle +6 -> 710
    //   707: ldc 60
    //   709: areturn
    //   710: aload 10
    //   712: areturn
    //   713: astore_0
    //   714: goto -75 -> 639
    //   717: astore 8
    //   719: goto -175 -> 544
    //   722: astore 8
    //   724: goto -276 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	727	0	paramContext	android.content.Context
    //   0	727	1	paramBitmap	Bitmap
    //   87	319	2	i	int
    //   85	284	3	j	int
    //   79	283	4	k	int
    //   272	8	5	m	int
    //   137	48	6	localBufferedOutputStream1	java.io.BufferedOutputStream
    //   409	18	6	localException1	java.lang.Exception
    //   450	1	6	localBufferedOutputStream2	java.io.BufferedOutputStream
    //   505	18	6	localException2	java.lang.Exception
    //   546	1	6	localBufferedOutputStream3	java.io.BufferedOutputStream
    //   601	18	6	localException3	java.lang.Exception
    //   637	8	6	localObject	Object
    //   662	18	6	localException4	java.lang.Exception
    //   133	450	7	localBufferedOutputStream4	java.io.BufferedOutputStream
    //   443	25	8	localException5	java.lang.Exception
    //   539	25	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   717	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   722	1	8	localException6	java.lang.Exception
    //   32	324	9	str1	String
    //   66	645	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   218	223	409	java/lang/Exception
    //   114	135	443	java/lang/Exception
    //   486	491	505	java/lang/Exception
    //   114	135	539	java/lang/OutOfMemoryError
    //   582	587	601	java/lang/Exception
    //   114	135	635	finally
    //   644	649	662	java/lang/Exception
    //   139	166	713	finally
    //   170	182	713	finally
    //   186	213	713	finally
    //   452	481	713	finally
    //   548	577	713	finally
    //   139	166	717	java/lang/OutOfMemoryError
    //   170	182	717	java/lang/OutOfMemoryError
    //   186	213	717	java/lang/OutOfMemoryError
    //   139	166	722	java/lang/Exception
    //   170	182	722	java/lang/Exception
    //   186	213	722	java/lang/Exception
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
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = (GetImgValidStatusRsp)paramObject;
      if (paramObject == null) {}
    }
    for (int i = paramObject.ValidStatus;; i = -2)
    {
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
      for (boolean bool = true;; bool = false)
      {
        notifyUI(5, bool, Integer.valueOf(i));
        return;
      }
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      notifyUI(3, true, Integer.valueOf(((GetOnlineUserNumRsp)paramObject).OnlineUserNum));
    }
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = (GetRecommandTextByEmotionRsp)paramObject;
      localArrayList = paramFromServiceMsg.RecTexts;
      paramObject = paramFromServiceMsg.Emo;
    }
    for (paramFromServiceMsg = paramFromServiceMsg.UiNumConfig;; paramFromServiceMsg = localObject)
    {
      try
      {
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg);
        bool = true;
        notifyUI(1, bool, new bhso(localArrayList, paramObject, paramFromServiceMsg));
        return;
      }
      catch (JSONException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = null;
        }
      }
      paramObject = null;
    }
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool2 = bool3;
      if (((GetTextValidStatusRsp)paramObject).ValidStatus == 0) {
        bool1 = true;
      }
    }
    for (boolean bool2 = bool3;; bool2 = false)
    {
      notifyUI(2, bool2, Boolean.valueOf(bool1));
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!badq.a())
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
    if (!badq.a())
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
    bhbv.a(paramString, new avzn(this, localToServiceMsg));
  }
  
  public void c()
  {
    if (!badq.a())
    {
      LogUtils.w("111", "[reqOnlineUserNum] no network....");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetOnlineUserNum", Long.valueOf(System.currentTimeMillis()));
    send(new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetOnlineUserNum"));
  }
  
  public void c(String paramString)
  {
    if (!badq.a())
    {
      LogUtils.w("111", "[reqTextValidStatus] no network....");
      f(null, Boolean.valueOf(false));
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put("CameraModuleSvc.GetTextValidStatus", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("CameraModuleSvc", this.mApp.getCurrentAccountUin(), "CameraModuleSvc.GetTextValidStatus");
    localToServiceMsg.extraData.putString("EmoText", paramString);
    send(localToServiceMsg);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return avzo.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = 0L;
    bhci localbhci;
    int i;
    long l2;
    if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetRecommandTextByEmotion"))
    {
      localbhci = bhci.a();
      i = paramFromServiceMsg.getResultCode();
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetRecommandTextByEmotion")) {
        l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetRecommandTextByEmotion")).longValue();
      }
      localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetRecommandTextByEmotion");
      e(paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      super.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetTextValidStatus"))
      {
        localbhci = bhci.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetTextValidStatus")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetTextValidStatus")).longValue();
        }
        localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetTextValidStatus");
        f(paramFromServiceMsg, paramObject);
      }
      else if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetCameraConfig"))
      {
        localbhci = bhci.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetCameraConfig")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetCameraConfig")).longValue();
        }
        localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetCameraConfig");
        a(paramFromServiceMsg, paramObject);
      }
      else if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetOnlineUserNum"))
      {
        localbhci = bhci.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetOnlineUserNum")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetOnlineUserNum")).longValue();
        }
        localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetOnlineUserNum");
        d(paramFromServiceMsg, paramObject);
      }
      else if (paramFromServiceMsg.getServiceCmd().equals("CameraModuleSvc.GetFontData"))
      {
        localbhci = bhci.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetFontData")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetFontData")).longValue();
        }
        localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetFontData");
        b(paramFromServiceMsg, paramObject);
      }
      else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus"))
      {
        localbhci = bhci.a();
        i = paramFromServiceMsg.getResultCode();
        l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey("CameraModuleSvc.GetImgValidStatus")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilMap.get("CameraModuleSvc.GetImgValidStatus")).longValue();
        }
        localbhci.a(i, String.valueOf(l2 - l1), "CameraModuleSvc.GetImgValidStatus");
        c(paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzm
 * JD-Core Version:    0.7.0.1
 */