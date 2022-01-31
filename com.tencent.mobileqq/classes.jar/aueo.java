import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;

public class aueo
{
  private static final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private static final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private static final Rect jdField_a_of_type_AndroidGraphicsRect;
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private static final auen jdField_a_of_type_Auen = new auen();
  private float jdField_a_of_type_Float;
  private final auej jdField_a_of_type_Auej;
  private final auel jdField_a_of_type_Auel;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public aueo(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
    this.jdField_a_of_type_Auel = new auel(paramSettings);
    this.jdField_a_of_type_Auej = new auej(paramSettings);
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
  
  public auen a(auen paramauen, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Auel.a(paramauen);
    float f2 = this.jdField_a_of_type_Auel.c();
    float f1;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c() > 0.0F)
    {
      f1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c();
      if (paramauen.c() >= 0.5F * (f2 + f1)) {
        break label82;
      }
    }
    for (;;)
    {
      paramauen = paramauen.a();
      paramauen.b(f1, paramFloat1, paramFloat2);
      return paramauen;
      f1 = this.jdField_a_of_type_Auel.b();
      break;
      label82:
      f1 = f2;
    }
  }
  
  public auen a(auen paramauen1, auen paramauen2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    jdField_a_of_type_Auen.a(paramauen1);
    if (a(jdField_a_of_type_Auen, paramauen2, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3)) {
      return jdField_a_of_type_Auen.a();
    }
    return null;
  }
  
  public void a(auen paramauen)
  {
    if (this.jdField_a_of_type_Float > 0.0F) {
      paramauen.a(paramauen.a(), paramauen.b(), paramauen.c() * this.jdField_a_of_type_Float, paramauen.d());
    }
  }
  
  public void a(auen paramauen, RectF paramRectF)
  {
    this.jdField_a_of_type_Auej.a(paramauen).a(paramRectF);
  }
  
  public boolean a(auen paramauen)
  {
    this.jdField_a_of_type_Boolean = true;
    return b(paramauen);
  }
  
  public boolean a(auen paramauen1, auen paramauen2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
      auep.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsPoint);
      f2 = jdField_a_of_type_AndroidGraphicsPoint.x;
      f1 = jdField_a_of_type_AndroidGraphicsPoint.y;
    }
    if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f()))
    {
      paramFloat1 = Math.round(paramauen1.d() / 90.0F) * 90.0F;
      if (!auen.a(paramFloat1, paramauen1.d())) {
        paramauen1.d(paramFloat1, f2, f1);
      }
    }
    label233:
    label491:
    label500:
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      this.jdField_a_of_type_Auel.a(paramauen1);
      float f5 = this.jdField_a_of_type_Auel.a();
      float f4 = this.jdField_a_of_type_Auel.b();
      float f3;
      if (paramBoolean2)
      {
        paramFloat1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
        f3 = this.jdField_a_of_type_Auel.a(paramauen1.c(), paramFloat1);
        paramFloat2 = f3;
        if (paramauen2 != null) {
          paramFloat2 = a(f3, paramauen2.c(), f5, f4, paramFloat1);
        }
        if (auen.a(paramFloat2, paramauen1.c())) {
          break label510;
        }
        paramauen1.b(paramFloat2, f2, f1);
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
          this.jdField_a_of_type_Auej.a(paramauen1);
          this.jdField_a_of_type_Auej.a(paramauen1.a(), paramauen1.b(), f1, f2, jdField_a_of_type_AndroidGraphicsPointF);
          f4 = jdField_a_of_type_AndroidGraphicsPointF.x;
          f3 = jdField_a_of_type_AndroidGraphicsPointF.y;
          if (paramFloat2 >= f5) {
            break label500;
          }
          paramFloat1 = (float)Math.sqrt((paramFloat2 * paramFloat1 / f5 - 1.0F) / (paramFloat1 - 1.0F));
          this.jdField_a_of_type_Auej.a(f4, f3, jdField_a_of_type_AndroidGraphicsPointF);
          paramFloat2 = jdField_a_of_type_AndroidGraphicsPointF.x;
          f5 = jdField_a_of_type_AndroidGraphicsPointF.y;
          paramFloat2 += (f4 - paramFloat2) * paramFloat1;
        }
        for (paramFloat1 = (f3 - f5) * paramFloat1 + f5;; paramFloat1 = f3)
        {
          f4 = paramFloat1;
          f3 = paramFloat2;
          if (paramauen2 != null)
          {
            this.jdField_a_of_type_Auej.a(jdField_a_of_type_AndroidGraphicsRectF);
            f3 = b(paramFloat2, paramauen2.a(), jdField_a_of_type_AndroidGraphicsRectF.left, jdField_a_of_type_AndroidGraphicsRectF.right, f1);
            f4 = b(paramFloat1, paramauen2.b(), jdField_a_of_type_AndroidGraphicsRectF.top, jdField_a_of_type_AndroidGraphicsRectF.bottom, f2);
          }
          if ((!auen.a(f3, paramauen1.a())) || (!auen.a(f4, paramauen1.b())))
          {
            paramauen1.b(f3, f4);
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
  
  public boolean b(auen paramauen)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramauen.a(0.0F, 0.0F, this.jdField_a_of_type_Auel.a(paramauen).c(), 0.0F);
      auep.a(paramauen, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsRect);
      paramauen.b(jdField_a_of_type_AndroidGraphicsRect.left, jdField_a_of_type_AndroidGraphicsRect.top);
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
    a(paramauen, paramauen, (0.0F / 0.0F), (0.0F / 0.0F), false, false, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aueo
 * JD-Core Version:    0.7.0.1
 */