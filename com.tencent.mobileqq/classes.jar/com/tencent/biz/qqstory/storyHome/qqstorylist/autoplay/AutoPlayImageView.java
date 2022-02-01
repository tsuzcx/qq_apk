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
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.widget.PAVideoView;

public class AutoPlayImageView
  extends ImageView
  implements QQLiveDrawable.OnStateListener
{
  public boolean a = true;
  private int b;
  private String c;
  private int d;
  private int e;
  private Path f;
  private int g = 0;
  private URLDrawable h;
  private Drawable i;
  private Paint j;
  
  public AutoPlayImageView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public AutoPlayImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g()
  {
    this.b = 0;
    this.f = new Path();
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    } else if (Build.VERSION.SDK_INT >= 14) {
      super.setLayerType(1, null);
    }
    this.j = new Paint();
    this.j.setColor(-2302756);
    this.j.setStyle(Paint.Style.STROKE);
  }
  
  public Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = ((URLDrawable)this.i).getCurrDrawable();
    if ((paramString != null) && ((paramString instanceof RegionDrawable)))
    {
      paramString = ((RegionDrawable)paramString).getBitmap();
      if ((paramString != null) && (!paramString.isRecycled()))
      {
        paramString = new BitmapDrawable(paramString);
        break label55;
      }
    }
    paramString = null;
    label55:
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new EmptyDrawable(-2631721, paramInt1, paramInt2);
    }
    return localObject;
  }
  
  public QQLiveDrawable.QQLiveDrawableParams a(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    paramOnStateListener = new QQLiveDrawable.QQLiveDrawableParams();
    int k;
    if (paramInt1 > 0)
    {
      k = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {}
    }
    else
    {
      k = 544;
      paramInt1 = 968;
    }
    paramOnStateListener.mPreviewWidth = k;
    paramOnStateListener.mPreviewHeight = paramInt1;
    paramOnStateListener.mCoverWidth = this.d;
    paramOnStateListener.mCoverHeight = this.e;
    paramOnStateListener.mPlayType = 2;
    paramOnStateListener.mDataSourceType = 3;
    paramOnStateListener.mDataSource = paramString2;
    paramOnStateListener.mCoverUrl = paramString1;
    paramOnStateListener.mCoverLoadingDrawable = new EmptyDrawable(-2631721, k, paramInt1);
    paramOnStateListener.mLoopback = true;
    paramOnStateListener.msgUniseq = paramLong;
    return paramOnStateListener;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    SLog.a("AutoPlayImageView", "doPlay last mState=%s", Integer.valueOf(this.b));
    this.a = true;
    this.b = 1;
    paramString1 = a(paramInt1, paramInt2, paramLong, paramString1, paramString2, this);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mExtraInfo = paramString1;
    paramString2.mLoadingDrawable = a(paramString1.mCoverUrl, paramInt1, paramInt2);
    paramString1 = URLDrawable.getDrawable(PAVideoView.a(paramLong), paramString2);
    paramString1.setURLDrawableListener(new AutoPlayImageView.1(this));
    setImageDrawable(paramString1);
  }
  
  public boolean a()
  {
    int k = this.b;
    boolean bool2 = false;
    if (k == 3) {
      return false;
    }
    URLDrawable localURLDrawable = this.h;
    boolean bool1 = bool2;
    if (localURLDrawable != null)
    {
      bool1 = bool2;
      if ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))
      {
        bool1 = bool2;
        if (((QQLiveDrawable)this.h.getCurrDrawable()).getPlayState() == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    URLDrawable localURLDrawable = this.h;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localURLDrawable != null)
    {
      bool1 = bool2;
      if ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))
      {
        bool1 = bool2;
        if (((QQLiveDrawable)this.h.getCurrDrawable()).getPlayState() == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pausePlay last mState=");
    ((StringBuilder)localObject).append(this.b);
    SLog.b("AutoPlayImageView", ((StringBuilder)localObject).toString());
    if (this.b == 3) {
      return;
    }
    this.b = 2;
    localObject = this.h;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.h.getCurrDrawable()).pause();
    }
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resumePlay last mState=");
    ((StringBuilder)localObject).append(this.b);
    SLog.b("AutoPlayImageView", ((StringBuilder)localObject).toString());
    if (this.b == 3) {
      return;
    }
    this.b = 1;
    localObject = this.h;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable)))
    {
      ((QQLiveDrawable)this.h.getCurrDrawable()).resume();
      super.setImageDrawable(this.h);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f == null) {
      this.f = new Path();
    }
    this.f.reset();
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int k = getHeight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + m, getPaddingTop() + (k - n - i1));
    k = this.g;
    if (k <= 0) {
      k = m / 30;
    }
    Path localPath = this.f;
    float f1 = k;
    localPath.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
    this.f.setFillType(Path.FillType.EVEN_ODD);
    paramCanvas.clipPath(this.f);
    super.draw(paramCanvas);
    this.f.reset();
    this.f.addRoundRect(localRectF, f1, f1, Path.Direction.CCW);
    if (QQStoryContext.e()) {
      this.j.setColor(getContext().getResources().getColor(2131167388));
    }
    paramCanvas.drawPath(this.f, this.j);
  }
  
  public void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pausePlay last mState=");
    ((StringBuilder)localObject).append(this.b);
    SLog.b("AutoPlayImageView", ((StringBuilder)localObject).toString());
    if (this.b == 1) {
      this.a = false;
    }
    this.b = 3;
    localObject = this.h;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.h.getCurrDrawable()).recyleAndKeepPostion();
    }
  }
  
  public boolean f()
  {
    if (this.b != 3) {
      return false;
    }
    return this.a;
  }
  
  public int getAutoPlayState()
  {
    return this.b;
  }
  
  public String getCoverUrl()
  {
    return this.c;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    URLDrawable localURLDrawable = this.h;
    if ((localURLDrawable != null) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable)))
    {
      ((QQLiveDrawable)this.h.getCurrDrawable()).release();
      this.h = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject) {}
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    this.j.setColor(paramInt);
    invalidate();
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt > 0)
    {
      this.g = paramInt;
      return;
    }
    throw new IllegalArgumentException("should not be less than 0");
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.i = paramDrawable;
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2)
  {
    this.c = paramString;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof URLDrawable)) {
      this.h = ((URLDrawable)paramDrawable);
    } else {
      this.h = null;
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView
 * JD-Core Version:    0.7.0.1
 */