package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoEnterPageActivity$RefreshFaceRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$RefreshFaceRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.this$0.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI;
      int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int i = 0;
      while (i < j)
      {
        arrayOfMultiVideoEnterPageMembersControlUI[i].c();
        i += 1;
      }
    }
    if (this.this$0.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.this$0.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */