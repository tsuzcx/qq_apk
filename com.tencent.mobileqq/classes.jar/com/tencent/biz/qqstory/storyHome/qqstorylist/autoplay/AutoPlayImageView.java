package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.ImageView;
import apkp;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.PAVideoView;
import wre;
import wxe;

public class AutoPlayImageView
  extends ImageView
  implements QQLiveDrawable.OnStateListener
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int b;
  private int c;
  private int d;
  
  public AutoPlayImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2302756);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        super.setLayerType(1, null);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = ((URLDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getCurrDrawable();
    if ((paramString != null) && ((paramString instanceof RegionDrawable)))
    {
      paramString = ((RegionDrawable)paramString).getBitmap();
      if ((paramString == null) || (paramString.isRecycled())) {}
    }
    for (paramString = new BitmapDrawable(paramString);; paramString = null)
    {
      Object localObject = paramString;
      if (paramString == null) {
        localObject = new apkp(-2631721, paramInt1, paramInt2);
      }
      return localObject;
    }
  }
  
  public QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    paramOnStateListener = new QQLiveDrawable.QQLiveDrawableParams();
    int i;
    if (paramInt1 > 0)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    else
    {
      i = 544;
      paramInt1 = 968;
    }
    paramOnStateListener.mPreviewWidth = i;
    paramOnStateListener.mPreviewHeight = paramInt1;
    paramOnStateListener.mCoverWidth = this.b;
    paramOnStateListener.mCoverHeight = this.c;
    paramOnStateListener.mPlayType = 2;
    paramOnStateListener.mDataSourceType = 3;
    paramOnStateListener.mDataSource = paramString2;
    paramOnStateListener.mCoverUrl = paramString1;
    paramOnStateListener.mCoverLoadingDrawable = new apkp(-2631721, i, paramInt1);
    paramOnStateListener.mLoopback = true;
    paramOnStateListener.msgUniseq = paramLong;
    return paramOnStateListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    wxe.b("AutoPlayImageView", "pausePlay last mState=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 3) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = 2;
    } while ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)));
    ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).pause();
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    wxe.a("AutoPlayImageView", "doPlay last mState=%s", Integer.valueOf(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2, this);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl, paramInt1, paramInt2);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramString1.setURLDrawableListener(new wre(this));
    setImageDrawable(paramString1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 3) {}
    while ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      return false;
    }
    if (((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getPlayState() == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b()
  {
    wxe.b("AutoPlayImageView", "resumePlay last mState=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 3) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = 1;
    } while ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)));
    ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).resume();
    super.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      return ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getPlayState() == 2;
    }
    return false;
  }
  
  public void c()
  {
    wxe.b("AutoPlayImageView", "pausePlay last mState=" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Int = 3;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).recyleAndKeepPostion();
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int != 3) {
      return false;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.d > 0) {
      i = this.d;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      if (QQStoryContext.a()) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getContext().getResources().getColor(2131166403));
      }
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      i /= 30;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).release();
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (paramInt == 2) {}
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.d = paramInt;
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof URLDrawable)) {}
    for (this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)paramDrawable);; this.jdField_a_of_type_ComTencentImageURLDrawable = null)
    {
      super.setImageDrawable(paramDrawable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView
 * JD-Core Version:    0.7.0.1
 */