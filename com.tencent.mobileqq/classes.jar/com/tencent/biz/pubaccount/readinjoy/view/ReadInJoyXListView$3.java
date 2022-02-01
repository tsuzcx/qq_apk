package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;

class ReadInJoyXListView$3
  implements Runnable
{
  ReadInJoyXListView$3(ReadInJoyXListView paramReadInJoyXListView, boolean paramBoolean) {}
  
  public void run()
  {
    QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], isTopRefreshIng = " + this.a);
    if (this.a)
    {
      this.this$0.setLayerType(1, null);
      return;
    }
    this.this$0.setLayerType(ReadInJoyXListView.a(this.this$0), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView.3
 * JD-Core Version:    0.7.0.1
 */