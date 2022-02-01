package com.tencent.biz.qqcircle.publish.task;

import cooperation.qqcircle.beans.QCircleFakeFeed;

class QCircleUploadShuoShuoTask$RetryRequestFeed
  implements Runnable
{
  QCircleFakeFeed a;
  int b = 0;
  QCircleUploadShuoShuoTask.ResultParmas c;
  
  public QCircleUploadShuoShuoTask$RetryRequestFeed(QCircleUploadShuoShuoTask paramQCircleUploadShuoShuoTask, QCircleFakeFeed paramQCircleFakeFeed, int paramInt, QCircleUploadShuoShuoTask.ResultParmas paramResultParmas)
  {
    this.a = paramQCircleFakeFeed;
    this.b = paramInt;
    this.c = paramResultParmas;
  }
  
  public void run()
  {
    QCircleUploadShuoShuoTask.a(this.this$0, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask.RetryRequestFeed
 * JD-Core Version:    0.7.0.1
 */