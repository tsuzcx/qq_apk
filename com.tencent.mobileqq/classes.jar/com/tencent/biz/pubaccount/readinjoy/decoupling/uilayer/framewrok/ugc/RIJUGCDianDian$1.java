package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc;

import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyUserProtocolWidget;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

final class RIJUGCDianDian$1
  implements PopupMenuDialog.OnClickActionListener
{
  RIJUGCDianDian$1(BaseActivity paramBaseActivity) {}
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      ReadInjoyUserProtocolWidget.a(this.a, new RIJUGCDianDian.1.1(this));
      return;
    }
    ReadInjoyUserProtocolWidget.a(this.a, new RIJUGCDianDian.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian.1
 * JD-Core Version:    0.7.0.1
 */