package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.SetCapsuleCallback;

class StoreJsModule$1
  implements IStoreAvatar2D.SetCapsuleCallback
{
  StoreJsModule$1(StoreJsModule paramStoreJsModule, String paramString) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.b(this.a);
      return;
    }
    this.b.a(this.a, "result != 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.StoreJsModule.1
 * JD-Core Version:    0.7.0.1
 */