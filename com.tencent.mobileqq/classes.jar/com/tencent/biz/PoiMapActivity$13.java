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
      this.a.a(((PoiMapActivity.TabView)paramView).a);
      this.a.i();
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabClickListener" + ((PoiMapActivity.TabView)paramView).a);
      }
      if (!PoiMapActivity.a(this.a)) {
        break label127;
      }
      this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      this.a.a("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).a + 1), this.a.f, this.a.e, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.13
 * JD-Core Version:    0.7.0.1
 */