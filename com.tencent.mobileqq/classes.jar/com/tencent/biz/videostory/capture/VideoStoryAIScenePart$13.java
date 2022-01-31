package com.tencent.biz.videostory.capture;

import android.os.Bundle;
import bhci;
import bhcw;
import bhgs;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AECamera.View.AEFilterProviderView;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import wtw;

public class VideoStoryAIScenePart$13
  implements Runnable
{
  public VideoStoryAIScenePart$13(wtw paramwtw, QIMFilterCategoryItem paramQIMFilterCategoryItem, bhgs parambhgs, Bundle paramBundle) {}
  
  public void run()
  {
    if ((wtw.a(this.this$0) != null) && (!wtw.a(this.this$0).b())) {}
    while ((this.this$0.a == null) || (wtw.a(this.this$0).b() != 2)) {
      return;
    }
    wtw.b(this.this$0, true);
    bhci.a().c(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
    this.jdField_a_of_type_Bhgs.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.this$0.a, this.jdField_a_of_type_AndroidOsBundle);
    AEFilterProviderView.a(this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryAIScenePart.13
 * JD-Core Version:    0.7.0.1
 */