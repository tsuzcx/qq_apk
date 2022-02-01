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
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = null;
  private URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
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
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.h, 0);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.g, 0);
    this.jdField_a_of_type_Float = paramContext.getFloat(R.styleable.d, -1.0F);
    this.jdField_b_of_type_Float = paramContext.getFloat(R.styleable.e, -1.0F);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.c, false);
    paramAttributeSet = new ColorDrawable(paramContext.getColor(R.styleable.jdField_a_of_type_Int, 0));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramContext, R.styleable.f, paramAttributeSet);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(paramContext, R.styleable.jdField_b_of_type_Int, paramAttributeSet);
    b();
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mUseApngImage = paramContext.getBoolean(R.styleable.i, false);
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
  
  private boolean a(String paramString)
  {
    Object localObject = getDrawable();
    if (!(localObject instanceof URLDrawable)) {
      return false;
    }
    localObject = (URLDrawable)localObject;
    if (!((URLDrawable)localObject).getURL().toString().equals(paramString)) {
      return false;
    }
    int i = ((URLDrawable)localObject).getStatus();
    if ((i != 1) && (i != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mDecodeFileStrategy = 3;
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
    a(paramString, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
  }
  
  public void a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (a(paramString))
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
    URLDrawable.URLDrawableListener localURLDrawableListener = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadCanceled(paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    URLDrawable.URLDrawableListener localURLDrawableListener = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadFialed(paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    URLDrawable.URLDrawableListener localURLDrawableListener = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadProgressed(paramURLDrawable, paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    requestLayout();
    URLDrawable.URLDrawableListener localURLDrawableListener = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener;
    if (localURLDrawableListener != null) {
      localURLDrawableListener.onLoadSuccessed(paramURLDrawable);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    if (localDrawable != null)
    {
      int i;
      if ((localDrawable.getIntrinsicHeight() >= 0) && (localDrawable.getIntrinsicWidth() >= 0)) {
        i = 0;
      } else {
        i = 1;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Drawable not null");
      double d;
      if ((j == 1073741824) && ((k == -2147483648) || (k == 0)))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt1);
        if (i != 0)
        {
          paramInt1 = this.jdField_b_of_type_Int;
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {
            d = Math.ceil(paramInt2 * this.jdField_a_of_type_Float / this.jdField_b_of_type_Float);
          } else {
            d = Math.ceil(paramInt2 * localDrawable.getIntrinsicHeight() / localDrawable.getIntrinsicWidth());
          }
          paramInt1 = (int)d;
        }
        setMeasuredDimension(paramInt2, paramInt1);
        return;
      }
      if (((j == -2147483648) || (j == 0)) && (k == 1073741824))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if (i != 0)
        {
          paramInt1 = this.jdField_a_of_type_Int;
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {
            d = Math.ceil(paramInt2 * this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
          } else {
            d = Math.ceil(paramInt2 * localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight());
          }
          paramInt1 = (int)d;
        }
        setMeasuredDimension(paramInt1, paramInt2);
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "Drawable null");
    if ((j == 1073741824) && ((k == -2147483648) || (k == 0)))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jdField_b_of_type_Int);
      return;
    }
    if (((j == -2147483648) || (j == 0)) && (k == 1073741824))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(this.jdField_a_of_type_Int, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setFailedDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = paramDrawable;
  }
  
  public void setFixedRatio(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = paramDrawable;
  }
  
  public void setLoopOne()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mExtraInfo = localBundle;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.jdField_b_of_type_Int = Math.max(paramInt, 0);
  }
  
  public void setMinWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, 0);
  }
  
  public void setURLDrawableListener(URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = paramURLDrawableListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView
 * JD-Core Version:    0.7.0.1
 */