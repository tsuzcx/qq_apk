package com.tencent.aelight.camera.aeeditor.view.playtrack.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;

public class PlayTrackExpandWidthView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private ScaleAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
  private IPlayTrackViewBitmapProvider jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  
  public PlayTrackExpandWidthView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PlayTrackExpandWidthView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PlayTrackExpandWidthView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      paramInt1 = -paramInt2;
    }
    int i = 0;
    if (paramInt1 > 0)
    {
      i = this.jdField_a_of_type_Int;
      return paramInt2 + paramInt1 % i - i;
    }
    paramInt2 = i;
    while (paramInt1 < 0)
    {
      paramInt1 += this.jdField_a_of_type_Int;
      paramInt2 += 1;
    }
    if (paramInt2 != 0) {
      paramInt1 = (paramInt2 - 1) * this.jdField_a_of_type_Int;
    }
    return paramInt1;
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = getContext().getResources().getDisplayMetrics().widthPixels;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    if (this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider == null) {
      return;
    }
    getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    int j = getMeasuredWidth();
    int k = getScrollX();
    int m = this.jdField_a_of_type_ArrayOfInt[0];
    if ((m <= this.jdField_b_of_type_Int) && (m + j >= 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    int i = a(m, k);
    while ((i < j + k) && (i < this.jdField_b_of_type_Int + k - m))
    {
      long l = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(i);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider.getBitmap(l);
      int n = localBitmap.getHeight();
      int i1 = localBitmap.getWidth();
      int i2 = this.jdField_a_of_type_Int;
      int i3 = getHeight();
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.left = (i1 - i2 >> 1);
      localRect.top = (n - i3 >> 1);
      localRect.right = (localRect.left + this.jdField_a_of_type_Int);
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.bottom = (localRect.top + getHeight());
      localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      localRect.left = i;
      localRect.top = 0;
      localRect.right = (localRect.left + this.jdField_a_of_type_Int);
      localRect = this.jdField_b_of_type_AndroidGraphicsRect;
      localRect.bottom = (localRect.top + getHeight());
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += this.jdField_a_of_type_Int;
    }
  }
  
  public void setPixelPerBitmap(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
  }
  
  public void setVideoThumbProvider(IPlayTrackViewBitmapProvider paramIPlayTrackViewBitmapProvider)
  {
    this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider = paramIPlayTrackViewBitmapProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.playtrack.view.PlayTrackExpandWidthView
 * JD-Core Version:    0.7.0.1
 */