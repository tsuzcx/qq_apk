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
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class AutoResizeAsyncImageView
  extends ImageView
  implements URLDrawable.URLDrawableListener
{
  public static final String a;
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = null;
  private URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  static
  {
    jdField_a_of_type_JavaLangString = AutoResizeAsyncImageView.class.getName();
  }
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AutoResizeAsyncImageView);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(8, 0);
    this.jdField_b_of_type_Int = paramContext.getDimensionPixelSize(7, 0);
    this.jdField_a_of_type_Float = paramContext.getFloat(4, -1.0F);
    this.jdField_b_of_type_Float = paramContext.getFloat(5, -1.0F);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(3, false);
    paramAttributeSet = new ColorDrawable(paramContext.getColor(0, 0));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramContext, 6, paramAttributeSet);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(paramContext, 2, paramAttributeSet);
    b();
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mUseApngImage = paramContext.getBoolean(9, false);
    paramContext.recycle();
  }
  
  private Drawable a(TypedArray paramTypedArray, int paramInt, Drawable paramDrawable)
  {
    paramTypedArray = paramTypedArray.getDrawable(paramInt);
    if (paramTypedArray == null) {
      return paramDrawable;
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
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mDecodeFileStrategy = 3;
  }
  
  public void a()
  {
    Object localObject = getDrawable();
    if (!(localObject instanceof URLDrawable)) {}
    do
    {
      return;
      localObject = (URLDrawable)localObject;
    } while ((localObject == null) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof ApngDrawable)) || (((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage() == null));
    Bitmap localBitmap = ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage().getCurrentFrame();
    if (localBitmap != null) {
      localBitmap.eraseColor(0);
    }
    ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).repaly();
  }
  
  public void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
  }
  
  public void a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (a(paramString)) {
      a();
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
    paramString.setURLDrawableListener(this);
    setImageDrawable(paramString);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener.onLoadCanceled(paramURLDrawable);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener.onLoadFialed(paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener.onLoadProgressed(paramURLDrawable, paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    requestLayout();
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener.onLoadSuccessed(paramURLDrawable);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    if (localDrawable != null)
    {
      int i;
      if ((localDrawable.getIntrinsicHeight() < 0) || (localDrawable.getIntrinsicWidth() < 0))
      {
        i = 1;
        QLog.d(jdField_a_of_type_JavaLangString, QLog._DEFAULT_REPORTLOG_LEVEL, "Drawable not null");
        if ((j != 1073741824) || ((k != -2147483648) && (k != 0))) {
          break label150;
        }
        paramInt2 = View.MeasureSpec.getSize(paramInt1);
        if (i == 0) {
          break label97;
        }
        paramInt1 = this.jdField_b_of_type_Int;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        i = 0;
        break;
        label97:
        if (this.jdField_a_of_type_Boolean) {
          paramInt1 = (int)Math.ceil(paramInt2 * this.jdField_a_of_type_Float / this.jdField_b_of_type_Float);
        } else {
          paramInt1 = (int)Math.ceil(paramInt2 * localDrawable.getIntrinsicHeight() / localDrawable.getIntrinsicWidth());
        }
      }
      label150:
      if (((j == -2147483648) || (j == 0)) && (k == 1073741824))
      {
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if (i != 0) {
          paramInt1 = this.jdField_a_of_type_Int;
        }
        for (;;)
        {
          setMeasuredDimension(paramInt1, paramInt2);
          return;
          if (this.jdField_a_of_type_Boolean) {
            paramInt1 = (int)Math.ceil(paramInt2 * this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
          } else {
            paramInt1 = (int)Math.ceil(paramInt2 * localDrawable.getIntrinsicWidth() / localDrawable.getIntrinsicHeight());
          }
        }
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, QLog._DEFAULT_REPORTLOG_LEVEL, "Drawable null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView
 * JD-Core Version:    0.7.0.1
 */