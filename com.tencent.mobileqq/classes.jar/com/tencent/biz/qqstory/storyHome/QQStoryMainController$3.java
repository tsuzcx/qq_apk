package com.tencent.biz.qqstory.storyHome;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class QQStoryMainController$3
  implements Runnable
{
  QQStoryMainController$3(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    ((QQStoryHandler)QQStoryContext.j().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(2001, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.3
 * JD-Core Version:    0.7.0.1
 */