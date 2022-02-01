package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;

class CmdTaskManger$Command<Request extends NetworkRequest, Respond extends BaseResponse>
  implements NetworkRequest.IProtocolListener<Respond>
{
  public Request a;
  protected final long b;
  protected CmdTaskManger.CommandCallback<Request, Respond> c;
  
  public CmdTaskManger$Command(Request paramRequest)
  {
    this.a = paramRequest;
    this.b = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    CmdTaskManger.CommandCallback localCommandCallback = this.c;
    if (localCommandCallback != null)
    {
      localCommandCallback.a(this.a, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    SLog.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.CmdTaskManger.Command
 * JD-Core Version:    0.7.0.1
 */