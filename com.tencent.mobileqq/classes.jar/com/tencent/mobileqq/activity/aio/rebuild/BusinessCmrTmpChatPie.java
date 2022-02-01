package com.tencent.mobileqq.activity.aio.rebuild;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
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
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.input.InputRightIconUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.helper.CmrHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.managers.TempMsgManager;
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
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  long jdField_a_of_type_Long = 0L;
  public Handler a;
  protected LinearLayout a;
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  protected CustomMenuBar a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new BusinessCmrTmpChatPie.15(this);
  public EnterpriseQQObserver a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new BusinessCmrTmpChatPie.6(this);
  public PublicAccountInfo a;
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  public QidianBusinessObserver a;
  List<StructMsg.ButtonInfo> jdField_a_of_type_JavaUtilList = null;
  protected NewIntent a;
  protected LinearLayout b;
  protected MessageObserver b;
  protected MessageObserver c;
  private int h;
  protected View h;
  protected TextView h;
  public View i;
  protected TextView i;
  protected ImageView l;
  protected ImageView m;
  protected ImageView n;
  protected ImageView o;
  
  public BusinessCmrTmpChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_a_of_type_MqqAppNewIntent = null;
    this.jdField_a_of_type_AndroidOsHandler = new BusinessCmrTmpChatPie.1(this);
    this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new BusinessCmrTmpChatPie.8(this);
    this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver = new BusinessCmrTmpChatPie.12(this);
    this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver = new BusinessCmrTmpChatPie.14(this);
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new BusinessCmrTmpChatPie.16(this);
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(new BusinessCmrTmpChatPie.2(this));
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      as();
    }
  }
  
  private void aA()
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.jdField_a_of_type_Int > 0)) {
      j = 0;
    } else {
      j = AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() != j) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), j);
    }
  }
  
  private void aB()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131558570, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372244);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366391));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366390);
    ((View)localObject).setOnClickListener(new BusinessCmrTmpChatPie.9(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new BusinessCmrTmpChatPie.10(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new BusinessCmrTmpChatPie.11(this));
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    } else if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373217));
    localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a();
    if (localView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 1;
      ((FrameLayout.LayoutParams)localObject).gravity = 16;
      localView.setLayoutParams(localLayoutParams);
    }
    this.l = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366392));
    this.l.setOnClickListener(this);
    if (CustomMenuBar.a())
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167208));
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.b(48.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
    }
    this.o = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372878));
    this.o.setOnClickListener(this);
    this.n = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366114));
    this.n.setOnClickListener(this);
    if (!CustomMenuBar.a())
    {
      this.n.setImageResource(2130848134);
      this.o.setImageResource(2130837988);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850319);
      if (CustomMenuBar.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167208));
      }
    }
  }
  
  private void aC()
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
      return;
    }
    if (!this.J)
    {
      this.J = true;
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
      long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
      int j;
      if (localPubAccountNavigationMenu != null) {
        j = localPubAccountNavigationMenu.version;
      } else {
        j = 0;
      }
      localQidianHandler.a(l1, l2, j, this.jdField_h_of_type_Int, false);
    }
  }
  
  private void az()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850178);
        g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.b);
        aA();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        localLayoutParams.bottomMargin = 0;
        localLayoutParams.topMargin = 1;
        localLayoutParams.leftMargin = AIOUtils.b(8.0F, (Resources)localObject);
        localLayoutParams.gravity = 80;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, 2130850319);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167208));
        }
        av();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        aA();
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 1;
        ((FrameLayout.LayoutParams)localObject).gravity = 16;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void n(int paramInt)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramInt);
    ((Bundle)localObject1).putString("key_action_DATA", ((StringBuilder)localObject3).toString());
    localObject3 = ((Resources)localObject2).getString(2131693883);
    localObject2 = ((Resources)localObject2).getString(2131693884);
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject3, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    paramInt = ((String)localObject3).indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(paramInt, ((String)localObject2).length() + paramInt, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void O()
  {
    super.O();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void P()
  {
    super.P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public StructMsg.ButtonInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return null;
      }
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (StructMsg.ButtonInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        if (((StructMsg.ButtonInfo)localObject).id.get() == paramInt) {
          return localObject;
        }
        localObject = ((StructMsg.ButtonInfo)localObject).sub_button.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int k = 0;
          while (k < ((List)localObject).size())
          {
            if (((StructMsg.ButtonInfo)((List)localObject).get(k)).id.get() == paramInt) {
              return (StructMsg.ButtonInfo)((List)localObject).get(k);
            }
            k += 1;
          }
        }
        j += 1;
      }
    }
    return null;
  }
  
  protected AIOContext a()
  {
    return new BusinessCmrTmpContext();
  }
  
  protected HelperProvider a()
  {
    return new CmrHelperProvider(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    aq();
  }
  
  void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      m(80);
      return;
    }
    m(16);
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramPubAccountNavigationMenu.puin))))
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        paramPubAccountNavigationMenu = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu == null) {
          return;
        }
        long l1 = MobileQQService.seq;
        paramPubAccountNavigationMenu = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1, paramPubAccountNavigationMenu);
        if (paramPubAccountNavigationMenu == null) {
          return;
        }
        paramPubAccountNavigationMenu.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
        ((QQMessageFacade)localObject).a(paramPubAccountNavigationMenu, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        return;
      }
      catch (Exception paramPubAccountNavigationMenu)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Add message error: ");
      ((StringBuilder)localObject).append(paramPubAccountNavigationMenu.getMessage());
      QLog.d("BusinessChatPie", 2, ((StringBuilder)localObject).toString());
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BusinessChatPie", 2, "showNavigationMenu not current uin or xml is null");
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.v = false;
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      aB();
      if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(b()))
      {
        av();
        EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), false);
      }
    }
    this.I = this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ax();
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new BusinessCmrTmpChatPie.3(this);
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (BusinessObserver)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        aA();
      }
    }
    else
    {
      localObject = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 6);
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (BmqqAccountType)localObject);
    }
    az();
    ay();
    return true;
  }
  
  protected void aq()
  {
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (u())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      ar();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    as();
  }
  
  protected void ar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      BusinessCmrTmpChatPie.4 local4 = new BusinessCmrTmpChatPie.4(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362540);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297080));
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559983, null);
      this.jdField_h_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838225));
      this.jdField_h_of_type_AndroidViewView.findViewById(2131370813).setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_h_of_type_AndroidViewView.findViewById(2131370816));
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167134));
      ((ImageView)this.jdField_h_of_type_AndroidViewView.findViewById(2131370804)).setImageResource(2130841813);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(local4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_h_of_type_AndroidViewView, localLayoutParams1);
      View localView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559983, null);
      localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838225));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370816));
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167134));
      this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691811));
      ((ImageView)localView.findViewById(2131370804)).setImageResource(2130841700);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener(local4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131362540);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689943));
      this.jdField_h_of_type_AndroidViewView.setTag(Integer.valueOf(1));
    }
    else
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131691813));
      this.jdField_h_of_type_AndroidViewView.setTag(Integer.valueOf(2));
    }
    if ((this.jdField_i_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689826));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.f);
    }
    catch (Exception localException)
    {
      label607:
      break label607;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "removeHeaderView err");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a((int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131297080));
  }
  
  protected void as()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() != 0) {
        break label55;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.f);
    }
    catch (Exception localException)
    {
      label39:
      label55:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "addHeaderView err");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a(0);
  }
  
  void at()
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_MqqAppNewIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new BusinessCmrTmpChatPie.5(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void au()
  {
    ImageView localImageView = this.n;
    if (localImageView == null) {
      return;
    }
    localImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.n.setImageResource(2130850216);
      } else {
        this.n.setImageResource(2130850664);
      }
      this.n.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698518));
    }
    else
    {
      if (CustomMenuBar.a()) {
        this.n.setImageResource(2130850215);
      } else {
        this.n.setImageResource(2130850665);
      }
      this.n.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131698517));
    }
    if (VersionUtils.e()) {
      this.n.setAlpha(1.0F);
    }
  }
  
  public void av()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    List localList = EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(localList);
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty())) {
      m(true);
    } else {
      m(false);
    }
    b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void aw()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
    }
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(1);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      label155:
      ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new BusinessCmrTmpChatPie.13(this));
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): END");
      }
      return;
    }
    catch (Exception localException)
    {
      break label155;
    }
  }
  
  public void ax()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, 0);
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
  
  public void ay()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (Math.abs(l1 - this.jdField_a_of_type_Long) < 1000L) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    this.J = false;
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false)) {
      aC();
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    au();
    if (paramInt2 == 8)
    {
      if (this.o != null)
      {
        if (CustomMenuBar.a())
        {
          this.o.setImageResource(2130850265);
          return;
        }
        this.o.setImageResource(2130850187);
      }
    }
    else if (this.o != null)
    {
      if (CustomMenuBar.a())
      {
        this.o.setImageResource(2130850264);
        return;
      }
      this.o.setImageResource(2130850186);
    }
  }
  
  protected void b(Intent paramIntent)
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
    int j = 0;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.l.setVisibility(0);
      int k = paramList.size();
      while (j < k)
      {
        if (j > 2) {
          return;
        }
        Object localObject = (StructMsg.ButtonInfo)paramList.get(j);
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
        j += 1;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    this.l.setVisibility(8);
  }
  
  protected void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      aw();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
        aA();
      }
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void d(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("From chatActivity : buinessCrm Sigt--->");
      localStringBuilder.append(HexUtil.bytes2HexStr(paramIntent));
      QLog.d("BusinessChatPie", 2, localStringBuilder.toString());
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
  
  public void d(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ("1".equals(paramString))
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramString = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        int j;
        if (localPubAccountNavigationMenu != null) {
          j = localPubAccountNavigationMenu.version;
        } else {
          j = 0;
        }
        paramString.a(l1, l2, j, 0, true);
        return;
      }
      if (localPubAccountNavigationMenu != null) {
        a(localPubAccountNavigationMenu);
      }
    }
  }
  
  public boolean d()
  {
    CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.c();
    }
    return super.d();
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    aA();
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new BusinessCmrTmpChatPie.7(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698601));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        j = 0;
      } else {
        j = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
      localIntent.putExtra("uintype", j);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2000);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Open_biz_card", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
  }
  
  public void l(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  protected void m()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850473, 2130850474);
  }
  
  void m(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    localObject = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (localLayoutParams.gravity != paramInt)
    {
      localLayoutParams.gravity = paramInt;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams);
    }
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    if (((LinearLayout.LayoutParams)localObject).gravity != paramInt)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void m(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(4);
        return;
      }
      this.l.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366392) {
      m(true);
    }
    if (paramView.getId() == 2131366114) {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      }
    }
    if (paramView.getId() == 2131372878)
    {
      ShortVideoUtils.loadShortVideoSo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Object localObject = (FastImageHelper)a(83);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8)
      {
        ImageView localImageView = this.o;
        if (localImageView != null) {
          localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689914));
        }
        ((FastImageHelper)localObject).b(true);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      }
      else
      {
        ((FastImageHelper)localObject).b();
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
        localObject = this.o;
        if (localObject != null) {
          ((ImageView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689835));
        }
        h(0);
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void p()
  {
    super.p();
    if ((this.m != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.m);
      this.m = null;
    }
    QidianManager localQidianManager = this.jdField_a_of_type_ComTencentQidianQidianManager;
    if ((localQidianManager != null) && (localQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingRight(), 0);
    }
  }
  
  protected boolean u()
  {
    Object localObject;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      boolean bool = this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showOrHideFollow isQidianMasterInCache: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("ChatActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (bool) {
        return this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) ^ true;
      }
      localObject = (IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label144:
      break label144;
    }
    if (!((IPublicAccountDataManager)localObject).isFollowedUin(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  protected void w()
  {
    super.w();
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int j;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0)) {
      j = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131297080);
    } else {
      j = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a(j);
  }
  
  public void z()
  {
    super.z();
    if ((this.m != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeView(this.m);
      this.m = null;
    }
    CustomMenuBar localCustomMenuBar = this.jdField_a_of_type_ComTencentBizUiCustomMenuBar;
    if (localCustomMenuBar != null) {
      localCustomMenuBar.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie
 * JD-Core Version:    0.7.0.1
 */