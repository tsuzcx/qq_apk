package com.tencent.aelight.camera.ae.gif.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import java.util.ArrayList;
import java.util.List;

public class ConcatFilter
  extends BaseFilter
{
  private List<Frame> a = new ArrayList();
  private Frame b = new Frame();
  
  public ConcatFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public Frame a()
  {
    float f1 = 2.0F / this.a.size();
    int i = 0;
    while (i < this.a.size())
    {
      float f2 = i * f1 - 1.0F;
      float f3 = f2 + f1;
      setPositions(new float[] { f2, -1.0F, f2, 1.0F, f3, 1.0F, f3, -1.0F });
      Frame localFrame = (Frame)this.a.get(i);
      RenderProcess(localFrame.getTextureId(), localFrame.width, localFrame.height, this.a.size() * 64, 64, -1, 0.0D, this.b);
      i += 1;
    }
    return this.b;
  }
  
  public void a(List<Frame> paramList)
  {
    this.a = paramList;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.ConcatFilter
 * JD-Core Version:    0.7.0.1
 */