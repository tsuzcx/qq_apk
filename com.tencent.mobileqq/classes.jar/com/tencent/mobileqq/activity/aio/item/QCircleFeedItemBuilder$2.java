package com.tencent.mobileqq.activity.aio.item;

import ahdl;
import ahdo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QCircleFeedItemBuilder$2
  implements Runnable
{
  public QCircleFeedItemBuilder$2(ahdl paramahdl, String paramString, ahdo paramahdo) {}
  
  public void run()
  {
    ahdl.a(ahdl.a(this.this$0, this.this$0.a.getApplication().getResources(), this.jdField_a_of_type_JavaLangString));
    ThreadManager.getUIHandler().post(new QCircleFeedItemBuilder.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */