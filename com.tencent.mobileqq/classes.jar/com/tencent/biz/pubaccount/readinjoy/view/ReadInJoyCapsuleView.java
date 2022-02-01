package com.tencent.biz.pubaccount.readinjoy.view;

import agej;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class ReadInJoyCapsuleView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCapsuleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyCapsuleView, 0, 0);
    try
    {
      this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(3);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(4);
      this.jdField_a_of_type_Int = paramAttributeSet.getDimensionPixelSize(5, 6);
      this.jdField_b_of_type_Int = paramAttributeSet.getDimensionPixelSize(0, 24);
      this.c = paramAttributeSet.getColor(1, -1);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(2);
      paramAttributeSet.recycle();
      a(paramContext);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.c);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      setDrawableLeft(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
    localLayoutParams.leftMargin = agej.a(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = agej.a(12.0F, paramContext.getResources());
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    float f = j * 0.5F;
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i - f, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i - 2.0F * f, 0.0F, i, j);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 180.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f, j);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f * 2.0F, j);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_a_of_type_AndroidGraphicsRectF, 90.0F, 180.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(null, null, 31);
    super.dispatchDraw(paramCanvas);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    measureChildWithMargins(this.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 0, paramInt2, 0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramInt1 = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
    int i = localLayoutParams.leftMargin;
    paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.rightMargin + (paramInt1 + i), 1073741824);
    this.jdField_a_of_type_AndroidWidgetImageView.measure(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setBackgroundSrc(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setColorFilter(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt, PorterDuff.Mode.DARKEN);
  }
  
  public void setDrawableLeft(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    float f = this.jdField_b_of_type_Int / this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, (int)(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() * f), (int)(f * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.c = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView
 * JD-Core Version:    0.7.0.1
 */