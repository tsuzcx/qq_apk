import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.qphone.base.util.QLog;

public class aqfz
  extends aztf
{
  public int a;
  public long a;
  public Context a;
  protected RectF a;
  public View a;
  private Interpolator a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public int d;
  public int e;
  
  public aqfz(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_Int = 2;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
  }
  
  private void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_b_of_type_Int = 2;
  }
  
  public RectF a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.f - 0.0F, this.g - 0.0F - paramInt, this.f + this.h + 0.0F, 0.0F + (this.g + this.i) - paramInt);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = (int)(paramInt + this.jdField_a_of_type_Int * (this.jdField_b_of_type_Float - 1.0F));
    }
    this.g = i;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.e = this.jdField_a_of_type_Int;
    this.d = (this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.jdField_b_of_type_Int = 1;
    a(paramLong);
  }
  
  protected void a(Canvas paramCanvas) {}
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool2 = false;
    b();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.c);
    a(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {}
    for (boolean bool1 = super.a(paramCanvas);; bool1 = false)
    {
      b(paramCanvas);
      paramCanvas.restore();
      if ((this.jdField_a_of_type_Boolean) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / (float)this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {}
    for (float f1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f2);; f1 = f2)
    {
      float f3 = this.e;
      a((int)(f1 * (this.d - this.e) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.jdField_b_of_type_Int)
      {
      case 2: 
      default: 
        f();
        return;
      case 1: 
        this.jdField_b_of_type_Int = 3;
        c();
        return;
      }
      this.jdField_b_of_type_Int = 2;
      return;
    }
  }
  
  protected void b(Canvas paramCanvas) {}
  
  public void c()
  {
    this.e = this.g;
    this.d = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new aqga(this);
    a(1500L);
  }
  
  public void d() {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "stopActiveSanHua stopAnimation");
    }
    super.e();
    f();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfz
 * JD-Core Version:    0.7.0.1
 */