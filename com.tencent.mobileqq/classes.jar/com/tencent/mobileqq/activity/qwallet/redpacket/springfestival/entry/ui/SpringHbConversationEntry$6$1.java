package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import ahfx;
import ahgq;
import ahgt;
import android.os.Handler;
import bbll;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;

public class SpringHbConversationEntry$6$1
  implements Runnable
{
  public SpringHbConversationEntry$6$1(ahgt paramahgt) {}
  
  public void run()
  {
    ahfx localahfx = (ahfx)this.a.jdField_a_of_type_Ahgq.a.a.getManager(342);
    localahfx.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpakcetPreviewConfBean$BreathLight.type == 0)
    {
      int i = bbll.b(45.0F);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new SpringHbConversationEntry.6.1.1(this, i, localahfx), 3500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbConversationEntry.6.1
 * JD-Core Version:    0.7.0.1
 */