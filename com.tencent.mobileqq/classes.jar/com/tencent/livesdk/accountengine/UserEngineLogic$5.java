package com.tencent.livesdk.accountengine;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AvInitCallBack;
import java.util.Iterator;
import java.util.List;

class UserEngineLogic$5
  implements AvInitCallBack
{
  UserEngineLogic$5(UserEngineLogic paramUserEngineLogic) {}
  
  public void onAvInitCompleted()
  {
    UserEngineLogic.access$302(this.this$0, 5);
    UserEngineLogic.access$200(this.this$0).i("ilivesdkdemo", "good, onAvInitCompleted OK :)", new Object[0]);
    Iterator localIterator = UserEngineLogic.access$400(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((UserInitStateCallback)localIterator.next()).onAvInitSucceed();
    }
  }
  
  public void onAvInitErr()
  {
    UserEngineLogic.access$302(this.this$0, 4);
    Iterator localIterator = UserEngineLogic.access$400(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((UserInitStateCallback)localIterator.next()).onAvInitFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.accountengine.UserEngineLogic.5
 * JD-Core Version:    0.7.0.1
 */