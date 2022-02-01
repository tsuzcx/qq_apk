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
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class avqf
  extends avpy
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private FaceDetectForThirdPartyManager.AppConf jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf;
  
  public avqf(Intent paramIntent, avqk paramavqk)
  {
    this.jdField_a_of_type_Avqk = paramavqk;
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
    //   348: invokestatic 135	avqo:a	()Lavqo;
    //   351: aload 9
    //   353: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 10
    //   358: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokevirtual 138	avqo:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: aload 6
    //   367: astore 8
    //   369: aload_2
    //   370: astore 7
    //   372: aload_0
    //   373: getfield 29	avqf:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   376: ifnull +637 -> 1013
    //   379: aload 6
    //   381: astore 8
    //   383: aload_2
    //   384: astore 7
    //   386: aload_0
    //   387: getfield 29	avqf:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   390: getfield 142	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:actionReq	[I
    //   393: ifnull +620 -> 1013
    //   396: aload 6
    //   398: astore 8
    //   400: aload_2
    //   401: astore 7
    //   403: invokestatic 135	avqo:a	()Lavqo;
    //   406: iconst_5
    //   407: invokevirtual 145	avqo:a	(I)Lorg/json/JSONObject;
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
    //   539: getfield 29	avqf:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
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
    //   620: getfield 29	avqf:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   623: getfield 169	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:colorSequence	Ljava/lang/String;
    //   626: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   629: pop
    //   630: aload 6
    //   632: astore 8
    //   634: aload_2
    //   635: astore 7
    //   637: aload 10
    //   639: ldc 171
    //   641: new 160	org/json/JSONObject
    //   644: dup
    //   645: aload_0
    //   646: getfield 29	avqf:jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf	Lcom/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf;
    //   649: getfield 174	com/tencent/mobileqq/jsp/FaceDetectForThirdPartyManager$AppConf:selectData	Ljava/lang/String;
    //   652: invokespecial 175	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   655: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   658: pop
    //   659: aload 6
    //   661: astore 8
    //   663: aload_2
    //   664: astore 7
    //   666: aload 10
    //   668: ldc 177
    //   670: invokevirtual 181	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   673: pop
    //   674: aload 6
    //   676: astore 8
    //   678: aload_2
    //   679: astore 7
    //   681: aload_1
    //   682: invokevirtual 187	android/content/Context:getFilesDir	()Ljava/io/File;
    //   685: invokevirtual 190	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   688: astore 11
    //   690: aload 6
    //   692: astore 8
    //   694: aload_2
    //   695: astore 7
    //   697: getstatic 196	bnkt:b	Lbnkt;
    //   700: invokestatic 201	bnky:a	(Lbnkt;)Ljava/lang/String;
    //   703: astore 9
    //   705: aload 9
    //   707: astore_1
    //   708: aload 6
    //   710: astore 8
    //   712: aload_2
    //   713: astore 7
    //   715: aload 9
    //   717: getstatic 204	java/io/File:separator	Ljava/lang/String;
    //   720: invokevirtual 210	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   723: ifeq +24 -> 747
    //   726: aload 6
    //   728: astore 8
    //   730: aload_2
    //   731: astore 7
    //   733: aload 9
    //   735: iconst_0
    //   736: aload 9
    //   738: invokevirtual 214	java/lang/String:length	()I
    //   741: iconst_1
    //   742: isub
    //   743: invokevirtual 218	java/lang/String:substring	(II)Ljava/lang/String;
    //   746: astore_1
    //   747: aload 6
    //   749: astore 8
    //   751: aload_2
    //   752: astore 7
    //   754: aload 10
    //   756: ldc 220
    //   758: new 73	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   765: aload 11
    //   767: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: ldc 222
    //   772: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 6
    //   784: astore 8
    //   786: aload_2
    //   787: astore 7
    //   789: aload 10
    //   791: ldc 224
    //   793: aload_1
    //   794: invokevirtual 163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   797: pop
    //   798: aload 6
    //   800: astore 8
    //   802: aload_2
    //   803: astore 7
    //   805: ldc 111
    //   807: iconst_1
    //   808: iconst_4
    //   809: anewarray 226	java/lang/Object
    //   812: dup
    //   813: iconst_0
    //   814: ldc 228
    //   816: aastore
    //   817: dup
    //   818: iconst_1
    //   819: new 73	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   826: aload 11
    //   828: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: ldc 222
    //   833: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: aastore
    //   840: dup
    //   841: iconst_2
    //   842: ldc 230
    //   844: aastore
    //   845: dup
    //   846: iconst_3
    //   847: aload_1
    //   848: aastore
    //   849: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   852: aload 6
    //   854: astore 8
    //   856: aload_2
    //   857: astore 7
    //   859: new 94	java/io/File
    //   862: dup
    //   863: aload 10
    //   865: ldc 220
    //   867: ldc 236
    //   869: invokevirtual 240	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   872: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   875: astore_1
    //   876: aload 6
    //   878: astore 8
    //   880: aload_2
    //   881: astore 7
    //   883: aload_1
    //   884: invokevirtual 243	java/io/File:getParentFile	()Ljava/io/File;
    //   887: astore 9
    //   889: aload 9
    //   891: ifnull +158 -> 1049
    //   894: aload 6
    //   896: astore 8
    //   898: aload_2
    //   899: astore 7
    //   901: aload 9
    //   903: invokevirtual 247	java/io/File:exists	()Z
    //   906: ifne +143 -> 1049
    //   909: aload 6
    //   911: astore 8
    //   913: aload_2
    //   914: astore 7
    //   916: aload 9
    //   918: invokevirtual 250	java/io/File:mkdirs	()Z
    //   921: istore 5
    //   923: iload 5
    //   925: ifne +18 -> 943
    //   928: aload 6
    //   930: astore 8
    //   932: aload_2
    //   933: astore 7
    //   935: aload 10
    //   937: ldc 220
    //   939: invokevirtual 181	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   942: pop
    //   943: aload 6
    //   945: astore 8
    //   947: aload_2
    //   948: astore 7
    //   950: aload_1
    //   951: invokevirtual 247	java/io/File:exists	()Z
    //   954: ifeq +15 -> 969
    //   957: aload 6
    //   959: astore 8
    //   961: aload_2
    //   962: astore 7
    //   964: aload_1
    //   965: invokevirtual 253	java/io/File:delete	()Z
    //   968: pop
    //   969: aload 6
    //   971: astore 8
    //   973: aload_2
    //   974: astore 7
    //   976: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq +34 -> 1013
    //   982: aload 6
    //   984: astore 8
    //   986: aload_2
    //   987: astore 7
    //   989: ldc 111
    //   991: iconst_2
    //   992: iconst_2
    //   993: anewarray 226	java/lang/Object
    //   996: dup
    //   997: iconst_0
    //   998: ldc_w 258
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: aload 10
    //   1006: invokevirtual 259	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1009: aastore
    //   1010: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1013: aload 6
    //   1015: astore 8
    //   1017: aload_2
    //   1018: astore 7
    //   1020: ldc 111
    //   1022: iconst_1
    //   1023: ldc_w 261
    //   1026: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1029: aload_2
    //   1030: ifnull +7 -> 1037
    //   1033: aload_2
    //   1034: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1037: aload 6
    //   1039: ifnull +8 -> 1047
    //   1042: aload 6
    //   1044: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1047: iconst_0
    //   1048: ireturn
    //   1049: iconst_1
    //   1050: istore 5
    //   1052: goto -129 -> 923
    //   1055: astore_1
    //   1056: ldc 111
    //   1058: iconst_1
    //   1059: new 73	java/lang/StringBuilder
    //   1062: dup
    //   1063: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1066: ldc 149
    //   1068: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: aload_1
    //   1072: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1075: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: goto -47 -> 1037
    //   1087: astore_1
    //   1088: ldc 111
    //   1090: iconst_1
    //   1091: new 73	java/lang/StringBuilder
    //   1094: dup
    //   1095: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1098: ldc 130
    //   1100: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload_1
    //   1104: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1107: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: goto -69 -> 1047
    //   1119: astore_1
    //   1120: ldc 111
    //   1122: iconst_1
    //   1123: new 73	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1130: ldc 149
    //   1132: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload_1
    //   1136: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1139: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1148: goto -943 -> 205
    //   1151: astore_1
    //   1152: ldc 111
    //   1154: iconst_1
    //   1155: new 73	java/lang/StringBuilder
    //   1158: dup
    //   1159: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1162: ldc 130
    //   1164: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: aload_1
    //   1168: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1171: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1177: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1180: iconst_1
    //   1181: ireturn
    //   1182: astore_1
    //   1183: ldc 111
    //   1185: iconst_1
    //   1186: new 73	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1193: ldc 149
    //   1195: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload_1
    //   1199: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1202: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: goto -913 -> 298
    //   1214: astore_1
    //   1215: aconst_null
    //   1216: astore 6
    //   1218: aconst_null
    //   1219: astore_2
    //   1220: aload 6
    //   1222: astore 8
    //   1224: aload_2
    //   1225: astore 7
    //   1227: ldc 111
    //   1229: iconst_1
    //   1230: new 73	java/lang/StringBuilder
    //   1233: dup
    //   1234: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1237: ldc_w 265
    //   1240: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: aload_1
    //   1244: invokevirtual 266	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1247: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: aload_2
    //   1257: ifnull +7 -> 1264
    //   1260: aload_2
    //   1261: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1264: aload 6
    //   1266: ifnull -1051 -> 215
    //   1269: aload 6
    //   1271: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1274: iconst_1
    //   1275: ireturn
    //   1276: astore_1
    //   1277: ldc 111
    //   1279: iconst_1
    //   1280: new 73	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1287: ldc 130
    //   1289: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: aload_1
    //   1293: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1296: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1305: iconst_1
    //   1306: ireturn
    //   1307: astore_1
    //   1308: ldc 111
    //   1310: iconst_1
    //   1311: new 73	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1318: ldc 149
    //   1320: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload_1
    //   1324: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1327: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: goto -72 -> 1264
    //   1339: astore_1
    //   1340: aconst_null
    //   1341: astore 6
    //   1343: aconst_null
    //   1344: astore_2
    //   1345: aload_2
    //   1346: ifnull +7 -> 1353
    //   1349: aload_2
    //   1350: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1353: aload 6
    //   1355: ifnull +8 -> 1363
    //   1358: aload 6
    //   1360: invokevirtual 125	java/io/BufferedReader:close	()V
    //   1363: aload_1
    //   1364: athrow
    //   1365: astore_2
    //   1366: ldc 111
    //   1368: iconst_1
    //   1369: new 73	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1376: ldc 149
    //   1378: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: aload_2
    //   1382: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1385: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1394: goto -41 -> 1353
    //   1397: astore_2
    //   1398: ldc 111
    //   1400: iconst_1
    //   1401: new 73	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   1408: ldc 130
    //   1410: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload_2
    //   1414: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1417: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1423: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1426: goto -63 -> 1363
    //   1429: astore_1
    //   1430: aconst_null
    //   1431: astore 6
    //   1433: goto -88 -> 1345
    //   1436: astore_1
    //   1437: aload 8
    //   1439: astore 6
    //   1441: aload 7
    //   1443: astore_2
    //   1444: goto -99 -> 1345
    //   1447: astore 7
    //   1449: aload_1
    //   1450: astore_2
    //   1451: aload 7
    //   1453: astore_1
    //   1454: goto -109 -> 1345
    //   1457: astore_1
    //   1458: aconst_null
    //   1459: astore 6
    //   1461: goto -241 -> 1220
    //   1464: astore_1
    //   1465: goto -245 -> 1220
    //   1468: astore_1
    //   1469: aconst_null
    //   1470: astore 6
    //   1472: aconst_null
    //   1473: astore_2
    //   1474: goto -1219 -> 255
    //   1477: astore_1
    //   1478: aconst_null
    //   1479: astore 6
    //   1481: goto -1226 -> 255
    //   1484: astore_2
    //   1485: aconst_null
    //   1486: astore 6
    //   1488: aload 7
    //   1490: astore_1
    //   1491: goto -1322 -> 169
    //   1494: astore 7
    //   1496: aconst_null
    //   1497: astore 6
    //   1499: aload_2
    //   1500: astore_1
    //   1501: aload 7
    //   1503: astore_2
    //   1504: goto -1335 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1507	0	this	avqf
    //   0	1507	1	paramContext	android.content.Context
    //   0	1507	2	paramString	String
    //   560	28	3	i	int
    //   557	8	4	j	int
    //   921	130	5	bool	boolean
    //   22	1476	6	localObject1	Object
    //   1	149	7	str1	String
    //   162	5	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   222	1220	7	str2	String
    //   1447	42	7	localObject2	Object
    //   1494	8	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   43	1395	8	localObject3	Object
    //   52	865	9	localObject4	Object
    //   61	944	10	localObject5	Object
    //   137	690	11	localObject6	Object
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
    //   637	659	162	java/io/FileNotFoundException
    //   666	674	162	java/io/FileNotFoundException
    //   681	690	162	java/io/FileNotFoundException
    //   697	705	162	java/io/FileNotFoundException
    //   715	726	162	java/io/FileNotFoundException
    //   733	747	162	java/io/FileNotFoundException
    //   754	782	162	java/io/FileNotFoundException
    //   789	798	162	java/io/FileNotFoundException
    //   805	852	162	java/io/FileNotFoundException
    //   859	876	162	java/io/FileNotFoundException
    //   883	889	162	java/io/FileNotFoundException
    //   901	909	162	java/io/FileNotFoundException
    //   916	923	162	java/io/FileNotFoundException
    //   935	943	162	java/io/FileNotFoundException
    //   950	957	162	java/io/FileNotFoundException
    //   964	969	162	java/io/FileNotFoundException
    //   976	982	162	java/io/FileNotFoundException
    //   989	1013	162	java/io/FileNotFoundException
    //   1020	1029	162	java/io/FileNotFoundException
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
    //   637	659	254	java/io/IOException
    //   666	674	254	java/io/IOException
    //   681	690	254	java/io/IOException
    //   697	705	254	java/io/IOException
    //   715	726	254	java/io/IOException
    //   733	747	254	java/io/IOException
    //   754	782	254	java/io/IOException
    //   789	798	254	java/io/IOException
    //   805	852	254	java/io/IOException
    //   859	876	254	java/io/IOException
    //   883	889	254	java/io/IOException
    //   901	909	254	java/io/IOException
    //   916	923	254	java/io/IOException
    //   935	943	254	java/io/IOException
    //   950	957	254	java/io/IOException
    //   964	969	254	java/io/IOException
    //   976	982	254	java/io/IOException
    //   989	1013	254	java/io/IOException
    //   1020	1029	254	java/io/IOException
    //   303	308	310	java/io/IOException
    //   445	450	452	java/io/IOException
    //   436	440	483	java/io/IOException
    //   1033	1037	1055	java/io/IOException
    //   1042	1047	1087	java/io/IOException
    //   201	205	1119	java/io/IOException
    //   210	215	1151	java/io/IOException
    //   294	298	1182	java/io/IOException
    //   63	94	1214	org/json/JSONException
    //   1269	1274	1276	java/io/IOException
    //   1260	1264	1307	java/io/IOException
    //   63	94	1339	finally
    //   1349	1353	1365	java/io/IOException
    //   1358	1363	1397	java/io/IOException
    //   94	126	1429	finally
    //   133	139	1436	finally
    //   151	159	1436	finally
    //   224	231	1436	finally
    //   243	251	1436	finally
    //   262	290	1436	finally
    //   348	365	1436	finally
    //   372	379	1436	finally
    //   386	396	1436	finally
    //   403	412	1436	finally
    //   424	432	1436	finally
    //   522	531	1436	finally
    //   538	547	1436	finally
    //   554	559	1436	finally
    //   574	584	1436	finally
    //   598	608	1436	finally
    //   615	630	1436	finally
    //   637	659	1436	finally
    //   666	674	1436	finally
    //   681	690	1436	finally
    //   697	705	1436	finally
    //   715	726	1436	finally
    //   733	747	1436	finally
    //   754	782	1436	finally
    //   789	798	1436	finally
    //   805	852	1436	finally
    //   859	876	1436	finally
    //   883	889	1436	finally
    //   901	909	1436	finally
    //   916	923	1436	finally
    //   935	943	1436	finally
    //   950	957	1436	finally
    //   964	969	1436	finally
    //   976	982	1436	finally
    //   989	1013	1436	finally
    //   1020	1029	1436	finally
    //   1227	1256	1436	finally
    //   169	197	1447	finally
    //   94	126	1457	org/json/JSONException
    //   133	139	1464	org/json/JSONException
    //   151	159	1464	org/json/JSONException
    //   224	231	1464	org/json/JSONException
    //   243	251	1464	org/json/JSONException
    //   348	365	1464	org/json/JSONException
    //   372	379	1464	org/json/JSONException
    //   386	396	1464	org/json/JSONException
    //   403	412	1464	org/json/JSONException
    //   424	432	1464	org/json/JSONException
    //   522	531	1464	org/json/JSONException
    //   538	547	1464	org/json/JSONException
    //   554	559	1464	org/json/JSONException
    //   574	584	1464	org/json/JSONException
    //   598	608	1464	org/json/JSONException
    //   615	630	1464	org/json/JSONException
    //   637	659	1464	org/json/JSONException
    //   666	674	1464	org/json/JSONException
    //   681	690	1464	org/json/JSONException
    //   697	705	1464	org/json/JSONException
    //   715	726	1464	org/json/JSONException
    //   733	747	1464	org/json/JSONException
    //   754	782	1464	org/json/JSONException
    //   789	798	1464	org/json/JSONException
    //   805	852	1464	org/json/JSONException
    //   859	876	1464	org/json/JSONException
    //   883	889	1464	org/json/JSONException
    //   901	909	1464	org/json/JSONException
    //   916	923	1464	org/json/JSONException
    //   935	943	1464	org/json/JSONException
    //   950	957	1464	org/json/JSONException
    //   964	969	1464	org/json/JSONException
    //   976	982	1464	org/json/JSONException
    //   989	1013	1464	org/json/JSONException
    //   1020	1029	1464	org/json/JSONException
    //   63	94	1468	java/io/IOException
    //   94	126	1477	java/io/IOException
    //   63	94	1484	java/io/FileNotFoundException
    //   94	126	1494	java/io/FileNotFoundException
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
      localObject = bdax.a().jdField_a_of_type_AndroidHardwareCamera;
      k = bdax.a().jdField_a_of_type_Int;
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
      YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
      localYtSDKPlatformContext.currentCamera = ((Camera)localObject);
      localYtSDKPlatformContext.currentCameraId = k;
      localYtSDKPlatformContext.currentRotateState = YTCameraSetting.getRotate(BaseApplicationImpl.getApplication(), k, 1);
      localYtSDKPlatformContext.reflectLayout = null;
      localYtSDKPlatformContext.reflectListener = new avqg(this);
      localYtSDKPlatformContext.currentAppContext = paramActivity.getApplicationContext();
      localObject = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
      JSONObject localJSONObject = avqo.a().a(5);
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
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContext, localJSONObject, (YtSDKKitFramework.YtSDKKitFrameworkWorkMode)localObject, localArrayList, new avqh(this))) });
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
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramArrayOfString[i];
          System.load(paramString + (String)localObject);
          i += 1;
        }
        QLog.d("qq_Identification.Model", 1, "init load so success");
        return true;
      }
      QLog.e("qq_Identification.Model", 1, new Object[] { "init load so, soDir is not exists, so path : ", localObject });
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
 * Qualified Name:     avqf
 * JD-Core Version:    0.7.0.1
 */