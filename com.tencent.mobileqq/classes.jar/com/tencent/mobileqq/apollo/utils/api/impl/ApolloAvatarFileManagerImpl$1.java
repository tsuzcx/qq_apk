package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManagerImpl$1
  implements ICMSPlayerListener
{
  ApolloAvatarFileManagerImpl$1(ApolloAvatarFileManagerImpl paramApolloAvatarFileManagerImpl, int paramInt, String paramString, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiImplApolloAvatarFileManagerImpl.putAction2GifFilePath(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramString2);
      paramCMSAction = (List)ApolloAvatarFileManagerImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiImplApolloAvatarFileManagerImpl).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if ((paramCMSAction != null) && (paramCMSAction.size() > 0))
      {
        paramString1 = new StringBuilder();
        paramString1.append("getAllFrameFiles onRecordDone success filePathList: ");
        paramString1.append(paramCMSAction.size());
        QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, paramString1.toString());
        this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiIApolloAvatarFileManager$OnGetFramePathListener.a(true, paramCMSAction, this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiIApolloAvatarFileManager$OnGetFramePathListener.a(false, null, this.jdField_a_of_type_Int);
      paramString1 = new StringBuilder();
      paramString1.append("ICMSPlayerListener onRecordDone :");
      paramString1.append(paramBoolean);
      paramString1.append(" filePathList: ");
      int i;
      if (paramCMSAction == null) {
        i = -1;
      } else {
        i = paramCMSAction.size();
      }
      paramString1.append(i);
      QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramString1.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloUtilsApiIApolloAvatarFileManager$OnGetFramePathListener.a(false, null, this.jdField_a_of_type_Int);
    paramCMSAction = new StringBuilder();
    paramCMSAction.append("ICMSPlayerListener onRecordDone :");
    paramCMSAction.append(paramBoolean);
    QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramCMSAction.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloAvatarFileManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */