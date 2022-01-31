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
import tdm;
import tdn;
import tdo;
import tdp;
import tdq;
import tdr;
import tdt;
import tdu;
import tdv;

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
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tdu(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tdr(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new tdp(this);
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new tdq(this);
  BusinessCardManager jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager;
  BusinessCardObserver jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardObserver = new tdt(this);
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
    //   30: ifnull +3239 -> 3269
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
    //   70: ifne +828 -> 898
    //   73: aload_0
    //   74: getfield 133	com/tencent/mobileqq/activity/ProfileCardMoreActivity:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: astore 12
    //   79: iconst_0
    //   80: istore_2
    //   81: iconst_0
    //   82: istore 4
    //   84: aconst_null
    //   85: astore 13
    //   87: aload_0
    //   88: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   91: astore 16
    //   93: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   96: astore 14
    //   98: new 151	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   105: ldc 154
    //   107: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 12
    //   112: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 160
    //   117: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 11
    //   125: aload 16
    //   127: aload 14
    //   129: iconst_4
    //   130: anewarray 98	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: ldc 165
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: ldc 167
    //   142: aastore
    //   143: dup
    //   144: iconst_2
    //   145: ldc 169
    //   147: aastore
    //   148: dup
    //   149: iconst_3
    //   150: ldc 171
    //   152: aastore
    //   153: aload 11
    //   155: aconst_null
    //   156: aconst_null
    //   157: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore 11
    //   162: iconst_0
    //   163: istore_3
    //   164: lconst_0
    //   165: lstore 8
    //   167: iload 4
    //   169: istore_2
    //   170: aload 11
    //   172: ifnull +3084 -> 3256
    //   175: aload 11
    //   177: invokeinterface 183 1 0
    //   182: istore 10
    //   184: iload 10
    //   186: ifeq +3070 -> 3256
    //   189: aload 11
    //   191: iconst_0
    //   192: invokeinterface 187 2 0
    //   197: lstore 6
    //   199: iload_2
    //   200: istore 4
    //   202: aload 15
    //   204: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   207: astore 13
    //   209: aload 13
    //   211: ifnull +830 -> 1041
    //   214: aconst_null
    //   215: astore 14
    //   217: aload_0
    //   218: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   221: astore 16
    //   223: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   226: astore 13
    //   228: new 151	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   235: ldc 192
    //   237: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: lload 6
    //   242: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   245: ldc 197
    //   247: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 169
    //   252: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 199
    //   257: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 201
    //   262: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 203
    //   267: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 171
    //   272: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 199
    //   277: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 15
    //   282: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   285: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 203
    //   290: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 205
    //   295: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 199
    //   300: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iconst_2
    //   304: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc 160
    //   309: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore 17
    //   317: aload 16
    //   319: aload 13
    //   321: iconst_5
    //   322: anewarray 98	java/lang/String
    //   325: dup
    //   326: iconst_0
    //   327: ldc 165
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: ldc 167
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: ldc 169
    //   339: aastore
    //   340: dup
    //   341: iconst_3
    //   342: ldc 171
    //   344: aastore
    //   345: dup
    //   346: iconst_4
    //   347: ldc 205
    //   349: aastore
    //   350: aload 17
    //   352: aconst_null
    //   353: aconst_null
    //   354: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   357: astore 13
    //   359: aload 13
    //   361: ifnull +568 -> 929
    //   364: aload 13
    //   366: invokeinterface 211 1 0
    //   371: istore 10
    //   373: iload 10
    //   375: ifeq +554 -> 929
    //   378: iconst_1
    //   379: istore_3
    //   380: iconst_1
    //   381: istore_2
    //   382: aload 13
    //   384: invokeinterface 214 1 0
    //   389: iconst_0
    //   390: ifeq +2859 -> 3249
    //   393: new 216	java/lang/NullPointerException
    //   396: dup
    //   397: invokespecial 217	java/lang/NullPointerException:<init>	()V
    //   400: athrow
    //   401: iload_3
    //   402: istore 5
    //   404: lload 6
    //   406: lstore 8
    //   408: iload_2
    //   409: istore 4
    //   411: aload 11
    //   413: ifnull +2823 -> 3236
    //   416: aload 11
    //   418: invokeinterface 214 1 0
    //   423: iload_3
    //   424: ifne +642 -> 1066
    //   427: iconst_1
    //   428: istore_3
    //   429: iconst_0
    //   430: istore_2
    //   431: new 219	android/content/ContentValues
    //   434: dup
    //   435: invokespecial 220	android/content/ContentValues:<init>	()V
    //   438: astore 13
    //   440: iload_3
    //   441: iconst_1
    //   442: if_icmpne +642 -> 1084
    //   445: aload_0
    //   446: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   449: getstatic 223	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   452: aload 13
    //   454: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   457: invokestatic 233	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   460: lstore 6
    //   462: aload 12
    //   464: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifne +51 -> 518
    //   470: aload 13
    //   472: invokevirtual 236	android/content/ContentValues:clear	()V
    //   475: aload 13
    //   477: ldc 165
    //   479: lload 6
    //   481: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   484: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   487: aload 13
    //   489: ldc 169
    //   491: ldc 248
    //   493: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 13
    //   498: ldc 171
    //   500: aload 12
    //   502: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_0
    //   506: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   509: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   512: aload 13
    //   514: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   517: pop
    //   518: aload 15
    //   520: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   523: ifnonnull +11 -> 534
    //   526: aload 15
    //   528: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   531: ifnull +95 -> 626
    //   534: aload 13
    //   536: invokevirtual 236	android/content/ContentValues:clear	()V
    //   539: aload 13
    //   541: ldc 165
    //   543: lload 6
    //   545: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   548: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   551: aload 13
    //   553: ldc 169
    //   555: ldc_w 259
    //   558: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload 15
    //   563: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   566: ifnull +15 -> 581
    //   569: aload 13
    //   571: ldc 171
    //   573: aload 15
    //   575: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   578: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 15
    //   583: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   586: ifnull +16 -> 602
    //   589: aload 13
    //   591: ldc_w 261
    //   594: aload 15
    //   596: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   599: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   602: aload 13
    //   604: ldc 205
    //   606: iconst_1
    //   607: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   613: aload_0
    //   614: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   617: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   620: aload 13
    //   622: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   625: pop
    //   626: aload 15
    //   628: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   631: ifnull +65 -> 696
    //   634: aload 13
    //   636: invokevirtual 236	android/content/ContentValues:clear	()V
    //   639: aload 13
    //   641: ldc 165
    //   643: lload 6
    //   645: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   648: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   651: aload 13
    //   653: ldc 169
    //   655: ldc 201
    //   657: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: aload 13
    //   662: ldc 171
    //   664: aload 15
    //   666: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   669: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   672: aload 13
    //   674: ldc 205
    //   676: iconst_2
    //   677: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   683: aload_0
    //   684: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   687: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   690: aload 13
    //   692: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   695: pop
    //   696: aload 15
    //   698: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   701: ifnull +65 -> 766
    //   704: aload 13
    //   706: invokevirtual 236	android/content/ContentValues:clear	()V
    //   709: aload 13
    //   711: ldc 165
    //   713: lload 6
    //   715: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   718: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   721: aload 13
    //   723: ldc 169
    //   725: ldc 201
    //   727: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload 13
    //   732: ldc 171
    //   734: aload 15
    //   736: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   739: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 13
    //   744: ldc 205
    //   746: iconst_3
    //   747: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   753: aload_0
    //   754: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   757: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   760: aload 13
    //   762: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   765: pop
    //   766: aload 15
    //   768: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   771: ifnull +66 -> 837
    //   774: aload 13
    //   776: invokevirtual 236	android/content/ContentValues:clear	()V
    //   779: aload 13
    //   781: ldc 165
    //   783: lload 6
    //   785: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   788: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   791: aload 13
    //   793: ldc 169
    //   795: ldc_w 277
    //   798: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload 13
    //   803: ldc 171
    //   805: aload 15
    //   807: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   810: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload 13
    //   815: ldc 205
    //   817: iconst_2
    //   818: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   824: aload_0
    //   825: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   828: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   831: aload 13
    //   833: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   836: pop
    //   837: aload 13
    //   839: invokevirtual 236	android/content/ContentValues:clear	()V
    //   842: aload 13
    //   844: ldc 165
    //   846: lload 6
    //   848: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   851: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   854: aload 13
    //   856: ldc 169
    //   858: ldc_w 279
    //   861: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload 13
    //   866: ldc 171
    //   868: aload_1
    //   869: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   872: aload 13
    //   874: ldc 205
    //   876: iconst_2
    //   877: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   880: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   883: aload_0
    //   884: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   887: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   890: aload 13
    //   892: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   895: pop
    //   896: iconst_0
    //   897: ireturn
    //   898: aload 15
    //   900: getfield 282	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   903: ifnull +13 -> 916
    //   906: aload 15
    //   908: getfield 282	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqNickName	Ljava/lang/String;
    //   911: astore 12
    //   913: goto -834 -> 79
    //   916: aload_1
    //   917: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   920: ifne +2343 -> 3263
    //   923: aload_1
    //   924: astore 12
    //   926: goto -847 -> 79
    //   929: iconst_0
    //   930: istore_2
    //   931: iconst_0
    //   932: istore 4
    //   934: iload_2
    //   935: istore_3
    //   936: aload 13
    //   938: ifnull +2337 -> 3275
    //   941: iload 4
    //   943: istore_3
    //   944: aload 13
    //   946: invokeinterface 214 1 0
    //   951: iload_2
    //   952: istore_3
    //   953: goto +2322 -> 3275
    //   956: iload_2
    //   957: istore_3
    //   958: aload 13
    //   960: ifnull +2315 -> 3275
    //   963: iload_2
    //   964: istore_3
    //   965: aload 13
    //   967: invokeinterface 214 1 0
    //   972: iload_2
    //   973: istore_3
    //   974: goto +2301 -> 3275
    //   977: astore 13
    //   979: iload_3
    //   980: istore_2
    //   981: iconst_1
    //   982: istore_3
    //   983: iload_3
    //   984: istore 5
    //   986: lload 6
    //   988: lstore 8
    //   990: iload_2
    //   991: istore 4
    //   993: aload 11
    //   995: ifnull +2241 -> 3236
    //   998: aload 11
    //   1000: invokeinterface 214 1 0
    //   1005: goto -582 -> 423
    //   1008: astore 13
    //   1010: aload 14
    //   1012: ifnull +13 -> 1025
    //   1015: iload_2
    //   1016: istore 4
    //   1018: aload 14
    //   1020: invokeinterface 214 1 0
    //   1025: iload_2
    //   1026: istore 4
    //   1028: aload 13
    //   1030: athrow
    //   1031: astore 13
    //   1033: iconst_1
    //   1034: istore_3
    //   1035: iload 4
    //   1037: istore_2
    //   1038: goto -55 -> 983
    //   1041: iconst_0
    //   1042: istore_2
    //   1043: iconst_1
    //   1044: istore_3
    //   1045: goto -644 -> 401
    //   1048: astore 11
    //   1050: aload 13
    //   1052: astore_1
    //   1053: aload_1
    //   1054: ifnull +9 -> 1063
    //   1057: aload_1
    //   1058: invokeinterface 214 1 0
    //   1063: aload 11
    //   1065: athrow
    //   1066: iload_2
    //   1067: ifne +10 -> 1077
    //   1070: iconst_1
    //   1071: istore_3
    //   1072: iconst_0
    //   1073: istore_2
    //   1074: goto -643 -> 431
    //   1077: iconst_1
    //   1078: istore_2
    //   1079: iconst_0
    //   1080: istore_3
    //   1081: goto -650 -> 431
    //   1084: iload_2
    //   1085: iconst_1
    //   1086: if_icmpne +2006 -> 3092
    //   1089: aload 15
    //   1091: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1094: ifnull +118 -> 1212
    //   1097: aload 13
    //   1099: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1102: aload 13
    //   1104: ldc 169
    //   1106: ldc 201
    //   1108: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: aload 13
    //   1113: ldc 171
    //   1115: aload 15
    //   1117: getfield 190	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqMobileNum	Ljava/lang/String;
    //   1120: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: aload 13
    //   1125: ldc 205
    //   1127: iconst_2
    //   1128: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1131: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1134: aload_0
    //   1135: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1138: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1141: aload 13
    //   1143: new 151	java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1150: ldc 192
    //   1152: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: lload 6
    //   1157: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1160: ldc 197
    //   1162: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: ldc 169
    //   1167: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: ldc 199
    //   1172: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: ldc 201
    //   1177: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: ldc 203
    //   1182: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc 205
    //   1187: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: ldc 199
    //   1192: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: iconst_2
    //   1196: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1199: ldc 160
    //   1201: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: aconst_null
    //   1208: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1211: pop
    //   1212: aload 15
    //   1214: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1217: ifnull +271 -> 1488
    //   1220: aconst_null
    //   1221: astore 11
    //   1223: aload_0
    //   1224: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1227: astore 14
    //   1229: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1232: astore 16
    //   1234: new 151	java/lang/StringBuilder
    //   1237: dup
    //   1238: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1241: ldc 192
    //   1243: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: lload 6
    //   1248: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1251: ldc 197
    //   1253: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: ldc 169
    //   1258: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: ldc 199
    //   1263: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: ldc_w 259
    //   1269: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: ldc 203
    //   1274: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: ldc 205
    //   1279: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: ldc 199
    //   1284: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: iconst_1
    //   1288: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: ldc 160
    //   1293: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: astore 12
    //   1301: aload 14
    //   1303: aload 16
    //   1305: iconst_5
    //   1306: anewarray 98	java/lang/String
    //   1309: dup
    //   1310: iconst_0
    //   1311: ldc 165
    //   1313: aastore
    //   1314: dup
    //   1315: iconst_1
    //   1316: ldc 167
    //   1318: aastore
    //   1319: dup
    //   1320: iconst_2
    //   1321: ldc 169
    //   1323: aastore
    //   1324: dup
    //   1325: iconst_3
    //   1326: ldc_w 261
    //   1329: aastore
    //   1330: dup
    //   1331: iconst_4
    //   1332: ldc 205
    //   1334: aastore
    //   1335: aload 12
    //   1337: aconst_null
    //   1338: aconst_null
    //   1339: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1342: astore 12
    //   1344: aload 12
    //   1346: astore 11
    //   1348: aload 11
    //   1350: invokeinterface 211 1 0
    //   1355: ifeq +1252 -> 2607
    //   1358: aload 13
    //   1360: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1363: aload 13
    //   1365: ldc 169
    //   1367: ldc_w 259
    //   1370: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload 13
    //   1375: ldc_w 261
    //   1378: aload 15
    //   1380: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   1383: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1386: aload 13
    //   1388: ldc 205
    //   1390: iconst_1
    //   1391: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1394: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1397: aload_0
    //   1398: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1401: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1404: aload 13
    //   1406: new 151	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1413: ldc 192
    //   1415: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: lload 6
    //   1420: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1423: ldc 197
    //   1425: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: ldc 169
    //   1430: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: ldc 199
    //   1435: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: ldc_w 259
    //   1441: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: ldc 203
    //   1446: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: ldc 205
    //   1451: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: ldc 199
    //   1456: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: iconst_1
    //   1460: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: ldc 160
    //   1465: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: aconst_null
    //   1472: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1475: pop
    //   1476: aload 11
    //   1478: ifnull +10 -> 1488
    //   1481: aload 11
    //   1483: invokeinterface 214 1 0
    //   1488: aload 15
    //   1490: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1493: ifnull +269 -> 1762
    //   1496: aconst_null
    //   1497: astore 11
    //   1499: aload_0
    //   1500: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1503: astore 14
    //   1505: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1508: astore 16
    //   1510: new 151	java/lang/StringBuilder
    //   1513: dup
    //   1514: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1517: ldc 192
    //   1519: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: lload 6
    //   1524: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1527: ldc 197
    //   1529: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc 169
    //   1534: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: ldc 199
    //   1539: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: ldc_w 259
    //   1545: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1548: ldc 203
    //   1550: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: ldc 205
    //   1555: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: ldc 199
    //   1560: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: iconst_1
    //   1564: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1567: ldc 160
    //   1569: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: astore 12
    //   1577: aload 14
    //   1579: aload 16
    //   1581: iconst_5
    //   1582: anewarray 98	java/lang/String
    //   1585: dup
    //   1586: iconst_0
    //   1587: ldc 165
    //   1589: aastore
    //   1590: dup
    //   1591: iconst_1
    //   1592: ldc 167
    //   1594: aastore
    //   1595: dup
    //   1596: iconst_2
    //   1597: ldc 169
    //   1599: aastore
    //   1600: dup
    //   1601: iconst_3
    //   1602: ldc 171
    //   1604: aastore
    //   1605: dup
    //   1606: iconst_4
    //   1607: ldc 205
    //   1609: aastore
    //   1610: aload 12
    //   1612: aconst_null
    //   1613: aconst_null
    //   1614: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1617: astore 12
    //   1619: aload 12
    //   1621: astore 11
    //   1623: aload 11
    //   1625: invokeinterface 211 1 0
    //   1630: ifeq +1076 -> 2706
    //   1633: aload 13
    //   1635: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1638: aload 13
    //   1640: ldc 169
    //   1642: ldc_w 259
    //   1645: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1648: aload 13
    //   1650: ldc 171
    //   1652: aload 15
    //   1654: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   1657: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1660: aload 13
    //   1662: ldc 205
    //   1664: iconst_1
    //   1665: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1668: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1671: aload_0
    //   1672: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1675: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1678: aload 13
    //   1680: new 151	java/lang/StringBuilder
    //   1683: dup
    //   1684: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1687: ldc 192
    //   1689: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: lload 6
    //   1694: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1697: ldc 197
    //   1699: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: ldc 169
    //   1704: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: ldc 199
    //   1709: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: ldc_w 259
    //   1715: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: ldc 203
    //   1720: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: ldc 205
    //   1725: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1728: ldc 199
    //   1730: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: iconst_1
    //   1734: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1737: ldc 160
    //   1739: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: aconst_null
    //   1746: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1749: pop
    //   1750: aload 11
    //   1752: ifnull +10 -> 1762
    //   1755: aload 11
    //   1757: invokeinterface 214 1 0
    //   1762: aload 15
    //   1764: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1767: ifnull +278 -> 2045
    //   1770: aconst_null
    //   1771: astore 11
    //   1773: aload_0
    //   1774: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1777: astore 16
    //   1779: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1782: astore 14
    //   1784: new 151	java/lang/StringBuilder
    //   1787: dup
    //   1788: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1791: ldc 192
    //   1793: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: lload 6
    //   1798: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1801: ldc 197
    //   1803: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: ldc 169
    //   1808: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: ldc 199
    //   1813: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: ldc 201
    //   1818: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: ldc 203
    //   1823: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: ldc 205
    //   1828: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: ldc 199
    //   1833: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: iconst_3
    //   1837: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1840: ldc 160
    //   1842: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: astore 12
    //   1850: aload 16
    //   1852: aload 14
    //   1854: iconst_5
    //   1855: anewarray 98	java/lang/String
    //   1858: dup
    //   1859: iconst_0
    //   1860: ldc 165
    //   1862: aastore
    //   1863: dup
    //   1864: iconst_1
    //   1865: ldc 167
    //   1867: aastore
    //   1868: dup
    //   1869: iconst_2
    //   1870: ldc 169
    //   1872: aastore
    //   1873: dup
    //   1874: iconst_3
    //   1875: ldc 171
    //   1877: aastore
    //   1878: dup
    //   1879: iconst_4
    //   1880: ldc 205
    //   1882: aastore
    //   1883: aload 12
    //   1885: aconst_null
    //   1886: aconst_null
    //   1887: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1890: astore 12
    //   1892: aload 12
    //   1894: astore 11
    //   1896: aload 11
    //   1898: invokeinterface 211 1 0
    //   1903: ifeq +901 -> 2804
    //   1906: aload 13
    //   1908: invokevirtual 236	android/content/ContentValues:clear	()V
    //   1911: aload 13
    //   1913: ldc 165
    //   1915: lload 6
    //   1917: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1920: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1923: aload 13
    //   1925: ldc 169
    //   1927: ldc 201
    //   1929: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1932: aload 13
    //   1934: ldc 171
    //   1936: aload 15
    //   1938: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   1941: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1944: aload 13
    //   1946: ldc 205
    //   1948: iconst_3
    //   1949: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1952: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1955: aload_0
    //   1956: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   1959: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   1962: aload 13
    //   1964: new 151	java/lang/StringBuilder
    //   1967: dup
    //   1968: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1971: ldc 192
    //   1973: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: lload 6
    //   1978: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1981: ldc 197
    //   1983: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: ldc 169
    //   1988: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: ldc 199
    //   1993: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: ldc 201
    //   1998: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: ldc 203
    //   2003: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2006: ldc 205
    //   2008: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: ldc 199
    //   2013: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: iconst_3
    //   2017: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2020: ldc 160
    //   2022: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2025: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2028: aconst_null
    //   2029: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2032: pop
    //   2033: aload 11
    //   2035: ifnull +10 -> 2045
    //   2038: aload 11
    //   2040: invokeinterface 214 1 0
    //   2045: aload 15
    //   2047: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2050: ifnull +281 -> 2331
    //   2053: aconst_null
    //   2054: astore 11
    //   2056: aload_0
    //   2057: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2060: astore 14
    //   2062: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2065: astore 12
    //   2067: new 151	java/lang/StringBuilder
    //   2070: dup
    //   2071: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2074: ldc 192
    //   2076: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2079: lload 6
    //   2081: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2084: ldc 197
    //   2086: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc 169
    //   2091: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: ldc 199
    //   2096: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: ldc_w 277
    //   2102: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: ldc 203
    //   2107: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: ldc 205
    //   2112: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: ldc 199
    //   2117: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2120: iconst_2
    //   2121: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2124: ldc 160
    //   2126: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2132: astore 16
    //   2134: aload 14
    //   2136: aload 12
    //   2138: iconst_5
    //   2139: anewarray 98	java/lang/String
    //   2142: dup
    //   2143: iconst_0
    //   2144: ldc 165
    //   2146: aastore
    //   2147: dup
    //   2148: iconst_1
    //   2149: ldc 167
    //   2151: aastore
    //   2152: dup
    //   2153: iconst_2
    //   2154: ldc 169
    //   2156: aastore
    //   2157: dup
    //   2158: iconst_3
    //   2159: ldc 171
    //   2161: aastore
    //   2162: dup
    //   2163: iconst_4
    //   2164: ldc 205
    //   2166: aastore
    //   2167: aload 16
    //   2169: aconst_null
    //   2170: aconst_null
    //   2171: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2174: astore 12
    //   2176: aload 12
    //   2178: astore 11
    //   2180: aload 11
    //   2182: invokeinterface 211 1 0
    //   2187: ifeq +714 -> 2901
    //   2190: aload 13
    //   2192: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2195: aload 13
    //   2197: ldc 165
    //   2199: lload 6
    //   2201: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2204: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2207: aload 13
    //   2209: ldc 169
    //   2211: ldc_w 277
    //   2214: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2217: aload 13
    //   2219: ldc 171
    //   2221: aload 15
    //   2223: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2226: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2229: aload 13
    //   2231: ldc 205
    //   2233: iconst_2
    //   2234: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2237: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2240: aload_0
    //   2241: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2244: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2247: aload 13
    //   2249: new 151	java/lang/StringBuilder
    //   2252: dup
    //   2253: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2256: ldc 192
    //   2258: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: lload 6
    //   2263: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2266: ldc 197
    //   2268: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: ldc 169
    //   2273: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: ldc 199
    //   2278: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: ldc_w 277
    //   2284: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: ldc 203
    //   2289: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2292: ldc 205
    //   2294: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2297: ldc 199
    //   2299: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: iconst_2
    //   2303: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2306: ldc 160
    //   2308: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2314: aconst_null
    //   2315: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2318: pop
    //   2319: aload 11
    //   2321: ifnull +10 -> 2331
    //   2324: aload 11
    //   2326: invokeinterface 214 1 0
    //   2331: aconst_null
    //   2332: astore 11
    //   2334: aload_0
    //   2335: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2338: astore 15
    //   2340: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2343: astore 12
    //   2345: new 151	java/lang/StringBuilder
    //   2348: dup
    //   2349: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2352: ldc 192
    //   2354: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: lload 6
    //   2359: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2362: ldc 197
    //   2364: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: ldc 169
    //   2369: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: ldc 199
    //   2374: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: ldc_w 279
    //   2380: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: ldc 203
    //   2385: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2388: ldc 205
    //   2390: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2393: ldc 199
    //   2395: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: iconst_2
    //   2399: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2402: ldc 160
    //   2404: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2407: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2410: astore 14
    //   2412: aload 15
    //   2414: aload 12
    //   2416: iconst_5
    //   2417: anewarray 98	java/lang/String
    //   2420: dup
    //   2421: iconst_0
    //   2422: ldc 165
    //   2424: aastore
    //   2425: dup
    //   2426: iconst_1
    //   2427: ldc 167
    //   2429: aastore
    //   2430: dup
    //   2431: iconst_2
    //   2432: ldc 169
    //   2434: aastore
    //   2435: dup
    //   2436: iconst_3
    //   2437: ldc 171
    //   2439: aastore
    //   2440: dup
    //   2441: iconst_4
    //   2442: ldc 205
    //   2444: aastore
    //   2445: aload 14
    //   2447: aconst_null
    //   2448: aconst_null
    //   2449: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2452: astore 12
    //   2454: aload 12
    //   2456: astore 11
    //   2458: aload 11
    //   2460: invokeinterface 211 1 0
    //   2465: ifeq +534 -> 2999
    //   2468: aload 13
    //   2470: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2473: aload 13
    //   2475: ldc 165
    //   2477: lload 6
    //   2479: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2482: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2485: aload 13
    //   2487: ldc 169
    //   2489: ldc_w 279
    //   2492: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2495: aload 13
    //   2497: ldc 171
    //   2499: aload_1
    //   2500: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2503: aload 13
    //   2505: ldc 205
    //   2507: iconst_2
    //   2508: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2511: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2514: aload_0
    //   2515: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2518: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2521: aload 13
    //   2523: new 151	java/lang/StringBuilder
    //   2526: dup
    //   2527: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2530: ldc 192
    //   2532: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2535: lload 6
    //   2537: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2540: ldc 197
    //   2542: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: ldc 169
    //   2547: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2550: ldc 199
    //   2552: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: ldc_w 279
    //   2558: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: ldc 203
    //   2563: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: ldc 205
    //   2568: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: ldc 199
    //   2573: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2576: iconst_2
    //   2577: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2580: ldc 160
    //   2582: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2588: aconst_null
    //   2589: invokevirtual 286	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2592: pop
    //   2593: aload 11
    //   2595: ifnull +10 -> 2605
    //   2598: aload 11
    //   2600: invokeinterface 214 1 0
    //   2605: iconst_1
    //   2606: ireturn
    //   2607: aload 13
    //   2609: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2612: aload 13
    //   2614: ldc 165
    //   2616: lload 6
    //   2618: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2621: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2624: aload 13
    //   2626: ldc 169
    //   2628: ldc_w 259
    //   2631: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2634: aload 13
    //   2636: ldc_w 261
    //   2639: aload 15
    //   2641: getfield 254	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqJobTitle	Ljava/lang/String;
    //   2644: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2647: aload 13
    //   2649: ldc 205
    //   2651: iconst_1
    //   2652: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2655: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2658: aload_0
    //   2659: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2662: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2665: aload 13
    //   2667: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2670: pop
    //   2671: goto -1195 -> 1476
    //   2674: astore 12
    //   2676: aload 11
    //   2678: ifnull -1190 -> 1488
    //   2681: aload 11
    //   2683: invokeinterface 214 1 0
    //   2688: goto -1200 -> 1488
    //   2691: astore_1
    //   2692: aload 11
    //   2694: ifnull +10 -> 2704
    //   2697: aload 11
    //   2699: invokeinterface 214 1 0
    //   2704: aload_1
    //   2705: athrow
    //   2706: aload 13
    //   2708: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2711: aload 13
    //   2713: ldc 165
    //   2715: lload 6
    //   2717: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2720: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2723: aload 13
    //   2725: ldc 169
    //   2727: ldc_w 259
    //   2730: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2733: aload 13
    //   2735: ldc 171
    //   2737: aload 15
    //   2739: getfield 257	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqCompany	Ljava/lang/String;
    //   2742: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2745: aload 13
    //   2747: ldc 205
    //   2749: iconst_1
    //   2750: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2753: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2756: aload_0
    //   2757: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2760: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2763: aload 13
    //   2765: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2768: pop
    //   2769: goto -1019 -> 1750
    //   2772: astore 12
    //   2774: aload 11
    //   2776: ifnull -1014 -> 1762
    //   2779: aload 11
    //   2781: invokeinterface 214 1 0
    //   2786: goto -1024 -> 1762
    //   2789: astore_1
    //   2790: aload 11
    //   2792: ifnull +10 -> 2802
    //   2795: aload 11
    //   2797: invokeinterface 214 1 0
    //   2802: aload_1
    //   2803: athrow
    //   2804: aload 13
    //   2806: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2809: aload 13
    //   2811: ldc 165
    //   2813: lload 6
    //   2815: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2818: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2821: aload 13
    //   2823: ldc 169
    //   2825: ldc 201
    //   2827: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2830: aload 13
    //   2832: ldc 171
    //   2834: aload 15
    //   2836: getfield 272	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqTelphone	Ljava/lang/String;
    //   2839: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2842: aload 13
    //   2844: ldc 205
    //   2846: iconst_3
    //   2847: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2850: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2853: aload_0
    //   2854: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2857: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2860: aload 13
    //   2862: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2865: pop
    //   2866: goto -833 -> 2033
    //   2869: astore 12
    //   2871: aload 11
    //   2873: ifnull -828 -> 2045
    //   2876: aload 11
    //   2878: invokeinterface 214 1 0
    //   2883: goto -838 -> 2045
    //   2886: astore_1
    //   2887: aload 11
    //   2889: ifnull +10 -> 2899
    //   2892: aload 11
    //   2894: invokeinterface 214 1 0
    //   2899: aload_1
    //   2900: athrow
    //   2901: aload 13
    //   2903: invokevirtual 236	android/content/ContentValues:clear	()V
    //   2906: aload 13
    //   2908: ldc 165
    //   2910: lload 6
    //   2912: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2915: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2918: aload 13
    //   2920: ldc 169
    //   2922: ldc_w 277
    //   2925: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2928: aload 13
    //   2930: ldc 171
    //   2932: aload 15
    //   2934: getfield 275	com/tencent/mobileqq/data/BmqqUserSimpleInfo:mBmqqEmail	Ljava/lang/String;
    //   2937: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2940: aload 13
    //   2942: ldc 205
    //   2944: iconst_2
    //   2945: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2948: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2951: aload_0
    //   2952: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   2955: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   2958: aload 13
    //   2960: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   2963: pop
    //   2964: goto -645 -> 2319
    //   2967: astore 12
    //   2969: aload 11
    //   2971: ifnull -640 -> 2331
    //   2974: aload 11
    //   2976: invokeinterface 214 1 0
    //   2981: goto -650 -> 2331
    //   2984: astore_1
    //   2985: aload 11
    //   2987: ifnull +10 -> 2997
    //   2990: aload 11
    //   2992: invokeinterface 214 1 0
    //   2997: aload_1
    //   2998: athrow
    //   2999: aload 13
    //   3001: invokevirtual 236	android/content/ContentValues:clear	()V
    //   3004: aload 13
    //   3006: ldc 165
    //   3008: lload 6
    //   3010: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3013: invokevirtual 246	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3016: aload 13
    //   3018: ldc 169
    //   3020: ldc_w 279
    //   3023: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3026: aload 13
    //   3028: ldc 171
    //   3030: aload_1
    //   3031: invokevirtual 251	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3034: aload 13
    //   3036: ldc 205
    //   3038: iconst_2
    //   3039: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3042: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3045: aload_0
    //   3046: invokevirtual 143	com/tencent/mobileqq/activity/ProfileCardMoreActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   3049: getstatic 149	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   3052: aload 13
    //   3054: invokevirtual 227	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   3057: pop
    //   3058: goto -465 -> 2593
    //   3061: astore_1
    //   3062: aload 11
    //   3064: ifnull -459 -> 2605
    //   3067: aload 11
    //   3069: invokeinterface 214 1 0
    //   3074: goto -469 -> 2605
    //   3077: astore_1
    //   3078: aload 11
    //   3080: ifnull +10 -> 3090
    //   3083: aload 11
    //   3085: invokeinterface 214 1 0
    //   3090: aload_1
    //   3091: athrow
    //   3092: iconst_m1
    //   3093: ireturn
    //   3094: astore_1
    //   3095: goto -17 -> 3078
    //   3098: astore_1
    //   3099: aconst_null
    //   3100: astore 11
    //   3102: goto -40 -> 3062
    //   3105: astore_1
    //   3106: goto -121 -> 2985
    //   3109: astore 11
    //   3111: aconst_null
    //   3112: astore 11
    //   3114: goto -145 -> 2969
    //   3117: astore_1
    //   3118: goto -231 -> 2887
    //   3121: astore 11
    //   3123: aconst_null
    //   3124: astore 11
    //   3126: goto -255 -> 2871
    //   3129: astore_1
    //   3130: goto -340 -> 2790
    //   3133: astore 11
    //   3135: aconst_null
    //   3136: astore 11
    //   3138: goto -364 -> 2774
    //   3141: astore_1
    //   3142: goto -450 -> 2692
    //   3145: astore 11
    //   3147: aconst_null
    //   3148: astore 11
    //   3150: goto -474 -> 2676
    //   3153: astore 12
    //   3155: aload 11
    //   3157: astore_1
    //   3158: aload 12
    //   3160: astore 11
    //   3162: goto -2109 -> 1053
    //   3165: astore 11
    //   3167: aconst_null
    //   3168: astore 11
    //   3170: iconst_0
    //   3171: istore_3
    //   3172: lconst_0
    //   3173: lstore 6
    //   3175: goto -2192 -> 983
    //   3178: astore 13
    //   3180: lload 8
    //   3182: lstore 6
    //   3184: goto -2201 -> 983
    //   3187: astore 13
    //   3189: iconst_1
    //   3190: istore_3
    //   3191: lload 8
    //   3193: lstore 6
    //   3195: goto -2212 -> 983
    //   3198: astore 16
    //   3200: aload 13
    //   3202: astore 14
    //   3204: aload 16
    //   3206: astore 13
    //   3208: goto -2198 -> 1010
    //   3211: astore 16
    //   3213: aload 13
    //   3215: astore 14
    //   3217: iconst_1
    //   3218: istore_2
    //   3219: aload 16
    //   3221: astore 13
    //   3223: goto -2213 -> 1010
    //   3226: astore 14
    //   3228: goto -2272 -> 956
    //   3231: astore 14
    //   3233: goto -2277 -> 956
    //   3236: lload 8
    //   3238: lstore 6
    //   3240: iload 5
    //   3242: istore_3
    //   3243: iload 4
    //   3245: istore_2
    //   3246: goto -2823 -> 423
    //   3249: iconst_1
    //   3250: istore_2
    //   3251: iconst_1
    //   3252: istore_3
    //   3253: goto -2852 -> 401
    //   3256: lload 8
    //   3258: lstore 6
    //   3260: goto -2859 -> 401
    //   3263: aconst_null
    //   3264: astore 12
    //   3266: goto -3187 -> 79
    //   3269: aconst_null
    //   3270: astore 15
    //   3272: goto -3226 -> 46
    //   3275: iload_3
    //   3276: istore_2
    //   3277: iconst_1
    //   3278: istore_3
    //   3279: lload 6
    //   3281: lstore 8
    //   3283: goto -3113 -> 170
    //   3286: astore 13
    //   3288: aconst_null
    //   3289: astore 13
    //   3291: goto -2335 -> 956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3294	0	this	ProfileCardMoreActivity
    //   0	3294	1	paramString	String
    //   80	3197	2	k	int
    //   163	3116	3	m	int
    //   82	3162	4	n	int
    //   402	2839	5	i1	int
    //   197	3083	6	l1	long
    //   165	3117	8	l2	long
    //   182	192	10	bool	boolean
    //   26	973	11	localObject1	Object
    //   1048	16	11	localObject2	Object
    //   1221	1880	11	localObject3	Object
    //   3109	1	11	localException1	Exception
    //   3112	1	11	localObject4	Object
    //   3121	1	11	localException2	Exception
    //   3124	1	11	localObject5	Object
    //   3133	1	11	localException3	Exception
    //   3136	1	11	localObject6	Object
    //   3145	1	11	localException4	Exception
    //   3148	13	11	localObject7	Object
    //   3165	1	11	localException5	Exception
    //   3168	1	11	localObject8	Object
    //   77	2378	12	localObject9	Object
    //   2674	1	12	localException6	Exception
    //   2772	1	12	localException7	Exception
    //   2869	1	12	localException8	Exception
    //   2967	1	12	localException9	Exception
    //   3153	6	12	localObject10	Object
    //   3264	1	12	localObject11	Object
    //   85	881	13	localObject12	Object
    //   977	1	13	localException10	Exception
    //   1008	21	13	localObject13	Object
    //   1031	2022	13	localException11	Exception
    //   3178	1	13	localException12	Exception
    //   3187	14	13	localException13	Exception
    //   3206	16	13	localObject14	Object
    //   3286	1	13	localException14	Exception
    //   3289	1	13	localObject15	Object
    //   96	3120	14	localObject16	Object
    //   3226	1	14	localException15	Exception
    //   3231	1	14	localException16	Exception
    //   44	3227	15	localObject17	Object
    //   91	2077	16	localObject18	Object
    //   3198	7	16	localObject19	Object
    //   3211	9	16	localObject20	Object
    //   315	36	17	str	String
    // Exception table:
    //   from	to	target	type
    //   393	401	977	java/lang/Exception
    //   944	951	977	java/lang/Exception
    //   965	972	977	java/lang/Exception
    //   217	359	1008	finally
    //   202	209	1031	java/lang/Exception
    //   1018	1025	1031	java/lang/Exception
    //   1028	1031	1031	java/lang/Exception
    //   87	162	1048	finally
    //   1348	1476	2674	java/lang/Exception
    //   2607	2671	2674	java/lang/Exception
    //   1223	1344	2691	finally
    //   1623	1750	2772	java/lang/Exception
    //   2706	2769	2772	java/lang/Exception
    //   1499	1619	2789	finally
    //   1896	2033	2869	java/lang/Exception
    //   2804	2866	2869	java/lang/Exception
    //   1773	1892	2886	finally
    //   2180	2319	2967	java/lang/Exception
    //   2901	2964	2967	java/lang/Exception
    //   2056	2176	2984	finally
    //   2458	2593	3061	java/lang/Exception
    //   2999	3058	3061	java/lang/Exception
    //   2334	2454	3077	finally
    //   2458	2593	3094	finally
    //   2999	3058	3094	finally
    //   2334	2454	3098	java/lang/Exception
    //   2180	2319	3105	finally
    //   2901	2964	3105	finally
    //   2056	2176	3109	java/lang/Exception
    //   1896	2033	3117	finally
    //   2804	2866	3117	finally
    //   1773	1892	3121	java/lang/Exception
    //   1623	1750	3129	finally
    //   2706	2769	3129	finally
    //   1499	1619	3133	java/lang/Exception
    //   1348	1476	3141	finally
    //   2607	2671	3141	finally
    //   1223	1344	3145	java/lang/Exception
    //   175	184	3153	finally
    //   189	199	3153	finally
    //   202	209	3153	finally
    //   393	401	3153	finally
    //   944	951	3153	finally
    //   965	972	3153	finally
    //   1018	1025	3153	finally
    //   1028	1031	3153	finally
    //   87	162	3165	java/lang/Exception
    //   175	184	3178	java/lang/Exception
    //   189	199	3187	java/lang/Exception
    //   364	373	3198	finally
    //   382	389	3211	finally
    //   364	373	3226	java/lang/Exception
    //   382	389	3231	java/lang/Exception
    //   217	359	3286	java/lang/Exception
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
    setContentViewB(2130970498);
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
      this.leftView.setText(2131433681);
      this.rightViewText.setVisibility(8);
      localObject1 = findViewById(2131363700);
      if (this.jdField_a_of_type_ArrayOfInt[14] != 1) {
        break label225;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131363711);
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
      localObject1 = getString(2131437140);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370893));
    a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_nick_name");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_e_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370894));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370895));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370898));
      a(2, this.jdField_a_of_type_AndroidWidgetRelativeLayout, n, i2);
      a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new tdn(this));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370899));
      a(3, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370901));
      a(4, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370900));
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label673;
      }
      a(5, this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem, n, i2);
      if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0) {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
      }
      label508:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370902));
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
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131370903));
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
      this.h = ((FormSimpleItem)findViewById(2131370904));
      a(8, this.h, n, m);
      if (i1 != 0) {
        this.h.setVisibility(8);
      }
      this.i = ((FormSimpleItem)findViewById(2131370905));
      a(9, this.i, n, m);
      if ((i1 != 0) || (!QQStoryManager.j())) {
        this.i.setVisibility(8);
      }
      this.j = ((FormSimpleItem)findViewById(2131363697));
      a(10, this.j, n, m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370906));
      Object localObject2;
      if ((i1 == 0) && (this.jdField_a_of_type_ArrayOfInt[12] == 1)) {
        if ((12 == n) && (12 == m))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363698));
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
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131370907));
          if (this.jdField_a_of_type_ArrayOfInt[13] != 1) {
            break label1449;
          }
          localObject1 = ((FriendsManager)this.app.getManager(50)).b(AppConstants.au);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131437147));
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
          this.j.setContentDescription(getString(2131436844));
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
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838619));
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838631));
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838626));
        return;
      }
      paramRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130838629));
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
      a(this.jdField_a_of_type_AndroidWidgetTextView, getResources().getDrawable(2130842945));
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
      localActionSheet.a(2131434511);
    }
    for (;;)
    {
      localActionSheet.a(2131434501, 3);
      localActionSheet.c(2131432998);
      localActionSheet.a(new tdo(this, paramString, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.a(2131434510);
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
    localObject2 = ((AbsShareMsg.Builder)localObject2).b(14).a(2).a("推荐了" + paramString2).a("plugin", str2, "", (String)localObject3, str1).b(getResources().getString(2131433751)).a();
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
        a(2131434494, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131434493, 1);
      }
    }
    a(2131432992, 1);
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
      a(2131434495, 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131434491, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131434494, 1);
      } else {
        a(2131434493, 1);
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
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370908));
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434436);
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
            a(2131435764, 1);
            return;
          }
          a(2131435763, 0);
          return;
        }
        a(2131434595, 1);
        return;
        paramIntent.putExtra("selfSet_leftViewText", getString(2131433280));
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
        ThreadManager.post(new tdm(this), 5, null, true);
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
        this.j.setRightText(getString(2131436019));
      }
    }
    else {
      return;
    }
    this.j.setRightText(getString(2131436020));
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
        a(2131432992, 1);
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
    a(2131432992, 1);
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
    case 2131370894: 
    case 2131370895: 
    case 2131370899: 
    case 2131370902: 
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
      ThreadManager.getFileThreadHandler().post(new tdv(this));
      return;
    case 2131370903: 
      if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = getIntent().getStringExtra("recommend_campus_name");
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = ContactUtils.f(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1310;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      break;
    }
    label1310:
    for (;;)
    {
      String str1 = getIntent().getStringExtra("recommend_campus_info");
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      str1 = String.format(Locale.getDefault(), "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=campus_circle&source=sharecard&uin=%s&name=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView });
      a("推荐校园圈联系人", paramView, (String)localObject, 109, "AppCmd://OpenContactInfo/?uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, str1, str1, getResources().getString(2131433753));
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
        a("推荐联系人", paramView, "帐号: " + this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 14, str2, str1, str1, getResources().getString(2131433751));
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
        }
        ProfileCardUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, this.app.getAccount(), 10027, null);
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