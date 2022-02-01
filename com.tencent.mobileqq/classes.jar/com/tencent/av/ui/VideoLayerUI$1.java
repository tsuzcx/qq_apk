package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$1
  implements Runnable
{
  VideoLayerUI$1(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    int i = this.this$0.b.getHeight();
    int j = this.this$0.b.getWidth();
    if ((i != 0) && (j != 0))
    {
      j = this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299268);
      VideoLayerUI localVideoLayerUI = this.this$0;
      i -= j;
      VideoLayerUI.a(localVideoLayerUI, new Rect(0, i - localVideoLayerUI.m, VideoLayerUI.a(this.this$0).widthPixels, i));
      QLog.w(this.this$0.jdField_a_of_type_JavaLangString, 1, "initGlRootView mSlideWindowAreas init end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.1
 * JD-Core Version:    0.7.0.1
 */