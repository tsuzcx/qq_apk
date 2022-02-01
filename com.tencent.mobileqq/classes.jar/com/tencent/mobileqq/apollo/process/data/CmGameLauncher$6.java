package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;

class CmGameLauncher$6
  extends IApolloRunnableTask
{
  CmGameLauncher$6(CmGameLauncher paramCmGameLauncher, IApolloCmdChannel paramIApolloCmdChannel) {}
  
  public String a()
  {
    return "onKey_back_requestData";
  }
  
  public void run()
  {
    if (this.a != null) {
      this.a.requestData(CmGameLauncher.a(this.this$0).getLuaState(), "cs.make_room_min.local", "{}", true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.6
 * JD-Core Version:    0.7.0.1
 */