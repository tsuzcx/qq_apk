package com.tencent.mobileqq.apollo.game;

import aiyc;
import android.os.Process;
import bbdh;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$1
  implements Runnable
{
  ApolloGameStateMachine$1(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    aiyc localaiyc2 = ApolloGameStateMachine.jdField_a_of_type_Aiyc;
    aiyc localaiyc1 = localaiyc2;
    if (localaiyc2 == null) {
      localaiyc1 = new aiyc();
    }
    localaiyc1.b = bbdh.a(Process.myPid());
    localaiyc1.c = bbdh.f();
    ApolloGameStateMachine.jdField_a_of_type_Aiyc = localaiyc1;
    ApolloGameStateMachine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.1
 * JD-Core Version:    0.7.0.1
 */