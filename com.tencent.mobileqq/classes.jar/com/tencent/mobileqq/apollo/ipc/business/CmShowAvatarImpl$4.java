package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CmShowAvatarImpl$4
  implements GetFrameCallback
{
  CmShowAvatarImpl$4(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt, ICMSRecordCallback paramICMSRecordCallback) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    CmShowAvatarImpl.a(this.jdField_a_of_type_ComTencentMobileqqApolloIpcBusinessCmShowAvatarImpl).remove(paramCMSAction);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordStaticAvatar onRecordDone actionId:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key: ");
      localStringBuilder.append(paramCMSAction.a(null, null));
      localStringBuilder.append(" map size:");
      localStringBuilder.append(CmShowAvatarImpl.a(this.jdField_a_of_type_ComTencentMobileqqApolloIpcBusinessCmShowAvatarImpl).size());
      QLog.i("[cmshow]CmShowAvatarImpl", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSRecordCallback.a(paramBoolean, paramString, paramCMSAction.a(null, null), this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.4
 * JD-Core Version:    0.7.0.1
 */