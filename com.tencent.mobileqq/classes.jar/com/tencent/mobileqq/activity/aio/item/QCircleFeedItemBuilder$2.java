package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class QCircleFeedItemBuilder$2
  implements Runnable
{
  QCircleFeedItemBuilder$2(QCircleFeedItemBuilder paramQCircleFeedItemBuilder, String paramString, QCircleFeedItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    QCircleFeedItemBuilder localQCircleFeedItemBuilder = this.this$0;
    QCircleFeedItemBuilder.a(QCircleFeedItemBuilder.a(localQCircleFeedItemBuilder, localQCircleFeedItemBuilder.a.getApplication().getResources(), this.jdField_a_of_type_JavaLangString));
    ThreadManager.getUIHandler().post(new QCircleFeedItemBuilder.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */