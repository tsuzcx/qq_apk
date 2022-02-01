package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManager$2
  implements GetFrameCallback
{
  ApolloAvatarFileManager$2(ApolloAvatarFileManager paramApolloAvatarFileManager, int paramInt, List paramList, ApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    if (paramBoolean)
    {
      ApolloAvatarFileManager.b(this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager).put(Integer.valueOf(this.jdField_a_of_type_Int), paramString);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager$OnGetFramePathListener.a(true, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager$OnGetFramePathListener.a(false, null, this.jdField_a_of_type_Int);
    QLog.e("ApolloAvatarFileManager", 1, "GetFrameCallback onComplete :" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager.2
 * JD-Core Version:    0.7.0.1
 */