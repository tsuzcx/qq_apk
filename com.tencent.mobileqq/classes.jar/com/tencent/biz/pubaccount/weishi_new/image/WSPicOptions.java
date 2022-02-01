package com.tencent.biz.pubaccount.weishi_new.image;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;

public class WSPicOptions
{
  private ImageView a;
  private String b;
  private Drawable c;
  private String d;
  private int e;
  private boolean f = true;
  private IPublicAccountImageDownListener g;
  
  public WSPicOptions(ImageView paramImageView, String paramString)
  {
    this.a = paramImageView;
    this.b = paramString;
  }
  
  public ImageView a()
  {
    return this.a;
  }
  
  public WSPicOptions a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public WSPicOptions a(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    return this;
  }
  
  public WSPicOptions a(IPublicAccountImageDownListener paramIPublicAccountImageDownListener)
  {
    this.g = paramIPublicAccountImageDownListener;
    return this;
  }
  
  public WSPicOptions a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public WSPicOptions a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Drawable c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
  
  public IPublicAccountImageDownListener g()
  {
    return this.g;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageView:");
    Object localObject = this.a;
    if (localObject != null) {
      localObject = Integer.valueOf(localObject.hashCode());
    } else {
      localObject = "";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", sopName:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", listIndex:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isNeedReport:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", path:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicOptions
 * JD-Core Version:    0.7.0.1
 */