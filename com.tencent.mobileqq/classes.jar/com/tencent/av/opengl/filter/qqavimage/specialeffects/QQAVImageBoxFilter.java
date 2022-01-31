package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class QQAVImageBoxFilter
  extends QQAVImageFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\n\nuniform float imageWidth;                  //从客户端传入的图片宽数据\nuniform float imageHeight;                 //从客户端传入的图片高数据\nvec2 clipTextureCoordinate;     \t //当前屏幕进行裁剪的区域，每个宫格以这个区域进行缩放\nfloat in_zoom_times = 1.0;                //每个宫格对clipTextureCoordinate缩放的比例\nuniform float clipBoxNum;\t\t\t//每条边分割的数量，九宫格就是3 \nvec2 eachBoxSize;\nuniform vec4 boxColor[16]; \n\n// 转换为纹理范围\nvec2 transForTexPosition(vec2 pos)\n{\n    return vec2(float(pos.x/imageWidth), float(pos.y/imageHeight));\n}\n \nvec2 getZoomPosition(vec2 src)\n{   \n    float dis = mod(src.x, eachBoxSize.x * imageWidth);\n    float zoom_x = clipTextureCoordinate.x + dis / in_zoom_times; \n    dis = mod(src.y , eachBoxSize.y * imageHeight);\n    float zoom_y = clipTextureCoordinate.y +  dis / in_zoom_times; \n    \n    return vec2(zoom_x, zoom_y);\n}\n\nvec4 getZoomColor(vec2 src)\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n    //双线性插值采样\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y))); \n\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.))); \n\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y))); \n\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y + 1.))); \n\n    return (1. - u) * (1. - v) * data_00 + (1. - u) * v * data_01 + u * (1. - v) * data_10 + u * v * data_11;\n\n}\n\nvec4 getShrinkColor(vec2 src)\n{\n\tvec2 uv = vec2(mod(src.x, eachBoxSize.x), mod(src.y, eachBoxSize.x));\n\tuv += 0.5 - in_zoom_times / 2.0;\n\tfloat shrinkScale = 1.0 / in_zoom_times;\n\tvec2 coordinate = (0.5 + -0.5 * shrinkScale +  uv * shrinkScale);\n        vec4 r = texture2D(inputImageTexture, coordinate);\n\treturn r;\n}\n\nvec4 getCurrentBoxColor(vec2 src)\n{\n\tint indexX = int(src.x /  eachBoxSize.x);\n\tint indexY = int(src.y /  eachBoxSize.y);\n\tint index = indexY * int(clipBoxNum) + indexX;\n\treturn boxColor[index];\n}\n\nvec4 getMixColor(vec4 frontColor, vec4 backColor)\n{\n\treturn vec4(mix(backColor.rgb, frontColor.rgb, frontColor.a * 0.5), \tfrontColor.a);\n}\n\nvoid main()\n{ \n\tif (clipBoxNum <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n  \teachBoxSize.x = 1.0 / clipBoxNum;\n\teachBoxSize.y = 1.0 / clipBoxNum;\n  \tin_zoom_times = 1.0 / clipBoxNum;\n\t//gl_FragColor = getZoomColor(gl_FragCoord.xy);  \t//双线性插值缩放\n\tgl_FragColor = getShrinkColor(textureCoordinate.xy);  //线性缩放\n\n\t//boxColor[0] = vec4(1.0, 0.0, 0.0, 1.0);\n\t//gl_FragColor = getMixColor(getCurrentBoxColor(textureCoordinate), gl_FragColor);\n}";
  private int mBoxNumLocation;
  private int mCurrentBoxNum;
  private int mHeightLocation;
  private long mStartTimeMills;
  private int mWidthLocation;
  
  public QQAVImageBoxFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\n\nuniform float imageWidth;                  //从客户端传入的图片宽数据\nuniform float imageHeight;                 //从客户端传入的图片高数据\nvec2 clipTextureCoordinate;     \t //当前屏幕进行裁剪的区域，每个宫格以这个区域进行缩放\nfloat in_zoom_times = 1.0;                //每个宫格对clipTextureCoordinate缩放的比例\nuniform float clipBoxNum;\t\t\t//每条边分割的数量，九宫格就是3 \nvec2 eachBoxSize;\nuniform vec4 boxColor[16]; \n\n// 转换为纹理范围\nvec2 transForTexPosition(vec2 pos)\n{\n    return vec2(float(pos.x/imageWidth), float(pos.y/imageHeight));\n}\n \nvec2 getZoomPosition(vec2 src)\n{   \n    float dis = mod(src.x, eachBoxSize.x * imageWidth);\n    float zoom_x = clipTextureCoordinate.x + dis / in_zoom_times; \n    dis = mod(src.y , eachBoxSize.y * imageHeight);\n    float zoom_y = clipTextureCoordinate.y +  dis / in_zoom_times; \n    \n    return vec2(zoom_x, zoom_y);\n}\n\nvec4 getZoomColor(vec2 src)\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n    //双线性插值采样\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y))); \n\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.))); \n\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y))); \n\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y + 1.))); \n\n    return (1. - u) * (1. - v) * data_00 + (1. - u) * v * data_01 + u * (1. - v) * data_10 + u * v * data_11;\n\n}\n\nvec4 getShrinkColor(vec2 src)\n{\n\tvec2 uv = vec2(mod(src.x, eachBoxSize.x), mod(src.y, eachBoxSize.x));\n\tuv += 0.5 - in_zoom_times / 2.0;\n\tfloat shrinkScale = 1.0 / in_zoom_times;\n\tvec2 coordinate = (0.5 + -0.5 * shrinkScale +  uv * shrinkScale);\n        vec4 r = texture2D(inputImageTexture, coordinate);\n\treturn r;\n}\n\nvec4 getCurrentBoxColor(vec2 src)\n{\n\tint indexX = int(src.x /  eachBoxSize.x);\n\tint indexY = int(src.y /  eachBoxSize.y);\n\tint index = indexY * int(clipBoxNum) + indexX;\n\treturn boxColor[index];\n}\n\nvec4 getMixColor(vec4 frontColor, vec4 backColor)\n{\n\treturn vec4(mix(backColor.rgb, frontColor.rgb, frontColor.a * 0.5), \tfrontColor.a);\n}\n\nvoid main()\n{ \n\tif (clipBoxNum <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n  \teachBoxSize.x = 1.0 / clipBoxNum;\n\teachBoxSize.y = 1.0 / clipBoxNum;\n  \tin_zoom_times = 1.0 / clipBoxNum;\n\t//gl_FragColor = getZoomColor(gl_FragCoord.xy);  \t//双线性插值缩放\n\tgl_FragColor = getShrinkColor(textureCoordinate.xy);  //线性缩放\n\n\t//boxColor[0] = vec4(1.0, 0.0, 0.0, 1.0);\n\t//gl_FragColor = getMixColor(getCurrentBoxColor(textureCoordinate), gl_FragColor);\n}");
    super.setQQAVEffectType(1015);
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    long l = (System.currentTimeMillis() - this.mStartTimeMills) % 10000L;
    if (l < 4000L) {
      this.mCurrentBoxNum = 2;
    }
    for (;;)
    {
      setFloat(this.mBoxNumLocation, this.mCurrentBoxNum);
      super.onDraw2(paramInt1, paramInt2);
      return;
      if (l < 8000L) {
        this.mCurrentBoxNum = 3;
      } else if (l < 10000L) {
        this.mCurrentBoxNum = 1;
      }
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.mBoxNumLocation = GLES20.glGetUniformLocation(getProgram(), "clipBoxNum");
    this.mStartTimeMills = System.currentTimeMillis();
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mWidthLocation, paramInt1);
    setFloat(this.mHeightLocation, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageBoxFilter
 * JD-Core Version:    0.7.0.1
 */