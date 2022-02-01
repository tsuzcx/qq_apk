package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformShaker;

public class QQAVImageShakeFilter
  extends QQAVImageFilter
  implements QQSpecialAVFilter.MusicWaveformShaker
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D      inputImageTexture;\nvarying vec2    textureCoordinate;\nuniform float imageWidth;//从客户端传入的图片宽数据\nuniform float imageHeight;//从客户端传入的图片高数据\nuniform float scale;\nuniform int yScaleDirection;//Y轴缩放方向，默认Y轴向上，如果上层逻辑导致向下，这里传1来区分\nuniform float maxScale;\n\nvec2 getZoomPosition(vec2 src)\n{\n\tvec2 in_circle_pos = vec2(imageWidth / 2.0, imageHeight / 2.0);\n    \tfloat zoom_x = (src.x - in_circle_pos.x) / scale;\n    \tfloat zoom_y = (src.y - in_circle_pos.y) / scale;\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\n\nvec2 transForTexPosition(vec2 pos)\n{\n    \treturn vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n\nvec4 getZoomColor(vec2 src)//双线性插值采样\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\nvoid main() {\nif (scale <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n\tfloat scaleDis = (scale - 1.0) / (maxScale - 1.0);\n\tfloat amountY = 0.02 * scale * scaleDis;\n    \tfloat amountX = 0.01 * scale * scaleDis;\nif (yScaleDirection != 0) {\n\t\tamountY = -amountY;\n\t}\tvec4 colR = getZoomColor(vec2((textureCoordinate.x - amountX)* imageWidth, (textureCoordinate.y - amountY) * imageHeight));\n\tvec4 colG = getZoomColor(vec2(textureCoordinate.x * imageWidth, textureCoordinate.y * imageHeight));\n\tvec4 colB = colG;\n\tgl_FragColor = vec4(colR.r, colG.g, colB.b, 1.0);\n}";
  private static final float MAX_SCALE = 1.3F;
  private int mHeightLocation;
  private int mMaxScaleLocation;
  private float mScale;
  private int mScaleLocation;
  private int mWidthLocation;
  private int mYScaleDirection;
  
  public QQAVImageShakeFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nuniform sampler2D      inputImageTexture;\nvarying vec2    textureCoordinate;\nuniform float imageWidth;//从客户端传入的图片宽数据\nuniform float imageHeight;//从客户端传入的图片高数据\nuniform float scale;\nuniform int yScaleDirection;//Y轴缩放方向，默认Y轴向上，如果上层逻辑导致向下，这里传1来区分\nuniform float maxScale;\n\nvec2 getZoomPosition(vec2 src)\n{\n\tvec2 in_circle_pos = vec2(imageWidth / 2.0, imageHeight / 2.0);\n    \tfloat zoom_x = (src.x - in_circle_pos.x) / scale;\n    \tfloat zoom_y = (src.y - in_circle_pos.y) / scale;\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\n\nvec2 transForTexPosition(vec2 pos)\n{\n    \treturn vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n\nvec4 getZoomColor(vec2 src)//双线性插值采样\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\nvoid main() {\nif (scale <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n\tfloat scaleDis = (scale - 1.0) / (maxScale - 1.0);\n\tfloat amountY = 0.02 * scale * scaleDis;\n    \tfloat amountX = 0.01 * scale * scaleDis;\nif (yScaleDirection != 0) {\n\t\tamountY = -amountY;\n\t}\tvec4 colR = getZoomColor(vec2((textureCoordinate.x - amountX)* imageWidth, (textureCoordinate.y - amountY) * imageHeight));\n\tvec4 colG = getZoomColor(vec2(textureCoordinate.x * imageWidth, textureCoordinate.y * imageHeight));\n\tvec4 colB = colG;\n\tgl_FragColor = vec4(colR.r, colG.g, colB.b, 1.0);\n}");
    super.setQQAVEffectType(1013);
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    setInteger(this.mYScaleDirection, 1);
    super.onDraw2(paramInt1, paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.mScaleLocation = GLES20.glGetUniformLocation(getProgram(), "scale");
    this.mYScaleDirection = GLES20.glGetUniformLocation(getProgram(), "yScaleDirection");
    this.mMaxScaleLocation = GLES20.glGetUniformLocation(getProgram(), "maxScale");
    setScale(1.0F);
    setFloat(this.mMaxScaleLocation, 1.3F);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mWidthLocation, paramInt1);
    setFloat(this.mHeightLocation, paramInt2);
  }
  
  public void setMusicScale(float paramFloat)
  {
    setScale(1.0F + 0.3F * paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
    setFloat(this.mScaleLocation, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageShakeFilter
 * JD-Core Version:    0.7.0.1
 */