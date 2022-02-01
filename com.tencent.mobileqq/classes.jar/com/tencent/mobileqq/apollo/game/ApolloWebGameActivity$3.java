package com.tencent.mobileqq.apollo.game;

import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;

class ApolloWebGameActivity$3
  extends IApolloRunnableTask
{
  ApolloWebGameActivity$3(ApolloWebGameActivity paramApolloWebGameActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String a()
  {
    return "doOnActivityResult_selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (ApolloWebGameActivity.a(this.this$0).a().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity.3
 * JD-Core Version:    0.7.0.1
 */