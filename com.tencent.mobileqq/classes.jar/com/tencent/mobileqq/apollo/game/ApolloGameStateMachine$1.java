package com.tencent.mobileqq.apollo.game;

import amnj;
import android.os.Process;
import bgln;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    amnj localamnj2 = ApolloGameStateMachine.jdField_a_of_type_Amnj;
    amnj localamnj1 = localamnj2;
    if (localamnj2 == null) {
      localamnj1 = new amnj();
    }
    localamnj1.b = bgln.a(Process.myPid());
    localamnj1.c = bgln.f();
    ApolloGameStateMachine.jdField_a_of_type_Amnj = localamnj1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */