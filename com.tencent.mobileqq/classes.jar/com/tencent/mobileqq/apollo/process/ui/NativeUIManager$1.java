package com.tencent.mobileqq.apollo.process.ui;

import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;

class NativeUIManager$1
  extends IApolloRunnableTask
{
  NativeUIManager$1(NativeUIManager paramNativeUIManager, ApolloSurfaceView paramApolloSurfaceView, String paramString1, String paramString2) {}
  
  public String a()
  {
    return "notifyUIUpdate";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
      if (localIApolloCmdChannel != null) {
        localIApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRuntimeState(), 0, this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1
 * JD-Core Version:    0.7.0.1
 */