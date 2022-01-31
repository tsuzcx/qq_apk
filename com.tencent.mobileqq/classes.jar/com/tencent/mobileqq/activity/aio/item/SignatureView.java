package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import vgq;

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
  private VipPngPlayAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
  private SignatureTemplateInfo.DynamicItem jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem;
  public CharSequence a;
  public String a;
  public List a;
  public boolean a;
  public float b;
  public int b;
  private Rect b;
  public Drawable b;
  public TextPaint b;
  public CharSequence b;
  public String b;
  public List b;
  public boolean b;
  public float c;
  public int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private TextPaint jdField_c_of_type_AndroidTextTextPaint = new TextPaint(1);
  public boolean c;
  private float jdField_d_of_type_Float;
  public int d;
  private TextPaint jdField_d_of_type_AndroidTextTextPaint = new TextPaint(1);
  public boolean d;
  private int e;
  public boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.h = getResources().getDisplayMetrics().widthPixels;
    this.jdField_d_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Float = (13.0F * this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_c_of_type_Int = -16777216;
    this.jdField_b_of_type_Float = (12.0F * this.jdField_d_of_type_Float);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846083);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845814);
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_a_of_type_Int = Color.parseColor("#66000000");
    this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureView", 2, "rect left: " + this.jdField_b_of_type_AndroidGraphicsRect.left + " rect top: " + this.jdField_b_of_type_AndroidGraphicsRect.top + " rect right: " + this.jdField_b_of_type_AndroidGraphicsRect.right + " rect bottom: " + this.jdField_b_of_type_AndroidGraphicsRect.bottom + " x: " + paramInt1 + " y: " + paramInt2);
    }
    return this.jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.g = (this.h / 2 - this.jdField_e_of_type_Int / 2);
    setX(this.g);
    int m;
    int n;
    int i1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      m = this.j;
      n = this.i;
      i1 = this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_Int / 2 - this.jdField_a_of_type_AndroidGraphicsRect.width() / 2, m + n - i1, this.jdField_c_of_type_AndroidTextTextPaint);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, this.l, this.jdField_e_of_type_Int, this.f);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    Object localObject;
    URLDrawable localURLDrawable;
    label208:
    float f1;
    float f2;
    float f3;
    float f4;
    if (this.jdField_e_of_type_Boolean)
    {
      m = 0;
      if (m < this.jdField_d_of_type_Int)
      {
        localObject = (RichStatus.StickerInfo)this.jdField_a_of_type_JavaUtilList.get(m);
        localURLDrawable = (URLDrawable)this.jdField_b_of_type_JavaUtilList.get(m);
        if (1 != localURLDrawable.getStatus())
        {
          localURLDrawable.setAlpha(0);
          f1 = ((RichStatus.StickerInfo)localObject).jdField_a_of_type_Float * this.jdField_e_of_type_Int;
          f2 = ((RichStatus.StickerInfo)localObject).jdField_b_of_type_Float * (this.f - this.l) + this.l;
          f3 = ((RichStatus.StickerInfo)localObject).jdField_c_of_type_Float * this.jdField_e_of_type_Int;
          f4 = ((RichStatus.StickerInfo)localObject).jdField_d_of_type_Float;
          f4 = (this.f - this.l) * f4;
          if (f1 + f3 <= this.jdField_e_of_type_Int) {
            break label375;
          }
          f1 -= f1 + f3 - this.jdField_e_of_type_Int;
        }
      }
    }
    label1549:
    label1570:
    for (;;)
    {
      label304:
      if (f2 + f4 > this.f) {
        f2 -= f2 + f4 - this.f;
      }
      for (;;)
      {
        localURLDrawable.setBounds((int)f1, (int)f2, (int)(f1 + f3), (int)(f2 + f4));
        localURLDrawable.draw(paramCanvas);
        m += 1;
        break;
        localURLDrawable.setAlpha(255);
        break label208;
        label375:
        if (f1 >= 0.0F) {
          break label1570;
        }
        f1 = 0.0F;
        break label304;
        if (f2 < 0.0F)
        {
          f2 = 0.0F;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)))
            {
              m = paramCanvas.getSaveCount();
              paramCanvas.save();
              n = this.jdField_e_of_type_Int;
              i1 = (int)(this.jdField_d_of_type_Float * 20.0F + 0.5D);
              int i2 = (int)(this.jdField_d_of_type_Float * 20.0F + 0.5D);
              paramCanvas.translate(this.jdField_d_of_type_Float * 20.0F, this.l + this.jdField_d_of_type_Float * 20.0F);
              this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
              this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
              new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, n - i1 - i2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 5.0F, false).draw(paramCanvas);
              paramCanvas.restoreToCount(m);
            }
            if ((this.jdField_b_of_type_JavaLangCharSequence != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)))
            {
              m = paramCanvas.getSaveCount();
              paramCanvas.save();
              this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
              this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
              f1 = this.jdField_d_of_type_Float;
              localObject = this.jdField_b_of_type_AndroidTextTextPaint.getFontMetricsInt();
              this.jdField_c_of_type_Float = (this.f - this.jdField_d_of_type_Float * 20.0F - 5.0F * this.jdField_d_of_type_Float - (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top));
              paramCanvas.translate(f1 * 20.0F, this.jdField_c_of_type_Float);
              f1 = this.jdField_b_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangCharSequence.toString());
              if (f1 > 150.0F * this.jdField_d_of_type_Float) {
                this.jdField_b_of_type_JavaLangCharSequence = this.jdField_b_of_type_JavaLangCharSequence.subSequence(0, (int)(this.jdField_b_of_type_JavaLangCharSequence.length() * 150 * this.jdField_d_of_type_Float / f1 + 0.5D));
              }
              new StaticLayout(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidTextTextPaint, (int)(150.0F * this.jdField_d_of_type_Float + 0.5D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
              paramCanvas.restoreToCount(m);
            }
          }
          if (this.jdField_d_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SignatureView", 2, "mShowStaticBitmap is true.");
            }
            if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
              break label1549;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SignatureView", 2, "draw static bitmap.");
            }
            m = paramCanvas.getSaveCount();
            paramCanvas.save();
            paramCanvas.translate(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_a_of_type_Float * this.jdField_e_of_type_Int, this.l + this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_b_of_type_Float * (this.f - this.l));
            n = (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_c_of_type_Float * this.jdField_e_of_type_Int + 0.5D);
            i1 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_d_of_type_Float * (this.f - this.l) + 0.5D);
            paramCanvas.drawBitmap(jdField_a_of_type_AndroidGraphicsBitmap, new Rect(0, 0, jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), new Rect(0, 0, n, i1), this.jdField_a_of_type_AndroidGraphicsPaint);
            paramCanvas.restoreToCount(m);
          }
          for (;;)
          {
            invalidate();
            if (this.jdField_c_of_type_Boolean)
            {
              m = paramCanvas.getSaveCount();
              paramCanvas.save();
              paramCanvas.translate(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_a_of_type_Float * this.jdField_e_of_type_Int, this.l + this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_b_of_type_Float * (this.f - this.l));
              n = (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_c_of_type_Float * this.jdField_e_of_type_Int + 0.5D);
              i1 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.jdField_d_of_type_Float * (this.f - this.l) + 0.5D);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.setBounds(0, 0, n, i1);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.draw(paramCanvas);
              if (QLog.isColorLevel()) {
                QLog.d("SignatureView", 2, "mAnimationDrawable.mRepeatCount: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.f);
              }
              paramCanvas.restoreToCount(m);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.f > 0) {
                invalidate();
              }
            }
            if (this.jdField_b_of_type_Boolean)
            {
              m = paramCanvas.getSaveCount();
              paramCanvas.save();
              this.jdField_d_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#fffcf9"));
              this.jdField_d_of_type_AndroidTextTextPaint.setTextSize(12.0F * this.jdField_d_of_type_Float);
              f1 = 13.0F * this.jdField_d_of_type_Float * 2.0F + 5.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + this.jdField_d_of_type_AndroidTextTextPaint.measureText(this.jdField_b_of_type_JavaLangString);
              f2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + 15.0F * this.jdField_d_of_type_Float;
              f3 = this.jdField_e_of_type_Int - this.jdField_d_of_type_Float * 20.0F - f1;
              f4 = this.f - this.jdField_d_of_type_Float * 20.0F - f2;
              paramCanvas.translate(f3, f4);
              this.jdField_b_of_type_AndroidGraphicsRect.set((int)f3, (int)f4, (int)(f3 + f1), (int)(f4 + f2));
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
            return;
            if (QLog.isColorLevel()) {
              QLog.d("SignatureView", 2, "static bitmap is null.");
            }
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.jdField_e_of_type_Int, this.f);
    if (QLog.isColorLevel()) {
      QLog.d("SignatureView", 2, "mSigWidth: " + this.jdField_e_of_type_Int + " mSigHeight: " + this.f + " mHeightAddedTittleContent: " + this.i + " mHeightAddedTittleTop: " + this.j + " mHeightAddedTittleBottom: " + this.k + " mHeightAddedTittle: " + this.l);
    }
  }
  
  public void setAnimation(int paramInt, String paramString, SignatureTemplateInfo.DynamicItem paramDynamicItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureView", 2, toString() + "SignatureView setAnimation.");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem = paramDynamicItem;
    if ((jdField_a_of_type_AndroidGraphicsBitmap != null) && (!jdField_a_of_type_AndroidGraphicsBitmap.isMutable()) && (!jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    ThreadManager.post(new vgq(this, paramInt, paramString, paramDynamicItem), 5, null, true);
  }
  
  public void setSigViewSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidTextTextPaint.setTextSize(14.0F * this.jdField_d_of_type_Float);
      this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_c_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_c_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt = this.jdField_c_of_type_AndroidTextTextPaint.getFontMetricsInt();
      this.i = (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetricsInt.top);
      this.j = ((int)(17.0F * this.jdField_d_of_type_Float + 0.5F));
      this.k = ((int)(8.0F * this.jdField_d_of_type_Float + 0.5F));
      this.l = (this.i + this.j + this.k);
    }
    this.jdField_e_of_type_Int = paramInt1;
    this.f = (this.l + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SignatureView
 * JD-Core Version:    0.7.0.1
 */