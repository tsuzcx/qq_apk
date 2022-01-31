package com.dataline.util.widget;

import amyk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import apck;
import axwd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import fa;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
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
    Object localObject = null;
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {}
    do
    {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AsyncImageView", 2, paramString.getMessage(), paramString);
          }
          paramString = null;
        }
      }
      String str2;
      String str1;
      if (apck.a(paramString) == 2)
      {
        str2 = "videothumb";
        str1 = paramString;
        paramString = str2;
      }
      for (;;)
      {
        try
        {
          paramString = new URL(paramString, "", str1);
          return paramString;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          paramString = localObject;
        }
        str1 = "datalineimage";
        str2 = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + "0" + "|" + paramBoolean;
        paramString = str1;
        str1 = str2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AsyncImageView", 2, localMalformedURLException.getMessage(), localMalformedURLException);
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
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramString = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramString;
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mGifRoundCorner = 0.0F;
      localURLDrawableOptions.mDecodeFileStrategy = 3;
      if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        break label204;
      }
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
    }
    for (localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;; localURLDrawableOptions.mRequestHeight = 0)
    {
      paramString = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      setImageDrawable(paramString);
      paramString.setURLDrawableListener(new fa(this));
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        paramString = new ColorDrawable(this.d);
        break;
      }
      paramString = getResources().getDrawable(this.c);
      break;
      label204:
      localURLDrawableOptions.mRequestWidth = 0;
    }
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
    if ((axwd.b() instanceof SkinnableBitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new amyk(localResources, ((SkinnableBitmapDrawable)axwd.b()).getBitmap(), i, j, -921103);
      return;
    }
    if ((axwd.b() instanceof BitmapDrawable))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new amyk(localResources, ((BitmapDrawable)axwd.b()).getBitmap(), i, j, -921103);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = axwd.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.util.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */