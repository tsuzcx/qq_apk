package com.tencent.av.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$3
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$3(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if ((this.this$0.an != null) && (this.this$0.as != null) && (this.this$0.aj != null))
    {
      int i = this.this$0.aj.getDimensionPixelSize(2131300030);
      this.this$0.as.setMaxWidth(i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.this$0.X, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.3
 * JD-Core Version:    0.7.0.1
 */