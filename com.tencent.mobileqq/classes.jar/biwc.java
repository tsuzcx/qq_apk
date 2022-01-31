import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;
import java.lang.ref.WeakReference;

public class biwc
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 16.0F;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Property<biwc, Float> jdField_a_of_type_AndroidUtilProperty = new biwd(this, Float.class, "backHeight");
  private bixa jdField_a_of_type_Bixa = new bixa();
  private bixg jdField_a_of_type_Bixg = new bixg();
  private WeakReference<biwn> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 5.0F;
  private int jdField_b_of_type_Int = 255;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  Property<biwc, Integer> jdField_b_of_type_AndroidUtilProperty = new biwf(this, Integer.class, "backAlpha");
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 50.0F;
  private int jdField_c_of_type_Int;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  Property<biwc, Integer> jdField_c_of_type_AndroidUtilProperty = new biwg(this, Integer.class, "speedAlpha");
  private float jdField_d_of_type_Float = 50.0F;
  private int jdField_d_of_type_Int = 179;
  Property<biwc, Integer> jdField_d_of_type_AndroidUtilProperty = new biwh(this, Integer.class, "reverseAlpha");
  private float jdField_e_of_type_Float = 30.0F;
  private int jdField_e_of_type_Int;
  Property<biwc, Float> jdField_e_of_type_AndroidUtilProperty = new biwi(this, Float.class, "foreSpeed");
  private float jdField_f_of_type_Float = 22.0F;
  private int jdField_f_of_type_Int = 179;
  Property<biwc, Float> jdField_f_of_type_AndroidUtilProperty = new biwj(this, Float.class, "foreHeight");
  private int jdField_g_of_type_Int = -1;
  Property<biwc, Float> jdField_g_of_type_AndroidUtilProperty = new biwk(this, Float.class, "speedPos");
  private int jdField_h_of_type_Int = 0;
  Property<biwc, Integer> jdField_h_of_type_AndroidUtilProperty = new biwl(this, Integer.class, "markAlpha");
  
  private float a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
  }
  
  private void a(float paramFloat)
  {
    if (this.jdField_h_of_type_Int == 4)
    {
      float f1 = this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
      this.jdField_b_of_type_AndroidGraphicsRectF.offset(0.0F, paramFloat - f1);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        biwn localbiwn = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localbiwn != null) {
          localbiwn.a(this.jdField_h_of_type_Int, this.jdField_b_of_type_AndroidGraphicsRectF);
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int i = getBounds().height();
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    PropertyValuesHolder localPropertyValuesHolder3;
    if (paramInt1 == 1)
    {
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.jdField_a_of_type_AndroidGraphicsRectF.height(), i });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.jdField_f_of_type_AndroidUtilProperty, new float[] { this.jdField_c_of_type_AndroidGraphicsRectF.height(), i });
      localPropertyValuesHolder3 = PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, 115 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, PropertyValuesHolder.ofInt(this.jdField_c_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 0 }), PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.jdField_e_of_type_Int, 255 }), localPropertyValuesHolder3, PropertyValuesHolder.ofInt(this.jdField_h_of_type_AndroidUtilProperty, new int[] { this.jdField_f_of_type_Int, 127 }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new biwm(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new biwe(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      if (paramInt1 == 3)
      {
        localPropertyValuesHolder1 = PropertyValuesHolder.ofInt(this.jdField_b_of_type_AndroidUtilProperty, new int[] { this.jdField_a_of_type_Int, 0 });
        localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.jdField_a_of_type_AndroidGraphicsRectF.height(), 0.0F });
        localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat(this.jdField_f_of_type_AndroidUtilProperty, new float[] { this.jdField_c_of_type_AndroidGraphicsRectF.height(), (int)(i * 0.9F) });
        PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofFloat(this.jdField_e_of_type_AndroidUtilProperty, new float[] { this.jdField_b_of_type_AndroidGraphicsRectF.height(), (int)this.jdField_c_of_type_Float });
        PropertyValuesHolder localPropertyValuesHolder5 = PropertyValuesHolder.ofInt(this.jdField_c_of_type_AndroidUtilProperty, new int[] { this.jdField_b_of_type_Int, 255 });
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder3, localPropertyValuesHolder4, PropertyValuesHolder.ofInt(this.jdField_d_of_type_AndroidUtilProperty, new int[] { this.jdField_e_of_type_Int, 0 }), localPropertyValuesHolder2, localPropertyValuesHolder5, PropertyValuesHolder.ofInt(this.jdField_h_of_type_AndroidUtilProperty, new int[] { this.jdField_f_of_type_Int, 179 }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
      else if (paramInt1 == 4)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.jdField_g_of_type_AndroidUtilProperty, new float[] { paramFloat1, paramFloat2 }) });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramInt2);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_c_of_type_Float = PickerContainer.a(paramContext, this.jdField_c_of_type_Float);
    this.jdField_d_of_type_Float = PickerContainer.a(paramContext, this.jdField_d_of_type_Float);
    this.jdField_e_of_type_Float = PickerContainer.a(paramContext, this.jdField_e_of_type_Float);
    this.jdField_f_of_type_Float = PickerContainer.a(paramContext, this.jdField_f_of_type_Float);
    this.jdField_b_of_type_Float = PickerContainer.a(paramContext, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Float /= paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(Canvas paramCanvas)
  {
    RectF localRectF = this.jdField_a_of_type_Bixg.a(this.jdField_g_of_type_Int);
    if (localRectF != null)
    {
      float f1 = localRectF.centerX();
      float f2 = localRectF.centerY();
      f1 -= this.jdField_b_of_type_AndroidGraphicsRectF.width() / 2.0F;
      f2 -= this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F;
      float f3 = this.jdField_b_of_type_AndroidGraphicsRectF.width();
      float f4 = this.jdField_b_of_type_AndroidGraphicsRectF.height();
      paramCanvas.save();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    RectF localRectF = this.jdField_a_of_type_Bixg.a(this.jdField_c_of_type_Int - 1);
    if ((localRectF != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      float f1 = localRectF.centerX();
      float f2 = localRectF.centerY();
      f1 -= this.jdField_e_of_type_Float / 2.0F;
      f2 -= this.jdField_f_of_type_Float / 2.0F;
      float f3 = this.jdField_e_of_type_Float;
      float f4 = this.jdField_f_of_type_Float;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
      if (paramBoolean) {
        break label119;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_e_of_type_Int);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      label119:
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(255);
    }
  }
  
  private void a(Rect paramRect)
  {
    if (paramRect == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!this.jdField_b_of_type_Boolean) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("GroundDrawable", 2, "isrunning, cannot resetdata:" + this.jdField_h_of_type_Int);
          return;
          if ((this.jdField_h_of_type_Int != 0) && (this.jdField_h_of_type_Int != 1)) {
            break;
          }
          a(this.jdField_a_of_type_AndroidGraphicsRectF, paramRect.height() * 0.4F);
          if (this.jdField_a_of_type_Bixa != null) {
            this.jdField_a_of_type_Bixa.a(this.jdField_a_of_type_AndroidGraphicsRectF);
          }
          a(this.jdField_c_of_type_AndroidGraphicsRectF, paramRect.height() * 0.9F);
        } while (this.jdField_a_of_type_Bixg == null);
        this.jdField_a_of_type_Bixg.a(this.jdField_c_of_type_AndroidGraphicsRectF);
        return;
      } while ((this.jdField_h_of_type_Int != 3) && (this.jdField_h_of_type_Int != 2));
      a(this.jdField_a_of_type_AndroidGraphicsRectF, paramRect.height());
      a(this.jdField_c_of_type_AndroidGraphicsRectF, paramRect.height());
      if (this.jdField_a_of_type_Bixa != null) {
        this.jdField_a_of_type_Bixa.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
    } while (this.jdField_a_of_type_Bixg == null);
    this.jdField_a_of_type_Bixg.a(this.jdField_c_of_type_AndroidGraphicsRectF);
  }
  
  private void a(RectF paramRectF, float paramFloat)
  {
    if (paramRectF == null) {
      return;
    }
    Rect localRect = getBounds();
    float f1 = paramFloat;
    if (localRect.height() < paramFloat) {
      f1 = localRect.height();
    }
    float f2 = localRect.width() * 1.0F / localRect.height() * f1;
    paramFloat = f2;
    if (localRect.width() < f2) {
      paramFloat = localRect.width();
    }
    f2 = (localRect.width() - paramFloat) / 2.0F;
    float f3 = (localRect.height() - f1) / 2.0F;
    paramRectF.set(f2, f3, paramFloat + f2, f3 + f1);
  }
  
  private void a(Float paramFloat)
  {
    if (this.jdField_h_of_type_Int == 3)
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (this.jdField_b_of_type_AndroidGraphicsRectF.centerX() - paramFloat.floatValue() / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_b_of_type_AndroidGraphicsRectF.centerX() + paramFloat.floatValue() / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_AndroidGraphicsRectF.centerY() - paramFloat.floatValue() / 2.0F);
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_AndroidGraphicsRectF.centerY() + paramFloat.floatValue() / 2.0F);
    }
  }
  
  private float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.height();
  }
  
  private int b()
  {
    return this.jdField_f_of_type_Int;
  }
  
  private void b(float paramFloat)
  {
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 3))
    {
      a(this.jdField_a_of_type_AndroidGraphicsRectF, paramFloat);
      if (this.jdField_a_of_type_Bixa != null) {
        this.jdField_a_of_type_Bixa.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      }
    }
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 1))
    {
      this.jdField_f_of_type_Int = paramInt;
      return;
    }
    if (this.jdField_h_of_type_Int == 0)
    {
      this.jdField_f_of_type_Int = 179;
      return;
    }
    this.jdField_f_of_type_Int = 127;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)this.jdField_b_of_type_AndroidGraphicsRectF.left, (int)this.jdField_b_of_type_AndroidGraphicsRectF.top, (int)this.jdField_b_of_type_AndroidGraphicsRectF.right, (int)this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  private float c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.height();
  }
  
  private int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void c(float paramFloat)
  {
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 3))
    {
      a(this.jdField_c_of_type_AndroidGraphicsRectF, paramFloat);
      if (this.jdField_a_of_type_Bixg != null)
      {
        this.jdField_a_of_type_Bixg.a(this.jdField_c_of_type_AndroidGraphicsRectF);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          biwn localbiwn = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localbiwn != null) {
            localbiwn.a(this.jdField_h_of_type_Int, a());
          }
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = 115;
  }
  
  private float d()
  {
    return this.jdField_c_of_type_AndroidGraphicsRectF.height();
  }
  
  private int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 3))
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = 255;
  }
  
  private int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_h_of_type_Int == 1)
    {
      this.jdField_e_of_type_Int = paramInt;
      this.jdField_d_of_type_Int = (255 - this.jdField_e_of_type_Int);
    }
    while (this.jdField_h_of_type_Int != 3) {
      return;
    }
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_d_of_type_Int = ((int)((255 - this.jdField_e_of_type_Int) * 179 * 1.0F / 255.0F));
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    biwn localbiwn;
    do
    {
      return;
      localbiwn = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbiwn == null);
    localbiwn.b(paramInt);
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    biwn localbiwn;
    do
    {
      return;
      localbiwn = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbiwn == null);
    localbiwn.a(paramInt);
  }
  
  private void h(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    biwn localbiwn;
    do
    {
      return;
      localbiwn = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbiwn == null);
    localbiwn.c(paramInt);
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public int a(float paramFloat)
  {
    if (this.jdField_a_of_type_Bixg != null) {
      return this.jdField_a_of_type_Bixg.a(paramFloat);
    }
    return 0;
  }
  
  public RectF a()
  {
    if (this.jdField_a_of_type_Bixg != null) {
      return this.jdField_a_of_type_Bixg.a(this.jdField_g_of_type_Int);
    }
    return null;
  }
  
  public RectF a(float paramFloat)
  {
    int i = a(paramFloat);
    if (this.jdField_a_of_type_Bixg != null) {
      return this.jdField_a_of_type_Bixg.a(i);
    }
    return null;
  }
  
  public RectF a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_g_of_type_Int;
    this.jdField_g_of_type_Int = paramInt;
    if (paramBoolean1) {
      this.jdField_a_of_type_Boolean = paramBoolean1;
    }
    RectF localRectF;
    Object localObject;
    if (this.jdField_a_of_type_Bixg != null)
    {
      localRectF = this.jdField_a_of_type_Bixg.a(paramInt);
      if (localRectF != null)
      {
        if (paramBoolean2) {
          break label160;
        }
        this.jdField_b_of_type_AndroidGraphicsRectF.set(localRectF.centerX() - this.jdField_c_of_type_Float / 2.0F, localRectF.centerY() - this.jdField_d_of_type_Float / 2.0F, localRectF.centerX() + this.jdField_d_of_type_Float / 2.0F, localRectF.centerY() + this.jdField_d_of_type_Float / 2.0F);
        if ((paramBoolean1) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
        {
          localObject = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null)
          {
            ((biwn)localObject).a(this.jdField_h_of_type_Int, this.jdField_g_of_type_Int, localRectF);
            this.jdField_a_of_type_Boolean = false;
          }
        }
        invalidateSelf();
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_AndroidGraphicsRectF;
      label160:
      localObject = this.jdField_a_of_type_Bixg.a(i);
      if (localObject != null)
      {
        this.jdField_b_of_type_AndroidGraphicsRectF.set(((RectF)localObject).centerX() - this.jdField_c_of_type_Float / 2.0F, ((RectF)localObject).centerY() - this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject).centerX() + this.jdField_d_of_type_Float / 2.0F, ((RectF)localObject).centerY() + this.jdField_d_of_type_Float / 2.0F);
        float f1 = Math.abs(((RectF)localObject).centerY() - localRectF.centerY());
        float f2 = this.jdField_a_of_type_Float;
        if (isRunning()) {
          stop();
        }
        this.jdField_h_of_type_Int = 4;
        this.jdField_b_of_type_Boolean = true;
        a(this.jdField_h_of_type_Int, (int)(f1 * f2), ((RectF)localObject).centerY(), localRectF.centerY());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bixg.a();
    this.jdField_a_of_type_Bixa.a();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_AndroidUtilProperty = null;
    this.jdField_b_of_type_AndroidUtilProperty = null;
    this.jdField_c_of_type_AndroidUtilProperty = null;
    this.jdField_d_of_type_AndroidUtilProperty = null;
    this.jdField_e_of_type_AndroidUtilProperty = null;
    this.jdField_f_of_type_AndroidUtilProperty = null;
    this.jdField_g_of_type_AndroidUtilProperty = null;
    this.jdField_h_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    switch (this.jdField_h_of_type_Int)
    {
    }
  }
  
  public boolean a(Context paramContext, int paramInt, float paramFloat1, float paramFloat2, biwn parambiwn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambiwn);
    if (paramInt > 0) {
      this.jdField_a_of_type_Float /= paramInt;
    }
    a(paramContext);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bixg.a(-1, paramInt, this.jdField_b_of_type_Float, paramFloat1, paramFloat2);
    this.jdField_a_of_type_Bixa.a(0, paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841032);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841031);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_h_of_type_Int == 0)
    {
      this.jdField_a_of_type_Bixg.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
      if ((this.jdField_g_of_type_Int >= 0) && (this.jdField_g_of_type_Int < this.jdField_c_of_type_Int)) {
        a(paramCanvas);
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 2))
      {
        this.jdField_a_of_type_Bixa.a(paramCanvas, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bixg.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 127.0F / 255.0F), this.jdField_f_of_type_Int);
        a(paramCanvas, false);
        if ((this.jdField_h_of_type_Int == 3) || (this.jdField_h_of_type_Int == 1))
        {
          if (this.jdField_g_of_type_Int == this.jdField_c_of_type_Int - 1)
          {
            a(paramCanvas, true);
            return;
          }
          a(paramCanvas);
        }
      }
      else if (this.jdField_h_of_type_Int == 4)
      {
        RectF localRectF = a();
        if (localRectF != null)
        {
          if (Math.abs(localRectF.centerY() - this.jdField_b_of_type_AndroidGraphicsRectF.centerY()) >= this.jdField_b_of_type_AndroidGraphicsRectF.height() / 2.0F) {
            break label292;
          }
          this.jdField_a_of_type_Bixg.a(paramCanvas, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
        }
        while ((this.jdField_g_of_type_Int >= 0) && (this.jdField_g_of_type_Int < this.jdField_c_of_type_Int))
        {
          b(paramCanvas);
          return;
          label292:
          this.jdField_a_of_type_Bixg.a(paramCanvas, this.jdField_d_of_type_Int, -1, (int)(this.jdField_e_of_type_Int * 1.0F * 179.0F / 255.0F), this.jdField_f_of_type_Int);
        }
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a(paramRect);
    if (this.jdField_g_of_type_Int >= 0)
    {
      a(this.jdField_g_of_type_Int, false, false);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramRect = (biwn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramRect != null)
        {
          RectF localRectF = new RectF();
          localRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF);
          paramRect.a(this.jdField_h_of_type_Int, this.jdField_g_of_type_Int, localRectF);
          this.jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("GroundDrawable", 2, "start :" + this.jdField_h_of_type_Int);
    }
    if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 0))
    {
      this.jdField_h_of_type_Int = 1;
      a(this.jdField_h_of_type_Int, 300, -1.0F, -1.0F);
    }
    while ((this.jdField_h_of_type_Int != 3) && (this.jdField_h_of_type_Int != 2)) {
      return;
    }
    this.jdField_h_of_type_Int = 3;
    a(this.jdField_h_of_type_Int, 200, -1.0F, -1.0F);
  }
  
  public void stop()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
      if (this.jdField_h_of_type_Int == 1)
      {
        this.jdField_h_of_type_Int = 2;
        a(getBounds());
        this.jdField_a_of_type_Int = 115;
        return;
      }
    } while (this.jdField_h_of_type_Int != 3);
    this.jdField_h_of_type_Int = 0;
    a(getBounds());
    this.jdField_a_of_type_Int = 115;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwc
 * JD-Core Version:    0.7.0.1
 */