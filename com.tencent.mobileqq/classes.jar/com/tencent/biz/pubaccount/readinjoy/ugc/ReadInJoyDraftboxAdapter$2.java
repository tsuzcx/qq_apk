package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxAdapter$2
  implements View.OnClickListener
{
  ReadInJoyDraftboxAdapter$2(ReadInJoyDraftboxAdapter paramReadInJoyDraftboxAdapter, ReadInJoyDraftboxItem paramReadInJoyDraftboxItem, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDraftboxAdapter.2.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2
 * JD-Core Version:    0.7.0.1
 */