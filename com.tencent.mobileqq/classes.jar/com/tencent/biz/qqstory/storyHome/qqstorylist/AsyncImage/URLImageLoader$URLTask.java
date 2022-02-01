package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class URLImageLoader$URLTask
  extends Task
  implements URLDrawable.URLDrawableListener
{
  private URLImageLoader.Config i;
  private URLDrawable j;
  
  public URLImageLoader$URLTask(ImageView paramImageView, URLImageLoader.Config paramConfig)
  {
    super(paramImageView);
    this.i = paramConfig;
  }
  
  public void a()
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "runOnBackGround url= ", this.i.a });
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      new URL(this.i.a);
      this.j = URLDrawable.getDrawable(this.i.a, localURLDrawableOptions);
      this.j.setURLDrawableListener(this);
      if (this.j.getStatus() == 1)
      {
        InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable have urlDrawable cache" });
        onLoadSuccessed(this.j);
        return;
      }
      if ((this.j.getStatus() != 2) && (this.j.getStatus() != 3))
      {
        InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable startDownload" });
        this.j.startDownload(true);
        return;
      }
      InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "drawable restartDownload" });
      this.j.restartDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localMalformedURLException.printStackTrace();
      InfoPrinter.a("Q.qqstory.newImageLoader", new Object[] { localMalformedURLException.getMessage() });
      Drawable localDrawable = this.i.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url is error:");
      localStringBuilder.append(localMalformedURLException);
      a(localDrawable, localStringBuilder.toString());
    }
  }
  
  public String b()
  {
    return this.i.a;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadCanceled url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, "task have been cancel!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadFialed url= ", paramURLDrawable.getURL() });
    super.a(paramURLDrawable, paramThrowable.getMessage());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    InfoPrinter.c("Q.qqstory.newImageLoader", new Object[] { "onLoadSuccessed url= ", paramURLDrawable.getURL() });
    if (this.h)
    {
      super.a(paramURLDrawable);
      return;
    }
    if (this.i.b != null)
    {
      Bitmap localBitmap = StoryListUtils.a(paramURLDrawable.getCurrDrawable(), this.i.c, this.i.d, UIUtils.e, this.i.b);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramURLDrawable = (ImageView)this.d.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.setTag(2131436783, localBitmap);
        }
        super.a(new BitmapDrawable(localBitmap));
        return;
      }
      super.a(paramURLDrawable, "drawable transform failed!");
      return;
    }
    super.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.URLTask
 * JD-Core Version:    0.7.0.1
 */