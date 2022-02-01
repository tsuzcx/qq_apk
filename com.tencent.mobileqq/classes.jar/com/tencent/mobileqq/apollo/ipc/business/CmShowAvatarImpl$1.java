package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.qphone.base.util.QLog;

class CmShowAvatarImpl$1
  implements IApolloAvatarVideoProcessor.OnProcessFinishListener
{
  CmShowAvatarImpl$1(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt1, ICmShowAvatar.IAvatarInterface paramIAvatarInterface, int paramInt2, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSetAvatar isDynamic: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.i("[cmshow]CmShowAvatarImpl", 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      CmShowAvatarImpl.a(this.e, this.b, paramInt, this.c, this.d);
      return;
    }
    this.b.a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.1
 * JD-Core Version:    0.7.0.1
 */