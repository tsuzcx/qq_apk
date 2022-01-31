import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.InteractPasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class bmms
  extends bmmw
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bmmt jdField_a_of_type_Bmmt;
  public bmmu a;
  private bmtw jdField_a_of_type_Bmtw;
  public boolean a;
  private Paint b;
  protected int e = 1;
  public int f;
  
  public bmms(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    g();
    paramDoodleView.getResources().getDisplayMetrics();
  }
  
  private void a(bmmu parambmmu)
  {
    if (parambmmu == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bmtw.a(parambmmu, StoryGuideLineView.a, true);
    boolean bool2 = this.jdField_a_of_type_Bmtw.a(parambmmu, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bmtw.b(parambmmu, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambmmu.e = parambmmu.w;
      parambmmu.jdField_a_of_type_AndroidGraphicsPointF = parambmmu.jdField_b_of_type_AndroidGraphicsPointF;
      parambmmu.jdField_a_of_type_Float = parambmmu.q;
      parambmmu.jdField_b_of_type_Float = parambmmu.r;
      parambmmu.c = parambmmu.s;
      parambmmu.d = parambmmu.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambmmu.l, parambmmu.r, parambmmu.s, parambmmu.t, parambmmu.jdField_b_of_type_AndroidGraphicsPointF, parambmmu.m, 0);
      if (this.jdField_a_of_type_Bmmt == null) {
        break;
      }
      this.jdField_a_of_type_Bmmt.a(bool1, bool2, false, bool3, parambmmu.l);
      return;
      parambmmu.w = parambmmu.e;
      if (parambmmu.jdField_a_of_type_AndroidGraphicsPointF != null) {
        parambmmu.jdField_b_of_type_AndroidGraphicsPointF = parambmmu.jdField_a_of_type_AndroidGraphicsPointF;
      }
      parambmmu.q = parambmmu.jdField_a_of_type_Float;
      parambmmu.r = parambmmu.jdField_b_of_type_Float;
      if (bool3)
      {
        parambmmu.t = parambmmu.d;
        if ((!bool1) && (!bool2)) {
          parambmmu.c = parambmmu.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambmmu.s = parambmmu.c;
        if (!bool3) {
          parambmmu.d = parambmmu.t;
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bmtw = new bmtw();
    this.jdField_a_of_type_Bmtw.a(true);
    this.jdField_a_of_type_Bmtw.a(18.0F);
    this.jdField_a_of_type_Bmtw.b(0.5F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColor(Color.parseColor("#3DB8FF"));
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(2.0F);
    this.b.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private void h()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  public Bundle a()
  {
    Bundle localBundle = super.a();
    if (this.jdField_a_of_type_Bmmu != null) {
      localBundle.putParcelable("vote_paster", new InteractPasterParcelData(this.jdField_a_of_type_Bmmu));
    }
    return localBundle;
  }
  
  @Nullable
  public bmmu a()
  {
    return this.jdField_a_of_type_Bmmu;
  }
  
  public String a()
  {
    return "VoteLayer";
  }
  
  public void a()
  {
    c();
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_Bmmu == null)
    {
      this.jdField_a_of_type_Bmmu = new bmmu(this, paramArrayOfString, paramBitmap, new PointF(xod.a(this.jdField_a_of_type_AndroidContentContext) / 2, xod.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bmmu.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (this.jdField_a_of_type_Bmmu.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;; this.jdField_a_of_type_Bmmu.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bmmu.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bmmu.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bmmu.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bmmu.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bmmu.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bmmu.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bmmu.q = paramFloat1;
      this.jdField_a_of_type_Bmmu.r = paramFloat2;
      this.jdField_a_of_type_Bmmu.s = paramFloat3;
      this.jdField_a_of_type_Bmmu.t = paramFloat4;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.e == 1)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_Bmmu != null) {
        this.jdField_a_of_type_Bmmu.a(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    paramBundle = (InteractPasterParcelData)paramBundle.getParcelable("vote_paster");
  }
  
  public void a(bmmt parambmmt)
  {
    this.jdField_a_of_type_Bmmt = parambmmt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bmmu == null;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.f);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmtw.a(paramMotionEvent, false);
      if ((this.jdField_a_of_type_Bmmu != null) && (this.jdField_a_of_type_Bmtw.a() != null)) {
        break;
      }
      h();
      return true;
      this.f = i;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmmu);
      continue;
      if (j > 5)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!this.jdField_a_of_type_Boolean) {
          d();
        }
        this.jdField_a_of_type_Bmtw.a();
        a(this, false);
        n();
      }
    }
    a(this.jdField_a_of_type_Bmmu);
    return true;
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.e != 1) {}
    do
    {
      return false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Bmtw.a(this.jdField_a_of_type_Bmmu, f1, f2, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoteLayer", 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoteLayer", 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    return false;
  }
  
  public void c()
  {
    this.e = 1;
    if (this.jdField_a_of_type_Bmmu != null)
    {
      if (!this.jdField_a_of_type_Bmmu.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bmmu.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bmmu = null;
    }
    if (this.jdField_a_of_type_Bmmt != null) {
      this.jdField_a_of_type_Bmmt.a();
    }
    k();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bmmt != null) && (this.jdField_a_of_type_Bmmu != null) && (this.jdField_a_of_type_Bmmt.a(this.jdField_a_of_type_Bmmu))) {
      this.jdField_a_of_type_Bmmu = null;
    }
  }
  
  public void e()
  {
    this.e = 2;
    k();
  }
  
  public void f()
  {
    this.e = 1;
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmms
 * JD-Core Version:    0.7.0.1
 */