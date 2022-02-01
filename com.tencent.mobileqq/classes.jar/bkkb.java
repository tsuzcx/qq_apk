import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class bkkb
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 300;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 0;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  
  public bkkb(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130841461);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130841462);
    this.jdField_d_of_type_Int = ((int)(paramContext.getDisplayMetrics().density * 300.0F + 0.5F));
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
  }
  
  private void c()
  {
    float f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) / this.m, 1.0F);
    float f2 = this.jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1);
    this.jdField_a_of_type_Float = (this.jdField_e_of_type_Float + (this.f - this.jdField_e_of_type_Float) * f2);
    this.jdField_b_of_type_Float = (this.g + (this.h - this.g) * f2);
    this.jdField_c_of_type_Float = (this.i + (this.j - this.i) * f2);
    this.jdField_d_of_type_Float = (this.k + (this.l - this.k) * f2);
    if (f1 >= 0.999F) {}
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_e_of_type_Int = 3;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.m = 1000.0F;
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Float;
      this.g = this.jdField_b_of_type_Float;
      this.i = this.jdField_c_of_type_Float;
      this.k = this.jdField_d_of_type_Float;
      this.f = 0.0F;
      this.h = 0.0F;
      this.j = 0.0F;
      this.l = 0.0F;
      return;
    case 1: 
      this.jdField_e_of_type_Int = 4;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.m = 1000.0F;
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Float;
      this.g = this.jdField_b_of_type_Float;
      this.i = this.jdField_c_of_type_Float;
      this.k = this.jdField_d_of_type_Float;
      this.f = 0.0F;
      this.h = 0.0F;
      this.j = 0.0F;
      this.l = 0.0F;
      return;
    case 4: 
      if (this.l != 0.0F) {}
      for (f1 = 1.0F / (this.l * this.l);; f1 = 3.4028235E+38F)
      {
        float f3 = this.g;
        this.jdField_b_of_type_Float = (f1 * (f2 * (this.h - this.g)) + f3);
        this.jdField_e_of_type_Int = 3;
        return;
      }
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  public void a()
  {
    this.jdField_e_of_type_Int = 0;
  }
  
  public void a(float paramFloat)
  {
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    if ((this.jdField_e_of_type_Int == 4) && ((float)(l1 - this.jdField_a_of_type_Long) < this.m)) {
      return;
    }
    if (this.jdField_e_of_type_Int != 1) {
      this.jdField_d_of_type_Float = 1.0F;
    }
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_Long = l1;
    this.m = 167.0F;
    this.n += paramFloat;
    float f1 = Math.abs(this.n);
    float f2 = Math.max(0.6F, Math.min(f1, 0.8F));
    this.jdField_e_of_type_Float = f2;
    this.jdField_a_of_type_Float = f2;
    f1 = Math.max(0.5F, Math.min(f1 * 7.0F, 1.0F));
    this.g = f1;
    this.jdField_b_of_type_Float = f1;
    f1 = Math.min(0.8F, this.jdField_c_of_type_Float + Math.abs(paramFloat) * 1.1F);
    this.i = f1;
    this.jdField_c_of_type_Float = f1;
    f2 = Math.abs(paramFloat);
    f1 = f2;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      if (this.n < 0.0F) {
        f1 = -f2;
      }
    }
    if (this.n == 0.0F) {
      this.jdField_d_of_type_Float = 0.0F;
    }
    paramFloat = Math.min(4.0F, Math.max(0.0F, f1 * 7.0F + this.jdField_d_of_type_Float));
    this.k = paramFloat;
    this.jdField_d_of_type_Float = paramFloat;
    this.f = this.jdField_a_of_type_Float;
    this.h = this.jdField_b_of_type_Float;
    this.j = this.jdField_c_of_type_Float;
    this.l = this.jdField_d_of_type_Float;
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = 2;
    paramInt = Math.max(100, Math.abs(paramInt));
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.m = (0.1F + paramInt * 0.03F);
    this.jdField_e_of_type_Float = 0.0F;
    this.g = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.i = 0.5F;
    this.k = 0.0F;
    this.f = Math.max(0, Math.min(paramInt * 8, 1));
    this.h = Math.max(0.5F, Math.min(paramInt * 8, 1.0F));
    this.l = Math.min(0.025F + paramInt / 100 * paramInt * 0.00015F, 1.75F);
    this.j = Math.max(this.i, Math.min(paramInt * 16 * 1.0E-005F, 0.8F));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Int == 0;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool = false;
    c();
    int i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    int i2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    int i3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha((int)(Math.max(0.0F, Math.min(this.jdField_c_of_type_Float, 1.0F)) * 255.0F));
    i2 = (int)Math.min(i2 * this.jdField_d_of_type_Float * i2 / i3 * 0.6F, i2 * 4.0F);
    if (this.jdField_a_of_type_Int < this.jdField_d_of_type_Int)
    {
      i3 = (this.jdField_a_of_type_Int - this.jdField_d_of_type_Int) / 2;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i3, 0, this.jdField_a_of_type_Int - i3, i2);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha((int)(Math.max(0.0F, Math.min(this.jdField_a_of_type_Float, 1.0F)) * 255.0F));
      i1 = (int)(i1 * this.jdField_b_of_type_Float);
      if (this.jdField_a_of_type_Int >= this.jdField_d_of_type_Int) {
        break label249;
      }
      i2 = (this.jdField_a_of_type_Int - this.jdField_d_of_type_Int) / 2;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i2, 0, this.jdField_a_of_type_Int - i2, i1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      if (this.jdField_e_of_type_Int != 0) {
        bool = true;
      }
      return bool;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, i2);
      break;
      label249:
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, i1);
    }
  }
  
  public void b()
  {
    this.n = 0.0F;
    if ((this.jdField_e_of_type_Int != 1) && (this.jdField_e_of_type_Int != 4)) {
      return;
    }
    this.jdField_e_of_type_Int = 3;
    this.jdField_e_of_type_Float = this.jdField_a_of_type_Float;
    this.g = this.jdField_b_of_type_Float;
    this.i = this.jdField_c_of_type_Float;
    this.k = this.jdField_d_of_type_Float;
    this.f = 0.0F;
    this.h = 0.0F;
    this.j = 0.0F;
    this.l = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.m = 1000.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkkb
 * JD-Core Version:    0.7.0.1
 */