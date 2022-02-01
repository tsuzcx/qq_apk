package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.LooperGifImage.OnPlayFinish;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class WSMultiImageManager$2
  implements LooperGifImage.OnPlayFinish
{
  WSMultiImageManager$2(WSMultiImageManager paramWSMultiImageManager, String paramString, URLImageView paramURLImageView) {}
  
  public void a()
  {
    URLDrawable localURLDrawable = WSMultiImageManager.a(this.c, this.a, true);
    if (localURLDrawable == null) {
      return;
    }
    this.b.setImageDrawable(localURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager.2
 * JD-Core Version:    0.7.0.1
 */