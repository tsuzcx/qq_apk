package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.quicklogin.ClosePCVerifyImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.QRLoginAuthUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class DevlockQuickLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  Handler jdField_a_of_type_AndroidOsHandler = new DevlockQuickLoginActivity.1(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private DevlockQuickLoginActivity.DevlockClosePCVerifyProxy jdField_a_of_type_ComTencentMobileqqActivityDevlockQuickLoginActivity$DevlockClosePCVerifyProxy = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new DevlockQuickLoginActivity.3(this);
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int jdField_b_of_type_Int = 1;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = 2;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  int d = 0;
  int e = 0;
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 86
    //   3: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   6: astore 8
    //   8: aload_0
    //   9: ldc 88
    //   11: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   14: astore 9
    //   16: aload_0
    //   17: ldc 89
    //   19: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 35	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 13
    //   33: aconst_null
    //   34: astore 11
    //   36: aconst_null
    //   37: astore 12
    //   39: aload 6
    //   41: ifnull +697 -> 738
    //   44: new 91	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   47: dup
    //   48: invokespecial 92	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   51: astore 11
    //   53: aload 8
    //   55: astore 10
    //   57: aload 11
    //   59: aload_0
    //   60: getfield 35	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   63: invokevirtual 96	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   66: pop
    //   67: aload 8
    //   69: astore 10
    //   71: aload 11
    //   73: getfield 100	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   76: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   79: ifeq +1220 -> 1299
    //   82: aload 8
    //   84: astore 10
    //   86: aload 11
    //   88: getfield 100	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: istore_1
    //   95: goto +3 -> 98
    //   98: iload_1
    //   99: iconst_2
    //   100: if_icmpne +521 -> 621
    //   103: aload 8
    //   105: astore 10
    //   107: aload 11
    //   109: getfield 111	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +1189 -> 1304
    //   118: aload 8
    //   120: astore 10
    //   122: aload 11
    //   124: getfield 111	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: istore_1
    //   131: goto +3 -> 134
    //   134: iload_1
    //   135: ifne +486 -> 621
    //   138: aload 8
    //   140: astore 6
    //   142: aload 8
    //   144: astore 10
    //   146: aload 11
    //   148: getfield 115	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   151: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   154: ifeq +17 -> 171
    //   157: aload 8
    //   159: astore 10
    //   161: aload 11
    //   163: getfield 115	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   169: astore 6
    //   171: aload 9
    //   173: astore 8
    //   175: aload 6
    //   177: astore 10
    //   179: aload 11
    //   181: getfield 124	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   184: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   187: ifeq +17 -> 204
    //   190: aload 6
    //   192: astore 10
    //   194: aload 11
    //   196: getfield 124	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   199: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   202: astore 8
    //   204: aload 7
    //   206: astore 10
    //   208: aload 7
    //   210: astore 9
    //   212: aload 11
    //   214: getfield 127	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   217: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   220: ifeq +46 -> 266
    //   223: aload 7
    //   225: astore 9
    //   227: aload 11
    //   229: getfield 127	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   235: astore 7
    //   237: aload 7
    //   239: astore 9
    //   241: aload 7
    //   243: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: istore 5
    //   248: aload 7
    //   250: astore 10
    //   252: iload 5
    //   254: ifne +12 -> 266
    //   257: iconst_1
    //   258: istore_1
    //   259: aload 7
    //   261: astore 9
    //   263: goto +9 -> 272
    //   266: aload 10
    //   268: astore 9
    //   270: iconst_0
    //   271: istore_1
    //   272: aload 11
    //   274: getfield 136	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   277: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   280: ifeq +15 -> 295
    //   283: aload_0
    //   284: aload 11
    //   286: getfield 136	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   292: putfield 41	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   295: aload 11
    //   297: getfield 139	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   300: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   303: ifeq +18 -> 321
    //   306: aload 11
    //   308: getfield 139	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   311: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   314: astore 7
    //   316: iconst_1
    //   317: istore_3
    //   318: goto +8 -> 326
    //   321: aconst_null
    //   322: astore 7
    //   324: iconst_0
    //   325: istore_3
    //   326: iload_3
    //   327: istore 4
    //   329: aload 11
    //   331: getfield 142	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   334: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   337: ifeq +18 -> 355
    //   340: iload_3
    //   341: istore 4
    //   343: aload_0
    //   344: aload 11
    //   346: getfield 142	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   349: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   352: putfield 39	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   355: iload_3
    //   356: istore_2
    //   357: iload_3
    //   358: istore 4
    //   360: aload_0
    //   361: getfield 41	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   364: ifne +5 -> 369
    //   367: iconst_0
    //   368: istore_2
    //   369: iload_2
    //   370: istore 4
    //   372: aload 11
    //   374: getfield 145	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   377: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   380: ifeq +18 -> 398
    //   383: iload_2
    //   384: istore 4
    //   386: aload_0
    //   387: aload 11
    //   389: getfield 145	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   395: putfield 45	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   398: iload_2
    //   399: istore 4
    //   401: aload 11
    //   403: getfield 148	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   406: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   409: istore 5
    //   411: iload 5
    //   413: ifeq +50 -> 463
    //   416: aload 11
    //   418: getfield 148	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   421: invokevirtual 121	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   424: astore 10
    //   426: iconst_1
    //   427: istore_3
    //   428: goto +40 -> 468
    //   431: astore 11
    //   433: aconst_null
    //   434: astore 10
    //   436: iconst_1
    //   437: istore 4
    //   439: aload 6
    //   441: astore 13
    //   443: aload 8
    //   445: astore 12
    //   447: iload_1
    //   448: istore_3
    //   449: aload 9
    //   451: astore 8
    //   453: iload 4
    //   455: istore_1
    //   456: aload 10
    //   458: astore 6
    //   460: goto +262 -> 722
    //   463: aconst_null
    //   464: astore 10
    //   466: iconst_0
    //   467: istore_3
    //   468: aload 11
    //   470: getfield 151	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   476: ifeq +15 -> 491
    //   479: aload_0
    //   480: aload 11
    //   482: getfield 151	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   485: invokevirtual 108	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   488: putfield 43	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:d	I
    //   491: aload_0
    //   492: getfield 45	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   495: istore 4
    //   497: iload 4
    //   499: ifne +24 -> 523
    //   502: iconst_0
    //   503: istore_3
    //   504: aload 6
    //   506: astore 13
    //   508: aload 8
    //   510: astore 12
    //   512: aload 9
    //   514: astore 11
    //   516: aload 10
    //   518: astore 6
    //   520: goto +126 -> 646
    //   523: aload 6
    //   525: astore 13
    //   527: aload 8
    //   529: astore 12
    //   531: aload 9
    //   533: astore 11
    //   535: aload 10
    //   537: astore 6
    //   539: goto +107 -> 646
    //   542: astore 11
    //   544: iload_3
    //   545: istore 4
    //   547: aload 6
    //   549: astore 13
    //   551: aload 8
    //   553: astore 12
    //   555: iload_1
    //   556: istore_3
    //   557: aload 9
    //   559: astore 8
    //   561: iload 4
    //   563: istore_1
    //   564: aload 10
    //   566: astore 6
    //   568: goto +154 -> 722
    //   571: astore 10
    //   573: aload 6
    //   575: astore 11
    //   577: aload 8
    //   579: astore 12
    //   581: iload_1
    //   582: istore_3
    //   583: aload 7
    //   585: astore 13
    //   587: iload 4
    //   589: istore_2
    //   590: goto +111 -> 701
    //   593: astore 7
    //   595: aload 6
    //   597: astore 10
    //   599: aload 9
    //   601: astore 6
    //   603: goto +78 -> 681
    //   606: astore 7
    //   608: iconst_0
    //   609: istore_1
    //   610: aload 6
    //   612: astore 10
    //   614: aload 9
    //   616: astore 6
    //   618: goto +63 -> 681
    //   621: aconst_null
    //   622: astore 6
    //   624: iconst_0
    //   625: istore_3
    //   626: iconst_1
    //   627: istore_1
    //   628: iconst_1
    //   629: istore_2
    //   630: aload 7
    //   632: astore 11
    //   634: aload 12
    //   636: astore 7
    //   638: aload 9
    //   640: astore 12
    //   642: aload 8
    //   644: astore 13
    //   646: iload_3
    //   647: istore 4
    //   649: aload 12
    //   651: astore 9
    //   653: iload_1
    //   654: istore_3
    //   655: aload 11
    //   657: astore 10
    //   659: iload 4
    //   661: istore_1
    //   662: goto +97 -> 759
    //   665: astore 11
    //   667: aload 7
    //   669: astore 6
    //   671: iconst_1
    //   672: istore_1
    //   673: aload 9
    //   675: astore 8
    //   677: aload 11
    //   679: astore 7
    //   681: iconst_1
    //   682: istore_2
    //   683: aload 6
    //   685: astore 9
    //   687: iload_1
    //   688: istore_3
    //   689: aload 8
    //   691: astore 12
    //   693: aload 10
    //   695: astore 11
    //   697: aload 7
    //   699: astore 10
    //   701: aconst_null
    //   702: astore 6
    //   704: iconst_0
    //   705: istore_1
    //   706: aload 9
    //   708: astore 8
    //   710: aload 13
    //   712: astore 7
    //   714: aload 11
    //   716: astore 13
    //   718: aload 10
    //   720: astore 11
    //   722: aload 11
    //   724: invokevirtual 154	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   727: aload 12
    //   729: astore 9
    //   731: aload 8
    //   733: astore 10
    //   735: goto +24 -> 759
    //   738: aconst_null
    //   739: astore 6
    //   741: iconst_1
    //   742: istore_3
    //   743: iconst_1
    //   744: istore_2
    //   745: iconst_0
    //   746: istore_1
    //   747: aload 7
    //   749: astore 10
    //   751: aload 11
    //   753: astore 7
    //   755: aload 8
    //   757: astore 13
    //   759: aload_0
    //   760: aload 13
    //   762: invokevirtual 158	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   765: aload_0
    //   766: getfield 160	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   769: astore 11
    //   771: aload_0
    //   772: getfield 164	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   775: ifnull +15 -> 790
    //   778: aload_0
    //   779: getfield 164	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   782: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   785: astore 8
    //   787: goto +7 -> 794
    //   790: ldc 171
    //   792: astore 8
    //   794: aload 11
    //   796: aload 8
    //   798: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   801: aload_0
    //   802: getfield 178	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   805: aload 9
    //   807: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   810: iload_3
    //   811: ifeq +170 -> 981
    //   814: aload 10
    //   816: aload_0
    //   817: ldc 179
    //   819: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   822: invokevirtual 185	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   825: ifeq +100 -> 925
    //   828: aconst_null
    //   829: ldc 187
    //   831: ldc 171
    //   833: ldc 171
    //   835: ldc 189
    //   837: ldc 189
    //   839: iconst_0
    //   840: iconst_0
    //   841: ldc 171
    //   843: ldc 171
    //   845: ldc 171
    //   847: ldc 171
    //   849: invokestatic 194	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   852: aload_0
    //   853: new 196	com/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy
    //   856: dup
    //   857: new 198	java/lang/ref/WeakReference
    //   860: dup
    //   861: aload_0
    //   862: invokespecial 201	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   865: new 198	java/lang/ref/WeakReference
    //   868: dup
    //   869: aload_0
    //   870: getfield 203	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   873: invokespecial 201	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   876: invokespecial 206	com/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy:<init>	(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   879: putfield 47	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ComTencentMobileqqActivityDevlockQuickLoginActivity$DevlockClosePCVerifyProxy	Lcom/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy;
    //   882: invokestatic 211	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	()Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyImpl;
    //   885: aload_0
    //   886: getfield 47	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ComTencentMobileqqActivityDevlockQuickLoginActivity$DevlockClosePCVerifyProxy	Lcom/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy;
    //   889: invokevirtual 214	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	(Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyProxy;)V
    //   892: aload_0
    //   893: getfield 203	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   896: invokestatic 211	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	()Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyImpl;
    //   899: aload 10
    //   901: aload_0
    //   902: getfield 164	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   905: aload_0
    //   906: invokevirtual 217	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	(Ljava/lang/String;Lcom/tencent/common/app/business/BaseQQAppInterface;Lcom/tencent/mobileqq/app/QBaseActivity;)Landroid/text/SpannableString;
    //   909: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   912: aload_0
    //   913: getfield 203	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   916: invokestatic 223	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   919: invokevirtual 227	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   922: goto +68 -> 990
    //   925: aload_0
    //   926: getfield 203	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   929: aload 10
    //   931: invokevirtual 176	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   934: goto +56 -> 990
    //   937: astore 8
    //   939: new 229	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   946: astore 9
    //   948: aload 9
    //   950: ldc 232
    //   952: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload 9
    //   958: aload 8
    //   960: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   963: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: ldc 241
    //   969: iconst_1
    //   970: aload 9
    //   972: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: goto +12 -> 990
    //   981: aload_0
    //   982: getfield 203	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   985: bipush 8
    //   987: invokevirtual 253	android/widget/TextView:setVisibility	(I)V
    //   990: iload_2
    //   991: ifeq +143 -> 1134
    //   994: aload 7
    //   996: astore 8
    //   998: aload 7
    //   1000: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1003: ifeq +30 -> 1033
    //   1006: aload_0
    //   1007: getfield 39	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   1010: iconst_1
    //   1011: if_icmpne +14 -> 1025
    //   1014: aload_0
    //   1015: ldc 254
    //   1017: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1020: astore 8
    //   1022: goto +11 -> 1033
    //   1025: aload_0
    //   1026: ldc 255
    //   1028: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1031: astore 8
    //   1033: aload_0
    //   1034: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1037: aload 8
    //   1039: invokevirtual 260	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1042: aload_0
    //   1043: getfield 41	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   1046: istore_2
    //   1047: iload_2
    //   1048: iconst_2
    //   1049: if_icmpne +27 -> 1076
    //   1052: aload_0
    //   1053: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1056: ldc_w 261
    //   1059: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1062: aload_0
    //   1063: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1066: aload_0
    //   1067: ldc_w 265
    //   1070: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1073: goto +70 -> 1143
    //   1076: iload_2
    //   1077: iconst_3
    //   1078: if_icmpne +27 -> 1105
    //   1081: aload_0
    //   1082: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1085: ldc_w 270
    //   1088: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1091: aload_0
    //   1092: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1095: aload_0
    //   1096: ldc_w 271
    //   1099: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1102: goto +41 -> 1143
    //   1105: iload_2
    //   1106: iconst_1
    //   1107: if_icmpne +36 -> 1143
    //   1110: aload_0
    //   1111: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1114: ldc_w 272
    //   1117: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1120: aload_0
    //   1121: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1124: aload_0
    //   1125: ldc_w 273
    //   1128: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1131: goto +12 -> 1143
    //   1134: aload_0
    //   1135: getfield 257	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1138: bipush 8
    //   1140: invokevirtual 274	android/widget/Button:setVisibility	(I)V
    //   1143: iload_1
    //   1144: ifeq +145 -> 1289
    //   1147: aload 6
    //   1149: astore 7
    //   1151: aload 6
    //   1153: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1156: ifeq +30 -> 1186
    //   1159: aload_0
    //   1160: getfield 43	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:d	I
    //   1163: iconst_1
    //   1164: if_icmpne +14 -> 1178
    //   1167: aload_0
    //   1168: ldc 254
    //   1170: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1173: astore 7
    //   1175: goto +11 -> 1186
    //   1178: aload_0
    //   1179: ldc 255
    //   1181: invokevirtual 87	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1184: astore 7
    //   1186: aload_0
    //   1187: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1190: iconst_0
    //   1191: invokevirtual 274	android/widget/Button:setVisibility	(I)V
    //   1194: aload_0
    //   1195: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1198: aload 7
    //   1200: invokevirtual 260	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1203: aload_0
    //   1204: getfield 45	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   1207: istore_1
    //   1208: iload_1
    //   1209: iconst_2
    //   1210: if_icmpne +25 -> 1235
    //   1213: aload_0
    //   1214: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1217: ldc_w 261
    //   1220: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1223: aload_0
    //   1224: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1227: aload_0
    //   1228: ldc_w 265
    //   1231: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1234: return
    //   1235: iload_1
    //   1236: iconst_3
    //   1237: if_icmpne +25 -> 1262
    //   1240: aload_0
    //   1241: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1244: ldc_w 270
    //   1247: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1250: aload_0
    //   1251: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1254: aload_0
    //   1255: ldc_w 271
    //   1258: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1261: return
    //   1262: iload_1
    //   1263: iconst_1
    //   1264: if_icmpne +34 -> 1298
    //   1267: aload_0
    //   1268: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1271: ldc_w 272
    //   1274: invokevirtual 264	android/widget/Button:setBackgroundResource	(I)V
    //   1277: aload_0
    //   1278: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1281: aload_0
    //   1282: ldc_w 273
    //   1285: invokevirtual 269	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1288: return
    //   1289: aload_0
    //   1290: getfield 276	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   1293: bipush 8
    //   1295: invokevirtual 274	android/widget/Button:setVisibility	(I)V
    //   1298: return
    //   1299: iconst_1
    //   1300: istore_1
    //   1301: goto -1203 -> 98
    //   1304: iconst_1
    //   1305: istore_1
    //   1306: goto -1172 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1309	0	this	DevlockQuickLoginActivity
    //   94	1212	1	i	int
    //   356	752	2	j	int
    //   317	494	3	k	int
    //   327	333	4	m	int
    //   246	166	5	bool	boolean
    //   28	1124	6	localObject1	Object
    //   22	562	7	str	String
    //   593	1	7	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   606	25	7	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   636	563	7	localObject2	Object
    //   6	791	8	localObject3	Object
    //   937	22	8	localException	java.lang.Exception
    //   996	42	8	localObject4	Object
    //   14	957	9	localObject5	Object
    //   55	510	10	localObject6	Object
    //   571	1	10	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   597	333	10	localObject7	Object
    //   34	383	11	localSchemePkg	com.tencent.ims.devlock_verify_scheme.SchemePkg
    //   431	50	11	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   514	20	11	localObject8	Object
    //   542	1	11	localInvalidProtocolBufferMicroException5	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   575	81	11	localObject9	Object
    //   665	13	11	localInvalidProtocolBufferMicroException6	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   695	100	11	localObject10	Object
    //   37	691	12	localObject11	Object
    //   31	730	13	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   416	426	431	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   468	491	542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   491	497	542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   329	340	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   343	355	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   360	367	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   372	383	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   386	398	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   401	411	571	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   272	295	593	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   295	316	593	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   212	223	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	237	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   241	248	606	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   57	67	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   71	82	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	95	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   107	118	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	131	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   146	157	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   161	171	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   179	190	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   194	204	665	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   814	922	937	java/lang/Exception
    //   925	934	937	java/lang/Exception
  }
  
  public void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  void b()
  {
    Object localObject1 = QRUtils.a(this.app.getOnlineStauts());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = this.app.getCurrentAccountUin();
    Object localObject4 = this.app.getUinDisplayNameBeforeLogin((String)localObject1);
    localObject2 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals(localObject1)))
    {
      localObject4 = ((String)localObject4).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject4.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject4.length);
      localByteBuffer.put((byte[])localObject4);
      localObject4 = localByteBuffer.array();
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject4));
    }
    else
    {
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
    }
    localObject3 = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject3).putShort((short)21);
    ((ByteBuffer)localObject3).putShort((short)4);
    int i;
    if (this.jdField_a_of_type_Int == 2) {
      i = 1;
    } else {
      i = 0;
    }
    ((ByteBuffer)localObject3).putInt(i);
    ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
    }
    ((WtloginManager)this.app.getManager(1)).closeCode((String)localObject1, 16L, this.jdField_b_of_type_ArrayOfByte, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  void c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean onBackEvent()
  {
    super.finish();
    super.overridePendingTransition(0, 2130772015);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131365086) {
      if (i != 2131369233)
      {
        if (i != 2131378373) {
          break label426;
        }
      }
      else
      {
        super.finish();
        super.overridePendingTransition(0, 2130772015);
        break label426;
      }
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, super.getString(2131692183), 0).b(super.getTitleBarHeight());
    }
    else if ((this.app != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      int j = this.jdField_a_of_type_JavaLangString.indexOf("?k=") + 3;
      if (j < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
        }
        QQToast.a(super.getApplicationContext(), 1, super.getString(2131692037), 0).b(getTitleBarHeight());
        super.finish();
        super.overridePendingTransition(0, 2130772015);
      }
      else
      {
        String str = this.jdField_a_of_type_JavaLangString.substring(j, j + 32);
        this.jdField_b_of_type_ArrayOfByte = QRLoginAuthUtil.a(str.getBytes(), str.length());
        str = this.app.getCurrentAccountUin();
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (!super.isFinishing()))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
        }
        if (i == 2131365086) {
          i = this.jdField_b_of_type_Int;
        } else {
          i = this.d;
        }
        this.jdField_a_of_type_Int = i;
        localObject = (WtloginManager)this.app.getManager(1);
        byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
        ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      QQToast.a(super.getApplicationContext(), 1, super.getString(2131692037), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130772015);
    }
    label426:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131755933);
    super.onCreate(paramBundle);
    super.setContentView(2131561052);
    this.leftView.setVisibility(4);
    super.setRightButton(2131690874, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366405));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371857));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378750));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378751));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365086));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378373));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("qrcode");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("maintip");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArrayExtra("loginConfig");
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate qrCodeSting=");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(" mainTip=");
      paramBundle.append(this.jdField_b_of_type_JavaLangString);
      paramBundle.append(" smallTip=");
      paramBundle.append(this.jdField_c_of_type_JavaLangString);
      QLog.d("DevlockQuickLoginActivity", 2, paramBundle.toString());
    }
    ThreadManager.post(new DevlockQuickLoginActivity.2(this), 5, null, false);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityDevlockQuickLoginActivity$DevlockClosePCVerifyProxy != null) {
      ClosePCVerifyImpl.a().a();
    }
    c();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("maintip");
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("loginConfig");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onNewIntent qrCodeSting=");
        paramIntent.append(this.jdField_a_of_type_JavaLangString);
        paramIntent.append(" mainTip=");
        paramIntent.append(this.jdField_b_of_type_JavaLangString);
        paramIntent.append(" smallTip=");
        paramIntent.append(this.jdField_c_of_type_JavaLangString);
        QLog.d("DevlockQuickLoginActivity", 2, paramIntent.toString());
      }
      d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */