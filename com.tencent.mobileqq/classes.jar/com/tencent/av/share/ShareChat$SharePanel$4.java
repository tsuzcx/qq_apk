package com.tencent.av.share;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShareChat$SharePanel$4
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showChooseTypeActionSheet, which[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], mIHandle[");
      localStringBuilder.append(this.d.f);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
    }
    if (this.d.f == null) {
      return;
    }
    paramView = paramView.getContext();
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.d.a(this.a, paramView, this.b);
      }
    }
    else {
      this.d.b(this.a, paramView, this.b);
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.4
 * JD-Core Version:    0.7.0.1
 */