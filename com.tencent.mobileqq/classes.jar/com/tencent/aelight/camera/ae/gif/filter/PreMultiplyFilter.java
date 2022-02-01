package com.tencent.aelight.camera.ae.gif.filter;

import com.tencent.filter.BaseFilter;

public class PreMultiplyFilter
  extends BaseFilter
{
  public PreMultiplyFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n\n    gl_FragColor = vec4(color.rgb, step(0.5, color.a));\n}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.filter.PreMultiplyFilter
 * JD-Core Version:    0.7.0.1
 */