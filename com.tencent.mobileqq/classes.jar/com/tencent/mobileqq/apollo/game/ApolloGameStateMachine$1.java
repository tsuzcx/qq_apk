package com.tencent.mobileqq.apollo.game;

import aiye;
import android.os.Process;
import bbct;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    aiye localaiye2 = ApolloGameStateMachine.jdField_a_of_type_Aiye;
    aiye localaiye1 = localaiye2;
    if (localaiye2 == null) {
      localaiye1 = new aiye();
    }
    localaiye1.b = bbct.a(Process.myPid());
    localaiye1.c = bbct.f();
    ApolloGameStateMachine.jdField_a_of_type_Aiye = localaiye1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */