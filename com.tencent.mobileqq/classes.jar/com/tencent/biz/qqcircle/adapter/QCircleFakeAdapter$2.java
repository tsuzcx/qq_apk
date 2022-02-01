package com.tencent.biz.qqcircle.adapter;

import java.util.ArrayList;

class QCircleFakeAdapter$2
  implements Runnable
{
  QCircleFakeAdapter$2(QCircleFakeAdapter paramQCircleFakeAdapter) {}
  
  public void run()
  {
    QCircleFakeAdapter.a(this.this$0).clear();
    QCircleFakeAdapter.b(this.this$0);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.2
 * JD-Core Version:    0.7.0.1
 */