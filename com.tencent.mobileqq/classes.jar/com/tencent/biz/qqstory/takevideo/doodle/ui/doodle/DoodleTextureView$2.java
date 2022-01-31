package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.qphone.base.util.QLog;
import vbj;
import vbs;

class DoodleTextureView$2
  implements Runnable
{
  DoodleTextureView$2(DoodleTextureView paramDoodleTextureView) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.g();
      vbs localvbs = (vbs)this.this$0.a.a(102);
      if (localvbs != null) {
        localvbs.b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView.2
 * JD-Core Version:    0.7.0.1
 */