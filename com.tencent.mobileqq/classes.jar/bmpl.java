import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import cooperation.qzone.util.QZLog;

public class bmpl
  extends Drawable
  implements Animatable
{
  private float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new bmpn(this, Looper.getMainLooper());
  public bmpo a;
  private bmpp jdField_a_of_type_Bmpp;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bmpl()
  {
    this.jdField_a_of_type_Bmpp = new bmpp(this, null);
  }
  
  public bmpl(bmpp parambmpp)
  {
    this.jdField_a_of_type_Bmpp = parambmpp;
  }
  
  public bmpl(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bmpp = new bmpp(this, null);
    a(paramString, paramInt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bmpp.b();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bmpp.jdField_a_of_type_JavaLangString;
  }
  
  @Deprecated
  public void a()
  {
    this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null) {
      this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a(this.jdField_a_of_type_Float);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bmpp != null) && (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null)) {
      this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.c(paramInt);
    }
  }
  
  public void a(bmpo parambmpo)
  {
    this.jdField_a_of_type_Bmpo = parambmpo;
  }
  
  public void a(bmpx parambmpx)
  {
    if (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null) {
      this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a(parambmpx);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bmpp.a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bmpp != null) && (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bmpp != null) && (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null)) {
      this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Bmpp != null) && (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null)) {
      this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a(paramInt, null);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Bmpp == null) || (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr == null)) {}
    while (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a() == null) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    this.d = true;
    this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a(new bmpm(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_a_of_type_Bmpp.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a(0, null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 1000 / this.jdField_a_of_type_Bmpp.jdField_a_of_type_Int);
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
      } while (!this.jdField_a_of_type_Bmpp.jdField_a_of_type_Boolean);
      localDrawable = this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a();
    } while (localDrawable == null);
    localDrawable.setBounds(getBounds());
    localDrawable.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable;
    if (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null)
    {
      localDrawable = this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a();
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
    if (this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr != null)
    {
      localDrawable = this.jdField_a_of_type_Bmpp.jdField_a_of_type_Bmpr.a();
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
    this.jdField_a_of_type_Bmpp.a(paramRect);
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
    if (!this.jdField_a_of_type_Bmpp.jdField_a_of_type_Boolean) {
      return;
    }
    d();
  }
  
  public void stop()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("ZipAnimationDrawable", 2, "stop");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.jdField_a_of_type_Boolean = false;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpl
 * JD-Core Version:    0.7.0.1
 */