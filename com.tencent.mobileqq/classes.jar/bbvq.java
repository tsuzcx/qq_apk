import android.graphics.PointF;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class bbvq
{
  public final int a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private bbvs jdField_a_of_type_Bbvs;
  private bbvt jdField_a_of_type_Bbvt = new bbvt(this, null);
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  private PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF();
  private bbvt jdField_b_of_type_Bbvt = new bbvt(this, null);
  private boolean jdField_b_of_type_Boolean;
  public final int c;
  private PointF jdField_c_of_type_AndroidGraphicsPointF = new PointF();
  private boolean jdField_c_of_type_Boolean;
  public final int d;
  private PointF jdField_d_of_type_AndroidGraphicsPointF = new PointF();
  private boolean jdField_d_of_type_Boolean;
  public final int e;
  private PointF jdField_e_of_type_AndroidGraphicsPointF = new PointF();
  private boolean jdField_e_of_type_Boolean;
  public final int f;
  private boolean f;
  public final int g = 6;
  public final int h = -1;
  public final int i = 50;
  public final int j = 0;
  public final int k = 1;
  public final int l = 2;
  private final int m = 200;
  private final int n = 200;
  private final int o = 200;
  private final int p = 30;
  private final int q = 80;
  private final int r = 400;
  private final int s = 50;
  private final int t = 30;
  private int u;
  private int v;
  private int w;
  private int x;
  private final int y = 8;
  
  bbvq(bbvs parambbvs)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = 4;
    this.jdField_f_of_type_Int = 5;
    this.jdField_a_of_type_Bbvs = parambbvs;
  }
  
  private static float a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = Math.abs(paramPointF1.x - paramPointF2.x);
    f1 = (float)Math.atan2(Math.abs(paramPointF1.y - paramPointF2.y), f1);
    if (paramPointF1.x > paramPointF2.x)
    {
      if (paramPointF1.y < paramPointF2.y) {
        return f1;
      }
      if (paramPointF1.y > paramPointF2.y) {
        return (float)(6.283185307179586D - f1);
      }
      return 0.0F;
    }
    if (paramPointF1.x < paramPointF2.x)
    {
      if (paramPointF1.y < paramPointF2.y) {
        return (float)(3.141592653589793D - f1);
      }
      if (paramPointF1.y > paramPointF2.y) {
        return (float)(f1 + 3.141592653589793D);
      }
      return 3.141593F;
    }
    if (paramPointF1.y < paramPointF2.y) {
      return 1.570796F;
    }
    return 4.712389F;
  }
  
  private bbvt a(int paramInt)
  {
    bbvt localbbvt = null;
    VideoEnvironment.LogDownLoad("GameplayEngine.GameEvent", String.format("id=%d,pointerId0=%d,pointerId1=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Bbvt.jdField_a_of_type_Int) }), null);
    VideoEnvironment.LogDownLoad("GameplayEngine.GameEvent", String.format("id=%d,pressed0=%b,pressed1=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Bbvt.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Bbvt.jdField_a_of_type_Boolean) }), null);
    if (paramInt == this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int) {
      localbbvt = this.jdField_a_of_type_Bbvt;
    }
    do
    {
      return localbbvt;
      if (paramInt == this.jdField_b_of_type_Bbvt.jdField_a_of_type_Int) {
        return this.jdField_b_of_type_Bbvt;
      }
      if (this.jdField_a_of_type_Bbvt.jdField_a_of_type_Boolean) {
        return this.jdField_a_of_type_Bbvt;
      }
    } while (!this.jdField_b_of_type_Bbvt.jdField_a_of_type_Boolean);
    return this.jdField_b_of_type_Bbvt;
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown";
    case 0: 
      return "GESTURE_TAP";
    case 1: 
      return "GESTURE_SWIPE";
    case 2: 
      return "GESTURE_PINCH";
    case 3: 
      return "GESTURE_LONG_TAP";
    case 4: 
      return "GESTURE_ROTATE";
    case 5: 
      return "GESTURE_DRAG";
    case 6: 
      return "GESTURE_DROP";
    case -1: 
      return "GESTURE_ANY_SUPPORTED";
    }
    return "GESTURE_PROMOTE";
  }
  
  private void a()
  {
    this.x = ((int)Math.sqrt(Math.pow(this.jdField_a_of_type_Bbvt.jdField_a_of_type_Float - this.jdField_b_of_type_Bbvt.jdField_a_of_type_Float, 2.0D) + Math.pow(this.jdField_a_of_type_Bbvt.b - this.jdField_b_of_type_Bbvt.b, 2.0D)) + 5);
  }
  
  private void a(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    VideoEnvironment.LogDownLoad("GameplayEngine.GameEvent", String.format("gestureEvent:Name=%s,x=%f,y=%f,param=%f", new Object[] { a(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }), null);
    if (this.jdField_a_of_type_Bbvs != null) {
      this.jdField_a_of_type_Bbvs.a(paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    }
  }
  
  private void a(long paramLong, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("GameplayEngine.GameEvent", String.format("touchEvent:touchName=%s,x=%f,y=%f,pointerId=%d", new Object[] { b(paramInt1), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) }), null);
    if (this.jdField_a_of_type_Bbvs != null) {
      this.jdField_a_of_type_Bbvs.a(paramLong, paramInt1, paramFloat1, paramFloat2, paramInt2);
    }
  }
  
  private boolean a()
  {
    return !this.jdField_b_of_type_Boolean;
  }
  
  private boolean a(int paramInt, float paramFloat1, float paramFloat2)
  {
    bbvt localbbvt = a(paramInt);
    if (localbbvt == null) {}
    do
    {
      return false;
      float f2 = localbbvt.jdField_a_of_type_Float;
      float f1 = localbbvt.b;
      paramFloat1 = Math.abs(paramFloat1 - f2);
      paramFloat2 = Math.abs(paramFloat2 - f1);
    } while ((paramFloat1 <= 8.0F) && (paramFloat2 <= 8.0F));
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramInt1);
    float f2 = Math.abs(paramInt2);
    return (f1 <= 8.0F) && (f2 <= 8.0F);
  }
  
  private boolean a(long paramLong)
  {
    boolean bool = false;
    if ((a(paramLong, 0)) || (a(paramLong, 1)) || (a(paramLong, 2)) || (a(paramLong, 3)) || (a(paramLong, 5)) || (a(paramLong, 6))) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Bbvs != null) {
      return this.jdField_a_of_type_Bbvs.a(paramLong, paramInt);
    }
    return false;
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unKnown";
    case 0: 
      return "TOUCH_PRESS";
    case 1: 
      return "TOUCH_RELEASE";
    }
    return "TOUCH_MOVE";
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bbvt.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Bbvt.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
    this.jdField_b_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
    this.jdField_c_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
    this.jdField_d_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
    this.u = -1;
    this.jdField_f_of_type_Boolean = false;
    this.w = 0;
    this.v = 0;
    this.x = 0;
    this.jdField_e_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    return ((paramInt1 > 0) && (paramInt2 > 0)) || ((paramInt1 < 0) && (paramInt2 < 0));
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
  }
  
  void a(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2)
  {
    boolean bool = a(paramLong1);
    if (paramInt2 == 0)
    {
      b();
      if (bool)
      {
        this.jdField_a_of_type_Bbvt.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bbvt.jdField_a_of_type_Long = paramLong2;
        this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Bbvt.jdField_a_of_type_Float = paramFloat1;
        this.jdField_a_of_type_Bbvt.b = paramFloat2;
        this.jdField_a_of_type_AndroidGraphicsPointF.set(paramFloat1, paramFloat2);
        this.jdField_c_of_type_AndroidGraphicsPointF.set(paramFloat1, paramFloat2);
      }
      c();
      this.u = paramInt1;
      a(paramLong1, 0, paramFloat1, paramFloat2, paramInt1);
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != 5);
      if (bool)
      {
        this.jdField_b_of_type_Bbvt.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Bbvt.jdField_a_of_type_Long = paramLong2;
        this.jdField_b_of_type_Bbvt.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Bbvt.jdField_a_of_type_Float = paramFloat1;
        this.jdField_b_of_type_Bbvt.b = paramFloat2;
        this.jdField_b_of_type_AndroidGraphicsPointF.set(paramFloat1, paramFloat2);
        this.jdField_d_of_type_AndroidGraphicsPointF.set(paramFloat1, paramFloat2);
        a();
        this.jdField_e_of_type_AndroidGraphicsPointF.set((this.jdField_a_of_type_Bbvt.jdField_a_of_type_Float + this.jdField_b_of_type_Bbvt.jdField_a_of_type_Float) / 2.0F, (this.jdField_a_of_type_Bbvt.b + this.jdField_b_of_type_Bbvt.b) / 2.0F);
      }
    } while (!this.jdField_a_of_type_Boolean);
    a(paramLong1, 0, paramFloat1, paramFloat2, paramInt1);
  }
  
  void a(long paramLong1, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong2)
  {
    int i4 = paramArrayOfInt.length;
    int i2 = 0;
    int i5;
    float f2;
    float f3;
    int i3;
    if (i2 < i4)
    {
      i5 = paramArrayOfInt[i2];
      f2 = paramArrayOfFloat1[i2];
      f3 = paramArrayOfFloat2[i2];
      i3 = 0;
      i1 = i3;
      if (!this.jdField_a_of_type_Bbvt.jdField_a_of_type_Boolean) {
        break label721;
      }
      if ((!this.jdField_b_of_type_Bbvt.jdField_a_of_type_Boolean) || ((i5 != this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int) && (i5 != this.jdField_b_of_type_Bbvt.jdField_a_of_type_Int))) {
        break label1070;
      }
      if (this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int == this.jdField_b_of_type_Bbvt.jdField_a_of_type_Int) {
        c();
      }
    }
    else
    {
      return;
    }
    int i1 = i3;
    label197:
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int i12;
    float f1;
    if (a(paramLong1, 2))
    {
      if (this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int != i5) {
        break label776;
      }
      this.jdField_a_of_type_AndroidGraphicsPointF.set(this.jdField_c_of_type_AndroidGraphicsPointF);
      this.jdField_c_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.v = ((int)Math.sqrt(Math.pow(f2 - this.jdField_a_of_type_Bbvt.jdField_a_of_type_Float, 2.0D) + Math.pow(f3 - this.jdField_a_of_type_Bbvt.b, 2.0D)));
      if ((!this.jdField_b_of_type_Boolean) && (this.v >= 30) && (this.w >= 30)) {
        this.jdField_b_of_type_Boolean = true;
      }
      i1 = i3;
      if (this.jdField_b_of_type_Boolean)
      {
        a(this.jdField_a_of_type_AndroidGraphicsPointF, this.jdField_b_of_type_AndroidGraphicsPointF);
        a(this.jdField_c_of_type_AndroidGraphicsPointF, this.jdField_d_of_type_AndroidGraphicsPointF);
        i1 = (int)Math.sqrt(Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.x - this.jdField_c_of_type_AndroidGraphicsPointF.x, 2.0D) + Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.y - this.jdField_c_of_type_AndroidGraphicsPointF.y, 2.0D));
        i6 = (int)Math.sqrt(Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x, 2.0D) + Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y, 2.0D));
        i7 = (int)Math.sqrt(Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.x - this.jdField_d_of_type_AndroidGraphicsPointF.x, 2.0D) + Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.y - this.jdField_d_of_type_AndroidGraphicsPointF.y, 2.0D));
        i8 = (int)Math.sqrt(Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.x - this.jdField_b_of_type_AndroidGraphicsPointF.x, 2.0D) + Math.pow(this.jdField_e_of_type_AndroidGraphicsPointF.y - this.jdField_b_of_type_AndroidGraphicsPointF.y, 2.0D));
        i9 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.x - this.jdField_a_of_type_AndroidGraphicsPointF.x);
        i10 = (int)(this.jdField_c_of_type_AndroidGraphicsPointF.y - this.jdField_a_of_type_AndroidGraphicsPointF.y);
        i11 = (int)(this.jdField_d_of_type_AndroidGraphicsPointF.x - this.jdField_b_of_type_AndroidGraphicsPointF.x);
        i12 = (int)(this.jdField_d_of_type_AndroidGraphicsPointF.y - this.jdField_b_of_type_AndroidGraphicsPointF.y);
        if (i5 != this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int) {
          break label844;
        }
        f1 = i1 / i6;
        label559:
        int i13 = (int)Math.sqrt(Math.pow(this.jdField_c_of_type_AndroidGraphicsPointF.x - this.jdField_d_of_type_AndroidGraphicsPointF.x, 2.0D) + Math.pow(this.jdField_c_of_type_AndroidGraphicsPointF.y - this.jdField_d_of_type_AndroidGraphicsPointF.y, 2.0D));
        if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))
        {
          if (Math.abs(0.0F) >= 0.002D) {
            break label902;
          }
          if ((!b(i10, i12)) || (!b(i9, i11)) || (i13 >= this.x)) {
            break label856;
          }
          this.jdField_c_of_type_Boolean = true;
          this.jdField_d_of_type_Boolean = false;
          this.jdField_e_of_type_Boolean = false;
        }
        label689:
        if (!this.jdField_d_of_type_Boolean) {
          break label920;
        }
        a(paramLong1, 2, this.jdField_e_of_type_AndroidGraphicsPointF.x, this.jdField_e_of_type_AndroidGraphicsPointF.y, f1);
        i1 = 1;
      }
    }
    for (;;)
    {
      label721:
      if ((i1 == 0) && ((this.jdField_a_of_type_Boolean) || (this.u == i5)) && (a(i5, f2, f3))) {
        a(paramLong1, 2, f2, f3, i5);
      }
      i2 += 1;
      break;
      label776:
      this.jdField_b_of_type_AndroidGraphicsPointF.set(this.jdField_d_of_type_AndroidGraphicsPointF);
      this.jdField_d_of_type_AndroidGraphicsPointF.set(f2, f3);
      this.w = ((int)Math.sqrt(Math.pow(f2 - this.jdField_b_of_type_Bbvt.jdField_a_of_type_Float, 2.0D) + Math.pow(f3 - this.jdField_b_of_type_Bbvt.b, 2.0D)));
      break label197;
      label844:
      f1 = i7 / i8;
      break label559;
      label856:
      if (((i1 < i6) || (i7 < i8)) && ((i1 > i6) || (i7 > i8))) {
        break label689;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = false;
      break label689;
      label902:
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = true;
      break label689;
      label920:
      if (this.jdField_c_of_type_Boolean)
      {
        if ((i10 > 0) && (i12 > 0)) {
          if (i10 > i12) {
            a(paramLong1, 50, i11, i12, 0.0F);
          }
        }
        for (;;)
        {
          i1 = 1;
          break;
          a(paramLong1, 50, i9, i10, 0.0F);
          continue;
          if ((i10 < 0) && (i12 < 0)) {
            if (i10 > i12) {
              a(paramLong1, 50, i9, i10, 0.0F);
            } else {
              a(paramLong1, 50, i11, i12, 0.0F);
            }
          }
        }
      }
      i1 = i3;
      if (this.jdField_e_of_type_Boolean)
      {
        i1 = 1;
        a(paramLong1, 4, this.jdField_e_of_type_AndroidGraphicsPointF.x, this.jdField_e_of_type_AndroidGraphicsPointF.y, 0.0F);
        continue;
        label1070:
        i1 = i3;
        if (a())
        {
          i1 = i3;
          if (i5 == this.jdField_a_of_type_Bbvt.jdField_a_of_type_Int)
          {
            i1 = i3;
            if (a(paramLong1, 5))
            {
              i6 = (int)Math.sqrt(Math.pow(f2 - this.jdField_a_of_type_Bbvt.jdField_a_of_type_Float, 2.0D) + Math.pow(f3 - this.jdField_a_of_type_Bbvt.b, 2.0D));
              if (!this.jdField_f_of_type_Boolean)
              {
                i1 = i3;
                if (!a(paramLong1, 5)) {}
              }
              else
              {
                i1 = i3;
                if (paramLong2 - this.jdField_a_of_type_Bbvt.jdField_a_of_type_Long >= 200L)
                {
                  i1 = i3;
                  if (i6 >= 30)
                  {
                    a(paramLong1, 5, f2, f3, 0.0F);
                    this.jdField_f_of_type_Boolean = true;
                    i1 = 1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  void b(long paramLong1, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, long paramLong2)
  {
    int i2;
    int i1;
    bbvt localbbvt;
    if (paramInt2 == 1)
    {
      i2 = 0;
      i1 = 0;
      localbbvt = a(paramInt1);
      if (localbbvt != null) {}
    }
    label114:
    do
    {
      do
      {
        return;
        paramInt2 = i1;
        float f1;
        float f2;
        if (localbbvt.jdField_a_of_type_Boolean)
        {
          f1 = paramFloat1 - localbbvt.jdField_a_of_type_Float;
          f2 = paramFloat2 - localbbvt.b;
          if (!this.jdField_b_of_type_Boolean) {
            break label114;
          }
          c();
          paramInt2 = 1;
        }
        for (;;)
        {
          localbbvt.jdField_a_of_type_Boolean = false;
          if ((paramInt2 == 0) && ((this.jdField_a_of_type_Boolean) || (this.u == paramInt1))) {
            a(paramLong1, 1, paramFloat1, paramFloat2, paramInt1);
          }
          this.u = -1;
          return;
          if (this.jdField_f_of_type_Boolean)
          {
            paramInt2 = i2;
            if (a(paramLong1, 6))
            {
              a(paramLong1, 6, paramFloat1, paramFloat2, 0.0F);
              paramInt2 = 1;
            }
            this.jdField_f_of_type_Boolean = false;
          }
          else
          {
            if ((a(paramLong1, 1)) && (paramLong2 - localbbvt.jdField_a_of_type_Long < 400L) && ((Math.abs(f1) > 50.0F) || (Math.abs(f2) > 50.0F)))
            {
              paramInt2 = 0;
              if (Math.abs(f1) > Math.abs(f2)) {
                if (f1 > 0.0F) {
                  paramInt2 = 8;
                }
              }
              for (;;)
              {
                a(paramLong1, 1, paramFloat1, paramFloat2, paramInt2);
                paramInt2 = 1;
                break;
                if (f1 < 0.0F)
                {
                  paramInt2 = 4;
                  continue;
                  if (f2 > 0.0F) {
                    paramInt2 = 2;
                  } else if (f2 < 0.0F) {
                    paramInt2 = 1;
                  }
                }
              }
            }
            if ((a(paramLong1, 0)) && (a((int)f1, (int)f2)) && (paramLong2 - localbbvt.jdField_a_of_type_Long < 200L))
            {
              a(paramLong1, 0, paramFloat1, paramFloat2, 0.0F);
              paramInt2 = 1;
            }
            else
            {
              paramInt2 = i1;
              if (a(paramLong1, 3))
              {
                paramInt2 = i1;
                if (a((int)f1, (int)f2))
                {
                  paramInt2 = i1;
                  if (paramLong2 - localbbvt.jdField_a_of_type_Long >= 200L)
                  {
                    a(paramLong1, 3, paramFloat1, paramFloat2, (float)(paramLong2 - localbbvt.jdField_a_of_type_Long));
                    paramInt2 = 1;
                  }
                }
              }
            }
          }
        }
      } while (paramInt2 != 6);
      i1 = 0;
      localbbvt = a(paramInt1);
    } while (localbbvt == null);
    paramInt2 = i1;
    int i3;
    if (localbbvt.jdField_a_of_type_Boolean)
    {
      i3 = (int)(paramFloat1 - localbbvt.jdField_a_of_type_Float);
      i2 = (int)(paramFloat2 - localbbvt.b);
      if ((!this.jdField_a_of_type_Boolean) || (!a(paramLong1, 1)) || (paramLong2 - localbbvt.jdField_a_of_type_Long >= 400L) || ((Math.abs(i3) <= 50) && (Math.abs(i2) <= 50))) {
        break label646;
      }
      paramInt2 = 0;
      if (i3 <= 0) {
        break label617;
      }
      paramInt2 = 8;
      label539:
      if (i2 <= 0) {
        break label628;
      }
      i1 = paramInt2 | 0x2;
      label550:
      a(paramLong1, 1, paramFloat1, paramFloat2, i1);
      paramInt2 = 1;
    }
    for (;;)
    {
      localbbvt.jdField_a_of_type_Boolean = false;
      if ((paramInt2 == 0) && ((this.jdField_a_of_type_Boolean) || (this.u == paramInt1))) {
        a(paramLong1, 1, paramFloat1, paramFloat2, paramInt1);
      }
      if (this.u != paramInt1) {
        break;
      }
      this.u = -1;
      return;
      label617:
      if (i3 >= 0) {
        break label539;
      }
      paramInt2 = 4;
      break label539;
      label628:
      i1 = paramInt2;
      if (i2 >= 0) {
        break label550;
      }
      i1 = paramInt2 | 0x1;
      break label550;
      label646:
      if ((this.jdField_a_of_type_Boolean) && (a(paramLong1, 0)) && (a(i3, i2)) && (paramLong2 - localbbvt.jdField_a_of_type_Long < 200L))
      {
        a(paramLong1, 0, paramFloat1, paramFloat2, 0.0F);
        paramInt2 = 1;
      }
      else
      {
        paramInt2 = i1;
        if (this.jdField_a_of_type_Boolean)
        {
          paramInt2 = i1;
          if (a(paramLong1, 3))
          {
            paramInt2 = i1;
            if (a(i3, i2))
            {
              paramInt2 = i1;
              if (paramLong2 - localbbvt.jdField_a_of_type_Long >= 200L)
              {
                a(paramLong1, 3, paramFloat1, paramFloat2, (float)(paramLong2 - localbbvt.jdField_a_of_type_Long));
                paramInt2 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  void b(long paramLong1, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvq
 * JD-Core Version:    0.7.0.1
 */