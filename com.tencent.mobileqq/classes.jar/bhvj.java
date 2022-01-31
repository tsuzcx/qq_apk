import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public class bhvj
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new bhvl(this, Looper.getMainLooper());
  public bhvm a;
  private bhvn jdField_a_of_type_Bhvn;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bhvj()
  {
    this.jdField_a_of_type_Bhvn = new bhvn(this, null);
  }
  
  public bhvj(bhvn parambhvn)
  {
    this.jdField_a_of_type_Bhvn = parambhvn;
  }
  
  public bhvj(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bhvn = new bhvn(this, null);
    a(paramString, paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bhvn.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bhvn.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a()
  {
    this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null) {
      this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a(this.jdField_a_of_type_Float);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bhvn != null) && (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null)) {
      this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.c(paramInt);
    }
  }
  
  public void a(bhvm parambhvm)
  {
    this.jdField_a_of_type_Bhvm = parambhvm;
  }
  
  public void a(bhvv parambhvv)
  {
    if (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null) {
      this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a(parambhvv);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bhvn.a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bhvn != null) && (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhvn != null) && (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null)) {
      this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Bhvn != null) && (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null)) {
      this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a(paramInt, null);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Bhvn == null) || (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp == null)) {}
    while (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a() == null) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    this.d = true;
    this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a(new bhvk(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_a_of_type_Bhvn.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a(0, null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 1000 / this.jdField_a_of_type_Bhvn.jdField_a_of_type_Int);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b) && (!this.d)) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Bhvn.jdField_a_of_type_Boolean);
      localDrawable = this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a();
    } while (localDrawable == null);
    localDrawable.setBounds(getBounds());
    localDrawable.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable;
    if (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null)
    {
      localDrawable = this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicHeight() * this.jdField_a_of_type_Float);
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable;
    if (this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp != null)
    {
      localDrawable = this.jdField_a_of_type_Bhvn.jdField_a_of_type_Bhvp.a();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicWidth() * this.jdField_a_of_type_Float);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_Bhvn.a(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (isVisible() != paramBoolean1)
    {
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean1) {
          break label48;
        }
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
        }
      }
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      i = 0;
      break;
      label48:
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
  }
  
  public void start()
  {
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_a_of_type_Bhvn.jdField_a_of_type_Boolean) {
      return;
    }
    d();
  }
  
  public void stop()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Boolean = false;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhvj
 * JD-Core Version:    0.7.0.1
 */