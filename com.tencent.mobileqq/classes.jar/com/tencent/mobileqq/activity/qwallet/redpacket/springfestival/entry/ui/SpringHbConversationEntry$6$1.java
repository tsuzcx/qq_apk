package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahfz;
import ahgs;
import ahgv;
import android.os.Handler;
import bbkx;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class SpringHbConversationEntry$6$1
  implements Runnable
{
  public SpringHbConversationEntry$6$1(ahgv paramahgv) {}
  
  public void run()
  {
    ahfz localahfz = (ahfz)this.a.jdField_a_of_type_Ahgs.a.a.getManager(342);
    localahfz.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.type == 0)
    {
      int i = bbkx.b(45.0F);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new SpringHbConversationEntry.6.1.1(this, i, localahfz), 3500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.6.1
 * JD-Core Version:    0.7.0.1
 */