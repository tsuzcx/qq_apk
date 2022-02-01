package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxFragment$1$1
  implements ReadInJoyDraftboxFragment.LoadDraftCallback
{
  ReadInJoyDraftboxFragment$1$1(ReadInJoyDraftboxFragment.1 param1) {}
  
  public void a(List<ReadInJoyDraftboxItem> paramList)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxFragment.1.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment.1.1
 * JD-Core Version:    0.7.0.1
 */