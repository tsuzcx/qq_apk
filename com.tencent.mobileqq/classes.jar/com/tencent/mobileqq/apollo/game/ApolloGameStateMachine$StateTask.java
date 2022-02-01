package com.tencent.mobileqq.apollo.game;

import java.lang.ref.WeakReference;

public class ApolloGameStateMachine$StateTask
  implements Runnable
{
  public int a;
  public Runnable b;
  private WeakReference<ApolloGameStateMachine> c;
  
  public ApolloGameStateMachine$StateTask(int paramInt, Runnable paramRunnable, ApolloGameStateMachine paramApolloGameStateMachine)
  {
    this.a = paramInt;
    this.b = paramRunnable;
    this.c = new WeakReference(paramApolloGameStateMachine);
  }
  
  public void a() {}
  
  public void run()
  {
    Runnable localRunnable = this.b;
    if (localRunnable != null)
    {
      localRunnable.run();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.StateTask
 * JD-Core Version:    0.7.0.1
 */