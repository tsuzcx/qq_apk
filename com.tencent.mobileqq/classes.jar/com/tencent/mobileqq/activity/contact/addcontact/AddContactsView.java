package com.tencent.mobileqq.activity.contact.addcontact;

import aekt;
import ahbm;
import ahbn;
import ahbo;
import ahbp;
import ahbr;
import ahbs;
import ahbt;
import ahbu;
import ahcn;
import ahfh;
import akfe;
import akfm;
import akfy;
import allj;
import alln;
import allo;
import alpo;
import alqx;
import alqy;
import alro;
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
import aovo;
import apds;
import apwx;
import apxa;
import asot;
import aush;
import ayrd;
import azmj;
import azwu;
import bcws;
import bdcb;
import bdee;
import bdiv;
import bhwu;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.contact.newfriend.connections.ConnectionsExplorationFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormMutiWithAvatarItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AddContactsView
  extends ContactBaseView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = alpo.a(2131700200);
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private akfe jdField_a_of_type_Akfe;
  akfm jdField_a_of_type_Akfm = new ahbo(this);
  akfy jdField_a_of_type_Akfy;
  public allj a;
  alln jdField_a_of_type_Alln = new ahbt(this);
  allo jdField_a_of_type_Allo = new ahbu(this);
  alqy jdField_a_of_type_Alqy = new ahbn(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ahbm(this);
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bcws jdField_a_of_type_Bcws;
  bhwu jdField_a_of_type_Bhwu = new ahbs(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  public HorizontalListView a;
  public SwipListView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AddContactsView.12(this);
  boolean jdField_a_of_type_Boolean;
  public String[] a;
  private long jdField_b_of_type_Long;
  akfm jdField_b_of_type_Akfm = new ahbp(this);
  public RelativeLayout b;
  FormMutiItem jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
  boolean jdField_b_of_type_Boolean;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  FormMutiItem c;
  public boolean c;
  FormMutiItem d;
  public boolean d;
  FormMutiItem e;
  FormMutiItem f;
  FormMutiItem g;
  FormMutiItem h;
  FormMutiItem i;
  
  public AddContactsView(ahcn paramahcn)
  {
    super(paramahcn);
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
      ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131166908));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, aekt.a(56.0F, getResources()));
      if (paramInt3 == 0) {
        localLayoutParams.topMargin = ((int)(12.0F * bdcb.a()));
      }
      ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
      ((FormMutiItem)localObject).setBackgroundResource(2130839211);
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
        break label111;
      }
    }
    label111:
    for (boolean bool = false;; bool = this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())
    {
      QLog.d("AddContactsView", 2, bool);
      if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
      {
        if ((this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (paramBoolean)) {
          ahfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    this.jdField_a_of_type_Boolean = localalro.b("sp_mayknow_addpage_s_a_vl");
    if ((localalro.b("sp_mayknow_entry_list_add")) && (!azwu.a())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Allj.a();
    String[] arrayOfString = this.jdField_a_of_type_Allj.b();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.jdField_c_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_c_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((apds.a()) || (!bdee.d(this.jdField_a_of_type_AndroidAppActivity))) {
        break label176;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_Ahcn.a().addObserver(this.jdField_a_of_type_Alqy);
      ((alqx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).b();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Allj.c(this.jdField_a_of_type_Alln);
        this.jdField_a_of_type_Allj.a(this.jdField_a_of_type_Allo);
      }
      return;
      label176:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131365842));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131298037), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130849667);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(alpo.a(2131700202));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844492));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131689729));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844250));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689725));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(alpo.a(2131700198));
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844249));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(alpo.a(2131700203));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(alpo.a(2131700199));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375439));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362115));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131370105));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(aekt.a(9.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Akfe);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131375430));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837582));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131689735));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(getResources().getString(2131689736));
      }
    }
    if (this.e != null)
    {
      this.e.setLeftIcon(getResources().getDrawable(2130837579));
      this.e.setFirstLineText(getResources().getString(2131689770));
      this.e.setSecondLineVisible(false);
      this.e.a(true);
      this.e.setOnClickListener(this);
    }
    if (this.f != null)
    {
      this.f.setLeftIcon(getResources().getDrawable(2130844653));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((apwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if (localObject == null) {
        break label960;
      }
      this.f.setFirstLineText(((apxa)localObject).d);
      this.f.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.g.setLeftIcon(getResources().getDrawable(2130844843));
        this.g.a(true);
        this.g.setOnClickListener(this);
        String str = getResources().getString(2131717467);
        localObject = getResources().getString(2131717466);
        str = bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
        bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
        this.g.setFirstLineText(str);
        this.g.setSecondLineVisible(false);
      }
      if (this.h != null)
      {
        this.h.setLeftIcon(getResources().getDrawable(2130837580));
        this.h.a(true);
        this.h.setOnClickListener(this);
        this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.h.setFirstLineText(2131689731);
        this.h.setSecondLineVisible(false);
      }
      if (this.i != null)
      {
        this.i.setLeftIcon(getResources().getDrawable(2130839655));
        this.i.a(true);
        this.i.setOnClickListener(this);
        this.i.setFirstLineText(2131692362);
        this.i.setSecondLineVisible(false);
      }
      return;
      label960:
      this.f.setFirstLineText(2131699271);
      this.f.setSecondLineVisible(false);
    }
  }
  
  private void l()
  {
    j();
    Intent localIntent = this.jdField_a_of_type_Ahcn.a().getIntent();
    alro localalro = (alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localalro != null) {
      localalro.a(5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.jdField_a_of_type_Boolean + "shouldShowMayknowEnty=" + this.jdField_b_of_type_Boolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (localalro != null) {
      localArrayList = localalro.c();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        e();
      }
      while (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Akfy = new akfy(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_Akfm);
        this.jdField_a_of_type_Akfy.b(21);
        int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297295);
        this.jdField_a_of_type_Akfy.a(j);
        this.jdField_a_of_type_Akfy.a(localArrayList);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Bhwu);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new ahbr(this));
        return;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      }
      this.jdField_a_of_type_Akfe = new akfe(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Akfm, 21, localIntent.getIntExtra("EntranceId", 0));
      return;
    }
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131362132);
    Object localObject1;
    int j;
    int k;
    Object localObject2;
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length > 0))
    {
      localObject1 = null;
      j = 0;
      if (j < this.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        k = 0;
        if (k < this.jdField_b_of_type_ArrayOfJavaLangString[j].length()) {
          switch (this.jdField_b_of_type_ArrayOfJavaLangString[j].charAt(k))
          {
          default: 
            localObject2 = localObject1;
          case '1': 
          case '5': 
          case '2': 
          case '4': 
          case '3': 
          case '7': 
            label119:
            do
            {
              do
              {
                for (;;)
                {
                  k += 1;
                  localObject1 = localObject2;
                  break;
                  localObject2 = localObject1;
                  if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                  {
                    this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, j, k);
                    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
                      localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 4);
                    }
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
                    }
                    localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem;
                    continue;
                    localObject2 = localObject1;
                    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                    {
                      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1004, j, k);
                      if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
                        localLinearLayout.addView(this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 4);
                      }
                      localObject2 = localObject1;
                      if (localObject1 == null) {
                        localObject2 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
                      }
                      localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem;
                      continue;
                      localObject2 = localObject1;
                      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, j, k);
                        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
                          localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 4);
                        }
                        localObject2 = localObject1;
                        if (localObject1 == null) {
                          localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
                        }
                        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
                        continue;
                        localObject2 = localObject1;
                        if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                        {
                          localObject2 = localObject1;
                          if (!azwu.a())
                          {
                            this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1003, j, k);
                            if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
                              localLinearLayout.addView(this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem, localLinearLayout.getChildCount() - 4);
                            }
                            localObject2 = localObject1;
                            if (localObject1 == null) {
                              localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
                            }
                            localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem;
                            continue;
                            localObject2 = localObject1;
                            if (this.e == null)
                            {
                              this.e = a(1006, j, k);
                              if (this.e != null) {
                                localLinearLayout.addView(this.e, localLinearLayout.getChildCount() - 4);
                              }
                              localObject2 = localObject1;
                              if (localObject1 == null) {
                                localObject2 = this.e;
                              }
                              localObject1 = this.e;
                            }
                          }
                        }
                      }
                    }
                  }
                }
                localObject2 = localObject1;
              } while (this.f != null);
              localObject2 = localObject1;
            } while (azwu.a());
            this.f = a(1007, j, k);
            if (this.f != null) {
              localLinearLayout.addView(this.f, localLinearLayout.getChildCount() - 4);
            }
            if (localObject1 == null) {
              localObject1 = this.f;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = this.f;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
      localObject2 = localObject1;
      break label119;
      localObject2 = localObject1;
      if (this.g != null) {
        break label119;
      }
      this.g = a(1008, j, k);
      if (this.g != null) {
        localLinearLayout.addView(this.g, localLinearLayout.getChildCount() - 4);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.g;
      }
      localObject1 = this.g;
      break label119;
      localObject2 = localObject1;
      if (this.h != null) {
        break label119;
      }
      localObject2 = localObject1;
      if (azwu.a()) {
        break label119;
      }
      this.h = a(1009, j, k, true);
      if (this.h != null) {
        localLinearLayout.addView(this.h, localLinearLayout.getChildCount() - 4);
      }
      if (localObject1 == null) {
        localObject1 = this.h;
      }
      for (;;)
      {
        localObject2 = this.h;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
        localObject2 = localObject1;
        break label119;
        localObject2 = localObject1;
        if (this.i != null) {
          break label119;
        }
        this.i = a(1010, j, k);
        if (this.i != null) {
          localLinearLayout.addView(this.i, localLinearLayout.getChildCount() - 4);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.i;
        }
        localObject1 = this.i;
        ahfh.a("0X800AB5C", "", "", "");
        break label119;
        j += 1;
        break;
        return;
      }
    }
  }
  
  private void n()
  {
    Object localObject1 = "13275";
    SharedPreferences localSharedPreferences = bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    String str = bdiv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      localObject1 = (apwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
      if ((j == 1) && (((apwx)localObject1).c()))
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
          if (((alro)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a() > 0) {}
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
  
  private void o()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.11(this));
  }
  
  private void p()
  {
    boolean bool = ahfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((bool) && (this.i != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow == null))
    {
      this.i.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.i.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "showFace2FaceAddFriendGuideTips, needShow=" + bool);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131297948);
  }
  
  protected void a()
  {
    super.a();
    super.a(2131558460);
    this.jdField_a_of_type_Allj = ((allj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59));
    i();
    n();
    m();
    k();
    l();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000000) && (QLog.isColorLevel())) {
      QLog.i("BindMsgConstant", 2, "REQ_CODE_BIND_NUMBER resultCode: " + paramInt1 + ", src: " + 14);
    }
  }
  
  protected void b()
  {
    super.b();
    f();
    this.jdField_a_of_type_Allj.a(this);
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.b();
    }
    if (this.jdField_a_of_type_Akfe != null) {
      this.jdField_a_of_type_Akfe.a();
    }
    if (this.h != null) {
      o();
    }
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("entrence_data_report", 0);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", j, 0, "", "", "", "");
    if (j != 0) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Int == 1) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    ayrd.a("add_page", "search_people", "exp", 0, 0, new String[] { "" });
    if (this.i != null) {
      p();
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Akfe != null)
    {
      this.jdField_a_of_type_Akfe.c();
      this.jdField_a_of_type_Akfe.b();
    }
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView != null) && (this.jdField_a_of_type_ComTencentWidgetSwipListView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    }
    b(false);
  }
  
  protected void d()
  {
    super.d();
    b(false);
    this.jdField_a_of_type_Allj.b(this);
    this.jdField_a_of_type_Allj.d(this.jdField_a_of_type_Alln);
    this.jdField_a_of_type_Allj.a(null);
    this.jdField_a_of_type_Ahcn.a().removeObserver(this.jdField_a_of_type_Alqy);
    if (this.jdField_a_of_type_Akfe != null) {
      this.jdField_a_of_type_Akfe.d();
    }
    if (this.jdField_a_of_type_Akfy != null) {
      this.jdField_a_of_type_Akfy.c();
    }
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.d();
      this.jdField_a_of_type_Bcws = null;
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
      ThreadManager.postImmediately(new AddContactsView.9(this, new StringBuilder(jdField_a_of_type_JavaLangString)), null, true);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onClick id=" + paramView.getId());
    }
    int j;
    Object localObject;
    long l;
    switch (paramView.getId())
    {
    default: 
    case 2131365842: 
    case 1002: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1007: 
    case 1008: 
      do
      {
        return;
        this.jdField_a_of_type_Ahcn.a();
        ayrd.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_c_of_type_Boolean));
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
        return;
        j = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + j);
        }
        if ((j == 2) || (j == 4) || (j == 9) || (j == 8))
        {
          paramView = new AddContactsView.6(this);
          localObject = new DenyRunnable(this.jdField_a_of_type_AndroidAppActivity, 2);
          aovo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (Runnable)localObject);
        }
        for (;;)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
          if ((j != 1) && (j != 5)) {
            break;
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
          return;
          if ((j == 3) || (j == 6) || (j == 7) || (j == 1) || (j == 5) || (j == 0))
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneMatchActivity.class);
            paramView.putExtra("kSrouce", 14);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
          }
        }
        if (!aush.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
          paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
          paramView.putExtra("FROM_WHERE", 1004);
          paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689628));
          NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
        }
        for (;;)
        {
          azmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
          paramView.putExtra("FROM_WHERE", 1004);
          paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131689628));
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateFaceToFaceDiscussionActivity.class);
        paramView.putExtra("create_source", 7);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
        return;
        ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_Ahcn.a(), 1);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
        return;
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long) }));
        }
      } while ((this.jdField_a_of_type_Long > 0L) && ((this.jdField_a_of_type_Long <= 0L) || (l - this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long)));
      boolean bool = asot.a("com.tencent.mobileqq:tool");
      this.jdField_a_of_type_Long = l;
      if (bool)
      {
        l = 1000L;
        this.jdField_b_of_type_Long = l;
        paramView = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
        localObject = bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label1442;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
      return;
      l = 2000L;
      break;
      j = this.jdField_a_of_type_Ahcn.a().getIntent().getIntExtra("EntranceId", 0);
      switch (j)
      {
      }
      for (;;)
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
        paramView.putExtra("EntranceId", j);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        return;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
      paramView.putExtra("from", "AddContactsActivity");
      paramView.setFlags(67108864);
      paramView.putExtra("QRDecode", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
      return;
      paramView = new Intent();
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView, ConnectionsExplorationFragment.class);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
      return;
      b(true);
      Face2FaceAddContactFragment.a(this.jdField_a_of_type_AndroidAppActivity, new Intent());
      ahfh.a("0X800AB5E", "", "", "");
      return;
      label1442:
      paramView = (View)localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */