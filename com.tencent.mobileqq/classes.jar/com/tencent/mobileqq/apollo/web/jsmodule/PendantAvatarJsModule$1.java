package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.ipc.business.ICmShowAvatar.IAvatarInterface;

class PendantAvatarJsModule$1
  implements ICmShowAvatar.IAvatarInterface
{
  PendantAvatarJsModule$1(PendantAvatarJsModule paramPendantAvatarJsModule, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.b.a(this.a, 0, "set avatar succeed");
      PendantAvatarJsModule.a(this.b, paramString);
      return;
    }
    this.b.a(this.a, "set avatar fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule.1
 * JD-Core Version:    0.7.0.1
 */