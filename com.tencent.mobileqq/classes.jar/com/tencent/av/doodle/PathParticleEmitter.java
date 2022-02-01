package com.tencent.av.doodle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import java.io.BufferedReader;
import java.io.IOException;

public class PathParticleEmitter
{
  private int A = 4;
  private String B;
  private int C;
  private boolean[] D;
  private boolean E;
  private int F;
  private boolean G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private float O;
  private float P;
  private float Q;
  private float R;
  private float S;
  private float T;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private boolean Y = true;
  private PathMeasure Z = null;
  public float a = 1.0F;
  public float b;
  float[] c = new float[2];
  float[] d = new float[2];
  private PathParticleEmitter.RangedNumericValue e = new PathParticleEmitter.RangedNumericValue();
  private PathParticleEmitter.ScaledNumericValue f = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.RangedNumericValue g = new PathParticleEmitter.RangedNumericValue();
  private PathParticleEmitter.ScaledNumericValue h = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue i = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue j = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue k = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue l = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue m = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue n = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue o = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue p = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.GradientColorValue q = new PathParticleEmitter.GradientColorValue();
  private PathParticleEmitter.RangedNumericValue r = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.RangedNumericValue s = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue t = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.ScaledNumericValue u = new PathParticleEmitter.ScaledNumericValue();
  private PathParticleEmitter.SpawnShapeValue v = new PathParticleEmitter.SpawnShapeValue();
  private float w;
  private BitmapDrawable[] x;
  private PathParticleEmitter.Particle[] y;
  private int z;
  
  public PathParticleEmitter()
  {
    b();
  }
  
  public PathParticleEmitter(BufferedReader paramBufferedReader)
  {
    b();
    a(paramBufferedReader);
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
    Object localObject = this.Z;
    float f2 = 3.4028235E+38F;
    if (localObject != null)
    {
      f1 = ((PathMeasure)localObject).getLength();
      if (f1 > 0.0F)
      {
        f1 = MathUtils.c(f1);
        this.Z.getPosTan(f1, this.c, this.d);
        localObject = this.c;
        f2 = localObject[0];
        f1 = localObject[1];
        break label79;
      }
    }
    float f1 = 3.4028235E+38F;
    label79:
    float f3 = f2;
    if (this.r.b) {
      f3 = f2 + this.r.a();
    }
    f2 = f1;
    if (this.s.b) {
      f2 = f1 + this.s.a();
    }
    int i1 = this.v.a;
    float f4;
    float f5;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          paramFloat1 = f2;
          f1 = f3;
        }
        else
        {
          f4 = this.O + this.P * this.t.a(paramFloat1);
          f1 = this.Q;
          float f6 = this.R;
          paramFloat1 = this.u.a(paramFloat1);
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
              if (this.v.d)
              {
                i1 = this.v.e;
                if (i1 != 1)
                {
                  if (i1 != 2) {
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
                if ((this.F & 0x2) == 0)
                {
                  paramParticle.i = f4;
                  paramParticle.k = f6;
                  paramParticle.l = f7;
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
        f1 = this.O + this.P * this.t.a(paramFloat1);
        paramFloat1 = this.Q + this.R * this.u.a(paramFloat1);
        f1 = f3 + (MathUtils.c(f1) - f1 / 2.0F);
      }
    }
    else
    {
      for (paramFloat1 = MathUtils.c(paramFloat1) - paramFloat1 / 2.0F;; paramFloat1 = f5 * (paramFloat1 / f4))
      {
        paramFloat1 = f2 + paramFloat1;
        break label616;
        f4 = this.O + this.P * this.t.a(paramFloat1);
        paramFloat1 = this.Q + this.R * this.u.a(paramFloat1);
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
    paramInt = paramParticle.b - paramInt;
    if (paramInt <= 0) {
      return false;
    }
    paramParticle.b = paramInt;
    float f5 = 1.0F - paramParticle.b / paramParticle.a;
    paramInt = this.F;
    if ((paramInt & 0x1) != 0) {
      paramParticle.b(paramParticle.c + paramParticle.d * this.j.a(f5));
    }
    if ((paramInt & 0x8) != 0)
    {
      float f1 = (paramParticle.g + paramParticle.h * this.l.a(f5)) * paramFloat;
      float f4;
      if ((paramInt & 0x2) != 0)
      {
        float f6 = paramParticle.i + paramParticle.j * this.m.a(f5);
        f3 = MathUtils.b(f6) * f1;
        f4 = f1 * MathUtils.a(f6);
        f1 = f4;
        f2 = f3;
        if ((paramInt & 0x4) != 0)
        {
          f2 = paramParticle.e + paramParticle.f * this.k.a(f5);
          f1 = f2;
          if (this.W) {
            f1 = f2 + f6;
          }
          paramParticle.a(f1);
          f1 = f4;
          f2 = f3;
        }
      }
      else
      {
        f3 = f1 * paramParticle.k;
        f4 = f1 * paramParticle.l;
        if (!this.W)
        {
          f1 = f4;
          f2 = f3;
          if ((paramInt & 0x4) == 0) {}
        }
        else
        {
          f2 = paramParticle.e + paramParticle.f * this.k.a(f5);
          f1 = f2;
          if (this.W) {
            f1 = f2 + paramParticle.i;
          }
          paramParticle.a(f1);
          f2 = f3;
          f1 = f4;
        }
      }
      float f3 = f2;
      if ((paramInt & 0x10) != 0) {
        f3 = f2 + (paramParticle.o + paramParticle.p * this.n.a(f5)) * paramFloat;
      }
      float f2 = f1;
      if ((paramInt & 0x20) != 0) {
        f2 = f1 + (paramParticle.q + paramParticle.r * this.o.a(f5)) * paramFloat;
      }
      paramParticle.a(f3, f2);
    }
    else if ((paramInt & 0x4) != 0)
    {
      paramParticle.a(paramParticle.e + paramParticle.f * this.k.a(f5));
    }
    float[] arrayOfFloat;
    if ((paramInt & 0x40) != 0) {
      arrayOfFloat = this.q.a(f5);
    } else {
      arrayOfFloat = paramParticle.s;
    }
    paramParticle.b(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], paramParticle.m + paramParticle.n * this.p.a(f5));
    return true;
  }
  
  private void b()
  {
    this.g.a(true);
    this.i.a(true);
    this.h.a(true);
    this.j.a(true);
    this.p.a(true);
    this.v.a(true);
    this.t.a(true);
    this.u.a(true);
  }
  
  static boolean b(BufferedReader paramBufferedReader, String paramString)
  {
    return Boolean.parseBoolean(a(paramBufferedReader, paramString));
  }
  
  static int c(BufferedReader paramBufferedReader, String paramString)
  {
    return Integer.parseInt(a(paramBufferedReader, paramString));
  }
  
  private void c()
  {
    float f1;
    if (this.e.b) {
      f1 = this.e.a();
    } else {
      f1 = 0.0F;
    }
    this.S = f1;
    this.T = 0.0F;
    this.b -= this.a;
    this.a = this.g.a();
    this.H = ((int)this.i.a());
    this.I = ((int)this.i.b());
    if (!this.i.c()) {
      this.I -= this.H;
    }
    this.M = ((int)this.h.a());
    this.N = ((int)this.h.b());
    if (!this.h.c()) {
      this.N -= this.M;
    }
    int i1;
    if (this.f.b) {
      i1 = (int)this.f.a();
    } else {
      i1 = 0;
    }
    this.K = i1;
    this.L = ((int)this.f.b());
    if (!this.f.c()) {
      this.L -= this.K;
    }
    this.O = this.t.a();
    this.P = this.t.b();
    if (!this.t.c()) {
      this.P -= this.O;
    }
    this.Q = this.u.a();
    this.R = this.u.b();
    if (!this.u.c()) {
      this.R -= this.Q;
    }
    this.F = 0;
    if ((this.m.b) && (this.m.a.length > 1)) {
      this.F |= 0x2;
    }
    if (this.l.b) {
      this.F |= 0x8;
    }
    if (this.j.a.length > 1) {
      this.F |= 0x1;
    }
    if ((this.k.b) && (this.k.a.length > 1)) {
      this.F |= 0x4;
    }
    if (this.n.b) {
      this.F |= 0x10;
    }
    if (this.o.b) {
      this.F |= 0x20;
    }
    if (this.q.a.length > 1) {
      this.F |= 0x40;
    }
  }
  
  static float d(BufferedReader paramBufferedReader, String paramString)
  {
    return Float.parseFloat(a(paramBufferedReader, paramString));
  }
  
  private void d(int paramInt)
  {
    Object localObject3 = this.y;
    Object localObject2 = localObject3[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.x;
      localObject1 = a(localObject1[MathUtils.a(localObject1.length - 1)]);
      localObject3[paramInt] = localObject1;
    }
    float f4 = this.b / this.a;
    paramInt = this.F;
    int i1 = this.M + (int)(this.N * this.h.a(f4));
    ((PathParticleEmitter.Particle)localObject1).a = i1;
    ((PathParticleEmitter.Particle)localObject1).b = i1;
    if (this.l.b)
    {
      ((PathParticleEmitter.Particle)localObject1).g = this.l.a();
      ((PathParticleEmitter.Particle)localObject1).h = this.l.b();
      if (!this.l.c()) {
        ((PathParticleEmitter.Particle)localObject1).h -= ((PathParticleEmitter.Particle)localObject1).g;
      }
    }
    ((PathParticleEmitter.Particle)localObject1).i = this.m.a();
    ((PathParticleEmitter.Particle)localObject1).j = this.m.b();
    if (!this.m.c()) {
      ((PathParticleEmitter.Particle)localObject1).j -= ((PathParticleEmitter.Particle)localObject1).i;
    }
    float f1;
    if ((paramInt & 0x2) == 0)
    {
      f1 = ((PathParticleEmitter.Particle)localObject1).i + ((PathParticleEmitter.Particle)localObject1).j * this.m.a(0.0F);
      ((PathParticleEmitter.Particle)localObject1).i = f1;
      ((PathParticleEmitter.Particle)localObject1).k = MathUtils.b(f1);
      ((PathParticleEmitter.Particle)localObject1).l = MathUtils.a(f1);
    }
    else
    {
      f1 = 0.0F;
    }
    float f5 = ((PathParticleEmitter.Particle)localObject1).getBitmap().getWidth();
    ((PathParticleEmitter.Particle)localObject1).c = (this.j.a() / f5);
    ((PathParticleEmitter.Particle)localObject1).d = (this.j.b() / f5);
    if (!this.j.c()) {
      ((PathParticleEmitter.Particle)localObject1).d -= ((PathParticleEmitter.Particle)localObject1).c;
    }
    ((PathParticleEmitter.Particle)localObject1).b(((PathParticleEmitter.Particle)localObject1).c + ((PathParticleEmitter.Particle)localObject1).d * this.j.a(0.0F));
    if (this.k.b)
    {
      ((PathParticleEmitter.Particle)localObject1).e = this.k.a();
      ((PathParticleEmitter.Particle)localObject1).f = this.k.b();
      if (!this.k.c()) {
        ((PathParticleEmitter.Particle)localObject1).f -= ((PathParticleEmitter.Particle)localObject1).e;
      }
      float f3 = ((PathParticleEmitter.Particle)localObject1).e + ((PathParticleEmitter.Particle)localObject1).f * this.k.a(0.0F);
      float f2 = f3;
      if (this.W) {
        f2 = f3 + f1;
      }
      ((PathParticleEmitter.Particle)localObject1).a(f2);
    }
    if (this.n.b)
    {
      ((PathParticleEmitter.Particle)localObject1).o = this.n.a();
      ((PathParticleEmitter.Particle)localObject1).p = this.n.b();
      if (!this.n.c()) {
        ((PathParticleEmitter.Particle)localObject1).p -= ((PathParticleEmitter.Particle)localObject1).o;
      }
    }
    if (this.o.b)
    {
      ((PathParticleEmitter.Particle)localObject1).q = this.o.a();
      ((PathParticleEmitter.Particle)localObject1).r = this.o.b();
      if (!this.o.c()) {
        ((PathParticleEmitter.Particle)localObject1).r -= ((PathParticleEmitter.Particle)localObject1).q;
      }
    }
    localObject3 = ((PathParticleEmitter.Particle)localObject1).s;
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new float[3];
      ((PathParticleEmitter.Particle)localObject1).s = ((float[])localObject2);
    }
    localObject3 = this.q.a(0.0F);
    localObject2[0] = localObject3[0];
    localObject2[1] = localObject3[1];
    localObject2[2] = localObject3[2];
    ((PathParticleEmitter.Particle)localObject1).m = this.p.a();
    ((PathParticleEmitter.Particle)localObject1).n = (this.p.b() - ((PathParticleEmitter.Particle)localObject1).m);
    a((PathParticleEmitter.Particle)localObject1, f4, f5);
    i1 = (int)(this.K + this.L * this.f.a(f4));
    if (i1 > 0)
    {
      paramInt = i1;
      if (i1 >= ((PathParticleEmitter.Particle)localObject1).b) {
        paramInt = ((PathParticleEmitter.Particle)localObject1).b - 1;
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
    int i2 = this.C;
    if (i2 == this.A) {
      return;
    }
    boolean[] arrayOfBoolean = this.D;
    int i1 = 0;
    int i3 = arrayOfBoolean.length;
    while (i1 < i3)
    {
      if (arrayOfBoolean[i1] == 0)
      {
        d(i1);
        arrayOfBoolean[i1] = true;
        this.C = (i2 + 1);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      if (localObject.length <= 0) {
        return;
      }
      this.w += paramFloat * 1000.0F;
      float f2 = this.w;
      if (f2 < 1.0F) {
        return;
      }
      int i4 = (int)f2;
      float f1 = i4;
      this.w = (f2 - f1);
      f2 = this.T;
      if (f2 < this.S)
      {
        this.T = (f2 + f1);
      }
      else
      {
        if (this.E)
        {
          this.E = false;
          a();
        }
        f2 = this.b;
        if (f2 < this.a)
        {
          this.b = (f2 + f1);
        }
        else
        {
          if ((!this.V) || (this.G)) {
            break label150;
          }
          c();
        }
        i1 = 0;
        break label153;
        label150:
        i1 = 1;
        label153:
        if (i1 == 0)
        {
          this.J += i4;
          f1 = this.H + this.I * this.i.a(this.b / this.a);
          if (f1 > 0.0F)
          {
            f1 = 1000.0F / f1;
            i1 = this.J;
            if (i1 >= f1)
            {
              i1 = Math.min((int)(i1 / f1), this.A - this.C);
              this.J = ((int)(this.J - i1 * f1));
              this.J = ((int)(this.J % f1));
              b(i1);
            }
          }
          i1 = this.C;
          i2 = this.z;
          if (i1 < i2) {
            b(i2 - i1);
          }
        }
      }
      localObject = this.D;
      int i2 = this.C;
      PathParticleEmitter.Particle[] arrayOfParticle = this.y;
      int i5 = localObject.length;
      int i1 = 0;
      while (i1 < i5)
      {
        int i3 = i2;
        if (localObject[i1] != 0)
        {
          i3 = i2;
          if (!a(arrayOfParticle[i1], paramFloat, i4))
          {
            localObject[i1] = 0;
            i3 = i2 - 1;
          }
        }
        i1 += 1;
        i2 = i3;
      }
      this.C = i2;
    }
  }
  
  public void a(int paramInt)
  {
    this.A = paramInt;
    this.D = new boolean[paramInt];
    this.C = 0;
    this.y = new PathParticleEmitter.Particle[paramInt];
  }
  
  public void a(Canvas paramCanvas)
  {
    PathParticleEmitter.Particle[] arrayOfParticle = this.y;
    boolean[] arrayOfBoolean = this.D;
    int i2 = arrayOfBoolean.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (arrayOfBoolean[i1] != 0) {
        arrayOfParticle[i1].draw(paramCanvas);
      }
      i1 += 1;
    }
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    this.Z = paramPathMeasure;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    try
    {
      this.B = a(paramBufferedReader, "name");
      paramBufferedReader.readLine();
      this.e.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.g.a(paramBufferedReader);
      paramBufferedReader.readLine();
      c(c(paramBufferedReader, "minParticleCount"));
      a(c(paramBufferedReader, "maxParticleCount"));
      paramBufferedReader.readLine();
      this.i.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.h.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.f.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.r.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.s.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.v.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.t.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.u.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.j.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.l.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.m.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.k.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.n.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.o.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.q.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.p.a(paramBufferedReader);
      paramBufferedReader.readLine();
      this.U = b(paramBufferedReader, "attached");
      this.V = b(paramBufferedReader, "continuous");
      this.W = b(paramBufferedReader, "aligned");
      this.Y = b(paramBufferedReader, "additive");
      this.X = b(paramBufferedReader, "behind");
      return;
    }
    catch (RuntimeException paramBufferedReader)
    {
      if (this.B == null) {
        throw paramBufferedReader;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error parsing emitter: ");
      localStringBuilder.append(this.B);
      throw new RuntimeException(localStringBuilder.toString(), paramBufferedReader);
    }
  }
  
  public void a(BitmapDrawable[] paramArrayOfBitmapDrawable)
  {
    this.x = paramArrayOfBitmapDrawable;
  }
  
  public void b(int paramInt)
  {
    int i2 = Math.min(paramInt, this.A - this.C);
    if (i2 == 0) {
      return;
    }
    boolean[] arrayOfBoolean = this.D;
    int i3 = arrayOfBoolean.length;
    int i1 = 0;
    paramInt = 0;
    if (i1 < i2) {
      for (;;)
      {
        if (paramInt >= i3) {
          break label80;
        }
        if (arrayOfBoolean[paramInt] == 0)
        {
          d(paramInt);
          arrayOfBoolean[paramInt] = true;
          i1 += 1;
          paramInt += 1;
          break;
        }
        paramInt += 1;
      }
    }
    label80:
    this.C += i2;
  }
  
  public void c(int paramInt)
  {
    this.z = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter
 * JD-Core Version:    0.7.0.1
 */