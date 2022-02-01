package com.tencent.biz.pubaccount.weishi_new;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.LooperGifImage;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

public class WSMultiImageManager
{
  private LooperGifImage a;
  private boolean b;
  private URLDrawableDownListener c = new WSMultiImageManager.1(this);
  
  private URLDrawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    URL localURL = ((IPublicAccountGifPlayTimeHttpDownloader)QRoute.api(IPublicAccountGifPlayTimeHttpDownloader.class)).getPubURL(paramString);
    if (localURL == null) {
      return URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    }
    paramString = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if ((paramString.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramString.getCurrDrawable()).getImage();
      if (!paramBoolean) {
        paramString.setIndividualPause(true);
      } else {
        paramString.setIndividualPause(false);
      }
      ((AbstractGifImage)localObject).reset();
    }
    return paramString;
  }
  
  private void b()
  {
    if (this.b) {
      a();
    }
  }
  
  public void a()
  {
    LooperGifImage localLooperGifImage = this.a;
    if (localLooperGifImage != null) {
      localLooperGifImage.a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void a(URLImageView paramURLImageView, Drawable paramDrawable, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
    }
    this.b = paramBoolean2;
    paramDrawable = a(paramString, paramBoolean1);
    if (paramDrawable == null) {
      return;
    }
    if (paramDrawable.getStatus() == 1)
    {
      if ((paramDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof LooperGifImage))
        {
          this.a = ((LooperGifImage)localAbstractGifImage);
          this.a.a(new WSMultiImageManager.2(this, paramString, paramURLImageView));
        }
      }
      this.c.onLoadSuccessed(paramURLImageView, paramDrawable);
    }
    else
    {
      paramDrawable.startDownload();
    }
    paramURLImageView.setURLDrawableDownListener(this.c);
    paramURLImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager
 * JD-Core Version:    0.7.0.1
 */