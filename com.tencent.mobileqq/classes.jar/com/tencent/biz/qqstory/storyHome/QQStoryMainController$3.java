package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import vzu;

class QQStoryMainController$3
  implements Runnable
{
  QQStoryMainController$3(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    ((vzu)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(2001, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.3
 * JD-Core Version:    0.7.0.1
 */