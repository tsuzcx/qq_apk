package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AvatarPendantActivity$28$1
  implements Runnable
{
  AvatarPendantActivity$28$1(AvatarPendantActivity.28 param28, boolean paramBoolean, List paramList, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a).setEnabled(true);
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a).setVisibility(8);
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)this.jdField_a_of_type_JavaUtilList.get(0));
        AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a, (Intent)localObject);
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a, 2, 2131720144, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a.getTitleBarHeight());
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a, 1, 2131718781, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$28.a.getTitleBarHeight());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnProcessFinishListener avatar video process error! actionId: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.e("AvatarPendantActivity", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.28.1
 * JD-Core Version:    0.7.0.1
 */