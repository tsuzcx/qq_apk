package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManager$1
  implements ICMSPlayerListener
{
  ApolloAvatarFileManager$1(ApolloAvatarFileManager paramApolloAvatarFileManager, int paramInt, ApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager.a(this.jdField_a_of_type_Int, paramString2);
      paramCMSAction = (List)ApolloAvatarFileManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if ((paramCMSAction != null) && (paramCMSAction.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager$OnGetFramePathListener.a(true, paramCMSAction, this.jdField_a_of_type_Int);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiUitlsImplApolloAvatarFileManager$OnGetFramePathListener.a(false, null, this.jdField_a_of_type_Int);
    QLog.e("ApolloAvatarFileManager", 1, "ICMSPlayerListener onRecordDone :" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager.1
 * JD-Core Version:    0.7.0.1
 */