package com.tencent.mobileqq.apollo.script;

import android.view.View;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;

class SpriteBackgroundManager$1
  implements Runnable
{
  SpriteBackgroundManager$1(SpriteBackgroundManager paramSpriteBackgroundManager, ICMShowView paramICMShowView, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView() != null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView.getView().setVisibility(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.1
 * JD-Core Version:    0.7.0.1
 */