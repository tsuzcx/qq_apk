package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import agtt;
import agtw;
import aguo;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class SpringHbEntryPendantHolder$1
  implements Runnable
{
  public SpringHbEntryPendantHolder$1(aguo paramaguo, agtt paramagtt) {}
  
  public void run()
  {
    Bitmap localBitmap = agtw.a("spring_hb/qvip_pay_entry_drum_default.png", true);
    if (localBitmap != null) {
      ThreadManagerV2.getUIHandlerV2().post(new SpringHbEntryPendantHolder.1.1(this, localBitmap));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("springHb_SpringHbEntryPendantHolder", 2, "doLoadDefaultImage...bitmap:" + localBitmap + "isShowingNativeDefaultImage:" + aguo.a(this.this$0));
      }
      return;
      aguo.a(false);
      aguo.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbEntryPendantHolder.1
 * JD-Core Version:    0.7.0.1
 */