package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

final class RIJTabFrameDeliverPopupUtil$1
  implements PopupMenuDialog.OnClickActionListener
{
  RIJTabFrameDeliverPopupUtil$1(Frame paramFrame) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      QLog.e("RIJTabFrameDeliverPopupUtil", 1, "popupMenuDialog click, not support id, id=" + paramMenuItem.a);
      return;
    case 0: 
      RIJUgcUtils.b(this.a.a());
      return;
    case 1: 
      ReadInjoyUserProtocolWidget.a((BaseActivity)this.a.a(), new RIJTabFrameDeliverPopupUtil.1.1(this));
      return;
    case 2: 
      RIJUgcUtils.a(this.a.a(), 1);
      RIJTabFrameDeliverPopupUtil.b();
      return;
    }
    RIJUgcUtils.d(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJTabFrameDeliverPopupUtil.1
 * JD-Core Version:    0.7.0.1
 */