package com.tencent.mobileqq.apollo.game;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloGameStateMachine$4
  implements Runnable
{
  ApolloGameStateMachine$4(ApolloGameStateMachine paramApolloGameStateMachine) {}
  
  public void run()
  {
    if ((!ApolloGameStateMachine.a.get()) && (ApolloGameStateMachine.a(this.this$0) != null))
    {
      ThreadManager.removeJobFromThreadPool(ApolloGameStateMachine.a(this.this$0), 16);
      ThreadManager.excute(ApolloGameStateMachine.a(this.this$0), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.4
 * JD-Core Version:    0.7.0.1
 */