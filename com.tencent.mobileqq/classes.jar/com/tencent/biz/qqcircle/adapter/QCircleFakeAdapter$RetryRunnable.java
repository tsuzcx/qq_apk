package com.tencent.biz.qqcircle.adapter;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.qphone.base.util.QLog;

public class QCircleFakeAdapter$RetryRunnable
  implements Runnable
{
  private QCircleFakeAdapter jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter;
  private QCircleFeedEvent jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent;
  
  public QCircleFakeAdapter$RetryRunnable(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter = paramQCircleFakeAdapter;
    this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent = paramQCircleFeedEvent;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null) && (this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent != null))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent, true);
      return;
    }
    QLog.d("QCircleFakeAdapter", 1, "adapter or event is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter.RetryRunnable
 * JD-Core Version:    0.7.0.1
 */