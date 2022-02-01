package com.tencent.mobileqq.activity.specialcare;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;

class SpecailCareListActivity$1
  extends Handler
{
  SpecailCareListActivity$1(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2002: 
      if (this.a.i == null)
      {
        paramMessage = this.a;
        paramMessage.i = new QQProgressDialog(paramMessage, paramMessage.getTitleBarHeight());
      }
      this.a.i.c(2131897330);
      if ((!this.a.isFinishing()) && (!this.a.i.isShowing()))
      {
        this.a.i.show();
        return;
      }
      break;
    case 2001: 
      this.a.h.springBackOverScrollHeaderView();
      return;
    case 2000: 
      this.a.h.springBackOverScrollHeaderView();
      QQToast.makeText(BaseApplication.getContext(), 1, 2131892104, 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.1
 * JD-Core Version:    0.7.0.1
 */