package com.tencent.mobileqq.apollo.process.data;

import akyg;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class CmGameLauncher$6
  extends IApolloRunnableTask
{
  public CmGameLauncher$6(akyg paramakyg, ApolloCmdChannel paramApolloCmdChannel) {}
  
  public String a()
  {
    return "onKey_back_requestData";
  }
  
  public void run()
  {
    if (this.a != null) {
      this.a.requestData(akyg.a(this.this$0).getLuaState(), "cs.make_room_min.local", "{}", true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.6
 * JD-Core Version:    0.7.0.1
 */