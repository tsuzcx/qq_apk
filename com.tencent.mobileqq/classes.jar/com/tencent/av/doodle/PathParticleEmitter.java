package com.tencent.av.doodle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import java.io.BufferedReader;
import java.io.IOException;

public class PathParticleEmitter
{
  public float a;
  private int jdField_a_of_type_Int;
  private PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure = null;
  private PathParticleEmitter.GradientColorValue jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$GradientColorValue = new PathParticleEmitter.GradientColorValue();
  private PathParticleEmitter.RangedNumericValue jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue = new PathParticleEmitter.RangedNumericValue();
  private PathParticleEmitter.ScaledNumericValue jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.SpawnShapeValue jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue = new PathParticleEmitter.SpawnShapeValue();
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private BitmapDrawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private PathParticleEmitter.Particle[] jdField_a_of_type_ArrayOfComTencentAvDoodlePathParticleEmitter$Particle;
  private boolean[] jdField_a_of_type_ArrayOfBoolean;
  public float b;
  private int jdField_b_of_type_Int = 4;
  private PathParticleEmitter.RangedNumericValue jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue = new PathParticleEmitter.RangedNumericValue();
  private PathParticleEmitter.ScaledNumericValue jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_b_of_type_Boolean;
  float[] jdField_b_of_type_ArrayOfFloat = new float[2];
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private PathParticleEmitter.RangedNumericValue jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private PathParticleEmitter.RangedNumericValue jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_e_of_type_Boolean;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private boolean jdField_g_of_type_Boolean = true;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private float jdField_i_of_type_Float;
  private int jdField_i_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private int jdField_j_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private int jdField_k_of_type_Int;
  private PathParticleEmitter.ScaledNumericValue jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue l = new PathParticleEmitter.ScaledNumericValue();
  
  public PathParticleEmitter()
  {
    this.jdField_a_of_type_Float = 1.0F;
    b();
  }
  
  public PathParticleEmitter(BufferedReader paramBufferedReader)
  {
    this.jdField_a_of_type_Float = 1.0F;
    b();
    a(paramBufferedReader);
  }
  
  static float a(BufferedReader paramBufferedReader, String paramString)
  {
    return Float.parseFloat(a(paramBufferedReader, paramString));
  }
  
  static int a(BufferedReader paramBufferedReader, String paramString)
  {
    return Integer.parseInt(a(paramBufferedReader, paramString));
  }
  
  static String a(BufferedReader paramBufferedReader, String paramString)
  {
    paramBufferedReader = paramBufferedReader.readLine();
    if (paramBufferedReader != null) {
      return paramBufferedReader.substring(paramBufferedReader.indexOf(":") + 1).trim();
    }
    paramBufferedReader = new StringBuilder();
    paramBufferedReader.append("Missing value: ");
    paramBufferedReader.append(paramString);
    throw new IOException(paramBufferedReader.toString());
  }
  
  private void a(PathParticleEmitter.Particle paramParticle, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPathMeasure;
    float f2 = 3.4028235E+38F;
    if (localObject != null)
    {
      f1 = ((PathMeasure)localObject).getLength();
      if (f1 > 0.0F)
      {
        f1 = MathUtils.c(f1);
        this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f1, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
        localObject = this.jdField_a_of_type_ArrayOfFloat;
        f2 = localObject[0];
        f1 = localObject[1];
        break label79;
      }
    }
    float f1 = 3.4028235E+38F;
    label79:
    float f3 = f2;
    if (this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.jdField_a_of_type_Boolean) {
      f3 = f2 + this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a();
    }
    f2 = f1;
    if (this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.jdField_a_of_type_Boolean) {
      f2 = f1 + this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a();
    }
    int m = this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue.jdField_a_of_type_Int;
    float f4;
    float f5;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          paramFloat1 = f2;
          f1 = f3;
        }
        else
        {
          f4 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramFloat1);
          f1 = this.jdField_f_of_type_Float;
          float f6 = this.jdField_g_of_type_Float;
          paramFloat1 = this.l.a(paramFloat1);
          f5 = f4 / 2.0F;
          f6 = (f1 + f6 * paramFloat1) / 2.0F;
          paramFloat1 = f2;
          f1 = f3;
          if (f5 != 0.0F) {
            if (f6 == 0.0F)
            {
              paramFloat1 = f2;
              f1 = f3;
            }
            else
            {
              paramFloat1 = f5 / f6;
              if (this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue.jdField_c_of_type_Boolean)
              {
                m = this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue.jdField_b_of_type_Int;
                if (m != 1)
                {
                  if (m != 2) {
                    f4 = MathUtils.c(360.0F);
                  } else {
                    f4 = MathUtils.c(179.0F);
                  }
                }
                else {
                  f4 = -MathUtils.c(179.0F);
                }
                f6 = MathUtils.b(f4);
                float f7 = MathUtils.a(f4);
                f3 += f6 * f5;
                f2 += f5 * f7 / paramFloat1;
                paramFloat1 = f2;
                f1 = f3;
                if ((this.jdField_d_of_type_Int & 0x2) == 0)
                {
                  paramParticle.jdField_g_of_type_Float = f4;
                  paramParticle.jdField_i_of_type_Float = f6;
                  paramParticle.j = f7;
                  paramFloat1 = f2;
                  f1 = f3;
                }
              }
              else
              {
                do
                {
                  f1 = MathUtils.c(f4) - f5;
                  f6 = MathUtils.c(f4) - f5;
                } while (f1 * f1 + f6 * f6 > f5 * f5);
                f1 = f3 + f1;
                paramFloat1 = f2 + f6 / paramFloat1;
              }
            }
          }
        }
      }
      else
      {
        f1 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramFloat1);
        paramFloat1 = this.jdField_f_of_type_Float + this.jdField_g_of_type_Float * this.l.a(paramFloat1);
        f1 = f3 + (MathUtils.c(f1) - f1 / 2.0F);
      }
    }
    else
    {
      for (paramFloat1 = MathUtils.c(paramFloat1) - paramFloat1 / 2.0F;; paramFloat1 = f5 * (paramFloat1 / f4))
      {
        paramFloat1 = f2 + paramFloat1;
        break label616;
        f4 = this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramFloat1);
        paramFloat1 = this.jdField_f_of_type_Float + this.jdField_g_of_type_Float * this.l.a(paramFloat1);
        if (f4 == 0.0F) {
          break;
        }
        f5 = MathUtils.a() * f4;
        f1 = f3 + f5;
      }
      paramFloat1 = f2 + paramFloat1 * MathUtils.a();
      f1 = f3;
    }
    label616:
    f2 = paramParticle.getBitmap().getHeight();
    paramParticle.a(f1 - paramFloat2 / 2.0F, paramFloat1 - f2 / 2.0F, paramFloat2, f2);
  }
  
  private boolean a(PathParticleEmitter.Particle paramParticle, float paramFloat, int paramInt)
  {
    paramInt = paramParticle.jdField_b_of_type_Int - paramInt;
    if (paramInt <= 0) {
      return false;
    }
    paramParticle.jdField_b_of_type_Int = paramInt;
    float f5 = 1.0F - paramParticle.jdField_b_of_type_Int / paramParticle.jdField_a_of_type_Int;
    paramInt = this.jdField_d_of_type_Int;
    if ((paramInt & 0x1) != 0) {
      paramParticle.b(paramParticle.jdField_a_of_type_Float + paramParticle.jdField_b_of_type_Float * this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5));
    }
    if ((paramInt & 0x8) != 0)
    {
      float f1 = (paramParticle.jdField_e_of_type_Float + paramParticle.jdField_f_of_type_Float * this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5)) * paramFloat;
      float f4;
      if ((paramInt & 0x2) != 0)
      {
        float f6 = paramParticle.jdField_g_of_type_Float + paramParticle.jdField_h_of_type_Float * this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5);
        f3 = MathUtils.b(f6) * f1;
        f4 = f1 * MathUtils.a(f6);
        f1 = f4;
        f2 = f3;
        if ((paramInt & 0x4) != 0)
        {
          f2 = paramParticle.jdField_c_of_type_Float + paramParticle.jdField_d_of_type_Float * this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5);
          f1 = f2;
          if (this.jdField_e_of_type_Boolean) {
            f1 = f2 + f6;
          }
          paramParticle.a(f1);
          f1 = f4;
          f2 = f3;
        }
      }
      else
      {
        f3 = f1 * paramParticle.jdField_i_of_type_Float;
        f4 = f1 * paramParticle.j;
        if (!this.jdField_e_of_type_Boolean)
        {
          f1 = f4;
          f2 = f3;
          if ((paramInt & 0x4) == 0) {}
        }
        else
        {
          f2 = paramParticle.jdField_c_of_type_Float + paramParticle.jdField_d_of_type_Float * this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5);
          f1 = f2;
          if (this.jdField_e_of_type_Boolean) {
            f1 = f2 + paramParticle.jdField_g_of_type_Float;
          }
          paramParticle.a(f1);
          f2 = f3;
          f1 = f4;
        }
      }
      float f3 = f2;
      if ((paramInt & 0x10) != 0) {
        f3 = f2 + (paramParticle.m + paramParticle.n * this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5)) * paramFloat;
      }
      float f2 = f1;
      if ((paramInt & 0x20) != 0) {
        f2 = f1 + (paramParticle.o + paramParticle.p * this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5)) * paramFloat;
      }
      paramParticle.a(f3, f2);
    }
    else if ((paramInt & 0x4) != 0)
    {
      paramParticle.a(paramParticle.jdField_c_of_type_Float + paramParticle.jdField_d_of_type_Float * this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5));
    }
    float[] arrayOfFloat;
    if ((paramInt & 0x40) != 0) {
      arrayOfFloat = this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$GradientColorValue.a(f5);
    } else {
      arrayOfFloat = paramParticle.jdField_a_of_type_ArrayOfFloat;
    }
    paramParticle.b(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], paramParticle.k + paramParticle.l * this.jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f5));
    return true;
  }
  
  static boolean a(BufferedReader paramBufferedReader, String paramString)
  {
    return Boolean.parseBoolean(a(paramBufferedReader, paramString));
  }
  
  private void b()
  {
    this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a(true);
    this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(true);
    this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(true);
    this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(true);
    this.jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(true);
    this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue.a(true);
    this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(true);
    this.l.a(true);
  }
  
  private void c()
  {
    float f1;
    if (this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.jdField_a_of_type_Boolean) {
      f1 = this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a();
    } else {
      f1 = 0.0F;
    }
    this.jdField_h_of_type_Float = f1;
    this.jdField_i_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float -= this.jdField_a_of_type_Float;
    this.jdField_a_of_type_Float = this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a();
    this.jdField_e_of_type_Int = ((int)this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a());
    this.jdField_f_of_type_Int = ((int)this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b());
    if (!this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      this.jdField_f_of_type_Int -= this.jdField_e_of_type_Int;
    }
    this.jdField_j_of_type_Int = ((int)this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a());
    this.jdField_k_of_type_Int = ((int)this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b());
    if (!this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      this.jdField_k_of_type_Int -= this.jdField_j_of_type_Int;
    }
    int m;
    if (this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) {
      m = (int)this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
    } else {
      m = 0;
    }
    this.jdField_h_of_type_Int = m;
    this.jdField_i_of_type_Int = ((int)this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b());
    if (!this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      this.jdField_i_of_type_Int -= this.jdField_h_of_type_Int;
    }
    this.jdField_d_of_type_Float = this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
    this.jdField_e_of_type_Float = this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
    if (!this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      this.jdField_e_of_type_Float -= this.jdField_d_of_type_Float;
    }
    this.jdField_f_of_type_Float = this.l.a();
    this.jdField_g_of_type_Float = this.l.b();
    if (!this.l.a()) {
      this.jdField_g_of_type_Float -= this.jdField_f_of_type_Float;
    }
    this.jdField_d_of_type_Int = 0;
    if ((this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) && (this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_ArrayOfFloat.length > 1)) {
      this.jdField_d_of_type_Int |= 0x2;
    }
    if (this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_Int |= 0x8;
    }
    if (this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_ArrayOfFloat.length > 1) {
      this.jdField_d_of_type_Int |= 0x1;
    }
    if ((this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_ArrayOfFloat.length > 1)) {
      this.jdField_d_of_type_Int |= 0x4;
    }
    if (this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_Int |= 0x10;
    }
    if (this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean) {
      this.jdField_d_of_type_Int |= 0x20;
    }
    if (this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$GradientColorValue.jdField_a_of_type_ArrayOfFloat.length > 1) {
      this.jdField_d_of_type_Int |= 0x40;
    }
  }
  
  private void d(int paramInt)
  {
    Object localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvDoodlePathParticleEmitter$Particle;
    Object localObject2 = localObject3[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
      localObject1 = a(localObject1[MathUtils.a(localObject1.length - 1)]);
      localObject3[paramInt] = localObject1;
    }
    float f4 = this.jdField_b_of_type_Float / this.jdField_a_of_type_Float;
    paramInt = this.jdField_d_of_type_Int;
    int m = this.jdField_j_of_type_Int + (int)(this.jdField_k_of_type_Int * this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f4));
    ((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_Int = m;
    ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Int = m;
    if (this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean)
    {
      ((PathParticleEmitter.Particle)localObject1).jdField_e_of_type_Float = this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
      ((PathParticleEmitter.Particle)localObject1).jdField_f_of_type_Float = this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
      if (!this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
        ((PathParticleEmitter.Particle)localObject1).jdField_f_of_type_Float -= ((PathParticleEmitter.Particle)localObject1).jdField_e_of_type_Float;
      }
    }
    ((PathParticleEmitter.Particle)localObject1).jdField_g_of_type_Float = this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
    ((PathParticleEmitter.Particle)localObject1).jdField_h_of_type_Float = this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
    if (!this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      ((PathParticleEmitter.Particle)localObject1).jdField_h_of_type_Float -= ((PathParticleEmitter.Particle)localObject1).jdField_g_of_type_Float;
    }
    float f1;
    if ((paramInt & 0x2) == 0)
    {
      f1 = ((PathParticleEmitter.Particle)localObject1).jdField_g_of_type_Float + ((PathParticleEmitter.Particle)localObject1).jdField_h_of_type_Float * this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(0.0F);
      ((PathParticleEmitter.Particle)localObject1).jdField_g_of_type_Float = f1;
      ((PathParticleEmitter.Particle)localObject1).jdField_i_of_type_Float = MathUtils.b(f1);
      ((PathParticleEmitter.Particle)localObject1).j = MathUtils.a(f1);
    }
    else
    {
      f1 = 0.0F;
    }
    float f5 = ((PathParticleEmitter.Particle)localObject1).getBitmap().getWidth();
    ((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_Float = (this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a() / f5);
    ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Float = (this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b() / f5);
    if (!this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
      ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Float -= ((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_Float;
    }
    ((PathParticleEmitter.Particle)localObject1).b(((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_Float + ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Float * this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(0.0F));
    if (this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean)
    {
      ((PathParticleEmitter.Particle)localObject1).jdField_c_of_type_Float = this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
      ((PathParticleEmitter.Particle)localObject1).jdField_d_of_type_Float = this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
      if (!this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
        ((PathParticleEmitter.Particle)localObject1).jdField_d_of_type_Float -= ((PathParticleEmitter.Particle)localObject1).jdField_c_of_type_Float;
      }
      float f3 = ((PathParticleEmitter.Particle)localObject1).jdField_c_of_type_Float + ((PathParticleEmitter.Particle)localObject1).jdField_d_of_type_Float * this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(0.0F);
      float f2 = f3;
      if (this.jdField_e_of_type_Boolean) {
        f2 = f3 + f1;
      }
      ((PathParticleEmitter.Particle)localObject1).a(f2);
    }
    if (this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean)
    {
      ((PathParticleEmitter.Particle)localObject1).m = this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
      ((PathParticleEmitter.Particle)localObject1).n = this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
      if (!this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
        ((PathParticleEmitter.Particle)localObject1).n -= ((PathParticleEmitter.Particle)localObject1).m;
      }
    }
    if (this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.jdField_a_of_type_Boolean)
    {
      ((PathParticleEmitter.Particle)localObject1).o = this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
      ((PathParticleEmitter.Particle)localObject1).p = this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b();
      if (!this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a()) {
        ((PathParticleEmitter.Particle)localObject1).p -= ((PathParticleEmitter.Particle)localObject1).o;
      }
    }
    localObject3 = ((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_ArrayOfFloat;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new float[3];
      ((PathParticleEmitter.Particle)localObject1).jdField_a_of_type_ArrayOfFloat = ((float[])localObject2);
    }
    localObject3 = this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$GradientColorValue.a(0.0F);
    localObject2[0] = localObject3[0];
    localObject2[1] = localObject3[1];
    localObject2[2] = localObject3[2];
    ((PathParticleEmitter.Particle)localObject1).k = this.jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a();
    ((PathParticleEmitter.Particle)localObject1).l = (this.jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.b() - ((PathParticleEmitter.Particle)localObject1).k);
    a((PathParticleEmitter.Particle)localObject1, f4, f5);
    m = (int)(this.jdField_h_of_type_Int + this.jdField_i_of_type_Int * this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(f4));
    if (m > 0)
    {
      paramInt = m;
      if (m >= ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Int) {
        paramInt = ((PathParticleEmitter.Particle)localObject1).jdField_b_of_type_Int - 1;
      }
      a((PathParticleEmitter.Particle)localObject1, paramInt / 1000.0F, paramInt);
    }
  }
  
  protected PathParticleEmitter.Particle a(BitmapDrawable paramBitmapDrawable)
  {
    return new PathParticleEmitter.Particle(paramBitmapDrawable);
  }
  
  public void a()
  {
    int n = this.jdField_c_of_type_Int;
    if (n == this.jdField_b_of_type_Int) {
      return;
    }
    boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
    int m = 0;
    int i1 = arrayOfBoolean.length;
    while (m < i1)
    {
      if (arrayOfBoolean[m] == 0)
      {
        d(m);
        arrayOfBoolean[m] = true;
        this.jdField_c_of_type_Int = (n + 1);
        return;
      }
      m += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
    if (localObject != null)
    {
      if (localObject.length <= 0) {
        return;
      }
      this.jdField_c_of_type_Float += paramFloat * 1000.0F;
      float f2 = this.jdField_c_of_type_Float;
      if (f2 < 1.0F) {
        return;
      }
      int i2 = (int)f2;
      float f1 = i2;
      this.jdField_c_of_type_Float = (f2 - f1);
      f2 = this.jdField_i_of_type_Float;
      if (f2 < this.jdField_h_of_type_Float)
      {
        this.jdField_i_of_type_Float = (f2 + f1);
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          a();
        }
        f2 = this.jdField_b_of_type_Float;
        if (f2 < this.jdField_a_of_type_Float)
        {
          this.jdField_b_of_type_Float = (f2 + f1);
        }
        else
        {
          if ((!this.jdField_d_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
            break label150;
          }
          c();
        }
        m = 0;
        break label153;
        label150:
        m = 1;
        label153:
        if (m == 0)
        {
          this.jdField_g_of_type_Int += i2;
          f1 = this.jdField_e_of_type_Int + this.jdField_f_of_type_Int * this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
          if (f1 > 0.0F)
          {
            f1 = 1000.0F / f1;
            m = this.jdField_g_of_type_Int;
            if (m >= f1)
            {
              m = Math.min((int)(m / f1), this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
              this.jdField_g_of_type_Int = ((int)(this.jdField_g_of_type_Int - m * f1));
              this.jdField_g_of_type_Int = ((int)(this.jdField_g_of_type_Int % f1));
              b(m);
            }
          }
          m = this.jdField_c_of_type_Int;
          n = this.jdField_a_of_type_Int;
          if (m < n) {
            b(n - m);
          }
        }
      }
      localObject = this.jdField_a_of_type_ArrayOfBoolean;
      int n = this.jdField_c_of_type_Int;
      PathParticleEmitter.Particle[] arrayOfParticle = this.jdField_a_of_type_ArrayOfComTencentAvDoodlePathParticleEmitter$Particle;
      int i3 = localObject.length;
      int m = 0;
      while (m < i3)
      {
        int i1 = n;
        if (localObject[m] != 0)
        {
          i1 = n;
          if (!a(arrayOfParticle[m], paramFloat, i2))
          {
            localObject[m] = 0;
            i1 = n - 1;
          }
        }
        m += 1;
        n = i1;
      }
      this.jdField_c_of_type_Int = n;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[paramInt];
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfComTencentAvDoodlePathParticleEmitter$Particle = new PathParticleEmitter.Particle[paramInt];
  }
  
  public void a(Canvas paramCanvas)
  {
    PathParticleEmitter.Particle[] arrayOfParticle = this.jdField_a_of_type_ArrayOfComTencentAvDoodlePathParticleEmitter$Particle;
    boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
    int n = arrayOfBoolean.length;
    int m = 0;
    while (m < n)
    {
      if (arrayOfBoolean[m] != 0) {
        arrayOfParticle[m].draw(paramCanvas);
      }
      m += 1;
    }
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = paramPathMeasure;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = a(paramBufferedReader, "name");
      paramBufferedReader.readLine();
      this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      c(a(paramBufferedReader, "minParticleCount"));
      a(a(paramBufferedReader, "maxParticleCount"));
      paramBufferedReader.readLine();
      this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_b_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_c_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$RangedNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$SpawnShapeValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_k_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.l.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_d_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_f_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_g_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_e_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_h_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_i_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_a_of_type_ComTencentAvDoodlePathParticleEmitter$GradientColorValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_j_of_type_ComTencentAvDoodlePathParticleEmitter$ScaledNumericValue.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.jdField_c_of_type_Boolean = a(paramBufferedReader, "attached");
      this.jdField_d_of_type_Boolean = a(paramBufferedReader, "continuous");
      this.jdField_e_of_type_Boolean = a(paramBufferedReader, "aligned");
      this.jdField_g_of_type_Boolean = a(paramBufferedReader, "additive");
      this.jdField_f_of_type_Boolean = a(paramBufferedReader, "behind");
      return;
    }
    catch (RuntimeException paramBufferedReader)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        throw paramBufferedReader;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error parsing emitter: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      throw new RuntimeException(localStringBuilder.toString(), paramBufferedReader);
    }
  }
  
  public void a(BitmapDrawable[] paramArrayOfBitmapDrawable)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = paramArrayOfBitmapDrawable;
  }
  
  public void b(int paramInt)
  {
    int n = Math.min(paramInt, this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    if (n == 0) {
      return;
    }
    boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfBoolean;
    int i1 = arrayOfBoolean.length;
    int m = 0;
    paramInt = 0;
    if (m < n) {
      for (;;)
      {
        if (paramInt >= i1) {
          break label80;
        }
        if (arrayOfBoolean[paramInt] == 0)
        {
          d(paramInt);
          arrayOfBoolean[paramInt] = true;
          m += 1;
          paramInt += 1;
          break;
        }
        paramInt += 1;
      }
    }
    label80:
    this.jdField_c_of_type_Int += n;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter
 * JD-Core Version:    0.7.0.1
 */