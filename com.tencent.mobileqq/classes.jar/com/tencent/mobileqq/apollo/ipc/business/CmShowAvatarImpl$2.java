package com.tencent.mobileqq.apollo.ipc.business;

import android.content.Intent;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CmShowAvatarImpl$2
  implements IApolloAvatarFileManager.OnGetFramePathListener
{
  CmShowAvatarImpl$2(CmShowAvatarImpl paramCmShowAvatarImpl, QQAppInterface paramQQAppInterface, int paramInt, ICmShowAvatar.IAvatarInterface paramIAvatarInterface) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    boolean bool = false;
    Object localObject;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      localObject = new Intent();
      paramList = (String)paramList.get(0);
      paramBoolean = ProfileCardUtil.a(this.a, paramList, (Intent)localObject);
    }
    else
    {
      paramList = "";
      paramBoolean = bool;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSetAvatar isDynamic: ");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("[cmshow]CmShowAvatarImpl", 1, ((StringBuilder)localObject).toString());
    }
    this.c.a(paramBoolean, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.2
 * JD-Core Version:    0.7.0.1
 */