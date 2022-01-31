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

public class bkbi
  extends bkbm
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bkbj jdField_a_of_type_Bkbj;
  public bkbk a;
  private bkim jdField_a_of_type_Bkim;
  public boolean a;
  private Paint b;
  protected int e = 1;
  public int f;
  
  public bkbi(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    g();
    paramDoodleView.getResources().getDisplayMetrics();
  }
  
  private void a(bkbk parambkbk)
  {
    if (parambkbk == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Bkim.a(parambkbk, StoryGuideLineView.a, true);
    boolean bool2 = this.jdField_a_of_type_Bkim.a(parambkbk, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_Bkim.b(parambkbk, StoryGuideLineView.d, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      parambkbk.e = parambkbk.w;
      parambkbk.jdField_a_of_type_AndroidGraphicsPointF = parambkbk.jdField_b_of_type_AndroidGraphicsPointF;
      parambkbk.jdField_a_of_type_Float = parambkbk.q;
      parambkbk.jdField_b_of_type_Float = parambkbk.r;
      parambkbk.c = parambkbk.s;
      parambkbk.d = parambkbk.t;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parambkbk.l, parambkbk.r, parambkbk.s, parambkbk.t, parambkbk.jdField_b_of_type_AndroidGraphicsPointF, parambkbk.m, 0);
      if (this.jdField_a_of_type_Bkbj == null) {
        break;
      }
      this.jdField_a_of_type_Bkbj.a(bool1, bool2, false, bool3, parambkbk.l);
      return;
      parambkbk.w = parambkbk.e;
      if (parambkbk.jdField_a_of_type_AndroidGraphicsPointF != null) {
        parambkbk.jdField_b_of_type_AndroidGraphicsPointF = parambkbk.jdField_a_of_type_AndroidGraphicsPointF;
      }
      parambkbk.q = parambkbk.jdField_a_of_type_Float;
      parambkbk.r = parambkbk.jdField_b_of_type_Float;
      if (bool3)
      {
        parambkbk.t = parambkbk.d;
        if ((!bool1) && (!bool2)) {
          parambkbk.c = parambkbk.s;
        }
      }
      if ((bool1) || (bool2))
      {
        parambkbk.s = parambkbk.c;
        if (!bool3) {
          parambkbk.d = parambkbk.t;
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bkim = new bkim();
    this.jdField_a_of_type_Bkim.a(true);
    this.jdField_a_of_type_Bkim.a(18.0F);
    this.jdField_a_of_type_Bkim.b(0.5F);
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
    if (this.jdField_a_of_type_Bkbk != null) {
      localBundle.putParcelable("vote_paster", new InteractPasterParcelData(this.jdField_a_of_type_Bkbk));
    }
    return localBundle;
  }
  
  @Nullable
  public bkbk a()
  {
    return this.jdField_a_of_type_Bkbk;
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
    if (this.jdField_a_of_type_Bkbk == null)
    {
      this.jdField_a_of_type_Bkbk = new bkbk(this, paramArrayOfString, paramBitmap, new PointF(vzl.a(this.jdField_a_of_type_AndroidContentContext) / 2, vzl.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bkbk.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (this.jdField_a_of_type_Bkbk.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;; this.jdField_a_of_type_Bkbk.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bkbk.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bkbk.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bkbk.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bkbk.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bkbk.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bkbk.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bkbk.q = paramFloat1;
      this.jdField_a_of_type_Bkbk.r = paramFloat2;
      this.jdField_a_of_type_Bkbk.s = paramFloat3;
      this.jdField_a_of_type_Bkbk.t = paramFloat4;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.e == 1)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_Bkbk != null) {
        this.jdField_a_of_type_Bkbk.a(paramCanvas);
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
  
  public void a(bkbj parambkbj)
  {
    this.jdField_a_of_type_Bkbj = parambkbj;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bkbk == null;
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
      this.jdField_a_of_type_Bkim.a(paramMotionEvent, false);
      if ((this.jdField_a_of_type_Bkbk != null) && (this.jdField_a_of_type_Bkim.a() != null)) {
        break;
      }
      h();
      return true;
      this.f = i;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkbk);
      continue;
      if (j > 5)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!this.jdField_a_of_type_Boolean) {
          d();
        }
        this.jdField_a_of_type_Bkim.a();
        a(this, false);
        n();
      }
    }
    a(this.jdField_a_of_type_Bkbk);
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
      if (this.jdField_a_of_type_Bkim.a(this.jdField_a_of_type_Bkbk, f1, f2, false))
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
    if (this.jdField_a_of_type_Bkbk != null)
    {
      if (!this.jdField_a_of_type_Bkbk.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bkbk.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bkbk = null;
    }
    if (this.jdField_a_of_type_Bkbj != null) {
      this.jdField_a_of_type_Bkbj.a();
    }
    k();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bkbj != null) && (this.jdField_a_of_type_Bkbk != null) && (this.jdField_a_of_type_Bkbj.a(this.jdField_a_of_type_Bkbk))) {
      this.jdField_a_of_type_Bkbk = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbi
 * JD-Core Version:    0.7.0.1
 */