package com.tencent.mobileqq.activity.aio.doodle;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils.CombineCallback;
import com.tencent.qphone.base.util.QLog;

class DoodlePanel$5
  implements ScribbleMsgUtils.CombineCallback
{
  DoodlePanel$5(DoodlePanel paramDoodlePanel, DoodleItem paramDoodleItem) {}
  
  public void a(int paramInt)
  {
    QLog.i("Scribble", 2, "bsuc " + paramInt);
    new Handler(Looper.getMainLooper()).post(new DoodlePanel.5.1(this, paramInt));
  }
  
  public boolean a(String paramString)
  {
    return DoodlePanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5
 * JD-Core Version:    0.7.0.1
 */