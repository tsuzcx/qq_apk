package com.tencent.biz.qqcircle.adapter;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QCircleFakeAdapter$1
  implements Runnable
{
  QCircleFakeAdapter$1(QCircleFakeAdapter paramQCircleFakeAdapter, List paramList) {}
  
  public void run()
  {
    try
    {
      if (QCircleFakeAdapter.a(this.this$0).size() != this.a.size())
      {
        if (QCircleFakeAdapter.a(this.this$0).size() == 0) {
          this.this$0.getDataList().addAll(0, this.a);
        }
        for (;;)
        {
          QCircleFakeAdapter.a(this.this$0).clear();
          QCircleFakeAdapter.a(this.this$0).addAll(this.a);
          this.this$0.notifyDataSetChanged();
          return;
          QCircleFakeAdapter.a(this.this$0);
          this.this$0.getDataList().addAll(0, this.a);
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
    this.this$0.getDataList().addAll(0, this.a);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.1
 * JD-Core Version:    0.7.0.1
 */