package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import QQService.EVIPSPEC;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxObserver;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.activity.specialcare.SpecialCareUtils;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean;
import com.tencent.mobileqq.config.business.SingTogetherConfigBean.GeneralTogetherItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qqexpand.chat.IAioColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.chat.IColdPalaceBanish;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IColdPalaceBanish
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private FilterMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxFilterMsgBoxObserver = new ChatSettingActivity.7(this);
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new ChatSettingActivity.8(this);
  IQvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ChatSettingActivity.20(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ChatSettingActivity.19(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ChatSettingActivity.23(this);
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new ChatSettingActivity.13(this);
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new ChatSettingActivity.14(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new ChatSettingActivity.22(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new ChatSettingActivity.18(this);
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new ChatSettingActivity.1(this);
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new ChatSettingActivity.21(this);
  ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ChatSettingActivity.2(this);
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new ChatSettingActivity.25(this);
  RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private XSimpleListAdapter jdField_a_of_type_ComTencentWidgetXSimpleListAdapter;
  protected String a;
  private WeakReference<FaceDrawable> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ChatSettingActivity.17(this);
  protected boolean a;
  private final int jdField_b_of_type_Int = 1;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference<FaceDrawable> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private final int jdField_d_of_type_Int = 3;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean = false;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean = true;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean = false;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString = "";
  private boolean jdField_k_of_type_Boolean = false;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private boolean jdField_l_of_type_Boolean = false;
  
  public ChatSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "ChatSettingActivity.nearby";
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void A()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692183, 1);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_h_of_type_Boolean);
      return;
    }
    Object localObject1 = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if (localObject1 != null) {}
    try
    {
      l1 = Long.parseLong(this.jdField_i_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      long l1;
      label59:
      Object localObject2;
      Object localObject3;
      Object localObject4;
      int m;
      boolean bool;
      break label59;
    }
    l1 = 0L;
    if (l1 > 0L)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(Long.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject3 = this.jdField_a_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("startStangerShield, tuin=");
        ((StringBuilder)localObject4).append(l1);
        ((StringBuilder)localObject4).append(", mIsShield=");
        ((StringBuilder)localObject4).append(this.jdField_h_of_type_Boolean);
        ((StringBuilder)localObject4).append(", mIsFollowed=");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_Boolean);
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      if (this.jdField_h_of_type_Boolean)
      {
        ((ShieldMsgManger)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (ChatActivityUtils.a.size() > 5) {
            ChatActivityUtils.a.poll();
          }
          localObject3 = ChatActivityUtils.a;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(l1);
          ((StringBuilder)localObject4).append("");
          ((Queue)localObject3).offer(((StringBuilder)localObject4).toString());
        }
        ((ShieldMsgManger)localObject1).a(this.jdField_a_of_type_Int, (List)localObject2);
      }
      this.jdField_j_of_type_Boolean = true;
    }
    else
    {
      a(1, HardCodeUtil.a(2131701969));
    }
    localObject4 = this.app;
    if (this.jdField_h_of_type_Boolean) {
      localObject2 = "cancel_aio";
    } else {
      localObject2 = "block_aio";
    }
    if (this.jdField_a_of_type_Int == 1001) {
      localObject3 = "0";
    } else {
      localObject3 = "1";
    }
    if (this.jdField_h_of_type_Boolean) {
      localObject1 = "";
    } else if (this.jdField_a_of_type_Boolean) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    ReportController.b((AppRuntime)localObject4, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, (String)localObject3, "1", (String)localObject1, "");
    m = this.jdField_a_of_type_Int;
    if ((m == 1001) || (m == 10002) || (m == 1003))
    {
      if (this.jdField_h_of_type_Boolean)
      {
        localObject1 = this.jdField_c_of_type_JavaLangString;
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          this.app.getMsgHandler().d(this.jdField_c_of_type_JavaLangString);
          this.jdField_j_of_type_Boolean = true;
        }
      }
      else
      {
        localObject1 = this.jdField_c_of_type_JavaLangString;
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          this.app.getMsgHandler().c(this.jdField_c_of_type_JavaLangString);
          this.jdField_j_of_type_Boolean = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startStangerShield, mCurUin=");
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", mIsShield=");
        ((StringBuilder)localObject2).append(this.jdField_h_of_type_Boolean);
        ((StringBuilder)localObject2).append(", mShieldByThis=");
        ((StringBuilder)localObject2).append(this.jdField_j_of_type_Boolean);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    bool = this.jdField_j_of_type_Boolean;
    if (this.jdField_a_of_type_Int == 1010)
    {
      if (this.jdField_h_of_type_Boolean)
      {
        ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshShieldButton, mCurType=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", mIsShield=");
      localStringBuilder.append(this.jdField_h_of_type_Boolean);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localObject != null)
    {
      ((FormSwitchItem)localObject).setChecked(this.jdField_h_of_type_Boolean);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690845));
      }
    }
    if ((this.jdField_a_of_type_Int != 1003) && (this.jdField_i_of_type_Boolean))
    {
      if ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        if (!b()) {
          this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      localObject = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((localObject != null) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        ((FormSwitchItem)localObject).setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void C()
  {
    int m = this.jdField_a_of_type_Int;
    if ((1001 != m) && (10002 != m)) {
      m = 2131690843;
    } else if (this.jdField_a_of_type_Boolean) {
      m = 2131696369;
    } else {
      m = 2131696367;
    }
    String str = getString(m);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
  }
  
  private void D()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {
      return;
    }
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_f_of_type_Boolean = ((FriendsManager)localObject).e(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690845));
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    z();
    boolean bool = this.jdField_f_of_type_Boolean;
    int n = 0;
    int m = 0;
    if (bool)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        m = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(m);
    }
    else if (!this.app.getCurrentUin().equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        m = n;
      } else {
        m = 8;
      }
      ((FormSwitchItem)localObject).setVisibility(m);
    }
    bool = jdField_b_of_type_Boolean;
  }
  
  private void E()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void F()
  {
    AllInOne localAllInOne = new AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.pa = 19;
    localAllInOne.nickname = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.nickname)) || (localAllInOne.nickname.equals(this.jdField_c_of_type_JavaLangString))) {
      localAllInOne.nickname = this.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.preWinUin = this.jdField_c_of_type_JavaLangString;
    int m = this.jdField_a_of_type_Int;
    localAllInOne.preWinType = m;
    localAllInOne.lastActivity = 5;
    localAllInOne.profileEntryType = 61;
    if (m != 1000)
    {
      if (m != 1001)
      {
        if (m != 1009)
        {
          if (m != 1010)
          {
            if ((m != 1044) && (m != 1045))
            {
              if (m != 4000)
              {
                if (m != 10002) {
                  if (m != 10008) {
                    if (m == 10010) {}
                  }
                }
                switch (m)
                {
                default: 
                  switch (m)
                  {
                  default: 
                    break;
                  case 1023: 
                    localAllInOne.pa = 74;
                    break;
                  case 1022: 
                    localAllInOne.pa = 27;
                    break;
                  case 1021: 
                    localAllInOne.pa = 72;
                    break;
                  case 1020: 
                    localAllInOne.pa = 58;
                  }
                  break;
                case 1005: 
                  localAllInOne.pa = 2;
                  break;
                case 1004: 
                  localAllInOne.pa = 47;
                  localAllInOne.discussUin = this.jdField_j_of_type_JavaLangString;
                  break;
                case 1003: 
                  localAllInOne.pa = 70;
                  break;
                  localAllInOne.pa = 117;
                  break;
                  localAllInOne.pa = 115;
                  break;
                  localAllInOne.pa = 86;
                  break;
                }
              }
              else
              {
                localAllInOne.pa = 34;
              }
            }
            else {
              localAllInOne.pa = 96;
            }
          }
          else {
            localAllInOne.pa = 76;
          }
        }
        else {
          localAllInOne.pa = 57;
        }
      }
      else {
        localAllInOne.pa = 42;
      }
    }
    else
    {
      localAllInOne.pa = 22;
      localAllInOne.troopUin = this.jdField_j_of_type_JavaLangString;
    }
    localAllInOne.reportExtra = NewReportPlugin.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.reportExtra }));
    }
    m = this.jdField_a_of_type_Int;
    if ((m != 1001) && (m != 10002) && (m != 10004) && (m != 1010)) {
      if (m == 1022)
      {
        m = this.jdField_f_of_type_Int;
        if ((m == 3007) || (m == 2007) || (m == 4007) || (m == 3019) || (m == 2019)) {}
      }
      else
      {
        m = this.jdField_a_of_type_Int;
        if ((m != 1044) && (m != 1045))
        {
          if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("param_wzry_data"))
          {
            localObject = this.jdField_a_of_type_AndroidContentIntent.getSerializableExtra("param_wzry_data");
            if (localObject != null) {
              localAllInOne.extras.putSerializable("param_wzry_data", (Serializable)localObject);
            }
          }
          ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
          return;
        }
        ProfileActivity.a(this, localAllInOne, this.jdField_a_of_type_AndroidContentIntent.getIntExtra("ExtendFriendLimitChatFromeType", 0), 3);
        return;
      }
    }
    Object localObject = new Intent();
    m = this.jdField_a_of_type_Int;
    if (m == 1001)
    {
      localAllInOne.profileEntryType = 12;
      if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.jdField_c_of_type_JavaLangString)) {
        ((Intent)localObject).putExtra("param_tiny_id", Long.valueOf(this.jdField_c_of_type_JavaLangString));
      }
      ((Intent)localObject).putExtra("frome_where", 21);
    }
    else if (m == 10002)
    {
      ((Intent)localObject).putExtra("frome_where", 22);
    }
    else if (m == 1010)
    {
      localAllInOne.profileEntryType = 13;
    }
    else
    {
      localAllInOne.profileEntryType = 30;
    }
    ((Intent)localObject).putExtra("AllInOne", localAllInOne);
    if (Utils.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
      ((Intent)localObject).putExtra("param_mode", 2);
    } else {
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    RouteUtils.a(this, (Intent)localObject, "/nearby/people/profile", 3);
  }
  
  private void G()
  {
    int m = this.jdField_a_of_type_Int;
    Object localObject;
    int n;
    if (m != 1009)
    {
      if (m != 1010)
      {
        if (m != 1036)
        {
          if (m != 10004)
          {
            if ((m != 1044) && (m != 1045))
            {
              switch (m)
              {
              default: 
                switch (m)
                {
                default: 
                  switch (m)
                  {
                  default: 
                    localObject = null;
                    m = 0;
                    n = 3999;
                    break;
                  case 10010: 
                    localObject = null;
                    m = 6;
                    n = 3076;
                    break;
                  case 10009: 
                    m = 5192;
                    break;
                  case 10008: 
                    localObject = null;
                    m = 3;
                    n = 3080;
                  }
                  break;
                case 1024: 
                  localObject = null;
                  m = 2;
                  n = 3072;
                  break;
                case 1023: 
                  m = 11;
                  break;
                case 1022: 
                  localObject = null;
                  m = 11;
                  n = 3041;
                  break;
                case 1021: 
                  m = 2;
                }
                break;
              case 1006: 
                localObject = null;
                m = 12;
                n = 3006;
                break;
              case 1005: 
                m = 12;
                localObject = null;
                n = 3008;
                break;
              case 1004: 
                localObject = getIntent().getStringExtra("troop_uin");
                m = 3;
                n = 3005;
                break;
              case 1003: 
                m = 1;
                localObject = null;
                n = 3071;
                break;
              case 1002: 
                m = 0;
                localObject = null;
                n = 3003;
                break;
              case 1001: 
                localObject = null;
                m = 3;
                n = 3007;
                break;
              }
              localObject = getIntent().getStringExtra("troop_uin");
              m = 3;
              n = 3004;
            }
            else
            {
              m = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("subId", 0);
              localObject = null;
              n = 3094;
            }
          }
          else
          {
            localObject = null;
            m = 3;
            n = 3043;
          }
        }
        else
        {
          localObject = null;
          m = 1;
          n = 3099;
        }
      }
      else
      {
        localObject = null;
        m = 0;
        n = 3019;
      }
    }
    else
    {
      localObject = null;
      m = 0;
      n = 3013;
    }
    if (n == 3007)
    {
      if (!LBSHandler.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        b();
      }
    }
    else if ((n == 3019) && (!DatingUtil.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      b();
      return;
    }
    int i1 = this.jdField_a_of_type_Int;
    if ((i1 != 3) && (i1 != 4000) && (i1 != 1006)) {
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject, n, m, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);
    } else {
      localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 2, this.jdField_k_of_type_JavaLangString, null, n, m, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);
    }
    if (n == 3094) {
      ((Intent)localObject).putExtra("entrance", 3);
    }
    if (localObject != null)
    {
      Serializable localSerializable = StrangerChatPie.a(this, this.jdField_a_of_type_Int, false, false);
      if (localSerializable != null) {
        ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
      }
    }
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this, (Intent)localObject);
  }
  
  private void H()
  {
    AllInOne localAllInOne = new AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.nickname = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
    int m = this.jdField_a_of_type_Int;
    if (3000 != m)
    {
      localAllInOne.preWinUin = this.jdField_c_of_type_JavaLangString;
      localAllInOne.preWinType = m;
    }
    localAllInOne.lastActivity = 5;
    localAllInOne.profileEntryType = 61;
    localAllInOne.reportExtra = NewReportPlugin.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.reportExtra }));
    }
    ProfileUtils.openProfileCardForResult(this, localAllInOne, 3);
  }
  
  private void I()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void J()
  {
    ChatSettingActivity.24 local24 = new ChatSettingActivity.24(this);
    if (!this.jdField_l_of_type_Boolean) {
      ThreadManager.post(local24, 8, null, true);
    }
  }
  
  private void K()
  {
    MutualMarkIconsView localMutualMarkIconsView;
    if (this.jdField_a_of_type_Int == 0)
    {
      localMutualMarkIconsView = this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
      if (localMutualMarkIconsView != null) {
        localMutualMarkIconsView.a(this.app, this.jdField_c_of_type_JavaLangString, 2);
      }
    }
    else
    {
      localMutualMarkIconsView = this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
      if (localMutualMarkIconsView != null) {
        localMutualMarkIconsView.setVisibility(8);
      }
    }
  }
  
  private void L()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_c_of_type_JavaLangString, this.app);
    FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694321));
      }
    }
  }
  
  private void M()
  {
    boolean bool = HiddenChatHelper.a(this.jdField_c_of_type_JavaLangString, this.app);
    FormSwitchItem localFormSwitchItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (localFormSwitchItem != null)
    {
      localFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      int m;
      if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        m = 0;
      } else {
        m = 8;
      }
      localFormSwitchItem.setVisibility(m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    }
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
    localStringBuilder.append(-2006);
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
    if (paramString == null) {
      return 0;
    }
    paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      long l1;
      if (paramInt == 3000) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
    }
    paramInt = paramString.getCount();
    paramString.close();
    return paramInt;
  }
  
  private TextView a(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      if (!(paramView2 instanceof ViewGroup)) {
        return null;
      }
      TextView localTextView = (TextView)paramView1.findViewById(2131377938);
      if (localTextView == null) {
        return null;
      }
      ((ViewGroup)paramView1).removeView(localTextView);
      paramView1 = localTextView.getLayoutParams();
      if ((paramView1 instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)paramView1).setMargins(0, AIOUtils.b(5.0F, getResources()), 0, 0);
      }
      ((ViewGroup)paramView2).addView(localTextView);
      return localTextView;
    }
    return null;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
    if (paramString != null) {
      return ExtensionRichStatus.a(paramString);
    }
    return null;
  }
  
  private String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject3 = null;
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject4 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject4 = ((FriendsManager)localObject4).e(paramString);
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        paramString = localObject2;
        if (((Friends)localObject4).remark != null) {
          paramString = ((Friends)localObject4).remark;
        }
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = paramString;
          if (!TextUtils.isEmpty(((Friends)localObject4).name)) {
            localObject1 = ((Friends)localObject4).name;
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("result");
    } else {
      paramIntent = null;
    }
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = "";
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (!((String)localObject).equals(this.jdField_g_of_type_JavaLangString))
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (paramIntent != null)
        {
          paramIntent.setFriendComment(this.jdField_c_of_type_JavaLangString, (String)localObject, false);
          this.jdField_e_of_type_Int |= 0x1;
          c((String)localObject);
          g(getString(2131690784));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          return;
        }
        a(2131693362, 1);
        return;
      }
      a(2131693348, 0);
      return;
    }
    a(2131694473, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, ChatSettingActivity.DeleteHistoryListener paramDeleteHistoryListener, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    DeleteRecordDialog localDeleteRecordDialog = new DeleteRecordDialog(paramActivity, paramQQAppInterface, true);
    localDeleteRecordDialog.a(new ChatSettingActivity.28(paramDeleteHistoryListener, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localDeleteRecordDialog.a(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_h_of_type_AndroidWidgetTextView = paramTextView;
    if (paramRichStatus != null)
    {
      if (paramTextView == null) {
        return;
      }
      Object localObject = paramRichStatus.toSpannableString(null);
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        if (localStatusManager != null) {
          paramRichStatus = localStatusManager.a(paramRichStatus.actionId, 200);
        } else {
          paramRichStatus = BitmapManager.a(getResources(), 2130849881);
        }
        paramRichStatus = new StatableBitmapDrawable(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new OffsetableImageSpan(paramRichStatus, 0);
        paramRichStatus.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, 3, 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
      paramTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue());
    localNearbyUserFollowReq.operation.set(Integer.valueOf(paramString).intValue());
    ProtoUtils.a(this.app, new ChatSettingActivity.5(this, paramString), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.app.getAccount()))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "isNeedShowFilterMsgView() called, getAccount() is null");
      return false;
    }
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)this.app.getRuntimeService(ITempMsgBoxManager.class, "");
    return (localITempMsgBoxManager != null) && (localITempMsgBoxManager.isBelongToFilterBox(this.jdField_c_of_type_JavaLangString, 0));
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 1009) && (paramInt != 1036) && (paramInt != 10002) && (paramInt != 10004) && (paramInt != 1044) && (paramInt != 1045)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return false;
          }
          break;
        }
        break;
      }
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  private String b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = ((FriendsManager)localObject2).e(paramString);
    paramString = localObject1;
    if (localFriends != null)
    {
      paramString = new StringBuilder();
      paramString.append(localFriends.groupid);
      paramString.append("");
      localObject2 = ((FriendsManager)localObject2).a(paramString.toString());
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = ((Groups)localObject2).group_name;
      }
    }
    return paramString;
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int m = paramIntent.getByteExtra("result", (byte)0);
    paramIntent = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(m));
    if (paramIntent != null) {
      d(paramIntent.group_name);
    }
  }
  
  private void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.app;
    String str2 = this.jdField_c_of_type_JavaLangString;
    String str1;
    if (this.jdField_a_of_type_Int == 1001) {
      str1 = "2";
    } else {
      str1 = "1";
    }
    int m = this.jdField_a_of_type_Int;
    NearbyHandler.a(localQQAppInterface, str2, str1, paramString, 3, new ChatSettingActivity.6(this, paramString));
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int == 1001;
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        return;
      }
      paramString = ContactUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void d(String paramString)
  {
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
  }
  
  private void e(String paramString)
  {
    Object localObject = this.app.getMessageFacade().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    long l1;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;
      } else {
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
      }
    }
    else {
      l1 = 0L;
    }
    this.app.getMessageFacade().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.app.getMessageFacade().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    this.app.getFileManagerDataCenter().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (paramString != null)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        l2 = 0L;
      }
      l1 = Math.max(l2, l1);
      if (l1 > 0L) {
        this.app.getMsgCache().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
      }
    }
    paramString = this.app.getHandler(Conversation.class);
    localObject = paramString.obtainMessage(1017);
    ((Message)localObject).obj = this.jdField_c_of_type_JavaLangString;
    ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
    paramString.sendMessage((Message)localObject);
  }
  
  private void f()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxFilterMsgBoxObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null) {
      localStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
  }
  
  private void f(String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (Utils.b(paramString)) {
      localActionSheet.setMainTitle(2131690632);
    } else if (MutualMarkDataCenter.a(this.app, this.jdField_c_of_type_JavaLangString, true)) {
      localActionSheet.setMainTitle(2131690634);
    } else {
      localActionSheet.setMainTitle(2131690633);
    }
    localActionSheet.addButton(2131691488, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new ChatSettingActivity.16(this, paramString, localActionSheet));
    localActionSheet.show();
  }
  
  private void g()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxFilterMsgBoxObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.app.removeHandler(ChatSettingActivity.class);
    StatusManager localStatusManager = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = null;
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562765);
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131718766));
  }
  
  private void h()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("follow_flag", false);
    if ((this.jdField_a_of_type_Int == 0) && (!a(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 1003;
    }
    int m = this.jdField_a_of_type_Int;
    if ((1 == m) || (1000 == m) || (1004 == m)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("real_troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareApiIQvipSpecialSoundManager = VasUtil.a().getSpecialSoundManager();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    int m = this.jdField_a_of_type_Int;
    if (m != 0)
    {
      if ((m != 1) && (m != 2) && (m != 3000)) {
        m();
      }
    }
    else {
      k();
    }
    setTitle(2131690817);
    setLeftViewName(2131690529);
    setContentBackgroundResource(2130838739);
  }
  
  private void j()
  {
    IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)QQStoryContext.a().getRuntimeService(IWebProcessManagerService.class, "multi");
    if ((localIWebProcessManagerService != null) && (localIWebProcessManagerService.isNeedPreloadWebProcess()))
    {
      localIWebProcessManagerService.startWebProcess(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "start preloadWebProcess");
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131559286, null));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
    }
    catch (Throwable localThrowable)
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, localThrowable.toString());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    try
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558844, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
      super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367238));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367237));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367239));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380936));
      this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371664));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365329));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377618));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364494));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377286));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364215));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364229));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131362191));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365495));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376401));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377747));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377292));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377287));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377289));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377288));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377290));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377285));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364214));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376787));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376788));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365502).setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130839433);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131376781).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      boolean bool = C2CShortcutBarSwitcher.b(this.app);
      Object localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (bool) {
        m = 0;
      } else {
        m = 8;
      }
      ((FormSwitchItem)localObject1).setVisibility(m);
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (bool) {
        m = 0;
      } else {
        m = 8;
      }
      ((TextView)localObject1).setVisibility(m);
      if (bool)
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(C2CShortcutBarSwitcher.a(this.app, this.jdField_c_of_type_JavaLangString));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        ReportController.b(this.app, "dc00898", "", "", "0X800B330", "0X800B330", C2CShortcutBarManager.a(this.app).a(this.jdField_c_of_type_JavaLangString), 0, "", "", "", "");
      }
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(FriendsStatusUtil.a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (Build.VERSION.SDK_INT <= 25)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      }
      else
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693366));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131689665));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690796));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718783));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716891));
        localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(getString(2131694518));
        ((StringBuilder)localObject2).append(getString(2131718801));
        ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694321));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131696353));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690846));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695150));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695147));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131689631));
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691488));
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription("从过滤消息移出");
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689539));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131719151));
      }
      this.jdField_g_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_g_of_type_JavaLangString == null) {
        this.jdField_g_of_type_JavaLangString = "";
      }
      c(this.jdField_g_of_type_JavaLangString);
      localObject1 = this.jdField_g_of_type_JavaLangString;
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      Object localObject2 = VipUtils.VipIconUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
      bool = VipUtils.VipIconUtils.a(localObject2[0]);
      if (bool)
      {
        localObject1 = VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject2[0]);
        if ((!VipUtils.VipIconUtils.b(localObject2[1])) && (!((VipUtils.VipIconUtils.NamePlateVipTpye)localObject1).a()))
        {
          localObject2 = VipUtils.VipIconUtils.a(this.app, this.jdField_c_of_type_JavaLangString, (VipUtils.VipIconUtils.NamePlateVipTpye)localObject1, false);
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(VipUtils.VipIconUtils.a((VipUtils.VipIconUtils.NamePlateVipTpye)localObject1)));
        }
      }
      VipUtils.VipIconUtils.VipIconTouchListener.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").a();
      int m = VipUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("bindView: vip=");
        ((StringBuilder)localObject2).append(m);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      int n = m >> 8;
      if ((n == 3) && (!SimpleUIUtil.a()))
      {
        localObject1 = VipUtils.VipIconUtils.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
        if ((m & 0xF) == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167202));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847300));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167202));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847298));
          }
        }
        NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.d(1));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if ((n == 1) && (!SimpleUIUtil.a()))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167202));
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.d(0));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else if ((n == 2) && (!SimpleUIUtil.a()))
      {
        localObject1 = VipUtils.VipIconUtils.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
        if ((m & 0xF) == 1)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167202));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847300));
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167202));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847298));
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.d(1));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.d(0));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        localObject1 = FaceDrawable.getUserFaceDrawable(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      }
      this.jdField_h_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_h_of_type_JavaLangString == null) {
        this.jdField_h_of_type_JavaLangString = "";
      }
      d(this.jdField_h_of_type_JavaLangString);
      w();
      if (!a()) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (Utils.b(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        localObject1 = (LinearLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(this, 20.0F);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(AppConstants.BABY_Q_UIN);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        localObject1 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.app, TempGetProfileDetailProcessor.class);
        if (localObject1 != null) {
          ((TempGetProfileDetailProcessor)localObject1).getBabyQSwitch();
        }
      }
      else
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      if (QidianManager.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (this.app != null)
      {
        D();
        K();
        L();
      }
      M();
      if (this.app.getCurrentUin().equals(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      if (!a(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      l();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
  
  private void l()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (localObject == null) {
      return;
    }
    if (((FormSimpleItem)localObject).getVisibility() != 0) {
      return;
    }
    localObject = ((SingTogetherConfigBean)QConfigManager.a().a(551)).a(4);
    if ((localObject != null) && (((SingTogetherConfigBean.GeneralTogetherItem)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      boolean bool = ((TogetherControlManager)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 2, this.jdField_c_of_type_JavaLangString);
      FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (bool) {
        localObject = "已开启";
      } else {
        localObject = "未开启";
      }
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (TogetherUtils.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130841440));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void m()
  {
    Object localObject1 = View.inflate(this, 2131558846, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558845, null);
    this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter = new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentWidgetXSimpleListAdapter);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377935);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377937));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364681));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377936));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377933));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377291));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131378658));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378659));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376402));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377934));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364076));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839433);
    if (b()) {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    if (this.jdField_a_of_type_Int == 1036)
    {
      if (a(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    else
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    int m = this.jdField_a_of_type_Int;
    if ((1001 == m) || (10002 == m)) {
      C();
    }
    m = this.jdField_a_of_type_Int;
    if ((m == 1044) || (m == 1045))
    {
      this.jdField_k_of_type_AndroidWidgetTextView = a((View)localObject1, this.jdField_a_of_type_AndroidViewView);
      n();
    }
    if (!a()) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_k_of_type_AndroidWidgetTextView == null) {
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131377938));
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693366));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690844));
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690846));
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      m = this.jdField_a_of_type_Int;
      if ((1001 != m) && (10002 != m)) {
        m = 2131690843;
      } else if (this.jdField_a_of_type_Boolean) {
        m = 2131696369;
      } else {
        m = 2131696367;
      }
      ((Button)localObject1).setContentDescription(getString(m));
      this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689540));
      this.jdField_l_of_type_AndroidWidgetTextView.setContentDescription("从过滤消息移出");
    }
    if (this.jdField_a_of_type_Int == 10004)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    }
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1006)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentIntent;
      if ((localObject1 != null) && (((Intent)localObject1).getBooleanExtra("isShieldMsgSwitchUnClickable", false)))
      {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
        localObject1 = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
        if (localObject1 == null) {
          break label777;
        }
        ((Switch)localObject1).setEnabled(false);
        break label777;
      }
    }
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    label777:
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
    m = this.jdField_a_of_type_Int;
    if ((m != 1010) && (m != 1001) && (m != 10002)) {
      if (m == 1022)
      {
        m = this.jdField_f_of_type_Int;
        if ((m == 3007) || (m == 2007) || (m == 4007) || (m == 3019) || (m == 2019)) {}
      }
      else
      {
        if (this.jdField_a_of_type_Int == 1006)
        {
          localObject1 = FaceDrawable.getMobileFaceDrawable(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          break label1019;
        }
        localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label1019;
      }
    }
    if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.jdField_c_of_type_JavaLangString)) {
      m = 202;
    } else {
      m = 200;
    }
    localObject1 = FaceDrawable.getStrangerFaceDrawable(this.app, m, this.jdField_c_of_type_JavaLangString, true);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    if (this.jdField_a_of_type_Int == 1001) {
      o();
    }
    label1019:
    this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    m = this.jdField_a_of_type_Int;
    if ((m == 1000) || (m == 1004)) {
      this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    m = this.jdField_a_of_type_Int;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if ((m != 1001) && (m != 10002))
    {
      if (m == 1006)
      {
        this.jdField_k_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString))
        {
          this.jdField_i_of_type_Boolean = false;
        }
        else
        {
          localObject1 = ContactUtils.b(this.app, this.jdField_k_of_type_JavaLangString);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            this.jdField_i_of_type_Boolean = false;
          }
          else
          {
            this.jdField_i_of_type_Boolean = true;
            this.jdField_i_of_type_JavaLangString = ((String)localObject1);
          }
        }
      }
      localObject1 = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_h_of_type_Boolean = ((ShieldMsgManger)localObject1).a(this.jdField_i_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initStrangerView, shieldMsgManger=");
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject3).append(bool);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject1 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_i_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject2 = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initStrangerView, f=");
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject3).append(bool);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject1 != null) && (((Friends)localObject1).groupid == -1002)) {
        this.jdField_h_of_type_Boolean = true;
      } else {
        this.jdField_h_of_type_Boolean = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initStrangerView, curType=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", mShieldUin=");
      ((StringBuilder)localObject2).append(this.jdField_i_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", mIsShield=");
      ((StringBuilder)localObject2).append(this.jdField_h_of_type_Boolean);
      ((StringBuilder)localObject2).append(", mShieldEnable=");
      ((StringBuilder)localObject2).append(this.jdField_i_of_type_Boolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (a(this.jdField_a_of_type_Int)) {
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    this.jdField_k_of_type_Boolean = true;
    B();
    localObject1 = new String[1];
    localObject1[0] = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
      e();
    }
    m = this.jdField_a_of_type_Int;
    if ((m != 1010) && (m != 1001) && (m != 10002) && (m != 10004)) {
      if (m == 1022)
      {
        m = this.jdField_f_of_type_Int;
        if ((m == 3007) || (m == 2007) || (m == 4007) || (m == 3019) || (m == 2019)) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getStrangerRichStatus((String[])localObject1, false);
        break label1642;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getStrangerRichStatus((String[])localObject1, true);
    label1642:
    m = this.jdField_a_of_type_Int;
    if ((m == 1001) || (m == 10002))
    {
      QQAppInterface localQQAppInterface = this.app;
      if (this.jdField_a_of_type_Int == 1001) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      if (this.jdField_a_of_type_Boolean) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      if (this.jdField_h_of_type_Boolean) {
        localObject3 = "0";
      } else {
        localObject3 = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, (String)localObject2, (String)localObject3, "");
    }
    m = this.jdField_a_of_type_Int;
    if ((m == 1044) || (m == 1045)) {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  private void n()
  {
    int m = ((IExpandManager)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    int i1 = 1;
    int i2 = 0;
    if ((m > 0) && (((IColdPalaceUtils)QRoute.api(IColdPalaceUtils.class)).getSvrShowGrayTipEntry(this.app))) {
      m = 1;
    } else {
      m = 0;
    }
    Object localObject = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i3 = 8;
    if (m != 0) {
      n = 0;
    } else {
      n = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(n);
    localObject = this.jdField_j_of_type_AndroidWidgetTextView;
    int n = i3;
    if (m != 0) {
      n = 0;
    }
    ((TextView)localObject).setVisibility(n);
    FormSimpleItem localFormSimpleItem = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (m != 0) {
      localObject = this;
    } else {
      localObject = null;
    }
    localFormSimpleItem.setOnClickListener((View.OnClickListener)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
    i3 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    n = i2;
    if (m != 0) {
      n = AIOUtils.b(12.0F, getResources());
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(i3, n, ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    localObject = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (m != 0) {
      m = i1;
    } else {
      m = 3;
    }
    ((FormSwitchItem)localObject).setBgType(m);
  }
  
  private void o()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(this.jdField_c_of_type_JavaLangString));
    boolean bool = ((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(this.jdField_c_of_type_JavaLangString);
    ((IMiniCardManager)this.app.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, bool ^ true, new ChatSettingActivity.3(this));
  }
  
  private void p()
  {
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    int m = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4)
          {
            if (m != 5) {
              return;
            }
            getResources().getString(2131716751);
            return;
          }
          getResources().getString(2131716749);
          return;
        }
        getResources().getString(2131716750);
        return;
      }
      getResources().getString(2131716752);
      return;
    }
    getResources().getString(2131716759);
  }
  
  private void q()
  {
    ReportController.b(this.app, "dc00898", "", "", "0X800B6B9", "0X800B6B9", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(getActivity(), 1, 2131692478, 0).a();
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setMessage(getResources().getString(2131698936)).setPositiveButton(getResources().getString(2131698935), new ChatSettingActivity.10(this)).setNegativeButton(getResources().getString(2131698934), new ChatSettingActivity.9(this));
    localQQCustomDialog.show();
    ((TextView)localQQCustomDialog.findViewById(2131365644)).setGravity(17);
  }
  
  private void r()
  {
    DialogUtil.a(this, 230).setMessage(HardCodeUtil.a(2131701932)).setPositiveButton(17039370, new ChatSettingActivity.12(this)).setNegativeButton(17039360, new ChatSettingActivity.11(this)).show();
  }
  
  private void s()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_entrance", 29);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, 2);
  }
  
  private void t()
  {
    ChatHistoryActivity.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, 3011);
  }
  
  private void u()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.b(this, VasWebviewUtil.a(IndividuationUrlHelper.a(this, "background", ""), 46), 33554432L, localIntent, true, 1);
  }
  
  private void v()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_d_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void w()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!QvipSpecialCareUtil.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130850769);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
      return;
    }
    boolean bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
    ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    if (bool)
    {
      localObject = getResources().getDrawable(2130850766);
      getResources().getDrawable(2130839270);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
  }
  
  private void x()
  {
    ChatSettingActivity.15 local15 = new ChatSettingActivity.15(this, new StringBuilder());
    if (!this.jdField_l_of_type_Boolean)
    {
      ThreadManager.post(local15, 8, null, true);
      a(2, getString(2131689992));
    }
  }
  
  private void y()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692183, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
      return;
    }
    z();
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
      {
        e();
        return;
      }
    }
    try
    {
      l1 = Long.parseLong(this.jdField_c_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      long l1;
      label62:
      break label62;
    }
    l1 = 0L;
    if (l1 > 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.changeFriendShieldFlag(l1, true ^ this.jdField_f_of_type_Boolean);
      return;
    }
    a(1, HardCodeUtil.a(2131701926));
  }
  
  private void z()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    boolean bool = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
    int n = 0;
    int m;
    if (!bool) {
      m = 0;
    } else {
      m = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(m);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      m = n;
    } else {
      m = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(m);
    a();
  }
  
  public int a()
  {
    return 2;
  }
  
  public Dialog a()
  {
    return this.jdField_a_of_type_AndroidAppDialog;
  }
  
  void a()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int m;
    if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      m = 0;
    } else {
      m = 8;
    }
    localFormSimpleItem.setVisibility(m);
  }
  
  public void a(Dialog paramDialog)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, int paramInt, String paramString)
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnBanishColdPalaceClick(paramBaseQQAppInterface, paramContext, paramInt, paramString, this);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null) {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this, getString(2131694401), new ChatSettingActivity.26(this), new ChatSettingActivity.27(this));
    }
    Dialog localDialog = this.jdField_b_of_type_AndroidAppDialog;
    if ((localDialog != null) && (!localDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void c()
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitConfirm(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this);
  }
  
  public void d()
  {
    ((IAioColdPalaceHelper)QRoute.api(IAioColdPalaceHelper.class)).doOnColdPalaceLimitCancel(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_e_of_type_Boolean = false;
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 1003) {
                return;
              }
              a(paramIntent);
              return;
            }
            if (paramIntent != null)
            {
              this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("follow_flag", false);
              C();
            }
          }
          else
          {
            paramInt1 = paramIntent.getIntExtra("param_subtype", -1);
            if (paramInt1 != 0)
            {
              if (paramInt1 != 1) {
                return;
              }
              Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
              paramIntent = paramIntent.getStringExtra("roomId");
              localIntent.putExtra("uin", paramIntent);
              localIntent.putExtra("uintype", 3000);
              localIntent.putExtra("uinname", ContactUtils.a(this.app, getApplicationContext(), paramIntent));
              localIntent.putExtra("isBack2Root", true);
              startActivity(localIntent);
              finish();
              return;
            }
            ReportController.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
            TroopUtils.a(this, paramIntent.getStringExtra("roomId"), true);
          }
        }
        else
        {
          v();
          finish();
        }
      }
      else {
        b(paramIntent);
      }
    }
    else if ((paramInt2 == 0) && (3 == paramInt1) && (paramIntent != null) && (paramIntent.getBooleanExtra("finchat", false))) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    e();
    f();
    h();
    i();
    j();
    ReportController.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_l_of_type_Boolean = true;
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
        this.jdField_b_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    g();
    this.jdField_k_of_type_Boolean = false;
  }
  
  protected void doOnPause()
  {
    this.jdField_e_of_type_Boolean = true;
    E();
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    this.jdField_e_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject1 != null)
    {
      if (this.jdField_k_of_type_Boolean)
      {
        ((MqqHandler)localObject1).removeMessages(32);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    ApngImage.playByTag(27);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      localObject1 = getString(2131716891);
      Object localObject2 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_c_of_type_JavaLangString);
      if ((localObject2 != null) && (((SpecialCareInfo)localObject2).globalSwitch != 0))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718660));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(getString(2131718660));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718659));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(getString(2131718659));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription((CharSequence)localObject1);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
      if ((localObject1 != null) && (!((MqqHandler)localObject1).hasMessages(34)))
      {
        int m = HotReactiveHelper.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject1 != null)
    {
      ((ViewGroup)localObject1).setVisibility(8);
      ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).f();
    }
    l();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      p();
      ((IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void finish()
  {
    int m = this.jdField_a_of_type_Int;
    if ((1001 == m) || (10002 == m))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("follow_flag", this.jdField_a_of_type_Boolean);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    int m;
    Object localObject1;
    boolean bool;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131380936: 
      VipUtils.VipIconUtils.VipIconTouchListener.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").onTouch(paramView, null);
      break;
    case 2131378658: 
      a(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString);
      break;
    case 2131377938: 
      ReportController.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      if (a(this.jdField_a_of_type_Int)) {
        NewReportPlugin.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString);
      }
      m = this.jdField_a_of_type_Int;
      if ((m == 1044) || (m == 1045))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("to_uid", this.jdField_c_of_type_JavaLangString);
        ((HashMap)localObject1).put("frompage", String.valueOf(a()));
        ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, (Map)localObject1, true, true);
      }
      break;
    case 2131377937: 
      F();
      break;
    case 2131377934: 
      m = this.jdField_a_of_type_Int;
      if ((1001 != m) && (10002 != m))
      {
        if ((1036 == m) && (this.jdField_h_of_type_Boolean))
        {
          r();
        }
        else
        {
          m = this.jdField_a_of_type_Int;
          if ((1044 != m) && (1045 != m))
          {
            G();
            ReportController.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
          }
          else
          {
            m = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("subId", 0);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("frompage", String.valueOf(m));
            ((HashMap)localObject1).put("to_uid", this.jdField_c_of_type_JavaLangString);
            ((HashMap)localObject1).put("session_id", ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).getSessionId(this.app.getCurrentAccountUin(), this.jdField_c_of_type_JavaLangString));
            ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_setting_page#add_friends_all", true, -1L, -1L, (Map)localObject1, true, true);
            G();
          }
        }
      }
      else
      {
        bool = this.jdField_a_of_type_Boolean;
        String str2 = "1";
        if (bool) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        if (1001 == this.jdField_a_of_type_Int) {
          a((String)localObject1);
        } else {
          b((String)localObject1);
        }
        ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
        QQAppInterface localQQAppInterface = this.app;
        if ("1".equals(localObject1)) {
          localObject2 = "follow_aio";
        } else {
          localObject2 = "unfollow_aio";
        }
        String str1;
        if (this.jdField_a_of_type_Int == 1001) {
          str1 = "0";
        } else {
          str1 = "1";
        }
        if ("1".equals(localObject1))
        {
          if (localShieldMsgManger.a(this.jdField_c_of_type_JavaLangString)) {
            localObject1 = str2;
          } else {
            localObject1 = "0";
          }
        }
        else {
          localObject1 = "";
        }
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str1, "1", (String)localObject1, "");
      }
      break;
    case 2131377747: 
      localObject1 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
      ((SharedPreferences)localObject1).edit().putBoolean("special_care_chat_setting", false).commit();
      if (((SharedPreferences)localObject1).getBoolean("special_care_red_point_one", false)) {
        ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", false).commit();
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      SpecialCareUtils.a(this, this.jdField_c_of_type_JavaLangString, 2);
      ReportController.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
      break;
    case 2131377618: 
      ReportController.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.jdField_c_of_type_JavaLangString, "", "", "");
      localObject1 = (TogetherControlManager)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      bool = ((TogetherControlManager)localObject1).a(4, 2, this.jdField_c_of_type_JavaLangString);
      localObject2 = TogetherUtils.a(bool, 5);
      if (bool) {
        ((TogetherControlManager)localObject1).b(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
      } else {
        ((TogetherControlManager)localObject1).a(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
      }
      TogetherUtils.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
      l();
      break;
    case 2131377289: 
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_c_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Int);
      MessageNotificationSettingFragment.a(this, (Intent)localObject1);
      break;
    case 2131377286: 
      u();
      ReportController.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      break;
    case 2131376787: 
      localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localObject1 != null)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((GetRoamToastRsp)localObject1).sUrl);
        ((Intent)localObject2).putExtra("isShowAd", false);
        startActivity((Intent)localObject2);
      }
      break;
    case 2131376781: 
      localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (localObject1 != null)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
        ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((GetRoamToastRsp)localObject1);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      break;
    case 2131376401: 
    case 2131376402: 
      q();
      break;
    case 2131367238: 
      H();
      break;
    case 2131365502: 
      ReportController.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
      a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, new ChatSettingActivity.4(this), 2);
      break;
    case 2131365329: 
      s();
      ReportController.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
      ReportController.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
      break;
    case 2131364681: 
      x();
      ReportController.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
      break;
    case 2131364494: 
      t();
      ReportController.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
      ReportController.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
      break;
    case 2131364214: 
      if (this.jdField_a_of_type_Int == 10008) {
        ReportController.b(this.app, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
      }
      NewReportPlugin.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin());
      break;
    case 2131364076: 
    case 2131365495: 
      f(this.jdField_c_of_type_JavaLangString);
      if (Utils.b(this.jdField_c_of_type_JavaLangString)) {
        ReportController.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
      break;
    case 2131362191: 
      J();
      ReportController.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */