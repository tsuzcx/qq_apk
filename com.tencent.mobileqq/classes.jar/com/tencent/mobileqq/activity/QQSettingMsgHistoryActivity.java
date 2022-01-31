package com.tencent.mobileqq.activity;

import aahj;
import alof;
import alpk;
import ammh;
import ammm;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import astt;
import asvr;
import aygl;
import azbw;
import bayu;
import bdeu;
import bdic;
import bdug;
import bety;
import bhtb;
import bkny;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;
import yak;

public class QQSettingMsgHistoryActivity
  extends IphoneTitleBarActivity
  implements ammm, ViewTreeObserver.OnGlobalLayoutListener
{
  private static volatile ScanSpaceManager jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager;
  static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getFilesDir() + File.separator + "ChatHistoryEventConfig.json";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bety jdField_a_of_type_Bety;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null)
    {
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b();
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager = null;
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_Long -= paramLong;
    String str = ammh.a(this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 99	android/content/Intent
    //   3: dup
    //   4: ldc 101
    //   6: invokespecial 104	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 106
    //   13: iconst_1
    //   14: invokevirtual 110	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   17: pop
    //   18: aload_1
    //   19: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   22: invokevirtual 122	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   25: aload_2
    //   26: invokevirtual 128	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   29: aload_1
    //   30: iconst_0
    //   31: invokestatic 133	bjdt:a	(Lmqq/app/AppRuntime;Z)V
    //   34: aload_1
    //   35: invokestatic 136	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   38: aload_1
    //   39: invokevirtual 138	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 141	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Ljava/lang/String;Z)V
    //   46: aload_1
    //   47: invokestatic 143	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   50: invokestatic 145	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:c	()V
    //   53: aload_1
    //   54: invokestatic 147	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   57: invokestatic 151	bdim:a	()V
    //   60: invokestatic 154	com/tencent/mobileqq/ark/ArkAppCenter:b	()V
    //   63: invokestatic 157	atox:b	()V
    //   66: aload_0
    //   67: ifnull +12 -> 79
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   75: invokestatic 165	bivc:a	(Landroid/app/Activity;Ljava/lang/String;)Z
    //   78: pop
    //   79: aload_1
    //   80: invokestatic 171	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:deleteAllH5Data	(Lcom/tencent/common/app/AppInterface;)V
    //   83: new 50	java/io/File
    //   86: dup
    //   87: new 31	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   94: getstatic 172	com/tencent/biz/pubaccount/PublicAccountJavascriptInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc 174
    //   102: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   109: invokestatic 182	bdhe:b	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   124: invokestatic 192	ncb:b	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull +14 -> 143
    //   132: new 50	java/io/File
    //   135: dup
    //   136: aload_0
    //   137: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   143: invokestatic 194	ncb:d	()Ljava/lang/String;
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +14 -> 162
    //   151: new 50	java/io/File
    //   154: dup
    //   155: aload_0
    //   156: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   162: invokestatic 196	ncb:a	()Ljava/lang/String;
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +14 -> 181
    //   170: new 50	java/io/File
    //   173: dup
    //   174: aload_0
    //   175: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   181: invokestatic 197	ncb:c	()Ljava/lang/String;
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +14 -> 200
    //   189: new 50	java/io/File
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   197: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   200: new 50	java/io/File
    //   203: dup
    //   204: new 31	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   211: invokestatic 202	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   214: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   217: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 207
    //   222: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   231: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   234: new 50	java/io/File
    //   237: dup
    //   238: invokestatic 210	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   241: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   244: ldc 212
    //   246: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   249: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   252: new 50	java/io/File
    //   255: dup
    //   256: invokestatic 210	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   259: invokevirtual 44	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   262: ldc 217
    //   264: invokespecial 215	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   267: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   270: aload_1
    //   271: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   274: ldc 219
    //   276: iconst_4
    //   277: invokevirtual 223	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   280: invokeinterface 229 1 0
    //   285: invokeinterface 234 1 0
    //   290: invokeinterface 238 1 0
    //   295: pop
    //   296: aload_1
    //   297: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   300: ldc 240
    //   302: iconst_4
    //   303: invokevirtual 223	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   306: invokeinterface 229 1 0
    //   311: invokeinterface 234 1 0
    //   316: invokeinterface 238 1 0
    //   321: pop
    //   322: new 50	java/io/File
    //   325: dup
    //   326: getstatic 245	alof:cu	Ljava/lang/String;
    //   329: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   332: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   335: invokestatic 250	com/tencent/smtt/sdk/CacheManager:getCacheFileBaseDir	()Ljava/io/File;
    //   338: astore_0
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   347: invokestatic 253	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()V
    //   350: new 50	java/io/File
    //   353: dup
    //   354: getstatic 256	alof:cx	Ljava/lang/String;
    //   357: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 259	java/io/File:exists	()Z
    //   365: ifeq +7 -> 372
    //   368: aload_0
    //   369: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   372: aload_0
    //   373: invokevirtual 259	java/io/File:exists	()Z
    //   376: ifne +8 -> 384
    //   379: aload_0
    //   380: invokevirtual 262	java/io/File:mkdirs	()Z
    //   383: pop
    //   384: new 50	java/io/File
    //   387: dup
    //   388: getstatic 265	alof:bu	Ljava/lang/String;
    //   391: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   394: astore_0
    //   395: aload_0
    //   396: invokevirtual 259	java/io/File:exists	()Z
    //   399: ifeq +7 -> 406
    //   402: aload_0
    //   403: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   406: new 50	java/io/File
    //   409: dup
    //   410: getstatic 268	alof:bv	Ljava/lang/String;
    //   413: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   416: astore_0
    //   417: aload_0
    //   418: invokevirtual 259	java/io/File:exists	()Z
    //   421: ifeq +7 -> 428
    //   424: aload_0
    //   425: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   428: new 50	java/io/File
    //   431: dup
    //   432: getstatic 271	alof:cH	Ljava/lang/String;
    //   435: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   438: astore_0
    //   439: aload_0
    //   440: invokevirtual 259	java/io/File:exists	()Z
    //   443: ifeq +7 -> 450
    //   446: aload_0
    //   447: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   450: new 50	java/io/File
    //   453: dup
    //   454: getstatic 274	alof:cC	Ljava/lang/String;
    //   457: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   460: astore_0
    //   461: aload_0
    //   462: invokevirtual 259	java/io/File:exists	()Z
    //   465: ifeq +7 -> 472
    //   468: aload_0
    //   469: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   472: new 50	java/io/File
    //   475: dup
    //   476: new 31	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   483: getstatic 277	alof:aX	Ljava/lang/String;
    //   486: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 279
    //   492: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   501: astore_0
    //   502: aload_0
    //   503: invokevirtual 259	java/io/File:exists	()Z
    //   506: ifeq +7 -> 513
    //   509: aload_0
    //   510: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   513: new 50	java/io/File
    //   516: dup
    //   517: getstatic 282	alof:bw	Ljava/lang/String;
    //   520: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   523: astore_0
    //   524: aload_0
    //   525: invokevirtual 259	java/io/File:exists	()Z
    //   528: ifeq +7 -> 535
    //   531: aload_0
    //   532: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   535: new 50	java/io/File
    //   538: dup
    //   539: getstatic 285	alof:bx	Ljava/lang/String;
    //   542: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   545: astore_0
    //   546: aload_0
    //   547: invokevirtual 259	java/io/File:exists	()Z
    //   550: ifeq +7 -> 557
    //   553: aload_0
    //   554: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   557: new 50	java/io/File
    //   560: dup
    //   561: getstatic 288	alof:by	Ljava/lang/String;
    //   564: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   567: astore_0
    //   568: aload_0
    //   569: invokevirtual 259	java/io/File:exists	()Z
    //   572: ifeq +7 -> 579
    //   575: aload_0
    //   576: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   579: new 50	java/io/File
    //   582: dup
    //   583: getstatic 291	alof:bz	Ljava/lang/String;
    //   586: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   589: astore_0
    //   590: aload_0
    //   591: invokevirtual 259	java/io/File:exists	()Z
    //   594: ifeq +7 -> 601
    //   597: aload_0
    //   598: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   601: new 50	java/io/File
    //   604: dup
    //   605: getstatic 294	alof:bA	Ljava/lang/String;
    //   608: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   611: astore_0
    //   612: aload_0
    //   613: invokevirtual 259	java/io/File:exists	()Z
    //   616: ifeq +7 -> 623
    //   619: aload_0
    //   620: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   623: new 50	java/io/File
    //   626: dup
    //   627: getstatic 297	alof:bB	Ljava/lang/String;
    //   630: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   633: astore_0
    //   634: aload_0
    //   635: invokevirtual 259	java/io/File:exists	()Z
    //   638: ifeq +7 -> 645
    //   641: aload_0
    //   642: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   645: new 50	java/io/File
    //   648: dup
    //   649: getstatic 300	alof:cR	Ljava/lang/String;
    //   652: invokespecial 183	java/io/File:<init>	(Ljava/lang/String;)V
    //   655: astore_0
    //   656: aload_0
    //   657: invokevirtual 259	java/io/File:exists	()Z
    //   660: ifeq +7 -> 667
    //   663: aload_0
    //   664: invokestatic 188	ey:a	(Ljava/io/File;)V
    //   667: invokestatic 305	com/tencent/mobileqq/vas/VasQuickUpdateManager:cleanCache	()V
    //   670: invokestatic 308	bnpo:b	()V
    //   673: invokestatic 312	agyv:f	()V
    //   676: return
    //   677: astore_0
    //   678: invokestatic 317	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -5 -> 676
    //   684: ldc_w 319
    //   687: iconst_2
    //   688: new 31	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 321
    //   698: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_0
    //   702: invokevirtual 324	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   705: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: return
    //   715: astore_0
    //   716: goto -464 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	paramActivity	android.app.Activity
    //   0	719	1	paramQQAppInterface	QQAppInterface
    //   9	17	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	66	677	java/lang/Exception
    //   70	79	677	java/lang/Exception
    //   79	128	677	java/lang/Exception
    //   132	143	677	java/lang/Exception
    //   143	147	677	java/lang/Exception
    //   151	162	677	java/lang/Exception
    //   162	166	677	java/lang/Exception
    //   170	181	677	java/lang/Exception
    //   181	185	677	java/lang/Exception
    //   189	200	677	java/lang/Exception
    //   252	339	677	java/lang/Exception
    //   343	347	677	java/lang/Exception
    //   347	372	677	java/lang/Exception
    //   372	384	677	java/lang/Exception
    //   384	406	677	java/lang/Exception
    //   406	428	677	java/lang/Exception
    //   428	450	677	java/lang/Exception
    //   450	472	677	java/lang/Exception
    //   472	513	677	java/lang/Exception
    //   513	535	677	java/lang/Exception
    //   535	557	677	java/lang/Exception
    //   557	579	677	java/lang/Exception
    //   579	601	677	java/lang/Exception
    //   601	623	677	java/lang/Exception
    //   623	645	677	java/lang/Exception
    //   645	667	677	java/lang/Exception
    //   667	676	677	java/lang/Exception
    //   200	252	715	java/lang/Exception
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getApp() == null) {
      return;
    }
    BaseApplication.getContext().getPackageName();
    a(bdeu.a(BaseApplication.getContext()) + "thumbnails/");
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = 0;
        while (j < paramString.length)
        {
          paramString[j].delete();
          j += 1;
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    while (j < alpk.jdField_a_of_type_JavaUtilVector.size())
    {
      a(alpk.jdField_a_of_type_JavaLangString + ((Integer)alpk.jdField_a_of_type_JavaUtilVector.get(j)).intValue() + "/");
      j += 1;
    }
    a(alpk.jdField_a_of_type_JavaLangString + "background" + "/");
    a(alof.aX + "temp" + "/");
    a(alpk.jdField_a_of_type_JavaLangString + "temp" + "/");
    a(alpk.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    a(alof.co);
    a(alpk.jdField_a_of_type_JavaLangString + "voice" + "/");
    a(aahj.a() + "/");
    a(alof.cz);
    a(astt.jdField_a_of_type_JavaLangString);
    a(asvr.jdField_a_of_type_JavaLangString);
    a(aygl.a());
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_c_of_type_JavaLangString, new Object[] { paramInt + "%" }));
    }
  }
  
  private void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    int j = Math.min(Math.max((int)(100L * paramLong1 / paramLong4), 2), 100) * this.jdField_d_of_type_Int / 100;
    ((LinearLayout.LayoutParams)localObject).width = j;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    int k = Math.min(Math.max((int)(100L * paramLong2 / paramLong4), 1), 100) * this.jdField_d_of_type_Int / 100;
    ((LinearLayout.LayoutParams)localObject).width = k;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    int m = Math.max(this.jdField_d_of_type_Int - j - k, 0);
    ((LinearLayout.LayoutParams)localObject).width = m;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int n = (int)(100L * paramLong1 / paramLong4);
    if (n < 1) {}
    for (localObject = "<1%";; localObject = n + "%")
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131699023), new Object[] { localObject }));
      localObject = ammh.a(paramLong1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_Long = paramLong1;
      QLog.d("QQSettingMsgHistoryActivity", 1, "showSpaceInfo qqSpaceLength: " + j + " phoneSpaceLength: " + k + " avaliableSpaceLength: " + m);
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    if (bayu.a != null)
    {
      a(bayu.a.getAbsolutePath());
      if ((paramQQAppInterface.getApp() instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl.getApplication();
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.getApplication();
          BaseApplicationImpl.sImageCache.evictAll();
        }
      }
    }
  }
  
  static void c()
  {
    a(alof.aX + "photo/");
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getManager(10);
    if (paramQQAppInterface == null) {}
    while (!(paramQQAppInterface instanceof azbw)) {
      return;
    }
    ((azbw)paramQQAppInterface).a = null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364954);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370790);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376147));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364955));
    this.jdField_c_of_type_JavaLangString = getResources().getString(2131690631);
  }
  
  private void e()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) && (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a()))
    {
      b(jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b, jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b(), jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.c());
      bkny.a(this);
      if (bhtb.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager != null) {
      jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.b();
    }
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager = new ScanSpaceManager();
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a(this);
    jdField_a_of_type_ComTencentMobileqqAppMessageMessagecleanScanSpaceManager.a();
  }
  
  private void f()
  {
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364217);
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131373607);
    this.e = this.jdField_c_of_type_AndroidViewView.findViewById(2131371777);
    this.f = this.jdField_c_of_type_AndroidViewView.findViewById(2131371746);
    this.g = this.jdField_c_of_type_AndroidViewView.findViewById(2131373356);
    this.h = this.jdField_c_of_type_AndroidViewView.findViewById(2131371744);
    this.i = this.jdField_c_of_type_AndroidViewView.findViewById(2131371742);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131373606));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131364708));
    ((GradientDrawable)this.g.getBackground()).setColor(Color.parseColor("#00CAFC"));
    ((GradientDrawable)this.h.getBackground()).setColor(Color.parseColor("#FFCC00"));
    ((GradientDrawable)this.i.getBackground()).setColor(Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelOffset(2131298280);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int / 8);
    this.jdField_c_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Int = (this.jdField_c_of_type_Int - this.jdField_a_of_type_Int * 2 - this.jdField_b_of_type_Int * 2);
  }
  
  private void g()
  {
    int k = 0;
    Intent localIntent = getIntent();
    int j = k;
    if (localIntent != null)
    {
      j = k;
      if (localIntent.hasExtra("set_display_type")) {
        j = localIntent.getIntExtra("set_display_type", 0);
      }
    }
    if (j == 2)
    {
      setTitle(2131720258);
      return;
    }
    setTitle(2131699782);
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    b(100);
    b(paramLong1, paramLong2, paramLong3, paramLong4);
    bkny.a(this);
    if (bhtb.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
    }
    b(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (bhtb.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561296);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376200));
    setTitle(2131691555);
    d();
    f();
    e();
    this.jdField_b_of_type_JavaLangString = this.app.getCurrentAccountUin();
    setVolumeControlStream(3);
    if (bdic.a(this)) {
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_installed_secure", 0, 0, null);
    }
    for (;;)
    {
      g();
      return true;
      VipUtils.a(this.app, "Safe_SpaceClean", "SpaceClean_", "enter_MsgHistory_had_not_intalled_secure", 0, 0, null);
    }
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
    a();
    yak.a(this);
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_Boolean) {}
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ((bdug)this.app.a(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    long l;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      l = paramIntent.getLongExtra("extra_delete_total_file_size", 0L);
    } while (l <= 0L);
    a(l);
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public String setLastActivityName()
  {
    return getString(2131690766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity
 * JD-Core Version:    0.7.0.1
 */