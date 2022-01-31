package com.tencent.mobileqq.apollo.game;

import aill;
import android.os.Process;
import babp;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    aill localaill2 = ApolloGameStateMachine.jdField_a_of_type_Aill;
    aill localaill1 = localaill2;
    if (localaill2 == null) {
      localaill1 = new aill();
    }
    localaill1.b = babp.a(Process.myPid());
    localaill1.c = babp.f();
    ApolloGameStateMachine.jdField_a_of_type_Aill = localaill1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */