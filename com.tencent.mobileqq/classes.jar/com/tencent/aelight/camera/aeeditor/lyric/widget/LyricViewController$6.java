package com.tencent.aelight.camera.aeeditor.lyric.widget;

import com.tencent.aelight.camera.log.AEQLog;

class LyricViewController$6
  implements Runnable
{
  LyricViewController$6(LyricViewController paramLyricViewController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface != null) {
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.a(this.a, this.b);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll != null) && (this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface != null))
    {
      if (LyricViewController.a(this.this$0))
      {
        AEQLog.a("ModuleController", "current is selecting lyric. not auto scroll.");
        return;
      }
      int i = this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricBaseInternalViewInterface.a();
      if (LyricViewController.a(this.this$0) == i) {
        return;
      }
      if (i == 0)
      {
        this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.b(i);
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorLyricWidgetLyricViewScroll.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController.6
 * JD-Core Version:    0.7.0.1
 */