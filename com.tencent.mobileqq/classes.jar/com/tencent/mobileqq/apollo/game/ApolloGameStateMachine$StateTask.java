package com.tencent.mobileqq.apollo.game;

import java.lang.ref.WeakReference;

public class ApolloGameStateMachine$StateTask
  implements Runnable
{
  public int a;
  public Runnable a;
  private WeakReference<ApolloGameStateMachine> a;
  
  public ApolloGameStateMachine$StateTask(int paramInt, Runnable paramRunnable, ApolloGameStateMachine paramApolloGameStateMachine)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloGameStateMachine);
  }
  
  public void a() {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameStateMachine.StateTask
 * JD-Core Version:    0.7.0.1
 */