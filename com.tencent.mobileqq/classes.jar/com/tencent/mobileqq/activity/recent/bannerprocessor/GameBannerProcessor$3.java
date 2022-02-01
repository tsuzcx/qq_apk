package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

class GameBannerProcessor$3
  implements ImageLoader.ImageLoadListener
{
  GameBannerProcessor$3(GameBannerProcessor paramGameBannerProcessor, Bundle paramBundle, Message paramMessage) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("iconURLBitmap", paramBitmap);
    BannerManager.a().a(36, 2, this.jdField_a_of_type_AndroidOsMessage);
    this.jdField_a_of_type_AndroidOsMessage.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor.3
 * JD-Core Version:    0.7.0.1
 */