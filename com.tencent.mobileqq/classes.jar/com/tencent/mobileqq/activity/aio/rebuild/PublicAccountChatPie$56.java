package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.widget.XListView.DrawFinishedListener;

class PublicAccountChatPie$56
  implements XListView.DrawFinishedListener
{
  PublicAccountChatPie$56(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void drawFinished()
  {
    if ((!this.a.ct) && (this.a.cu))
    {
      this.a.ct = true;
      PublicTracker.a("SUBSCRIPT_AIO_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.56
 * JD-Core Version:    0.7.0.1
 */