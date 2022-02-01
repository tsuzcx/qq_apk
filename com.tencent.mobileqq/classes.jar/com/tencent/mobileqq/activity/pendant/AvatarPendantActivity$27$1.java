package com.tencent.mobileqq.activity.pendant;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AvatarPendantActivity$27$1
  implements Runnable
{
  AvatarPendantActivity$27$1(AvatarPendantActivity.27 param27, boolean paramBoolean, List paramList, int paramInt) {}
  
  public void run()
  {
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a).setEnabled(true);
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a).setVisibility(8);
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)this.jdField_a_of_type_JavaUtilList.get(0));
        AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a, localIntent);
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a, 2, 2131720405, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a.getTitleBarHeight());
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a, 1, 2131719065, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$27.a.getTitleBarHeight());
    QLog.e("AvatarPendantActivity", 1, "OnProcessFinishListener avatar video process error! actionId: " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.27.1
 * JD-Core Version:    0.7.0.1
 */