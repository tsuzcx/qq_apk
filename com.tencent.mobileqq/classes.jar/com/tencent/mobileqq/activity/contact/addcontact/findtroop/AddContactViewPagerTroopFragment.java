package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class AddContactViewPagerTroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AddContactViewPagerTroopFragment.2(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new AddContactViewPagerTroopFragment.1(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AddContactFindTroopRTLW.onRefreshCallback jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW$onRefreshCallback = new AddContactViewPagerTroopFragment.3(this);
  AddContactFindTroopRTLW jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW;
  protected XListView a;
  public String a;
  TextView b;
  public String b;
  TextView c;
  public String c;
  private boolean d;
  
  public AddContactViewPagerTroopFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    Object localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115412_lWT3DV2SAk.png", null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
      ((URLDrawable)localObject).restartDownload();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689663);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131707192);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689662);
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setBackgroundResource(2130839393);
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "getView");
    }
    paramBundle = this.jdField_a_of_type_AndroidViewView;
    if (paramBundle == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559843, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378772));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368582));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378642));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378643));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378644));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376261));
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131362206);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167333);
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setScrollBarStyle(33554432);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetXListView;
      paramLayoutInflater.mForContacts = true;
      paramLayoutInflater.setOnScrollListener(this);
      if ((this.jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 23))
      {
        boolean bool;
        if ((getBaseActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) && (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel())
        {
          paramLayoutInflater = new StringBuilder();
          paramLayoutInflater.append("getView  >= M, canRequestLocation = ");
          paramLayoutInflater.append(bool);
          QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, paramLayoutInflater.toString());
        }
        if (!bool)
        {
          c(true);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
          paramLayoutInflater = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("getView  >= M, canRequestLocation = ");
            paramBundle.append(bool);
            paramBundle.append(",cached info = ");
            paramBundle.append(paramLayoutInflater);
            QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, paramBundle.toString());
          }
          if (paramLayoutInflater == null) {
            ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AddContactViewPagerTroopFragment.4(this, "recommend_troop"));
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW = new AddContactFindTroopRTLW(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW$onRefreshCallback = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW$onRefreshCallback;
    }
    else
    {
      paramLayoutInflater = paramBundle.getParent();
      if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
        ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "doOnDestroy");
    }
    e();
    AddContactFindTroopRTLW localAddContactFindTroopRTLW = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW;
    if (localAddContactFindTroopRTLW != null) {
      localAddContactFindTroopRTLW.c();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHotTagClickChanged,keyWord = ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(",newKeyWord = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",newHotTagName = ");
      localStringBuilder.append(paramString2);
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (!this.jdField_b_of_type_JavaLangString.equals(paramString1))
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      if (this.jdField_b_of_type_Boolean)
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW;
        if (paramString2 != null) {
          paramString2.a(paramString1);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume:");
      localStringBuilder.append(paramBoolean);
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    if (paramBoolean) {
      d();
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(getResources().getString(2131689663))) {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_location_exp", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_meet_exp", 0, 0, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (!this.d))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume requestData");
      }
      this.d = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW.b(false);
    }
  }
  
  public void ae_()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactFindTroopRTLW.d();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onPause");
    }
    if (paramBoolean) {
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "resetData");
    }
  }
  
  protected void d()
  {
    boolean bool = this.jdField_b_of_type_Boolean;
  }
  
  protected void e() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment
 * JD-Core Version:    0.7.0.1
 */