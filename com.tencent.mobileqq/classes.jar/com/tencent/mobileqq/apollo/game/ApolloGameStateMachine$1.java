package com.tencent.mobileqq.apollo.game;

import altx;
import android.os.Process;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    altx localaltx2 = ApolloGameStateMachine.jdField_a_of_type_Altx;
    altx localaltx1 = localaltx2;
    if (localaltx2 == null) {
      localaltx1 = new altx();
    }
    localaltx1.b = DeviceInfoUtil.getApplicationMemory(Process.myPid());
    localaltx1.c = DeviceInfoUtil.getMemoryClass();
    ApolloGameStateMachine.jdField_a_of_type_Altx = localaltx1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */