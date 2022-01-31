package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.sveffects.SdkContext;
import java.util.Random;
import jjw;

public class QQAVImageWrongEraseFilter
  extends QQAVImageFilter
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = 0;
  private int k;
  
  public QQAVImageWrongEraseFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nuniform sampler2D           inputImageTexture;\nvarying vec2                textureCoordinate;\nvec2    textureCoordinateUse;\nuniform float  imageWidth;\nuniform float  imageHeight;\nuniform float  u_time;\nuniform vec4 errorElement[10];\nuniform int errorNum;\nuniform int redIndex;//红色擦除index\nuniform int greenIndex;//绿色擦除index\nfloat  X;\nfloat  Y;\nfloat  Width;\nfloat  Height;\nvec4 color;\nuniform float waveHeight;\nuniform float noise; // 随机数，0 - 10\n\nfloat pi = 3.14159265359;\nfloat bbsm = 11.0;\n\nvec2 bbsopt(in vec2 a){\n    return fract(a*a*(1./bbsm))*bbsm;\n}\n\nvec2 mod1024(in vec2 a){\n    return fract(a*(1./0.3))*1411.;\n}\nvec4 hash(in vec2 pos){\n    vec2 a0 = mod1024(pos*pi);\n    vec2 a1 = bbsopt(a0);\n    vec2 a2 = a1.yx + bbsopt(a1);\n    vec2 a3 = a2.yx + bbsopt(a2);\n    return fract((a2.xyxy + a3.xxyy + a1.xyyx)*(1./bbsm));\n}\nvec3 rgbtohsv(vec3 rgb)\n{\n    float R = rgb.x;\n    float G = rgb.y;\n    float B = rgb.z;\n    vec3 hsv;\n    float max1 = max(R, max(G, B));\n    float min1 = min(R, min(G, B));\n    if (R == max1)\n    {\n        hsv.x = (G - B) / (max1 - min1);\n    }\n    if (G == max1)\n    {\n        hsv.x = 2.0 + (B - R) / (max1 - min1);\n    }\n    if (B == max1)\n    {\n        hsv.x = 4.0 + (R - G) / (max1 - min1);\n    }\n    hsv.x = hsv.x * 60.0;\n    if (hsv.x < 0.0)\n    {\n        hsv.x = hsv.x + 360.0;\n    }\n    hsv.z = max1;\n    hsv.y = (max1 - min1) / max1;\n    return hsv;\n}\n\nvec3 hsvtorgb(vec3 hsv)\n{\n    float R;\n    float G;\n    float B;\n    if (hsv.y == 0.0)\n    {\n        R = G = B = hsv.z;\n    }\n    else\n    {\n        hsv.x = hsv.x / 60.0;\n        int i = int(hsv.x);\n        float f = hsv.x - float(i);\n        float a = hsv.z * (1.0 - hsv.y);\n        float b = hsv.z * (1.0 - hsv.y * f);\n        float c = hsv.z * (1.0 - hsv.y * (1.0 - f));\n        if (i == 0)\n        {\n            R = hsv.z;\n            G = c;\n            B = a;\n        }\n        else if (i == 1)\n        {\n            R = b;\n            G = hsv.z;\n            B = a;\n        }\n        else if (i == 2)\n        {\n            R = a;\n            G = hsv.z;\n            B = c;\n        }\n        else if (i == 3)\n        {\n            R = a;\n            G = b;\n            B = hsv.z;\n        }\n        else if (i == 4)\n        {\n            R = c;\n            G = a;\n            B = hsv.z;\n        }\n        else\n        {\n            R = hsv.z;\n            G = a;\n            B = b;\n        }\n    }\n    return vec3(R, G, B);\n}\n\nvec4 getMixColor(vec4 backCol)\n{\n    vec3 backHSV = rgbtohsv(backCol.xyz);\n    backHSV.x = 0.0;\n    backHSV.y = 0.0;\n    vec3 rgb = hsvtorgb(backHSV);\n    return vec4(rgb, backCol.w);\n}\nfloat getSuperpositionColSingle(float col1, float col2)\n{\n    if (col1 < 0.5) {\n        return col1 * col2 / 0.5;\n    } else {\n        return 1.0 - (1.0 - col1) * (1.0 - col2) / 0.5;\n    }\n}\n//叠加两个颜色，对应ps里的叠加混合模式\nvec4 getSuperpositionCol(vec4 col1, vec4 col2)\n{\n    vec4 col;\n    col.x = getSuperpositionColSingle(col1.x, col2.x);\n    col.y = getSuperpositionColSingle(col1.y, col2.y);\n    col.z = getSuperpositionColSingle(col1.z, col2.z);\n    col.w = 1.0;\n    return col;\n}\nfloat getAddedColorLS(float col1, float col2)\n{\n    col1= col1*255.0;\n    col2= col2*255.0;\n    float color=255.0 -( ((255.0 - col1) * (255.0 - col2))/256.0);\n    return color/255.0;\n}\n//叠加两个颜色，对应ps里的滤色\nvec4 getSuperpositionColLS(vec4 col1, vec4 col2)\n{\n    vec4 col;\n    col.x = getAddedColorLS(col1.x, col2.x);\n    col.y = getAddedColorLS(col1.y, col2.y);\n    col.z = getAddedColorLS(col1.z, col2.z);\n    col.w = 1.0;\n    return col;\n}\nvec4 getErrorColor(sampler2D inputImageTexture,vec2 textureCoordinate)\n{\n    vec4 backColorBlue = texture2D(inputImageTexture,vec2((textureCoordinate.x+10.0/imageWidth), textureCoordinate.y));\n    backColorBlue = getMixColor(backColorBlue);\n    vec4 backColorRed = texture2D(inputImageTexture,vec2((textureCoordinate.x-10.0/imageWidth), textureCoordinate.y));\n    backColorRed = getMixColor(backColorRed);\n    vec4 colorFrontBlue = vec4(32.0 / 255.0, 22.0 / 255.0, 233.0 / 255.0, 1.0);\n    vec4 colorFrontRed = vec4(229.0 / 255.0, 23.0 / 255.0, 26.0 / 255.0, 1.0);\n    colorFrontBlue = getSuperpositionCol(backColorBlue, colorFrontBlue);\n    colorFrontRed = getSuperpositionCol(backColorRed, colorFrontRed);\n    return getSuperpositionColLS(colorFrontBlue, colorFrontRed);\n}\n\n\n\nfloat lumin( vec4 color ) { return dot( color, vec4( 0.0, 109.0 / 255.0, 1.0, 0.0 ) ); }\n\nvec4 filterByColor( vec4 color, vec4 filter )\n{\n    float lumOld = lumin( color );\n    color *= filter;\n    float lumNew = lumin( color );\n    \n    return color * ( lumOld / lumNew );\n}\n\nvec4 getColdColor(vec4 color)\n{\n    vec4 filterColorCold = vec4( 1.0, 1.1515, 1.33, 1.0 );\n    \n    vec4 colorCold = filterByColor( color, filterColorCold );\n    \n    return colorCold;\n}\nvec4 getLineColor(vec2 uv, vec4 srcColor)\n{\n    float y = mod(floor(uv.y * imageHeight / 4.0), 2.0);\n    vec4 colorLine;\n    vec4 origColor = srcColor ;//texture2D(inputImageTexture, uv);\n    if (y == 0.0) {\n        colorLine = vec4(origColor.r, 0.0, 0.0, 1.0);\n    } else {\n        colorLine = vec4(0.0, origColor.g, origColor.b, 1.0);\n    }\n    return colorLine;\n}\nfloat rng2(vec2 seed)\n{\n    return fract(sin(dot(seed * 12.0, vec2(127.1,311.7))) * 43758.5453123);\n}\nvec2 getBackColor( vec2 textureCoordinate)\n{\n    vec2 uv = textureCoordinate.xy;\n    float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n    return uv + vec2(waveu, 0);\n//    return texture2D(inputImageTexture, uv + vec2(waveu, 0));\n}\nvec4 getBackColorInOldTV(vec2 textureCoordinate)\n{\n    vec2 uv = textureCoordinate.xy;\n    float waveu = (cos((uv.y + u_time/50.0) * 5.0)+0.1)*(sin((uv.y + u_time/50.0) * 12.0) +0.1)* waveHeight;\n    float disX = waveu+ uv.x;\n    textureCoordinateUse=vec2(disX, uv.y);\n    if ((disX >-0.5/imageWidth && disX < 1.5/imageWidth)||(disX >1.0 && disX < 1.0+2.0/imageWidth)) {\n        return vec4(0.0, 0.0, 0.0, 1.0);\n    } else {\n        textureCoordinateUse=vec2(disX, uv.y);\n        return texture2D(inputImageTexture, textureCoordinateUse);\n    }\n    \n}\nvec4 getNoiseColor(vec2 textureCoordinate)\n{\n    vec2 fragCoord = vec2(textureCoordinate.x * imageWidth / 1.5, textureCoordinate.y * \timageHeight / 1.5);\n    vec2 scale = vec2(1.0 + noise, 1.0);\n    const int num = 2; //average multiple instances\n    \n    vec2 p = scale*floor(fragCoord.xy);\n    \n    vec4 c = vec4(0.0);\n    for(int i=0; i<num; i++) {\n        c+= hash(p+float(i*1024));\n    }\n    vec4 color = getBackColorInOldTV(textureCoordinate);\n    \n    return color + vec4(c.x,c.y,c.z,1.0) / 10.0;\n    \n}\n\nvec4 getOldTV(){\n    vec4 colorNoise = getNoiseColor(textureCoordinate);\n    vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    vec4 coldColor  = getColdColor(colorNoise);//冷却滤镜\n    vec4 lineColor = getLineColor(textureCoordinate, coldColor);//模拟电视线条效果\n    return vec4(mix(coldColor.rgb, lineColor.rgb, lineColor.a * 0.3), 1.0);\n}\nvoid main() {\n    bool colorFlag=true;\n    for(int i=0;i<errorNum;i++){\n        vec4 element=errorElement[i];\n        if(element.x==0.0){//从左边开始\n            X=0.0;\n        }else{//从右边开始\n            X=(1.0-element.z)*imageWidth;\n        }\n        Y=element.y*imageHeight;\n        Width=element.z*imageWidth;\n        Height=element.w;\n//\n        if(gl_FragCoord.x>X&&gl_FragCoord.x<X+Width&&gl_FragCoord.y>Y&&gl_FragCoord.y<Y+Height){\n            vec2 sinBackColor = getBackColor(textureCoordinate);\n            vec4 colorBack = texture2D(inputImageTexture, sinBackColor);\n            if (redIndex!=-1&&i == redIndex) {\n                color = getSuperpositionCol(colorBack, vec4(250.0 / 255.0, 0.0, 0.0, 1.0));\n            } else if (redIndex!=-1&&i == greenIndex) {\n                color = getSuperpositionCol(colorBack, vec4(25.0 / 255.0, 1.0, 1.0 / 255.0, 1.0));\n            } else {\n                color = getErrorColor(inputImageTexture, sinBackColor);\n            }\n            vec4 teleColor = getOldTV();\n            gl_FragColor=vec4(mix(color.rgb,teleColor.rgb,teleColor.a*0.3),1.0);\n            colorFlag=false;\n        }\n    }\n    if(colorFlag){\n        gl_FragColor=getOldTV();\n    }\n    \n}");
    super.setQQAVEffectType(1011);
    Application localApplication = SdkContext.a().a();
    if (localApplication != null) {
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = localApplication.getResources().getDisplayMetrics();
    }
    this.jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  private float a()
  {
    int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(5);
    float f1 = 0.0F;
    switch (m)
    {
    }
    for (;;)
    {
      return f1 * this.jdField_a_of_type_Float;
      f1 = 10.0F;
      continue;
      f1 = 20.0F;
      continue;
      f1 = 25.0F;
      continue;
      f1 = 35.0F;
      continue;
      f1 = 50.0F;
    }
  }
  
  private void a()
  {
    setInteger(this.d, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    int m = 0;
    int n;
    float[] arrayOfFloat;
    if (paramBoolean)
    {
      n = this.jdField_a_of_type_JavaUtilRandom.nextInt(2) + 1;
      int i2 = this.jdField_a_of_type_JavaUtilRandom.nextInt(2) + 1;
      i1 = n + i2 + 6;
      arrayOfFloat = new float[i1 * 4];
      int i3;
      while (m < n)
      {
        i3 = m * 4;
        arrayOfFloat[i3] = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
        arrayOfFloat[(i3 + 1)] = (this.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 10.0F);
        arrayOfFloat[(i3 + 2)] = 1.0F;
        arrayOfFloat[(i3 + 3)] = (50.0F * this.jdField_a_of_type_Float);
        m += 1;
      }
      m = n;
      while (m < n + i2)
      {
        i3 = m * 4;
        arrayOfFloat[i3] = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
        arrayOfFloat[(i3 + 1)] = (this.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 10.0F);
        arrayOfFloat[(i3 + 2)] = b();
        arrayOfFloat[(i3 + 3)] = (35.0F * this.jdField_a_of_type_Float);
        m += 1;
      }
      m = n + i2;
      while (m < n + i2 + 6)
      {
        i3 = m * 4;
        arrayOfFloat[i3] = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
        arrayOfFloat[(i3 + 1)] = (this.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 10.0F);
        arrayOfFloat[(i3 + 2)] = b();
        arrayOfFloat[(i3 + 3)] = a();
        m += 1;
      }
      setInteger(this.d, i1);
      a(this.c, i1, arrayOfFloat);
      m = i1;
      if (m > 0) {
        switch (this.jdField_a_of_type_JavaUtilRandom.nextInt(3))
        {
        default: 
          m = -1;
          n = -1;
        }
      }
    }
    for (;;)
    {
      if (n > -1) {
        setInteger(this.f, n);
      }
      if (m > -1) {
        setInteger(this.g, m);
      }
      return;
      n = this.jdField_a_of_type_JavaUtilRandom.nextInt(11);
      setInteger(this.d, n);
      arrayOfFloat = new float[n * 4];
      m = i1;
      while (m < n)
      {
        i1 = m * 4;
        arrayOfFloat[i1] = this.jdField_a_of_type_JavaUtilRandom.nextInt(2);
        arrayOfFloat[(i1 + 1)] = (this.jdField_a_of_type_JavaUtilRandom.nextInt(10) / 10.0F);
        arrayOfFloat[(i1 + 2)] = b();
        arrayOfFloat[(i1 + 3)] = a();
        m += 1;
      }
      a(this.c, n, arrayOfFloat);
      m = n;
      break;
      n = this.jdField_a_of_type_JavaUtilRandom.nextInt(m);
      m = this.jdField_a_of_type_JavaUtilRandom.nextInt(m);
      continue;
      n = this.jdField_a_of_type_JavaUtilRandom.nextInt(m);
      m = -1;
      continue;
      m = this.jdField_a_of_type_JavaUtilRandom.nextInt(m);
      n = -1;
    }
  }
  
  private float b()
  {
    int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(7);
    if (m >= 3) {
      return 1.0F;
    }
    switch (m)
    {
    default: 
      return 0.0F;
    case 0: 
      return 0.2F;
    case 1: 
      return 0.4F;
    case 2: 
      return 0.6F;
    }
    return 0.7F;
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    runOnDraw(new jjw(this, paramInt1, paramInt2, paramArrayOfFloat));
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    label52:
    label87:
    label106:
    int m;
    if ((l > 3000L) && (l < 3250L))
    {
      a(true);
      if (this.jdField_b_of_type_Float >= 0.0F)
      {
        this.jdField_b_of_type_Float -= 1.0F;
        setFloat(this.e, this.jdField_b_of_type_Float);
        if (this.jdField_b_of_type_Float % 100.0F >= 4.0F) {
          break label235;
        }
        setFloat(this.i, 0.87F);
        if (this.k >= 10) {
          break label248;
        }
        this.k += 1;
        setFloat(this.h, this.k);
        super.onDraw2(paramInt1, paramInt2);
      }
    }
    else
    {
      this.j += 1;
      if ((this.j == 2) || (this.j == 5)) {
        m = 1;
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          a(false);
          if (this.jdField_a_of_type_JavaUtilRandom.nextInt(10) <= 6) {
            break;
          }
          this.jdField_a_of_type_Boolean = true;
          break;
          if (this.j != 14) {
            break label256;
          }
          this.j = 0;
          m = 1;
          continue;
        }
        this.jdField_a_of_type_Boolean = false;
        break;
      }
      a();
      break;
      this.jdField_b_of_type_Float = 1000000.0F;
      break label52;
      label235:
      setFloat(this.i, 0.004F);
      break label87;
      label248:
      this.k = 0;
      break label106;
      label256:
      m = 0;
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    this.c = GLES20.glGetUniformLocation(getProgram(), "errorElement");
    this.d = GLES20.glGetUniformLocation(getProgram(), "errorNum");
    this.e = GLES20.glGetUniformLocation(getProgram(), "u_time");
    this.f = GLES20.glGetUniformLocation(getProgram(), "redIndex");
    this.g = GLES20.glGetUniformLocation(getProgram(), "greenIndex");
    this.h = GLES20.glGetUniformLocation(getProgram(), "noise");
    this.i = GLES20.glGetUniformLocation(getProgram(), "waveHeight");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Float = 1000000.0F;
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    setFloat(this.jdField_a_of_type_Int, paramInt1);
    setFloat(this.jdField_b_of_type_Int, paramInt2);
    this.jdField_a_of_type_Float = (paramInt2 / this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter
 * JD-Core Version:    0.7.0.1
 */