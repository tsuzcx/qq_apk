package com.tencent.mobileqq.activity.qwallet;

import android.content.res.Resources;
import android.widget.TextView;
import anvx;
import com.tencent.mobileqq.activity.qwallet.voice.KSongMicView;
import com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView;

class RedPacketKSongFragment$13
  implements Runnable
{
  RedPacketKSongFragment$13(RedPacketKSongFragment paramRedPacketKSongFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.c()) {
      return;
    }
    String str2 = this.this$0.getResources().getString(2131695053);
    String str1;
    if (this.jdField_a_of_type_Int == 2) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131712783));
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongVolumeView.setVisibility(8);
      this.this$0.b();
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceKSongMicView.b();
      RedPacketKSongFragment.c(this.this$0);
      return;
      str1 = str2;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.this$0.a(this.this$0.getActivity());
        str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.13
 * JD-Core Version:    0.7.0.1
 */