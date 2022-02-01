package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactUtils;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.adapter.MayKnowAdapter;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsCanceledListener;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.IFirstLocationReqCancelListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131699909);
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new AddContactsView.1(this);
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  MayKnowAdapter.OnRecommendsCanceledListener jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = new AddContactsView.3(this);
  private MayKnowAdapter jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
  RecommendFriendAdapter jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new AddContactsView.8(this);
  ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener = new AddContactsView.9(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new AddContactsView.11(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  SwipListView.RightIconMenuListener jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener = new AddContactsView.6(this);
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AddContactsView.13(this);
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private long jdField_b_of_type_Long;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  MayKnowAdapter.OnRecommendsCanceledListener jdField_b_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener = new AddContactsView.4(this);
  FormMutiItem jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_b_of_type_Boolean;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  FormMutiItem jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_c_of_type_Boolean = false;
  FormMutiItem jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_d_of_type_Boolean = false;
  FormMutiItem jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private boolean jdField_e_of_type_Boolean;
  FormMutiItem f;
  FormMutiItem g;
  FormMutiItem h;
  FormMutiItem i;
  
  public AddContactsView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3, false);
  }
  
  private FormMutiItem a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = new FormMutiWithAvatarItem(this.jdField_a_of_type_AndroidAppActivity);; localObject = new FormMutiItem(this.jdField_a_of_type_AndroidAppActivity))
    {
      ((FormMutiItem)localObject).setId(paramInt1);
      ((FormMutiItem)localObject).setClickable(true);
      ((FormMutiItem)localObject).setFocusable(true);
      ((FormMutiItem)localObject).setBgType(3);
      ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131167040));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(56.0F, getResources()));
      if (paramInt3 == 0) {
        localLayoutParams.topMargin = ((int)(12.0F * DeviceInfoUtil.a()));
      }
      ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
      ((FormMutiItem)localObject).setBackgroundResource(2130839532);
      return localObject;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideFace2FaceAddFriendGuideTips, save=").append(paramBoolean).append(" isShowing:");
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        break label116;
      }
    }
    label116:
    for (boolean bool = false;; bool = this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      QLog.d("AddContactsView", 2, bool);
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
      {
        if ((this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (paramBoolean))
        {
          this.jdField_e_of_type_Boolean = false;
          Face2FaceAddContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      }
      if (this.i != null) {
        this.i.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
  }
  
  private void i()
  {
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.jdField_a_of_type_Boolean = localMayknowRecommendManager.b("sp_mayknow_addpage_s_a_vl");
    if ((localMayknowRecommendManager.b("sp_mayknow_entry_list_add")) && (!StudyModeManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.jdField_c_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_c_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((DatingUtil.a()) || (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))) {
        break label178;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
      ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener);
      }
      return;
      label178:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131362178));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new AddContactsView.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131366444));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131298279), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130850763);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(HardCodeUtil.a(2131699911));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130845088));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689643));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844833));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689641));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(HardCodeUtil.a(2131699907));
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844832));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(HardCodeUtil.a(2131699912));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(HardCodeUtil.a(2131699908));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376763));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362205));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131371102));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.a(9.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376754));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837599));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689647));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(getResources().getString(2131689648));
      }
    }
    if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837596));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689665));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.f != null)
    {
      this.f.setLeftIcon(getResources().getDrawable(2130845259));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
      if (localObject == null) {
        break label999;
      }
      this.f.setFirstLineText(((ExtendFriendConfig)localObject).f);
      this.f.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.g.setLeftIcon(getResources().getDrawable(2130845606));
        this.g.a(true);
        this.g.setOnClickListener(this);
        String str = getResources().getString(2131716919);
        localObject = getResources().getString(2131716918);
        str = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
        this.g.setFirstLineText(str);
        this.g.setSecondLineVisible(false);
      }
      if (this.h != null)
      {
        this.h.setLeftIcon(getResources().getDrawable(2130837597));
        this.h.a(true);
        this.h.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.h.setFirstLineText(2131689645);
        this.h.setSecondLineVisible(false);
      }
      if (this.i != null)
      {
        this.i.setLeftIcon(getResources().getDrawable(2130840220));
        this.i.a(true);
        this.i.setOnClickListener(this);
        this.i.setFirstLineText(2131692227);
        this.i.setSecondLineVisible(false);
      }
      return;
      label999:
      this.f.setFirstLineText(2131698742);
      this.f.setSecondLineVisible(false);
    }
  }
  
  private void l()
  {
    j();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent();
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localMayknowRecommendManager != null) {
      localMayknowRecommendManager.a(5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.jdField_a_of_type_Boolean + "shouldShowMayknowEnty=" + this.jdField_b_of_type_Boolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (localMayknowRecommendManager != null) {
      localArrayList = localMayknowRecommendManager.c();
    }
    for (;;)
    {
      if (localArrayList.size() > 0)
      {
        e();
        if (!this.jdField_a_of_type_Boolean) {
          break label278;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter = new RecommendFriendAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener);
        this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.b(21);
        int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297494);
        this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(j);
        this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(localArrayList);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new AddContactsView.5(this));
      }
      for (;;)
      {
        if (StudyModeManager.d()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setVisibility(8);
        }
        return;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
        break;
        label278:
        this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter = new MayKnowAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener, 21, localIntent.getIntExtra("EntranceId", 0));
      }
    }
  }
  
  private void m()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long) }));
    }
    Object localObject1;
    Object localObject2;
    if ((this.jdField_a_of_type_Long <= 0L) || ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)))
    {
      boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
      this.jdField_a_of_type_Long = l;
      if (!bool) {
        break label214;
      }
      l = 1000L;
      this.jdField_b_of_type_Long = l;
      localObject1 = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
      localObject2 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label221;
      }
    }
    for (;;)
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
      return;
      label214:
      l = 2000L;
      break;
      label221:
      localObject1 = localObject2;
    }
  }
  
  private void n()
  {
    Intent localIntent;
    if (!NearbySPUtil.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689557));
      NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, localIntent);
    }
    for (;;)
    {
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689557));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_c_of_type_Boolean));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
  }
  
  private void p()
  {
    int j = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + j);
    }
    Object localObject;
    if ((j == 2) || (j == 4) || (j == 9) || (j == 8))
    {
      localObject = new AddContactsView.7(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidAppActivity, 2);
      PermissionChecker.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Runnable)localObject, localDenyRunnable);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
      if ((j == 1) || (j == 5)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
      }
      return;
      if ((j == 3) || (j == 6) || (j == 7) || (j == 1) || (j == 5) || (j == 0))
      {
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("kSrouce", 14);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  private void q()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366395);
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length > 0))
    {
      int j = 0;
      while (j < this.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        int k = 0;
        if (k < this.jdField_b_of_type_ArrayOfJavaLangString[j].length())
        {
          switch (this.jdField_b_of_type_ArrayOfJavaLangString[j].charAt(k))
          {
          }
          for (;;)
          {
            k += 1;
            break;
            if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.d()))
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, j, k);
              localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.a()))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, j, k);
                localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem);
                continue;
                if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                {
                  this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1006, j, k);
                  localLinearLayout.addView(this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem);
                  continue;
                  if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.a()))
                  {
                    this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1003, j, k);
                    localLinearLayout.addView(this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem);
                    continue;
                    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                    {
                      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1004, j, k);
                      localLinearLayout.addView(this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem);
                      continue;
                      if (this.i == null)
                      {
                        this.i = a(1010, j, k);
                        localLinearLayout.addView(this.i);
                        Face2FaceAddContactUtils.a("0X800AB5C", "", "", "");
                        continue;
                        boolean bool = ExpandFriendChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                        if (QLog.isColorLevel()) {
                          QLog.d("AddContactsView", 2, "createConfigView kuolie showEntry = " + bool);
                        }
                        if ((this.f == null) && (!StudyModeManager.a()) && (bool))
                        {
                          this.f = a(1007, j, k);
                          localLinearLayout.addView(this.f);
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
                          continue;
                          if (this.g == null)
                          {
                            this.g = a(1008, j, k);
                            localLinearLayout.addView(this.g);
                            continue;
                            if ((this.h == null) && (!StudyModeManager.a()))
                            {
                              this.h = a(1009, j, k, true);
                              localLinearLayout.addView(this.h);
                              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        j += 1;
      }
    }
  }
  
  private void r()
  {
    Object localObject1 = "13275";
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    String str = SharedPreUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2 = localObject1;
    if (str != null) {
      if (!str.isEmpty()) {
        break label321;
      }
    }
    label184:
    label321:
    for (localObject2 = localObject1;; localObject2 = str)
    {
      int j = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
      localObject1 = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (j == 1)
      {
        localObject1 = localObject2;
        if (!((String)localObject2).contains("7")) {
          localObject1 = "7" + (String)localObject2;
        }
        this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0);
        if (this.jdField_a_of_type_Int != 1) {
          break label293;
        }
        localObject2 = localObject1;
        if (!((String)localObject1).contains("8")) {
          localObject2 = "8" + (String)localObject1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "AddContactsViewConfig fetches successfully，content=" + (String)localObject2);
        }
        localObject1 = localObject2;
        if (((String)localObject2).contains("9"))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label307;
          }
          localObject1 = localObject2;
          if (((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a() > 0) {}
        }
      }
      for (localObject1 = ((String)localObject2).replace("9", "");; localObject1 = ((String)localObject2).replace("9", ""))
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split("\\|");
        return;
        localObject1 = ((String)localObject2).replace("7", "");
        break;
        localObject2 = ((String)localObject1).replace("8", "");
        break label184;
      }
    }
  }
  
  private void s()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.12(this));
  }
  
  private void t()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.i != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow == null))
    {
      this.i.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.i.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298179);
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131558468);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    i();
    r();
    q();
    k();
    l();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000000) && (QLog.isColorLevel())) {
      QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 14);
    }
  }
  
  public void b()
  {
    super.b();
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.a();
    }
    if (this.h != null) {
      s();
    }
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("entrence_data_report", 0);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", j, 0, "", "", "", "");
    if (j != 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Int == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    SearchUtils.a("add_page", "search_people", "exp", 0, 0, new String[] { "" });
    if (this.i != null)
    {
      this.jdField_e_of_type_Boolean = Face2FaceAddContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      t();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.c();
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView != null) && (this.jdField_a_of_type_ComTencentWidgetSwipListView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.hideCurShowingRightView();
    }
    b(false);
  }
  
  public void d()
  {
    super.d();
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "updateMayknowRecommendListStyle,addPageDisplayAsVerticalListItem = " + this.jdField_a_of_type_Boolean + " shouldShowMayknowEnty=" + this.jdField_b_of_type_Boolean);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      continue;
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  void f()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("fillSearchConditions | autoReqLocation = ").append(this.jdField_c_of_type_Boolean).append(" | code one = ");
      if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length != 4)) {
        break label94;
      }
    }
    label94:
    for (Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString[0];; localObject = Integer.valueOf(-1000))
    {
      QLog.d("AddContactsView", 2, localObject);
      ThreadManager.postImmediately(new AddContactsView.10(this, new StringBuilder(jdField_a_of_type_JavaLangString)), null, true);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick id=" + paramView.getId());
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      SearchUtils.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      continue;
      o();
      continue;
      p();
      continue;
      n();
      continue;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateFaceToFaceDiscussionActivity.class);
      localIntent.putExtra("create_source", 7);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
      continue;
      ExtendFriendLabelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
      ExpandReportUtils.b("1");
      continue;
      m();
      continue;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent().getIntExtra("EntranceId", 0);
      switch (j)
      {
      }
      for (;;)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
        localIntent.putExtra("EntranceId", j);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        break;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
      localIntent.putExtra("from", "AddContactsActivity");
      localIntent.setFlags(67108864);
      localIntent.putExtra("QRDecode", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent();
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, ConnectionsExplorationFragment.class);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
      continue;
      b(true);
      Face2FaceAddContactFragment.a(this.jdField_a_of_type_AndroidAppActivity, new Intent());
      Face2FaceAddContactUtils.a("0X800AB5E", "", "", "");
    }
  }
  
  public void setListViewHeightBasedOnChildren(ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "setListViewHeightBasedOnChildren");
    }
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return;
    }
    int j = 0;
    int k = 0;
    while (j < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(j, null, paramListView);
      ((View)localObject).measure(0, 0);
      k += ((View)localObject).getMeasuredHeight();
      j += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + k + paramListView.getPaddingTop() + paramListView.getPaddingBottom());
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */