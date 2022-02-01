package com.tencent.mobileqq.activity.pendant;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import java.util.List;

class AvatarPendantActivity$30$1
  implements Runnable
{
  AvatarPendantActivity$30$1(AvatarPendantActivity.30 param30, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter == null) {}
    do
    {
      return;
      localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    } while (localObject == null);
    Object localObject = ((AvatarPendantManager)localObject).a();
    AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a, this.jdField_a_of_type_JavaUtilList);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.getSharedPreferences("facechoosedata", 0).getInt("cmshow_avatar_exposure_cout", 0);
    if ((AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a) != null) && (AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a).size() > 0) && (i < 3)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("cmshow_avatar_exposure_cout", i + 1).apply();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a.jdField_a_of_type_JavaUtilList, AvatarPendantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity$30.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.30.1
 * JD-Core Version:    0.7.0.1
 */