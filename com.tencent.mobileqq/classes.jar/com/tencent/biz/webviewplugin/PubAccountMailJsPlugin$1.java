package com.tencent.biz.webviewplugin;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PubAccountMailJsPlugin$1
  implements ActionSheet.OnButtonClickListener
{
  PubAccountMailJsPlugin$1(PubAccountMailJsPlugin paramPubAccountMailJsPlugin) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.b.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PubAccountMailJsPlugin", 2, String.format("Unknow button %d", new Object[] { Integer.valueOf(paramInt) }));
            }
          }
          else {
            PubAccountMailJsPlugin.d(this.a);
          }
        }
        else {
          PubAccountMailJsPlugin.c(this.a);
        }
      }
      else {
        PubAccountMailJsPlugin.b(this.a);
      }
    }
    else {
      PubAccountMailJsPlugin.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountMailJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */