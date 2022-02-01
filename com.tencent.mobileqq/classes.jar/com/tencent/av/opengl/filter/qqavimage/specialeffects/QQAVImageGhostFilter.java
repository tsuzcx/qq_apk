package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import java.util.Random;

public class QQAVImageGhostFilter
  extends QQAVImageFilter
{
  public static final String FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float    u_time;//随机数，可以把当前时间传进来\nlowp float u_contrast = 3.0;//对比度\nlowp float in_circle_radius;//从客户端传入的放大镜圆半径\nlowp vec2  in_circle_pos;\nuniform lowp float imageWidth;//从客户端传入的图片宽数据\nuniform lowp float imageHeight;//从客户端传入的图片高数据\nuniform lowp float scaleRate;\nuniform lowp int upOrDown;\nuniform lowp float brightness;//-0.5--0.5 曝光度\nlowp float alpha=0.5;//闪现层透明度\nlowp float baohedu=0.18;//饱和度\nhighp vec3 rgbtohsv(highp vec3 rgb)\n{\n    highp float R = rgb.x;\n    highp float G = rgb.y;\n    highp float B = rgb.z;\n    highp vec3 hsv;\n    highp float max1 = max(R, max(G, B));\n    highp float min1 = min(R, min(G, B));\n    if (R == max1)\n    {\n        hsv.x = (G - B) / (max1 - min1);\n    }\n    if (G == max1)\n    {\n        hsv.x = 2.0 + (B - R) / (max1 - min1);\n    }\n    if (B == max1)\n    {\n        hsv.x = 4.0 + (R - G) / (max1 - min1);\n    }\n    hsv.x = hsv.x * 60.0;\n    if (hsv.x < 0.0)\n    {\n        hsv.x = hsv.x + 360.0;\n    }\n    hsv.z = max1;\n    hsv.y = (max1 - min1) / max1;\n    return hsv;\n}\nhighp vec3 hsvtorgb(highp vec3 hsv)\n{\n    highp float R;\n    highp float G;\n    highp float B;\n    if (hsv.y == 0.0)\n    {\n        R = G = B = hsv.z;\n    }\n    else\n    {\n        hsv.x = hsv.x / 60.0;\n        int i = int(hsv.x);\n        highp float f = hsv.x - float(i);\n        highp float a = hsv.z * (1.0 - hsv.y);\n        highp float b = hsv.z * (1.0 - hsv.y * f);\n        highp float c = hsv.z * (1.0 - hsv.y * (1.0 - f));\n        if (i == 0)\n        {\n            R = hsv.z;\n            G = c;\n            B = a;\n        }\n        else if (i == 1)\n        {\n            R = b;\n            G = hsv.z;\n            B = a;\n        }\n        else if (i == 2)\n        {\n            R = a;\n            G = hsv.z;\n            B = c;\n        }\n        else if (i == 3)\n        {\n            R = a;\n            G = b;\n            B = hsv.z;\n        }\n        else if (i == 4)\n        {\n            R = c;\n            G = a;\n            B = hsv.z;\n        }\n        else\n        {\n            R = hsv.z;\n            G = a;\n            B = b;\n        }\n    }\n    return vec3(R, G, B);\n}\nhighp vec4 getFrontColor(sampler2D inputImageTexture, highp vec2 textureCoordinate)\n{\n    highp float y = textureCoordinate.y - 0.009*sin(((textureCoordinate.x+ u_time/100.0)*10.0 ));\n    highp vec3 color = texture2D(inputImageTexture, vec2(textureCoordinate.x, y)).rgb;\n    highp vec4 colorfrag =vec4(color,1.0);\n    return colorfrag;\n}\nhighp vec4 getBackColor(sampler2D inputImageTexture, highp vec2 textureCoordinate)\n{\n    highp vec2 uv = textureCoordinate.xy;\n    highp float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n    return texture2D(inputImageTexture, uv + vec2(waveu, 0));\n}\nhighp vec2 getZoomPosition(highp vec2 src)\n{\n    highp float zoom_x = (src.x - in_circle_pos.x) / 4.0;\n    highp float zoom_y = (src.y - in_circle_pos.y) / 4.0;\n    return vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\nhighp vec2 transForTexPosition(highp vec2 pos)\n{\n    return vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\nhighp vec4 getColor(highp vec2 src)//双线性插值采样\n{\n    highp vec2 pos = getZoomPosition(src);\n    \n    highp float _x = floor(pos.x);\n    \n    highp float _y = floor(pos.y);\n    \n    highp float u = pos.x - _x;\n    highp float v = pos.y - _y;\n    \n    highp vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    highp vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    highp vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    highp vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n    \n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\nvoid main()\n{\n    highp vec4 colorBack = getBackColor(inputImageTexture, textureCoordinate);\n    highp vec4 pixColor = colorBack;\n    highp vec3 hsv;\n    hsv.xyz = rgbtohsv(pixColor.rgb);\n    hsv.y *=baohedu;\n    highp vec3 f_color = hsvtorgb(hsv);\n    f_color = ((f_color - 0.5) * max(u_contrast+1.0, 0.0)) + 0.5;\n    highp vec4 textureColor =vec4(f_color , 1.0);\n    textureColor=vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n    highp vec4 colorFront =vec4(0.0/255.0, 142.0/255.0, 215.0/255.0, 1.0);//蓝色蒙层颜色\n    colorFront = vec4(mix(textureColor.rgb, colorFront.rgb, colorFront.a * 0.3), \t colorFront.a);\n    in_circle_pos=vec2(imageWidth/2.0,imageHeight/2.0);\n    in_circle_radius=imageWidth > imageHeight ? imageWidth : imageHeight;\n    in_circle_radius=in_circle_radius/2.0;\n    if(upOrDown==0){\n        highp vec2 textureCoordinateUse=textureCoordinate;\n        highp vec2 textureCoordinateUse2=vec2((textureCoordinateUse.x),(textureCoordinateUse.y+scaleRate));\n        highp vec4 sharpColor= getColor(vec2((textureCoordinateUse2.x)*imageWidth,(textureCoordinateUse2.y)*imageHeight));\n        gl_FragColor =vec4(mix(colorFront.rgb, sharpColor.rgb, sharpColor.a * alpha), \tsharpColor.a);\n    }else{\n        gl_FragColor =colorFront;\n    }\n}\n";
  private int mAlphaLocation;
  private float mBrightness = -0.5F;
  private int mBrightnessLocation;
  private boolean mDecreaseBrightness;
  private int mHeightLocation;
  private Random mRandom;
  private int mScaleRateLocation;
  private float mTime;
  private int mTimeLocation;
  private int mUpOrDownLocation;
  private int mWidthLocation;
  
  public QQAVImageGhostFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "uniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nuniform lowp float    u_time;//随机数，可以把当前时间传进来\nlowp float u_contrast = 3.0;//对比度\nlowp float in_circle_radius;//从客户端传入的放大镜圆半径\nlowp vec2  in_circle_pos;\nuniform lowp float imageWidth;//从客户端传入的图片宽数据\nuniform lowp float imageHeight;//从客户端传入的图片高数据\nuniform lowp float scaleRate;\nuniform lowp int upOrDown;\nuniform lowp float brightness;//-0.5--0.5 曝光度\nlowp float alpha=0.5;//闪现层透明度\nlowp float baohedu=0.18;//饱和度\nhighp vec3 rgbtohsv(highp vec3 rgb)\n{\n    highp float R = rgb.x;\n    highp float G = rgb.y;\n    highp float B = rgb.z;\n    highp vec3 hsv;\n    highp float max1 = max(R, max(G, B));\n    highp float min1 = min(R, min(G, B));\n    if (R == max1)\n    {\n        hsv.x = (G - B) / (max1 - min1);\n    }\n    if (G == max1)\n    {\n        hsv.x = 2.0 + (B - R) / (max1 - min1);\n    }\n    if (B == max1)\n    {\n        hsv.x = 4.0 + (R - G) / (max1 - min1);\n    }\n    hsv.x = hsv.x * 60.0;\n    if (hsv.x < 0.0)\n    {\n        hsv.x = hsv.x + 360.0;\n    }\n    hsv.z = max1;\n    hsv.y = (max1 - min1) / max1;\n    return hsv;\n}\nhighp vec3 hsvtorgb(highp vec3 hsv)\n{\n    highp float R;\n    highp float G;\n    highp float B;\n    if (hsv.y == 0.0)\n    {\n        R = G = B = hsv.z;\n    }\n    else\n    {\n        hsv.x = hsv.x / 60.0;\n        int i = int(hsv.x);\n        highp float f = hsv.x - float(i);\n        highp float a = hsv.z * (1.0 - hsv.y);\n        highp float b = hsv.z * (1.0 - hsv.y * f);\n        highp float c = hsv.z * (1.0 - hsv.y * (1.0 - f));\n        if (i == 0)\n        {\n            R = hsv.z;\n            G = c;\n            B = a;\n        }\n        else if (i == 1)\n        {\n            R = b;\n            G = hsv.z;\n            B = a;\n        }\n        else if (i == 2)\n        {\n            R = a;\n            G = hsv.z;\n            B = c;\n        }\n        else if (i == 3)\n        {\n            R = a;\n            G = b;\n            B = hsv.z;\n        }\n        else if (i == 4)\n        {\n            R = c;\n            G = a;\n            B = hsv.z;\n        }\n        else\n        {\n            R = hsv.z;\n            G = a;\n            B = b;\n        }\n    }\n    return vec3(R, G, B);\n}\nhighp vec4 getFrontColor(sampler2D inputImageTexture, highp vec2 textureCoordinate)\n{\n    highp float y = textureCoordinate.y - 0.009*sin(((textureCoordinate.x+ u_time/100.0)*10.0 ));\n    highp vec3 color = texture2D(inputImageTexture, vec2(textureCoordinate.x, y)).rgb;\n    highp vec4 colorfrag =vec4(color,1.0);\n    return colorfrag;\n}\nhighp vec4 getBackColor(sampler2D inputImageTexture, highp vec2 textureCoordinate)\n{\n    highp vec2 uv = textureCoordinate.xy;\n    highp float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n    return texture2D(inputImageTexture, uv + vec2(waveu, 0));\n}\nhighp vec2 getZoomPosition(highp vec2 src)\n{\n    highp float zoom_x = (src.x - in_circle_pos.x) / 4.0;\n    highp float zoom_y = (src.y - in_circle_pos.y) / 4.0;\n    return vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\nhighp vec2 transForTexPosition(highp vec2 pos)\n{\n    return vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\nhighp vec4 getColor(highp vec2 src)//双线性插值采样\n{\n    highp vec2 pos = getZoomPosition(src);\n    \n    highp float _x = floor(pos.x);\n    \n    highp float _y = floor(pos.y);\n    \n    highp float u = pos.x - _x;\n    highp float v = pos.y - _y;\n    \n    highp vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    highp vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    highp vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    highp vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n    \n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\nvoid main()\n{\n    highp vec4 colorBack = getBackColor(inputImageTexture, textureCoordinate);\n    highp vec4 pixColor = colorBack;\n    highp vec3 hsv;\n    hsv.xyz = rgbtohsv(pixColor.rgb);\n    hsv.y *=baohedu;\n    highp vec3 f_color = hsvtorgb(hsv);\n    f_color = ((f_color - 0.5) * max(u_contrast+1.0, 0.0)) + 0.5;\n    highp vec4 textureColor =vec4(f_color , 1.0);\n    textureColor=vec4((textureColor.rgb + vec3(brightness)), textureColor.w);\n    highp vec4 colorFront =vec4(0.0/255.0, 142.0/255.0, 215.0/255.0, 1.0);//蓝色蒙层颜色\n    colorFront = vec4(mix(textureColor.rgb, colorFront.rgb, colorFront.a * 0.3), \t colorFront.a);\n    in_circle_pos=vec2(imageWidth/2.0,imageHeight/2.0);\n    in_circle_radius=imageWidth > imageHeight ? imageWidth : imageHeight;\n    in_circle_radius=in_circle_radius/2.0;\n    if(upOrDown==0){\n        highp vec2 textureCoordinateUse=textureCoordinate;\n        highp vec2 textureCoordinateUse2=vec2((textureCoordinateUse.x),(textureCoordinateUse.y+scaleRate));\n        highp vec4 sharpColor= getColor(vec2((textureCoordinateUse2.x)*imageWidth,(textureCoordinateUse2.y)*imageHeight));\n        gl_FragColor =vec4(mix(colorFront.rgb, sharpColor.rgb, sharpColor.a * alpha), \tsharpColor.a);\n    }else{\n        gl_FragColor =colorFront;\n    }\n}\n");
    super.setQQAVEffectType(1010);
    this.mRandom = new Random();
  }
  
  private float getRandomDis()
  {
    float f2 = this.mRandom.nextInt(16) / 10.0F;
    float f1 = f2;
    if (this.mRandom.nextBoolean()) {
      f1 = -f2;
    }
    return f1;
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    float f = this.mTime;
    if (f < 1000000.0F)
    {
      this.mTime = (f + 1.0F);
      setFloat(this.mTimeLocation, this.mTime);
    }
    else
    {
      this.mTime = 0.0F;
    }
    f = this.mRandom.nextInt() % 4 / 10.0F;
    setFloat(this.mAlphaLocation, f);
    int i = this.mRandom.nextInt(16);
    setInteger(this.mUpOrDownLocation, i);
    setFloat(this.mScaleRateLocation, getRandomDis());
    if (this.mDecreaseBrightness)
    {
      f = this.mBrightness;
      if (f > -0.5F) {
        this.mBrightness = (f - 0.02F);
      } else {
        this.mDecreaseBrightness = false;
      }
    }
    else
    {
      f = this.mBrightness;
      if (f < 0.5F)
      {
        double d = f;
        Double.isNaN(d);
        this.mBrightness = ((float)(d + 0.02D));
      }
      else
      {
        this.mDecreaseBrightness = true;
      }
    }
    setFloat(this.mBrightnessLocation, this.mBrightness);
    super.onDraw2(paramInt1, paramInt2);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.mTimeLocation = GLES20.glGetUniformLocation(getProgram(), "u_time");
    this.mAlphaLocation = GLES20.glGetUniformLocation(getProgram(), "alpha");
    this.mUpOrDownLocation = GLES20.glGetUniformLocation(getProgram(), "upOrDown");
    this.mScaleRateLocation = GLES20.glGetUniformLocation(getProgram(), "scaleRate");
    this.mBrightnessLocation = GLES20.glGetUniformLocation(getProgram(), "brightness");
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.mWidthLocation, paramInt1);
    setFloat(this.mHeightLocation, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGhostFilter
 * JD-Core Version:    0.7.0.1
 */