package com.tencent.mobileqq.apollo.process.ui;

import akwd;
import akzz;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class NativeUIManager$1
  extends IApolloRunnableTask
{
  public NativeUIManager$1(akzz paramakzz, ApolloSurfaceView paramApolloSurfaceView, String paramString1, String paramString2) {}
  
  public String a()
  {
    return "notifyUIUpdate";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      ApolloCmdChannel localApolloCmdChannel = akwd.a();
      if (localApolloCmdChannel != null) {
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRuntimeState(), 0, this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1
 * JD-Core Version:    0.7.0.1
 */