package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class AIOSearchBarHelper$2
  implements AdapterView.OnItemClickListener
{
  AIOSearchBarHelper$2(AIOSearchBarHelper paramAIOSearchBarHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (MessageItem)AIOSearchBarHelper.b(this.a).o.getItem(paramInt - 1);
    AIOSearchBarHelper.a(this.a, paramAdapterView);
    AIOSearchBarHelper.b(this.a).dismiss();
    ReportController.b(AIOSearchBarHelper.c(this.a).d, "dc00898", "", "", "0X800A417", "0X800A417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper.2
 * JD-Core Version:    0.7.0.1
 */