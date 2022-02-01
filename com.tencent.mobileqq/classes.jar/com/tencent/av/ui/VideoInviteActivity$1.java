package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class VideoInviteActivity$1
  implements DialogInterface.OnClickListener
{
  VideoInviteActivity$1(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, true, new VideoInviteActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.1
 * JD-Core Version:    0.7.0.1
 */