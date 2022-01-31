package com.tencent.mobileqq.activity;

import aaoj;
import aaok;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import babr;
import badq;
import bafb;
import bbms;
import bbmy;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import vvp;

public class DevlockQuickLoginActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 1;
  Handler jdField_a_of_type_AndroidOsHandler = new aaoj(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bafb jdField_a_of_type_Bafb;
  bbms jdField_a_of_type_Bbms;
  String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aaok(this);
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
    //   1: ldc 81
    //   3: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   6: astore 9
    //   8: aload_0
    //   9: ldc 83
    //   11: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   14: astore 10
    //   16: aload_0
    //   17: ldc 84
    //   19: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   22: astore 8
    //   24: aload_0
    //   25: getfield 34	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   28: ifnull +1049 -> 1077
    //   31: new 86	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   34: dup
    //   35: invokespecial 87	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   38: astore 13
    //   40: aload 13
    //   42: aload_0
    //   43: getfield 34	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_ArrayOfByte	[B
    //   46: invokevirtual 91	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   49: pop
    //   50: aload 13
    //   52: getfield 95	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   58: ifeq +1053 -> 1111
    //   61: aload 13
    //   63: getfield 95	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   66: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_2
    //   72: if_icmpne +1005 -> 1077
    //   75: aload 13
    //   77: getfield 106	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +1023 -> 1106
    //   86: aload 13
    //   88: getfield 106	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +981 -> 1077
    //   99: aload 13
    //   101: getfield 110	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   104: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   107: ifeq +967 -> 1074
    //   110: aload 13
    //   112: getfield 110	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   115: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   118: astore 11
    //   120: aload 11
    //   122: astore 9
    //   124: aload 13
    //   126: getfield 119	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   129: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   132: ifeq +935 -> 1067
    //   135: aload 13
    //   137: getfield 119	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   143: astore 12
    //   145: aload 13
    //   147: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   150: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   153: ifeq +905 -> 1058
    //   156: aload 13
    //   158: getfield 122	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   161: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   164: astore 11
    //   166: aload 11
    //   168: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: istore 7
    //   173: iload 7
    //   175: ifne +878 -> 1053
    //   178: iconst_1
    //   179: istore_3
    //   180: aload 13
    //   182: getfield 131	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   188: ifeq +15 -> 203
    //   191: aload_0
    //   192: aload 13
    //   194: getfield 131	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   197: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   200: putfield 40	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   203: aload 13
    //   205: getfield 134	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   208: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   211: ifeq +391 -> 602
    //   214: aload 13
    //   216: getfield 134	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   219: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   222: astore 10
    //   224: iconst_1
    //   225: istore_1
    //   226: aload 13
    //   228: getfield 137	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   234: ifeq +15 -> 249
    //   237: aload_0
    //   238: aload 13
    //   240: getfield 137	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   243: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   246: putfield 38	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   249: aload_0
    //   250: getfield 40	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   253: istore_2
    //   254: iload_2
    //   255: ifne +793 -> 1048
    //   258: iconst_0
    //   259: istore_2
    //   260: aload 13
    //   262: getfield 140	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   265: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   268: ifeq +15 -> 283
    //   271: aload_0
    //   272: aload 13
    //   274: getfield 140	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   277: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   280: putfield 44	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   283: aload 13
    //   285: getfield 143	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   288: invokevirtual 113	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   291: istore 7
    //   293: iload 7
    //   295: ifeq +745 -> 1040
    //   298: aload 13
    //   300: getfield 143	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   303: invokevirtual 116	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   306: astore 14
    //   308: iconst_1
    //   309: istore_1
    //   310: aload 13
    //   312: getfield 146	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   315: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   318: ifeq +15 -> 333
    //   321: aload_0
    //   322: aload 13
    //   324: getfield 146	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   327: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   330: putfield 42	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:d	I
    //   333: aload_0
    //   334: getfield 44	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   337: istore 6
    //   339: iload_2
    //   340: istore 4
    //   342: iload_3
    //   343: istore 5
    //   345: aload 14
    //   347: astore 8
    //   349: aload 10
    //   351: astore 13
    //   353: aload 11
    //   355: astore 15
    //   357: aload 12
    //   359: astore 16
    //   361: aload 9
    //   363: astore 17
    //   365: iload 6
    //   367: ifne +31 -> 398
    //   370: iconst_0
    //   371: istore_1
    //   372: aload 9
    //   374: astore 17
    //   376: aload 12
    //   378: astore 16
    //   380: aload 11
    //   382: astore 15
    //   384: aload 10
    //   386: astore 13
    //   388: aload 14
    //   390: astore 8
    //   392: iload_3
    //   393: istore 5
    //   395: iload_2
    //   396: istore 4
    //   398: aload_0
    //   399: aload 17
    //   401: invokevirtual 150	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   404: aload_0
    //   405: getfield 152	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   408: astore 10
    //   410: aload_0
    //   411: getfield 156	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   414: ifnull +264 -> 678
    //   417: aload_0
    //   418: getfield 156	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   421: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   424: astore 9
    //   426: aload 10
    //   428: aload 9
    //   430: invokevirtual 166	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   433: aload_0
    //   434: getfield 168	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   437: aload 16
    //   439: invokevirtual 166	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   442: iload 5
    //   444: ifeq +241 -> 685
    //   447: aload_0
    //   448: getfield 170	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   451: aload 15
    //   453: invokevirtual 166	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   456: iload 4
    //   458: ifeq +310 -> 768
    //   461: aload 13
    //   463: astore 9
    //   465: aload 13
    //   467: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifeq +19 -> 489
    //   473: aload_0
    //   474: getfield 38	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_Int	I
    //   477: iconst_1
    //   478: if_icmpne +219 -> 697
    //   481: aload_0
    //   482: ldc 171
    //   484: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   487: astore 9
    //   489: aload_0
    //   490: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   493: aload 9
    //   495: invokevirtual 176	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   498: aload_0
    //   499: getfield 40	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   502: iconst_2
    //   503: if_icmpne +205 -> 708
    //   506: aload_0
    //   507: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   510: ldc 177
    //   512: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   515: aload_0
    //   516: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   519: aload_0
    //   520: ldc 182
    //   522: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   525: iload_1
    //   526: ifeq +321 -> 847
    //   529: aload 8
    //   531: astore 9
    //   533: aload 8
    //   535: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   538: ifeq +19 -> 557
    //   541: aload_0
    //   542: getfield 42	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:d	I
    //   545: iconst_1
    //   546: if_icmpne +234 -> 780
    //   549: aload_0
    //   550: ldc 171
    //   552: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   555: astore 9
    //   557: aload_0
    //   558: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   561: iconst_0
    //   562: invokevirtual 191	android/widget/Button:setVisibility	(I)V
    //   565: aload_0
    //   566: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   569: aload 9
    //   571: invokevirtual 176	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   574: aload_0
    //   575: getfield 44	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   578: iconst_2
    //   579: if_icmpne +212 -> 791
    //   582: aload_0
    //   583: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   586: ldc 177
    //   588: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   591: aload_0
    //   592: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   595: aload_0
    //   596: ldc 182
    //   598: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   601: return
    //   602: iconst_0
    //   603: istore_1
    //   604: aconst_null
    //   605: astore 10
    //   607: goto -381 -> 226
    //   610: astore 11
    //   612: aload 9
    //   614: astore 14
    //   616: aconst_null
    //   617: astore 13
    //   619: aconst_null
    //   620: astore 15
    //   622: iconst_1
    //   623: istore_3
    //   624: iconst_0
    //   625: istore_1
    //   626: iconst_1
    //   627: istore_2
    //   628: aload 11
    //   630: astore 9
    //   632: aload 10
    //   634: astore 12
    //   636: aload 8
    //   638: astore 11
    //   640: aload 15
    //   642: astore 10
    //   644: aload 13
    //   646: astore 8
    //   648: aload 9
    //   650: invokevirtual 194	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   653: iload_2
    //   654: istore 4
    //   656: iload_3
    //   657: istore 5
    //   659: aload 10
    //   661: astore 13
    //   663: aload 11
    //   665: astore 15
    //   667: aload 12
    //   669: astore 16
    //   671: aload 14
    //   673: astore 17
    //   675: goto -277 -> 398
    //   678: ldc 196
    //   680: astore 9
    //   682: goto -256 -> 426
    //   685: aload_0
    //   686: getfield 170	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   689: bipush 8
    //   691: invokevirtual 197	android/widget/TextView:setVisibility	(I)V
    //   694: goto -238 -> 456
    //   697: aload_0
    //   698: ldc 198
    //   700: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   703: astore 9
    //   705: goto -216 -> 489
    //   708: aload_0
    //   709: getfield 40	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   712: iconst_3
    //   713: if_icmpne +25 -> 738
    //   716: aload_0
    //   717: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   720: ldc 199
    //   722: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   725: aload_0
    //   726: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   729: aload_0
    //   730: ldc 200
    //   732: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   735: goto -210 -> 525
    //   738: aload_0
    //   739: getfield 40	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_c_of_type_Int	I
    //   742: iconst_1
    //   743: if_icmpne -218 -> 525
    //   746: aload_0
    //   747: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   750: ldc 201
    //   752: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   755: aload_0
    //   756: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   759: aload_0
    //   760: ldc 202
    //   762: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   765: goto -240 -> 525
    //   768: aload_0
    //   769: getfield 173	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   772: bipush 8
    //   774: invokevirtual 191	android/widget/Button:setVisibility	(I)V
    //   777: goto -252 -> 525
    //   780: aload_0
    //   781: ldc 198
    //   783: invokevirtual 82	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:getString	(I)Ljava/lang/String;
    //   786: astore 9
    //   788: goto -231 -> 557
    //   791: aload_0
    //   792: getfield 44	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   795: iconst_3
    //   796: if_icmpne +23 -> 819
    //   799: aload_0
    //   800: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   803: ldc 199
    //   805: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   808: aload_0
    //   809: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   812: aload_0
    //   813: ldc 200
    //   815: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   818: return
    //   819: aload_0
    //   820: getfield 44	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:e	I
    //   823: iconst_1
    //   824: if_icmpne -223 -> 601
    //   827: aload_0
    //   828: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   831: ldc 201
    //   833: invokevirtual 181	android/widget/Button:setBackgroundResource	(I)V
    //   836: aload_0
    //   837: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   840: aload_0
    //   841: ldc 202
    //   843: invokevirtual 186	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   846: return
    //   847: aload_0
    //   848: getfield 188	com/tencent/mobileqq/activity/DevlockQuickLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   851: bipush 8
    //   853: invokevirtual 191	android/widget/Button:setVisibility	(I)V
    //   856: return
    //   857: astore 13
    //   859: aload 8
    //   861: astore 11
    //   863: aload 10
    //   865: astore 12
    //   867: iconst_1
    //   868: istore_3
    //   869: aconst_null
    //   870: astore 8
    //   872: aconst_null
    //   873: astore 10
    //   875: iconst_0
    //   876: istore_1
    //   877: iconst_1
    //   878: istore_2
    //   879: aload 9
    //   881: astore 14
    //   883: aload 13
    //   885: astore 9
    //   887: goto -239 -> 648
    //   890: astore 13
    //   892: aconst_null
    //   893: astore 10
    //   895: aload 8
    //   897: astore 11
    //   899: iconst_0
    //   900: istore_3
    //   901: aconst_null
    //   902: astore 8
    //   904: iconst_1
    //   905: istore_2
    //   906: iconst_0
    //   907: istore_1
    //   908: aload 9
    //   910: astore 14
    //   912: aload 13
    //   914: astore 9
    //   916: goto -268 -> 648
    //   919: astore 13
    //   921: aconst_null
    //   922: astore 8
    //   924: aconst_null
    //   925: astore 10
    //   927: iconst_0
    //   928: istore_3
    //   929: iconst_0
    //   930: istore_1
    //   931: iconst_1
    //   932: istore_2
    //   933: aload 9
    //   935: astore 14
    //   937: aload 13
    //   939: astore 9
    //   941: goto -293 -> 648
    //   944: astore 13
    //   946: aconst_null
    //   947: astore 10
    //   949: iconst_1
    //   950: istore_2
    //   951: aconst_null
    //   952: astore 8
    //   954: iconst_0
    //   955: istore_1
    //   956: aload 9
    //   958: astore 14
    //   960: aload 13
    //   962: astore 9
    //   964: goto -316 -> 648
    //   967: astore 13
    //   969: iload_1
    //   970: istore_2
    //   971: aconst_null
    //   972: astore 8
    //   974: iconst_0
    //   975: istore_1
    //   976: aload 9
    //   978: astore 14
    //   980: aload 13
    //   982: astore 9
    //   984: goto -336 -> 648
    //   987: astore 13
    //   989: aconst_null
    //   990: astore 8
    //   992: iconst_0
    //   993: istore_1
    //   994: aload 9
    //   996: astore 14
    //   998: aload 13
    //   1000: astore 9
    //   1002: goto -354 -> 648
    //   1005: astore 13
    //   1007: aconst_null
    //   1008: astore 8
    //   1010: iconst_1
    //   1011: istore_1
    //   1012: aload 9
    //   1014: astore 14
    //   1016: aload 13
    //   1018: astore 9
    //   1020: goto -372 -> 648
    //   1023: astore 13
    //   1025: aload 14
    //   1027: astore 8
    //   1029: aload 9
    //   1031: astore 14
    //   1033: aload 13
    //   1035: astore 9
    //   1037: goto -389 -> 648
    //   1040: aconst_null
    //   1041: astore 14
    //   1043: iconst_0
    //   1044: istore_1
    //   1045: goto -735 -> 310
    //   1048: iload_1
    //   1049: istore_2
    //   1050: goto -790 -> 260
    //   1053: iconst_0
    //   1054: istore_3
    //   1055: goto -875 -> 180
    //   1058: iconst_0
    //   1059: istore_3
    //   1060: aload 8
    //   1062: astore 11
    //   1064: goto -884 -> 180
    //   1067: aload 10
    //   1069: astore 12
    //   1071: goto -926 -> 145
    //   1074: goto -950 -> 124
    //   1077: aload 8
    //   1079: astore 15
    //   1081: aconst_null
    //   1082: astore 8
    //   1084: aconst_null
    //   1085: astore 13
    //   1087: iconst_1
    //   1088: istore 5
    //   1090: iconst_1
    //   1091: istore 4
    //   1093: iconst_0
    //   1094: istore_1
    //   1095: aload 10
    //   1097: astore 16
    //   1099: aload 9
    //   1101: astore 17
    //   1103: goto -705 -> 398
    //   1106: iconst_1
    //   1107: istore_1
    //   1108: goto -1013 -> 95
    //   1111: iconst_1
    //   1112: istore_1
    //   1113: goto -1043 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	this	DevlockQuickLoginActivity
    //   69	1044	1	i	int
    //   253	797	2	j	int
    //   179	881	3	k	int
    //   340	752	4	m	int
    //   343	746	5	n	int
    //   337	29	6	i1	int
    //   171	123	7	bool	boolean
    //   22	1061	8	localObject1	Object
    //   6	1094	9	localObject2	Object
    //   14	1082	10	localObject3	Object
    //   118	263	11	str	String
    //   610	19	11	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   638	425	11	localObject4	Object
    //   143	927	12	localObject5	Object
    //   38	624	13	localObject6	Object
    //   857	27	13	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   890	23	13	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   919	19	13	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   944	17	13	localInvalidProtocolBufferMicroException5	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   967	14	13	localInvalidProtocolBufferMicroException6	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   987	12	13	localInvalidProtocolBufferMicroException7	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1005	12	13	localInvalidProtocolBufferMicroException8	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1023	11	13	localInvalidProtocolBufferMicroException9	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1085	1	13	localObject7	Object
    //   306	736	14	localObject8	Object
    //   355	725	15	localObject9	Object
    //   359	739	16	localObject10	Object
    //   363	739	17	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   40	70	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   75	95	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	120	610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   124	145	857	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	166	890	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   166	173	919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   180	203	944	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	224	944	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   226	249	967	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   249	254	967	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   260	283	987	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   283	293	987	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   298	308	1005	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	333	1023	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   333	339	1023	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing()))
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    a();
    this.jdField_a_of_type_Bafb = babr.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_Bafb.setPositiveButton(paramString3, paramOnClickListener);
    this.jdField_a_of_type_Bafb.setCancelable(false);
    this.jdField_a_of_type_Bafb.show();
  }
  
  public void b()
  {
    Object localObject1 = vvp.a(this.app.a());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    Object localObject3 = ((ByteBuffer)localObject2).array();
    localObject1 = this.app.getCurrentAccountUin();
    Object localObject4 = this.app.b((String)localObject1);
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
      localObject3 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject3).putShort((short)21);
      ((ByteBuffer)localObject3).putShort((short)4);
      if (this.jdField_a_of_type_Int != 2) {
        break label312;
      }
    }
    label312:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject3).putInt(i);
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject3).array()));
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "confirmLogin start CloseCode..");
      }
      ((WtloginManager)this.app.getManager(1)).CloseCode((String)localObject1, 16L, this.jdField_b_of_type_ArrayOfByte, 1, (ArrayList)localObject2, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject2).add(HexUtil.bytes2HexStr((byte[])localObject3));
      break;
    }
  }
  
  public void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
      {
        this.jdField_a_of_type_Bbms.dismiss();
        this.jdField_a_of_type_Bbms.cancel();
      }
      this.jdField_a_of_type_Bbms = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    super.finish();
    super.overridePendingTransition(0, 2130772001);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      return;
    case 2131302832: 
      super.finish();
      super.overridePendingTransition(0, 2130772001);
      return;
    }
    if (!badq.d(this))
    {
      bbmy.a(this, super.getString(2131626719), 0).b(super.getTitleBarHeight());
      return;
    }
    if ((this.app == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString is empty");
      }
      bbmy.a(super.getApplicationContext(), 1, super.getString(2131626575), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130772001);
      return;
    }
    int j = this.jdField_a_of_type_JavaLangString.indexOf("?k=") + 3;
    if (j < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin qrCodeString  error");
      }
      bbmy.a(super.getApplicationContext(), 1, super.getString(2131626575), 0).b(getTitleBarHeight());
      super.finish();
      super.overridePendingTransition(0, 2130772001);
      return;
    }
    paramView = this.jdField_a_of_type_JavaLangString.substring(j, j + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginAuthActivity.a(paramView.getBytes(), paramView.length());
    paramView = this.app.getCurrentAccountUin();
    try
    {
      if ((this.jdField_a_of_type_Bbms == null) && (!super.isFinishing()))
      {
        this.jdField_a_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
        this.jdField_a_of_type_Bbms.c(2131629253);
      }
      if ((this.jdField_a_of_type_Bbms != null) && (!this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.show();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "requestQRLogin start verifyCode..");
      }
      if (i == 2131299056)
      {
        i = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Int = i;
        WtloginManager localWtloginManager = (WtloginManager)this.app.getManager(1);
        byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
        localWtloginManager.VerifyCode(paramView, 16L, true, arrayOfByte, new int[] { 5 }, 1, localWtloginObserver);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        continue;
        i = this.d;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.setTheme(2131690007);
    super.onCreate(paramBundle);
    super.setContentView(2131495156);
    this.leftView.setVisibility(4);
    super.setRightButton(2131625271, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131300230));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131305139));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131311509));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131311510));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299056));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131311128));
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
    if (QLog.isColorLevel()) {
      QLog.d("DevlockQuickLoginActivity", 2, "onCreate qrCodeSting=" + this.jdField_a_of_type_JavaLangString + " mainTip=" + this.jdField_b_of_type_JavaLangString + " smallTip=" + this.jdField_c_of_type_JavaLangString);
    }
    ThreadManager.post(new DevlockQuickLoginActivity.2(this), 5, null, false);
    d();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("qrcode");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("maintip");
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("smalltip");
      this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("loginConfig");
      if (QLog.isColorLevel()) {
        QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent qrCodeSting=" + this.jdField_a_of_type_JavaLangString + " mainTip=" + this.jdField_b_of_type_JavaLangString + " smallTip=" + this.jdField_c_of_type_JavaLangString);
      }
      d();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DevlockQuickLoginActivity", 2, "onNewIntent intent is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity
 * JD-Core Version:    0.7.0.1
 */