package com.tencent.aelight.camera.ae.config;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterRspItem;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorAIFilterManager.AIRequestCallback;
import com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterResponse;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraPeakServiceHandler
  extends CameraDataServiceHandler
{
  private static final String d = "CameraPeakServiceHandler";
  public AppInterface c;
  
  public CameraPeakServiceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.c = paramAppInterface;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 27	java/io/File
    //   3: dup
    //   4: getstatic 32	com/tencent/aelight/camera/ae/AEPath$CAMERA$CACHE:b	Ljava/lang/String;
    //   7: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aload 7
    //   14: invokevirtual 39	java/io/File:exists	()Z
    //   17: ifne +9 -> 26
    //   20: aload 7
    //   22: invokevirtual 42	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 44	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   33: astore 8
    //   35: aload 8
    //   37: aload 7
    //   39: invokevirtual 50	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 8
    //   48: getstatic 57	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 8
    //   57: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   60: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 8
    //   66: ldc 68
    //   68: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 12
    //   79: new 44	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   86: astore 8
    //   88: aload 8
    //   90: aload 7
    //   92: invokevirtual 50	java/io/File:getPath	()Ljava/lang/String;
    //   95: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 8
    //   101: getstatic 57	java/io/File:separator	Ljava/lang/String;
    //   104: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 8
    //   110: invokestatic 63	java/lang/System:currentTimeMillis	()J
    //   113: invokevirtual 66	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 8
    //   119: ldc 68
    //   121: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 8
    //   127: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore 13
    //   132: aload_1
    //   133: ifnonnull +6 -> 139
    //   136: ldc 73
    //   138: areturn
    //   139: aload_1
    //   140: invokevirtual 79	android/graphics/Bitmap:getWidth	()I
    //   143: istore 6
    //   145: aload_1
    //   146: invokevirtual 82	android/graphics/Bitmap:getHeight	()I
    //   149: istore 5
    //   151: iload 5
    //   153: istore 4
    //   155: iload 5
    //   157: sipush 250
    //   160: if_icmple +8 -> 168
    //   163: sipush 250
    //   166: istore 4
    //   168: iload 6
    //   170: istore 5
    //   172: iload 6
    //   174: sipush 250
    //   177: if_icmple +8 -> 185
    //   180: sipush 250
    //   183: istore 5
    //   185: aconst_null
    //   186: astore 10
    //   188: aconst_null
    //   189: astore 11
    //   191: aconst_null
    //   192: astore 7
    //   194: new 84	java/io/BufferedOutputStream
    //   197: dup
    //   198: new 86	java/io/FileOutputStream
    //   201: dup
    //   202: aload 12
    //   204: invokestatic 92	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   207: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   210: invokespecial 98	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   213: astore 8
    //   215: aload_1
    //   216: getstatic 104	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   219: bipush 100
    //   221: aload 8
    //   223: invokevirtual 108	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   226: pop
    //   227: aload 8
    //   229: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   232: goto +48 -> 280
    //   235: astore 7
    //   237: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   240: astore 8
    //   242: new 44	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   249: astore 9
    //   251: aload 9
    //   253: ldc 115
    //   255: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 9
    //   261: aload 7
    //   263: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   266: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 8
    //   272: aload 9
    //   274: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_1
    //   281: invokevirtual 124	android/graphics/Bitmap:isRecycled	()Z
    //   284: ifne +306 -> 590
    //   287: aload_1
    //   288: invokevirtual 127	android/graphics/Bitmap:recycle	()V
    //   291: goto +299 -> 590
    //   294: astore_0
    //   295: aload 8
    //   297: astore 7
    //   299: goto +416 -> 715
    //   302: astore 9
    //   304: goto +18 -> 322
    //   307: astore 9
    //   309: goto +150 -> 459
    //   312: astore_0
    //   313: goto +402 -> 715
    //   316: astore 9
    //   318: aload 10
    //   320: astore 8
    //   322: aload 8
    //   324: astore 7
    //   326: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   329: astore 10
    //   331: aload 8
    //   333: astore 7
    //   335: new 44	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   342: astore 11
    //   344: aload 8
    //   346: astore 7
    //   348: aload 11
    //   350: ldc 115
    //   352: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 8
    //   358: astore 7
    //   360: aload 11
    //   362: aload 9
    //   364: invokevirtual 128	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   367: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 8
    //   373: astore 7
    //   375: aload 10
    //   377: aload 11
    //   379: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload 8
    //   387: ifnull +56 -> 443
    //   390: aload 8
    //   392: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   395: goto +48 -> 443
    //   398: astore 7
    //   400: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   403: astore 8
    //   405: new 44	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   412: astore 9
    //   414: aload 9
    //   416: ldc 115
    //   418: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 9
    //   424: aload 7
    //   426: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 8
    //   435: aload 9
    //   437: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: aload_1
    //   444: invokevirtual 124	android/graphics/Bitmap:isRecycled	()Z
    //   447: ifne +143 -> 590
    //   450: goto -163 -> 287
    //   453: astore 9
    //   455: aload 11
    //   457: astore 8
    //   459: aload 8
    //   461: astore 7
    //   463: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   466: astore 10
    //   468: aload 8
    //   470: astore 7
    //   472: new 44	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   479: astore 11
    //   481: aload 8
    //   483: astore 7
    //   485: aload 11
    //   487: ldc 115
    //   489: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 8
    //   495: astore 7
    //   497: aload 11
    //   499: aload 9
    //   501: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   504: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 8
    //   510: astore 7
    //   512: aload 10
    //   514: aload 11
    //   516: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: aload 8
    //   524: ifnull +56 -> 580
    //   527: aload 8
    //   529: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   532: goto +48 -> 580
    //   535: astore 7
    //   537: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   540: astore 8
    //   542: new 44	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   549: astore 9
    //   551: aload 9
    //   553: ldc 115
    //   555: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 9
    //   561: aload 7
    //   563: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   566: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 8
    //   572: aload 9
    //   574: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload_1
    //   581: invokevirtual 124	android/graphics/Bitmap:isRecycled	()Z
    //   584: ifne +6 -> 590
    //   587: goto -300 -> 287
    //   590: aload_0
    //   591: aload 12
    //   593: aload 13
    //   595: iload 5
    //   597: iload 4
    //   599: invokestatic 133	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   602: iconst_0
    //   603: istore 6
    //   605: new 27	java/io/File
    //   608: dup
    //   609: aload 13
    //   611: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   614: astore_1
    //   615: aload_1
    //   616: invokevirtual 136	java/io/File:length	()J
    //   619: ldc2_w 137
    //   622: lcmp
    //   623: ifle +75 -> 698
    //   626: iload 6
    //   628: bipush 10
    //   630: if_icmpge +68 -> 698
    //   633: iload 5
    //   635: i2d
    //   636: dstore_2
    //   637: dload_2
    //   638: invokestatic 144	java/lang/Double:isNaN	(D)Z
    //   641: pop
    //   642: dload_2
    //   643: ldc2_w 145
    //   646: dmul
    //   647: d2i
    //   648: istore 5
    //   650: iload 4
    //   652: i2d
    //   653: dstore_2
    //   654: dload_2
    //   655: invokestatic 144	java/lang/Double:isNaN	(D)Z
    //   658: pop
    //   659: dload_2
    //   660: ldc2_w 145
    //   663: dmul
    //   664: d2i
    //   665: istore 4
    //   667: aload_0
    //   668: aload 12
    //   670: aload 13
    //   672: bipush 100
    //   674: iload 5
    //   676: invokestatic 152	java/lang/Math:max	(II)I
    //   679: bipush 100
    //   681: iload 4
    //   683: invokestatic 152	java/lang/Math:max	(II)I
    //   686: invokestatic 133	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V
    //   689: iload 6
    //   691: iconst_1
    //   692: iadd
    //   693: istore 6
    //   695: goto -90 -> 605
    //   698: aload_1
    //   699: invokevirtual 136	java/io/File:length	()J
    //   702: ldc2_w 137
    //   705: lcmp
    //   706: ifle +6 -> 712
    //   709: ldc 73
    //   711: areturn
    //   712: aload 13
    //   714: areturn
    //   715: aload 7
    //   717: ifnull +56 -> 773
    //   720: aload 7
    //   722: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   725: goto +48 -> 773
    //   728: astore 7
    //   730: getstatic 113	com/tencent/aelight/camera/ae/config/CameraPeakServiceHandler:d	Ljava/lang/String;
    //   733: astore 8
    //   735: new 44	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   742: astore 9
    //   744: aload 9
    //   746: ldc 115
    //   748: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 9
    //   754: aload 7
    //   756: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   759: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload 8
    //   765: aload 9
    //   767: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 121	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: aload_1
    //   774: invokevirtual 124	android/graphics/Bitmap:isRecycled	()Z
    //   777: ifne +7 -> 784
    //   780: aload_1
    //   781: invokevirtual 127	android/graphics/Bitmap:recycle	()V
    //   784: goto +5 -> 789
    //   787: aload_0
    //   788: athrow
    //   789: goto -2 -> 787
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	paramContext	android.content.Context
    //   0	792	1	paramBitmap	Bitmap
    //   636	24	2	d1	double
    //   153	529	4	i	int
    //   149	526	5	j	int
    //   143	551	6	k	int
    //   10	183	7	localFile	java.io.File
    //   235	27	7	localException1	java.lang.Exception
    //   297	77	7	localObject1	Object
    //   398	27	7	localException2	java.lang.Exception
    //   461	50	7	localObject2	Object
    //   535	186	7	localException3	java.lang.Exception
    //   728	27	7	localException4	java.lang.Exception
    //   33	731	8	localObject3	Object
    //   249	24	9	localStringBuilder1	StringBuilder
    //   302	1	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   307	1	9	localException5	java.lang.Exception
    //   316	47	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   412	24	9	localStringBuilder2	StringBuilder
    //   453	47	9	localException6	java.lang.Exception
    //   549	217	9	localStringBuilder3	StringBuilder
    //   186	327	10	str1	String
    //   189	326	11	localStringBuilder4	StringBuilder
    //   77	592	12	str2	String
    //   130	583	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   227	232	235	java/lang/Exception
    //   215	227	294	finally
    //   215	227	302	java/lang/OutOfMemoryError
    //   215	227	307	java/lang/Exception
    //   194	215	312	finally
    //   326	331	312	finally
    //   335	344	312	finally
    //   348	356	312	finally
    //   360	371	312	finally
    //   375	385	312	finally
    //   463	468	312	finally
    //   472	481	312	finally
    //   485	493	312	finally
    //   497	508	312	finally
    //   512	522	312	finally
    //   194	215	316	java/lang/OutOfMemoryError
    //   390	395	398	java/lang/Exception
    //   194	215	453	java/lang/Exception
    //   527	532	535	java/lang/Exception
    //   720	725	728	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (GetBulkImageClassifyRsp)paramObject;
    if (paramFromServiceMsg.isSuccess())
    {
      if ((localObject != null) && (((GetBulkImageClassifyRsp)localObject).MiltiRsps != null))
      {
        paramObject = new ArrayList();
        localObject = ((GetBulkImageClassifyRsp)localObject).MiltiRsps.iterator();
        while (((Iterator)localObject).hasNext())
        {
          SmartFilterRspItem localSmartFilterRspItem = (SmartFilterRspItem)((Iterator)localObject).next();
          paramObject.add(new AIFilterResponse(localSmartFilterRspItem.PituLabel, localSmartFilterRspItem.DisplayLabels));
        }
        AEEditorAIFilterManager.a().a(paramObject, paramToServiceMsg.hashCode());
      }
    }
    else if (1002 == paramFromServiceMsg.getResultCode()) {
      AEEditorAIFilterManager.a().a(-6, paramToServiceMsg.hashCode());
    } else {
      AEEditorAIFilterManager.a().a(-1, paramToServiceMsg.hashCode());
    }
    paramToServiceMsg = AEBaseDataReporter.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.b.containsKey("ShadowBackendSvc.GetBulkImageClassify")) {
      l1 = ((Long)this.b.get("ShadowBackendSvc.GetBulkImageClassify")).longValue();
    } else {
      l1 = 0L;
    }
    paramToServiceMsg.a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetBulkImageClassify", 0);
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
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    notifyUI(4, paramFromServiceMsg.isSuccess(), paramObject);
    if (!paramFromServiceMsg.isSuccess())
    {
      localObject = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFont fail: ");
      localStringBuilder.append(paramFromServiceMsg);
      QLog.e((String)localObject, 2, localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new CameraPeakServiceHandler.2(this));
    }
    paramObject = (GetFontDataRsp)paramObject;
    Object localObject = AEBaseDataReporter.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.b.containsKey("ShadowBackendSvc.GetFontData")) {
      l1 = ((Long)this.b.get("ShadowBackendSvc.GetFontData")).longValue();
    } else {
      l1 = 0L;
    }
    ((AEBaseDataReporter)localObject).a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetFontData", paramObject.Code);
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetImgValidStatusRsp)paramObject;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = paramObject.ValidStatus;
    } else {
      i = -2;
    }
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      int j = paramFromServiceMsg.getResultCode();
      long l2 = System.currentTimeMillis();
      long l1;
      if (this.b.containsKey("ShadowBackendSvc.GetImgValidStatus")) {
        l1 = ((Long)this.b.get("ShadowBackendSvc.GetImgValidStatus")).longValue();
      } else {
        l1 = 0L;
      }
      localAEBaseDataReporter.a(j, String.valueOf(l2 - l1), "ShadowBackendSvc.GetImgValidStatus", paramObject.Code);
    }
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(5, bool, Integer.valueOf(i));
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetOnlineUserNumRsp)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      notifyUI(3, true, Integer.valueOf(paramObject.OnlineUserNum));
    }
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    int i = paramFromServiceMsg.getResultCode();
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.b.containsKey("ShadowBackendSvc.GetOnlineUserNum")) {
      l1 = ((Long)this.b.get("ShadowBackendSvc.GetOnlineUserNum")).longValue();
    } else {
      l1 = 0L;
    }
    localAEBaseDataReporter.a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetOnlineUserNum", paramObject.Code);
  }
  
  private void f(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = new ArrayList();
    boolean bool = paramObject instanceof GetRecommandTextByEmotionRsp;
    String str = null;
    Object localObject1 = null;
    GetRecommandTextByEmotionRsp localGetRecommandTextByEmotionRsp;
    if (bool) {
      localGetRecommandTextByEmotionRsp = (GetRecommandTextByEmotionRsp)paramObject;
    } else {
      localGetRecommandTextByEmotionRsp = null;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (localGetRecommandTextByEmotionRsp != null))
    {
      localObject2 = localGetRecommandTextByEmotionRsp.RecTexts;
      str = localGetRecommandTextByEmotionRsp.Emo;
      paramObject = localGetRecommandTextByEmotionRsp.UiNumConfig;
      try
      {
        paramObject = new JSONObject(paramObject);
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        paramObject = localObject1;
      }
      bool = true;
      localObject1 = localObject2;
    }
    else
    {
      bool = false;
      paramObject = null;
      localObject1 = localObject2;
    }
    if ((paramFromServiceMsg != null) && (localGetRecommandTextByEmotionRsp != null))
    {
      localObject2 = AEBaseDataReporter.a();
      int i = paramFromServiceMsg.getResultCode();
      long l2 = System.currentTimeMillis();
      long l1;
      if (this.b.containsKey("ShadowBackendSvc.GetRecommandTextByEmotion")) {
        l1 = ((Long)this.b.get("ShadowBackendSvc.GetRecommandTextByEmotion")).longValue();
      } else {
        l1 = 0L;
      }
      ((AEBaseDataReporter)localObject2).a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetRecommandTextByEmotion", localGetRecommandTextByEmotionRsp.Code);
    }
    notifyUI(1, bool, new RecognizedEmotionBean(localObject1, str, paramObject));
  }
  
  private void g(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (GetTextValidStatusRsp)paramObject;
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = bool3;
      if (paramObject.ValidStatus == 0)
      {
        bool2 = true;
        bool1 = bool3;
      }
    }
    else
    {
      bool1 = false;
    }
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
      int i = paramFromServiceMsg.getResultCode();
      long l2 = System.currentTimeMillis();
      long l1;
      if (this.b.containsKey("ShadowBackendSvc.GetTextValidStatus")) {
        l1 = ((Long)this.b.get("ShadowBackendSvc.GetTextValidStatus")).longValue();
      } else {
        l1 = 0L;
      }
      localAEBaseDataReporter.a(i, String.valueOf(l2 - l1), "ShadowBackendSvc.GetTextValidStatus", paramObject.Code);
    }
    notifyUI(2, bool1, Boolean.valueOf(bool2));
  }
  
  private void h()
  {
    notifyUI(5, false, Integer.valueOf(-100));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
      f(null, null);
      return;
    }
    this.b.put("ShadowBackendSvc.GetRecommandTextByEmotion", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.c.getCurrentAccountUin(), "ShadowBackendSvc.GetRecommandTextByEmotion");
    if (paramBitmap != null)
    {
      Bundle localBundle = localToServiceMsg.extraData;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localBundle.putByteArray("Rawdata", localByteArrayOutputStream.toByteArray());
    }
    send(localToServiceMsg);
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList, AEEditorAIFilterManager.AIRequestCallback paramAIRequestCallback)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
      return;
    }
    this.b.put("ShadowBackendSvc.GetBulkImageClassify", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.c.getCurrentAccountUin(), "ShadowBackendSvc.GetBulkImageClassify");
    localToServiceMsg.extraData.putSerializable("AI_FILTER_REQ_PICS", paramArrayList);
    send(localToServiceMsg);
    if (paramAIRequestCallback != null) {
      paramAIRequestCallback.a(localToServiceMsg.hashCode());
    }
  }
  
  protected void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    super.b(paramFromServiceMsg, paramObject);
  }
  
  public void b(String paramString)
  {
    this.b.put("ShadowBackendSvc.GetImgValidStatus", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.c.getCurrentAccountUin(), "ShadowBackendSvc.GetImgValidStatus");
    paramString = SafeBitmapFactory.decodeFile(paramString);
    String str = AETakeFacePhotoPreviewFragment.getDetectFacePath();
    if ((str != null) && (str.length() > 0))
    {
      a(localToServiceMsg, str);
      return;
    }
    FaceChangeUtils.cropFace(paramString, new CameraPeakServiceHandler.1(this, localToServiceMsg));
  }
  
  public void c(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqTextValidStatus] no network....");
      g(null, null);
      return;
    }
    this.b.put("ShadowBackendSvc.GetTextValidStatus", Long.valueOf(System.currentTimeMillis()));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.c.getCurrentAccountUin(), "ShadowBackendSvc.GetTextValidStatus");
    localToServiceMsg.extraData.putString("EmoText", paramString);
    send(localToServiceMsg);
  }
  
  public void g()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      LogUtils.w("111", "[reqOnlineUserNum] no network....");
      return;
    }
    this.b.put("ShadowBackendSvc.GetOnlineUserNum", Long.valueOf(System.currentTimeMillis()));
    send(new ToServiceMsg("ShadowBackendSvc", this.c.getCurrentAccountUin(), "ShadowBackendSvc.GetOnlineUserNum"));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return CameraPeakServiceObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetRecommandTextByEmotion"))
    {
      f(paramFromServiceMsg, paramObject);
    }
    else if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetTextValidStatus"))
    {
      g(paramFromServiceMsg, paramObject);
    }
    else
    {
      if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetCameraConfig"))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetOnlineUserNum")) {
        e(paramFromServiceMsg, paramObject);
      } else if (paramFromServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetFontData")) {
        c(paramFromServiceMsg, paramObject);
      } else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetImgValidStatus")) {
        d(paramFromServiceMsg, paramObject);
      } else if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBulkImageClassify")) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    super.onReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler
 * JD-Core Version:    0.7.0.1
 */