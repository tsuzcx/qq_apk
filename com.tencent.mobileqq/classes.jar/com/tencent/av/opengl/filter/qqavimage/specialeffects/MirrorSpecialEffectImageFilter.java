package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

public class MirrorSpecialEffectImageFilter
  extends QQAVImageFilter
{
  private static long a;
  protected int a;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private int c;
  private int d = 1006;
  
  static
  {
    jdField_a_of_type_Long = 500L;
  }
  
  public MirrorSpecialEffectImageFilter(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n//Android这里从屏幕向左横屏为0，顺时针依次+90，因为纹理坐标并没有变化，这里对不同方向做处理，使中间内容在\n//左边，然后右边做镜像\nconst int ORIENTATION_0 = 1;\nconst int ORIENTATION_90 = 2;\nconst int ORIENTATION_180 = 3;\nconst int ORIENTATION_270 = 4;\nuniform int deviceOrientation;\n\nvoid main()\n{\n   highp vec2 textureCoordinateToUse = textureCoordinate;\n   if (deviceOrientation == ORIENTATION_0) {\n        if (textureCoordinateToUse.y < 0.5) {\n           textureCoordinateToUse.y = 1.0 - (textureCoordinateToUse.y + 0.25); \n        } else {\n           textureCoordinateToUse.y = textureCoordinateToUse.y - 0.25;\n        }\n   } else if (deviceOrientation == ORIENTATION_90) {\n        if (textureCoordinateToUse.x < 0.5) {\n           textureCoordinateToUse.x = textureCoordinateToUse.x + 0.25; \n        } else {\n           textureCoordinateToUse.x = 1.0 - (textureCoordinateToUse.x - 0.25);\n        }\n   } else if (deviceOrientation == ORIENTATION_180) {\n       if (textureCoordinateToUse.y < 0.5) {\n           textureCoordinateToUse.y = textureCoordinateToUse.y + 0.25; \n       } else {\n           textureCoordinateToUse.y = 1.0 - (textureCoordinateToUse.y - 0.25);\n       }\n   } else if (deviceOrientation == ORIENTATION_270) {\n        if (textureCoordinateToUse.x < 0.5) {\n           textureCoordinateToUse.x = 1.0 - (textureCoordinateToUse.x + 0.25); \n        } else {\n           textureCoordinateToUse.x = textureCoordinateToUse.x - 0.25;\n       }\n   } \n   gl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse);\n}");
    super.setQQAVEffectType(paramInt);
    this.d = paramInt;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt)
  {
    int i = paramInt;
    if (this.d == 1016) {
      switch (paramInt)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      setInteger(this.c, i);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 1;
    }
  }
  
  public void onDraw2(int paramInt1, int paramInt2)
  {
    int j = 2;
    long l = System.currentTimeMillis();
    int i;
    if (l - this.jdField_b_of_type_Long > jdField_a_of_type_Long)
    {
      i = j;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int != i)
      {
        this.jdField_b_of_type_Long = l;
        this.jdField_b_of_type_Int = i;
        b(i);
      }
      super.onDraw2(paramInt1, paramInt2);
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.c = GLES20.glGetUniformLocation(getProgram(), "deviceOrientation");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    b(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.specialeffects.MirrorSpecialEffectImageFilter
 * JD-Core Version:    0.7.0.1
 */