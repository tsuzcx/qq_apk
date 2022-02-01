package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.DPCObserver;

class MsgTabStoryNodeConfigManager$3
  implements DPCObserver
{
  MsgTabStoryNodeConfigManager$3(MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((QQStoryHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1023, true, Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.3
 * JD-Core Version:    0.7.0.1
 */