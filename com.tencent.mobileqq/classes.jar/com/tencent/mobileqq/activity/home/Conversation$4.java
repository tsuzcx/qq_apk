package com.tencent.mobileqq.activity.home;

import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class Conversation$4
  extends IApolloRunnableTask
{
  Conversation$4(Conversation paramConversation, ApolloSurfaceView paramApolloSurfaceView, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String a()
  {
    return "Conversation_selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.4
 * JD-Core Version:    0.7.0.1
 */