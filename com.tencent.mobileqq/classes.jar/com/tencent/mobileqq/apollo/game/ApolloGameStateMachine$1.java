package com.tencent.mobileqq.apollo.game;

import amzd;
import android.os.Process;
import bhlo;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    amzd localamzd2 = ApolloGameStateMachine.jdField_a_of_type_Amzd;
    amzd localamzd1 = localamzd2;
    if (localamzd2 == null) {
      localamzd1 = new amzd();
    }
    localamzd1.b = bhlo.a(Process.myPid());
    localamzd1.c = bhlo.f();
    ApolloGameStateMachine.jdField_a_of_type_Amzd = localamzd1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */