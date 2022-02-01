package com.tencent.mobileqq.apollo.game;

import amsy;
import android.os.Process;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    amsy localamsy2 = ApolloGameStateMachine.jdField_a_of_type_Amsy;
    amsy localamsy1 = localamsy2;
    if (localamsy2 == null) {
      localamsy1 = new amsy();
    }
    localamsy1.b = DeviceInfoUtil.getApplicationMemory(Process.myPid());
    localamsy1.c = DeviceInfoUtil.getMemoryClass();
    ApolloGameStateMachine.jdField_a_of_type_Amsy = localamsy1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */