import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bkao
  extends bkin
{
  public long a;
  public Bitmap a;
  public RectF a;
  public Drawable a;
  public TroopBarPOI a;
  public boolean b;
  public boolean c;
  public final String d;
  public int e;
  public final String e;
  public int f;
  public final String f;
  public int g;
  public String g;
  public int h;
  
  public bkao(bkak parambkak, @NonNull Drawable paramDrawable, @NonNull bkas parambkas, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(parambkas.jdField_a_of_type_AndroidGraphicsPointF, parambkas.jdField_a_of_type_Float, parambkas.jdField_b_of_type_Float, parambkas.c, parambkas.d, parambkas.jdField_a_of_type_Int, parambkas.jdField_b_of_type_Int, true);
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public bkao(bkak parambkak, @NonNull Drawable paramDrawable, @NonNull bkas parambkas, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(parambkak, paramDrawable, parambkas, paramString1, paramString2, paramString3, paramInt1);
    this.jdField_f_of_type_Int = paramInt2;
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i;
    label35:
    int k;
    label47:
    int j;
    if (this.jdField_k_of_type_Int == 0)
    {
      i = 2130843818;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked())
      {
        if (this.jdField_k_of_type_Int != 0) {
          break label114;
        }
        i = 2130843826;
      }
      if (this.jdField_k_of_type_Int != 1) {
        break label120;
      }
      k = 2130843816;
      if (this.jdField_k_of_type_Int != 2) {
        break label127;
      }
      j = 2130843823;
      label58:
      if (this.n) {
        i = -1;
      }
      if (!bkak.d(this.jdField_b_of_type_Bkak).a.e()) {
        break label133;
      }
      j = -1;
      i = -1;
    }
    label133:
    for (;;)
    {
      bkik.a(paramCanvas, this.jdField_b_of_type_Bkak.jdField_a_of_type_Bkim, this, i, k, j);
      paramCanvas.restore();
      return;
      i = 2130843817;
      break;
      label114:
      i = 2130843824;
      break label35;
      label120:
      k = 2130843815;
      break label47;
      label127:
      j = 2130843822;
      break label58;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a();
    }
    return "";
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(bkak.c(this.jdField_b_of_type_Bkak).a())) && (!this.jdField_k_of_type_Boolean)) {}
    do
    {
      return;
      float f2 = this.u;
      float f1 = this.v;
      if (f2 * this.q < 200.0F) {
        f2 = 200.0F / this.q;
      }
      if (this.q * f1 < 200.0F) {
        f1 = 200.0F / this.q;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_k_of_type_Boolean))
      {
        if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
        {
          f1 = this.l;
          f2 = this.jdField_j_of_type_Float;
          float f3 = this.m;
          float f4 = this.jdField_k_of_type_Float;
          float f5 = this.jdField_b_of_type_AndroidGraphicsPointF.x;
          float f6 = this.s;
          float f7 = this.jdField_b_of_type_AndroidGraphicsPointF.y;
          paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.t + f7, this.jdField_b_of_type_Bkak.e);
          paramCanvas.save();
          paramCanvas.concat(this.jdField_b_of_type_Bkak.jdField_a_of_type_Bkim.b(this));
          int i = (int)(this.u * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          int j = (int)(this.v * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          paramCanvas.drawRect(new RectF(-i / 2, -j / 2, i / 2, j / 2), this.jdField_b_of_type_Bkak.f);
          paramCanvas.restore();
        }
        if (this.jdField_g_of_type_Boolean) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
      }
      paramCanvas.save();
      paramCanvas.concat(this.jdField_b_of_type_Bkak.jdField_a_of_type_Bkim.a(this));
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      this.jdField_b_of_type_Bkak.jdField_a_of_type_Bkim.b(this);
    } while (!this.jdField_k_of_type_Boolean);
    b(paramCanvas);
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isInSegment(bkak.e(this.jdField_b_of_type_Bkak).a())) && (!this.jdField_k_of_type_Boolean)) {
      return;
    }
    float f2 = this.u;
    float f1 = this.v;
    if (f2 * this.q < 200.0F) {
      f2 = 200.0F / this.q;
    }
    if (this.q * f1 < 200.0F) {
      f1 = 200.0F / this.q;
    }
    if (this.jdField_f_of_type_Boolean) {
      paramCanvas.drawColor(Color.parseColor("#66000000"));
    }
    paramCanvas.save();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    this.jdField_b_of_type_Bkak.jdField_a_of_type_Bkim.b(this);
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_h_of_type_Int == 0))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = bkak.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.extractAlpha(this.jdField_b_of_type_Bkak.g, null), null, new Rect((int)-this.p, (int)-this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + (int)this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + (int)this.p), this.jdField_b_of_type_Bkak.g);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
    if (paramTroopBarPOI != null)
    {
      a(paramTroopBarPOI.a());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(null);
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof bkhx)) {
        break label68;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bkge.a((bkhx)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_Bkak.jdField_a_of_type_AndroidContentContext, paramString);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_g_of_type_JavaLangString = ((bkhx)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
      }
    }
    while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      return;
      label68:
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bkge.a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_Bkak.jdField_a_of_type_AndroidContentContext, paramString);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    float f1 = this.jdField_b_of_type_AndroidGraphicsPointF.x - this.q * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2.0F + this.s;
    if (f1 < blcq.a(23.0F)) {
      this.jdField_b_of_type_AndroidGraphicsPointF.x = (this.jdField_b_of_type_AndroidGraphicsPointF.x - f1 + blcq.a(23.0F));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(bkak.f(this.jdField_b_of_type_Bkak));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    this.u = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    this.v = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    ((bjfl)bjav.a(4)).a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bkap(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new bkaq(this));
    }
    if (!this.jdField_j_of_type_Boolean) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_j_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkao
 * JD-Core Version:    0.7.0.1
 */