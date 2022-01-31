package com.tencent.mobileqq.activity.contact.addcontact;

import afdm;
import afdo;
import afdu;
import afdv;
import afdy;
import afea;
import akug;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import axqw;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.fragment.ContactsBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class AddContactViewPagerTroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  protected int a;
  public afdm a;
  afdo jdField_a_of_type_Afdo = new afdy(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afdv(this);
  public View.OnTouchListener a;
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public XListView a;
  public String a;
  public TextView b;
  public String b;
  public TextView c;
  public String c;
  private boolean c;
  
  public AddContactViewPagerTroopFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new afdu(this);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689706);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131707153);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689705);
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setBackgroundResource(2130839132);
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
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "getView");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559656, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377338));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367898));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377220));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377221));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377222));
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374969));
      this.jdField_a_of_type_ComTencentWidgetXListView.setId(2131362086);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131167087);
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setScrollBarStyle(33554432);
      this.jdField_a_of_type_ComTencentWidgetXListView.mForContacts = true;
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      if ((this.jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 23)) {
        if ((getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1)) {
          break label443;
        }
      }
    }
    label443:
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, "getView  >= M, canRequestLocation = " + bool);
      }
      if (!bool)
      {
        c(true);
        this.jdField_a_of_type_Afdm = new afdm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Afdm.jdField_a_of_type_Afdo = this.jdField_a_of_type_Afdo;
      }
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        paramLayoutInflater = akug.a("recommend_troop");
        if (QLog.isColorLevel()) {
          QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, "getView  >= M, canRequestLocation = " + bool + ",cached info = " + paramLayoutInflater);
        }
        if (paramLayoutInflater != null) {
          break;
        }
        akug.a(new afea(this, "recommend_troop"));
        break;
        paramLayoutInflater = this.jdField_a_of_type_AndroidViewView.getParent();
        if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
          ((ViewGroup)paramLayoutInflater).removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "doOnDestroy");
    }
    e();
    if (this.jdField_a_of_type_Afdm != null) {
      this.jdField_a_of_type_Afdm.e();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onHotTagClickChanged,keyWord = " + this.jdField_b_of_type_JavaLangString + ",newKeyWord = " + paramString1 + ",newHotTagName = " + paramString2);
    }
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (!this.jdField_b_of_type_JavaLangString.equals(paramString1))
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Afdm != null)) {
        this.jdField_a_of_type_Afdm.a(paramString1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        d();
      }
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
      {
        if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(getResources().getString(2131689706))) {
          break label158;
        }
        axqw.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_location_exp", 0, 0, "", "", "", "");
      }
      while ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume requestData");
        }
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Afdm.a(false);
        return;
        label158:
        axqw.b(null, "dc00899", "Grp_find_new", "", "grptab", "no_meet_exp", 0, 0, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "", "");
      }
    }
  }
  
  public void an_()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Afdm.b();
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
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment
 * JD-Core Version:    0.7.0.1
 */