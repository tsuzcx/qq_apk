package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.Map;

class C2CMessageManagerCallback$1$2
  implements Runnable
{
  C2CMessageManagerCallback$1$2(C2CMessageManagerCallback.1 param1) {}
  
  public void run()
  {
    if (this.a.f.getRefreshActionMap().containsKey(UinTypeUtil.a(this.a.d, this.a.c))) {
      this.a.f.getRefreshActionMap().remove(UinTypeUtil.a(this.a.d, this.a.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManagerCallback.1.2
 * JD-Core Version:    0.7.0.1
 */