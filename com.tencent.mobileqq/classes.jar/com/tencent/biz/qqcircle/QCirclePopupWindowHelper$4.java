package com.tencent.biz.qqcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCirclePopupWindowHelper$4
  implements View.OnClickListener
{
  QCirclePopupWindowHelper$4(QCirclePopupWindowHelper paramQCirclePopupWindowHelper, QCirclePopupWindowHelper.MenuClickListener paramMenuClickListener) {}
  
  public void onClick(View paramView)
  {
    if ((this.a != null) && (paramView.getId() == 2131441751)) {
      this.a.a(QCirclePopupWindowHelper.MenuType.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper.4
 * JD-Core Version:    0.7.0.1
 */