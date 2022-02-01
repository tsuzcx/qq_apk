package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class BusinessCmrTmpChatPie
  extends FriendChatPie
{
  private boolean S = false;
  private boolean T = false;
  private boolean U = false;
  public Handler a;
  protected CustomMenuBar a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new BusinessCmrTmpChatPie.15(this);
  public EnterpriseQQObserver a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new BusinessCmrTmpChatPie.5(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new BusinessCmrTmpChatPie.6(this);
  public PublicAccountInfo a;
  public QidianBusinessObserver a;
  protected NewIntent a;
  long jdField_b_of_type_Long = 0L;
  protected LinearLayout b;
  protected MessageObserver b;
  QidianManager jdField_b_of_type_ComTencentQidianQidianManager;
  List<StructMsg.ButtonInfo> jdField_b_of_type_JavaUtilList = null;
  protected LinearLayout c;
  protected MessageObserver c;
  private int l;
  protected ImageView l;
  protected TextView l;
  protected ImageView m;
  protected TextView m;
  protected View n;
  protected ImageView n;
  public View o;
  protected ImageView o;
  
  public BusinessCmrTmpChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_MqqAppNewIntent = null;
    this.jdField_a_of_type_AndroidOsHandler = new BusinessCmrTmpChatPie.1(this);
    this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new BusinessCmrTmpChatPie.8(this);
    this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver = new BusinessCmrTmpChatPie.12(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new BusinessCmrTmpChatPie.14(this);
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new BusinessCmrTmpChatPie.16(this);
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      bl();
    }
  }
  
  private void bs()
  {
    if (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850251);
        q();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.b);
        bt();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = AIOUtils.a(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850392);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167183));
        }
        bo();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bt();
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
    ((FrameLayout.LayoutParams)localObject).topMargin = 1;
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void bt()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.jdField_a_of_type_Int <= 0)) {
      i = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() != i) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), i);
    }
  }
  
  private void bu()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558672, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_o_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372666);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366511));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366510);
    ((View)localObject).setOnClickListener(new BusinessCmrTmpChatPie.9(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new BusinessCmrTmpChatPie.10(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new BusinessCmrTmpChatPie.11(this));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373644));
      localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 1;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131366512));
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167183));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      this.jdField_o_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373298));
      this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131366225));
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130848264);
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130838139);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850392);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167183));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
      }
    }
  }
  
  private void bv()
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
    }
    while (this.T) {
      return;
    }
    this.T = true;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int i = localPubAccountNavigationMenu.version;; i = 0)
    {
      localQidianHandler.a(l1, l2, i, this.jdField_l_of_type_Int, false);
      return;
    }
  }
  
  private void x(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    ((Bundle)localObject1).putString("key_action_DATA", "" + paramInt);
    String str = ((Resources)localObject2).getString(2131693927);
    localObject2 = ((Resources)localObject2).getString(2131693928);
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void B()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850547, 2130850548);
  }
  
  protected boolean F()
  {
    PublicAccountDataManager localPublicAccountDataManager;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      boolean bool = this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label135:
      break label135;
    }
    if (!localPublicAccountDataManager.a(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  public void J()
  {
    super.J();
    if ((this.jdField_m_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.jdField_m_of_type_AndroidWidgetImageView);
      this.jdField_m_of_type_AndroidWidgetImageView = null;
    }
    if ((this.jdField_b_of_type_ComTencentQidianQidianManager != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), 0);
    }
  }
  
  public void P()
  {
    super.P();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    int j = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166);
    int i = j;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      i = j;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
        i = j + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297098);
      }
    }
    localLayoutParams.topMargin = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void S()
  {
    super.S();
    if ((this.jdField_m_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.jdField_m_of_type_AndroidWidgetImageView);
      this.jdField_m_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    }
  }
  
  public StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject;
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty()))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        break label156;
      }
      StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)this.jdField_b_of_type_JavaUtilList.get(i);
      localObject = localButtonInfo;
      if (localButtonInfo.id.get() == paramInt) {
        break;
      }
      localObject = localButtonInfo.sub_button.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int j = 0;
        while (j < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(j)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(j);
          }
          j += 1;
        }
      }
      i += 1;
    }
    label156:
    return null;
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    bj();
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        paramPubAccountNavigationMenu = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l1 = MobileQQService.seq;
          paramPubAccountNavigationMenu = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1, paramPubAccountNavigationMenu);
          if (paramPubAccountNavigationMenu != null)
          {
            paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
            localQQMessageFacade.a(paramPubAccountNavigationMenu, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          }
        }
        return;
      }
      catch (Exception paramPubAccountNavigationMenu)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("BusinessChatPie", 2, "Add message error: " + paramPubAccountNavigationMenu.getMessage());
        return;
      }
    }
    QLog.d("BusinessChatPie", 2, "showNavigationMenu not current uin or xml is null");
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.B = false;
    this.jdField_b_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      bu();
      if (!this.jdField_b_of_type_ComTencentQidianQidianManager.f(b()))
      {
        bo();
        EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), false);
      }
    }
    this.S = this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bq();
    Object localObject;
    if (!this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new BusinessCmrTmpChatPie.2(this);
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (BusinessObserver)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bt();
      }
    }
    for (;;)
    {
      bs();
      br();
      return true;
      localObject = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 6);
      this.jdField_b_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      e(paramEditable);
    }
  }
  
  public void al()
  {
    super.al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void am()
  {
    super.am();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(paramInt1), paramInt2);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.jdField_b_of_type_Boolean = true;
    paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && ((paramIntent == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(List<StructMsg.ButtonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while ((i < j) && (i <= 2))
      {
        Object localObject = (StructMsg.ButtonInfo)paramList.get(i);
        MenuItem localMenuItem = new MenuItem(((StructMsg.ButtonInfo)localObject).key.get(), ((StructMsg.ButtonInfo)localObject).name.get(), null, ((StructMsg.ButtonInfo)localObject).id.get());
        if (((StructMsg.ButtonInfo)localObject).sub_button.get().size() > 0)
        {
          localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            StructMsg.ButtonInfo localButtonInfo = (StructMsg.ButtonInfo)((Iterator)localObject).next();
            localMenuItem.a(new MenuItem(localButtonInfo.key.get(), localButtonInfo.name.get(), null, localButtonInfo.id.get()));
          }
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, b());
        i += 1;
      }
    }
  }
  
  protected void bj()
  {
    if (!this.jdField_b_of_type_ComTencentQidianQidianManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (F())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      bk();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    bl();
  }
  
  protected void bk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null)
    {
      BusinessCmrTmpChatPie.3 local3 = new BusinessCmrTmpChatPie.3(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131362584);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297098));
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131560112, null);
      this.jdField_n_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838395));
      this.jdField_n_of_type_AndroidViewView.findViewById(2131371188).setVisibility(8);
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_n_of_type_AndroidViewView.findViewById(2131371191));
      this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167109));
      ((ImageView)this.jdField_n_of_type_AndroidViewView.findViewById(2131371180)).setImageResource(2130841922);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(local3);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_n_of_type_AndroidViewView, localLayoutParams1);
      View localView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131560112, null);
      localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838395));
      this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371191));
      this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167109));
      this.jdField_m_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691889));
      ((ImageView)localView.findViewById(2131371180)).setImageResource(2130841814);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(local3);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362584);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131690028));
      this.jdField_n_of_type_AndroidViewView.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.jdField_m_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_m_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689912));
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_l_of_type_AndroidViewView);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297098) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166));
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        this.jdField_l_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691891));
        this.jdField_n_of_type_AndroidViewView.setTag(Integer.valueOf(2));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "removeHeaderView err");
          }
        }
      }
    }
  }
  
  protected void bl()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_l_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        int i = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.topMargin = i;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "addHeaderView err");
        }
      }
    }
  }
  
  void bm()
  {
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new BusinessCmrTmpChatPie.4(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void bn()
  {
    if (this.jdField_n_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130844952);
      this.jdField_n_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.e());
    this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850289);
        }
        for (;;)
        {
          this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698452));
          return;
          this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850738);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850288);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698451));
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850739);
      }
    }
    this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850289);
      }
      for (;;)
      {
        this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698452));
        label246:
        if (!VersionUtils.e()) {
          break;
        }
        this.jdField_n_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850738);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850288);
    }
    for (;;)
    {
      this.jdField_n_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698451));
      break label246;
      break;
      this.jdField_n_of_type_AndroidWidgetImageView.setImageResource(2130850739);
    }
  }
  
  public void bo()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      t(true);
    }
    for (;;)
    {
      b(this.jdField_b_of_type_JavaUtilList);
      return;
      t(false);
    }
  }
  
  public void bp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
      localObject = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
      try
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        label161:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new BusinessCmrTmpChatPie.13(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label161;
      }
    }
  }
  
  public void bq()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019) || (localMessageRecord.msgtype == -7006)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(str, 0, localMessageRecord.uniseq);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void br()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.jdField_l_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      long l1;
      do
      {
        return;
        l1 = System.currentTimeMillis();
      } while (Math.abs(l1 - this.jdField_b_of_type_Long) < 1000L);
      this.jdField_b_of_type_Long = l1;
      this.T = false;
    } while (!this.jdField_b_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false));
    bv();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bn();
    if (paramInt2 == 8) {
      if (this.jdField_o_of_type_AndroidWidgetImageView != null)
      {
        if (!CustomMenuBar.a()) {
          break label40;
        }
        this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130850338);
      }
    }
    label40:
    while (this.jdField_o_of_type_AndroidWidgetImageView == null)
    {
      return;
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130850260);
      return;
    }
    if (CustomMenuBar.a())
    {
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130850337);
      return;
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130850259);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    if (!this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bp();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        bt();
      }
    }
  }
  
  public void d(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + HexUtil.bytes2HexStr(paramIntent));
    }
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  void e(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      w(80);
      return;
    }
    w(16);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.c();
    }
    return super.g();
  }
  
  public void i(String paramString)
  {
    PubAccountNavigationMenu localPubAccountNavigationMenu;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (!"1".equals(paramString)) {
        break label110;
      }
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
      l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
      if (localPubAccountNavigationMenu == null) {
        break label105;
      }
      i = localPubAccountNavigationMenu.version;
      paramString.a(l1, l2, i, 0, true);
    }
    label105:
    label110:
    while (localPubAccountNavigationMenu == null) {
      for (;;)
      {
        long l1;
        long l2;
        return;
        int i = 0;
      }
    }
    a(localPubAccountNavigationMenu);
  }
  
  public void m(int paramInt)
  {
    super.m(paramInt);
    bt();
  }
  
  public void o()
  {
    super.o();
    if (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bl();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366512) {
      t(true);
    }
    FastImageHelper localFastImageHelper;
    if ((paramView.getId() == 2131366225) && (this.jdField_a_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131373298)
    {
      ShortVideoUtils.loadShortVideoSo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localFastImageHelper = (FastImageHelper)a(83);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 8) {
        break label227;
      }
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689999));
      }
      localFastImageHelper.b(true);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label227:
      localFastImageHelper.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if (this.jdField_o_of_type_AndroidWidgetImageView != null) {
        this.jdField_o_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689921));
      }
      n(0);
    }
  }
  
  public void p()
  {
    if (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bj();
    }
  }
  
  public void t(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.jdField_l_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void v()
  {
    if (this.jdField_b_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new BusinessCmrTmpChatPie.7(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698535));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void v(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  void w(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams.gravity != paramInt)
      {
        localLayoutParams.gravity = paramInt;
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams1);
      }
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    } while (localLayoutParams.gravity == paramInt);
    localLayoutParams.gravity = paramInt;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams);
  }
  
  public void z()
  {
    int i = 0;
    if (this.jdField_b_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localIntent.putExtra("uintype", i);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
        return;
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    CrmUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie
 * JD-Core Version:    0.7.0.1
 */