import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.1;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.2;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.4;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class arcs
  extends arcn
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  
  public arcs(Intent paramIntent, arcx paramarcx)
  {
    this.jdField_a_of_type_Arcx = paramarcx;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf = ((FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf"));
  }
  
  private void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  /* Error */
  public int a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 73	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   10: aload_2
    //   11: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 80
    //   16: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore_1
    //   23: new 73	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   30: aload_2
    //   31: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 86
    //   36: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_2
    //   43: new 73	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   50: astore 8
    //   52: new 73	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   59: astore 9
    //   61: new 88	java/io/BufferedReader
    //   64: dup
    //   65: new 90	java/io/InputStreamReader
    //   68: dup
    //   69: new 92	java/io/FileInputStream
    //   72: dup
    //   73: new 94	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore_1
    //   91: new 88	java/io/BufferedReader
    //   94: dup
    //   95: new 90	java/io/InputStreamReader
    //   98: dup
    //   99: new 92	java/io/FileInputStream
    //   102: dup
    //   103: new 94	java/io/File
    //   106: dup
    //   107: aload_2
    //   108: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   114: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   117: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   120: astore_2
    //   121: aload_2
    //   122: astore 7
    //   124: aload_1
    //   125: astore 6
    //   127: aload_1
    //   128: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore 10
    //   133: aload 10
    //   135: ifnull +78 -> 213
    //   138: aload_2
    //   139: astore 7
    //   141: aload_1
    //   142: astore 6
    //   144: aload 8
    //   146: aload 10
    //   148: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: goto -31 -> 121
    //   155: astore 7
    //   157: aload_1
    //   158: astore 6
    //   160: aload_2
    //   161: astore_1
    //   162: aload 7
    //   164: astore_2
    //   165: ldc 111
    //   167: iconst_1
    //   168: new 73	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   175: ldc 113
    //   177: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_2
    //   181: invokevirtual 116	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 6
    //   195: ifnull +8 -> 203
    //   198: aload 6
    //   200: invokevirtual 125	java/io/BufferedReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 125	java/io/BufferedReader:close	()V
    //   211: iconst_1
    //   212: ireturn
    //   213: aload_2
    //   214: astore 7
    //   216: aload_1
    //   217: astore 6
    //   219: aload_2
    //   220: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 10
    //   225: aload 10
    //   227: ifnull +106 -> 333
    //   230: aload_2
    //   231: astore 7
    //   233: aload_1
    //   234: astore 6
    //   236: aload 9
    //   238: aload 10
    //   240: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: goto -31 -> 213
    //   247: astore 8
    //   249: aload_2
    //   250: astore 7
    //   252: aload_1
    //   253: astore 6
    //   255: ldc 111
    //   257: iconst_1
    //   258: new 73	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   265: ldc 127
    //   267: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 8
    //   272: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_1
    //   285: ifnull +7 -> 292
    //   288: aload_1
    //   289: invokevirtual 125	java/io/BufferedReader:close	()V
    //   292: aload_2
    //   293: ifnull -82 -> 211
    //   296: aload_2
    //   297: invokevirtual 125	java/io/BufferedReader:close	()V
    //   300: iconst_1
    //   301: ireturn
    //   302: astore_1
    //   303: ldc 111
    //   305: iconst_1
    //   306: new 73	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   313: ldc 130
    //   315: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iconst_1
    //   332: ireturn
    //   333: aload_2
    //   334: astore 7
    //   336: aload_1
    //   337: astore 6
    //   339: invokestatic 135	arcz:a	()Larcz;
    //   342: aload 8
    //   344: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: aload 9
    //   349: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 138	arcz:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: aload_2
    //   357: astore 7
    //   359: aload_1
    //   360: astore 6
    //   362: aload_0
    //   363: getfield 29	arcs:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   366: ifnull +371 -> 737
    //   369: aload_2
    //   370: astore 7
    //   372: aload_1
    //   373: astore 6
    //   375: aload_0
    //   376: getfield 29	arcs:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   379: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   382: ifnull +355 -> 737
    //   385: aload_2
    //   386: astore 7
    //   388: aload_1
    //   389: astore 6
    //   391: invokestatic 135	arcz:a	()Larcz;
    //   394: iconst_5
    //   395: invokevirtual 145	arcz:a	(I)Lorg/json/JSONObject;
    //   398: astore 8
    //   400: aload 8
    //   402: ifnonnull +98 -> 500
    //   405: aload_2
    //   406: astore 7
    //   408: aload_1
    //   409: astore 6
    //   411: ldc 111
    //   413: iconst_1
    //   414: ldc 147
    //   416: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 125	java/io/BufferedReader:close	()V
    //   427: aload_2
    //   428: ifnull -217 -> 211
    //   431: aload_2
    //   432: invokevirtual 125	java/io/BufferedReader:close	()V
    //   435: iconst_1
    //   436: ireturn
    //   437: astore_1
    //   438: ldc 111
    //   440: iconst_1
    //   441: new 73	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   448: ldc 130
    //   450: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   457: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iconst_1
    //   467: ireturn
    //   468: astore_1
    //   469: ldc 111
    //   471: iconst_1
    //   472: new 73	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   479: ldc 149
    //   481: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   488: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: goto -70 -> 427
    //   500: aload_2
    //   501: astore 7
    //   503: aload_1
    //   504: astore 6
    //   506: new 151	org/json/JSONArray
    //   509: dup
    //   510: invokespecial 152	org/json/JSONArray:<init>	()V
    //   513: astore 9
    //   515: aload_2
    //   516: astore 7
    //   518: aload_1
    //   519: astore 6
    //   521: aload_0
    //   522: getfield 29	arcs:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   525: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   528: astore 10
    //   530: aload_2
    //   531: astore 7
    //   533: aload_1
    //   534: astore 6
    //   536: aload 10
    //   538: arraylength
    //   539: istore 4
    //   541: iconst_0
    //   542: istore_3
    //   543: iload_3
    //   544: iload 4
    //   546: if_icmpge +26 -> 572
    //   549: aload_2
    //   550: astore 7
    //   552: aload_1
    //   553: astore 6
    //   555: aload 9
    //   557: aload 10
    //   559: iload_3
    //   560: iaload
    //   561: invokevirtual 156	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   564: pop
    //   565: iload_3
    //   566: iconst_1
    //   567: iadd
    //   568: istore_3
    //   569: goto -26 -> 543
    //   572: aload_2
    //   573: astore 7
    //   575: aload_1
    //   576: astore 6
    //   578: aload 8
    //   580: ldc 158
    //   582: aload 9
    //   584: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   587: pop
    //   588: aload_2
    //   589: astore 7
    //   591: aload_1
    //   592: astore 6
    //   594: aload 8
    //   596: ldc 165
    //   598: aload_0
    //   599: getfield 29	arcs:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   602: getfield 169	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   605: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   608: pop
    //   609: aload_2
    //   610: astore 7
    //   612: aload_1
    //   613: astore 6
    //   615: aload 8
    //   617: ldc 171
    //   619: invokevirtual 175	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   622: pop
    //   623: aload_2
    //   624: astore 7
    //   626: aload_1
    //   627: astore 6
    //   629: new 94	java/io/File
    //   632: dup
    //   633: aload 8
    //   635: ldc 177
    //   637: ldc 179
    //   639: invokevirtual 183	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   642: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   645: astore 9
    //   647: aload_2
    //   648: astore 7
    //   650: aload_1
    //   651: astore 6
    //   653: aload 9
    //   655: invokevirtual 187	java/io/File:getParentFile	()Ljava/io/File;
    //   658: astore 10
    //   660: aload 10
    //   662: ifnull +107 -> 769
    //   665: aload_2
    //   666: astore 7
    //   668: aload_1
    //   669: astore 6
    //   671: aload 10
    //   673: invokevirtual 191	java/io/File:exists	()Z
    //   676: ifne +93 -> 769
    //   679: aload_2
    //   680: astore 7
    //   682: aload_1
    //   683: astore 6
    //   685: aload 10
    //   687: invokevirtual 194	java/io/File:mkdirs	()Z
    //   690: istore 5
    //   692: iload 5
    //   694: ifne +17 -> 711
    //   697: aload_2
    //   698: astore 7
    //   700: aload_1
    //   701: astore 6
    //   703: aload 8
    //   705: ldc 177
    //   707: invokevirtual 175	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   710: pop
    //   711: aload_2
    //   712: astore 7
    //   714: aload_1
    //   715: astore 6
    //   717: aload 9
    //   719: invokevirtual 191	java/io/File:exists	()Z
    //   722: ifeq +15 -> 737
    //   725: aload_2
    //   726: astore 7
    //   728: aload_1
    //   729: astore 6
    //   731: aload 9
    //   733: invokevirtual 197	java/io/File:delete	()Z
    //   736: pop
    //   737: aload_2
    //   738: astore 7
    //   740: aload_1
    //   741: astore 6
    //   743: ldc 111
    //   745: iconst_1
    //   746: ldc 199
    //   748: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: aload_1
    //   752: ifnull +7 -> 759
    //   755: aload_1
    //   756: invokevirtual 125	java/io/BufferedReader:close	()V
    //   759: aload_2
    //   760: ifnull +7 -> 767
    //   763: aload_2
    //   764: invokevirtual 125	java/io/BufferedReader:close	()V
    //   767: iconst_0
    //   768: ireturn
    //   769: iconst_1
    //   770: istore 5
    //   772: goto -80 -> 692
    //   775: astore_1
    //   776: ldc 111
    //   778: iconst_1
    //   779: new 73	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   786: ldc 149
    //   788: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: aload_1
    //   792: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   795: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: goto -45 -> 759
    //   807: astore_1
    //   808: ldc 111
    //   810: iconst_1
    //   811: new 73	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   818: ldc 130
    //   820: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   827: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: goto -69 -> 767
    //   839: astore_2
    //   840: ldc 111
    //   842: iconst_1
    //   843: new 73	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   850: ldc 149
    //   852: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_2
    //   856: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   859: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: goto -665 -> 203
    //   871: astore_1
    //   872: ldc 111
    //   874: iconst_1
    //   875: new 73	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   882: ldc 130
    //   884: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload_1
    //   888: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   891: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   897: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: iconst_1
    //   901: ireturn
    //   902: astore_1
    //   903: ldc 111
    //   905: iconst_1
    //   906: new 73	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   913: ldc 149
    //   915: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_1
    //   919: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   922: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: goto -639 -> 292
    //   934: astore 8
    //   936: aconst_null
    //   937: astore_2
    //   938: aconst_null
    //   939: astore_1
    //   940: aload_2
    //   941: astore 7
    //   943: aload_1
    //   944: astore 6
    //   946: ldc 111
    //   948: iconst_1
    //   949: new 73	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   956: ldc 204
    //   958: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload 8
    //   963: invokevirtual 205	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   966: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: aload_1
    //   976: ifnull +7 -> 983
    //   979: aload_1
    //   980: invokevirtual 125	java/io/BufferedReader:close	()V
    //   983: aload_2
    //   984: ifnull -773 -> 211
    //   987: aload_2
    //   988: invokevirtual 125	java/io/BufferedReader:close	()V
    //   991: iconst_1
    //   992: ireturn
    //   993: astore_1
    //   994: ldc 111
    //   996: iconst_1
    //   997: new 73	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1004: ldc 130
    //   1006: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_1
    //   1010: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1013: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1022: iconst_1
    //   1023: ireturn
    //   1024: astore_1
    //   1025: ldc 111
    //   1027: iconst_1
    //   1028: new 73	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1035: ldc 149
    //   1037: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: aload_1
    //   1041: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1044: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1053: goto -70 -> 983
    //   1056: astore_2
    //   1057: aconst_null
    //   1058: astore 7
    //   1060: aconst_null
    //   1061: astore_1
    //   1062: aload_1
    //   1063: ifnull +7 -> 1070
    //   1066: aload_1
    //   1067: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1070: aload 7
    //   1072: ifnull +8 -> 1080
    //   1075: aload 7
    //   1077: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1080: aload_2
    //   1081: athrow
    //   1082: astore_1
    //   1083: ldc 111
    //   1085: iconst_1
    //   1086: new 73	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1093: ldc 149
    //   1095: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload_1
    //   1099: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1102: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1111: goto -41 -> 1070
    //   1114: astore_1
    //   1115: ldc 111
    //   1117: iconst_1
    //   1118: new 73	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1125: ldc 130
    //   1127: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload_1
    //   1131: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1134: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1143: goto -63 -> 1080
    //   1146: astore_2
    //   1147: aconst_null
    //   1148: astore 7
    //   1150: goto -88 -> 1062
    //   1153: astore_2
    //   1154: aload 6
    //   1156: astore_1
    //   1157: goto -95 -> 1062
    //   1160: astore_2
    //   1161: aload_1
    //   1162: astore 7
    //   1164: aload 6
    //   1166: astore_1
    //   1167: goto -105 -> 1062
    //   1170: astore 8
    //   1172: aconst_null
    //   1173: astore_2
    //   1174: goto -234 -> 940
    //   1177: astore 8
    //   1179: goto -239 -> 940
    //   1182: astore 8
    //   1184: aconst_null
    //   1185: astore_2
    //   1186: aconst_null
    //   1187: astore_1
    //   1188: goto -939 -> 249
    //   1191: astore 8
    //   1193: aconst_null
    //   1194: astore_2
    //   1195: goto -946 -> 249
    //   1198: astore_2
    //   1199: aconst_null
    //   1200: astore_1
    //   1201: goto -1036 -> 165
    //   1204: astore_2
    //   1205: aconst_null
    //   1206: astore 7
    //   1208: aload_1
    //   1209: astore 6
    //   1211: aload 7
    //   1213: astore_1
    //   1214: goto -1049 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1217	0	this	arcs
    //   0	1217	1	paramContext	android.content.Context
    //   0	1217	2	paramString	String
    //   542	27	3	i	int
    //   539	8	4	j	int
    //   690	81	5	bool	boolean
    //   1	1209	6	localContext	android.content.Context
    //   122	18	7	str	String
    //   155	8	7	localFileNotFoundException	java.io.FileNotFoundException
    //   214	998	7	localObject1	Object
    //   50	95	8	localStringBuilder	java.lang.StringBuilder
    //   247	96	8	localIOException1	java.io.IOException
    //   398	306	8	localJSONObject	JSONObject
    //   934	28	8	localJSONException1	org.json.JSONException
    //   1170	1	8	localJSONException2	org.json.JSONException
    //   1177	1	8	localJSONException3	org.json.JSONException
    //   1182	1	8	localIOException2	java.io.IOException
    //   1191	1	8	localIOException3	java.io.IOException
    //   59	673	9	localObject2	Object
    //   131	555	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   127	133	155	java/io/FileNotFoundException
    //   144	152	155	java/io/FileNotFoundException
    //   219	225	155	java/io/FileNotFoundException
    //   236	244	155	java/io/FileNotFoundException
    //   339	356	155	java/io/FileNotFoundException
    //   362	369	155	java/io/FileNotFoundException
    //   375	385	155	java/io/FileNotFoundException
    //   391	400	155	java/io/FileNotFoundException
    //   411	419	155	java/io/FileNotFoundException
    //   506	515	155	java/io/FileNotFoundException
    //   521	530	155	java/io/FileNotFoundException
    //   536	541	155	java/io/FileNotFoundException
    //   555	565	155	java/io/FileNotFoundException
    //   578	588	155	java/io/FileNotFoundException
    //   594	609	155	java/io/FileNotFoundException
    //   615	623	155	java/io/FileNotFoundException
    //   629	647	155	java/io/FileNotFoundException
    //   653	660	155	java/io/FileNotFoundException
    //   671	679	155	java/io/FileNotFoundException
    //   685	692	155	java/io/FileNotFoundException
    //   703	711	155	java/io/FileNotFoundException
    //   717	725	155	java/io/FileNotFoundException
    //   731	737	155	java/io/FileNotFoundException
    //   743	751	155	java/io/FileNotFoundException
    //   127	133	247	java/io/IOException
    //   144	152	247	java/io/IOException
    //   219	225	247	java/io/IOException
    //   236	244	247	java/io/IOException
    //   339	356	247	java/io/IOException
    //   362	369	247	java/io/IOException
    //   375	385	247	java/io/IOException
    //   391	400	247	java/io/IOException
    //   411	419	247	java/io/IOException
    //   506	515	247	java/io/IOException
    //   521	530	247	java/io/IOException
    //   536	541	247	java/io/IOException
    //   555	565	247	java/io/IOException
    //   578	588	247	java/io/IOException
    //   594	609	247	java/io/IOException
    //   615	623	247	java/io/IOException
    //   629	647	247	java/io/IOException
    //   653	660	247	java/io/IOException
    //   671	679	247	java/io/IOException
    //   685	692	247	java/io/IOException
    //   703	711	247	java/io/IOException
    //   717	725	247	java/io/IOException
    //   731	737	247	java/io/IOException
    //   743	751	247	java/io/IOException
    //   296	300	302	java/io/IOException
    //   431	435	437	java/io/IOException
    //   423	427	468	java/io/IOException
    //   755	759	775	java/io/IOException
    //   763	767	807	java/io/IOException
    //   198	203	839	java/io/IOException
    //   207	211	871	java/io/IOException
    //   288	292	902	java/io/IOException
    //   61	91	934	org/json/JSONException
    //   987	991	993	java/io/IOException
    //   979	983	1024	java/io/IOException
    //   61	91	1056	finally
    //   1066	1070	1082	java/io/IOException
    //   1075	1080	1114	java/io/IOException
    //   91	121	1146	finally
    //   127	133	1153	finally
    //   144	152	1153	finally
    //   219	225	1153	finally
    //   236	244	1153	finally
    //   255	284	1153	finally
    //   339	356	1153	finally
    //   362	369	1153	finally
    //   375	385	1153	finally
    //   391	400	1153	finally
    //   411	419	1153	finally
    //   506	515	1153	finally
    //   521	530	1153	finally
    //   536	541	1153	finally
    //   555	565	1153	finally
    //   578	588	1153	finally
    //   594	609	1153	finally
    //   615	623	1153	finally
    //   629	647	1153	finally
    //   653	660	1153	finally
    //   671	679	1153	finally
    //   685	692	1153	finally
    //   703	711	1153	finally
    //   717	725	1153	finally
    //   731	737	1153	finally
    //   743	751	1153	finally
    //   946	975	1153	finally
    //   165	193	1160	finally
    //   91	121	1170	org/json/JSONException
    //   127	133	1177	org/json/JSONException
    //   144	152	1177	org/json/JSONException
    //   219	225	1177	org/json/JSONException
    //   236	244	1177	org/json/JSONException
    //   339	356	1177	org/json/JSONException
    //   362	369	1177	org/json/JSONException
    //   375	385	1177	org/json/JSONException
    //   391	400	1177	org/json/JSONException
    //   411	419	1177	org/json/JSONException
    //   506	515	1177	org/json/JSONException
    //   521	530	1177	org/json/JSONException
    //   536	541	1177	org/json/JSONException
    //   555	565	1177	org/json/JSONException
    //   578	588	1177	org/json/JSONException
    //   594	609	1177	org/json/JSONException
    //   615	623	1177	org/json/JSONException
    //   629	647	1177	org/json/JSONException
    //   653	660	1177	org/json/JSONException
    //   671	679	1177	org/json/JSONException
    //   685	692	1177	org/json/JSONException
    //   703	711	1177	org/json/JSONException
    //   717	725	1177	org/json/JSONException
    //   731	737	1177	org/json/JSONException
    //   743	751	1177	org/json/JSONException
    //   61	91	1182	java/io/IOException
    //   91	121	1191	java/io/IOException
    //   61	91	1198	java/io/FileNotFoundException
    //   91	121	1204	java/io/FileNotFoundException
  }
  
  public void a()
  {
    super.a();
    YtSDKKitFramework.getInstance().deInit();
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    int i;
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new IdentificationPoseReflect.1(this, paramActivity));
      localObject = axhp.a().jdField_a_of_type_AndroidHardwareCamera;
      i = axhp.a().jdField_a_of_type_Int;
      int j = YTCameraSetting.initCamera(paramActivity.getApplicationContext(), (Camera)localObject, i);
      QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera result : ", Integer.valueOf(j) });
      if (j == 0) {
        break label114;
      }
      new HashMap().put("process_action", "failed");
      if ((paramActivity instanceof QQIdentiferActivity)) {
        a(new IdentificationPoseReflect.2(this, paramActivity));
      }
    }
    return;
    label114:
    YtSDKKitFramework.YtSDKPlatformContex localYtSDKPlatformContex = YtSDKKitFramework.getInstance().getPlatformContext();
    localYtSDKPlatformContex.currentCamera = ((Camera)localObject);
    localYtSDKPlatformContex.currentCameraId = i;
    localYtSDKPlatformContex.currentRotateState = YTCameraSetting.getRotate(BaseApplicationImpl.getApplication(), i, 1);
    localYtSDKPlatformContex.reflectLayout = null;
    localYtSDKPlatformContex.reflectListener = new arct(this);
    localYtSDKPlatformContex.currentAppContex = paramActivity.getApplicationContext();
    Object localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
    JSONObject localJSONObject = arcz.a().a(5);
    ArrayList localArrayList = YtSDKKitConfigHelper.getPipleStateNames((YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject);
    if ((localArrayList == null) || (localJSONObject == null))
    {
      if ((paramActivity instanceof QQIdentiferActivity)) {
        a(new IdentificationPoseReflect.4(this, paramActivity));
      }
      QLog.e("qq_Identification.Model", 1, "initSdkResult stateNames == null || sdkConfig == null");
      return;
    }
    QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContex, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new arcu(this))) });
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("qq_Identification.Model", 1, "initLoadSo error : so path is empty");
      return false;
    }
    try
    {
      if (new File(paramString).exists())
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          System.load(paramString + str);
          i += 1;
        }
        QLog.d("qq_Identification.Model", 1, "init load so success");
        return true;
      }
      QLog.e("qq_Identification.Model", 1, "init load so, soDir is not exists");
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so Exception : " + paramString.getMessage());
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      QLog.e("qq_Identification.Model", 1, "System.load so UnsatisfiedLinkError : " + paramString.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcs
 * JD-Core Version:    0.7.0.1
 */