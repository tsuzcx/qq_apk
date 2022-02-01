package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CmShowAvatarImpl$3
  implements IApolloAvatarFileManager.OnGetFramePathListener
{
  CmShowAvatarImpl$3(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt, ICmShowAvatar.IAvatarInterface paramIAvatarInterface) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSetAvatarResp actionId: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" actionType:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("[cmshow]CmShowAvatarImpl", 1, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      paramList = (String)paramList.get(0);
    } else {
      paramList = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcBusinessICmShowAvatar$IAvatarInterface.a(true, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.3
 * JD-Core Version:    0.7.0.1
 */