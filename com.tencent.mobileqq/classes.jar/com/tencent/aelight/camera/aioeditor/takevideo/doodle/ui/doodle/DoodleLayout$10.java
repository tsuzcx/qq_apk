package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer.LayerEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class DoodleLayout$10
  implements LineLayer.LayerEventListener
{
  DoodleLayout$10(DoodleLayout paramDoodleLayout) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.a.y != null) {
      this.a.y.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a.y != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify outside onDrawMosaic. width:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",height:");
      localStringBuilder.append(paramInt2);
      SLog.b("DoodleLayout", localStringBuilder.toString());
      this.a.y.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.10
 * JD-Core Version:    0.7.0.1
 */