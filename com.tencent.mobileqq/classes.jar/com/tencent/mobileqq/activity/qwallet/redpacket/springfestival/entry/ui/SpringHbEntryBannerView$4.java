package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahgl;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class SpringHbEntryBannerView$4
  implements Runnable
{
  SpringHbEntryBannerView$4(SpringHbEntryBannerView paramSpringHbEntryBannerView, String paramString, int paramInt, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo) {}
  
  public void run()
  {
    Bitmap localBitmap = ahgl.a(this.jdField_a_of_type_JavaLangString, true);
    if (QLog.isColorLevel()) {
      QLog.d("springHb_SpringHbEntryView", 2, "doLoadDefaultImage -- >,status:" + this.jdField_a_of_type_Int + ",filePath:" + this.jdField_a_of_type_JavaLangString + ",bitmap:" + localBitmap);
    }
    ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryBannerView.4.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryBannerView.4
 * JD-Core Version:    0.7.0.1
 */