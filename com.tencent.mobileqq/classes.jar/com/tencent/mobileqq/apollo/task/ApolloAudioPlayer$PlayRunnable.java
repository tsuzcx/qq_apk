package com.tencent.mobileqq.apollo.task;

import java.lang.ref.WeakReference;

class ApolloAudioPlayer$PlayRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  WeakReference<ApolloAudioPlayer> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void run()
  {
    ApolloAudioPlayer localApolloAudioPlayer = (ApolloAudioPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloAudioPlayer == null) {
      return;
    }
    ApolloAudioPlayer.a(localApolloAudioPlayer, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAudioPlayer.PlayRunnable
 * JD-Core Version:    0.7.0.1
 */