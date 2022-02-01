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
    paramPathDataNode = paramPathDataNode.mParams;
    this.mParams = PathParser.copyOfRange(paramPathDataNode, 0, paramPathDataNode.length);
  }
  
  private static void addCommand(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
  {
    float f7 = paramArrayOfFloat1[0];
    float f8 = paramArrayOfFloat1[1];
    float f9 = paramArrayOfFloat1[2];
    float f10 = paramArrayOfFloat1[3];
    float f6 = paramArrayOfFloat1[4];
    float f5 = paramArrayOfFloat1[5];
    float f1 = f7;
    float f2 = f8;
    float f3 = f9;
    float f4 = f10;
    char c1;
    switch (paramChar2)
    {
    default: 
      f4 = f10;
      f3 = f9;
      f2 = f8;
      f1 = f7;
    case 'L': 
    case 'M': 
    case 'T': 
    case 'l': 
    case 'm': 
    case 't': 
    case 'Z': 
    case 'z': 
      for (;;)
      {
        c1 = '\002';
        break;
        paramPath.close();
        paramPath.moveTo(f6, f5);
        f1 = f6;
        f3 = f1;
        f2 = f5;
        f4 = f2;
      }
    case 'Q': 
    case 'S': 
    case 'q': 
    case 's': 
      c1 = '\004';
      f1 = f7;
      f2 = f8;
      f3 = f9;
      f4 = f10;
      break;
    case 'H': 
    case 'V': 
    case 'h': 
    case 'v': 
      c1 = '\001';
      f1 = f7;
      f2 = f8;
      f3 = f9;
      f4 = f10;
      break;
    case 'C': 
    case 'c': 
      c1 = '\006';
      f1 = f7;
      f2 = f8;
      f3 = f9;
      f4 = f10;
      break;
    case 'A': 
    case 'a': 
      c1 = '\007';
      f4 = f10;
      f3 = f9;
      f2 = f8;
      f1 = f7;
    }
    char c2 = '\000';
    int i = paramChar1;
    paramChar1 = c2;
    for (;;)
    {
      c2 = paramChar2;
      if (paramChar1 >= paramArrayOfFloat2.length) {
        break;
      }
      int j;
      label1231:
      boolean bool1;
      label1557:
      label1568:
      boolean bool2;
      if (c2 != 'A')
      {
        int k;
        if (c2 != 'C')
        {
          if (c2 != 'H')
          {
            if (c2 != 'Q')
            {
              if (c2 != 'V')
              {
                if (c2 != 'a')
                {
                  if (c2 != 'c') {
                    if (c2 != 'h') {
                      if (c2 != 'q') {
                        if (c2 != 'v') {
                          if (c2 != 'L') {
                            if (c2 != 'M') {
                              if (c2 != 'S') {
                                if (c2 != 'T') {
                                  if (c2 != 'l') {
                                    if (c2 != 'm') {
                                      if (c2 != 's') {
                                        if (c2 != 't') {
                                          break label2128;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  for (;;)
                  {
                    if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
                    {
                      f4 = 0.0F;
                      f3 = 0.0F;
                    }
                    else
                    {
                      f3 = f1 - f3;
                      f4 = f2 - f4;
                    }
                    i = paramChar1 + '\000';
                    f7 = paramArrayOfFloat2[i];
                    c2 = paramChar1 + '\001';
                    paramPath.rQuadTo(f3, f4, f7, paramArrayOfFloat2[c2]);
                    f7 = f1 + paramArrayOfFloat2[i];
                    f8 = f2 + paramArrayOfFloat2[c2];
                    f4 += f2;
                    f3 += f1;
                    f2 = f8;
                    f1 = f7;
                    continue;
                    if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
                    {
                      f3 = 0.0F;
                      f4 = 0.0F;
                    }
                    else
                    {
                      f4 = f2 - f4;
                      f3 = f1 - f3;
                    }
                    i = paramChar1 + '\000';
                    f7 = paramArrayOfFloat2[i];
                    c2 = paramChar1 + '\001';
                    f8 = paramArrayOfFloat2[c2];
                    j = paramChar1 + '\002';
                    f9 = paramArrayOfFloat2[j];
                    k = paramChar1 + '\003';
                    paramPath.rCubicTo(f3, f4, f7, f8, f9, paramArrayOfFloat2[k]);
                    f8 = paramArrayOfFloat2[i] + f1;
                    f3 = paramArrayOfFloat2[c2] + f2;
                    f4 = f1 + paramArrayOfFloat2[j];
                    f7 = paramArrayOfFloat2[k];
                    f1 = f8;
                    break label1557;
                    i = paramChar1 + '\000';
                    f1 += paramArrayOfFloat2[i];
                    c2 = paramChar1 + '\001';
                    f2 += paramArrayOfFloat2[c2];
                    if (paramChar1 > 0)
                    {
                      paramPath.rLineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                    }
                    else
                    {
                      paramPath.rMoveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                      break label1231;
                      i = paramChar1 + '\000';
                      f7 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      paramPath.rLineTo(f7, paramArrayOfFloat2[c2]);
                      f1 += paramArrayOfFloat2[i];
                      for (f7 = paramArrayOfFloat2[c2];; f7 = paramArrayOfFloat2[i])
                      {
                        f2 += f7;
                        break;
                        if ((i != 113) && (i != 116) && (i != 81))
                        {
                          f8 = f2;
                          f7 = f1;
                          if (i != 84) {}
                        }
                        else
                        {
                          f7 = f1 * 2.0F - f3;
                          f8 = f2 * 2.0F - f4;
                        }
                        i = paramChar1 + '\000';
                        f1 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        paramPath.quadTo(f7, f8, f1, paramArrayOfFloat2[c2]);
                        f1 = paramArrayOfFloat2[i];
                        f2 = paramArrayOfFloat2[c2];
                        f4 = f8;
                        f3 = f7;
                        break;
                        if ((i != 99) && (i != 115) && (i != 67))
                        {
                          f8 = f2;
                          f7 = f1;
                          if (i != 83) {}
                        }
                        else
                        {
                          f7 = f1 * 2.0F - f3;
                          f8 = f2 * 2.0F - f4;
                        }
                        i = paramChar1 + '\000';
                        f1 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        f2 = paramArrayOfFloat2[c2];
                        j = paramChar1 + '\002';
                        f3 = paramArrayOfFloat2[j];
                        k = paramChar1 + '\003';
                        paramPath.cubicTo(f7, f8, f1, f2, f3, paramArrayOfFloat2[k]);
                        f1 = paramArrayOfFloat2[i];
                        f3 = paramArrayOfFloat2[c2];
                        f7 = paramArrayOfFloat2[j];
                        f2 = paramArrayOfFloat2[k];
                        break label1568;
                        i = paramChar1 + '\000';
                        f1 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        f2 = paramArrayOfFloat2[c2];
                        if (paramChar1 > 0)
                        {
                          paramPath.lineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                          break;
                        }
                        paramPath.moveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                        f5 = f2;
                        f6 = f1;
                        break;
                        i = paramChar1 + '\000';
                        f1 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        paramPath.lineTo(f1, paramArrayOfFloat2[c2]);
                        f1 = paramArrayOfFloat2[i];
                        f2 = paramArrayOfFloat2[c2];
                        break;
                        i = paramChar1 + '\000';
                        paramPath.rLineTo(0.0F, paramArrayOfFloat2[i]);
                      }
                      i = paramChar1 + '\000';
                      f3 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      f4 = paramArrayOfFloat2[c2];
                      j = paramChar1 + '\002';
                      f7 = paramArrayOfFloat2[j];
                      k = paramChar1 + '\003';
                      paramPath.rQuadTo(f3, f4, f7, paramArrayOfFloat2[k]);
                      f8 = paramArrayOfFloat2[i] + f1;
                      f3 = paramArrayOfFloat2[c2] + f2;
                      f4 = f1 + paramArrayOfFloat2[j];
                      f7 = paramArrayOfFloat2[k];
                      f1 = f8;
                      break label1557;
                      i = paramChar1 + '\000';
                      paramPath.rLineTo(paramArrayOfFloat2[i], 0.0F);
                      f1 += paramArrayOfFloat2[i];
                      continue;
                      f3 = paramArrayOfFloat2[(paramChar1 + '\000')];
                      f4 = paramArrayOfFloat2[(paramChar1 + '\001')];
                      i = paramChar1 + '\002';
                      f7 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\003';
                      f8 = paramArrayOfFloat2[c2];
                      j = paramChar1 + '\004';
                      f9 = paramArrayOfFloat2[j];
                      k = paramChar1 + '\005';
                      paramPath.rCubicTo(f3, f4, f7, f8, f9, paramArrayOfFloat2[k]);
                      f8 = paramArrayOfFloat2[i] + f1;
                      f3 = paramArrayOfFloat2[c2] + f2;
                      f4 = f1 + paramArrayOfFloat2[j];
                      f7 = paramArrayOfFloat2[k];
                      f1 = f8;
                      f2 += f7;
                      f7 = f4;
                      f4 = f3;
                      f3 = f1;
                      f1 = f7;
                    }
                  }
                }
                i = paramChar1 + '\005';
                f3 = paramArrayOfFloat2[i];
                c2 = paramChar1 + '\006';
                f4 = paramArrayOfFloat2[c2];
                f7 = paramArrayOfFloat2[(paramChar1 + '\000')];
                f8 = paramArrayOfFloat2[(paramChar1 + '\001')];
                f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
                if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
                if (paramArrayOfFloat2[(paramChar1 + '\004')] != 0.0F) {
                  bool2 = true;
                } else {
                  bool2 = false;
                }
                drawArc(paramPath, f1, f2, f3 + f1, f4 + f2, f7, f8, f9, bool1, bool2);
                f1 += paramArrayOfFloat2[i];
                f2 += paramArrayOfFloat2[c2];
              }
              else
              {
                i = paramChar1 + '\000';
                paramPath.lineTo(f1, paramArrayOfFloat2[i]);
                f2 = paramArrayOfFloat2[i];
                break label2128;
              }
            }
            else
            {
              i = paramChar1;
              c2 = i + 0;
              f1 = paramArrayOfFloat2[c2];
              j = i + 1;
              f2 = paramArrayOfFloat2[j];
              k = i + 2;
              f3 = paramArrayOfFloat2[k];
              i += 3;
              paramPath.quadTo(f1, f2, f3, paramArrayOfFloat2[i]);
              f3 = paramArrayOfFloat2[c2];
              f4 = paramArrayOfFloat2[j];
              f1 = paramArrayOfFloat2[k];
              f2 = paramArrayOfFloat2[i];
              break label2128;
            }
          }
          else
          {
            i = paramChar1 + '\000';
            paramPath.lineTo(paramArrayOfFloat2[i], f2);
            f1 = paramArrayOfFloat2[i];
            break label2128;
          }
        }
        else
        {
          i = paramChar1;
          f1 = paramArrayOfFloat2[(i + 0)];
          f2 = paramArrayOfFloat2[(i + 1)];
          c2 = i + 2;
          f3 = paramArrayOfFloat2[c2];
          j = i + 3;
          f4 = paramArrayOfFloat2[j];
          k = i + 4;
          f7 = paramArrayOfFloat2[k];
          i += 5;
          paramPath.cubicTo(f1, f2, f3, f4, f7, paramArrayOfFloat2[i]);
          f1 = paramArrayOfFloat2[k];
          f2 = paramArrayOfFloat2[i];
          f3 = paramArrayOfFloat2[c2];
          f4 = paramArrayOfFloat2[j];
          break label2128;
        }
      }
      else
      {
        i = paramChar1;
        c2 = i + 5;
        f3 = paramArrayOfFloat2[c2];
        j = i + 6;
        f4 = paramArrayOfFloat2[j];
        f7 = paramArrayOfFloat2[(i + 0)];
        f8 = paramArrayOfFloat2[(i + 1)];
        f9 = paramArrayOfFloat2[(i + 2)];
        if (paramArrayOfFloat2[(i + 3)] != 0.0F) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (paramArrayOfFloat2[(i + 4)] != 0.0F) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        drawArc(paramPath, f1, f2, f3, f4, f7, f8, f9, bool1, bool2);
        f1 = paramArrayOfFloat2[c2];
        f2 = paramArrayOfFloat2[j];
      }
      f4 = f2;
      f3 = f1;
      label2128:
      paramChar1 += c1;
      i = paramChar2;
    }
    paramArrayOfFloat1[0] = f1;
    paramArrayOfFloat1[1] = f2;
    paramArrayOfFloat1[2] = f3;
    paramArrayOfFloat1[3] = f4;
    paramArrayOfFloat1[4] = f6;
    paramArrayOfFloat1[5] = f5;
  }
  
  private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    int i = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / 3.141592653589793D));
    double d4 = Math.cos(paramDouble7);
    double d5 = Math.sin(paramDouble7);
    double d1 = Math.cos(paramDouble8);
    double d3 = Math.sin(paramDouble8);
    paramDouble7 = -paramDouble3;
    double d9 = paramDouble7 * d4;
    double d10 = paramDouble4 * d5;
    paramDouble7 *= d5;
    double d11 = paramDouble4 * d4;
    paramDouble4 = i;
    Double.isNaN(paramDouble4);
    double d6 = paramDouble9 / paramDouble4;
    double d2 = d3 * paramDouble7 + d1 * d11;
    paramDouble9 = d9 * d3 - d10 * d1;
    int j = 0;
    d3 = paramDouble8;
    d1 = paramDouble6;
    paramDouble8 = paramDouble5;
    paramDouble4 = paramDouble7;
    paramDouble7 = d6;
    paramDouble6 = d5;
    paramDouble5 = d4;
    for (;;)
    {
      d5 = paramDouble3;
      if (j >= i) {
        break;
      }
      d6 = d3 + paramDouble7;
      double d7 = Math.sin(d6);
      double d12 = Math.cos(d6);
      d4 = paramDouble1 + d5 * paramDouble5 * d12 - d10 * d7;
      double d8 = paramDouble2 + d5 * paramDouble6 * d12 + d11 * d7;
      d5 = d9 * d7 - d10 * d12;
      d7 = d7 * paramDouble4 + d12 * d11;
      d3 = d6 - d3;
      d12 = Math.tan(d3 / 2.0D);
      d3 = Math.sin(d3) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
      paramPath.rLineTo(0.0F, 0.0F);
      paramPath.cubicTo((float)(paramDouble8 + paramDouble9 * d3), (float)(d1 + d2 * d3), (float)(d4 - d3 * d5), (float)(d8 - d3 * d7), (float)d4, (float)d8);
      j += 1;
      d1 = d8;
      d3 = d6;
      d2 = d7;
      paramDouble9 = d5;
      paramDouble8 = d4;
    }
  }
  
  private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
  {
    double d5 = Math.toRadians(paramFloat7);
    double d6 = Math.cos(d5);
    double d7 = Math.sin(d5);
    double d8 = paramFloat1;
    Double.isNaN(d8);
    double d9 = paramFloat2;
    Double.isNaN(d9);
    double d10 = paramFloat5;
    Double.isNaN(d10);
    double d1 = (d8 * d6 + d9 * d7) / d10;
    double d2 = -paramFloat1;
    Double.isNaN(d2);
    Double.isNaN(d9);
    double d11 = paramFloat6;
    Double.isNaN(d11);
    double d4 = (d2 * d7 + d9 * d6) / d11;
    double d3 = paramFloat3;
    Double.isNaN(d3);
    d2 = paramFloat4;
    Double.isNaN(d2);
    Double.isNaN(d10);
    double d12 = (d3 * d6 + d2 * d7) / d10;
    d3 = -paramFloat3;
    Double.isNaN(d3);
    Double.isNaN(d2);
    Double.isNaN(d11);
    double d13 = (d3 * d7 + d2 * d6) / d11;
    double d15 = d1 - d12;
    double d14 = d4 - d13;
    d3 = (d1 + d12) / 2.0D;
    d2 = (d4 + d13) / 2.0D;
    double d16 = d15 * d15 + d14 * d14;
    if (d16 == 0.0D)
    {
      Log.w("PathParser", " Points are coincident");
      return;
    }
    double d17 = 1.0D / d16 - 0.25D;
    if (d17 < 0.0D)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Points are too far apart ");
      localStringBuilder.append(d16);
      Log.w("PathParser", localStringBuilder.toString());
      float f = (float)(Math.sqrt(d16) / 1.99999D);
      drawArc(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
      return;
    }
    d16 = Math.sqrt(d17);
    d15 *= d16;
    d14 = d16 * d14;
    if (paramBoolean1 == paramBoolean2)
    {
      d3 -= d14;
      d2 += d15;
    }
    else
    {
      d3 += d14;
      d2 -= d15;
    }
    d14 = Math.atan2(d4 - d2, d1 - d3);
    d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
    if (d4 >= 0.0D) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    d1 = d4;
    if (paramBoolean2 != paramBoolean1) {
      if (d4 > 0.0D) {
        d1 = d4 - 6.283185307179586D;
      } else {
        d1 = d4 + 6.283185307179586D;
      }
    }
    Double.isNaN(d10);
    d3 *= d10;
    Double.isNaN(d11);
    d2 *= d11;
    arcToBezier(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
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
    for (;;)
    {
      float[] arrayOfFloat = paramPathDataNode1.mParams;
      if (i >= arrayOfFloat.length) {
        break;
      }
      this.mParams[i] = (arrayOfFloat[i] * (1.0F - paramFloat) + paramPathDataNode2.mParams[i] * paramFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.PathParser.PathDataNode
 * JD-Core Version:    0.7.0.1
 */