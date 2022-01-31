package com.tencent.mobileqq.apollo.store;

import ajcf;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class ApolloGameActivity$12
  extends IApolloRunnableTask
{
  ApolloGameActivity$12(ApolloGameActivity paramApolloGameActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String a()
  {
    return "ApolloGameActivity_doOnActivityResult_selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (ApolloGameActivity.a(this.this$0).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.12
 * JD-Core Version:    0.7.0.1
 */