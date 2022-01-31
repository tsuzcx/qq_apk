package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;

class SpringHbEntryBannerView$2
  implements Runnable
{
  SpringHbEntryBannerView$2(SpringHbEntryBannerView paramSpringHbEntryBannerView, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo, Drawable paramDrawable1, Drawable paramDrawable2) {}
  
  public void run()
  {
    SpringHbEntryBannerView.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo$BannerInfo);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      SpringHbEntryBannerView.a(this.this$0).setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    SpringHbEntryBannerView.a(this.this$0).setBackgroundDrawable(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryBannerView.2
 * JD-Core Version:    0.7.0.1
 */