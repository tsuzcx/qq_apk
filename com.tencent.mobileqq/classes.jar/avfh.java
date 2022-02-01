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

public class avfh
  extends avfa
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  
  public avfh(Intent paramIntent, avfm paramavfm)
  {
    this.jdField_a_of_type_Avfm = paramavfm;
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
    //   348: invokestatic 135	avfq:a	()Lavfq;
    //   351: aload 9
    //   353: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 10
    //   358: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokevirtual 138	avfq:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: aload 6
    //   367: astore 8
    //   369: aload_2
    //   370: astore 7
    //   372: aload_0
    //   373: getfield 29	avfh:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   376: ifnull +564 -> 940
    //   379: aload 6
    //   381: astore 8
    //   383: aload_2
    //   384: astore 7
    //   386: aload_0
    //   387: getfield 29	avfh:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   390: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   393: ifnull +547 -> 940
    //   396: aload 6
    //   398: astore 8
    //   400: aload_2
    //   401: astore 7
    //   403: invokestatic 135	avfq:a	()Lavfq;
    //   406: iconst_5
    //   407: invokevirtual 145	avfq:a	(I)Lorg/json/JSONObject;
    //   410: astore 10
    //   412: aload 10
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
    //   529: astore 9
    //   531: aload 6
    //   533: astore 8
    //   535: aload_2
    //   536: astore 7
    //   538: aload_0
    //   539: getfield 29	avfh:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
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
    //   574: aload 9
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
    //   598: aload 10
    //   600: ldc 158
    //   602: aload 9
    //   604: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   607: pop
    //   608: aload 6
    //   610: astore 8
    //   612: aload_2
    //   613: astore 7
    //   615: aload 10
    //   617: ldc 165
    //   619: aload_0
    //   620: getfield 29	avfh:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   623: getfield 169	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   626: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload 6
    //   632: astore 8
    //   634: aload_2
    //   635: astore 7
    //   637: aload 10
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
    //   659: astore 11
    //   661: aload 6
    //   663: astore 8
    //   665: aload_2
    //   666: astore 7
    //   668: getstatic 190	bnpt:b	Lbnpt;
    //   671: invokestatic 195	bnpy:a	(Lbnpt;)Ljava/lang/String;
    //   674: astore 9
    //   676: aload 9
    //   678: astore_1
    //   679: aload 6
    //   681: astore 8
    //   683: aload_2
    //   684: astore 7
    //   686: aload 9
    //   688: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   691: invokevirtual 204	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   694: ifeq +24 -> 718
    //   697: aload 6
    //   699: astore 8
    //   701: aload_2
    //   702: astore 7
    //   704: aload 9
    //   706: iconst_0
    //   707: aload 9
    //   709: invokevirtual 208	java/lang/String:length	()I
    //   712: iconst_1
    //   713: isub
    //   714: invokevirtual 212	java/lang/String:substring	(II)Ljava/lang/String;
    //   717: astore_1
    //   718: aload 6
    //   720: astore 8
    //   722: aload_2
    //   723: astore 7
    //   725: aload 10
    //   727: ldc 214
    //   729: new 73	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   736: aload 11
    //   738: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: ldc 216
    //   743: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   752: pop
    //   753: aload 6
    //   755: astore 8
    //   757: aload_2
    //   758: astore 7
    //   760: aload 10
    //   762: ldc 218
    //   764: aload_1
    //   765: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload 6
    //   771: astore 8
    //   773: aload_2
    //   774: astore 7
    //   776: ldc 111
    //   778: iconst_1
    //   779: iconst_4
    //   780: anewarray 220	java/lang/Object
    //   783: dup
    //   784: iconst_0
    //   785: ldc 222
    //   787: aastore
    //   788: dup
    //   789: iconst_1
    //   790: new 73	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   797: aload 11
    //   799: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: ldc 216
    //   804: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: aastore
    //   811: dup
    //   812: iconst_2
    //   813: ldc 224
    //   815: aastore
    //   816: dup
    //   817: iconst_3
    //   818: aload_1
    //   819: aastore
    //   820: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   823: aload 6
    //   825: astore 8
    //   827: aload_2
    //   828: astore 7
    //   830: new 94	java/io/File
    //   833: dup
    //   834: aload 10
    //   836: ldc 214
    //   838: ldc 230
    //   840: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   843: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   846: astore_1
    //   847: aload 6
    //   849: astore 8
    //   851: aload_2
    //   852: astore 7
    //   854: aload_1
    //   855: invokevirtual 237	java/io/File:getParentFile	()Ljava/io/File;
    //   858: astore 9
    //   860: aload 9
    //   862: ifnull +113 -> 975
    //   865: aload 6
    //   867: astore 8
    //   869: aload_2
    //   870: astore 7
    //   872: aload 9
    //   874: invokevirtual 241	java/io/File:exists	()Z
    //   877: ifne +98 -> 975
    //   880: aload 6
    //   882: astore 8
    //   884: aload_2
    //   885: astore 7
    //   887: aload 9
    //   889: invokevirtual 244	java/io/File:mkdirs	()Z
    //   892: istore 5
    //   894: iload 5
    //   896: ifne +18 -> 914
    //   899: aload 6
    //   901: astore 8
    //   903: aload_2
    //   904: astore 7
    //   906: aload 10
    //   908: ldc 214
    //   910: invokevirtual 175	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   913: pop
    //   914: aload 6
    //   916: astore 8
    //   918: aload_2
    //   919: astore 7
    //   921: aload_1
    //   922: invokevirtual 241	java/io/File:exists	()Z
    //   925: ifeq +15 -> 940
    //   928: aload 6
    //   930: astore 8
    //   932: aload_2
    //   933: astore 7
    //   935: aload_1
    //   936: invokevirtual 247	java/io/File:delete	()Z
    //   939: pop
    //   940: aload 6
    //   942: astore 8
    //   944: aload_2
    //   945: astore 7
    //   947: ldc 111
    //   949: iconst_1
    //   950: ldc 249
    //   952: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aload_2
    //   956: ifnull +7 -> 963
    //   959: aload_2
    //   960: invokevirtual 125	java/io/BufferedReader:close	()V
    //   963: aload 6
    //   965: ifnull +8 -> 973
    //   968: aload 6
    //   970: invokevirtual 125	java/io/BufferedReader:close	()V
    //   973: iconst_0
    //   974: ireturn
    //   975: iconst_1
    //   976: istore 5
    //   978: goto -84 -> 894
    //   981: astore_1
    //   982: ldc 111
    //   984: iconst_1
    //   985: new 73	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   992: ldc 149
    //   994: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload_1
    //   998: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1001: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1010: goto -47 -> 963
    //   1013: astore_1
    //   1014: ldc 111
    //   1016: iconst_1
    //   1017: new 73	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1024: ldc 130
    //   1026: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload_1
    //   1030: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1033: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1039: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1042: goto -69 -> 973
    //   1045: astore_1
    //   1046: ldc 111
    //   1048: iconst_1
    //   1049: new 73	java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1056: ldc 149
    //   1058: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload_1
    //   1062: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1065: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: goto -869 -> 205
    //   1077: astore_1
    //   1078: ldc 111
    //   1080: iconst_1
    //   1081: new 73	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1088: ldc 130
    //   1090: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: aload_1
    //   1094: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1097: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1106: iconst_1
    //   1107: ireturn
    //   1108: astore_1
    //   1109: ldc 111
    //   1111: iconst_1
    //   1112: new 73	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1119: ldc 149
    //   1121: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: aload_1
    //   1125: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1128: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1137: goto -839 -> 298
    //   1140: astore_1
    //   1141: aconst_null
    //   1142: astore 6
    //   1144: aconst_null
    //   1145: astore_2
    //   1146: aload 6
    //   1148: astore 8
    //   1150: aload_2
    //   1151: astore 7
    //   1153: ldc 111
    //   1155: iconst_1
    //   1156: new 73	java/lang/StringBuilder
    //   1159: dup
    //   1160: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1163: ldc 253
    //   1165: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: aload_1
    //   1169: invokevirtual 254	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1172: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1181: aload_2
    //   1182: ifnull +7 -> 1189
    //   1185: aload_2
    //   1186: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1189: aload 6
    //   1191: ifnull -976 -> 215
    //   1194: aload 6
    //   1196: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1199: iconst_1
    //   1200: ireturn
    //   1201: astore_1
    //   1202: ldc 111
    //   1204: iconst_1
    //   1205: new 73	java/lang/StringBuilder
    //   1208: dup
    //   1209: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1212: ldc 130
    //   1214: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload_1
    //   1218: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1221: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: iconst_1
    //   1231: ireturn
    //   1232: astore_1
    //   1233: ldc 111
    //   1235: iconst_1
    //   1236: new 73	java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1243: ldc 149
    //   1245: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload_1
    //   1249: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1252: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1258: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1261: goto -72 -> 1189
    //   1264: astore_1
    //   1265: aconst_null
    //   1266: astore 6
    //   1268: aconst_null
    //   1269: astore_2
    //   1270: aload_2
    //   1271: ifnull +7 -> 1278
    //   1274: aload_2
    //   1275: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1278: aload 6
    //   1280: ifnull +8 -> 1288
    //   1283: aload 6
    //   1285: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1288: aload_1
    //   1289: athrow
    //   1290: astore_2
    //   1291: ldc 111
    //   1293: iconst_1
    //   1294: new 73	java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1301: ldc 149
    //   1303: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload_2
    //   1307: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1310: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1319: goto -41 -> 1278
    //   1322: astore_2
    //   1323: ldc 111
    //   1325: iconst_1
    //   1326: new 73	java/lang/StringBuilder
    //   1329: dup
    //   1330: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1333: ldc 130
    //   1335: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: aload_2
    //   1339: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1342: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1351: goto -63 -> 1288
    //   1354: astore_1
    //   1355: aconst_null
    //   1356: astore 6
    //   1358: goto -88 -> 1270
    //   1361: astore_1
    //   1362: aload 8
    //   1364: astore 6
    //   1366: aload 7
    //   1368: astore_2
    //   1369: goto -99 -> 1270
    //   1372: astore 7
    //   1374: aload_1
    //   1375: astore_2
    //   1376: aload 7
    //   1378: astore_1
    //   1379: goto -109 -> 1270
    //   1382: astore_1
    //   1383: aconst_null
    //   1384: astore 6
    //   1386: goto -240 -> 1146
    //   1389: astore_1
    //   1390: goto -244 -> 1146
    //   1393: astore_1
    //   1394: aconst_null
    //   1395: astore 6
    //   1397: aconst_null
    //   1398: astore_2
    //   1399: goto -1144 -> 255
    //   1402: astore_1
    //   1403: aconst_null
    //   1404: astore 6
    //   1406: goto -1151 -> 255
    //   1409: astore_2
    //   1410: aconst_null
    //   1411: astore 6
    //   1413: aload 7
    //   1415: astore_1
    //   1416: goto -1247 -> 169
    //   1419: astore 7
    //   1421: aconst_null
    //   1422: astore 6
    //   1424: aload_2
    //   1425: astore_1
    //   1426: aload 7
    //   1428: astore_2
    //   1429: goto -1260 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1432	0	this	avfh
    //   0	1432	1	paramContext	android.content.Context
    //   0	1432	2	paramString	String
    //   560	28	3	i	int
    //   557	8	4	j	int
    //   892	85	5	bool	boolean
    //   22	1401	6	localObject1	Object
    //   1	149	7	str1	String
    //   162	5	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   222	1145	7	str2	String
    //   1372	42	7	localObject2	Object
    //   1419	8	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   43	1320	8	localObject3	Object
    //   52	836	9	localObject4	Object
    //   61	846	10	localObject5	Object
    //   137	661	11	localObject6	Object
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
    //   652	661	162	java/io/FileNotFoundException
    //   668	676	162	java/io/FileNotFoundException
    //   686	697	162	java/io/FileNotFoundException
    //   704	718	162	java/io/FileNotFoundException
    //   725	753	162	java/io/FileNotFoundException
    //   760	769	162	java/io/FileNotFoundException
    //   776	823	162	java/io/FileNotFoundException
    //   830	847	162	java/io/FileNotFoundException
    //   854	860	162	java/io/FileNotFoundException
    //   872	880	162	java/io/FileNotFoundException
    //   887	894	162	java/io/FileNotFoundException
    //   906	914	162	java/io/FileNotFoundException
    //   921	928	162	java/io/FileNotFoundException
    //   935	940	162	java/io/FileNotFoundException
    //   947	955	162	java/io/FileNotFoundException
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
    //   652	661	254	java/io/IOException
    //   668	676	254	java/io/IOException
    //   686	697	254	java/io/IOException
    //   704	718	254	java/io/IOException
    //   725	753	254	java/io/IOException
    //   760	769	254	java/io/IOException
    //   776	823	254	java/io/IOException
    //   830	847	254	java/io/IOException
    //   854	860	254	java/io/IOException
    //   872	880	254	java/io/IOException
    //   887	894	254	java/io/IOException
    //   906	914	254	java/io/IOException
    //   921	928	254	java/io/IOException
    //   935	940	254	java/io/IOException
    //   947	955	254	java/io/IOException
    //   303	308	310	java/io/IOException
    //   445	450	452	java/io/IOException
    //   436	440	483	java/io/IOException
    //   959	963	981	java/io/IOException
    //   968	973	1013	java/io/IOException
    //   201	205	1045	java/io/IOException
    //   210	215	1077	java/io/IOException
    //   294	298	1108	java/io/IOException
    //   63	94	1140	org/json/JSONException
    //   1194	1199	1201	java/io/IOException
    //   1185	1189	1232	java/io/IOException
    //   63	94	1264	finally
    //   1274	1278	1290	java/io/IOException
    //   1283	1288	1322	java/io/IOException
    //   94	126	1354	finally
    //   133	139	1361	finally
    //   151	159	1361	finally
    //   224	231	1361	finally
    //   243	251	1361	finally
    //   262	290	1361	finally
    //   348	365	1361	finally
    //   372	379	1361	finally
    //   386	396	1361	finally
    //   403	412	1361	finally
    //   424	432	1361	finally
    //   522	531	1361	finally
    //   538	547	1361	finally
    //   554	559	1361	finally
    //   574	584	1361	finally
    //   598	608	1361	finally
    //   615	630	1361	finally
    //   637	645	1361	finally
    //   652	661	1361	finally
    //   668	676	1361	finally
    //   686	697	1361	finally
    //   704	718	1361	finally
    //   725	753	1361	finally
    //   760	769	1361	finally
    //   776	823	1361	finally
    //   830	847	1361	finally
    //   854	860	1361	finally
    //   872	880	1361	finally
    //   887	894	1361	finally
    //   906	914	1361	finally
    //   921	928	1361	finally
    //   935	940	1361	finally
    //   947	955	1361	finally
    //   1153	1181	1361	finally
    //   169	197	1372	finally
    //   94	126	1382	org/json/JSONException
    //   133	139	1389	org/json/JSONException
    //   151	159	1389	org/json/JSONException
    //   224	231	1389	org/json/JSONException
    //   243	251	1389	org/json/JSONException
    //   348	365	1389	org/json/JSONException
    //   372	379	1389	org/json/JSONException
    //   386	396	1389	org/json/JSONException
    //   403	412	1389	org/json/JSONException
    //   424	432	1389	org/json/JSONException
    //   522	531	1389	org/json/JSONException
    //   538	547	1389	org/json/JSONException
    //   554	559	1389	org/json/JSONException
    //   574	584	1389	org/json/JSONException
    //   598	608	1389	org/json/JSONException
    //   615	630	1389	org/json/JSONException
    //   637	645	1389	org/json/JSONException
    //   652	661	1389	org/json/JSONException
    //   668	676	1389	org/json/JSONException
    //   686	697	1389	org/json/JSONException
    //   704	718	1389	org/json/JSONException
    //   725	753	1389	org/json/JSONException
    //   760	769	1389	org/json/JSONException
    //   776	823	1389	org/json/JSONException
    //   830	847	1389	org/json/JSONException
    //   854	860	1389	org/json/JSONException
    //   872	880	1389	org/json/JSONException
    //   887	894	1389	org/json/JSONException
    //   906	914	1389	org/json/JSONException
    //   921	928	1389	org/json/JSONException
    //   935	940	1389	org/json/JSONException
    //   947	955	1389	org/json/JSONException
    //   63	94	1393	java/io/IOException
    //   94	126	1402	java/io/IOException
    //   63	94	1409	java/io/FileNotFoundException
    //   94	126	1419	java/io/FileNotFoundException
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
      localObject = bcig.a().jdField_a_of_type_AndroidHardwareCamera;
      k = bcig.a().jdField_a_of_type_Int;
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
      localYtSDKPlatformContex.reflectListener = new avfi(this);
      localYtSDKPlatformContex.currentAppContex = paramActivity.getApplicationContext();
      localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
      JSONObject localJSONObject = avfq.a().a(5);
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
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContex, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new avfj(this))) });
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
  
  public boolean a(String paramString, String[] paramArrayOfString)
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
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = paramArrayOfString[i];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfh
 * JD-Core Version:    0.7.0.1
 */