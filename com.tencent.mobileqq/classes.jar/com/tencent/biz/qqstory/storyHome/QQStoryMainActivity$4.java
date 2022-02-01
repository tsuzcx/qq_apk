package com.tencent.biz.qqstory.storyHome;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;

class QQStoryMainActivity$4
  implements DialogInterface.OnClickListener
{
  QQStoryMainActivity$4(QQStoryMainActivity paramQQStoryMainActivity, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "-->qbShowShareResultDialog--stay");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.home.QQStoryMainActivity", 2, "qbShowShareResultDialog back");
      }
      Util.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity, 0, "", "");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.finish();
      try
      {
        paramDialogInterface = (PendingIntent)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramDialogInterface != null) && ((paramDialogInterface instanceof PendingIntent)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "-->finish--send callback using PendingIntent");
          }
          paramDialogInterface.send();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity.moveTaskToBack(true);
        return;
      }
      catch (Throwable paramDialogInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.home.QQStoryMainActivity", 2, "qbShowShareResultDialog ", paramDialogInterface);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.4
 * JD-Core Version:    0.7.0.1
 */