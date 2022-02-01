package com.tencent.av.video.effect.core.qqavimage.denoise;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class QQAVImageDenoiseRGB2YUVFilter
  extends QQAVImageFilter
{
  public QQAVImageDenoiseRGB2YUVFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(26));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseRGB2YUVFilter
 * JD-Core Version:    0.7.0.1
 */