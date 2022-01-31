package com.tencent.av.ui.redbag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketDataCollector;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import khd;
import khe;
import org.json.JSONObject;

public class GetRedBag
  extends BaseRedBag
{
  ResultReceiver a;
  public ResultData a;
  public Runnable a;
  public WeakReference a;
  public String g;
  public String h;
  
  GetRedBag(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_AndroidOsResultReceiver = null;
  }
  
  static int a(String paramString1, String paramString2, String paramString3)
  {
    if (("0".equals(paramString2)) && (("0".equals(paramString3)) || ("1".equals(paramString3))))
    {
      if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("0"))) {
        return 7;
      }
      return 0;
    }
    if (("66231409".equals(paramString2)) || (("0".equals(paramString2)) && ("5".equals(paramString3)))) {
      return 8;
    }
    if (("66231411".equals(paramString2)) || ("66231412".equals(paramString2))) {
      return 5;
    }
    if (("0".equals(paramString2)) && ("7".equals(paramString3))) {
      return 6;
    }
    return 9;
  }
  
  private static void a(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, PayBridgeActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", 5);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity begin");
    paramContext.startActivity(localIntent);
    QLog.w("GetRedBag", 1, "startActivity, PayBridgeActivity end");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("receiver", paramResultReceiver);
    a(paramQQAppInterface.getApp(), paramBundle);
  }
  
  /* Error */
  private boolean a(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: getfield 112	com/tencent/av/ui/redbag/GetRedBag:i	Ljava/lang/String;
    //   7: astore 6
    //   9: new 114	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   16: ldc 119
    //   18: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: ldc 128
    //   27: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: astore 7
    //   32: aload_2
    //   33: ifnull +576 -> 609
    //   36: iconst_1
    //   37: istore 5
    //   39: aload 6
    //   41: iconst_1
    //   42: aload 7
    //   44: iload 5
    //   46: invokevirtual 131	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 133
    //   51: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 81	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_2
    //   61: ifnull +703 -> 764
    //   64: ldc 139
    //   66: aload_2
    //   67: invokestatic 144	com/tencent/mobileqq/utils/AudioHelper:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   70: aload_2
    //   71: ldc 146
    //   73: invokevirtual 150	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_2
    //   77: ldc 152
    //   79: astore 6
    //   81: ldc 154
    //   83: astore 9
    //   85: aload_2
    //   86: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +552 -> 641
    //   92: new 156	org/json/JSONObject
    //   95: dup
    //   96: aload_2
    //   97: invokespecial 159	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   100: astore 7
    //   102: new 114	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   109: ldc 154
    //   111: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 7
    //   116: ldc 161
    //   118: sipush -9999
    //   121: invokevirtual 165	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   124: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_2
    //   131: aload 7
    //   133: ldc 167
    //   135: ldc 169
    //   137: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 11
    //   142: aload 7
    //   144: ldc 175
    //   146: invokevirtual 177	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore 6
    //   151: aload 6
    //   153: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifne +598 -> 754
    //   159: new 156	org/json/JSONObject
    //   162: dup
    //   163: aload 6
    //   165: invokespecial 159	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   168: astore 8
    //   170: aload 8
    //   172: ldc 179
    //   174: ldc 181
    //   176: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 9
    //   181: aload_0
    //   182: aload 8
    //   184: ldc 183
    //   186: aconst_null
    //   187: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   190: putfield 185	com/tencent/av/ui/redbag/GetRedBag:g	Ljava/lang/String;
    //   193: aload_0
    //   194: aload 8
    //   196: ldc 187
    //   198: aconst_null
    //   199: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   202: putfield 189	com/tencent/av/ui/redbag/GetRedBag:h	Ljava/lang/String;
    //   205: aload 8
    //   207: ldc 191
    //   209: ldc 193
    //   211: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 7
    //   216: aload 8
    //   218: ldc 195
    //   220: aconst_null
    //   221: invokevirtual 173	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 10
    //   226: aload 7
    //   228: astore 8
    //   230: aload 10
    //   232: astore 7
    //   234: aload 7
    //   236: astore 10
    //   238: aload 6
    //   240: astore 7
    //   242: aload_2
    //   243: astore 6
    //   245: aload 8
    //   247: astore_2
    //   248: aload 11
    //   250: astore 8
    //   252: aload_2
    //   253: astore 13
    //   255: aload 9
    //   257: astore 12
    //   259: aload 6
    //   261: astore 11
    //   263: iconst_5
    //   264: invokestatic 198	com/tencent/mobileqq/utils/AudioHelper:a	(I)I
    //   267: iconst_1
    //   268: if_icmpne +122 -> 390
    //   271: aload_0
    //   272: invokevirtual 201	com/tencent/av/ui/redbag/GetRedBag:a	()Lcom/tencent/av/ui/redbag/AVRedBagMgr;
    //   275: astore 14
    //   277: aload_2
    //   278: astore 13
    //   280: aload 9
    //   282: astore 12
    //   284: aload 6
    //   286: astore 11
    //   288: aload 14
    //   290: ifnull +100 -> 390
    //   293: aload_2
    //   294: astore 13
    //   296: aload 9
    //   298: astore 12
    //   300: aload 6
    //   302: astore 11
    //   304: aload 14
    //   306: getfield 206	com/tencent/av/ui/redbag/AVRedBagMgr:a	Lcom/tencent/av/ui/redbag/AVRedBagMgr$TestFlag;
    //   309: ifnull +81 -> 390
    //   312: aload_2
    //   313: astore 13
    //   315: aload 9
    //   317: astore 12
    //   319: aload 6
    //   321: astore 11
    //   323: aload 14
    //   325: getfield 206	com/tencent/av/ui/redbag/AVRedBagMgr:a	Lcom/tencent/av/ui/redbag/AVRedBagMgr$TestFlag;
    //   328: getfield 212	com/tencent/av/ui/redbag/AVRedBagMgr$TestFlag:jdField_c_of_type_Boolean	Z
    //   331: ifeq +59 -> 390
    //   334: aload_2
    //   335: astore 13
    //   337: aload 9
    //   339: astore 12
    //   341: aload 6
    //   343: astore 11
    //   345: aload 14
    //   347: getfield 206	com/tencent/av/ui/redbag/AVRedBagMgr:a	Lcom/tencent/av/ui/redbag/AVRedBagMgr$TestFlag;
    //   350: getfield 214	com/tencent/av/ui/redbag/AVRedBagMgr$TestFlag:a	Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   357: getfield 220	com/tencent/av/ui/redbag/ResultData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   360: invokestatic 223	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   363: ifeq +27 -> 390
    //   366: ldc 225
    //   368: astore 13
    //   370: aload 14
    //   372: getfield 206	com/tencent/av/ui/redbag/AVRedBagMgr:a	Lcom/tencent/av/ui/redbag/AVRedBagMgr$TestFlag;
    //   375: getfield 226	com/tencent/av/ui/redbag/AVRedBagMgr$TestFlag:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   378: astore 11
    //   380: aload 14
    //   382: getfield 206	com/tencent/av/ui/redbag/AVRedBagMgr:a	Lcom/tencent/av/ui/redbag/AVRedBagMgr$TestFlag;
    //   385: getfield 229	com/tencent/av/ui/redbag/AVRedBagMgr$TestFlag:d	Ljava/lang/String;
    //   388: astore 12
    //   390: aload 13
    //   392: aload 11
    //   394: aload 12
    //   396: invokestatic 231	com/tencent/av/ui/redbag/GetRedBag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   399: istore_3
    //   400: aload_0
    //   401: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   404: aload 13
    //   406: putfield 232	com/tencent/av/ui/redbag/ResultData:i	Ljava/lang/String;
    //   409: aload_0
    //   410: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   413: aload 8
    //   415: putfield 233	com/tencent/av/ui/redbag/ResultData:h	Ljava/lang/String;
    //   418: aload_0
    //   419: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   422: aload 10
    //   424: putfield 234	com/tencent/av/ui/redbag/ResultData:g	Ljava/lang/String;
    //   427: aload_0
    //   428: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   431: aload 11
    //   433: putfield 237	com/tencent/av/ui/redbag/ResultData:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   436: aload_0
    //   437: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   440: aload 12
    //   442: putfield 240	com/tencent/av/ui/redbag/ResultData:f	Ljava/lang/String;
    //   445: aload_0
    //   446: getfield 112	com/tencent/av/ui/redbag/GetRedBag:i	Ljava/lang/String;
    //   449: iconst_1
    //   450: new 114	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   457: ldc 242
    //   459: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 11
    //   464: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc 244
    //   469: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 8
    //   474: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc 246
    //   479: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 12
    //   484: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: ldc 248
    //   489: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 185	com/tencent/av/ui/redbag/GetRedBag:g	Ljava/lang/String;
    //   496: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 250
    //   501: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_0
    //   505: getfield 189	com/tencent/av/ui/redbag/GetRedBag:h	Ljava/lang/String;
    //   508: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc 252
    //   513: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 13
    //   518: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: ldc 254
    //   523: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 10
    //   528: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: ldc_w 256
    //   534: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: iload_3
    //   538: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: ldc_w 258
    //   544: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 7
    //   549: invokestatic 261	com/tencent/mobileqq/utils/AudioHelper:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   552: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc 133
    //   557: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 81	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: iload_3
    //   567: istore 4
    //   569: iload_1
    //   570: bipush 253
    //   572: if_icmpne +15 -> 587
    //   575: iload_3
    //   576: istore 4
    //   578: iload_3
    //   579: iconst_3
    //   580: if_icmpne +7 -> 587
    //   583: bipush 10
    //   585: istore 4
    //   587: aload_0
    //   588: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   591: iload 4
    //   593: putfield 264	com/tencent/av/ui/redbag/ResultData:jdField_e_of_type_Int	I
    //   596: aload_0
    //   597: invokevirtual 267	com/tencent/av/ui/redbag/GetRedBag:b	()V
    //   600: aload_0
    //   601: getfield 216	com/tencent/av/ui/redbag/GetRedBag:jdField_a_of_type_ComTencentAvUiRedbagResultData	Lcom/tencent/av/ui/redbag/ResultData;
    //   604: invokestatic 272	com/tencent/av/ui/redbag/RedBagReport:b	(Lcom/tencent/av/ui/redbag/ResultData;)V
    //   607: iconst_1
    //   608: ireturn
    //   609: iconst_0
    //   610: istore 5
    //   612: goto -573 -> 39
    //   615: astore 8
    //   617: aconst_null
    //   618: astore 7
    //   620: ldc 154
    //   622: astore 9
    //   624: ldc 193
    //   626: astore_2
    //   627: aload 8
    //   629: invokevirtual 275	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   632: astore 8
    //   634: aload 12
    //   636: astore 10
    //   638: goto -386 -> 252
    //   641: aconst_null
    //   642: astore 7
    //   644: ldc_w 277
    //   647: astore 8
    //   649: ldc 154
    //   651: astore 9
    //   653: ldc 193
    //   655: astore_2
    //   656: aload 12
    //   658: astore 10
    //   660: goto -408 -> 252
    //   663: astore 8
    //   665: aload_2
    //   666: astore 6
    //   668: aconst_null
    //   669: astore 7
    //   671: ldc 193
    //   673: astore_2
    //   674: ldc 154
    //   676: astore 9
    //   678: goto -51 -> 627
    //   681: astore 8
    //   683: aload_2
    //   684: astore 7
    //   686: aload 6
    //   688: astore 10
    //   690: ldc 193
    //   692: astore_2
    //   693: ldc 154
    //   695: astore 9
    //   697: aload 7
    //   699: astore 6
    //   701: aload 10
    //   703: astore 7
    //   705: goto -78 -> 627
    //   708: astore 8
    //   710: aload_2
    //   711: astore 7
    //   713: aload 6
    //   715: astore 10
    //   717: ldc 193
    //   719: astore_2
    //   720: aload 7
    //   722: astore 6
    //   724: aload 10
    //   726: astore 7
    //   728: goto -101 -> 627
    //   731: astore 8
    //   733: aload_2
    //   734: astore 10
    //   736: aload 6
    //   738: astore 11
    //   740: aload 7
    //   742: astore_2
    //   743: aload 10
    //   745: astore 6
    //   747: aload 11
    //   749: astore 7
    //   751: goto -124 -> 627
    //   754: ldc 193
    //   756: astore 8
    //   758: aconst_null
    //   759: astore 7
    //   761: goto -527 -> 234
    //   764: iconst_3
    //   765: istore_3
    //   766: goto -200 -> 566
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	769	0	this	GetRedBag
    //   0	769	1	paramInt	int
    //   0	769	2	paramBundle	Bundle
    //   399	367	3	i	int
    //   567	25	4	j	int
    //   37	574	5	bool	boolean
    //   7	739	6	localObject1	java.lang.Object
    //   30	730	7	localObject2	java.lang.Object
    //   168	305	8	localObject3	java.lang.Object
    //   615	13	8	localException1	Exception
    //   632	16	8	str1	String
    //   663	1	8	localException2	Exception
    //   681	1	8	localException3	Exception
    //   708	1	8	localException4	Exception
    //   731	1	8	localException5	Exception
    //   756	1	8	str2	String
    //   83	613	9	str3	String
    //   224	520	10	localObject4	java.lang.Object
    //   140	608	11	localObject5	java.lang.Object
    //   1	656	12	localObject6	java.lang.Object
    //   253	264	13	localObject7	java.lang.Object
    //   275	106	14	localAVRedBagMgr	AVRedBagMgr
    // Exception table:
    //   from	to	target	type
    //   92	131	615	java/lang/Exception
    //   131	151	663	java/lang/Exception
    //   151	181	681	java/lang/Exception
    //   181	216	708	java/lang/Exception
    //   216	226	731	java/lang/Exception
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      QLog.w(this.i, 1, "getRedBag, removeDelayRunnable");
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.w(this.i, 1, "getRedBag，超时逻辑已启动, resultCode[" + paramInt + "]");
      return;
    }
    String str = this.i;
    StringBuilder localStringBuilder = new StringBuilder().append("getRedBag，启动超时逻辑, resultCode[").append(paramInt).append("], mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break;
      }
      this.jdField_a_of_type_JavaLangRunnable = new khd(this, paramInt);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
      return;
    }
  }
  
  public void a(String paramString)
  {
    QLog.w(this.i, 1, "GetRedBag, cancel[" + paramString + "]");
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int = 4;
    b();
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ResultData paramResultData, WeakReference paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData = paramResultData;
    if (paramVideoAppInterface == null)
    {
      QLog.w(this.i, 1, "GetRedBag, app为空");
      return false;
    }
    long l = RedBagUtil.a(paramVideoAppInterface);
    if (l == 0L)
    {
      QLog.w(this.i, 1, "GetRedBag, userId为空");
      paramResultData.jdField_e_of_type_Int = 2;
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsResultReceiver == null) {
      this.jdField_a_of_type_AndroidOsResultReceiver = new GetRedBag.1(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
    }
    String str = a(paramVideoAppInterface);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("listid", paramResultData.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("authkey", paramResultData.d);
      localJSONObject2.put("name", str);
      localJSONObject2.put("channel", "16384");
      localJSONObject2.put("silence_grap", "1");
      localJSONObject2.put("grouptype", "0");
      localJSONObject2.put("groupid", "" + l);
      localJSONObject1.put("userId", l);
      localJSONObject1.put("viewTag", "graphb");
      localJSONObject1.put("app_info", "appid#0|bargainor_id#0|channel#bqredpacket");
      localJSONObject1.put("come_from", 2);
      localJSONObject1.put("extra_data", localJSONObject2);
      this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      paramWeakReference = new Bundle();
      paramWeakReference.putString("json", localJSONObject1.toString());
      paramWeakReference.putString("callbackSn", "0");
      if ((paramAVActivity != null) && (paramAVActivity.b() != -1) && (paramAVActivity.b() != 5))
      {
        paramWeakReference.putParcelable("receiver", this.jdField_a_of_type_AndroidOsResultReceiver);
        a(paramAVActivity, paramWeakReference);
        QLog.w(this.i, 1, "GetRedBag, userName[" + str + "], userId[" + l + "], redPocketId[" + paramResultData.jdField_c_of_type_JavaLangString + "], json[" + AudioHelper.a(localJSONObject1) + "], Activity[" + paramAVActivity + "]");
        paramResultData.jdField_e_of_type_Int = 1;
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        QLog.w(this.i, 1, "发通知到主进程抢红包");
        paramVideoAppInterface.a(2, 0, 0, paramWeakReference, this.jdField_a_of_type_AndroidOsResultReceiver);
        a(-3, 20000L);
      }
    }
  }
  
  void b()
  {
    a();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      khe localkhe = (khe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localkhe != null) {
        localkhe.a(this);
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      AVRedPacketDataCollector.b(bool, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.f);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GetRedBag
 * JD-Core Version:    0.7.0.1
 */