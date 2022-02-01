package com.tencent.av.ui;

import android.app.Activity;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.gameplay.ARNativeBridge;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import lbc;

class GamePlayView$6
  implements Runnable
{
  public void run()
  {
    GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getHeight();
    lbc.c("ARZimuTask_GamePlayView", "createEngineBusiness " + GamePlayView.a(this.this$0).getWidth() + "|" + GamePlayView.a(this.this$0).getHeight() + "|" + this.jdField_a_of_type_Int + "|" + this.b);
    GamePlayView.a(this.this$0).a(this.c, this.jdField_a_of_type_JavaLangString, GamePlayView.a(this.this$0), this.jdField_a_of_type_AndroidContentResAssetManager, this.jdField_a_of_type_JavaLangString, GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getWidth(), GamePlayView.a(this.this$0).getWindowManager().getDefaultDisplay().getHeight(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GamePlayView.6
 * JD-Core Version:    0.7.0.1
 */