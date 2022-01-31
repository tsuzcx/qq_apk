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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.MenuItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qphone.base.util.QLog;
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
import vqz;
import vra;
import vrb;
import vrc;
import vrd;
import vrf;
import vrg;
import vrh;
import vri;
import vrj;
import vrk;
import vrl;
import vro;
import vrp;
import vrq;
import vrr;
import vrs;
import vrt;
import vru;

public class BusinessCmrTmpChatPie
  extends FriendChatPie
{
  private boolean R;
  private boolean S;
  private boolean T;
  public Handler a;
  public CustomMenuBar a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new vrj(this);
  public EnterpriseQQObserver a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  protected MessageObserver a;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new vrq(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new vrr(this);
  public PublicAccountInfo a;
  public QidianManager a;
  public QidianBusinessObserver a;
  protected NewIntent a;
  protected MessageObserver b;
  public List b;
  protected LinearLayout d;
  protected LinearLayout e;
  public final String f = "BusinessChatPie";
  long h = 0L;
  protected TextView j;
  protected TextView k;
  private int m;
  protected ImageView n;
  protected View o;
  protected ImageView o;
  public View p;
  protected ImageView p;
  protected ImageView q;
  
  public BusinessCmrTmpChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new vqz(this);
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vrt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver = new vrc(this);
    this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver = new vri(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new vrk(this);
  }
  
  private void a(EqqDetail paramEqqDetail)
  {
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1)) {
      aZ();
    }
  }
  
  private void bj()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845636);
        l();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.b);
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      }
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
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
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845774);
        if (CustomMenuBar.a()) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493279));
        }
        bc();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 1;
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void bk()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130968658, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_p_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363048);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar = ((CustomMenuBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363051));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363047);
    ((View)localObject).setOnClickListener(new vru(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setCoverView((View)localObject);
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnMenuItemClickListener(new vra(this));
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setOnBackClickListner(new vrb(this));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("crm_ivr_aio_video_action_sheet", false)) {
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.c.findViewById(2131363496));
      localObject = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 1;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      ((LinearLayout.LayoutParams)localObject).topMargin = 1;
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.n = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131361893));
      this.n.setOnClickListener(this);
      if (CustomMenuBar.a())
      {
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493279));
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setMinimumHeight(AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
      }
      this.q = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131365600));
      this.q.setOnClickListener(this);
      this.jdField_p_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetLinearLayout.findViewById(2131364075));
      this.jdField_p_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (!CustomMenuBar.a())
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130844545);
        this.q.setImageResource(2130837588);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130845774);
        if (CustomMenuBar.a()) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131493279));
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "We needn't show video action sheet, because isShowVideoActionSheet is false");
      }
    }
  }
  
  private void bl()
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "checkNavigationMenuUpdate msg shielded");
      }
    }
    while (this.S) {
      return;
    }
    this.S = true;
    long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    QidianHandler localQidianHandler = (QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    if (localPubAccountNavigationMenu != null) {}
    for (int i = localPubAccountNavigationMenu.version;; i = 0)
    {
      localQidianHandler.a(l1, l2, i);
      return;
    }
  }
  
  private void bm()
  {
    new Bundle().putInt("key_action", 26);
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
    Object localObject2 = BaseApplicationImpl.getApplication().getResources();
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 26);
    String str = ((Resources)localObject2).getString(2131438732);
    localObject2 = ((Resources)localObject2).getString(2131438733);
    localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime(), -2064, 0, 0L);
    int i = str.indexOf((String)localObject2);
    localMessageForGrayTips.addHightlightItem(i, ((String)localObject2).length() + i, (Bundle)localObject1);
    localObject1 = new ArrayList();
    ((List)localObject1).add(localMessageForGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void H()
  {
    super.H();
    if ((this.jdField_o_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_o_of_type_AndroidWidgetImageView);
      this.jdField_o_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
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
        int i1 = 0;
        while (i1 < ((List)localObject).size())
        {
          if (((StructMsg.ButtonInfo)((List)localObject).get(i1)).id.get() == paramInt) {
            return (StructMsg.ButtonInfo)((List)localObject).get(i1);
          }
          i1 += 1;
        }
      }
      i += 1;
    }
    label156:
    return null;
  }
  
  public void a(int paramInt, BusinessObserver paramBusinessObserver)
  {
    EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    if (localEnterpriseQQHandler != null) {
      localEnterpriseQQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3, paramInt, 2, paramBusinessObserver);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    aX();
  }
  
  void a(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount() > 1))
    {
      w(80);
      return;
    }
    w(16);
  }
  
  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo != null)
    {
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager == null) {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): pam is null");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      PublicAccountDataManager localPublicAccountDataManager;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo.mIsSyncLbsSelected=" + paramPublicAccountInfo.mIsSyncLbsSelected + ", eqqPublicAccountInfo.isSyncLbs=" + paramPublicAccountInfo.isSyncLbs + ", eqqPublicAccountInfo.mIsAgreeSyncLbs=" + paramPublicAccountInfo.mIsAgreeSyncLbs);
        }
      } while ((!paramPublicAccountInfo.isSyncLbs) || (paramPublicAccountInfo.mIsSyncLbsSelected) || (paramPublicAccountInfo.mIsAgreeSyncLbs));
      String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131428081);
      String str2 = String.format(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131428082), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
      paramPublicAccountInfo = DialogUtil.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, str1, str2, 2131428083, 2131428084, new vrd(this, paramPublicAccountInfo, localPublicAccountDataManager), new vrf(this, paramPublicAccountInfo, localPublicAccountDataManager));
      paramPublicAccountInfo.setCanceledOnTouchOutside(true);
      paramPublicAccountInfo.show();
      return;
    }
    QLog.e("BusinessChatPie", 2, "showEqqLbsEnableDialog(): eqqPublicAccountInfo=NULL, uin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if ((paramPubAccountNavigationMenu != null) && (paramPubAccountNavigationMenu.xml != null) && (paramPubAccountNavigationMenu.xml.length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramPubAccountNavigationMenu.puin)))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramPubAccountNavigationMenu = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), paramPubAccountNavigationMenu.xml.getBytes(), 0);
        if (paramPubAccountNavigationMenu != null)
        {
          long l = MobileQQService.jdField_a_of_type_Int;
          paramPubAccountNavigationMenu = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l, paramPubAccountNavigationMenu);
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
  
  protected boolean a(boolean paramBoolean)
  {
    this.C = false;
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    super.a(paramBoolean);
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())
    {
      bk();
      if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(a()))
      {
        bc();
        EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), false);
      }
    }
    this.R = this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    bg();
    Object localObject;
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
      localObject = new vrl(this);
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (BusinessObserver)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
    }
    for (;;)
    {
      bj();
      bh();
      return true;
      localObject = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 6);
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (BmqqAccountType)localObject);
    }
  }
  
  public void aX()
  {
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView don't request qidian master, so wait request show");
      }
      return;
    }
    if (x())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateFollowAndShieldView true");
      }
      aY();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateFollowAndShieldView false");
    }
    aZ();
  }
  
  protected void aY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showFollowAndShield() ==== called.");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject2 = new vro(this);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setId(2131361976);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131558669));
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      this.jdField_o_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130969526, null);
      this.jdField_o_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837757));
      this.jdField_o_of_type_AndroidViewView.findViewById(2131366828).setVisibility(8);
      this.j = ((TextView)this.jdField_o_of_type_AndroidViewView.findViewById(2131364575));
      this.j.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131494260));
      ((ImageView)this.jdField_o_of_type_AndroidViewView.findViewById(2131364574)).setImageResource(2130839733);
      this.jdField_o_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject2);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(this.jdField_o_of_type_AndroidViewView, localLayoutParams1);
      View localView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130969526, null);
      localView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837757));
      this.k = ((TextView)localView.findViewById(2131364575));
      this.k.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131494260));
      this.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131436132));
      ((ImageView)localView.findViewById(2131364574)).setImageResource(2130839692);
      localView.setTag(Integer.valueOf(3));
      localView.setOnClickListener((View.OnClickListener)localObject2);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams1);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(3, 2131361976);
      localLayoutParams.topMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0, localLayoutParams);
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      this.j.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131433405));
      this.jdField_o_of_type_AndroidViewView.setTag(Integer.valueOf(1));
    }
    for (;;)
    {
      if ((this.k != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.k.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131433403));
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeHeaderView(this.jdField_m_of_type_AndroidViewView);
        localObject1 = this.c.findViewById(2131363508);
        if (localObject1 != null)
        {
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131558669));
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        return;
        this.j.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131436131));
        this.jdField_o_of_type_AndroidViewView.setTag(Integer.valueOf(2));
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
  
  protected void aZ()
  {
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_m_of_type_AndroidViewView);
      }
      if (this.c != null)
      {
        View localView = this.c.findViewById(2131363508);
        if (localView != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.topMargin = 0;
          localView.setLayoutParams(localLayoutParams);
        }
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
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEnterpriseQQObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      a(paramEditable);
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, a(paramInt1), paramInt2);
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.jdField_a_of_type_Boolean = true;
    paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && ((paramIntent == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.n.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.n.setVisibility(0);
      int i1 = paramList.size();
      int i = 0;
      while ((i < i1) && (i <= 2))
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
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.a(localMenuItem, a());
        i += 1;
      }
    }
  }
  
  public void ba()
  {
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow");
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    Object localObject = new mobileqq_mp.FollowRequest();
    ((mobileqq_mp.FollowRequest)localObject).account_type.set(2);
    ((mobileqq_mp.FollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.FollowRequest)localObject).toByteArray());
    localObject = new vrp(this);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver((BusinessObserver)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "follow exit");
    }
  }
  
  @TargetApi(11)
  protected void bb()
  {
    if (this.jdField_p_of_type_AndroidWidgetImageView == null) {}
    do
    {
      return;
      if (this.jdField_e_of_type_Int != 1) {
        break;
      }
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130842202);
      this.jdField_p_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(true);
    } while (!VersionUtils.e());
    this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    return;
    if (this.jdField_e_of_type_Int == 2)
    {
      this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(false);
      if (VersionUtils.e()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(0.6F);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        if (CustomMenuBar.a()) {
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845670);
        }
        for (;;)
        {
          this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433396));
          return;
          this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845964);
        }
      }
      if (CustomMenuBar.a()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845669);
      }
      for (;;)
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433395));
        return;
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845965);
      }
    }
    this.jdField_p_of_type_AndroidWidgetImageView.setEnabled(true);
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      if (CustomMenuBar.a()) {
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845670);
      }
      for (;;)
      {
        this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433396));
        label246:
        if (!VersionUtils.e()) {
          break;
        }
        this.jdField_p_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
        this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845964);
      }
    }
    if (CustomMenuBar.a()) {
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845669);
    }
    for (;;)
    {
      this.jdField_p_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131433395));
      break label246;
      break;
      this.jdField_p_of_type_AndroidWidgetImageView.setImageResource(2130845965);
    }
  }
  
  public void bc()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = EnterpriseQQManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_b_of_type_JavaUtilList.addAll(localList);
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      o(true);
    }
    for (;;)
    {
      b(this.jdField_b_of_type_JavaUtilList);
      return;
      o(false);
    }
  }
  
  public void bd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog(): BEGIN");
    }
    Object localObject;
    if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isforceRequestDetail", false))
    {
      localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo);
    }
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
        label166:
        ((NewIntent)localObject).putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new vrg(this));
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "showEqqLbsEnableDialog() get eqq detail");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
  
  public void be()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo == null)
    {
      PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      if (localPublicAccountDataManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo = localPublicAccountDataManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.isSyncLbs) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mIsAgreeSyncLbs)) {
      bf();
    }
  }
  
  public void bf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "getMyLocationAndSend(): BEGIN");
    }
    SosoInterface.a(new vrh(this, 1, true, true, 0L, true, false, "BusinessCmrTmpChatPie"));
  }
  
  public void bg()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.msgtype == -1013) || (localMessageRecord.msgtype == -1019) || (localMessageRecord.msgtype == -1018) || (localMessageRecord.msgtype == -2019)) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 0, localMessageRecord.uniseq);
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
  
  public void bh()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessChatPie", 2, "checkNavigationMenuUpdate");
    }
    this.jdField_m_of_type_Int = c();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
      } while (Math.abs(l - this.h) < 1000L);
      this.h = l;
      this.S = false;
    } while (!this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false));
    bl();
  }
  
  public void bi()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      PubAccountNavigationMenu localPubAccountNavigationMenu = ((QidianPubAccountBigDataHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localPubAccountNavigationMenu != null) {
        a(localPubAccountNavigationMenu);
      }
    }
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    bb();
    if (paramInt2 == 8) {
      if (this.q != null)
      {
        if (!CustomMenuBar.a()) {
          break label40;
        }
        this.q.setImageResource(2130845713);
      }
    }
    label40:
    while (this.q == null)
    {
      return;
      this.q.setImageResource(2130845645);
      return;
    }
    if (CustomMenuBar.a())
    {
      this.q.setImageResource(2130845712);
      return;
    }
    this.q.setImageResource(2130845644);
  }
  
  public void c(Intent paramIntent)
  {
    paramIntent.putExtra("uintype", 1024);
    super.c(paramIntent);
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      bd();
      be();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
    }
  }
  
  protected void d(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_business");
    paramIntent = paramIntent.getByteArrayExtra("sigt");
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "From chatActivity : buinessCrm Sigt--->" + HexUtil.a(paramIntent));
    }
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("BusinessChatPie", 4, "updateSession()--AIO 已保存 sigt");
      }
    }
    StartupTracker.a("AIO_updateSession_business", null);
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected boolean e()
  {
    if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar != null) {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b();
    }
    return super.e();
  }
  
  protected void g(Intent paramIntent)
  {
    super.g(paramIntent);
    bh();
  }
  
  public void j()
  {
    super.j();
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      aZ();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      aX();
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.n.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131361893) {
      o(true);
    }
    if ((paramView.getId() == 2131364075) && (this.jdField_e_of_type_Int != 1))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005796", 0, 0, "", "", "", "");
      }
    }
    else if (paramView.getId() == 2131365600)
    {
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 8) {
        break label243;
      }
      if (this.q != null) {
        this.q.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437051));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "BaseCHatPie onClick keybordicon removeFastImage");
        }
        a(true);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005795", 0, 0, "", "", "", "");
      break;
      label243:
      Y();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
      if (this.q != null) {
        this.q.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437052));
      }
      k(0);
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new vrs(this));
      if (AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131433381));
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void s()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
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
  
  protected void u()
  {
    a(this.jdField_a_of_type_AndroidWidgetImageView, 2130845900, 2130845901);
  }
  
  public void v(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramInt, 0).show();
  }
  
  void w(int paramInt)
  {
    if (this.jdField_e_of_type_AndroidWidgetLinearLayout == null) {}
    LinearLayout.LayoutParams localLayoutParams1;
    do
    {
      return;
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      if (localLayoutParams1.gravity != paramInt)
      {
        localLayoutParams1.gravity = paramInt;
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
      }
      if (localLayoutParams2.gravity != paramInt)
      {
        localLayoutParams2.gravity = paramInt;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams(localLayoutParams2);
      }
      localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    } while (localLayoutParams1.gravity == paramInt);
    localLayoutParams1.gravity = paramInt;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams(localLayoutParams1);
  }
  
  protected boolean x()
  {
    PublicAccountDataManager localPublicAccountDataManager;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) && (!BmqqSegmentUtil.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      boolean bool = this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "showOrHideFollow isQidianMasterInCache: " + bool);
      }
      if (bool) {
        return !this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label134:
      break label134;
    }
    if (!localPublicAccountDataManager.a(Long.valueOf(l1))) {
      return true;
    }
    return false;
  }
  
  protected void z()
  {
    super.z();
    if ((this.jdField_o_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_o_of_type_AndroidWidgetImageView);
      this.jdField_o_of_type_AndroidWidgetImageView = null;
    }
    if ((this.jdField_a_of_type_ComTencentQidianQidianManager != null) && (this.jdField_a_of_type_ComTencentQidianQidianManager.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ((QidianHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie
 * JD-Core Version:    0.7.0.1
 */