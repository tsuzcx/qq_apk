package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;

public class GalleryProgressView
  implements AbstractProgressView
{
  ImageView a;
  PhotoProgressDrawable b;
  Rect c;
  boolean d = false;
  boolean e = false;
  int f = 0;
  
  private void a(Activity paramActivity)
  {
    try
    {
      localBitmap1 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130850524);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap1;
      label13:
      Bitmap localBitmap2;
      break label13;
    }
    localBitmap1 = null;
    localBitmap2 = localBitmap1;
    if (localBitmap1 == null) {
      localBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
    }
    this.b = new PhotoProgressDrawable(localBitmap2, (int)(paramActivity.getResources().getDisplayMetrics().density * 12.0F));
    this.b.setLevel(0);
    this.c = new Rect(0, 0, 0, 0);
  }
  
  public void a()
  {
    this.d = true;
    if ((this.e) && (this.a.getVisibility() == 4))
    {
      if ((this.c.width() == 0) || (this.c.height() == 0))
      {
        this.c.set(0, 0, this.a.getWidth(), this.a.getHeight());
        this.b.setBounds(this.c);
        this.a.setImageDrawable(this.b);
      }
      this.a.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    this.e = true;
    if (this.d)
    {
      if ((this.c.width() == 0) || (this.c.height() == 0))
      {
        this.c.set(0, 0, this.a.getWidth(), this.a.getHeight());
        this.b.setBounds(this.c);
        this.a.setImageDrawable(this.b);
      }
      this.a.setVisibility(0);
    }
    if ((paramInt >= 0) && (paramInt < 100))
    {
      this.b.setLevel(paramInt * 100);
      this.b.invalidateSelf();
      return;
    }
    this.b.a();
  }
  
  public void a(Activity paramActivity, ImageView paramImageView)
  {
    this.a = paramImageView;
    a(paramActivity);
  }
  
  public void a(Activity paramActivity, AbstractGalleryScene paramAbstractGalleryScene)
  {
    this.a = ((ImageView)((RelativeLayout)paramAbstractGalleryScene.C()).findViewById(2131440773));
    a(paramActivity);
  }
  
  public void b()
  {
    this.d = false;
    if (this.a.getVisibility() == 0) {
      this.a.setVisibility(4);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      this.b.setLevel(paramInt * 100);
      this.b.invalidateSelf();
    }
  }
  
  public void c()
  {
    this.f = 0;
    this.e = false;
    if (this.a.getVisibility() == 0) {
      this.a.setVisibility(4);
    }
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryProgressView
 * JD-Core Version:    0.7.0.1
 */