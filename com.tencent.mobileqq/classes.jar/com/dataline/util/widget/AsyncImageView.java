package com.dataline.util.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends ImageView
{
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = Color.parseColor("#C8C8C8");
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      Object localObject;
      if (FileManagerUtil.a(paramString) == 2)
      {
        localObject = "videothumb";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramBoolean);
        paramString = ((StringBuilder)localObject).toString();
        localObject = "datalineimage";
      }
      try
      {
        paramString = new URL((String)localObject, "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AsyncImageView", 2, paramString.getMessage(), paramString);
        }
        return null;
      }
    }
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AsyncImageView", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setAsyncImage(String paramString)
  {
    URL localURL = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
    if ((getDrawable() instanceof URLDrawable))
    {
      paramString = (URLDrawable)getDrawable();
      if (paramString.getURL().toString().equals(localURL.toString()))
      {
        if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
          paramString.restartDownload();
        }
        return;
      }
    }
    paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (paramString == null) {
      if (this.jdField_b_of_type_Boolean) {
        paramString = new ColorDrawable(this.d);
      } else {
        paramString = getResources().getDrawable(this.c);
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString;
    localURLDrawableOptions.mFailedDrawable = paramString;
    localURLDrawableOptions.mPlayGifImage = false;
    localURLDrawableOptions.mGifRoundCorner = 0.0F;
    localURLDrawableOptions.mDecodeFileStrategy = 3;
    int i = this.jdField_a_of_type_Int;
    if (i > 0)
    {
      int j = this.jdField_b_of_type_Int;
      if (j > 0)
      {
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        break label200;
      }
    }
    localURLDrawableOptions.mRequestWidth = 0;
    localURLDrawableOptions.mRequestHeight = 0;
    label200:
    paramString = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
    setImageDrawable(paramString);
    paramString.setURLDrawableListener(new AsyncImageView.1(this));
  }
  
  public void setDefaultColorDrawable(int paramInt)
  {
    this.d = paramInt;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.c = paramInt;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void setDefaultImageByMargin()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    Resources localResources = getResources();
    if ((URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawableWithMargin(localResources, ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
      return;
    }
    if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawableWithMargin(localResources, ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap(), i, j, -921103);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.getLoadingDrawable();
  }
  
  public void setImageDrawableDefault()
  {
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setIsDrawRound(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */