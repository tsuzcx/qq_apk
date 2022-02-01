package com.tencent.biz.qqcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePopupWindowHelper$5
  implements View.OnClickListener
{
  QCirclePopupWindowHelper$5(QCirclePopupWindowHelper paramQCirclePopupWindowHelper, QCirclePopupWindowHelper.MenuClickListener paramMenuClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      int i = paramView.getId();
      if (i == 2131441758) {
        this.a.a(QCirclePopupWindowHelper.MenuType.a);
      } else if (i == 2131441750) {
        this.a.a(QCirclePopupWindowHelper.MenuType.b);
      } else if (i == 2131441751) {
        this.a.a(QCirclePopupWindowHelper.MenuType.c);
      } else if (i == 2131441757) {
        this.a.a(QCirclePopupWindowHelper.MenuType.d);
      } else if (i == 2131441752) {
        this.a.a(QCirclePopupWindowHelper.MenuType.e);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.5
 * JD-Core Version:    0.7.0.1
 */