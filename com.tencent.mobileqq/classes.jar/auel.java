import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;

public class auel
{
  private static final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_a_of_type_Float;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private float b;
  private float c;
  
  public auel(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(float paramFloat1, float paramFloat2)
  {
    return aueq.a(paramFloat1, this.jdField_a_of_type_Float / paramFloat2, this.b * paramFloat2);
  }
  
  public auel a(auen paramauen)
  {
    float f5 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e();
    float f6 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f();
    float f7 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.c();
    float f8 = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.d();
    if ((f5 == 0.0F) || (f6 == 0.0F) || (f7 == 0.0F) || (f8 == 0.0F))
    {
      this.c = 1.0F;
      this.b = 1.0F;
      this.jdField_a_of_type_Float = 1.0F;
      return this;
    }
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a();
    this.b = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.b();
    float f9 = paramauen.d();
    float f3 = f8;
    float f1 = f7;
    float f2 = f6;
    float f4 = f5;
    label262:
    label267:
    if (!auen.a(f9, 0.0F))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() == Settings.Fit.OUTSIDE)
      {
        jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-f9);
        jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f7, f8);
        jdField_a_of_type_AndroidGraphicsMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
        f1 = jdField_a_of_type_AndroidGraphicsRectF.width();
        f3 = jdField_a_of_type_AndroidGraphicsRectF.height();
        f4 = f5;
        f2 = f6;
      }
    }
    else {
      label202:
      switch (auem.a[this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a().ordinal()])
      {
      default: 
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          f1 = this.jdField_a_of_type_Float;
          this.c = f1;
          if (this.jdField_a_of_type_Float <= 0.0F) {
            this.jdField_a_of_type_Float = this.c;
          }
          if (this.b <= 0.0F) {
            this.b = this.c;
          }
          if (this.c > this.b)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a()) {
              break label501;
            }
            this.b = this.c;
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Float > this.b) {
        this.jdField_a_of_type_Float = this.b;
      }
      if (this.c >= this.jdField_a_of_type_Float) {
        break;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a()) {
        break label512;
      }
      this.jdField_a_of_type_Float = this.c;
      return this;
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(f9);
      jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f5, f6);
      jdField_a_of_type_AndroidGraphicsMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      f4 = jdField_a_of_type_AndroidGraphicsRectF.width();
      f2 = jdField_a_of_type_AndroidGraphicsRectF.height();
      f3 = f8;
      f1 = f7;
      break label202;
      this.c = (f1 / f4);
      break label267;
      this.c = (f3 / f2);
      break label267;
      this.c = Math.min(f1 / f4, f3 / f2);
      break label267;
      this.c = Math.max(f1 / f4, f3 / f2);
      break label267;
      f1 = 1.0F;
      break label262;
      label501:
      this.c = this.b;
    }
    label512:
    this.c = this.jdField_a_of_type_Float;
    return this;
  }
  
  public float b()
  {
    return this.b;
  }
  
  public float c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auel
 * JD-Core Version:    0.7.0.1
 */