package com.tencent.mobileqq.apollo.utils.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManagerImpl$2
  implements GetFrameCallback
{
  ApolloAvatarFileManagerImpl$2(ApolloAvatarFileManagerImpl paramApolloAvatarFileManagerImpl, int paramInt, List paramList, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      ApolloAvatarFileManagerImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiImplApolloAvatarFileManagerImpl).put(Integer.valueOf(this.jdField_a_of_type_Int), paramString);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiIApolloAvatarFileManager$OnGetFramePathListener.a(true, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiIApolloAvatarFileManager$OnGetFramePathListener.a(false, null, this.jdField_a_of_type_Int);
    paramString = new StringBuilder();
    paramString.append("GetFrameCallback onComplete :");
    paramString.append(paramBoolean);
    QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloAvatarFileManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */