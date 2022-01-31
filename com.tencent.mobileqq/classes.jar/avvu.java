import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;

public class avvu
{
  private static final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private static final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private static final Rect jdField_a_of_type_AndroidGraphicsRect;
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private static final avvt jdField_a_of_type_Avvt = new avvt();
  private float jdField_a_of_type_Float;
  private final avvp jdField_a_of_type_Avvp;
  private final avvr jdField_a_of_type_Avvr;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public avvu(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
    this.jdField_a_of_type_Avvr = new avvr(paramSettings);
    this.jdField_a_of_type_Avvp = new avvp(paramSettings);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 == 1.0F) {}
    for (;;)
    {
      return paramFloat1;
      float f = paramFloat3 / paramFloat5;
      if ((paramFloat1 < paramFloat3) && (paramFloat1 < paramFloat2)) {
        paramFloat3 = (paramFloat3 - paramFloat1) / (paramFloat3 - f);
      }
      while (paramFloat3 != 0.0F)
      {
        return paramFloat1 + (float)Math.sqrt(paramFloat3) * (paramFloat2 - paramFloat1);
        if ((paramFloat1 > paramFloat4) && (paramFloat1 > paramFloat2)) {
          paramFloat3 = (paramFloat1 - paramFloat4) / (paramFloat4 * paramFloat5 - paramFloat4);
        } else {
          paramFloat3 = 0.0F;
        }
      }
    }
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float f1 = 1.0F;
    if (paramFloat5 == 0.0F) {}
    for (;;)
    {
      return paramFloat1;
      float f2 = (paramFloat1 + paramFloat2) * 0.5F;
      if ((f2 < paramFloat3) && (paramFloat1 < paramFloat2)) {
        paramFloat3 = (paramFloat3 - f2) / paramFloat5;
      }
      while (paramFloat3 != 0.0F)
      {
        if (paramFloat3 > 1.0F) {
          paramFloat3 = f1;
        }
        for (;;)
        {
          return paramFloat1 - (float)Math.sqrt(paramFloat3) * (paramFloat1 - paramFloat2);
          if ((f2 <= paramFloat4) || (paramFloat1 <= paramFloat2)) {
            break label98;
          }
          paramFloat3 = (f2 - paramFloat4) / paramFloat5;
          break;
        }
        label98:
        paramFloat3 = 0.0F;
      }
    }
  }
  
  public avvt a(avvt paramavvt, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Avvr.a(paramavvt);
    float f2 = this.jdField_a_of_type_Avvr.c();
    float f1;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c() > 0.0F)
    {
      f1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c();
      if (paramavvt.c() >= 0.5F * (f2 + f1)) {
        break label82;
      }
    }
    for (;;)
    {
      paramavvt = paramavvt.a();
      paramavvt.b(f1, paramFloat1, paramFloat2);
      return paramavvt;
      f1 = this.jdField_a_of_type_Avvr.b();
      break;
      label82:
      f1 = f2;
    }
  }
  
  public avvt a(avvt paramavvt1, avvt paramavvt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    jdField_a_of_type_Avvt.a(paramavvt1);
    if (a(jdField_a_of_type_Avvt, paramavvt2, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3)) {
      return jdField_a_of_type_Avvt.a();
    }
    return null;
  }
  
  public void a(avvt paramavvt)
  {
    if (this.jdField_a_of_type_Float > 0.0F) {
      paramavvt.a(paramavvt.a(), paramavvt.b(), paramavvt.c() * this.jdField_a_of_type_Float, paramavvt.d());
    }
  }
  
  public void a(avvt paramavvt, RectF paramRectF)
  {
    this.jdField_a_of_type_Avvp.a(paramavvt).a(paramRectF);
  }
  
  public boolean a(avvt paramavvt)
  {
    this.jdField_a_of_type_Boolean = true;
    return b(paramavvt);
  }
  
  public boolean a(avvt paramavvt1, avvt paramavvt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.i()) {
      return false;
    }
    float f2;
    float f1;
    if (!Float.isNaN(paramFloat1))
    {
      f2 = paramFloat1;
      f1 = paramFloat2;
      if (!Float.isNaN(paramFloat2)) {}
    }
    else
    {
      avvv.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsPoint);
      f2 = jdField_a_of_type_AndroidGraphicsPoint.x;
      f1 = jdField_a_of_type_AndroidGraphicsPoint.y;
    }
    if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f()))
    {
      paramFloat1 = Math.round(paramavvt1.d() / 90.0F) * 90.0F;
      if (!avvt.a(paramFloat1, paramavvt1.d())) {
        paramavvt1.d(paramFloat1, f2, f1);
      }
    }
    label233:
    label491:
    label500:
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      this.jdField_a_of_type_Avvr.a(paramavvt1);
      float f5 = this.jdField_a_of_type_Avvr.a();
      float f4 = this.jdField_a_of_type_Avvr.b();
      float f3;
      if (paramBoolean2)
      {
        paramFloat1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
        f3 = this.jdField_a_of_type_Avvr.a(paramavvt1.c(), paramFloat1);
        paramFloat2 = f3;
        if (paramavvt2 != null) {
          paramFloat2 = a(f3, paramavvt2.c(), f5, f4, paramFloat1);
        }
        if (avvt.a(paramFloat2, paramavvt1.c())) {
          break label510;
        }
        paramavvt1.b(paramFloat2, f2, f1);
      }
      label247:
      label510:
      for (paramBoolean2 = true;; paramBoolean2 = paramBoolean3)
      {
        if (paramBoolean1)
        {
          f1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e();
          if (!paramBoolean1) {
            break label491;
          }
          f2 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f();
          this.jdField_a_of_type_Avvp.a(paramavvt1);
          this.jdField_a_of_type_Avvp.a(paramavvt1.a(), paramavvt1.b(), f1, f2, jdField_a_of_type_AndroidGraphicsPointF);
          f4 = jdField_a_of_type_AndroidGraphicsPointF.x;
          f3 = jdField_a_of_type_AndroidGraphicsPointF.y;
          if (paramFloat2 >= f5) {
            break label500;
          }
          paramFloat1 = (float)Math.sqrt((paramFloat2 * paramFloat1 / f5 - 1.0F) / (paramFloat1 - 1.0F));
          this.jdField_a_of_type_Avvp.a(f4, f3, jdField_a_of_type_AndroidGraphicsPointF);
          paramFloat2 = jdField_a_of_type_AndroidGraphicsPointF.x;
          f5 = jdField_a_of_type_AndroidGraphicsPointF.y;
          paramFloat2 += (f4 - paramFloat2) * paramFloat1;
        }
        for (paramFloat1 = (f3 - f5) * paramFloat1 + f5;; paramFloat1 = f3)
        {
          f4 = paramFloat1;
          f3 = paramFloat2;
          if (paramavvt2 != null)
          {
            this.jdField_a_of_type_Avvp.a(jdField_a_of_type_AndroidGraphicsRectF);
            f3 = b(paramFloat2, paramavvt2.a(), jdField_a_of_type_AndroidGraphicsRectF.left, jdField_a_of_type_AndroidGraphicsRectF.right, f1);
            f4 = b(paramFloat1, paramavvt2.b(), jdField_a_of_type_AndroidGraphicsRectF.top, jdField_a_of_type_AndroidGraphicsRectF.bottom, f2);
          }
          if ((!avvt.a(f3, paramavvt1.a())) || (!avvt.a(f4, paramavvt1.b())))
          {
            paramavvt1.b(f3, f4);
            return true;
            paramFloat1 = 1.0F;
            break;
            f1 = 0.0F;
            break label233;
            f2 = 0.0F;
            break label247;
          }
          return paramBoolean2;
          paramFloat2 = f4;
        }
      }
    }
  }
  
  public boolean b(avvt paramavvt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramavvt.a(0.0F, 0.0F, this.jdField_a_of_type_Avvr.a(paramavvt).c(), 0.0F);
      avvv.a(paramavvt, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsRect);
      paramavvt.b(jdField_a_of_type_AndroidGraphicsRect.left, jdField_a_of_type_AndroidGraphicsRect.top);
      if ((!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.k()) || (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.l())) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        return true;
      }
      return false;
    }
    a(paramavvt, paramavvt, (0.0F / 0.0F), (0.0F / 0.0F), false, false, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvu
 * JD-Core Version:    0.7.0.1
 */