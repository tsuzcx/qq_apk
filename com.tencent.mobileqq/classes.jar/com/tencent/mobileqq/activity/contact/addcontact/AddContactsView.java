package com.tencent.mobileqq.activity.contact.addcontact;

import aciy;
import aetn;
import aeto;
import aetp;
import aetq;
import aets;
import aett;
import aetu;
import aetv;
import aeuo;
import aibc;
import aibk;
import aibw;
import ajfw;
import ajga;
import ajgb;
import ajjy;
import ajlf;
import ajlg;
import ajls;
import amnv;
import amvy;
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
import android.widget.RelativeLayout;
import anoe;
import anoh;
import aqeb;
import asfc;
import avwf;
import awqx;
import azwg;
import babp;
import badq;
import baig;
import benm;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
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
  private static final String jdField_a_of_type_JavaLangString = ajjy.a(2131634032);
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private aibc jdField_a_of_type_Aibc;
  aibk jdField_a_of_type_Aibk = new aetp(this);
  aibw jdField_a_of_type_Aibw;
  public ajfw a;
  ajga jdField_a_of_type_Ajga = new aetu(this);
  ajgb jdField_a_of_type_Ajgb = new aetv(this);
  ajlg jdField_a_of_type_Ajlg = new aeto(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aetn(this);
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private azwg jdField_a_of_type_Azwg;
  benm jdField_a_of_type_Benm = new aett(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  public HorizontalListView a;
  public SwipListView a;
  boolean jdField_a_of_type_Boolean;
  public String[] a;
  private long jdField_b_of_type_Long;
  aibk jdField_b_of_type_Aibk = new aetq(this);
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
  
  public AddContactsView(aeuo paramaeuo)
  {
    super(paramaeuo);
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
      ((FormMutiItem)localObject).setFirstLineTextColor(getResources().getColor(2131101267));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, aciy.a(56.0F, getResources()));
      if (paramInt3 == 0) {
        localLayoutParams.topMargin = ((int)(12.0F * babp.a()));
      }
      ((FormMutiItem)localObject).setLayoutParams(localLayoutParams);
      ((FormMutiItem)localObject).setBackgroundResource(2130839099);
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
  
  private void i()
  {
    ajls localajls = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    this.jdField_a_of_type_Boolean = localajls.b("sp_mayknow_addpage_s_a_vl");
    this.jdField_b_of_type_Boolean = localajls.b("sp_mayknow_entry_list_add");
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_Ajfw.a();
    String[] arrayOfString = this.jdField_a_of_type_Ajfw.b();
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initSearchConditions|autoReqLocation = " + this.jdField_c_of_type_Boolean + ", locCode[0] = " + arrayOfString[0]);
    }
    if ((this.jdField_c_of_type_Boolean) || ("0".equals(arrayOfString[0])))
    {
      if ((amvy.a()) || (!badq.d(this.jdField_a_of_type_AndroidAppActivity))) {
        break label175;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : yes");
      }
      this.jdField_a_of_type_Aeuo.a().addObserver(this.jdField_a_of_type_Ajlg);
      ((ajlf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3)).b();
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajga);
        this.jdField_a_of_type_Ajfw.a(this.jdField_a_of_type_Ajgb);
      }
      return;
      label175:
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "-1", "-1", "-1", "-1" };
      if (QLog.isColorLevel()) {
        QLog.d("AddContactsView", 2, "initSearchConditions|getUserCurrentLocation execute : no");
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131300160));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setPadding(getResources().getDimensionPixelSize(2131166922), 0, 0, 0);
    Object localObject = getResources().getDrawable(2130848992);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setContentDescription(ajjy.a(2131634034));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130844068));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(this.jdField_a_of_type_AndroidAppActivity.getString(2131624188));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130843828));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131624184));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(ajjy.a(2131634030));
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130843827));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(ajjy.a(2131634035));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(ajjy.a(2131634031));
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309223));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296570));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131304164));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(aciy.a(9.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Aibc);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131309214));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setFocusable(false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem != null)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130837576));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(getResources().getString(2131624194));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineVisible(false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.a(true);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem.setContentDescription(getResources().getString(2131624195));
      }
    }
    if (this.e != null)
    {
      this.e.setLeftIcon(getResources().getDrawable(2130837573));
      this.e.setFirstLineText(getResources().getString(2131624229));
      this.e.setSecondLineVisible(false);
      this.e.a(true);
      this.e.setOnClickListener(this);
    }
    if (this.f != null)
    {
      this.f.setLeftIcon(getResources().getDrawable(2130844222));
      this.f.a(true);
      this.f.setOnClickListener(this);
      localObject = ((anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if (localObject == null) {
        break label902;
      }
      this.f.setFirstLineText(((anoh)localObject).d);
      this.f.setSecondLineVisible(false);
    }
    for (;;)
    {
      if (this.g != null)
      {
        this.g.setLeftIcon(getResources().getDrawable(2130844398));
        this.g.a(true);
        this.g.setOnClickListener(this);
        String str = getResources().getString(2131651292);
        localObject = getResources().getString(2131651291);
        str = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_firstline", str);
        baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_secondline", (String)localObject);
        this.g.setFirstLineText(str);
        this.g.setSecondLineVisible(false);
      }
      if (this.h != null)
      {
        this.h.setLeftIcon(getResources().getDrawable(2130837574));
        this.h.a(true);
        this.h.setOnClickListener(this);
        this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.h.setFirstLineText(2131624190);
        this.h.setSecondLineVisible(false);
      }
      return;
      label902:
      this.f.setFirstLineText(2131633204);
      this.f.setSecondLineVisible(false);
    }
  }
  
  private void l()
  {
    j();
    Intent localIntent = this.jdField_a_of_type_Aeuo.a().getIntent();
    ajls localajls = (ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    if (localajls != null) {
      localajls.a(5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "initData  addPageDisplayAsVerticalListItem = " + this.jdField_a_of_type_Boolean + "shouldShowMayknowEnty=" + this.jdField_b_of_type_Boolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (localajls != null) {
      localArrayList = localajls.c();
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        e();
      }
      while (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Aibw = new aibw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, localIntent.getIntExtra("EntranceId", 0), this.jdField_b_of_type_Aibk);
        this.jdField_a_of_type_Aibw.b(21);
        int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131166195);
        this.jdField_a_of_type_Aibw.a(i);
        this.jdField_a_of_type_Aibw.a(localArrayList);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this.jdField_a_of_type_Benm);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.getViewTreeObserver().addOnGlobalLayoutListener(new aets(this));
        return;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      }
      this.jdField_a_of_type_Aibc = new aibc(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_Aibk, 21, localIntent.getIntExtra("EntranceId", 0));
      return;
    }
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296585);
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    if ((this.jdField_b_of_type_ArrayOfJavaLangString != null) && (this.jdField_b_of_type_ArrayOfJavaLangString.length > 0))
    {
      localObject1 = null;
      i = 0;
      if (i < this.jdField_b_of_type_ArrayOfJavaLangString.length)
      {
        j = 0;
        if (j < this.jdField_b_of_type_ArrayOfJavaLangString[i].length())
        {
          localObject2 = localObject1;
          switch (this.jdField_b_of_type_ArrayOfJavaLangString[i].charAt(j))
          {
          default: 
            localObject2 = localObject1;
          case '6': 
          case '1': 
          case '5': 
          case '2': 
          case '4': 
          case '3': 
          case '7': 
            label123:
            do
            {
              for (;;)
              {
                j += 1;
                localObject1 = localObject2;
                break;
                localObject2 = localObject1;
                if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem == null)
                {
                  this.jdField_b_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1001, i, j);
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
                    this.jdField_d_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1004, i, j);
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
                      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1002, i, j);
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
                        this.jdField_c_of_type_ComTencentMobileqqWidgetFormMutiItem = a(1003, i, j);
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
                          this.e = a(1006, i, j);
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
              localObject2 = localObject1;
            } while (this.f != null);
            this.f = a(1007, i, j);
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C4", "0X80092C4", 0, 0, "", "", "", "");
      localObject2 = localObject1;
      break label123;
      localObject2 = localObject1;
      if (this.g != null) {
        break label123;
      }
      this.g = a(1008, i, j);
      if (this.g != null) {
        localLinearLayout.addView(this.g, localLinearLayout.getChildCount() - 4);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.g;
      }
      localObject1 = this.g;
      break label123;
      localObject2 = localObject1;
      if (this.h != null) {
        break label123;
      }
      this.h = a(1009, i, j, true);
      if (this.h != null) {
        localLinearLayout.addView(this.h, localLinearLayout.getChildCount() - 4);
      }
      if (localObject1 == null) {
        localObject1 = this.h;
      }
      for (;;)
      {
        localObject2 = this.h;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_exp", 0, 0, "", "", "", "");
        localObject2 = localObject1;
        break label123;
        i += 1;
        break;
        return;
      }
    }
  }
  
  private void n()
  {
    String str = "13524";
    Object localObject1 = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785");
    Object localObject2 = baig.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
      localObject2 = "13524";
    }
    for (;;)
    {
      int i = ((SharedPreferences)localObject1).getInt("sp_extend_friend_entry_add_friend", 0);
      anoe localanoe = (anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
      localObject1 = localObject2;
      if (i == 1)
      {
        localObject1 = localObject2;
        if (localanoe.b())
        {
          localObject2 = "7" + (String)localObject2;
          localObject1 = localObject2;
          if (((String)localObject2).indexOf("4") != -1) {
            localObject1 = ((String)localObject2).replace("4", "");
          }
        }
      }
      this.jdField_a_of_type_Int = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("invitation_friend_entry", 0);
      localObject2 = str;
      if (this.jdField_a_of_type_Int == 1) {
        localObject2 = "8" + (String)localObject1;
      }
      if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "AddContactsViewConfig fetches successfully，content=" + (String)localObject1);
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains("6"))
        {
          QLog.d("AddContactsView", 1, "行家已经下架，不应该出现。 content=" + (String)localObject1);
          localObject2 = ((String)localObject1).replace("6", "");
        }
        localObject1 = localObject2;
        if (((String)localObject2).contains("9"))
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label351;
          }
          localObject1 = localObject2;
          if (((ajls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a() > 0) {}
        }
        label351:
        for (localObject1 = ((String)localObject2).replace("9", "");; localObject1 = ((String)localObject2).replace("9", ""))
        {
          this.jdField_b_of_type_ArrayOfJavaLangString = ((String)localObject1).split("\\|");
          return;
        }
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { localObject2 };
      return;
    }
  }
  
  private void o()
  {
    ThreadManager.getSubThreadHandler().post(new AddContactsView.11(this));
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131166837);
  }
  
  protected void a()
  {
    super.a();
    super.a(2131492922);
    this.jdField_a_of_type_Ajfw = ((ajfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59));
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
    this.jdField_a_of_type_Ajfw.a(this);
    if (this.jdField_a_of_type_Aibw != null) {
      this.jdField_a_of_type_Aibw.b();
    }
    if (this.jdField_a_of_type_Aibc != null) {
      this.jdField_a_of_type_Aibc.a();
    }
    if (this.h != null) {
      o();
    }
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("entrence_data_report", 0);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", i, 0, "", "", "", "");
    if (i != 0) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800760D", "0X800760D", 0, 0, "", "", "", "");
    }
    if (this.jdField_a_of_type_Int == 1) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F6", "0X80096F6", 0, 0, "", "", "", "");
    }
    avwf.a("add_page", "search_people", "exp", 0, 0, new String[] { "" });
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Aibc != null)
    {
      this.jdField_a_of_type_Aibc.c();
      this.jdField_a_of_type_Aibc.b();
    }
    if (this.jdField_a_of_type_Aibw != null) {
      this.jdField_a_of_type_Aibw.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetSwipListView != null) && (this.jdField_a_of_type_ComTencentWidgetSwipListView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.t();
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Ajfw.b(this);
    this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajga);
    this.jdField_a_of_type_Ajfw.a(null);
    this.jdField_a_of_type_Aeuo.a().removeObserver(this.jdField_a_of_type_Ajlg);
    if (this.jdField_a_of_type_Aibc != null) {
      this.jdField_a_of_type_Aibc.d();
    }
    if (this.jdField_a_of_type_Aibw != null) {
      this.jdField_a_of_type_Aibw.c();
    }
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
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
    int i;
    Object localObject;
    long l;
    switch (paramView.getId())
    {
    default: 
    case 2131300160: 
    case 1002: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1007: 
    case 1008: 
      do
      {
        return;
        this.jdField_a_of_type_Aeuo.a();
        avwf.a("add_page", "search", "active_frame", 1, 0, new String[] { "" });
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 1, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setRightIcon(null);
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(new Intent(this.jdField_a_of_type_AndroidAppActivity, ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", this.jdField_c_of_type_Boolean));
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
        return;
        i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).d();
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + i);
        }
        if ((i == 2) || (i == 4) || (i == 9) || (i == 8))
        {
          paramView = new AddContactsView.6(this);
          localObject = new DenyRunnable(this.jdField_a_of_type_AndroidAppActivity, 2);
          amnv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (Runnable)localObject);
        }
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
          if ((i != 1) && (i != 5)) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
          return;
          if ((i == 3) || (i == 6) || (i == 7) || (i == 1) || (i == 5) || (i == 0))
          {
            paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, PhoneMatchActivity.class);
            paramView.putExtra("kSrouce", 14);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
          }
        }
        if (!asfc.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyActivity.class);
          paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
          paramView.putExtra("FROM_WHERE", 1004);
          paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131624088));
          NearbyFakeActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
        }
        for (;;)
        {
          awqx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
          return;
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, NearbyGuideActivity.class);
          paramView.putExtra("FROM_WHERE", 1004);
          paramView.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getResources().getText(2131624088));
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, CreateFaceToFaceDiscussionActivity.class);
        paramView.putExtra("create_source", 7);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
        return;
        ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeuo.a());
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C5", "0X80092C5", 0, 0, "", "", "", "");
        return;
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("AddContactsView", 2, String.format("onClick invite lastTs=%d lastBlank=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long) }));
        }
      } while ((this.jdField_a_of_type_Long > 0L) && ((this.jdField_a_of_type_Long <= 0L) || (l - this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long)));
      boolean bool = aqeb.a("com.tencent.mobileqq:tool");
      this.jdField_a_of_type_Long = l;
      if (bool)
      {
        l = 1000L;
        this.jdField_b_of_type_Long = l;
        paramView = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
        localObject = baig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "register_invitation_sp_entry", "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label1399;
        }
      }
      break;
    }
    for (;;)
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
      return;
      l = 2000L;
      break;
      i = this.jdField_a_of_type_Aeuo.a().getIntent().getIntExtra("EntranceId", 0);
      switch (i)
      {
      }
      for (;;)
      {
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
        paramView.putExtra("EntranceId", i);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        return;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006747", "0X8006747", 0, 0, "", "", "", "");
        continue;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006770", "0X8006770", 0, 0, "", "", "", "");
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
      paramView.putExtra("from", "AddContactsActivity");
      paramView.setFlags(67108864);
      paramView.putExtra("QRDecode", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
      return;
      paramView = new Intent();
      PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView, ConnectionsExplorationFragment.class);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "renmai_entry_clk", 0, 0, "", "", "", "");
      return;
      label1399:
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
    int i = 0;
    int j = 0;
    while (i < localListAdapter.getCount())
    {
      localObject = localListAdapter.getView(i, null, paramListView);
      ((View)localObject).measure(0, 0);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    Object localObject = paramListView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (paramListView.getDividerHeight() * (localListAdapter.getCount() - 1) + j + paramListView.getPaddingTop() + paramListView.getPaddingBottom());
    paramListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView
 * JD-Core Version:    0.7.0.1
 */