package com.tencent.mobileqq.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import mqq.app.MobileQQ;

public class EditFriendRemarkService
  implements IEditInfoApi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new EditFriendRemarkService.2(this);
  private IEditInfoActivity jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = null;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
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
    return new EditFriendRemarkService.1(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditFriendRemarkService
 * JD-Core Version:    0.7.0.1
 */