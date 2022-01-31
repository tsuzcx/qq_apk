package com.tencent.av.video.effect.core.qqavimage;

public class QQAVImageGrayscaleFilter
  extends QQAVImageFilter
{
  public QQAVImageGrayscaleFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(22));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageGrayscaleFilter
 * JD-Core Version:    0.7.0.1
 */