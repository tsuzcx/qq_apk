package com.tencent.mobileqq.apollo.game;

import akud;
import android.os.Process;
import bdgk;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    akud localakud2 = ApolloGameStateMachine.jdField_a_of_type_Akud;
    akud localakud1 = localakud2;
    if (localakud2 == null) {
      localakud1 = new akud();
    }
    localakud1.b = bdgk.a(Process.myPid());
    localakud1.c = bdgk.f();
    ApolloGameStateMachine.jdField_a_of_type_Akud = localakud1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */