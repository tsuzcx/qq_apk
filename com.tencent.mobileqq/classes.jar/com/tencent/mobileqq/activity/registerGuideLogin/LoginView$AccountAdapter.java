package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

class LoginView$AccountAdapter
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public LoginView$AccountAdapter(LoginView paramLoginView, Context paramContext)
  {
    super(paramContext, 2131558412, 2131369438, paramLoginView.jdField_a_of_type_JavaUtilList);
  }
  
  public String a(int paramInt)
  {
    String str = ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_MqqAppAppRuntime == null) {
      return str;
    }
    return LoginUtils.a(str);
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      return super.getCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(0);
    }
  }
  
  public Filter getFilter()
  {
    if (this.jdField_a_of_type_AndroidWidgetFilter == null) {
      this.jdField_a_of_type_AndroidWidgetFilter = new LoginView.AccountAdapter.1(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131363419);
    ImageView localImageView = (ImageView)localView.findViewById(2131369351);
    String str = ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
    if ((LoginView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView) == null) || (LoginView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView).get(str) == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(localImageView, str, false);
      localImageView = (ImageView)localView.findViewById(2131369286);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(this);
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719733));
      localView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131689502) + "%s", new Object[] { str }));
      if (getCount() != 1) {
        break label297;
      }
      localLinearLayout.setPadding(0, Utils.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, Utils.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
    }
    for (;;)
    {
      localLinearLayout.setOnClickListener(new LoginView.AccountAdapter.2(this, paramInt));
      localView.setOnTouchListener(new LoginView.AccountAdapter.3(this));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = LoginView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView).get(str);
      LoginView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView, localImageView, localObject);
      break;
      label297:
      if (paramInt == 0) {
        localLinearLayout.setPadding(0, Utils.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()), 0, 0);
      } else if (paramInt == getCount() - 1) {
        localLinearLayout.setPadding(0, 0, 0, Utils.a(7.5F, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.getResources()));
      } else {
        localLinearLayout.setPadding(0, 0, 0, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_Int = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.AccountAdapter
 * JD-Core Version:    0.7.0.1
 */