package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CmShowAvatarImpl$5
  implements ICMSPlayerListener
{
  CmShowAvatarImpl$5(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt, ICMSRecordCallback paramICMSRecordCallback) {}
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    CmShowAvatarImpl.b(this.jdField_a_of_type_ComTencentMobileqqApolloIpcBusinessCmShowAvatarImpl).remove(paramCMSAction);
    if (QLog.isColorLevel())
    {
      paramCMSAction = new StringBuilder();
      paramCMSAction.append("recordDynamicAvatar onRecordDone actionId:");
      paramCMSAction.append(this.jdField_a_of_type_Int);
      paramCMSAction.append(" success:");
      paramCMSAction.append(paramBoolean);
      paramCMSAction.append(" ");
      paramCMSAction.append(paramString2);
      paramCMSAction.append(" key: ");
      paramCMSAction.append(paramString1);
      paramCMSAction.append(" map size:");
      paramCMSAction.append(CmShowAvatarImpl.b(this.jdField_a_of_type_ComTencentMobileqqApolloIpcBusinessCmShowAvatarImpl).size());
      QLog.i("[cmshow]CmShowAvatarImpl", 1, paramCMSAction.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSRecordCallback.a(paramBoolean, paramString2, paramString1, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.5
 * JD-Core Version:    0.7.0.1
 */