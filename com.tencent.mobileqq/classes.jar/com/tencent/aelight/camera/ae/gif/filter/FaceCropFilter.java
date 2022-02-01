package com.tencent.aelight.camera.ae.gif.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.aebase.Util;
import com.tencent.filter.BaseFilter;
import java.util.List;

public class FaceCropFilter
  extends BaseFilter
{
  private Frame a = new Frame();
  
  public FaceCropFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public Frame a(int paramInt1, List<PointF> paramList, int paramInt2, int paramInt3)
  {
    float[] arrayOfFloat = new float[8];
    Util.a(paramList, paramInt2, paramInt3, arrayOfFloat);
    paramList = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    paramList.apply();
    paramList.setTexCords(arrayOfFloat);
    paramList.setRotationAndFlip(0, 1, 1);
    paramList.RenderProcess(paramInt1, paramInt2, paramInt3, 64, 64, -1, 0.0D, this.a);
    return this.a;
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.FaceCropFilter
 * JD-Core Version:    0.7.0.1
 */