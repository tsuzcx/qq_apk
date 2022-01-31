import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.Settings.Fit;

public class avvp
{
  private static final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private static final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final float[] jdField_a_of_type_ArrayOfFloat = new float[2];
  private float jdField_a_of_type_Float;
  private final Settings jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings;
  private float jdField_b_of_type_Float;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float c;
  
  public avvp(Settings paramSettings)
  {
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings = paramSettings;
  }
  
  private void a(Rect paramRect)
  {
    avvv.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsPoint);
    jdField_a_of_type_ArrayOfFloat[0] = jdField_a_of_type_AndroidGraphicsPoint.x;
    jdField_a_of_type_ArrayOfFloat[1] = jdField_a_of_type_AndroidGraphicsPoint.y;
    if (!avvt.a(this.jdField_a_of_type_Float, 0.0F))
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (jdField_a_of_type_ArrayOfFloat[0] - paramRect.width());
    this.jdField_b_of_type_AndroidGraphicsRectF.right = jdField_a_of_type_ArrayOfFloat[0];
    this.jdField_b_of_type_AndroidGraphicsRectF.top = (jdField_a_of_type_ArrayOfFloat[1] - paramRect.height());
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = jdField_a_of_type_ArrayOfFloat[1];
  }
  
  private void a(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
      this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.left;
    }
    while (paramRectF.height() < paramRect.height())
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.top;
      return;
      localRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
      RectF localRectF2 = this.jdField_b_of_type_AndroidGraphicsRectF;
      f = paramRect.left;
      localRectF2.right = f;
      localRectF1.left = f;
    }
    paramRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    RectF localRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f = paramRect.top;
    localRectF1.bottom = f;
    paramRectF.top = f;
  }
  
  private void b(RectF paramRectF, Rect paramRect)
  {
    if (paramRectF.width() < paramRect.width()) {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - (paramRect.width() - paramRectF.width()));
    }
    for (this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.left; paramRectF.height() < paramRect.height(); this.jdField_b_of_type_AndroidGraphicsRectF.right = (paramRectF.right - paramRect.width()))
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - (paramRect.height() - paramRectF.height()));
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.top;
      return;
      this.jdField_b_of_type_AndroidGraphicsRectF.left = paramRectF.left;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.top = paramRectF.top;
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (paramRectF.bottom - paramRect.height());
  }
  
  private void c(RectF paramRectF, Rect paramRect)
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.left = (paramRectF.left - paramRect.width());
    this.jdField_b_of_type_AndroidGraphicsRectF.right = paramRectF.right;
    this.jdField_b_of_type_AndroidGraphicsRectF.top = (paramRectF.top - paramRect.height());
    this.jdField_b_of_type_AndroidGraphicsRectF.bottom = paramRectF.bottom;
  }
  
  public avvp a(avvt paramavvt)
  {
    Object localObject = jdField_a_of_type_AndroidGraphicsRectF;
    avvv.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, jdField_a_of_type_AndroidGraphicsRect);
    ((RectF)localObject).set(jdField_a_of_type_AndroidGraphicsRect);
    Rect localRect = jdField_a_of_type_AndroidGraphicsRect;
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() == Settings.Fit.OUTSIDE)
    {
      this.jdField_a_of_type_Float = paramavvt.d();
      this.jdField_b_of_type_Float = ((RectF)localObject).centerX();
      this.c = ((RectF)localObject).centerY();
      if (!avvt.a(this.jdField_a_of_type_Float, 0.0F))
      {
        jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
        jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
      }
      paramavvt.a(jdField_a_of_type_AndroidGraphicsMatrix);
      if (!avvt.a(this.jdField_a_of_type_Float, 0.0F)) {
        jdField_a_of_type_AndroidGraphicsMatrix.postRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      }
      avvv.a(jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings, localRect);
      switch (avvq.a[this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a().ordinal()])
      {
      default: 
        this.jdField_b_of_type_AndroidGraphicsRectF.set(-5.368709E+008F, -5.368709E+008F, 5.368709E+008F, 5.368709E+008F);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.a() != Settings.Fit.OUTSIDE)
      {
        paramavvt.a(jdField_a_of_type_AndroidGraphicsMatrix);
        paramavvt = jdField_a_of_type_AndroidGraphicsRectF;
        paramavvt.set(0.0F, 0.0F, this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.e(), this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureSettings.f());
        jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramavvt);
        localObject = jdField_a_of_type_ArrayOfFloat;
        jdField_a_of_type_ArrayOfFloat[1] = 0.0F;
        localObject[0] = 0.0F;
        jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
        this.jdField_b_of_type_AndroidGraphicsRectF.offset(jdField_a_of_type_ArrayOfFloat[0] - paramavvt.left, jdField_a_of_type_ArrayOfFloat[1] - paramavvt.top);
      }
      return this;
      this.jdField_a_of_type_Float = 0.0F;
      this.c = 0.0F;
      this.jdField_b_of_type_Float = 0.0F;
      break;
      a((RectF)localObject, localRect);
      continue;
      b((RectF)localObject, localRect);
      continue;
      c((RectF)localObject, localRect);
      continue;
      a(localRect);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.union(jdField_a_of_type_ArrayOfFloat[0], jdField_a_of_type_ArrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    jdField_a_of_type_ArrayOfFloat[0] = paramFloat1;
    jdField_a_of_type_ArrayOfFloat[1] = paramFloat2;
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    jdField_a_of_type_ArrayOfFloat[0] = avvw.a(jdField_a_of_type_ArrayOfFloat[0], this.jdField_b_of_type_AndroidGraphicsRectF.left - paramFloat3, this.jdField_b_of_type_AndroidGraphicsRectF.right + paramFloat3);
    jdField_a_of_type_ArrayOfFloat[1] = avvw.a(jdField_a_of_type_ArrayOfFloat[1], this.jdField_b_of_type_AndroidGraphicsRectF.top - paramFloat4, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + paramFloat4);
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      jdField_a_of_type_AndroidGraphicsMatrix.setRotate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
      jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(jdField_a_of_type_ArrayOfFloat);
    }
    paramPointF.set(jdField_a_of_type_ArrayOfFloat[0], jdField_a_of_type_ArrayOfFloat[1]);
  }
  
  public void a(float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    a(paramFloat1, paramFloat2, 0.0F, 0.0F, paramPointF);
  }
  
  public void a(RectF paramRectF)
  {
    if (this.jdField_a_of_type_Float == 0.0F)
    {
      paramRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
      return;
    }
    jdField_a_of_type_AndroidGraphicsMatrix.setRotate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c);
    jdField_a_of_type_AndroidGraphicsMatrix.mapRect(paramRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avvp
 * JD-Core Version:    0.7.0.1
 */