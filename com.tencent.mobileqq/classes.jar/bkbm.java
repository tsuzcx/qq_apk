import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import org.json.JSONObject;

public abstract class bkbm
  implements bkbq
{
  private static String a;
  protected float a;
  public Context a;
  public Rect a;
  protected bkbn a;
  protected DoodleView a;
  protected boolean c;
  protected Paint h;
  protected Paint i;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BaseLayer";
  }
  
  public bkbm(DoodleView paramDoodleView)
  {
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.jdField_a_of_type_AndroidContentContext = paramDoodleView.getContext();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(5.0F);
    this.i.setColor(-16776961);
    this.c = false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("BaseLayer:TopLevelWeight", this.t);
    return localBundle;
  }
  
  public abstract String a();
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException("illegal width or height, width=" + paramInt1 + ",height=" + paramInt2);
    }
    ved.b("BaseLayer", "layer size,width=" + paramInt1 + ",height=" + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = paramInt2;
    this.r = this.jdField_a_of_type_AndroidGraphicsRect.left;
    this.s = this.jdField_a_of_type_AndroidGraphicsRect.right;
    this.p = this.jdField_a_of_type_AndroidGraphicsRect.top;
    this.q = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    b(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    a(paramCanvas, paramFloat);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.t = paramBundle.getInt("BaseLayer:TopLevelWeight");
  }
  
  public void a(bkbn parambkbn)
  {
    this.jdField_a_of_type_Bkbn = parambkbn;
  }
  
  public abstract boolean a(long paramLong);
  
  protected abstract boolean a(MotionEvent paramMotionEvent);
  
  public boolean a(JSONObject paramJSONObject)
  {
    return false;
  }
  
  public void b()
  {
    ved.b("BaseLayer", getClass().getName() + " onDestroy.");
  }
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.width();
  }
  
  public int d()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.height();
  }
  
  public void d(int paramInt)
  {
    this.t = (paramInt + 1);
  }
  
  public final void d(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setActiveLayer(this);
    }
    for (;;)
    {
      k();
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.f();
    }
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public final boolean d(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bkbn != null) {
      this.jdField_a_of_type_Bkbn.a(this, paramMotionEvent);
    }
    k();
    return a(paramMotionEvent);
  }
  
  public int i_()
  {
    return this.t;
  }
  
  public void k()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.postInvalidate();
  }
  
  public void l()
  {
    ved.b("BaseLayer", getClass().getName() + " onPause.");
    this.c = false;
  }
  
  public void m()
  {
    ved.b("BaseLayer", getClass().getName() + " onResume.");
    this.c = true;
  }
  
  public void n()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbm
 * JD-Core Version:    0.7.0.1
 */