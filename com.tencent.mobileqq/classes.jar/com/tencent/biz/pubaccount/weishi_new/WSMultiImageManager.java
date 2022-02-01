package com.tencent.biz.pubaccount.weishi_new;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader;
import com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

public class WSMultiImageManager
{
  private IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new WSMultiImageManager.1(this);
  private boolean jdField_a_of_type_Boolean;
  
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
      if (paramBoolean) {
        break label79;
      }
      paramString.setIndividualPause(true);
    }
    for (;;)
    {
      ((AbstractGifImage)localObject).reset();
      return paramString;
      label79:
      paramString.setIndividualPause(false);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage.a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void a(URLImageView paramURLImageView, Drawable paramDrawable, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramURLImageView.setImageDrawable(paramDrawable);
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean2;
      paramDrawable = a(paramString, paramBoolean1);
    } while (paramDrawable == null);
    if (paramDrawable.getStatus() == 1)
    {
      if ((paramDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage = ((IPublicAccountGifPlayTimeHttpDownloader.LooperGifImage)localAbstractGifImage);
          this.jdField_a_of_type_ComTencentBizPubaccountUtilApiIPublicAccountGifPlayTimeHttpDownloader$LooperGifImage.a(new WSMultiImageManager.2(this, paramString, paramURLImageView));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(paramURLImageView, paramDrawable);
    }
    for (;;)
    {
      paramURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      paramURLImageView.setImageDrawable(paramDrawable);
      return;
      paramDrawable.startDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager
 * JD-Core Version:    0.7.0.1
 */