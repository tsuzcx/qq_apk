package com.tencent.biz;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PoiMapActivity$13
  implements View.OnClickListener
{
  PoiMapActivity$13(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof PoiMapActivity.TabView))
    {
      Object localObject = this.a;
      PoiMapActivity.TabView localTabView = (PoiMapActivity.TabView)paramView;
      ((PoiMapActivity)localObject).a(localTabView.d);
      this.a.f();
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mTabClickListener");
        ((StringBuilder)localObject).append(localTabView.d);
        QLog.i("PoiMapActivity", 4, ((StringBuilder)localObject).toString());
      }
      StringBuilder localStringBuilder;
      if (PoiMapActivity.g(this.a))
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("click_tab");
        localStringBuilder.append(localTabView.d + 1);
        ((PoiMapActivity)localObject).a("share_locate", localStringBuilder.toString(), "", "", "", "");
      }
      else
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("click_tab");
        localStringBuilder.append(localTabView.d + 1);
        ((PoiMapActivity)localObject).a("share_locate", localStringBuilder.toString(), this.a.ac, this.a.ab, "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.13
 * JD-Core Version:    0.7.0.1
 */