package com.tencent.mobileqq.activity.qwallet;

import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;
import com.tencent.mobileqq.app.HardCodeUtil;

class RedPacketKSongFragment$12
  implements Runnable
{
  RedPacketKSongFragment$12(RedPacketKSongFragment paramRedPacketKSongFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.c()) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713269));
      RedPacketKSongFragment.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.o();
    }
    for (;;)
    {
      RedPacketKSongFragment.c(this.this$0);
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713271));
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
      this.this$0.b();
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.12
 * JD-Core Version:    0.7.0.1
 */