package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.util.Utils;
import java.util.HashSet;
import mqq.app.AppRuntime;

class DrawerBizFacade$5
  extends FriendListObserver
{
  DrawerBizFacade$5(DrawerBizFacade paramDrawerBizFacade) {}
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)) && (this.a.jdField_a_of_type_MqqAppAppRuntime != null) && (paramHashSet.contains(this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))) {
      this.a.a("d_avatar").g();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)) && (this.a.jdField_a_of_type_MqqAppAppRuntime != null) && (Utils.a(paramString, this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new DrawerBizFacade.5.1(this));
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1) && (DrawerBizFacade.a(this.a))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new DrawerBizFacade.5.2(this));
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      String str = this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin();
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (str == null) {
          break;
        }
        j = k;
        if (i >= paramArrayOfString.length) {
          break;
        }
        if (str.equals(paramArrayOfString[i]))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new DrawerBizFacade.5.3(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.5
 * JD-Core Version:    0.7.0.1
 */