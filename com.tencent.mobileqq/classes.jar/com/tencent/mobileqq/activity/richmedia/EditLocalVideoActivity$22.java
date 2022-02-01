package com.tencent.mobileqq.activity.richmedia;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class EditLocalVideoActivity$22
  implements Runnable
{
  EditLocalVideoActivity$22(EditLocalVideoActivity paramEditLocalVideoActivity, float paramFloat) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.E(this.this$0) != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCurrentRangeTimeChanged, time=");
        localStringBuilder.append(this.this$0.a((int)this.a));
        QLog.d("EditLocalVideoActivity", 2, localStringBuilder.toString());
      }
      EditLocalVideoActivity.E(this.this$0).setText(this.this$0.a((int)this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.22
 * JD-Core Version:    0.7.0.1
 */