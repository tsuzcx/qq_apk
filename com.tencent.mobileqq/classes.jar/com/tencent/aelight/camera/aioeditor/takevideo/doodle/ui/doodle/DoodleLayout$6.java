package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel.DoodlePanelListener;

class DoodleLayout$6
  implements DoodleShapePanel.DoodlePanelListener
{
  DoodleLayout$6(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    Object localObject = this.a.getShapeLayer();
    if (localObject != null)
    {
      ((ShapeLayer)localObject).i().h();
      this.a.w();
      DoodleLayout.a(this.a);
      if (this.a.C == 9) {
        DoodleLayout.b(this.a);
      }
      localObject = this.a;
      DoodleLayout.a((DoodleLayout)localObject, ((DoodleLayout)localObject).C);
    }
  }
  
  public void a(float paramFloat)
  {
    ShapeLayer localShapeLayer = this.a.getShapeLayer();
    if (localShapeLayer != null)
    {
      localShapeLayer.i().b(paramFloat);
      this.a.w();
    }
  }
  
  public void a(int paramInt)
  {
    ShapeLayer localShapeLayer = this.a.getShapeLayer();
    if (localShapeLayer != null)
    {
      localShapeLayer.i().b(paramInt);
      this.a.w();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.6
 * JD-Core Version:    0.7.0.1
 */