package com.tencent.mobileqq.activity.springfestival.entry.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

class SpringPopBanner$3
  implements View.OnClickListener
{
  SpringPopBanner$3(SpringPopBanner paramSpringPopBanner, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("active_id", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("refer", "1");
    SpringHbReporter.a("event_dachaping", 0, 0, localHashMap, "clk", true);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner.a(true);
    SpringPopBanner.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryUiSpringPopBanner, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ui.SpringPopBanner.3
 * JD-Core Version:    0.7.0.1
 */