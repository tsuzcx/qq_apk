package com.tencent.mobileqq.apollo.game.process.ui;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class NativeUIManager$1
  extends IApolloRunnableTask
{
  NativeUIManager$1(NativeUIManager paramNativeUIManager, ApolloSurfaceView paramApolloSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView != null) {
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getLuaState(), 0, this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.NativeUIManager.1
 * JD-Core Version:    0.7.0.1
 */