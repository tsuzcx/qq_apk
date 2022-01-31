package com.tencent.mobileqq.activity.aio.item;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import bdpn;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public final class SignatureView
  extends View
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public float a;
  public int a;
  private Paint.FontMetricsInt jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Drawable a;
  public TextPaint a;
  public bdpn a;
  public VipPngPlayAnimationDrawable a;
  public CharSequence a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  private Rect b;
  public Drawable b;
  public TextPaint b;
  public CharSequence b;
  public String b;
  public boolean b;
  public float c;
  public int c;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private TextPaint jdField_c_of_type_AndroidTextTextPaint = new TextPaint(1);
  public boolean c;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private TextPaint jdField_d_of_type_AndroidTextTextPaint = new TextPaint(1);
  public boolean d;
  private int e;
  public boolean e;
  private int f;
  public boolean f;
  private int g;
  public boolean g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public SignatureView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Float = 0.0F;
    a();
  }
  
  private void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_g_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = -16777216;
    this.jdField_a_of_type_Float = (12.0F * this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_JavaLangCharSequence = alpo.a(2131714495);
    this.jdField_c_of_type_Int = Color.parseColor("#878B99");
    this.jdField_b_of_type_Float = (11.0F * this.jdField_d_of_type_Float);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849773);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849396);
    this.jdField_a_of_type_Int = Color.parseColor("#66000000");
    this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidTextTextPaint.setTextSize(14.0F * this.jdField_d_of_type_Float);
      this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_c_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_c_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.h = (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top);
      this.i = ((int)(17.0F * this.jdField_d_of_type_Float + 0.5F));
      this.j = ((int)(8.0F * this.jdField_d_of_type_Float + 0.5F));
      this.k = (this.h + this.i + this.j);
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = (this.k + paramInt2);
    requestLayout();
    return this.k;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m;
    int n;
    int i1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      m = this.i;
      n = this.h;
      i1 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Int / 2 - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2, m + n - i1, this.jdField_c_of_type_AndroidTextTextPaint);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, this.k, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    float f1;
    Object localObject;
    float f2;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangCharSequence != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)))
    {
      m = paramCanvas.getSaveCount();
      paramCanvas.save();
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      f1 = this.jdField_d_of_type_Float;
      localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.jdField_c_of_type_Float = (this.jdField_e_of_type_Int - 20.0F * this.jdField_d_of_type_Float - 5.0F * this.jdField_d_of_type_Float - (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top));
      paramCanvas.translate(20.0F * f1, this.jdField_c_of_type_Float);
      f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());
      f1 = 190.0F * this.jdField_d_of_type_Float;
      if (!this.jdField_f_of_type_Boolean) {
        f1 = this.jdField_d_of_type_Int - 20.0F * this.jdField_d_of_type_Float;
      }
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
        break label1751;
      }
      f1 = f1 - this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangCharSequence.toString()) - 16.0F * this.jdField_d_of_type_Float;
    }
    label1729:
    label1751:
    for (;;)
    {
      if (f2 > f1)
      {
        this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, (int)(this.jdField_a_of_type_JavaLangCharSequence.length() * f1 / f2) - 1);
        f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());
        if (f2 > f1) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, (int)(this.jdField_a_of_type_JavaLangCharSequence.length() * f1 / f2) - 1);
        }
        f2 = this.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangCharSequence.toString());
        this.jdField_g_of_type_Boolean = true;
      }
      for (;;)
      {
        if (this.jdField_g_of_type_Boolean)
        {
          localObject = new StaticLayout("…", this.jdField_a_of_type_AndroidTextTextPaint, (int)(f1 + 0.5D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
          paramCanvas.translate(f2, 0.0F);
          ((StaticLayout)localObject).draw(paramCanvas);
          paramCanvas.translate(-f2, 0.0F);
        }
        new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, (int)(f1 + 0.5D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
        paramCanvas.restoreToCount(m);
        float f3;
        float f4;
        if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)))
        {
          m = paramCanvas.getSaveCount();
          paramCanvas.save();
          f1 = this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());
          f2 = this.jdField_d_of_type_Int - 20.0F * this.jdField_d_of_type_Float - f1;
          localObject = this.jdField_b_of_type_AndroidTextTextPaint.getFontMetricsInt();
          f3 = this.jdField_e_of_type_Int - 20.0F * this.jdField_d_of_type_Float - 5.0F * this.jdField_d_of_type_Float - (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top);
          paramCanvas.translate(f2, f3);
          this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
          this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
          f4 = ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top;
          this.jdField_b_of_type_AndroidGraphicsRect.set((int)f2, (int)f3, (int)(f2 + f1), (int)(f4 + f3));
          new StaticLayout(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidTextTextPaint, (int)(f1 + 0.5D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
          paramCanvas.restoreToCount(m);
        }
        if (this.jdField_e_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Signature.SignatureView", 2, "mShowStaticBitmap is true.");
          }
          if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
            break label1729;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Signature.SignatureView", 2, "draw static bitmap.");
          }
          m = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(this.jdField_a_of_type_Bdpn.jdField_a_of_type_Float * this.jdField_d_of_type_Int, this.k + this.jdField_a_of_type_Bdpn.jdField_b_of_type_Float * (this.jdField_e_of_type_Int - this.k));
          n = (int)(this.jdField_a_of_type_Bdpn.jdField_c_of_type_Float * this.jdField_d_of_type_Int + 0.5D);
          i1 = (int)(this.jdField_a_of_type_Bdpn.jdField_d_of_type_Float * (this.jdField_e_of_type_Int - this.k) + 0.5D);
          paramCanvas.drawBitmap(jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, n, i1), this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restoreToCount(m);
        }
        for (;;)
        {
          invalidate();
          if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Bdpn != null))
          {
            m = paramCanvas.getSaveCount();
            paramCanvas.save();
            paramCanvas.translate(this.jdField_a_of_type_Bdpn.jdField_a_of_type_Float * this.jdField_d_of_type_Int, this.k + this.jdField_a_of_type_Bdpn.jdField_b_of_type_Float * (this.jdField_e_of_type_Int - this.k));
            n = (int)(this.jdField_a_of_type_Bdpn.jdField_c_of_type_Float * this.jdField_d_of_type_Int + 0.5D);
            i1 = (int)(this.jdField_a_of_type_Bdpn.jdField_d_of_type_Float * (this.jdField_e_of_type_Int - this.k) + 0.5D);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.setBounds(0, 0, n, i1);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.draw(paramCanvas);
            paramCanvas.restoreToCount(m);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_f_of_type_Int > 0)
            {
              if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_f_of_type_Int < 2)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.jdField_f_of_type_Int = 3;
              }
              invalidate();
            }
          }
          if (this.jdField_c_of_type_Boolean)
          {
            m = paramCanvas.getSaveCount();
            paramCanvas.save();
            this.jdField_d_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#fffcf9"));
            this.jdField_d_of_type_AndroidTextTextPaint.setTextSize(12.0F * this.jdField_d_of_type_Float);
            f1 = 13.0F * this.jdField_d_of_type_Float * 2.0F + 5.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + this.jdField_d_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString);
            f2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + 15.0F * this.jdField_d_of_type_Float;
            f3 = this.jdField_d_of_type_Int - 20.0F * this.jdField_d_of_type_Float - f1;
            f4 = this.jdField_e_of_type_Int - 20.0F * this.jdField_d_of_type_Float - f2;
            paramCanvas.translate(f3, f4);
            this.jdField_c_of_type_AndroidGraphicsRect.set((int)f3, (int)f4, (int)(f3 + f1), (int)(f4 + f2));
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)f1, (int)f2);
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)(13.0F * this.jdField_d_of_type_Float), (int)(f2 / 2.0F - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2), (int)(13.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()), (int)(f2 / 2.0F + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2));
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            paramCanvas.restoreToCount(m);
            m = paramCanvas.getSaveCount();
            paramCanvas.save();
            paramCanvas.translate((int)(13.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) + f3 + 5.0F * this.jdField_d_of_type_Float, (int)(f2 / 2.0F - this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2) + f4);
            new StaticLayout(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_AndroidTextTextPaint, (int)this.jdField_d_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
            paramCanvas.restoreToCount(m);
          }
          if (this.jdField_c_of_type_Boolean)
          {
            localObject = alpo.a(2131714505);
            this.jdField_d_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
            this.jdField_d_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
            Point localPoint = new Point(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.centerY());
            m = (int)this.jdField_d_of_type_AndroidTextTextPaint.measureText((String)localObject);
            localPoint = new Point(localPoint);
            localPoint.offset((int)-(16.0F * this.jdField_d_of_type_Float + m), 0);
            Paint.FontMetrics localFontMetrics = this.jdField_d_of_type_AndroidTextTextPaint.getFontMetrics();
            n = (int)(localFontMetrics.descent - localFontMetrics.ascent);
            localPoint.offset(0, (int)(-0.5F * n));
            this.jdField_b_of_type_AndroidGraphicsRect.set(localPoint.x, localPoint.y, m + localPoint.x, n + localPoint.y);
            paramCanvas.save();
            paramCanvas.translate(localPoint.x, localPoint.y);
            paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), 0.0F, (int)-localFontMetrics.ascent, this.jdField_d_of_type_AndroidTextTextPaint);
            paramCanvas.restore();
          }
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Signature.SignatureView", 2, "static bitmap is null.");
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (paramInt1 > this.jdField_d_of_type_Int) {
        this.jdField_g_of_type_Int = paramInt1;
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Int = (this.jdField_g_of_type_Int / 2 - this.jdField_d_of_type_Int / 2);
      setX(this.jdField_f_of_type_Int);
    }
    setMeasuredDimension(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  public void setAnimation(int paramInt, String paramString, bdpn parambdpn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.SignatureView", 2, toString() + "SignatureView setAnimation.");
    }
    this.jdField_a_of_type_Bdpn = parambdpn;
    if ((jdField_a_of_type_AndroidGraphicsBitmap != null) && (!jdField_a_of_type_AndroidGraphicsBitmap.isMutable()) && (!jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    ThreadManager.post(new SignatureView.1(this, paramInt, paramString, parambdpn), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SignatureView
 * JD-Core Version:    0.7.0.1
 */