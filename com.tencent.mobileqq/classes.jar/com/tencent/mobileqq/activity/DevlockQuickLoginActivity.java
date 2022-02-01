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
  QQProgressDialog a;
  Handler b = new DevlockQuickLoginActivity.1(this);
  String c;
  String d;
  String e;
  byte[] f = null;
  byte[] g;
  int h = 1;
  ImageView i;
  TextView j;
  TextView k;
  TextView l;
  Button m;
  Button n;
  QQCustomDialog o;
  int p = 1;
  int q = 2;
  int r = 0;
  int s = 0;
  WtloginObserver t = new DevlockQuickLoginActivity.3(this);
  private DevlockQuickLoginActivity.DevlockClosePCVerifyProxy u = null;
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 97
    //   3: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   6: astore 8
    //   8: aload_0
    //   9: ldc 99
    //   11: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   14: astore 9
    //   16: aload_0
    //   17: ldc 100
    //   19: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 51	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:f	[B
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 13
    //   33: aconst_null
    //   34: astore 11
    //   36: aconst_null
    //   37: astore 12
    //   39: aload 6
    //   41: ifnull +697 -> 738
    //   44: new 102	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   47: dup
    //   48: invokespecial 103	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   51: astore 11
    //   53: aload 8
    //   55: astore 10
    //   57: aload 11
    //   59: aload_0
    //   60: getfield 51	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:f	[B
    //   63: invokevirtual 107	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   66: pop
    //   67: aload 8
    //   69: astore 10
    //   71: aload 11
    //   73: getfield 111	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   76: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   79: ifeq +1224 -> 1303
    //   82: aload 8
    //   84: astore 10
    //   86: aload 11
    //   88: getfield 111	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: istore_1
    //   95: goto +3 -> 98
    //   98: iload_1
    //   99: iconst_2
    //   100: if_icmpne +521 -> 621
    //   103: aload 8
    //   105: astore 10
    //   107: aload 11
    //   109: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   115: ifeq +1193 -> 1308
    //   118: aload 8
    //   120: astore 10
    //   122: aload 11
    //   124: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: istore_1
    //   131: goto +3 -> 134
    //   134: iload_1
    //   135: ifne +486 -> 621
    //   138: aload 8
    //   140: astore 6
    //   142: aload 8
    //   144: astore 10
    //   146: aload 11
    //   148: getfield 126	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   151: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   154: ifeq +17 -> 171
    //   157: aload 8
    //   159: astore 10
    //   161: aload 11
    //   163: getfield 126	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   166: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   169: astore 6
    //   171: aload 9
    //   173: astore 8
    //   175: aload 6
    //   177: astore 10
    //   179: aload 11
    //   181: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   184: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   187: ifeq +17 -> 204
    //   190: aload 6
    //   192: astore 10
    //   194: aload 11
    //   196: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   199: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   202: astore 8
    //   204: aload 7
    //   206: astore 10
    //   208: aload 7
    //   210: astore 9
    //   212: aload 11
    //   214: getfield 138	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   217: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   220: ifeq +46 -> 266
    //   223: aload 7
    //   225: astore 9
    //   227: aload 11
    //   229: getfield 138	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   232: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   235: astore 7
    //   237: aload 7
    //   239: astore 9
    //   241: aload 7
    //   243: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   274: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   277: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   280: ifeq +15 -> 295
    //   283: aload_0
    //   284: aload 11
    //   286: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   289: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   292: putfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:q	I
    //   295: aload 11
    //   297: getfield 150	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   300: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   303: ifeq +18 -> 321
    //   306: aload 11
    //   308: getfield 150	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   311: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
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
    //   331: getfield 153	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   334: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   337: ifeq +18 -> 355
    //   340: iload_3
    //   341: istore 4
    //   343: aload_0
    //   344: aload 11
    //   346: getfield 153	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   349: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   352: putfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:p	I
    //   355: iload_3
    //   356: istore_2
    //   357: iload_3
    //   358: istore 4
    //   360: aload_0
    //   361: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:q	I
    //   364: ifne +5 -> 369
    //   367: iconst_0
    //   368: istore_2
    //   369: iload_2
    //   370: istore 4
    //   372: aload 11
    //   374: getfield 156	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   377: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   380: ifeq +18 -> 398
    //   383: iload_2
    //   384: istore 4
    //   386: aload_0
    //   387: aload 11
    //   389: getfield 156	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   395: putfield 61	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:s	I
    //   398: iload_2
    //   399: istore 4
    //   401: aload 11
    //   403: getfield 159	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   406: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   409: istore 5
    //   411: iload 5
    //   413: ifeq +50 -> 463
    //   416: aload 11
    //   418: getfield 159	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   421: invokevirtual 132	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
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
    //   470: getfield 162	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 116	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   476: ifeq +15 -> 491
    //   479: aload_0
    //   480: aload 11
    //   482: getfield 162	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   485: invokevirtual 119	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   488: putfield 59	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:r	I
    //   491: aload_0
    //   492: getfield 61	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:s	I
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
    //   724: invokevirtual 165	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
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
    //   762: invokevirtual 169	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   765: aload_0
    //   766: getfield 171	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:j	Landroid/widget/TextView;
    //   769: astore 11
    //   771: aload_0
    //   772: getfield 175	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   775: ifnull +15 -> 790
    //   778: aload_0
    //   779: getfield 175	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   782: invokevirtual 180	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   785: astore 8
    //   787: goto +7 -> 794
    //   790: ldc 182
    //   792: astore 8
    //   794: aload 11
    //   796: aload 8
    //   798: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   801: aload_0
    //   802: getfield 189	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:k	Landroid/widget/TextView;
    //   805: aload 9
    //   807: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   810: iload_3
    //   811: ifeq +170 -> 981
    //   814: aload 10
    //   816: aload_0
    //   817: ldc 190
    //   819: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   822: invokevirtual 196	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   825: ifeq +100 -> 925
    //   828: aconst_null
    //   829: ldc 198
    //   831: ldc 182
    //   833: ldc 182
    //   835: ldc 200
    //   837: ldc 200
    //   839: iconst_0
    //   840: iconst_0
    //   841: ldc 182
    //   843: ldc 182
    //   845: ldc 182
    //   847: ldc 182
    //   849: invokestatic 205	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   852: aload_0
    //   853: new 207	com/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy
    //   856: dup
    //   857: new 209	java/lang/ref/WeakReference
    //   860: dup
    //   861: aload_0
    //   862: invokespecial 212	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   865: new 209	java/lang/ref/WeakReference
    //   868: dup
    //   869: aload_0
    //   870: getfield 214	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:l	Landroid/widget/TextView;
    //   873: invokespecial 212	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   876: invokespecial 217	com/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy:<init>	(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   879: putfield 63	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:u	Lcom/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy;
    //   882: invokestatic 222	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	()Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyImpl;
    //   885: aload_0
    //   886: getfield 63	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:u	Lcom/tencent/mobileqq/activity/DevlockQuickLoginActivity$DevlockClosePCVerifyProxy;
    //   889: invokevirtual 225	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	(Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyProxy;)V
    //   892: aload_0
    //   893: getfield 214	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:l	Landroid/widget/TextView;
    //   896: invokestatic 222	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	()Lcom/tencent/mobileqq/quicklogin/ClosePCVerifyImpl;
    //   899: aload 10
    //   901: aload_0
    //   902: getfield 175	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   905: aload_0
    //   906: invokevirtual 228	com/tencent/mobileqq/quicklogin/ClosePCVerifyImpl:a	(Ljava/lang/String;Lcom/tencent/common/app/business/BaseQQAppInterface;Lcom/tencent/mobileqq/app/QBaseActivity;)Landroid/text/SpannableString;
    //   909: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   912: aload_0
    //   913: getfield 214	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:l	Landroid/widget/TextView;
    //   916: invokestatic 234	android/text/method/LinkMovementMethod:getInstance	()Landroid/text/method/MovementMethod;
    //   919: invokevirtual 238	android/widget/TextView:setMovementMethod	(Landroid/text/method/MovementMethod;)V
    //   922: goto +68 -> 990
    //   925: aload_0
    //   926: getfield 214	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:l	Landroid/widget/TextView;
    //   929: aload 10
    //   931: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   934: goto +56 -> 990
    //   937: astore 8
    //   939: new 240	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   946: astore 9
    //   948: aload 9
    //   950: ldc 243
    //   952: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: aload 9
    //   958: aload 8
    //   960: invokevirtual 250	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   963: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: ldc 252
    //   969: iconst_1
    //   970: aload 9
    //   972: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   978: goto +12 -> 990
    //   981: aload_0
    //   982: getfield 214	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:l	Landroid/widget/TextView;
    //   985: bipush 8
    //   987: invokevirtual 264	android/widget/TextView:setVisibility	(I)V
    //   990: iload_2
    //   991: ifeq +145 -> 1136
    //   994: aload 7
    //   996: astore 8
    //   998: aload 7
    //   1000: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1003: ifeq +32 -> 1035
    //   1006: aload_0
    //   1007: getfield 55	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:p	I
    //   1010: iconst_1
    //   1011: if_icmpne +15 -> 1026
    //   1014: aload_0
    //   1015: ldc_w 265
    //   1018: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1021: astore 8
    //   1023: goto +12 -> 1035
    //   1026: aload_0
    //   1027: ldc_w 266
    //   1030: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1033: astore 8
    //   1035: aload_0
    //   1036: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1039: aload 8
    //   1041: invokevirtual 271	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1044: aload_0
    //   1045: getfield 57	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:q	I
    //   1048: istore_2
    //   1049: iload_2
    //   1050: iconst_2
    //   1051: if_icmpne +27 -> 1078
    //   1054: aload_0
    //   1055: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1058: ldc_w 272
    //   1061: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1064: aload_0
    //   1065: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1068: aload_0
    //   1069: ldc_w 276
    //   1072: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1075: goto +70 -> 1145
    //   1078: iload_2
    //   1079: iconst_3
    //   1080: if_icmpne +27 -> 1107
    //   1083: aload_0
    //   1084: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1087: ldc_w 281
    //   1090: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1093: aload_0
    //   1094: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1097: aload_0
    //   1098: ldc_w 282
    //   1101: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1104: goto +41 -> 1145
    //   1107: iload_2
    //   1108: iconst_1
    //   1109: if_icmpne +36 -> 1145
    //   1112: aload_0
    //   1113: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1116: ldc_w 283
    //   1119: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1122: aload_0
    //   1123: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1126: aload_0
    //   1127: ldc_w 284
    //   1130: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1133: goto +12 -> 1145
    //   1136: aload_0
    //   1137: getfield 268	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:m	Landroid/widget/Button;
    //   1140: bipush 8
    //   1142: invokevirtual 285	android/widget/Button:setVisibility	(I)V
    //   1145: iload_1
    //   1146: ifeq +147 -> 1293
    //   1149: aload 6
    //   1151: astore 7
    //   1153: aload 6
    //   1155: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1158: ifeq +32 -> 1190
    //   1161: aload_0
    //   1162: getfield 59	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:r	I
    //   1165: iconst_1
    //   1166: if_icmpne +15 -> 1181
    //   1169: aload_0
    //   1170: ldc_w 265
    //   1173: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1176: astore 7
    //   1178: goto +12 -> 1190
    //   1181: aload_0
    //   1182: ldc_w 266
    //   1185: invokevirtual 98	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   1188: astore 7
    //   1190: aload_0
    //   1191: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1194: iconst_0
    //   1195: invokevirtual 285	android/widget/Button:setVisibility	(I)V
    //   1198: aload_0
    //   1199: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1202: aload 7
    //   1204: invokevirtual 271	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   1207: aload_0
    //   1208: getfield 61	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:s	I
    //   1211: istore_1
    //   1212: iload_1
    //   1213: iconst_2
    //   1214: if_icmpne +25 -> 1239
    //   1217: aload_0
    //   1218: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1221: ldc_w 272
    //   1224: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1227: aload_0
    //   1228: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1231: aload_0
    //   1232: ldc_w 276
    //   1235: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1238: return
    //   1239: iload_1
    //   1240: iconst_3
    //   1241: if_icmpne +25 -> 1266
    //   1244: aload_0
    //   1245: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1248: ldc_w 281
    //   1251: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1254: aload_0
    //   1255: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1258: aload_0
    //   1259: ldc_w 282
    //   1262: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1265: return
    //   1266: iload_1
    //   1267: iconst_1
    //   1268: if_icmpne +34 -> 1302
    //   1271: aload_0
    //   1272: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1275: ldc_w 283
    //   1278: invokevirtual 275	android/widget/Button:setBackgroundResource	(I)V
    //   1281: aload_0
    //   1282: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1285: aload_0
    //   1286: ldc_w 284
    //   1289: invokevirtual 280	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   1292: return
    //   1293: aload_0
    //   1294: getfield 287	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:n	Landroid/widget/Button;
    //   1297: bipush 8
    //   1299: invokevirtual 285	android/widget/Button:setVisibility	(I)V
    //   1302: return
    //   1303: iconst_1
    //   1304: istore_1
    //   1305: goto -1207 -> 98
    //   1308: iconst_1
    //   1309: istore_1
    //   1310: goto -1176 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1313	0	this	DevlockQuickLoginActivity
    //   94	1216	1	i1	int
    //   356	754	2	i2	int
    //   317	494	3	i3	int
    //   327	333	4	i4	int
    //   246	166	5	bool	boolean
    //   28	1126	6	localObject1	Object
    //   22	562	7	str	String
    //   593	1	7	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   606	25	7	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   636	567	7	localObject2	Object
    //   6	791	8	localObject3	Object
    //   937	22	8	localException	java.lang.Exception
    //   996	44	8	localObject4	Object
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
    QQCustomDialog localQQCustomDialog = this.o;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.o.dismiss();
      this.o = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.o = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.o.setPositiveButton(paramString3, paramOnClickListener);
    this.o.setCancelable(false);
    this.o.show();
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
    int i1;
    if (this.h == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    ((ByteBuffer)localObject3).putInt(i1);
    ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
    }
    ((WtloginManager)this.app.getManager(1)).closeCode((String)localObject1, 16L, this.g, 1, (ArrayList)localObject2, this.t);
  }
  
  void c()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing()))
      {
        this.a.dismiss();
        this.a.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.a = null;
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
    super.overridePendingTransition(0, 2130772018);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131431227) {
      if (i1 != 2131436211)
      {
        if (i1 != 2131446972) {
          break label426;
        }
      }
      else
      {
        super.finish();
        super.overridePendingTransition(0, 2130772018);
        break label426;
      }
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, super.getString(2131889169), 0).show(super.getTitleBarHeight());
    }
    else if ((this.app != null) && (!TextUtils.isEmpty(this.c)))
    {
      int i2 = this.c.indexOf("?k=") + 3;
      if (i2 < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
        }
        QQToast.makeText(super.getApplicationContext(), 1, super.getString(2131889004), 0).show(getTitleBarHeight());
        super.finish();
        super.overridePendingTransition(0, 2130772018);
      }
      else
      {
        String str = this.c.substring(i2, i2 + 32);
        this.g = QRLoginAuthUtil.a(str.getBytes(), str.length());
        str = this.app.getCurrentAccountUin();
        try
        {
          if ((this.a == null) && (!super.isFinishing()))
          {
            this.a = new QQProgressDialog(this, super.getTitleBarHeight());
            this.a.c(2131892360);
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        Object localObject = this.a;
        if ((localObject != null) && (!((QQProgressDialog)localObject).isShowing())) {
          this.a.show();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
        }
        if (i1 == 2131431227) {
          i1 = this.p;
        } else {
          i1 = this.r;
        }
        this.h = i1;
        localObject = (WtloginManager)this.app.getManager(1);
        byte[] arrayOfByte = this.g;
        WtloginObserver localWtloginObserver = this.t;
        ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      QQToast.makeText(super.getApplicationContext(), 1, super.getString(2131889004), 0).show(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130772018);
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
    super.setTheme(2131953054);
    super.onCreate(paramBundle);
    super.setContentView(2131627394);
    this.leftView.setVisibility(4);
    super.setRightButton(2131887812, this);
    this.i = ((ImageView)super.findViewById(2131432718));
    this.j = ((TextView)super.findViewById(2131439298));
    this.k = ((TextView)super.findViewById(2131447424));
    this.l = ((TextView)super.findViewById(2131447425));
    this.m = ((Button)super.findViewById(2131431227));
    this.n = ((Button)super.findViewById(2131446972));
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getStringExtra("qrcode");
      this.d = paramBundle.getStringExtra("maintip");
      this.e = paramBundle.getStringExtra("smalltip");
      this.f = paramBundle.getByteArrayExtra("loginConfig");
    }
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreate qrCodeSting=");
      paramBundle.append(this.c);
      paramBundle.append(" mainTip=");
      paramBundle.append(this.d);
      paramBundle.append(" smallTip=");
      paramBundle.append(this.e);
      QLog.d("DevlockQuickLoginActivity", 2, paramBundle.toString());
    }
    ThreadManager.post(new DevlockQuickLoginActivity.2(this), 5, null, false);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.u != null) {
      ClosePCVerifyImpl.a().b();
    }
    c();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.c = paramIntent.getStringExtra("qrcode");
      this.d = paramIntent.getStringExtra("maintip");
      this.e = paramIntent.getStringExtra("smalltip");
      this.f = paramIntent.getByteArrayExtra("loginConfig");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onNewIntent qrCodeSting=");
        paramIntent.append(this.c);
        paramIntent.append(" mainTip=");
        paramIntent.append(this.d);
        paramIntent.append(" smallTip=");
        paramIntent.append(this.e);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */