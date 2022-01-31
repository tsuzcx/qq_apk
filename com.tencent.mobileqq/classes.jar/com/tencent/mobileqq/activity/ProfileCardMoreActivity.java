package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;
import tlg;
import tlh;
import tli;
import tlj;
import tlk;
import tll;
import tln;
import tlo;
import tlp;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  long jdField_a_of_type_Long;
  public Intent a;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ProfileActivity.AllInOne a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tlo(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tll(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new tlj(this);
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new tlk(this);
  BusinessCardManager jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new tln(this);
  public BusinessCard a;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  String jdField_b_of_type_JavaLangString;
  public boolean b;
  public FormSimpleItem c;
  public FormSwitchItem c;
  public String c;
  boolean c;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_e_of_type_JavaLangString;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_f_of_type_JavaLangString = "";
  FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_g_of_type_JavaLangString = "";
  FormSimpleItem h;
  FormSimpleItem i;
  FormSimpleItem j;
  
  public ProfileCardMoreActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private static AbsStructMsgItem a(String paramString)
  {
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.b(1);
    localStructMsgItemLayoutDefault.a(paramString);
    return localStructMsgItemLayoutDefault;
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 102	java/lang/String:trim	()Ljava/lang/String;
    //   8: invokevirtual 106	java/lang/String:length	()I
    //   11: ifne +5 -> 16
    //   14: iconst_m1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 110	com/tencent/mobileqq/activity/ProfileCardMoreActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 116	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   23: invokevirtual 122	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: astore 11
    //   28: aload 11
    //   30: ifnull +3234 -> 3264
    //   33: aload 11
    //   35: ldc 124
    //   37: aload_1
    //   38: invokevirtual 129	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   41: checkcast 124	com/tencent/mobileqq/data/BmqqUserSimpleInfo
    //   44: astore 15
    //   46: aload 11
    //   48: ifnull +8 -> 56
    //   51: aload 11
    //   53: invokevirtual 131	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   56: aload 15
    //   58: ifnonnull +5 -> 63
    //   61: iconst_m1
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 133	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   70: ifne +830 -> 900
    //   73: aload_0
    //   74: getfield 133	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: astore 12
    //   79: iconst_0
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_3
    //   83: aconst_null
    //   84: astore 13
    //   86: aload_0
    //   87: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   90: astore 11
    //   92: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   95: astore 16
    //   97: new 151	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   104: ldc 154
    //   106: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 12
    //   111: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 160
    //   116: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore 14
    //   124: aload 11
    //   126: aload 16
    //   128: iconst_4
    //   129: anewarray 98	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 165
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: ldc 167
    //   141: aastore
    //   142: dup
    //   143: iconst_2
    //   144: ldc 169
    //   146: aastore
    //   147: dup
    //   148: iconst_3
    //   149: ldc 171
    //   151: aastore
    //   152: aload 14
    //   154: aconst_null
    //   155: aconst_null
    //   156: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   159: astore 11
    //   161: iconst_0
    //   162: istore 4
    //   164: lconst_0
    //   165: lstore 8
    //   167: iload_3
    //   168: istore_2
    //   169: iload 4
    //   171: istore_3
    //   172: aload 11
    //   174: ifnull +3077 -> 3251
    //   177: aload 11
    //   179: invokeinterface 183 1 0
    //   184: istore 10
    //   186: iload 10
    //   188: ifeq +3063 -> 3251
    //   191: aload 11
    //   193: iconst_0
    //   194: invokeinterface 187 2 0
    //   199: lstore 6
    //   201: iload_2
    //   202: istore 4
    //   204: aload 15
    //   206: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   209: astore 13
    //   211: aload 13
    //   213: ifnull +830 -> 1043
    //   216: aconst_null
    //   217: astore 14
    //   219: aload_0
    //   220: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   223: astore 17
    //   225: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   228: astore 13
    //   230: new 151	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   237: ldc 192
    //   239: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: lload 6
    //   244: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   247: ldc 197
    //   249: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 169
    //   254: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc 199
    //   259: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc 201
    //   264: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 203
    //   269: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 171
    //   274: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc 199
    //   279: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 15
    //   284: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   287: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 203
    //   292: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 205
    //   297: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 199
    //   302: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iconst_2
    //   306: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: ldc 160
    //   311: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 16
    //   319: aload 17
    //   321: aload 13
    //   323: iconst_5
    //   324: anewarray 98	java/lang/String
    //   327: dup
    //   328: iconst_0
    //   329: ldc 165
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: ldc 167
    //   336: aastore
    //   337: dup
    //   338: iconst_2
    //   339: ldc 169
    //   341: aastore
    //   342: dup
    //   343: iconst_3
    //   344: ldc 171
    //   346: aastore
    //   347: dup
    //   348: iconst_4
    //   349: ldc 205
    //   351: aastore
    //   352: aload 16
    //   354: aconst_null
    //   355: aconst_null
    //   356: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   359: astore 13
    //   361: aload 13
    //   363: ifnull +568 -> 931
    //   366: aload 13
    //   368: invokeinterface 211 1 0
    //   373: istore 10
    //   375: iload 10
    //   377: ifeq +554 -> 931
    //   380: iconst_1
    //   381: istore_3
    //   382: iconst_1
    //   383: istore_2
    //   384: aload 13
    //   386: invokeinterface 214 1 0
    //   391: iconst_0
    //   392: ifeq +2852 -> 3244
    //   395: new 216	java/lang/NullPointerException
    //   398: dup
    //   399: invokespecial 217	java/lang/NullPointerException:<init>	()V
    //   402: athrow
    //   403: iload_3
    //   404: istore 5
    //   406: lload 6
    //   408: lstore 8
    //   410: iload_2
    //   411: istore 4
    //   413: aload 11
    //   415: ifnull +2816 -> 3231
    //   418: aload 11
    //   420: invokeinterface 214 1 0
    //   425: iload_3
    //   426: ifne +643 -> 1069
    //   429: iconst_1
    //   430: istore_3
    //   431: iconst_0
    //   432: istore_2
    //   433: new 219	android/content/ContentValues
    //   436: dup
    //   437: invokespecial 220	android/content/ContentValues:<init>	()V
    //   440: astore 13
    //   442: iload_3
    //   443: iconst_1
    //   444: if_icmpne +643 -> 1087
    //   447: aload_0
    //   448: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   451: getstatic 223	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   454: aload 13
    //   456: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   459: invokestatic 233	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   462: lstore 6
    //   464: aload 12
    //   466: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   469: ifne +51 -> 520
    //   472: aload 13
    //   474: invokevirtual 236	android/content/ContentValues:clear	()V
    //   477: aload 13
    //   479: ldc 165
    //   481: lload 6
    //   483: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   486: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   489: aload 13
    //   491: ldc 169
    //   493: ldc 248
    //   495: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload 13
    //   500: ldc 171
    //   502: aload 12
    //   504: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload_0
    //   508: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   511: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   514: aload 13
    //   516: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   519: pop
    //   520: aload 15
    //   522: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   525: ifnonnull +11 -> 536
    //   528: aload 15
    //   530: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   533: ifnull +95 -> 628
    //   536: aload 13
    //   538: invokevirtual 236	android/content/ContentValues:clear	()V
    //   541: aload 13
    //   543: ldc 165
    //   545: lload 6
    //   547: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   550: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   553: aload 13
    //   555: ldc 169
    //   557: ldc_w 259
    //   560: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 15
    //   565: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   568: ifnull +15 -> 583
    //   571: aload 13
    //   573: ldc 171
    //   575: aload 15
    //   577: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   580: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload 15
    //   585: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   588: ifnull +16 -> 604
    //   591: aload 13
    //   593: ldc_w 261
    //   596: aload 15
    //   598: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   601: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload 13
    //   606: ldc 205
    //   608: iconst_1
    //   609: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   615: aload_0
    //   616: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   619: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   622: aload 13
    //   624: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   627: pop
    //   628: aload 15
    //   630: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   633: ifnull +65 -> 698
    //   636: aload 13
    //   638: invokevirtual 236	android/content/ContentValues:clear	()V
    //   641: aload 13
    //   643: ldc 165
    //   645: lload 6
    //   647: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   650: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   653: aload 13
    //   655: ldc 169
    //   657: ldc 201
    //   659: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload 13
    //   664: ldc 171
    //   666: aload 15
    //   668: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   671: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: aload 13
    //   676: ldc 205
    //   678: iconst_2
    //   679: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   682: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   685: aload_0
    //   686: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   689: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   692: aload 13
    //   694: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   697: pop
    //   698: aload 15
    //   700: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   703: ifnull +65 -> 768
    //   706: aload 13
    //   708: invokevirtual 236	android/content/ContentValues:clear	()V
    //   711: aload 13
    //   713: ldc 165
    //   715: lload 6
    //   717: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   720: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   723: aload 13
    //   725: ldc 169
    //   727: ldc 201
    //   729: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: aload 13
    //   734: ldc 171
    //   736: aload 15
    //   738: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   741: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   744: aload 13
    //   746: ldc 205
    //   748: iconst_3
    //   749: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   752: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   755: aload_0
    //   756: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   759: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   762: aload 13
    //   764: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   767: pop
    //   768: aload 15
    //   770: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   773: ifnull +66 -> 839
    //   776: aload 13
    //   778: invokevirtual 236	android/content/ContentValues:clear	()V
    //   781: aload 13
    //   783: ldc 165
    //   785: lload 6
    //   787: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   790: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   793: aload 13
    //   795: ldc 169
    //   797: ldc_w 277
    //   800: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 13
    //   805: ldc 171
    //   807: aload 15
    //   809: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   812: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload 13
    //   817: ldc 205
    //   819: iconst_2
    //   820: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   823: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   826: aload_0
    //   827: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   830: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   833: aload 13
    //   835: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   838: pop
    //   839: aload 13
    //   841: invokevirtual 236	android/content/ContentValues:clear	()V
    //   844: aload 13
    //   846: ldc 165
    //   848: lload 6
    //   850: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   853: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   856: aload 13
    //   858: ldc 169
    //   860: ldc_w 279
    //   863: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 13
    //   868: ldc 171
    //   870: aload_1
    //   871: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   874: aload 13
    //   876: ldc 205
    //   878: iconst_2
    //   879: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   885: aload_0
    //   886: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   889: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   892: aload 13
    //   894: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   897: pop
    //   898: iconst_0
    //   899: ireturn
    //   900: aload 15
    //   902: getfield 282	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   905: ifnull +13 -> 918
    //   908: aload 15
    //   910: getfield 282	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   913: astore 12
    //   915: goto -836 -> 79
    //   918: aload_1
    //   919: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   922: ifne +2336 -> 3258
    //   925: aload_1
    //   926: astore 12
    //   928: goto -849 -> 79
    //   931: iconst_0
    //   932: istore_2
    //   933: iconst_0
    //   934: istore 4
    //   936: iload_2
    //   937: istore_3
    //   938: aload 13
    //   940: ifnull +2330 -> 3270
    //   943: iload 4
    //   945: istore_3
    //   946: aload 13
    //   948: invokeinterface 214 1 0
    //   953: iload_2
    //   954: istore_3
    //   955: goto +2315 -> 3270
    //   958: iload_2
    //   959: istore_3
    //   960: aload 13
    //   962: ifnull +2308 -> 3270
    //   965: iload_2
    //   966: istore_3
    //   967: aload 13
    //   969: invokeinterface 214 1 0
    //   974: iload_2
    //   975: istore_3
    //   976: goto +2294 -> 3270
    //   979: astore 13
    //   981: iload_3
    //   982: istore_2
    //   983: iconst_1
    //   984: istore_3
    //   985: iload_3
    //   986: istore 5
    //   988: lload 6
    //   990: lstore 8
    //   992: iload_2
    //   993: istore 4
    //   995: aload 11
    //   997: ifnull +2234 -> 3231
    //   1000: aload 11
    //   1002: invokeinterface 214 1 0
    //   1007: goto -582 -> 425
    //   1010: astore 13
    //   1012: aload 14
    //   1014: ifnull +13 -> 1027
    //   1017: iload_2
    //   1018: istore 4
    //   1020: aload 14
    //   1022: invokeinterface 214 1 0
    //   1027: iload_2
    //   1028: istore 4
    //   1030: aload 13
    //   1032: athrow
    //   1033: astore 13
    //   1035: iconst_1
    //   1036: istore_3
    //   1037: iload 4
    //   1039: istore_2
    //   1040: goto -55 -> 985
    //   1043: iconst_0
    //   1044: istore_2
    //   1045: iconst_1
    //   1046: istore_3
    //   1047: goto -644 -> 403
    //   1050: astore_1
    //   1051: aload 13
    //   1053: astore 11
    //   1055: aload 11
    //   1057: ifnull +10 -> 1067
    //   1060: aload 11
    //   1062: invokeinterface 214 1 0
    //   1067: aload_1
    //   1068: athrow
    //   1069: iload_2
    //   1070: ifne +10 -> 1080
    //   1073: iconst_1
    //   1074: istore_3
    //   1075: iconst_0
    //   1076: istore_2
    //   1077: goto -644 -> 433
    //   1080: iconst_1
    //   1081: istore_2
    //   1082: iconst_0
    //   1083: istore_3
    //   1084: goto -651 -> 433
    //   1087: iload_2
    //   1088: iconst_1
    //   1089: if_icmpne +2006 -> 3095
    //   1092: aload 15
    //   1094: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1097: ifnull +118 -> 1215
    //   1100: aload 13
    //   1102: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1105: aload 13
    //   1107: ldc 169
    //   1109: ldc 201
    //   1111: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1114: aload 13
    //   1116: ldc 171
    //   1118: aload 15
    //   1120: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1123: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload 13
    //   1128: ldc 205
    //   1130: iconst_2
    //   1131: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1134: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1137: aload_0
    //   1138: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1141: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1144: aload 13
    //   1146: new 151	java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1153: ldc 192
    //   1155: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: lload 6
    //   1160: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1163: ldc 197
    //   1165: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: ldc 169
    //   1170: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: ldc 199
    //   1175: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: ldc 201
    //   1180: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: ldc 203
    //   1185: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: ldc 205
    //   1190: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc 199
    //   1195: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: iconst_2
    //   1199: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc 160
    //   1204: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: aconst_null
    //   1211: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1214: pop
    //   1215: aload 15
    //   1217: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1220: ifnull +271 -> 1491
    //   1223: aconst_null
    //   1224: astore 11
    //   1226: aload_0
    //   1227: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1230: astore 14
    //   1232: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1235: astore 12
    //   1237: new 151	java/lang/StringBuilder
    //   1240: dup
    //   1241: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1244: ldc 192
    //   1246: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: lload 6
    //   1251: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1254: ldc 197
    //   1256: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: ldc 169
    //   1261: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: ldc 199
    //   1266: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: ldc_w 259
    //   1272: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: ldc 203
    //   1277: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: ldc 205
    //   1282: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: ldc 199
    //   1287: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: iconst_1
    //   1291: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1294: ldc 160
    //   1296: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: astore 16
    //   1304: aload 14
    //   1306: aload 12
    //   1308: iconst_5
    //   1309: anewarray 98	java/lang/String
    //   1312: dup
    //   1313: iconst_0
    //   1314: ldc 165
    //   1316: aastore
    //   1317: dup
    //   1318: iconst_1
    //   1319: ldc 167
    //   1321: aastore
    //   1322: dup
    //   1323: iconst_2
    //   1324: ldc 169
    //   1326: aastore
    //   1327: dup
    //   1328: iconst_3
    //   1329: ldc_w 261
    //   1332: aastore
    //   1333: dup
    //   1334: iconst_4
    //   1335: ldc 205
    //   1337: aastore
    //   1338: aload 16
    //   1340: aconst_null
    //   1341: aconst_null
    //   1342: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1345: astore 12
    //   1347: aload 12
    //   1349: astore 11
    //   1351: aload 11
    //   1353: invokeinterface 211 1 0
    //   1358: ifeq +1252 -> 2610
    //   1361: aload 13
    //   1363: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1366: aload 13
    //   1368: ldc 169
    //   1370: ldc_w 259
    //   1373: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1376: aload 13
    //   1378: ldc_w 261
    //   1381: aload 15
    //   1383: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1386: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1389: aload 13
    //   1391: ldc 205
    //   1393: iconst_1
    //   1394: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1397: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1400: aload_0
    //   1401: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1404: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1407: aload 13
    //   1409: new 151	java/lang/StringBuilder
    //   1412: dup
    //   1413: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1416: ldc 192
    //   1418: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: lload 6
    //   1423: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1426: ldc 197
    //   1428: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: ldc 169
    //   1433: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: ldc 199
    //   1438: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 259
    //   1444: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: ldc 203
    //   1449: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: ldc 205
    //   1454: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: ldc 199
    //   1459: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: iconst_1
    //   1463: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1466: ldc 160
    //   1468: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: aconst_null
    //   1475: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1478: pop
    //   1479: aload 11
    //   1481: ifnull +10 -> 1491
    //   1484: aload 11
    //   1486: invokeinterface 214 1 0
    //   1491: aload 15
    //   1493: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1496: ifnull +269 -> 1765
    //   1499: aconst_null
    //   1500: astore 11
    //   1502: aload_0
    //   1503: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1506: astore 14
    //   1508: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1511: astore 16
    //   1513: new 151	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1520: ldc 192
    //   1522: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: lload 6
    //   1527: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1530: ldc 197
    //   1532: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc 169
    //   1537: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: ldc 199
    //   1542: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: ldc_w 259
    //   1548: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: ldc 203
    //   1553: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: ldc 205
    //   1558: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: ldc 199
    //   1563: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: iconst_1
    //   1567: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1570: ldc 160
    //   1572: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: astore 12
    //   1580: aload 14
    //   1582: aload 16
    //   1584: iconst_5
    //   1585: anewarray 98	java/lang/String
    //   1588: dup
    //   1589: iconst_0
    //   1590: ldc 165
    //   1592: aastore
    //   1593: dup
    //   1594: iconst_1
    //   1595: ldc 167
    //   1597: aastore
    //   1598: dup
    //   1599: iconst_2
    //   1600: ldc 169
    //   1602: aastore
    //   1603: dup
    //   1604: iconst_3
    //   1605: ldc 171
    //   1607: aastore
    //   1608: dup
    //   1609: iconst_4
    //   1610: ldc 205
    //   1612: aastore
    //   1613: aload 12
    //   1615: aconst_null
    //   1616: aconst_null
    //   1617: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1620: astore 12
    //   1622: aload 12
    //   1624: astore 11
    //   1626: aload 11
    //   1628: invokeinterface 211 1 0
    //   1633: ifeq +1076 -> 2709
    //   1636: aload 13
    //   1638: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1641: aload 13
    //   1643: ldc 169
    //   1645: ldc_w 259
    //   1648: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1651: aload 13
    //   1653: ldc 171
    //   1655: aload 15
    //   1657: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1660: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1663: aload 13
    //   1665: ldc 205
    //   1667: iconst_1
    //   1668: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1671: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1674: aload_0
    //   1675: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1678: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1681: aload 13
    //   1683: new 151	java/lang/StringBuilder
    //   1686: dup
    //   1687: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1690: ldc 192
    //   1692: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: lload 6
    //   1697: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1700: ldc 197
    //   1702: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: ldc 169
    //   1707: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: ldc 199
    //   1712: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: ldc_w 259
    //   1718: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1721: ldc 203
    //   1723: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: ldc 205
    //   1728: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: ldc 199
    //   1733: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: iconst_1
    //   1737: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1740: ldc 160
    //   1742: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: aconst_null
    //   1749: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1752: pop
    //   1753: aload 11
    //   1755: ifnull +10 -> 1765
    //   1758: aload 11
    //   1760: invokeinterface 214 1 0
    //   1765: aload 15
    //   1767: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1770: ifnull +278 -> 2048
    //   1773: aconst_null
    //   1774: astore 11
    //   1776: aload_0
    //   1777: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1780: astore 14
    //   1782: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1785: astore 12
    //   1787: new 151	java/lang/StringBuilder
    //   1790: dup
    //   1791: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1794: ldc 192
    //   1796: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: lload 6
    //   1801: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1804: ldc 197
    //   1806: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: ldc 169
    //   1811: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: ldc 199
    //   1816: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: ldc 201
    //   1821: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc 203
    //   1826: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: ldc 205
    //   1831: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: ldc 199
    //   1836: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1839: iconst_3
    //   1840: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1843: ldc 160
    //   1845: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: astore 16
    //   1853: aload 14
    //   1855: aload 12
    //   1857: iconst_5
    //   1858: anewarray 98	java/lang/String
    //   1861: dup
    //   1862: iconst_0
    //   1863: ldc 165
    //   1865: aastore
    //   1866: dup
    //   1867: iconst_1
    //   1868: ldc 167
    //   1870: aastore
    //   1871: dup
    //   1872: iconst_2
    //   1873: ldc 169
    //   1875: aastore
    //   1876: dup
    //   1877: iconst_3
    //   1878: ldc 171
    //   1880: aastore
    //   1881: dup
    //   1882: iconst_4
    //   1883: ldc 205
    //   1885: aastore
    //   1886: aload 16
    //   1888: aconst_null
    //   1889: aconst_null
    //   1890: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1893: astore 12
    //   1895: aload 12
    //   1897: astore 11
    //   1899: aload 11
    //   1901: invokeinterface 211 1 0
    //   1906: ifeq +901 -> 2807
    //   1909: aload 13
    //   1911: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1914: aload 13
    //   1916: ldc 165
    //   1918: lload 6
    //   1920: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1923: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1926: aload 13
    //   1928: ldc 169
    //   1930: ldc 201
    //   1932: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1935: aload 13
    //   1937: ldc 171
    //   1939: aload 15
    //   1941: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1944: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1947: aload 13
    //   1949: ldc 205
    //   1951: iconst_3
    //   1952: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1955: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1958: aload_0
    //   1959: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1962: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1965: aload 13
    //   1967: new 151	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1974: ldc 192
    //   1976: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: lload 6
    //   1981: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1984: ldc 197
    //   1986: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: ldc 169
    //   1991: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: ldc 199
    //   1996: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: ldc 201
    //   2001: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2004: ldc 203
    //   2006: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: ldc 205
    //   2011: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: ldc 199
    //   2016: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: iconst_3
    //   2020: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc 160
    //   2025: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2031: aconst_null
    //   2032: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2035: pop
    //   2036: aload 11
    //   2038: ifnull +10 -> 2048
    //   2041: aload 11
    //   2043: invokeinterface 214 1 0
    //   2048: aload 15
    //   2050: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2053: ifnull +281 -> 2334
    //   2056: aconst_null
    //   2057: astore 11
    //   2059: aload_0
    //   2060: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2063: astore 12
    //   2065: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2068: astore 16
    //   2070: new 151	java/lang/StringBuilder
    //   2073: dup
    //   2074: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2077: ldc 192
    //   2079: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: lload 6
    //   2084: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2087: ldc 197
    //   2089: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: ldc 169
    //   2094: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: ldc 199
    //   2099: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: ldc_w 277
    //   2105: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2108: ldc 203
    //   2110: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: ldc 205
    //   2115: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: ldc 199
    //   2120: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: iconst_2
    //   2124: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2127: ldc 160
    //   2129: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2135: astore 14
    //   2137: aload 12
    //   2139: aload 16
    //   2141: iconst_5
    //   2142: anewarray 98	java/lang/String
    //   2145: dup
    //   2146: iconst_0
    //   2147: ldc 165
    //   2149: aastore
    //   2150: dup
    //   2151: iconst_1
    //   2152: ldc 167
    //   2154: aastore
    //   2155: dup
    //   2156: iconst_2
    //   2157: ldc 169
    //   2159: aastore
    //   2160: dup
    //   2161: iconst_3
    //   2162: ldc 171
    //   2164: aastore
    //   2165: dup
    //   2166: iconst_4
    //   2167: ldc 205
    //   2169: aastore
    //   2170: aload 14
    //   2172: aconst_null
    //   2173: aconst_null
    //   2174: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2177: astore 12
    //   2179: aload 12
    //   2181: astore 11
    //   2183: aload 11
    //   2185: invokeinterface 211 1 0
    //   2190: ifeq +714 -> 2904
    //   2193: aload 13
    //   2195: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2198: aload 13
    //   2200: ldc 165
    //   2202: lload 6
    //   2204: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2207: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2210: aload 13
    //   2212: ldc 169
    //   2214: ldc_w 277
    //   2217: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2220: aload 13
    //   2222: ldc 171
    //   2224: aload 15
    //   2226: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2229: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2232: aload 13
    //   2234: ldc 205
    //   2236: iconst_2
    //   2237: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2240: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2243: aload_0
    //   2244: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2247: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2250: aload 13
    //   2252: new 151	java/lang/StringBuilder
    //   2255: dup
    //   2256: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2259: ldc 192
    //   2261: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2264: lload 6
    //   2266: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2269: ldc 197
    //   2271: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: ldc 169
    //   2276: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: ldc 199
    //   2281: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: ldc_w 277
    //   2287: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: ldc 203
    //   2292: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: ldc 205
    //   2297: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: ldc 199
    //   2302: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2305: iconst_2
    //   2306: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2309: ldc 160
    //   2311: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2317: aconst_null
    //   2318: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2321: pop
    //   2322: aload 11
    //   2324: ifnull +10 -> 2334
    //   2327: aload 11
    //   2329: invokeinterface 214 1 0
    //   2334: aconst_null
    //   2335: astore 11
    //   2337: aload_0
    //   2338: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2341: astore 14
    //   2343: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2346: astore 15
    //   2348: new 151	java/lang/StringBuilder
    //   2351: dup
    //   2352: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2355: ldc 192
    //   2357: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: lload 6
    //   2362: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2365: ldc 197
    //   2367: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2370: ldc 169
    //   2372: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: ldc 199
    //   2377: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: ldc_w 279
    //   2383: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2386: ldc 203
    //   2388: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2391: ldc 205
    //   2393: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: ldc 199
    //   2398: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2401: iconst_2
    //   2402: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2405: ldc 160
    //   2407: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2410: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2413: astore 12
    //   2415: aload 14
    //   2417: aload 15
    //   2419: iconst_5
    //   2420: anewarray 98	java/lang/String
    //   2423: dup
    //   2424: iconst_0
    //   2425: ldc 165
    //   2427: aastore
    //   2428: dup
    //   2429: iconst_1
    //   2430: ldc 167
    //   2432: aastore
    //   2433: dup
    //   2434: iconst_2
    //   2435: ldc 169
    //   2437: aastore
    //   2438: dup
    //   2439: iconst_3
    //   2440: ldc 171
    //   2442: aastore
    //   2443: dup
    //   2444: iconst_4
    //   2445: ldc 205
    //   2447: aastore
    //   2448: aload 12
    //   2450: aconst_null
    //   2451: aconst_null
    //   2452: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2455: astore 12
    //   2457: aload 12
    //   2459: astore 11
    //   2461: aload 11
    //   2463: invokeinterface 211 1 0
    //   2468: ifeq +534 -> 3002
    //   2471: aload 13
    //   2473: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2476: aload 13
    //   2478: ldc 165
    //   2480: lload 6
    //   2482: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2485: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2488: aload 13
    //   2490: ldc 169
    //   2492: ldc_w 279
    //   2495: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2498: aload 13
    //   2500: ldc 171
    //   2502: aload_1
    //   2503: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2506: aload 13
    //   2508: ldc 205
    //   2510: iconst_2
    //   2511: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2514: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2517: aload_0
    //   2518: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2521: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2524: aload 13
    //   2526: new 151	java/lang/StringBuilder
    //   2529: dup
    //   2530: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2533: ldc 192
    //   2535: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: lload 6
    //   2540: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2543: ldc 197
    //   2545: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: ldc 169
    //   2550: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2553: ldc 199
    //   2555: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: ldc_w 279
    //   2561: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: ldc 203
    //   2566: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: ldc 205
    //   2571: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2574: ldc 199
    //   2576: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: iconst_2
    //   2580: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2583: ldc 160
    //   2585: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2591: aconst_null
    //   2592: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2595: pop
    //   2596: aload 11
    //   2598: ifnull +10 -> 2608
    //   2601: aload 11
    //   2603: invokeinterface 214 1 0
    //   2608: iconst_1
    //   2609: ireturn
    //   2610: aload 13
    //   2612: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2615: aload 13
    //   2617: ldc 165
    //   2619: lload 6
    //   2621: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2624: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2627: aload 13
    //   2629: ldc 169
    //   2631: ldc_w 259
    //   2634: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2637: aload 13
    //   2639: ldc_w 261
    //   2642: aload 15
    //   2644: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2647: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2650: aload 13
    //   2652: ldc 205
    //   2654: iconst_1
    //   2655: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2658: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2661: aload_0
    //   2662: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2665: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2668: aload 13
    //   2670: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2673: pop
    //   2674: goto -1195 -> 1479
    //   2677: astore 12
    //   2679: aload 11
    //   2681: ifnull -1190 -> 1491
    //   2684: aload 11
    //   2686: invokeinterface 214 1 0
    //   2691: goto -1200 -> 1491
    //   2694: astore_1
    //   2695: aload 11
    //   2697: ifnull +10 -> 2707
    //   2700: aload 11
    //   2702: invokeinterface 214 1 0
    //   2707: aload_1
    //   2708: athrow
    //   2709: aload 13
    //   2711: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2714: aload 13
    //   2716: ldc 165
    //   2718: lload 6
    //   2720: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2723: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2726: aload 13
    //   2728: ldc 169
    //   2730: ldc_w 259
    //   2733: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2736: aload 13
    //   2738: ldc 171
    //   2740: aload 15
    //   2742: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2745: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2748: aload 13
    //   2750: ldc 205
    //   2752: iconst_1
    //   2753: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2756: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2759: aload_0
    //   2760: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2763: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2766: aload 13
    //   2768: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2771: pop
    //   2772: goto -1019 -> 1753
    //   2775: astore 12
    //   2777: aload 11
    //   2779: ifnull -1014 -> 1765
    //   2782: aload 11
    //   2784: invokeinterface 214 1 0
    //   2789: goto -1024 -> 1765
    //   2792: astore_1
    //   2793: aload 11
    //   2795: ifnull +10 -> 2805
    //   2798: aload 11
    //   2800: invokeinterface 214 1 0
    //   2805: aload_1
    //   2806: athrow
    //   2807: aload 13
    //   2809: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2812: aload 13
    //   2814: ldc 165
    //   2816: lload 6
    //   2818: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2821: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2824: aload 13
    //   2826: ldc 169
    //   2828: ldc 201
    //   2830: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2833: aload 13
    //   2835: ldc 171
    //   2837: aload 15
    //   2839: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2842: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2845: aload 13
    //   2847: ldc 205
    //   2849: iconst_3
    //   2850: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2853: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2856: aload_0
    //   2857: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2860: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2863: aload 13
    //   2865: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2868: pop
    //   2869: goto -833 -> 2036
    //   2872: astore 12
    //   2874: aload 11
    //   2876: ifnull -828 -> 2048
    //   2879: aload 11
    //   2881: invokeinterface 214 1 0
    //   2886: goto -838 -> 2048
    //   2889: astore_1
    //   2890: aload 11
    //   2892: ifnull +10 -> 2902
    //   2895: aload 11
    //   2897: invokeinterface 214 1 0
    //   2902: aload_1
    //   2903: athrow
    //   2904: aload 13
    //   2906: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2909: aload 13
    //   2911: ldc 165
    //   2913: lload 6
    //   2915: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2918: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2921: aload 13
    //   2923: ldc 169
    //   2925: ldc_w 277
    //   2928: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2931: aload 13
    //   2933: ldc 171
    //   2935: aload 15
    //   2937: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2940: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2943: aload 13
    //   2945: ldc 205
    //   2947: iconst_2
    //   2948: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2951: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2954: aload_0
    //   2955: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2958: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2961: aload 13
    //   2963: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2966: pop
    //   2967: goto -645 -> 2322
    //   2970: astore 12
    //   2972: aload 11
    //   2974: ifnull -640 -> 2334
    //   2977: aload 11
    //   2979: invokeinterface 214 1 0
    //   2984: goto -650 -> 2334
    //   2987: astore_1
    //   2988: aload 11
    //   2990: ifnull +10 -> 3000
    //   2993: aload 11
    //   2995: invokeinterface 214 1 0
    //   3000: aload_1
    //   3001: athrow
    //   3002: aload 13
    //   3004: invokevirtual 236	android/content/ContentValues:clear	()V
    //   3007: aload 13
    //   3009: ldc 165
    //   3011: lload 6
    //   3013: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3016: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3019: aload 13
    //   3021: ldc 169
    //   3023: ldc_w 279
    //   3026: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3029: aload 13
    //   3031: ldc 171
    //   3033: aload_1
    //   3034: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3037: aload 13
    //   3039: ldc 205
    //   3041: iconst_2
    //   3042: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3045: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3048: aload_0
    //   3049: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3052: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3055: aload 13
    //   3057: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3060: pop
    //   3061: goto -465 -> 2596
    //   3064: astore_1
    //   3065: aload 11
    //   3067: ifnull -459 -> 2608
    //   3070: aload 11
    //   3072: invokeinterface 214 1 0
    //   3077: goto -469 -> 2608
    //   3080: astore_1
    //   3081: aload 11
    //   3083: ifnull +10 -> 3093
    //   3086: aload 11
    //   3088: invokeinterface 214 1 0
    //   3093: aload_1
    //   3094: athrow
    //   3095: iconst_m1
    //   3096: ireturn
    //   3097: astore_1
    //   3098: goto -17 -> 3081
    //   3101: astore_1
    //   3102: aconst_null
    //   3103: astore 11
    //   3105: goto -40 -> 3065
    //   3108: astore_1
    //   3109: goto -121 -> 2988
    //   3112: astore 11
    //   3114: aconst_null
    //   3115: astore 11
    //   3117: goto -145 -> 2972
    //   3120: astore_1
    //   3121: goto -231 -> 2890
    //   3124: astore 11
    //   3126: aconst_null
    //   3127: astore 11
    //   3129: goto -255 -> 2874
    //   3132: astore_1
    //   3133: goto -340 -> 2793
    //   3136: astore 11
    //   3138: aconst_null
    //   3139: astore 11
    //   3141: goto -364 -> 2777
    //   3144: astore_1
    //   3145: goto -450 -> 2695
    //   3148: astore 11
    //   3150: aconst_null
    //   3151: astore 11
    //   3153: goto -474 -> 2679
    //   3156: astore_1
    //   3157: goto -2102 -> 1055
    //   3160: astore 11
    //   3162: aconst_null
    //   3163: astore 11
    //   3165: iconst_0
    //   3166: istore_3
    //   3167: lconst_0
    //   3168: lstore 6
    //   3170: goto -2185 -> 985
    //   3173: astore 13
    //   3175: lload 8
    //   3177: lstore 6
    //   3179: goto -2194 -> 985
    //   3182: astore 13
    //   3184: iconst_1
    //   3185: istore_3
    //   3186: lload 8
    //   3188: lstore 6
    //   3190: goto -2205 -> 985
    //   3193: astore 16
    //   3195: aload 13
    //   3197: astore 14
    //   3199: aload 16
    //   3201: astore 13
    //   3203: goto -2191 -> 1012
    //   3206: astore 16
    //   3208: aload 13
    //   3210: astore 14
    //   3212: iconst_1
    //   3213: istore_2
    //   3214: aload 16
    //   3216: astore 13
    //   3218: goto -2206 -> 1012
    //   3221: astore 14
    //   3223: goto -2265 -> 958
    //   3226: astore 14
    //   3228: goto -2270 -> 958
    //   3231: lload 8
    //   3233: lstore 6
    //   3235: iload 5
    //   3237: istore_3
    //   3238: iload 4
    //   3240: istore_2
    //   3241: goto -2816 -> 425
    //   3244: iconst_1
    //   3245: istore_2
    //   3246: iconst_1
    //   3247: istore_3
    //   3248: goto -2845 -> 403
    //   3251: lload 8
    //   3253: lstore 6
    //   3255: goto -2852 -> 403
    //   3258: aconst_null
    //   3259: astore 12
    //   3261: goto -3182 -> 79
    //   3264: aconst_null
    //   3265: astore 15
    //   3267: goto -3221 -> 46
    //   3270: iload_3
    //   3271: istore_2
    //   3272: iconst_1
    //   3273: istore_3
    //   3274: lload 6
    //   3276: lstore 8
    //   3278: goto -3106 -> 172
    //   3281: astore 13
    //   3283: aconst_null
    //   3284: astore 13
    //   3286: goto -2328 -> 958
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3289	0	this	ProfileCardMoreActivity
    //   0	3289	1	paramString	String
    //   80	3192	2	k	int
    //   82	3192	3	m	int
    //   162	3077	4	n	int
    //   404	2832	5	i1	int
    //   199	3076	6	l1	long
    //   165	3112	8	l2	long
    //   184	192	10	bool	boolean
    //   26	3078	11	localObject1	Object
    //   3112	1	11	localException1	Exception
    //   3115	1	11	localObject2	Object
    //   3124	1	11	localException2	Exception
    //   3127	1	11	localObject3	Object
    //   3136	1	11	localException3	Exception
    //   3139	1	11	localObject4	Object
    //   3148	1	11	localException4	Exception
    //   3151	1	11	localObject5	Object
    //   3160	1	11	localException5	Exception
    //   3163	1	11	localObject6	Object
    //   77	2381	12	localObject7	Object
    //   2677	1	12	localException6	Exception
    //   2775	1	12	localException7	Exception
    //   2872	1	12	localException8	Exception
    //   2970	1	12	localException9	Exception
    //   3259	1	12	localObject8	Object
    //   84	884	13	localObject9	Object
    //   979	1	13	localException10	Exception
    //   1010	21	13	localObject10	Object
    //   1033	2023	13	localException11	Exception
    //   3173	1	13	localException12	Exception
    //   3182	14	13	localException13	Exception
    //   3201	16	13	localObject11	Object
    //   3281	1	13	localException14	Exception
    //   3284	1	13	localObject12	Object
    //   122	3089	14	localObject13	Object
    //   3221	1	14	localException15	Exception
    //   3226	1	14	localException16	Exception
    //   44	3222	15	localObject14	Object
    //   95	2045	16	localObject15	Object
    //   3193	7	16	localObject16	Object
    //   3206	9	16	localObject17	Object
    //   223	97	17	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   395	403	979	java/lang/Exception
    //   946	953	979	java/lang/Exception
    //   967	974	979	java/lang/Exception
    //   219	361	1010	finally
    //   204	211	1033	java/lang/Exception
    //   1020	1027	1033	java/lang/Exception
    //   1030	1033	1033	java/lang/Exception
    //   86	161	1050	finally
    //   1351	1479	2677	java/lang/Exception
    //   2610	2674	2677	java/lang/Exception
    //   1226	1347	2694	finally
    //   1626	1753	2775	java/lang/Exception
    //   2709	2772	2775	java/lang/Exception
    //   1502	1622	2792	finally
    //   1899	2036	2872	java/lang/Exception
    //   2807	2869	2872	java/lang/Exception
    //   1776	1895	2889	finally
    //   2183	2322	2970	java/lang/Exception
    //   2904	2967	2970	java/lang/Exception
    //   2059	2179	2987	finally
    //   2461	2596	3064	java/lang/Exception
    //   3002	3061	3064	java/lang/Exception
    //   2337	2457	3080	finally
    //   2461	2596	3097	finally
    //   3002	3061	3097	finally
    //   2337	2457	3101	java/lang/Exception
    //   2183	2322	3108	finally
    //   2904	2967	3108	finally
    //   2059	2179	3112	java/lang/Exception
    //   1899	2036	3120	finally
    //   2807	2869	3120	finally
    //   1776	1895	3124	java/lang/Exception
    //   1626	1753	3132	finally
    //   2709	2772	3132	finally
    //   1502	1622	3136	java/lang/Exception
    //   1351	1479	3144	finally
    //   2610	2674	3144	finally
    //   1226	1347	3148	java/lang/Exception
    //   177	186	3156	finally
    //   191	201	3156	finally
    //   204	211	3156	finally
    //   395	403	3156	finally
    //   946	953	3156	finally
    //   967	974	3156	finally
    //   1020	1027	3156	finally
    //   1030	1033	3156	finally
    //   86	161	3160	java/lang/Exception
    //   177	186	3173	java/lang/Exception
    //   191	201	3182	java/lang/Exception
    //   366	375	3193	finally
    //   384	391	3206	finally
    //   366	375	3221	java/lang/Exception
    //   384	391	3226	java/lang/Exception
    //   219	361	3281	java/lang/Exception
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public String a()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.g(this.app, this.jdField_a_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  void a()
  {
    setContentViewB(2130970552);
    Object localObject1;
    label77:
    label109:
    int n;
    int i2;
    int m;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = "好友设置";
      setTitle((CharSequence)localObject1);
      this.leftView.setText(2131433712);
      this.rightViewText.setVisibility(8);
      localObject1 = findViewById(2131363747);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label225;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131363758);
      if (this.jdField_a_of_type_ArrayOfInt[15] != 1) {
        break label235;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      n = -1;
      i2 = -1;
      m = 4;
      localObject1 = getIntent().getStringExtra("cur_add_source");
      if (!BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label245;
      }
      m = 6;
    }
    int k;
    int i1;
    for (;;)
    {
      k = 0;
      while (k <= m)
      {
        int i4 = i2;
        int i3 = n;
        if (this.jdField_a_of_type_ArrayOfInt[k] == 1)
        {
          i1 = n;
          if (n < 0) {
            i1 = k;
          }
          i4 = i2;
          i3 = i1;
          if (i2 < k)
          {
            i4 = k;
            i3 = i1;
          }
        }
        k += 1;
        i2 = i4;
        n = i3;
      }
      localObject1 = getString(2131437177);
      break;
      label225:
      ((View)localObject1).setVisibility(8);
      break label77;
      label235:
      ((View)localObject1).setVisibility(8);
      break label109;
      label245:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        m = 5;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371038));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_nick_name");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_e_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371039));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131371040));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371043));
      a(2, this.jdField_a_of_type_AndroidWidgetRelativeLayout, n, i2);
      a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new tlh(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371044));
      a(3, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371046));
      a(4, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371045));
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label673;
      }
      a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
      }
      label508:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371047));
      if ((!BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!QidianManager.b(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label685;
      }
      i1 = 1;
      label555:
      if (i1 == 0) {
        break label691;
      }
      a(6, this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      label573:
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371048));
      if (!"troopMembercard".equals(getIntent().getStringExtra("from"))) {
        break label703;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      label615:
      n = -1;
      m = -1;
      k = 8;
      label622:
      if (k > 12) {
        break label730;
      }
      if (this.jdField_a_of_type_ArrayOfInt[k] != 1) {
        break label1493;
      }
      if (n >= 0) {
        break label1490;
      }
      n = k;
      label644:
      if (m >= k) {
        break label1487;
      }
      m = k;
    }
    label673:
    label685:
    label691:
    label703:
    label979:
    label1493:
    for (;;)
    {
      k += 1;
      break label622;
      a(1, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      break;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label508;
      i1 = 0;
      break label555;
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label573;
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("推荐该联系人");
      a(7, this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem, 7, 7);
      break label615;
      label730:
      this.h = ((FormSimpleItem)findViewById(2131371049));
      a(8, this.h, n, m);
      if (i1 != 0) {
        this.h.setVisibility(8);
      }
      this.i = ((FormSimpleItem)findViewById(2131371050));
      a(9, this.i, n, m);
      if ((i1 != 0) || (!QQStoryManager.j())) {
        this.i.setVisibility(8);
      }
      this.j = ((FormSimpleItem)findViewById(2131363744));
      a(10, this.j, n, m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371051));
      Object localObject2;
      if ((i1 == 0) && (this.jdField_a_of_type_ArrayOfInt[12] == 1)) {
        if ((12 == n) && (12 == m))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363745));
          if (this.jdField_a_of_type_ArrayOfInt[11] != 1) {
            break label1437;
          }
          if ((11 != n) || (11 != m)) {
            break label1392;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("屏蔽此人");
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131371052));
          if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
            break label1449;
          }
          localObject1 = ((FriendsManager)this.app.getManager(50)).b(AppConstants.av);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131437184));
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          ((CardHandler)this.app.a(2)).r();
          if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            localObject2 = (FriendsManager)this.app.getManager(50);
            if (localObject2 != null) {
              break label1461;
            }
            localObject1 = null;
            label1120:
            if (localObject1 != null)
            {
              this.jdField_b_of_type_JavaLangString = ((Friends)localObject1).remark;
              this.jdField_d_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
              localObject2 = ((FriendsManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
              if ((localObject2 != null) && (!Utils.a(this.jdField_c_of_type_JavaLangString, ((Groups)localObject2).group_name))) {
                this.jdField_c_of_type_JavaLangString = ((Groups)localObject2).group_name;
              }
              if (((Friends)localObject1).gathtertype == 1)
              {
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              }
            }
            if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0))
            {
              localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
              if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                break label1478;
              }
            }
          }
        }
      }
      for (localObject1 = "";; localObject1 = this.jdField_c_of_type_JavaLangString)
      {
        ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
        if (this.jdField_a_of_type_ArrayOfInt[11] == 1)
        {
          this.jdField_a_of_type_Boolean = a();
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        }
        if (AppSetting.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("收起到不常联系好友 ");
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setFocusable(true);
          this.j.setContentDescription(getString(2131436881));
        }
        return;
        if (12 == n)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          break;
        }
        if (12 == m)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label908;
        label1392:
        if (11 == n)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
          break label953;
        }
        if (11 == m)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
          break label953;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
        break label953;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label979;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        break label1088;
        localObject1 = ((FriendsManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label1120;
      }
      continue;
      break label644;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a(getTitleBarHeight()).show();
  }
  
  void a(int paramInt1, RelativeLayout paramRelativeLayout, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramRelativeLayout == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramRelativeLayout.setVisibility(0);
      paramRelativeLayout.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838629));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838641));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838636));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838639));
      return;
    }
    paramRelativeLayout.setVisibility(8);
  }
  
  void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (paramTextView != null)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
        paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
      }
    }
    else {
      return;
    }
    paramTextView.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void a(BusinessCard paramBusinessCard)
  {
    int m = 0;
    if (paramBusinessCard == null) {
      return;
    }
    String str = "";
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Friends)localObject2).remark != null)
        {
          localObject1 = str;
          if (((Friends)localObject2).isRemark == 1) {
            localObject1 = ((Friends)localObject2).remark;
          }
        }
      }
      if (TextUtils.isEmpty(paramBusinessCard.picUrl)) {
        break label242;
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130843076));
    }
    int k;
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (!TextUtils.isEmpty(paramBusinessCard.company))
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append(paramBusinessCard.company);
      }
      if ((paramBusinessCard.mobilesNum == null) || (paramBusinessCard.mobilesNum.isEmpty())) {
        break label254;
      }
      k = 0;
      while (k < paramBusinessCard.mobilesNum.size())
      {
        if (((StringBuilder)localObject2).length() != 0) {
          ((StringBuilder)localObject2).append("，");
        }
        ((StringBuilder)localObject2).append((String)paramBusinessCard.mobilesNum.get(k));
        k += 1;
      }
      localObject2 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label242:
      a(this.jdField_a_of_type_AndroidWidgetTextView, null);
    }
    label254:
    if ((paramBusinessCard.descs != null) && (!paramBusinessCard.descs.isEmpty()))
    {
      k = m;
      if (((StringBuilder)localObject2).length() != 0)
      {
        ((StringBuilder)localObject2).append("，");
        k = m;
      }
      while (k < paramBusinessCard.descs.size())
      {
        ((StringBuilder)localObject2).append((String)paramBusinessCard.descs.get(k));
        k += 1;
      }
    }
    this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    b((String)localObject1);
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(this);
    if (Utils.b(paramString)) {
      localActionSheet.a(2131434544);
    }
    for (;;)
    {
      localActionSheet.a(2131434534, 3);
      localActionSheet.c(2131433029);
      localActionSheet.a(new tli(this, paramString, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.a(2131434543);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = ((FriendsManager)this.app.getManager(50)).a(paramString1);
    int k = 17;
    if (localObject1 != null) {
      k = ((Friends)localObject1).cSpecialFlag;
    }
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    Object localObject3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1 + "&cspecialflag=" + k;
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramString1 + "&version=1&cspecialflag=" + k;
    String str2 = "http://share.mp.qq.com/cgi/share.php?uin=" + paramString1 + "&account_flag=" + -7 + "&jumptype=1&card_type=crm&cspecialflag=" + k;
    localObject1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    localObject2 = ((AbsShareMsg.Builder)localObject2).b(14).a(2).a("推荐了" + paramString2).a("plugin", str2, "", (String)localObject3, str1).b(getResources().getString(2131433782)).a();
    localObject3 = new StructMsgItemLayout2();
    ((AbsStructMsgItem)localObject3).b(1);
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemCover((String)localObject1));
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemTitle(paramString2));
    ((AbsStructMsgItem)localObject3).a(new StructMsgItemSummary("帐号: " + QidianManager.b(this.app, paramString1)));
    ((AbsShareMsg)localObject2).addItem(a("推荐好友"));
    ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 20);
    paramString1.putInt("structmsg_service_id", paramInt);
    paramString1.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
    paramString1.putBoolean("k_dataline", false);
    paramString2 = new Intent();
    paramString2.putExtras(paramString1);
    ForwardBaseOption.a(this, paramString2, 21);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(paramInt).a("推荐了" + paramString2).a(2).a("plugin", "", paramString4, paramString5, paramString6).b(paramString7).a();
    Object localObject2 = new StructMsgItemLayoutDefault();
    ((AbsStructMsgItem)localObject2).b(1);
    ((AbsStructMsgItem)localObject2).a(paramString1);
    StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
    localStructMsgItemLayout2.b(1);
    localStructMsgItemLayout2.a(new StructMsgItemCover(paramString6));
    localStructMsgItemLayout2.a(new StructMsgItemTitle(paramString2));
    localStructMsgItemLayout2.a(new StructMsgItemSummary(paramString3));
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    ((AbsShareMsg)localObject1).addItem(localStructMsgItemLayout2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("forward_type", 20);
    ((Bundle)localObject2).putInt("structmsg_service_id", paramInt);
    ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ((Bundle)localObject2).putBoolean("k_dataline", false);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    ForwardBaseOption.a(this, (Intent)localObject1, 21);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(300);
      ((StringBuilder)localObject1).append("recommentFriend [title: ").append(paramString1).append(", nickname: ").append(paramString2).append(", info: ").append(paramString3).append(", serviceId: ").append(paramInt).append(", pActionData: ").append(paramString4).append(", aActionData: ").append(paramString5).append(", iActionData: ").append(paramString6).append(", compatibleText: ").append(paramString7).append("]");
      QLog.i("IphoneTitleBarActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int k;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = a();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          k = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(k, (List)localObject);
            k = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            m = k;
            if (m == 0) {
              break label314;
            }
            if (paramBoolean) {
              break label309;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.jdField_a_of_type_Int |= 0x2;
            d();
            return;
            localShieldMsgManger.a(k, (List)localObject);
            continue;
            k = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int m = k;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          m = k;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              m = 1;
              break;
              this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label309:
            paramBoolean = false;
          }
        }
      }
      label314:
      if (paramBoolean) {
        a(2131434527, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131434526, 1);
      }
    }
    a(2131433023, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    e();
    if ((this.jdField_a_of_type_Int & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label72;
      }
      if (!paramBoolean2) {
        break label61;
      }
      a(2131434528, 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131434524, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131434527, 1);
      } else {
        a(2131434526, 1);
      }
    }
  }
  
  boolean a()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.app.getManager(15);
      if (localShieldMsgManger == null) {
        break label162;
      }
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendsManager)this.app.getManager(50);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = a();
      }
    }
    label162:
    return false;
  }
  
  void b()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[16];
    int k = 0;
    while (k < 16)
    {
      this.jdField_a_of_type_ArrayOfInt[k] = 0;
      k += 1;
    }
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[3] = 1;
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[13] = 1;
        this.jdField_a_of_type_ArrayOfInt[14] = 1;
      }
    }
    for (;;)
    {
      if (((QidianManager)this.app.getManager(164)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[6] = 0;
      }
      return;
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[2] = 1;
      this.jdField_a_of_type_ArrayOfInt[5] = 1;
      if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
      }
      this.jdField_a_of_type_ArrayOfInt[7] = 1;
      this.jdField_a_of_type_ArrayOfInt[8] = 1;
      this.jdField_a_of_type_ArrayOfInt[9] = 1;
      this.jdField_a_of_type_ArrayOfInt[10] = 1;
      this.jdField_a_of_type_ArrayOfInt[12] = 1;
      this.jdField_a_of_type_ArrayOfInt[14] = 1;
      this.jdField_a_of_type_ArrayOfInt[15] = 1;
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
      {
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[11] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
      else if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ArrayOfInt[1] = 1;
        this.jdField_a_of_type_ArrayOfInt[7] = 1;
        this.jdField_a_of_type_ArrayOfInt[15] = 1;
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight() - (int)(localDisplayMetrics.density * 10.0F));
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      for (paramString = "" + this.jdField_f_of_type_JavaLangString;; paramString = this.jdField_b_of_type_JavaLangString + "，" + this.jdField_f_of_type_JavaLangString)
      {
        localTextView.setText(paramString);
        if (this.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_b_of_type_JavaLangString);
        setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
        return;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localTextView.setText(paramString);
      break;
    }
  }
  
  void c()
  {
    Object localObject = (FriendsManager)this.app.getManager(50);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(getActivity(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(SharePreferenceUtils.a(this, "bc_remark_first"))) {}
    while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8)) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371053));
    }
    if (paramInt1 < 0) {}
    for (paramInt1 = 0;; paramInt1 = AIOUtils.a(10.0F, getResources()))
    {
      int k = paramInt2;
      if (paramInt2 < 0) {
        k = 0;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(paramInt1, k, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      SharePreferenceUtils.a(this, "bc_remark_first", "false");
      return;
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434469);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt2 == -1) {}
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return;
    case 1003: 
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("result");
        bool = paramIntent.getBooleanExtra("hasChange", false);
      }
      break;
    }
    for (paramIntent = (Intent)localObject;; paramIntent = (Intent)localObject)
    {
      if (paramIntent == null) {
        paramIntent = "";
      }
      for (;;)
      {
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          if ((!bool) && (paramIntent.equals(this.jdField_e_of_type_JavaLangString))) {
            break;
          }
          if (!paramIntent.equals(this.jdField_b_of_type_JavaLangString))
          {
            localObject = (FriendListHandler)this.app.a(1);
            if (localObject != null)
            {
              ((FriendListHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent, false);
              this.jdField_a_of_type_Int |= 0x1;
              b(paramIntent);
              paramIntent = new QZoneDistributedAppCtrl.Control();
              paramIntent.jdField_a_of_type_Int = 5;
              QZoneDistributedAppCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).a(paramIntent);
              return;
            }
            a(2131435797, 1);
            return;
          }
          a(2131435796, 0);
          return;
        }
        a(2131434628, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131433311));
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
        return;
      }
      bool = false;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)getIntent().getParcelableExtra("BusinessCard"));
    this.jdField_d_of_type_Boolean = "troopMembercard".equals(getIntent().getStringExtra("from"));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      super.finish();
    }
    for (;;)
    {
      return true;
      try
      {
        b();
        a();
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager = ((BusinessCardManager)this.app.getManager(111));
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
        if (this.jdField_d_of_type_JavaLangString != null) {
          continue;
        }
        ThreadManager.post(new tlg(this), 5, null, true);
        return true;
      }
      catch (NoSuchFieldError paramBundle)
      {
        for (;;)
        {
          super.finish();
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    e();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SpecialCareInfo localSpecialCareInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (this.j.getVisibility() == 0)
    {
      if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0)) {
        this.j.setRightText(getString(2131436054));
      }
    }
    else {
      return;
    }
    this.j.setRightText(getString(2131436055));
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((Card)localObject1).strReMark == null) || (((Card)localObject1).strReMark.length() <= 0)) {
        break label148;
      }
    }
    label143:
    label148:
    for (localObject1 = ((Card)localObject1).strReMark;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30)
        {
          localObject1 = a();
          if (localObject1 == null) {
            break label143;
          }
        }
      }
      for (Object localObject2 = ((ProfileActivity.CardContactInfo)localObject1).jdField_a_of_type_JavaLangString;; localObject2 = null)
      {
        this.jdField_d_of_type_JavaLangString = ((String)localObject2);
        if (QLog.isDevelopLevel()) {
          QLog.i("IphoneTitleBarActivity", 4, "initRemark, " + this.jdField_d_of_type_JavaLangString);
        }
        return;
        localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = 1;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if ((paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      if (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label82;
      }
      if (this.jdField_a_of_type_Boolean != paramBoolean) {
        break label64;
      }
    }
    label64:
    label82:
    do
    {
      return;
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(bool1);
      return;
      if (paramCompoundButton == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          paramCompoundButton = (FriendListHandler)this.app.a(1);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          paramCompoundButton.a((short)1, localArrayList, paramBoolean);
          if (paramBoolean)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004C5A", "0X8004C5A", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8004C5B", "0X8004C5B", 0, 0, "", "", "", "");
          return;
        }
        a(2131433023, 1);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        paramCompoundButton = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (!paramBoolean) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          paramCompoundButton.setChecked(paramBoolean);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          return;
        }
      }
    } while (paramCompoundButton != this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a());
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      ((CardHandler)this.app.a(2)).j(paramBoolean);
      paramCompoundButton = this.app;
      if (paramBoolean) {}
      for (;;)
      {
        ReportController.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(k), "", "", "");
        return;
        k = 0;
      }
    }
    a(2131433023, 1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    paramCompoundButton = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!paramBoolean) {}
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int k;
    if (paramView == null) {
      k = 0;
    }
    Object localObject;
    switch (k)
    {
    default: 
    case 2131371039: 
    case 2131371040: 
    case 2131371044: 
    case 2131371047: 
      do
      {
        long l;
        do
        {
          return;
          k = paramView.getId();
          break;
          l = System.currentTimeMillis();
        } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l));
        this.jdField_a_of_type_Long = l;
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, this.app, this);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_more", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8007750", "0X8007750", 1, 0, "", "", "", "");
        return;
        c();
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getFileThreadHandler().post(new tlp(this));
      return;
    case 2131371048: 
      if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = getIntent().getStringExtra("recommend_campus_name");
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = ContactUtils.f(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1362;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      break;
    }
    label1362:
    for (;;)
    {
      String str1 = getIntent().getStringExtra("recommend_campus_info");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      str1 = String.format(Locale.getDefault(), "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=campus_circle&source=sharecard&uin=%s&name=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView });
      a("推荐校园圈联系人", paramView, (String)localObject, 109, "AppCmd://OpenContactInfo/?uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, str1, getResources().getString(2131433784));
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
      for (k = 1;; k = 2)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80050E7", "0X80050E7", k, 0, "", "", "", "");
        return;
        if (((QidianManager)this.app.getManager(164)).f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.j(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          localObject = getIntent().getStringExtra("key_nick_name");
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, 14);
          break;
        }
        str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        String str2 = "AppCmd://OpenContactInfo/?uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString = ContactUtils.j(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        localObject = getIntent().getStringExtra("SHARE_NICK_NAME");
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
        a("推荐联系人", paramView, "帐号: " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 14, str2, str1, str1, getResources().getString(2131433782));
        break;
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {
            break label891;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          a(paramView);
          return;
        }
        catch (Exception paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IphoneTitleBarActivity", 2, paramView, new Object[0]);
        return;
        label891:
        paramView = null;
      }
      if (((HotChatManager)this.app.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
        ReportPlugin.a(this, 202, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getAccount());
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
        {
          ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "6bW#X@~L.+X)4%$>"), null, null, this.app.getCurrentAccountUin(), 3008, null);
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
          paramView = (View)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          }
          ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, this.app.getAccount(), 10027, null);
        }
      }
      try
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        paramView.jdField_b_of_type_JavaLangString = this.app.getCurrentNickname();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
        ReportController.b(this.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      }
      catch (Exception paramView) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
      return;
      paramView = new Intent(this, QQSpecialCareSettingActivity.class);
      paramView.putExtra("key_friend_uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramView.putExtra("key_start_from", 3);
      startActivity(paramView);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "1", "", "", "");
      return;
      paramView = new Intent(this, QQStoryShieldActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      paramView.putExtra("from", 3);
      startActivity(paramView);
      StoryReportor.a("person_data_set", "clk_set", 0, 0, new String[] { "", "", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */