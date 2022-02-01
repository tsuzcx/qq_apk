package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.DoodlePanelListener;

class DoodleLayout$6
  implements DoodleShapePanel.DoodlePanelListener
{
  DoodleLayout$6(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      ((ShapeLayer)localObject).a().e();
      this.a.s();
      DoodleLayout.a(this.a);
      if (this.a.h == 9) {
        DoodleLayout.b(this.a);
      }
      localObject = this.a;
      DoodleLayout.a((DoodleLayout)localObject, ((DoodleLayout)localObject).h);
    }
  }
  
  public void a(float paramFloat)
  {
    ShapeLayer localShapeLayer = this.a.a();
    if (localShapeLayer != null)
    {
      localShapeLayer.a().b(paramFloat);
      this.a.s();
    }
  }
  
  public void a(int paramInt)
  {
    ShapeLayer localShapeLayer = this.a.a();
    if (localShapeLayer != null)
    {
      localShapeLayer.a().b(paramInt);
      this.a.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.6
 * JD-Core Version:    0.7.0.1
 */