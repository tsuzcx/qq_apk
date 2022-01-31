import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bkbd
  extends bkin
{
  public float a;
  public int a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public DynamicTextItem a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  
  public bkbd(bkba parambkba)
  {
    this(parambkba, new bkbc(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    this.jdField_b_of_type_AndroidGraphicsPointF.set(parambkba.jdField_a_of_type_AndroidGraphicsPointF);
    this.jdField_j_of_type_Int = vzl.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public bkbd(bkba parambkba, @NonNull bkbc parambkbc)
  {
    super(parambkbc.jdField_a_of_type_AndroidGraphicsPointF, parambkbc.jdField_a_of_type_Float, parambkbc.jdField_b_of_type_Float, parambkbc.jdField_c_of_type_Float, parambkbc.jdField_d_of_type_Float, parambkbc.e, parambkbc.jdField_f_of_type_Float, true);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new bjij();
    this.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    this.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    this.jdField_a_of_type_Float = bkba.jdField_a_of_type_Int;
    this.jdField_j_of_type_Int = vzl.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public bkbd(bkba parambkba, @NonNull bkbd parambkbd)
  {
    super(parambkbd, 1.0F);
    if (parambkbd.jdField_a_of_type_AndroidGraphicsRect == null) {}
    for (this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);; this.jdField_a_of_type_AndroidGraphicsRect = new Rect(parambkbd.jdField_a_of_type_AndroidGraphicsRect))
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = parambkbd.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_Float = parambkbd.jdField_a_of_type_Float;
      this.jdField_b_of_type_Float = parambkbd.jdField_b_of_type_Float;
      this.jdField_c_of_type_Float = parambkbd.jdField_c_of_type_Float;
      this.jdField_d_of_type_Float = parambkbd.jdField_d_of_type_Float;
      this.e = parambkbd.e;
      this.jdField_f_of_type_Float = parambkbd.jdField_f_of_type_Float;
      this.jdField_g_of_type_Float = parambkbd.jdField_g_of_type_Float;
      this.jdField_h_of_type_Float = parambkbd.jdField_h_of_type_Float;
      this.i = parambkbd.i;
      this.jdField_j_of_type_Int = vzl.a(BaseApplicationImpl.getContext(), 15.0F);
      a(parambkbd);
      return;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    int j;
    label35:
    int m;
    label47:
    int k;
    if (this.jdField_k_of_type_Int == 0)
    {
      j = 2130843820;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked())
      {
        if (this.jdField_k_of_type_Int != 0) {
          break label114;
        }
        j = 2130843826;
      }
      if (this.jdField_k_of_type_Int != 1) {
        break label120;
      }
      m = 2130843816;
      if (this.jdField_k_of_type_Int != 2) {
        break label127;
      }
      k = 2130843823;
      label58:
      if (this.n) {
        j = -1;
      }
      if (!bkba.b(this.jdField_a_of_type_Bkba).a.e()) {
        break label133;
      }
      k = -1;
      j = -1;
    }
    label133:
    for (;;)
    {
      bkik.a(paramCanvas, this.jdField_a_of_type_Bkba.jdField_a_of_type_Bkim, this, j, m, k);
      paramCanvas.restore();
      return;
      j = 2130843819;
      break;
      label114:
      j = 2130843824;
      break label35;
      label120:
      m = 2130843815;
      break label47;
      label127:
      k = 2130843822;
      break label58;
    }
  }
  
  private void f()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(bkba.e);
    localValueAnimator.addUpdateListener(new bkbe(this));
    localValueAnimator.start();
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(bkba.e);
    localValueAnimator.addUpdateListener(new bkbf(this));
    localValueAnimator.start();
  }
  
  protected void a()
  {
    this.jdField_d_of_type_Float = this.s;
    this.e = this.t;
    this.jdField_b_of_type_Float = this.q;
    this.jdField_c_of_type_Float = this.r;
    this.jdField_f_of_type_Float = (this.jdField_a_of_type_Bkba.n - this.jdField_b_of_type_AndroidGraphicsPointF.x - this.jdField_d_of_type_Float);
    this.jdField_g_of_type_Float = (this.jdField_a_of_type_Bkba.o - this.jdField_b_of_type_AndroidGraphicsPointF.y - this.e);
    this.jdField_h_of_type_Float = (1.0F - this.jdField_b_of_type_Float);
    if (this.jdField_c_of_type_Float < 180.0F)
    {
      this.i = (0.0F - this.jdField_c_of_type_Float);
      return;
    }
    this.i = (360.0F - this.jdField_c_of_type_Float);
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(bkba.a(this.jdField_a_of_type_Bkba).a())) && (!this.jdField_k_of_type_Boolean)) {}
    do
    {
      return;
      if (this.jdField_f_of_type_Boolean) {
        paramCanvas.drawColor(Color.parseColor("#66000000"));
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_k_of_type_Boolean))
      {
        if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
        {
          float f1 = this.l;
          float f2 = this.jdField_j_of_type_Float;
          float f3 = this.m;
          float f4 = this.jdField_k_of_type_Float;
          float f5 = this.jdField_b_of_type_AndroidGraphicsPointF.x;
          float f6 = this.s;
          float f7 = this.jdField_b_of_type_AndroidGraphicsPointF.y;
          paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.t + f7, this.jdField_a_of_type_Bkba.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.save();
          paramCanvas.concat(this.jdField_a_of_type_Bkba.jdField_a_of_type_Bkim.b(this));
          int j = (int)(this.u * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          int k = (int)(this.v * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          paramCanvas.drawRect(new RectF(-j / 2, -k / 2, j / 2, k / 2), bkba.a(this.jdField_a_of_type_Bkba));
          paramCanvas.restore();
        }
        if (this.jdField_g_of_type_Boolean) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
      }
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_Bkba.jdField_a_of_type_Bkim.a(this));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(paramCanvas);
      paramCanvas.restore();
    } while (!this.jdField_k_of_type_Boolean);
    b(paramCanvas);
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bkbg(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new bkbh(this));
    }
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_j_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      localStringBuilder.append("centerP x : ").append(this.jdField_b_of_type_AndroidGraphicsPointF.x).append(" y: ").append(this.jdField_b_of_type_AndroidGraphicsPointF.y);
    }
    localStringBuilder.append("textLeft: ").append(this.jdField_a_of_type_Float);
    localStringBuilder.append("mSaveScaleValue: ").append(this.jdField_b_of_type_Float);
    localStringBuilder.append("mSaveRotateValue: ").append(this.jdField_c_of_type_Float);
    localStringBuilder.append("mSaveTranslateXValue: ").append(this.jdField_d_of_type_Float);
    localStringBuilder.append("mDistanceX: ").append(this.jdField_f_of_type_Float);
    localStringBuilder.append("mDistanceY: ").append(this.jdField_g_of_type_Float);
    localStringBuilder.append("mDScale: ").append(this.jdField_h_of_type_Float);
    localStringBuilder.append("mDRotate: ").append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbd
 * JD-Core Version:    0.7.0.1
 */