package com.tencent.mobileqq.apollo.game;

import akpo;
import android.os.Process;
import bdcb;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    akpo localakpo2 = ApolloGameStateMachine.jdField_a_of_type_Akpo;
    akpo localakpo1 = localakpo2;
    if (localakpo2 == null) {
      localakpo1 = new akpo();
    }
    localakpo1.b = bdcb.a(Process.myPid());
    localakpo1.c = bdcb.f();
    ApolloGameStateMachine.jdField_a_of_type_Akpo = localakpo1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */