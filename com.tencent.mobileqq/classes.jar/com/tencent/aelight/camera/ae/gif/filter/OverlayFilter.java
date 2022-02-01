package com.tencent.aelight.camera.ae.gif.filter;

import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class OverlayFilter
  extends BaseFilter
{
  public OverlayFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int isAlpha;\nvoid main()\n{\n    highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    color.rgb = color.rgb / color.a;\n    float alpha = step(0.5, color.a);\n    if (isAlpha == 1)\n    {\n        gl_FragColor = vec4(1.0 - alpha, 1.0 - alpha, 1.0 - alpha, 1.0);\n    }\n    else\n    {\n        gl_FragColor = vec4(color.rgb, alpha);\n    }\n}");
    addParam(new UniformParam.IntParam("isAlpha", 0));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setPositions(new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, paramFloat4 });
  }
  
  public void a(Frame paramFrame1, Frame paramFrame2)
  {
    a(-1.0F, 0.0F, 1.0F, -1.0F);
    addParam(new UniformParam.IntParam("isAlpha", 1));
    RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
    a(-1.0F, 1.0F, 1.0F, 0.0F);
    addParam(new UniformParam.IntParam("isAlpha", 0));
    RenderProcess(paramFrame1.getTextureId(), paramFrame1.width, paramFrame1.height, paramFrame1.width, paramFrame1.height, -1, 0.0D, paramFrame2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.OverlayFilter
 * JD-Core Version:    0.7.0.1
 */