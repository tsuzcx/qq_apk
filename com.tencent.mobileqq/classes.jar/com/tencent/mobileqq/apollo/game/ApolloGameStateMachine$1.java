package com.tencent.mobileqq.apollo.game;

import android.os.Process;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    ApolloGameStateMachine.HardwareInfo localHardwareInfo2 = ApolloGameStateMachine.a;
    ApolloGameStateMachine.HardwareInfo localHardwareInfo1 = localHardwareInfo2;
    if (localHardwareInfo2 == null) {
      localHardwareInfo1 = new ApolloGameStateMachine.HardwareInfo();
    }
    localHardwareInfo1.f = DeviceInfoUtil.a(Process.myPid());
    localHardwareInfo1.g = DeviceInfoUtil.s();
    ApolloGameStateMachine.a = localHardwareInfo1;
    ApolloGameStateMachine.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */