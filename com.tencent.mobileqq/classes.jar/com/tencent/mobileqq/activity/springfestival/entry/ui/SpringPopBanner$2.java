package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class SpringPopBanner$2
  implements View.OnClickListener
{
  SpringPopBanner$2(SpringPopBanner paramSpringPopBanner) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true);
    Object localObject = SpringPopBanner.a(this.a).getTag();
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      HashMap localHashMap = new HashMap();
      localHashMap.put("active_id", localObject);
      localHashMap.put("refer", "2");
      SpringHbReporter.a("event_dachaping", 0, 0, localHashMap, "clk", true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner.2
 * JD-Core Version:    0.7.0.1
 */