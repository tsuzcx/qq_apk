package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;

public class PathParser$PathDataNode
{
  public float[] mParams;
  public char mType;
  
  PathParser$PathDataNode(char paramChar, float[] paramArrayOfFloat)
  {
    this.mType = paramChar;
    this.mParams = paramArrayOfFloat;
  }
  
  PathParser$PathDataNode(PathDataNode paramPathDataNode)
  {
    this.mType = paramPathDataNode.mType;
    this.mParams = PathParser.copyOfRange(paramPathDataNode.mParams, 0, paramPathDataNode.mParams.length);
  }
  
  private static void addCommand(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
  {
    float f6 = paramArrayOfFloat1[0];
    float f5 = paramArrayOfFloat1[1];
    float f4 = paramArrayOfFloat1[2];
    float f3 = paramArrayOfFloat1[3];
    float f1 = paramArrayOfFloat1[4];
    float f2 = paramArrayOfFloat1[5];
    char c1;
    int i;
    label212:
    float f7;
    float f8;
    switch (paramChar2)
    {
    default: 
      c1 = '\002';
      char c2 = '\000';
      i = paramChar1;
      paramChar1 = c2;
      if (paramChar1 < paramArrayOfFloat2.length) {
        switch (paramChar2)
        {
        default: 
          f7 = f2;
          f2 = f3;
          f3 = f1;
          f1 = f7;
        }
      }
      break;
    case 'Z': 
    case 'z': 
    case 'L': 
    case 'M': 
    case 'T': 
    case 'l': 
    case 'm': 
    case 't': 
    case 'H': 
    case 'V': 
    case 'h': 
    case 'v': 
    case 'C': 
    case 'c': 
    case 'Q': 
    case 'S': 
    case 'q': 
    case 's': 
    case 'A': 
    case 'a': 
      for (;;)
      {
        paramChar1 += c1;
        f7 = f3;
        i = paramChar2;
        f3 = f2;
        f2 = f1;
        f1 = f7;
        break label212;
        paramPath.close();
        paramPath.moveTo(f1, f2);
        f3 = f2;
        f4 = f1;
        f5 = f2;
        f6 = f1;
        c1 = '\002';
        break;
        c1 = '\002';
        break;
        c1 = '\001';
        break;
        c1 = '\006';
        break;
        c1 = '\004';
        break;
        c1 = '\007';
        break;
        f6 += paramArrayOfFloat2[(paramChar1 + '\000')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\001')] + f5;
        if (paramChar1 > 0)
        {
          paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
          f7 = f1;
          f1 = f2;
          f2 = f3;
          f3 = f7;
        }
        else
        {
          paramPath.rMoveTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
          f8 = f5;
          f7 = f6;
          f2 = f3;
          f1 = f5;
          f3 = f6;
          f5 = f8;
          f6 = f7;
          continue;
          f5 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
          if (paramChar1 > 0)
          {
            paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f7 = f5;
            f5 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f5;
            f5 = f6;
            f6 = f7;
          }
          else
          {
            paramPath.moveTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f8 = f6;
            f7 = f5;
            f2 = f3;
            f1 = f6;
            f3 = f5;
            f5 = f8;
            f6 = f7;
            continue;
            paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f8 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
            f7 += f5;
            f6 += f8;
            f5 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f5;
            f5 = f7;
            continue;
            paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
            f6 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f5 = paramArrayOfFloat2[(paramChar1 + '\001')];
            f7 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f7;
            continue;
            paramPath.rLineTo(paramArrayOfFloat2[(paramChar1 + '\000')], 0.0F);
            f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f7 = f6 + f7;
            f6 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f6;
            f6 = f7;
            continue;
            paramPath.lineTo(paramArrayOfFloat2[(paramChar1 + '\000')], f5);
            f6 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f7 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f7;
            continue;
            paramPath.rLineTo(0.0F, paramArrayOfFloat2[(paramChar1 + '\000')]);
            f8 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f7 = f1;
            f5 = f8 + f5;
            f1 = f2;
            f2 = f3;
            f3 = f7;
            continue;
            paramPath.lineTo(f6, paramArrayOfFloat2[(paramChar1 + '\000')]);
            f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
            f5 = f1;
            f1 = f2;
            f2 = f3;
            f3 = f5;
            f5 = f7;
            continue;
            paramPath.rCubicTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')], paramArrayOfFloat2[(paramChar1 + '\004')], paramArrayOfFloat2[(paramChar1 + '\005')]);
            f4 = paramArrayOfFloat2[(paramChar1 + '\002')];
            f8 = paramArrayOfFloat2[(paramChar1 + '\003')];
            f3 = paramArrayOfFloat2[(paramChar1 + '\004')];
            f7 = paramArrayOfFloat2[(paramChar1 + '\005')];
            f4 = f6 + f4;
            f7 += f5;
            f6 += f3;
            f3 = f1;
            f5 = f8 + f5;
            f1 = f2;
            f2 = f5;
            f5 = f7;
            continue;
            paramPath.cubicTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')], paramArrayOfFloat2[(paramChar1 + '\004')], paramArrayOfFloat2[(paramChar1 + '\005')]);
            f6 = paramArrayOfFloat2[(paramChar1 + '\004')];
            f5 = paramArrayOfFloat2[(paramChar1 + '\005')];
            f4 = paramArrayOfFloat2[(paramChar1 + '\002')];
            f7 = paramArrayOfFloat2[(paramChar1 + '\003')];
            f3 = f1;
            f1 = f2;
            f2 = f7;
          }
        }
      }
      if ((i == 99) || (i == 115) || (i == 67) || (i == 83))
      {
        f7 = f6 - f4;
        f4 = f5 - f3;
      }
      break;
    }
    for (f3 = f7;; f3 = 0.0F)
    {
      paramPath.rCubicTo(f3, f4, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
      f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
      f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
      f3 = paramArrayOfFloat2[(paramChar1 + '\002')];
      f7 = paramArrayOfFloat2[(paramChar1 + '\003')];
      f4 = f6 + f4;
      f7 += f5;
      f6 += f3;
      f3 = f1;
      f5 = f8 + f5;
      f1 = f2;
      f2 = f5;
      f5 = f7;
      break;
      if ((i == 99) || (i == 115) || (i == 67) || (i == 83))
      {
        f4 = 2.0F * f6 - f4;
        f5 = 2.0F * f5 - f3;
      }
      for (f3 = f4;; f3 = f6)
      {
        paramPath.cubicTo(f3, f5, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f6 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f3 = f1;
        f1 = f2;
        f2 = f7;
        break;
        paramPath.rQuadTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f3 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f4 = f6 + f4;
        f7 += f5;
        f6 += f3;
        f3 = f1;
        f5 = f8 + f5;
        f1 = f2;
        f2 = f5;
        f5 = f7;
        break;
        paramPath.quadTo(paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')], paramArrayOfFloat2[(paramChar1 + '\002')], paramArrayOfFloat2[(paramChar1 + '\003')]);
        f4 = paramArrayOfFloat2[(paramChar1 + '\000')];
        f7 = paramArrayOfFloat2[(paramChar1 + '\001')];
        f6 = paramArrayOfFloat2[(paramChar1 + '\002')];
        f5 = paramArrayOfFloat2[(paramChar1 + '\003')];
        f3 = f1;
        f1 = f2;
        f2 = f7;
        break;
        if ((i == 113) || (i == 116) || (i == 81) || (i == 84))
        {
          f4 = f6 - f4;
          f3 = f5 - f3;
        }
        for (;;)
        {
          paramPath.rQuadTo(f4, f3, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
          float f9 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f7 = f6 + f4;
          f8 += f5;
          f6 += f9;
          f4 = f1;
          f3 += f5;
          f1 = f2;
          f2 = f3;
          f3 = f4;
          f4 = f7;
          f5 = f8;
          break;
          if ((i != 113) && (i != 116) && (i != 81))
          {
            f8 = f5;
            f7 = f6;
            if (i != 84) {}
          }
          else
          {
            f7 = 2.0F * f6 - f4;
            f8 = 2.0F * f5 - f3;
          }
          paramPath.quadTo(f7, f8, paramArrayOfFloat2[(paramChar1 + '\000')], paramArrayOfFloat2[(paramChar1 + '\001')]);
          f6 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f5 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f4 = f7;
          f3 = f1;
          f1 = f2;
          f2 = f8;
          break;
          f3 = paramArrayOfFloat2[(paramChar1 + '\005')];
          f4 = paramArrayOfFloat2[(paramChar1 + '\006')];
          f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
          boolean bool1;
          if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F)
          {
            bool1 = true;
            label1974:
            if (paramArrayOfFloat2[(paramChar1 + '\004')] == 0.0F) {
              break label2068;
            }
          }
          label2068:
          for (boolean bool2 = true;; bool2 = false)
          {
            drawArc(paramPath, f6, f5, f3 + f6, f4 + f5, f7, f8, f9, bool1, bool2);
            f6 += paramArrayOfFloat2[(paramChar1 + '\005')];
            f7 = paramArrayOfFloat2[(paramChar1 + '\006')] + f5;
            f3 = f1;
            f4 = f6;
            f5 = f7;
            f1 = f2;
            f2 = f7;
            break;
            bool1 = false;
            break label1974;
          }
          f3 = paramArrayOfFloat2[(paramChar1 + '\005')];
          f4 = paramArrayOfFloat2[(paramChar1 + '\006')];
          f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
          f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
          f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
          if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F)
          {
            bool1 = true;
            label2129:
            if (paramArrayOfFloat2[(paramChar1 + '\004')] == 0.0F) {
              break label2211;
            }
          }
          label2211:
          for (bool2 = true;; bool2 = false)
          {
            drawArc(paramPath, f6, f5, f3, f4, f7, f8, f9, bool1, bool2);
            f6 = paramArrayOfFloat2[(paramChar1 + '\005')];
            f7 = paramArrayOfFloat2[(paramChar1 + '\006')];
            f3 = f1;
            f4 = f6;
            f5 = f7;
            f1 = f2;
            f2 = f7;
            break;
            bool1 = false;
            break label2129;
          }
          paramArrayOfFloat1[0] = f6;
          paramArrayOfFloat1[1] = f5;
          paramArrayOfFloat1[2] = f4;
          paramArrayOfFloat1[3] = f3;
          paramArrayOfFloat1[4] = f1;
          paramArrayOfFloat1[5] = f2;
          return;
          f3 = 0.0F;
          f4 = 0.0F;
        }
      }
      f4 = 0.0F;
    }
  }
  
  private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    int j = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
    double d6 = Math.cos(paramDouble7);
    double d7 = Math.sin(paramDouble7);
    paramDouble7 = Math.cos(paramDouble8);
    double d2 = Math.sin(paramDouble8);
    double d3 = -paramDouble3;
    double d1 = -paramDouble3;
    double d8 = paramDouble9 / j;
    int i = 0;
    d1 = d2 * (d1 * d7) + paramDouble7 * (paramDouble4 * d6);
    d2 = d3 * d6 * d2 - paramDouble4 * d7 * paramDouble7;
    paramDouble9 = paramDouble8;
    paramDouble8 = paramDouble6;
    paramDouble7 = paramDouble5;
    paramDouble6 = d2;
    for (paramDouble5 = d1; i < j; paramDouble5 = d3)
    {
      double d4 = paramDouble9 + d8;
      d3 = Math.sin(d4);
      double d9 = Math.cos(d4);
      d1 = paramDouble3 * d6 * d9 + paramDouble1 - paramDouble4 * d7 * d3;
      d2 = paramDouble4 * d6 * d3 + (paramDouble3 * d7 * d9 + paramDouble2);
      double d5 = -paramDouble3 * d6 * d3 - paramDouble4 * d7 * d9;
      d3 = d9 * (paramDouble4 * d6) + d3 * (-paramDouble3 * d7);
      d9 = Math.tan((d4 - paramDouble9) / 2.0D);
      paramDouble9 = Math.sin(d4 - paramDouble9);
      paramDouble9 = (Math.sqrt(d9 * (3.0D * d9) + 4.0D) - 1.0D) * paramDouble9 / 3.0D;
      paramPath.rLineTo(0.0F, 0.0F);
      paramPath.cubicTo((float)(paramDouble6 * paramDouble9 + paramDouble7), (float)(paramDouble8 + paramDouble5 * paramDouble9), (float)(d1 - paramDouble9 * d5), (float)(d2 - paramDouble9 * d3), (float)d1, (float)d2);
      i += 1;
      paramDouble6 = d5;
      paramDouble9 = d4;
      paramDouble8 = d2;
      paramDouble7 = d1;
    }
  }
  
  private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d5 = Math.toRadians(paramFloat7);
    double d6 = Math.cos(d5);
    double d7 = Math.sin(d5);
    double d8 = (paramFloat1 * d6 + paramFloat2 * d7) / paramFloat5;
    double d9 = (-paramFloat1 * d7 + paramFloat2 * d6) / paramFloat6;
    double d1 = (paramFloat3 * d6 + paramFloat4 * d7) / paramFloat5;
    double d4 = (-paramFloat3 * d7 + paramFloat4 * d6) / paramFloat6;
    double d11 = d8 - d1;
    double d10 = d9 - d4;
    double d3 = (d8 + d1) / 2.0D;
    double d2 = (d9 + d4) / 2.0D;
    double d12 = d11 * d11 + d10 * d10;
    if (d12 == 0.0D)
    {
      Log.w("PathParser", " Points are coincident");
      return;
    }
    double d13 = 1.0D / d12 - 0.25D;
    if (d13 < 0.0D)
    {
      Log.w("PathParser", "Points are too far apart " + d12);
      float f = (float)(Math.sqrt(d12) / 1.99999D);
      drawArc(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
      return;
    }
    d12 = Math.sqrt(d13);
    d11 *= d12;
    d10 *= d12;
    if (paramBoolean1 == paramBoolean2)
    {
      d3 -= d10;
      d2 = d11 + d2;
      d8 = Math.atan2(d9 - d2, d8 - d3);
      d4 = Math.atan2(d4 - d2, d1 - d3) - d8;
      if (d4 < 0.0D) {
        break label427;
      }
      paramBoolean1 = true;
      label325:
      d1 = d4;
      if (paramBoolean2 != paramBoolean1) {
        if (d4 <= 0.0D) {
          break label433;
        }
      }
    }
    label427:
    label433:
    for (d1 = d4 - 6.283185307179586D;; d1 = d4 + 6.283185307179586D)
    {
      d3 = paramFloat5 * d3;
      d2 *= paramFloat6;
      arcToBezier(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, paramFloat5, paramFloat6, paramFloat1, paramFloat2, d5, d8, d1);
      return;
      d3 = d10 + d3;
      d2 -= d11;
      break;
      paramBoolean1 = false;
      break label325;
    }
  }
  
  public static void nodesToPath(PathDataNode[] paramArrayOfPathDataNode, Path paramPath)
  {
    float[] arrayOfFloat = new float[6];
    char c = 'm';
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      addCommand(paramPath, arrayOfFloat, c, paramArrayOfPathDataNode[i].mType, paramArrayOfPathDataNode[i].mParams);
      c = paramArrayOfPathDataNode[i].mType;
      i += 1;
    }
  }
  
  public void interpolatePathDataNode(PathDataNode paramPathDataNode1, PathDataNode paramPathDataNode2, float paramFloat)
  {
    this.mType = paramPathDataNode1.mType;
    int i = 0;
    while (i < paramPathDataNode1.mParams.length)
    {
      this.mParams[i] = (paramPathDataNode1.mParams[i] * (1.0F - paramFloat) + paramPathDataNode2.mParams[i] * paramFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.PathParser.PathDataNode
 * JD-Core Version:    0.7.0.1
 */