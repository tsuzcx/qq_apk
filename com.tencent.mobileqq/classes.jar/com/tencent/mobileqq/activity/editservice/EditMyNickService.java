package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import mqq.app.MobileQQ;

public class EditMyNickService
  implements IEditInfoApi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new EditMyNickService.2(this);
  private IEditInfoActivity jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = null;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramString1, paramString1.getString(2131693295), 0).a();
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramString1, paramString1.getString(2131693296), 0).a();
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Intent a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("default_text");
    this.b = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    return paramIntent;
  }
  
  public View.OnClickListener a()
  {
    return null;
  }
  
  public EmoticonCallback a()
  {
    return null;
  }
  
  public OnItemSelectListener a()
  {
    return new EditMyNickService.1(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2) {}
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = paramIEditInfoActivity;
    this.jdField_a_of_type_AndroidContentContext = paramIEditInfoActivity.getContext();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditMyNickService
 * JD-Core Version:    0.7.0.1
 */