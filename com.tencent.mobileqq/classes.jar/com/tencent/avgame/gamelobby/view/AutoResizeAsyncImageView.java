package com.tencent.avgame.gamelobby.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.tencent.avgame.api.R.styleable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class AutoResizeAsyncImageView
  extends ImageView
  implements URLDrawable.URLDrawableListener
{
  public static final String a = "com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView";
  private int b = 0;
  private int c = 0;
  private boolean d = false;
  private float e = -1.0F;
  private float f = -1.0F;
  private URLDrawable.URLDrawableOptions g;
  private Drawable h;
  private Drawable i;
  private URLDrawable.URLDrawableListener j = null;
  
  public AutoResizeAsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AutoResizeAsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AutoResizeAsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.t);
    this.b = paramContext.getDimensionPixelSize(R.styleable.B, 0);
    this.c = paramContext.getDimensionPixelSize(R.styleable.A, 0);
    this.e = paramContext.getFloat(R.styleable.x, -1.0F);
    this.f = paramContext.getFloat(R.styleable.y, -1.0F);
    this.d = paramContext.getBoolean(R.styleable.w, false);
    paramAttributeSet = new ColorDrawable(paramContext.getColor(R.styleable.u, 0));
    this.h = a(paramContext, R.styleable.z, paramAttributeSet);
    this.i = a(paramContext, R.styleable.v, paramAttributeSet);
    b();
    this.g.mUseApngImage = paramContext.getBoolean(R.styleable.C, false);
    paramContext.recycle();
  }
  
  private Drawable a(TypedArray paramTypedArray, int paramInt, Drawable paramDrawable)
  {
    Drawable localDrawable = paramTypedArray.getDrawable(paramInt);
    paramTypedArray = localDrawable;
    if (localDrawable == null) {
      paramTypedArray = paramDrawable;
    }
    return paramTypedArray;
  }
  
  private void b()
  {
    this.g = URLDrawable.URLDrawableOptions.obtain();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = this.g;
    localURLDrawableOptions.mLoadingDrawable = this.h;
    localURLDrawableOptions.mFailedDrawable = this.i;
    localURLDrawableOptions.mDecodeFileStrategy = 3;
  }
  
  private boolean b(String paramString)
  {
    Object localObject = getDrawable();
    if (!(localObject instanceof URLDrawable)) {
      return false;
    }
    localObject = (URLDrawable)localObject;
    if (!((URLDrawable)localObject).getURL().toString().equals(paramString)) {
      return false;
    }
    int k = ((URLDrawable)localObject).getStatus();
    if ((k != 1) && (k != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    return true;
  }
  
  public void a()
  {
    Object localObject = getDrawable();
    if (!(localObject instanceof URLDrawable)) {
      return;
    }
    localObject = (URLDrawable)localObject;
    if ((localObject != null) && ((((URLDrawable)localObject).getCurrDrawable() instanceof ApngDrawable)) && (((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage() != null))
    {
      Bitmap localBitmap = ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage().getCurrentFrame();
      if (localBitmap != null) {
        localBitmap.eraseColor(0);
      }
      ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).repaly();
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, this.g);
  }
  
  public void a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (b(paramString))
    {
      a();
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
      paramString.setURLDrawableListener(this);
      setImageDrawable(paramString);
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    URLDrawable.URLDrawableListener localURLDrawableListener = this.j;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadCanceled(paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    URLDrawable.URLDrawableListener localURLDrawableListener = this.j;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadFialed(paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    URLDrawable.URLDrawableListener localURLDrawableListener = this.j;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadProgressed(paramURLDrawable, paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    requestLayout();
    URLDrawable.URLDrawableListener localURLDrawableListener = this.j;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadSuccessed(paramURLDrawable);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    if (localDrawable != null)
    {
      int k;
      if ((localDrawable.getIntrinsicHeight() >= 0) && (localDrawable.getIntrinsicWidth() >= 0)) {
        k = 0;
      } else {
        k = 1;
      }
      QLog.d(a, 2, "Drawable not null");
      double d1;
      if ((m == 1073741824) && ((n == -2147483648) || (n == 0)))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt1);
        if (k != 0)
        {
          paramInt1 = this.c;
        }
        else
        {
          if (this.d) {
            d1 = Math.ceil(paramInt2 * this.e / this.f);
          } else {
            d1 = Math.ceil(paramInt2 * localDrawable.getIntrinsicHeight() / localDrawable.getIntrinsicWidth());
          }
          paramInt1 = (int)d1;
        }
        setMeasuredDimension(paramInt2, paramInt1);
        return;
      }
      if (((m == -2147483648) || (m == 0)) && (n == 1073741824))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if (k != 0)
        {
          paramInt1 = this.b;
        }
        else
        {
          if (this.d) {
            d1 = Math.ceil(paramInt2 * this.f / this.e);
          } else {
            d1 = Math.ceil(paramInt2 * localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight());
          }
          paramInt1 = (int)d1;
        }
        setMeasuredDimension(paramInt1, paramInt2);
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    QLog.d(a, 2, "Drawable null");
    if ((m == 1073741824) && ((n == -2147483648) || (n == 0)))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.c);
      return;
    }
    if (((m == -2147483648) || (m == 0)) && (n == 1073741824))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(this.b, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setFailedDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.i = paramDrawable;
    this.g.mFailedDrawable = paramDrawable;
  }
  
  public void setFixedRatio(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.h = paramDrawable;
    this.g.mLoadingDrawable = paramDrawable;
  }
  
  public void setLoopOne()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    this.g.mExtraInfo = localBundle;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.c = Math.max(paramInt, 0);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.b = Math.max(paramInt, 0);
  }
  
  public void setURLDrawableListener(URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    this.j = paramURLDrawableListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView
 * JD-Core Version:    0.7.0.1
 */