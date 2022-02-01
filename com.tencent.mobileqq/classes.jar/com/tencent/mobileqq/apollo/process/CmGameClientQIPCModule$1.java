package com.tencent.mobileqq.apollo.process;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

public final class CmGameClientQIPCModule$1
  implements Runnable
{
  public CmGameClientQIPCModule$1(int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("gameId", this.a);
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "cm_game_client_module", "action_close_game", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */