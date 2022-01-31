package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$1
  implements Runnable
{
  QCircleFakeAdapter$1(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent) {}
  
  public void run()
  {
    try
    {
      if (QCircleFakeAdapter.a(this.this$0).size() != this.a.mFakeFeedDataList.size())
      {
        if (QCircleFakeAdapter.a(this.this$0).size() == 0) {
          this.this$0.b().addAll(0, this.a.mFakeFeedDataList);
        }
        for (;;)
        {
          QCircleFakeAdapter.a(this.this$0).clear();
          QCircleFakeAdapter.a(this.this$0).addAll(this.a.mFakeFeedDataList);
          this.this$0.notifyDataSetChanged();
          return;
          QCircleFakeAdapter.a(this.this$0);
          this.this$0.b().addAll(0, this.a.mFakeFeedDataList);
        }
      }
      if (QCircleFakeAdapter.a(this.this$0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QCircleFakeAdapter", 1, "onPublishFeedReload exception:" + localException.toString());
      return;
    }
    this.this$0.b().addAll(0, this.a.mFakeFeedDataList);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.1
 * JD-Core Version:    0.7.0.1
 */