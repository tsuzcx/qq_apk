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

public class bpik
  extends bpio
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bpil jdField_a_of_type_Bpil;
  public bpim a;
  private bppo jdField_a_of_type_Bppo;
  public boolean a;
  private Paint b;
  protected int e = 1;
  public int f;
  
  public bpik(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    g();
    paramDoodleView.getResources().getDisplayMetrics();
  }
  
  private void a(bpim parambpim)
  {
    if (parambpim == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bppo.a(parambpim, StoryGuideLineView.a, true);
    boolean bool2 = this.jdField_a_of_type_Bppo.a(parambpim, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bppo.b(parambpim, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambpim.e = parambpim.w;
      parambpim.jdField_a_of_type_AndroidGraphicsPointF = parambpim.jdField_b_of_type_AndroidGraphicsPointF;
      parambpim.jdField_a_of_type_Float = parambpim.q;
      parambpim.jdField_b_of_type_Float = parambpim.r;
      parambpim.c = parambpim.s;
      parambpim.d = parambpim.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambpim.l, parambpim.r, parambpim.s, parambpim.t, parambpim.jdField_b_of_type_AndroidGraphicsPointF, parambpim.m, 0);
      if (this.jdField_a_of_type_Bpil == null) {
        break;
      }
      this.jdField_a_of_type_Bpil.a(bool1, bool2, false, bool3, parambpim.l);
      return;
      parambpim.w = parambpim.e;
      if (parambpim.jdField_a_of_type_AndroidGraphicsPointF != null) {
        parambpim.jdField_b_of_type_AndroidGraphicsPointF = parambpim.jdField_a_of_type_AndroidGraphicsPointF;
      }
      parambpim.q = parambpim.jdField_a_of_type_Float;
      parambpim.r = parambpim.jdField_b_of_type_Float;
      if (bool3)
      {
        parambpim.t = parambpim.d;
        if ((!bool1) && (!bool2)) {
          parambpim.c = parambpim.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambpim.s = parambpim.c;
        if (!bool3) {
          parambpim.d = parambpim.t;
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bppo = new bppo();
    this.jdField_a_of_type_Bppo.a(true);
    this.jdField_a_of_type_Bppo.a(18.0F);
    this.jdField_a_of_type_Bppo.b(0.5F);
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
    if (this.jdField_a_of_type_Bpim != null) {
      localBundle.putParcelable("vote_paster", new InteractPasterParcelData(this.jdField_a_of_type_Bpim));
    }
    return localBundle;
  }
  
  @Nullable
  public bpim a()
  {
    return this.jdField_a_of_type_Bpim;
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
    if (this.jdField_a_of_type_Bpim == null)
    {
      this.jdField_a_of_type_Bpim = new bpim(this, paramArrayOfString, paramBitmap, new PointF(zlx.a(this.jdField_a_of_type_AndroidContentContext) / 2, zlx.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;; this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bpim.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bpim.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bpim.q = paramFloat1;
      this.jdField_a_of_type_Bpim.r = paramFloat2;
      this.jdField_a_of_type_Bpim.s = paramFloat3;
      this.jdField_a_of_type_Bpim.t = paramFloat4;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.e == 1)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_Bpim != null) {
        this.jdField_a_of_type_Bpim.a(paramCanvas);
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
  
  public void a(bpil parambpil)
  {
    this.jdField_a_of_type_Bpil = parambpil;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bpim == null;
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
      this.jdField_a_of_type_Bppo.a(paramMotionEvent, false);
      if ((this.jdField_a_of_type_Bpim != null) && (this.jdField_a_of_type_Bppo.a() != null)) {
        break;
      }
      h();
      return true;
      this.f = i;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bpim);
      continue;
      if (j > 5)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!this.jdField_a_of_type_Boolean) {
          d();
        }
        this.jdField_a_of_type_Bppo.a();
        a(this, false);
        n();
      }
    }
    a(this.jdField_a_of_type_Bpim);
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
      if (this.jdField_a_of_type_Bppo.a(this.jdField_a_of_type_Bpim, f1, f2, false))
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
    if (this.jdField_a_of_type_Bpim != null)
    {
      if (!this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bpim = null;
    }
    if (this.jdField_a_of_type_Bpil != null) {
      this.jdField_a_of_type_Bpil.a();
    }
    k();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bpil != null) && (this.jdField_a_of_type_Bpim != null) && (this.jdField_a_of_type_Bpil.a(this.jdField_a_of_type_Bpim))) {
      this.jdField_a_of_type_Bpim = null;
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
 * Qualified Name:     bpik
 * JD-Core Version:    0.7.0.1
 */