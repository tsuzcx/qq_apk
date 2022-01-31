package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformShaker;

public class QQAVImageSoulFilter
  extends QQAVImageFilter
  implements QQSpecialAVFilter.MusicWaveformShaker
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  
  public QQAVImageSoulFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nuniform float in_zoom_times;//从客户端传入的放大镜放大倍数\nuniform float imageWidth;//从客户端传入的图片宽数据\nuniform float imageHeight;//从客户端传入的图片高数据\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nvec2 transForTexPosition(vec2 pos)\n{\n    return vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n \nvec2 getZoomPosition(vec2 in_circle_pos)\n{\n    float zoom_x = (gl_FragCoord.x - in_circle_pos.x) / in_zoom_times;\n    float zoom_y = (gl_FragCoord.y - in_circle_pos.y) / in_zoom_times;\n    return vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\n\nvec4 getColor()//双线性插值采样\n{\n    vec2 pos = getZoomPosition(vec2(imageWidth * 0.5, imageHeight * 0.5));\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n \nvoid main()\n{\nif (in_zoom_times <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n\tvec2 frag_pos = vec2(gl_FragCoord.x, gl_FragCoord.y);\n   \tvec4 colorFront = getColor();\n\tvec4 colorBack = texture2D(inputImageTexture, textureCoordinate);\n\tgl_FragColor = vec4(mix(colorBack.rgb, colorFront.rgb, colorFront.a * 0.3), \tcolorFront.a);\n}");
    super.setQQAVEffectType(1014);
  }
  
  public void a(float paramFloat)
  {
    b(1.0F + 0.3F * paramFloat);
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    setFloat(this.c, paramFloat);
  }
  
  public void onInit()
  {
    super.onInit();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.b = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.c = GLES20.glGetUniformLocation(getProgram(), "in_zoom_times");
    b(1.0F);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.jdField_a_of_type_Int, paramInt1);
    setFloat(this.b, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageSoulFilter
 * JD-Core Version:    0.7.0.1
 */