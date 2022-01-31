package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.net.URL;

public class ShortVideoRealItemBuilder$ChatVideoView
  extends BubbleImageView
{
  URLDrawable a;
  public URLDrawable b;
  
  public ShortVideoRealItemBuilder$ChatVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    super.a();
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("PIXEL 2")) || (str.contains("M821"))) {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public boolean a(String paramString)
  {
    return (this.b == null) || (!this.b.getURL().getPath().equals(paramString));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
  
  public void setVideoDrawable(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    paramURLDrawable.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.ChatVideoView
 * JD-Core Version:    0.7.0.1
 */