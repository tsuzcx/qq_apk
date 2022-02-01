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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactUtils;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
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
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
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
import java.util.List;
import mqq.os.MqqHandler;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700050);
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
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AddContactsView.13(this);
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
    Object localObject;
    if (paramBoolean) {
      localObject = new FormMutiWithAvatarItem(this.jdField_a_of_type_AndroidAppActivity);
    } else {
      localObject = new FormMutiItem(this.jdField_a_of_type_AndroidAppActivity);
    }
    ((FormMutiItem)localObject).setId(paramInt1);
    ((FormMutiItem)localObject).setClickable(true);
    ((FormMutiItem)localObject).setFocusable(true);
    ((FormMutiItem)localObject).setBgType(3);
    ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131167063));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.b(56.0F, getResources()));
    if (paramInt3 == 0) {
      localLayoutParams.topMargin = ((int)(DeviceInfoUtil.a() * 12.0F));
    }
    ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
    ((FormMutiItem)localObject).setBackgroundResource(2130839388);
    return localObject;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      localObject = localViewGroup;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideFace2FaceAddFriendGuideTips, save=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" isShowing:");
      PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      boolean bool;
      if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null)
    {
      if ((((PopupWindow)localObject).isShowing()) && (paramBoolean))
      {
        this.jdField_e_of_type_Boolean = false;
        Face2FaceAddContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    localObject = this.i;
    if (localObject != null) {
      ((FormMutiItem)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void i()
  {
    MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.jdField_a_of_type_Boolean = localMayknowRecommendManager.b("sp_mayknow_addpage_s_a_vl");
    boolean bool;
    if ((localMayknowRecommendManager.b("sp_mayknow_entry_list_add")) && (!StudyModeManager.a())) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initSearchConditions|autoReqLocation = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(", locCode[0] = ");
      localStringBuilder.append(arrayOfString[0]);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
    if ((this.jdField_c_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((!DatingUtil.a()) && (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
        ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
      }
      else
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
        }
      }
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener);
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131362204));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new AddContactsView.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131366324));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131298274), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130850689);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(HardCodeUtil.a(2131700052));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130844965));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689675));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130844709));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689673));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(HardCodeUtil.a(2131700048));
      }
    }
    localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130844708));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(HardCodeUtil.a(2131700053));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(HardCodeUtil.a(2131700049));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376260));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362230));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131370726));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.b(9.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376252));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    localObject = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837687));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689679));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(getResources().getString(2131689680));
      }
    }
    localObject = this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837684));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689697));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130845151));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
      if (localObject != null)
      {
        this.f.setFirstLineText(((ExpandConfig)localObject).addEntranceTitle);
        QLog.d("AddContactsViewqqexpand", 1, ((ExpandConfig)localObject).addEntranceTitle);
        this.f.setSecondLineVisible(false);
      }
      else
      {
        this.f.setFirstLineText(2131698817);
        this.f.setSecondLineVisible(false);
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130845479));
      this.g.a(true);
      this.g.setOnClickListener(this);
      String str = getResources().getString(2131716572);
      localObject = getResources().getString(2131716571);
      str = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
      this.g.setFirstLineText(str);
      this.g.setSecondLineVisible(false);
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130837685));
      this.h.a(true);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.h.setFirstLineText(2131689677);
      this.h.setSecondLineVisible(false);
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((FormMutiItem)localObject).setLeftIcon(getResources().getDrawable(2130840079));
      this.i.a(true);
      this.i.setOnClickListener(this);
      this.i.setFirstLineText(2131692153);
      this.i.setSecondLineVisible(false);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData  addPageDisplayAsVerticalListItem = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("shouldShowMayknowEnty=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    if (localMayknowRecommendManager != null) {
      localObject = localMayknowRecommendManager.c();
    }
    if (((ArrayList)localObject).size() > 0)
    {
      e();
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter = new RecommendFriendAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener);
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.b(21);
      int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297483);
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a(j);
      this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter.a((List)localObject);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_ComTencentWidgetSwipListView$RightIconMenuListener);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new AddContactsView.5(this));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter = new MayKnowAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener, 21, localIntent.getIntExtra("EntranceId", 0));
    }
    if (StudyModeManager.d()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setVisibility(8);
    }
  }
  
  private void m()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long) }));
    }
    long l2 = this.jdField_a_of_type_Long;
    if ((l2 <= 0L) || ((l2 > 0L) && (l1 - l2 > this.jdField_b_of_type_Long)))
    {
      boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
      this.jdField_a_of_type_Long = l1;
      if (bool) {
        l1 = 1000L;
      } else {
        l1 = 2000L;
      }
      this.jdField_b_of_type_Long = l1;
      Object localObject1 = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
      Object localObject2 = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localObject2;
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
    }
  }
  
  private void n()
  {
    Intent localIntent;
    if (!((INearbySPUtil)QRoute.api(INearbySPUtil.class)).isNeedNearbyShowGuide(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      localIntent = new Intent();
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689589));
      NearbyFakeActivityUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent);
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689589));
      RouteUtils.a(getContext(), localIntent, "/nearby/guide");
    }
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    FormMutiItem localFormMutiItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
    if (localFormMutiItem != null) {
      localFormMutiItem.setRightIcon(null);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_c_of_type_Boolean));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
  }
  
  private void p()
  {
    Object localObject1 = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class);
    int j = ((IPhoneContactService)localObject1).getSelfBindState();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick ADD_PHONE_CONTACTS_ID selfBindState=");
      ((StringBuilder)localObject2).append(j);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject2).toString());
    }
    if ((j != 2) && (j != 4) && (j != 9) && (j != 8))
    {
      if ((j == 3) || (j == 6) || (j == 7) || (j == 1) || (j == 5) || (j == 0))
      {
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneMatchActivity.class);
        ((Intent)localObject1).putExtra("kSrouce", 14);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
      }
    }
    else
    {
      localObject1 = new AddContactsView.7(this, (IPhoneContactService)localObject1);
      localObject2 = new DenyRunnable(this.jdField_a_of_type_AndroidAppActivity, 2);
      PermissionChecker.a(this.jdField_a_of_type_AndroidAppActivity, (Runnable)localObject1, (Runnable)localObject2);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
    if ((j == 1) || (j == 5)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
    }
  }
  
  private void q()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366277);
    Object localObject = this.jdField_b_of_type_ArrayOfJavaLangString;
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = 0;
      while (j < this.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        int k = 0;
        while (k < this.jdField_b_of_type_ArrayOfJavaLangString[j].length())
        {
          switch (this.jdField_b_of_type_ArrayOfJavaLangString[j].charAt(k))
          {
          default: 
            break;
          case '9': 
            if ((this.h == null) && (!StudyModeManager.a()))
            {
              this.h = a(1009, j, k, true);
              localLinearLayout.addView(this.h);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
            }
            break;
          case '8': 
            if (this.g == null)
            {
              this.g = a(1008, j, k);
              localLinearLayout.addView(this.g);
            }
            break;
          case '7': 
            boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).needShowLimitChatOnPlus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("createConfigView kuolie showEntry = ");
              ((StringBuilder)localObject).append(bool);
              QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
            }
            if ((this.f == null) && (!StudyModeManager.a()) && (bool))
            {
              this.f = a(1007, j, k);
              localLinearLayout.addView(this.f);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
            }
            break;
          case '6': 
            if (this.i == null)
            {
              this.i = a(1010, j, k);
              localLinearLayout.addView(this.i);
              Face2FaceAddContactUtils.a("0X800AB5C", "", "", "");
            }
            break;
          case '5': 
            if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
            {
              this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1004, j, k);
              localLinearLayout.addView(this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem);
            }
            break;
          case '4': 
            if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.a()))
            {
              this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1003, j, k);
              localLinearLayout.addView(this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem);
            }
            break;
          case '3': 
            if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
            {
              this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1006, j, k);
              localLinearLayout.addView(this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem);
            }
            break;
          case '2': 
            if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.a()))
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, j, k);
              localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem);
            }
            break;
          case '1': 
            if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!StudyModeManager.d()))
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, j, k);
              localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem);
            }
            break;
          }
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private void r()
  {
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    Object localObject1 = SharedPreUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).isEmpty()) {}
    }
    else
    {
      localObject2 = "13275";
    }
    int j = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
    localObject1 = (IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (j == 1)
    {
      localObject1 = localObject2;
      if (!((String)localObject2).contains("7"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("7");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = ((String)localObject2).replace("7", "");
    }
    this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0);
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("8"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("8");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    else
    {
      localObject2 = ((String)localObject1).replace("8", "");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AddContactsViewConfig fetches successfully，content=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (((String)localObject2).contains("9")) {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = localObject2;
        if (((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a() <= 0) {
          localObject1 = ((String)localObject2).replace("9", "");
        }
      }
      else
      {
        localObject1 = ((String)localObject2).replace("9", "");
      }
    }
    this.jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split("\\|");
  }
  
  private void s()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.12(this));
  }
  
  private void t()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      FormMutiItem localFormMutiItem = this.i;
      if ((localFormMutiItem != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow == null))
      {
        localFormMutiItem.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.i.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      }
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298174);
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131558497);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    i();
    r();
    q();
    k();
    l();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000000) && (QLog.isColorLevel()))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("REQ_CODE_BIND_NUMBER resultCode: ");
      paramIntent.append(paramInt1);
      paramIntent.append(", src: ");
      paramIntent.append(14);
      QLog.i("BindMsgConstant", 2, paramIntent.toString());
    }
  }
  
  public void b()
  {
    super.b();
    f();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
    if (localObject != null) {
      ((MayKnowAdapter)localObject).a();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
    if (localObject != null)
    {
      ((MayKnowAdapter)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter.b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
    if ((localObject != null) && (((SwipListView)localObject).getVisibility() == 0)) {
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter;
    if (localObject != null) {
      ((MayKnowAdapter)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAdapterRecommendFriendAdapter;
    if (localObject != null) {
      ((RecommendFriendAdapter)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMayknowRecommendListStyle,addPageDisplayAsVerticalListItem = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" shouldShowMayknowEnty=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
  }
  
  void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fillSearchConditions | autoReqLocation = ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(" | code one = ");
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((localObject != null) && (localObject.length == 4)) {
        localObject = localObject[0];
      } else {
        localObject = Integer.valueOf(-1000);
      }
      localStringBuilder.append(localObject);
      QLog.d("AddContactsView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new AddContactsView.10(this, new StringBuilder(jdField_a_of_type_JavaLangString)), null, true);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick id=");
      ((StringBuilder)localObject).append(paramView.getId());
      QLog.d("AddContactsView", 2, ((StringBuilder)localObject).toString());
    }
    int j = paramView.getId();
    if (j != 2131362230)
    {
      if (j != 2131366324)
      {
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            break;
          case 1010: 
            b(true);
            Face2FaceAddContactFragment.a(this.jdField_a_of_type_AndroidAppActivity, new Intent());
            Face2FaceAddContactUtils.a("0X800AB5E", "", "", "");
            break;
          case 1009: 
            localObject = new Intent();
            PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, ConnectionsExplorationFragment.class);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
            break;
          case 1008: 
            m();
            break;
          case 1007: 
            ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
            ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("1");
            break;
          case 1006: 
            localObject = new Intent();
            ((Intent)localObject).putExtra("from", "AddContactsActivity");
            ((Intent)localObject).setFlags(67108864);
            ((Intent)localObject).putExtra("fromPicQRDecode", true);
            RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, "/qrscan/scanner");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
          }
          break;
        case 1004: 
          localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateFaceToFaceDiscussionActivity.class);
          ((Intent)localObject).putExtra("create_source", 7);
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
          break;
        case 1003: 
          n();
          break;
        case 1002: 
          o();
          break;
        case 1001: 
          p();
          break;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
        SearchUtils.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
      }
    }
    else
    {
      j = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getIntent().getIntExtra("EntranceId", 0);
      if (j != 3)
      {
        if (j == 4) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
        }
      }
      else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      ((Intent)localObject).putExtra("EntranceId", j);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    ((ViewGroup.LayoutParams)localObject).height = (k + paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + paramListView.getPaddingTop() + paramListView.getPaddingBottom());
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */