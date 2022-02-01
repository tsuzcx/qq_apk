package com.tencent.mobileqq.activity.contact.addcontact;

import aisd;
import aise;
import aisf;
import aisg;
import aish;
import aisj;
import aisk;
import aisl;
import aism;
import aitf;
import aive;
import ajcr;
import amia;
import amii;
import amiw;
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
import anrz;
import ansd;
import anse;
import anvx;
import anxi;
import anxj;
import anyb;
import arxx;
import aslo;
import aslx;
import asrt;
import avli;
import axqc;
import bcnc;
import bdla;
import bdvn;
import bhhr;
import blfe;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = anvx.a(2131699331);
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private amia jdField_a_of_type_Amia;
  amii jdField_a_of_type_Amii = new aisg(this);
  amiw jdField_a_of_type_Amiw;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aisd(this);
  public PopupWindow a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public anrz a;
  ansd jdField_a_of_type_Ansd = new aisl(this);
  anse jdField_a_of_type_Anse = new aism(this);
  anxj jdField_a_of_type_Anxj = new aise(this);
  blfe jdField_a_of_type_Blfe = new aisk(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  public HorizontalListView a;
  public SwipListView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AddContactsView.13(this);
  boolean jdField_a_of_type_Boolean;
  public String[] a;
  private long jdField_b_of_type_Long;
  amii jdField_b_of_type_Amii = new aish(this);
  public RelativeLayout b;
  FormMutiItem jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_b_of_type_Boolean;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  FormMutiItem c;
  public boolean c;
  FormMutiItem d;
  public boolean d;
  FormMutiItem jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem;
  private boolean jdField_e_of_type_Boolean;
  FormMutiItem f;
  FormMutiItem g;
  FormMutiItem h;
  public FormMutiItem i;
  
  public AddContactsView(aitf paramaitf)
  {
    super(paramaitf);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
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
      ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131167033));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(56.0F, getResources()));
      if (paramInt3 == 0) {
        localLayoutParams.topMargin = ((int)(12.0F * DeviceInfoUtil.getDesity()));
      }
      ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
      ((FormMutiItem)localObject).setBackgroundResource(2130839453);
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
          aive.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    anyb localanyb = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    this.jdField_a_of_type_Boolean = localanyb.b("sp_mayknow_addpage_s_a_vl");
    if ((localanyb.b("sp_mayknow_entry_list_add")) && (!bdvn.a())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Anrz.a();
    String[] arrayOfString = this.jdField_a_of_type_Anrz.b();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.jdField_c_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_c_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((arxx.a()) || (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))) {
        break label178;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_Aitf.a().addObserver(this.jdField_a_of_type_Anxj);
      ((anxi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Anrz.c(this.jdField_a_of_type_Ansd);
        this.jdField_a_of_type_Anrz.a(this.jdField_a_of_type_Anse);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131362158));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new aisf(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131366272));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131298199), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130850363);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(anvx.a(2131699333));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844928));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689636));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844672));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689634));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(anvx.a(2131699329));
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844671));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(anvx.a(2131699334));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(anvx.a(2131699330));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376368));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362185));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131370820));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.dp2px(9.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Amia);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131376359));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837599));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689640));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(getResources().getString(2131689641));
      }
    }
    if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837596));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689658));
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.f != null)
    {
      this.f.setLeftIcon(getResources().getDrawable(2130845097));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
      if (localObject == null) {
        break label989;
      }
      this.f.setFirstLineText(((aslx)localObject).d);
      this.f.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.g.setLeftIcon(getResources().getDrawable(2130845291));
        this.g.a(true);
        this.g.setOnClickListener(this);
        String str = getResources().getString(2131716426);
        localObject = getResources().getString(2131716425);
        str = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
        bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
        this.g.setFirstLineText(str);
        this.g.setSecondLineVisible(false);
      }
      if (this.h != null)
      {
        this.h.setLeftIcon(getResources().getDrawable(2130837597));
        this.h.a(true);
        this.h.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.h.setFirstLineText(2131689638);
        this.h.setSecondLineVisible(false);
      }
      if (this.i != null)
      {
        this.i.setLeftIcon(getResources().getDrawable(2130840129));
        this.i.a(true);
        this.i.setOnClickListener(this);
        this.i.setFirstLineText(2131692095);
        this.i.setSecondLineVisible(false);
      }
      return;
      label989:
      this.f.setFirstLineText(2131698459);
      this.f.setSecondLineVisible(false);
    }
  }
  
  private void l()
  {
    j();
    Intent localIntent = this.jdField_a_of_type_Aitf.a().getIntent();
    anyb localanyb = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (localanyb != null) {
      localanyb.a(5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.jdField_a_of_type_Boolean + "shouldShowMayknowEnty=" + this.jdField_b_of_type_Boolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (localanyb != null) {
      localArrayList = localanyb.c();
    }
    for (;;)
    {
      if (localArrayList.size() > 0)
      {
        e();
        if (!this.jdField_a_of_type_Boolean) {
          break label278;
        }
        this.jdField_a_of_type_Amiw = new amiw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_Amii);
        this.jdField_a_of_type_Amiw.b(21);
        int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297426);
        this.jdField_a_of_type_Amiw.a(j);
        this.jdField_a_of_type_Amiw.a(localArrayList);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Blfe);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new aisj(this));
      }
      for (;;)
      {
        if (bdvn.d()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setVisibility(8);
        }
        return;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
        break;
        label278:
        this.jdField_a_of_type_Amia = new amia(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Amii, 21, localIntent.getIntExtra("EntranceId", 0));
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
      boolean bool = avli.a("com.tencent.mobileqq:tool");
      this.jdField_a_of_type_Long = l;
      if (!bool) {
        break label214;
      }
      l = 1000L;
      this.jdField_b_of_type_Long = l;
      localObject1 = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
      localObject2 = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label221;
      }
    }
    for (;;)
    {
      localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
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
    if (!axqc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
      localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689550));
      NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, localIntent);
    }
    for (;;)
    {
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
      localIntent.putExtra("FROM_WHERE", 1004);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689550));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_c_of_type_Boolean));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
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
      ajcr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Runnable)localObject, localDenyRunnable);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
      if ((j == 1) || (j == 5)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
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
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131366224);
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
            if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!bdvn.d()))
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, j, k);
              localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem);
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!bdvn.a()))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, j, k);
                localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem);
                continue;
                if (this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                {
                  this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1006, j, k);
                  localLinearLayout.addView(this.jdField_e_of_type_ComTencentMobileqqWidgetFormMutiItem);
                  continue;
                  if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem == null) && (!bdvn.a()))
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
                        aive.a("0X800AB5C", "", "", "");
                        continue;
                        boolean bool = asrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                        if (QLog.isColorLevel()) {
                          QLog.d("AddContactsView", 2, "createConfigView kuolie showEntry = " + bool);
                        }
                        if ((this.f == null) && (!bdvn.a()) && (bool))
                        {
                          this.f = a(1007, j, k);
                          localLinearLayout.addView(this.f);
                          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
                          continue;
                          if (this.g == null)
                          {
                            this.g = a(1008, j, k);
                            localLinearLayout.addView(this.g);
                            continue;
                            if ((this.h == null) && (!bdvn.a()))
                            {
                              this.h = a(1009, j, k, true);
                              localLinearLayout.addView(this.h);
                              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
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
    SharedPreferences localSharedPreferences = bhhr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    String str = bhhr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2 = localObject1;
    if (str != null) {
      if (!str.isEmpty()) {
        break label328;
      }
    }
    label191:
    label328:
    for (localObject2 = localObject1;; localObject2 = str)
    {
      int j = localSharedPreferences.getInt("sp_extend_friend_entry_add_friend", 0);
      localObject1 = (aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if ((j == 1) && (((aslo)localObject1).d()))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).contains("7")) {
          localObject1 = "7" + (String)localObject2;
        }
        this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0);
        if (this.jdField_a_of_type_Int != 1) {
          break label300;
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
            break label314;
          }
          localObject1 = localObject2;
          if (((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a() > 0) {}
        }
      }
      for (localObject1 = ((String)localObject2).replace("9", "");; localObject1 = ((String)localObject2).replace("9", ""))
      {
        this.jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split("\\|");
        return;
        localObject1 = ((String)localObject2).replace("7", "");
        break;
        localObject2 = ((String)localObject1).replace("8", "");
        break label191;
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
    return getResources().getDimensionPixelSize(2131298099);
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131558467);
    this.jdField_a_of_type_Anrz = ((anrz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
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
    this.jdField_a_of_type_Anrz.a(this);
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.b();
    }
    if (this.jdField_a_of_type_Amia != null) {
      this.jdField_a_of_type_Amia.a();
    }
    if (this.h != null) {
      s();
    }
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("entrence_data_report", 0);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", j, 0, "", "", "", "");
    if (j != 0) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Int == 1) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    bcnc.a("add_page", "search_people", "exp", 0, 0, new String[] { "" });
    if (this.i != null)
    {
      this.jdField_e_of_type_Boolean = aive.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      t();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amia != null)
    {
      this.jdField_a_of_type_Amia.c();
      this.jdField_a_of_type_Amia.b();
    }
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView != null) && (this.jdField_a_of_type_ComTencentWidgetSwipListView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    }
    b(false);
  }
  
  public void d()
  {
    super.d();
    b(false);
    this.jdField_a_of_type_Anrz.b(this);
    this.jdField_a_of_type_Anrz.d(this.jdField_a_of_type_Ansd);
    this.jdField_a_of_type_Anrz.a(null);
    this.jdField_a_of_type_Aitf.a().removeObserver(this.jdField_a_of_type_Anxj);
    if (this.jdField_a_of_type_Amia != null) {
      this.jdField_a_of_type_Amia.d();
    }
    if (this.jdField_a_of_type_Amiw != null) {
      this.jdField_a_of_type_Amiw.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
  }
  
  public void e()
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
  
  public void f()
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
      this.jdField_a_of_type_Aitf.a();
      bcnc.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
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
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
      continue;
      ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_Aitf.a(), 1);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
      continue;
      m();
      continue;
      int j = this.jdField_a_of_type_Aitf.a().getIntent().getIntExtra("EntranceId", 0);
      switch (j)
      {
      }
      for (;;)
      {
        localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
        localIntent.putExtra("EntranceId", j);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
        break;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
      localIntent.putExtra("from", "AddContactsActivity");
      localIntent.setFlags(67108864);
      localIntent.putExtra("QRDecode", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
      continue;
      localIntent = new Intent();
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, ConnectionsExplorationFragment.class);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
      continue;
      b(true);
      Face2FaceAddContactFragment.a(this.jdField_a_of_type_AndroidAppActivity, new Intent());
      aive.a("0X800AB5E", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */