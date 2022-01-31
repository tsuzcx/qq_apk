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

public class asti
  extends astd
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  
  public asti(Intent paramIntent, astn paramastn)
  {
    this.jdField_a_of_type_Astn = paramastn;
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
    //   1: astore 7
    //   3: new 73	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   10: aload_2
    //   11: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 80
    //   16: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 6
    //   24: new 73	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   31: aload_2
    //   32: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 86
    //   37: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 8
    //   45: new 73	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   52: astore 9
    //   54: new 73	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   61: astore 10
    //   63: new 88	java/io/BufferedReader
    //   66: dup
    //   67: new 90	java/io/InputStreamReader
    //   70: dup
    //   71: new 92	java/io/FileInputStream
    //   74: dup
    //   75: new 94	java/io/File
    //   78: dup
    //   79: aload 6
    //   81: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   90: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   93: astore_2
    //   94: new 88	java/io/BufferedReader
    //   97: dup
    //   98: new 90	java/io/InputStreamReader
    //   101: dup
    //   102: new 92	java/io/FileInputStream
    //   105: dup
    //   106: new 94	java/io/File
    //   109: dup
    //   110: aload 8
    //   112: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   121: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore 6
    //   126: aload 6
    //   128: astore 8
    //   130: aload_2
    //   131: astore 7
    //   133: aload_2
    //   134: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   137: astore 11
    //   139: aload 11
    //   141: ifnull +76 -> 217
    //   144: aload 6
    //   146: astore 8
    //   148: aload_2
    //   149: astore 7
    //   151: aload 9
    //   153: aload 11
    //   155: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: goto -33 -> 126
    //   162: astore 7
    //   164: aload_2
    //   165: astore_1
    //   166: aload 7
    //   168: astore_2
    //   169: ldc 111
    //   171: iconst_1
    //   172: new 73	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   179: ldc 113
    //   181: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 116	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 125	java/io/BufferedReader:close	()V
    //   205: aload 6
    //   207: ifnull +8 -> 215
    //   210: aload 6
    //   212: invokevirtual 125	java/io/BufferedReader:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: aload 6
    //   219: astore 8
    //   221: aload_2
    //   222: astore 7
    //   224: aload 6
    //   226: invokevirtual 109	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore 11
    //   231: aload 11
    //   233: ifnull +108 -> 341
    //   236: aload 6
    //   238: astore 8
    //   240: aload_2
    //   241: astore 7
    //   243: aload 10
    //   245: aload 11
    //   247: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: goto -34 -> 217
    //   254: astore_1
    //   255: aload 6
    //   257: astore 8
    //   259: aload_2
    //   260: astore 7
    //   262: ldc 111
    //   264: iconst_1
    //   265: new 73	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   272: ldc 127
    //   274: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_2
    //   291: ifnull +7 -> 298
    //   294: aload_2
    //   295: invokevirtual 125	java/io/BufferedReader:close	()V
    //   298: aload 6
    //   300: ifnull -85 -> 215
    //   303: aload 6
    //   305: invokevirtual 125	java/io/BufferedReader:close	()V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore_1
    //   311: ldc 111
    //   313: iconst_1
    //   314: new 73	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   321: ldc 130
    //   323: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: iconst_1
    //   340: ireturn
    //   341: aload 6
    //   343: astore 8
    //   345: aload_2
    //   346: astore 7
    //   348: invokestatic 135	astp:a	()Lastp;
    //   351: aload 9
    //   353: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 10
    //   358: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokevirtual 138	astp:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: aload 6
    //   367: astore 8
    //   369: aload_2
    //   370: astore 7
    //   372: aload_0
    //   373: getfield 29	asti:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   376: ifnull +540 -> 916
    //   379: aload 6
    //   381: astore 8
    //   383: aload_2
    //   384: astore 7
    //   386: aload_0
    //   387: getfield 29	asti:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   390: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   393: ifnull +523 -> 916
    //   396: aload 6
    //   398: astore 8
    //   400: aload_2
    //   401: astore 7
    //   403: invokestatic 135	astp:a	()Lastp;
    //   406: iconst_5
    //   407: invokevirtual 145	astp:a	(I)Lorg/json/JSONObject;
    //   410: astore 9
    //   412: aload 9
    //   414: ifnonnull +101 -> 515
    //   417: aload 6
    //   419: astore 8
    //   421: aload_2
    //   422: astore 7
    //   424: ldc 111
    //   426: iconst_1
    //   427: ldc 147
    //   429: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_2
    //   433: ifnull +7 -> 440
    //   436: aload_2
    //   437: invokevirtual 125	java/io/BufferedReader:close	()V
    //   440: aload 6
    //   442: ifnull -227 -> 215
    //   445: aload 6
    //   447: invokevirtual 125	java/io/BufferedReader:close	()V
    //   450: iconst_1
    //   451: ireturn
    //   452: astore_1
    //   453: ldc 111
    //   455: iconst_1
    //   456: new 73	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   463: ldc 130
    //   465: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   472: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: iconst_1
    //   482: ireturn
    //   483: astore_1
    //   484: ldc 111
    //   486: iconst_1
    //   487: new 73	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   494: ldc 149
    //   496: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   503: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: goto -72 -> 440
    //   515: aload 6
    //   517: astore 8
    //   519: aload_2
    //   520: astore 7
    //   522: new 151	org/json/JSONArray
    //   525: dup
    //   526: invokespecial 152	org/json/JSONArray:<init>	()V
    //   529: astore 10
    //   531: aload 6
    //   533: astore 8
    //   535: aload_2
    //   536: astore 7
    //   538: aload_0
    //   539: getfield 29	asti:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   542: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   545: astore 11
    //   547: aload 6
    //   549: astore 8
    //   551: aload_2
    //   552: astore 7
    //   554: aload 11
    //   556: arraylength
    //   557: istore 4
    //   559: iconst_0
    //   560: istore_3
    //   561: iload_3
    //   562: iload 4
    //   564: if_icmpge +27 -> 591
    //   567: aload 6
    //   569: astore 8
    //   571: aload_2
    //   572: astore 7
    //   574: aload 10
    //   576: aload 11
    //   578: iload_3
    //   579: iaload
    //   580: invokevirtual 156	org/json/JSONArray:put	(I)Lorg/json/JSONArray;
    //   583: pop
    //   584: iload_3
    //   585: iconst_1
    //   586: iadd
    //   587: istore_3
    //   588: goto -27 -> 561
    //   591: aload 6
    //   593: astore 8
    //   595: aload_2
    //   596: astore 7
    //   598: aload 9
    //   600: ldc 158
    //   602: aload 10
    //   604: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   607: pop
    //   608: aload 6
    //   610: astore 8
    //   612: aload_2
    //   613: astore 7
    //   615: aload 9
    //   617: ldc 165
    //   619: aload_0
    //   620: getfield 29	asti:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   623: getfield 169	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   626: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload 6
    //   632: astore 8
    //   634: aload_2
    //   635: astore 7
    //   637: aload 9
    //   639: ldc 171
    //   641: invokevirtual 175	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   644: pop
    //   645: aload 6
    //   647: astore 8
    //   649: aload_2
    //   650: astore 7
    //   652: aload_1
    //   653: invokevirtual 181	android/content/Context:getFilesDir	()Ljava/io/File;
    //   656: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   659: astore_1
    //   660: aload 6
    //   662: astore 8
    //   664: aload_2
    //   665: astore 7
    //   667: aload 9
    //   669: ldc 186
    //   671: new 73	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   678: aload_1
    //   679: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 188
    //   684: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   693: pop
    //   694: aload 6
    //   696: astore 8
    //   698: aload_2
    //   699: astore 7
    //   701: aload 9
    //   703: ldc 190
    //   705: new 73	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   712: aload_1
    //   713: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: ldc 192
    //   718: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 6
    //   730: astore 8
    //   732: aload_2
    //   733: astore 7
    //   735: ldc 111
    //   737: iconst_1
    //   738: iconst_4
    //   739: anewarray 194	java/lang/Object
    //   742: dup
    //   743: iconst_0
    //   744: ldc 196
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: new 73	java/lang/StringBuilder
    //   752: dup
    //   753: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   756: aload_1
    //   757: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: ldc 188
    //   762: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: aastore
    //   769: dup
    //   770: iconst_2
    //   771: ldc 198
    //   773: aastore
    //   774: dup
    //   775: iconst_3
    //   776: new 73	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   783: aload_1
    //   784: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc 192
    //   789: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: aastore
    //   796: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   799: aload 6
    //   801: astore 8
    //   803: aload_2
    //   804: astore 7
    //   806: new 94	java/io/File
    //   809: dup
    //   810: aload 9
    //   812: ldc 186
    //   814: ldc 204
    //   816: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   819: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   822: astore_1
    //   823: aload 6
    //   825: astore 8
    //   827: aload_2
    //   828: astore 7
    //   830: aload_1
    //   831: invokevirtual 211	java/io/File:getParentFile	()Ljava/io/File;
    //   834: astore 10
    //   836: aload 10
    //   838: ifnull +113 -> 951
    //   841: aload 6
    //   843: astore 8
    //   845: aload_2
    //   846: astore 7
    //   848: aload 10
    //   850: invokevirtual 215	java/io/File:exists	()Z
    //   853: ifne +98 -> 951
    //   856: aload 6
    //   858: astore 8
    //   860: aload_2
    //   861: astore 7
    //   863: aload 10
    //   865: invokevirtual 218	java/io/File:mkdirs	()Z
    //   868: istore 5
    //   870: iload 5
    //   872: ifne +18 -> 890
    //   875: aload 6
    //   877: astore 8
    //   879: aload_2
    //   880: astore 7
    //   882: aload 9
    //   884: ldc 186
    //   886: invokevirtual 175	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   889: pop
    //   890: aload 6
    //   892: astore 8
    //   894: aload_2
    //   895: astore 7
    //   897: aload_1
    //   898: invokevirtual 215	java/io/File:exists	()Z
    //   901: ifeq +15 -> 916
    //   904: aload 6
    //   906: astore 8
    //   908: aload_2
    //   909: astore 7
    //   911: aload_1
    //   912: invokevirtual 221	java/io/File:delete	()Z
    //   915: pop
    //   916: aload 6
    //   918: astore 8
    //   920: aload_2
    //   921: astore 7
    //   923: ldc 111
    //   925: iconst_1
    //   926: ldc 223
    //   928: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: aload_2
    //   932: ifnull +7 -> 939
    //   935: aload_2
    //   936: invokevirtual 125	java/io/BufferedReader:close	()V
    //   939: aload 6
    //   941: ifnull +8 -> 949
    //   944: aload 6
    //   946: invokevirtual 125	java/io/BufferedReader:close	()V
    //   949: iconst_0
    //   950: ireturn
    //   951: iconst_1
    //   952: istore 5
    //   954: goto -84 -> 870
    //   957: astore_1
    //   958: ldc 111
    //   960: iconst_1
    //   961: new 73	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   968: ldc 149
    //   970: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload_1
    //   974: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   977: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: goto -47 -> 939
    //   989: astore_1
    //   990: ldc 111
    //   992: iconst_1
    //   993: new 73	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1000: ldc 130
    //   1002: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: aload_1
    //   1006: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1009: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1015: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1018: goto -69 -> 949
    //   1021: astore_1
    //   1022: ldc 111
    //   1024: iconst_1
    //   1025: new 73	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1032: ldc 149
    //   1034: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_1
    //   1038: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1041: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1050: goto -845 -> 205
    //   1053: astore_1
    //   1054: ldc 111
    //   1056: iconst_1
    //   1057: new 73	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1064: ldc 130
    //   1066: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload_1
    //   1070: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1073: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: iconst_1
    //   1083: ireturn
    //   1084: astore_1
    //   1085: ldc 111
    //   1087: iconst_1
    //   1088: new 73	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1095: ldc 149
    //   1097: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: aload_1
    //   1101: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1104: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1113: goto -815 -> 298
    //   1116: astore_1
    //   1117: aconst_null
    //   1118: astore 6
    //   1120: aconst_null
    //   1121: astore_2
    //   1122: aload 6
    //   1124: astore 8
    //   1126: aload_2
    //   1127: astore 7
    //   1129: ldc 111
    //   1131: iconst_1
    //   1132: new 73	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1139: ldc 227
    //   1141: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload_1
    //   1145: invokevirtual 228	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1148: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1157: aload_2
    //   1158: ifnull +7 -> 1165
    //   1161: aload_2
    //   1162: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1165: aload 6
    //   1167: ifnull -952 -> 215
    //   1170: aload 6
    //   1172: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1175: iconst_1
    //   1176: ireturn
    //   1177: astore_1
    //   1178: ldc 111
    //   1180: iconst_1
    //   1181: new 73	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1188: ldc 130
    //   1190: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload_1
    //   1194: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1197: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1206: iconst_1
    //   1207: ireturn
    //   1208: astore_1
    //   1209: ldc 111
    //   1211: iconst_1
    //   1212: new 73	java/lang/StringBuilder
    //   1215: dup
    //   1216: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1219: ldc 149
    //   1221: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: aload_1
    //   1225: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1228: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1237: goto -72 -> 1165
    //   1240: astore_1
    //   1241: aconst_null
    //   1242: astore 6
    //   1244: aconst_null
    //   1245: astore_2
    //   1246: aload_2
    //   1247: ifnull +7 -> 1254
    //   1250: aload_2
    //   1251: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1254: aload 6
    //   1256: ifnull +8 -> 1264
    //   1259: aload 6
    //   1261: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1264: aload_1
    //   1265: athrow
    //   1266: astore_2
    //   1267: ldc 111
    //   1269: iconst_1
    //   1270: new 73	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1277: ldc 149
    //   1279: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: aload_2
    //   1283: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1286: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1292: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1295: goto -41 -> 1254
    //   1298: astore_2
    //   1299: ldc 111
    //   1301: iconst_1
    //   1302: new 73	java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1309: ldc 130
    //   1311: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_2
    //   1315: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1318: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: goto -63 -> 1264
    //   1330: astore_1
    //   1331: aconst_null
    //   1332: astore 6
    //   1334: goto -88 -> 1246
    //   1337: astore_1
    //   1338: aload 8
    //   1340: astore 6
    //   1342: aload 7
    //   1344: astore_2
    //   1345: goto -99 -> 1246
    //   1348: astore 7
    //   1350: aload_1
    //   1351: astore_2
    //   1352: aload 7
    //   1354: astore_1
    //   1355: goto -109 -> 1246
    //   1358: astore_1
    //   1359: aconst_null
    //   1360: astore 6
    //   1362: goto -240 -> 1122
    //   1365: astore_1
    //   1366: goto -244 -> 1122
    //   1369: astore_1
    //   1370: aconst_null
    //   1371: astore 6
    //   1373: aconst_null
    //   1374: astore_2
    //   1375: goto -1120 -> 255
    //   1378: astore_1
    //   1379: aconst_null
    //   1380: astore 6
    //   1382: goto -1127 -> 255
    //   1385: astore_2
    //   1386: aconst_null
    //   1387: astore 6
    //   1389: aload 7
    //   1391: astore_1
    //   1392: goto -1223 -> 169
    //   1395: astore 7
    //   1397: aconst_null
    //   1398: astore 6
    //   1400: aload_2
    //   1401: astore_1
    //   1402: aload 7
    //   1404: astore_2
    //   1405: goto -1236 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1408	0	this	asti
    //   0	1408	1	paramContext	android.content.Context
    //   0	1408	2	paramString	String
    //   560	28	3	i	int
    //   557	8	4	j	int
    //   868	85	5	bool	boolean
    //   22	1377	6	localObject1	Object
    //   1	149	7	str1	String
    //   162	5	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   222	1121	7	str2	String
    //   1348	42	7	localObject2	Object
    //   1395	8	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   43	1296	8	localObject3	Object
    //   52	831	9	localObject4	Object
    //   61	803	10	localObject5	Object
    //   137	440	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   133	139	162	java/io/FileNotFoundException
    //   151	159	162	java/io/FileNotFoundException
    //   224	231	162	java/io/FileNotFoundException
    //   243	251	162	java/io/FileNotFoundException
    //   348	365	162	java/io/FileNotFoundException
    //   372	379	162	java/io/FileNotFoundException
    //   386	396	162	java/io/FileNotFoundException
    //   403	412	162	java/io/FileNotFoundException
    //   424	432	162	java/io/FileNotFoundException
    //   522	531	162	java/io/FileNotFoundException
    //   538	547	162	java/io/FileNotFoundException
    //   554	559	162	java/io/FileNotFoundException
    //   574	584	162	java/io/FileNotFoundException
    //   598	608	162	java/io/FileNotFoundException
    //   615	630	162	java/io/FileNotFoundException
    //   637	645	162	java/io/FileNotFoundException
    //   652	660	162	java/io/FileNotFoundException
    //   667	694	162	java/io/FileNotFoundException
    //   701	728	162	java/io/FileNotFoundException
    //   735	799	162	java/io/FileNotFoundException
    //   806	823	162	java/io/FileNotFoundException
    //   830	836	162	java/io/FileNotFoundException
    //   848	856	162	java/io/FileNotFoundException
    //   863	870	162	java/io/FileNotFoundException
    //   882	890	162	java/io/FileNotFoundException
    //   897	904	162	java/io/FileNotFoundException
    //   911	916	162	java/io/FileNotFoundException
    //   923	931	162	java/io/FileNotFoundException
    //   133	139	254	java/io/IOException
    //   151	159	254	java/io/IOException
    //   224	231	254	java/io/IOException
    //   243	251	254	java/io/IOException
    //   348	365	254	java/io/IOException
    //   372	379	254	java/io/IOException
    //   386	396	254	java/io/IOException
    //   403	412	254	java/io/IOException
    //   424	432	254	java/io/IOException
    //   522	531	254	java/io/IOException
    //   538	547	254	java/io/IOException
    //   554	559	254	java/io/IOException
    //   574	584	254	java/io/IOException
    //   598	608	254	java/io/IOException
    //   615	630	254	java/io/IOException
    //   637	645	254	java/io/IOException
    //   652	660	254	java/io/IOException
    //   667	694	254	java/io/IOException
    //   701	728	254	java/io/IOException
    //   735	799	254	java/io/IOException
    //   806	823	254	java/io/IOException
    //   830	836	254	java/io/IOException
    //   848	856	254	java/io/IOException
    //   863	870	254	java/io/IOException
    //   882	890	254	java/io/IOException
    //   897	904	254	java/io/IOException
    //   911	916	254	java/io/IOException
    //   923	931	254	java/io/IOException
    //   303	308	310	java/io/IOException
    //   445	450	452	java/io/IOException
    //   436	440	483	java/io/IOException
    //   935	939	957	java/io/IOException
    //   944	949	989	java/io/IOException
    //   201	205	1021	java/io/IOException
    //   210	215	1053	java/io/IOException
    //   294	298	1084	java/io/IOException
    //   63	94	1116	org/json/JSONException
    //   1170	1175	1177	java/io/IOException
    //   1161	1165	1208	java/io/IOException
    //   63	94	1240	finally
    //   1250	1254	1266	java/io/IOException
    //   1259	1264	1298	java/io/IOException
    //   94	126	1330	finally
    //   133	139	1337	finally
    //   151	159	1337	finally
    //   224	231	1337	finally
    //   243	251	1337	finally
    //   262	290	1337	finally
    //   348	365	1337	finally
    //   372	379	1337	finally
    //   386	396	1337	finally
    //   403	412	1337	finally
    //   424	432	1337	finally
    //   522	531	1337	finally
    //   538	547	1337	finally
    //   554	559	1337	finally
    //   574	584	1337	finally
    //   598	608	1337	finally
    //   615	630	1337	finally
    //   637	645	1337	finally
    //   652	660	1337	finally
    //   667	694	1337	finally
    //   701	728	1337	finally
    //   735	799	1337	finally
    //   806	823	1337	finally
    //   830	836	1337	finally
    //   848	856	1337	finally
    //   863	870	1337	finally
    //   882	890	1337	finally
    //   897	904	1337	finally
    //   911	916	1337	finally
    //   923	931	1337	finally
    //   1129	1157	1337	finally
    //   169	197	1348	finally
    //   94	126	1358	org/json/JSONException
    //   133	139	1365	org/json/JSONException
    //   151	159	1365	org/json/JSONException
    //   224	231	1365	org/json/JSONException
    //   243	251	1365	org/json/JSONException
    //   348	365	1365	org/json/JSONException
    //   372	379	1365	org/json/JSONException
    //   386	396	1365	org/json/JSONException
    //   403	412	1365	org/json/JSONException
    //   424	432	1365	org/json/JSONException
    //   522	531	1365	org/json/JSONException
    //   538	547	1365	org/json/JSONException
    //   554	559	1365	org/json/JSONException
    //   574	584	1365	org/json/JSONException
    //   598	608	1365	org/json/JSONException
    //   615	630	1365	org/json/JSONException
    //   637	645	1365	org/json/JSONException
    //   652	660	1365	org/json/JSONException
    //   667	694	1365	org/json/JSONException
    //   701	728	1365	org/json/JSONException
    //   735	799	1365	org/json/JSONException
    //   806	823	1365	org/json/JSONException
    //   830	836	1365	org/json/JSONException
    //   848	856	1365	org/json/JSONException
    //   863	870	1365	org/json/JSONException
    //   882	890	1365	org/json/JSONException
    //   897	904	1365	org/json/JSONException
    //   911	916	1365	org/json/JSONException
    //   923	931	1365	org/json/JSONException
    //   63	94	1369	java/io/IOException
    //   94	126	1378	java/io/IOException
    //   63	94	1385	java/io/FileNotFoundException
    //   94	126	1395	java/io/FileNotFoundException
  }
  
  public void a()
  {
    super.a();
    YtSDKKitFramework.getInstance().deInit();
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    Object localObject;
    int k;
    int i;
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new IdentificationPoseReflect.1(this, paramActivity));
      localObject = azcx.a().jdField_a_of_type_AndroidHardwareCamera;
      k = azcx.a().jdField_a_of_type_Int;
      i = -1;
    }
    try
    {
      int j = YTCameraSetting.initCamera(paramActivity.getApplicationContext(), (Camera)localObject, k);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera error : ", localException.getMessage() });
      }
      YtSDKKitFramework.YtSDKPlatformContex localYtSDKPlatformContex = YtSDKKitFramework.getInstance().getPlatformContext();
      localYtSDKPlatformContex.currentCamera = ((Camera)localObject);
      localYtSDKPlatformContex.currentCameraId = k;
      localYtSDKPlatformContex.currentRotateState = YTCameraSetting.getRotate(BaseApplicationImpl.getApplication(), k, 1);
      localYtSDKPlatformContex.reflectLayout = null;
      localYtSDKPlatformContex.reflectListener = new astj(this);
      localYtSDKPlatformContex.currentAppContex = paramActivity.getApplicationContext();
      localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
      JSONObject localJSONObject = astp.a().a(5);
      ArrayList localArrayList = YtSDKKitConfigHelper.getPipleStateNames((YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject);
      if ((localArrayList != null) && (localJSONObject != null)) {
        break label273;
      }
      if (!(paramActivity instanceof QQIdentiferActivity)) {
        break label263;
      }
      a(new IdentificationPoseReflect.4(this, paramActivity));
      QLog.e("qq_Identification.Model", 1, "initSdkResult stateNames == null || sdkConfig == null");
      return;
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContex, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new astk(this))) });
    }
    QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera result : ", Integer.valueOf(i) });
    if (i != 0)
    {
      new HashMap().put("process_action", "failed");
      if ((paramActivity instanceof QQIdentiferActivity)) {
        a(new IdentificationPoseReflect.2(this, paramActivity));
      }
      return;
    }
    label263:
    label273:
    return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asti
 * JD-Core Version:    0.7.0.1
 */