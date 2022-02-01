package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import meg;

class GAudioMembersCtrlActivity$RefreshFaceRunnable
  implements Runnable
{
  private GAudioMembersCtrlActivity$RefreshFaceRunnable(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Meg != null) {
      this.this$0.jdField_a_of_type_Meg.a();
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */