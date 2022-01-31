package com.tencent.mobileqq.activity.qwallet;

import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;

class RedPacketVoiceFragment$4
  implements Runnable
{
  RedPacketVoiceFragment$4(RedPacketVoiceFragment paramRedPacketVoiceFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.c()) {
      return;
    }
    String str2 = this.this$0.getResources().getString(2131695804);
    String str1;
    if (this.jdField_a_of_type_Int == 2) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      this.this$0.b.setText(str1);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
      this.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      RedPacketVoiceFragment.a(this.this$0);
      if (RedPacketVoiceFragment.a(this.this$0) == null) {
        break;
      }
      RedPacketVoiceFragment.a(this.this$0).removeCallbacksAndMessages(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment.4
 * JD-Core Version:    0.7.0.1
 */