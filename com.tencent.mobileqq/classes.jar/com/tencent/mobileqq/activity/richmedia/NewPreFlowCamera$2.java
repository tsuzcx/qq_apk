package com.tencent.mobileqq.activity.richmedia;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class NewPreFlowCamera$2
  implements Runnable
{
  NewPreFlowCamera$2(NewPreFlowCamera paramNewPreFlowCamera, String paramString) {}
  
  public void run()
  {
    this.this$0.a.setText(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "setTipsTextData: textData=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera.2
 * JD-Core Version:    0.7.0.1
 */