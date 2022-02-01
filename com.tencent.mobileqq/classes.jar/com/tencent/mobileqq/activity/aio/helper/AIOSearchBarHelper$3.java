package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class AIOSearchBarHelper$3
  implements AdapterView.OnItemClickListener
{
  AIOSearchBarHelper$3(AIOSearchBarHelper paramAIOSearchBarHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (MessageItem)AIOSearchBarHelper.a(this.a).a.getItem(paramInt - 1);
    AIOSearchBarHelper.a(this.a, paramAdapterView);
    AIOSearchBarHelper.a(this.a).dismiss();
    ReportController.b(AIOSearchBarHelper.a(this.a).a, "dc00898", "", "", "0X800A417", "0X800A417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.3
 * JD-Core Version:    0.7.0.1
 */