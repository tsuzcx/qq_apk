package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MsgTabStoryNodeListManager$4
  extends QQStoryObserver
{
  MsgTabStoryNodeListManager$4(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void a()
  {
    SLog.b(MsgTabStoryNodeListManager.o(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.E == null) {
      SLog.e(MsgTabStoryNodeListManager.o(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    MsgTabStoryManager localMsgTabStoryManager = (MsgTabStoryManager)this.a.E.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    if (localMsgTabStoryManager.e())
    {
      if (this.a.h()) {
        this.a.k.a("exp_story", 3);
      }
    }
    else if (localMsgTabStoryManager.f())
    {
      if (this.a.h()) {
        this.a.k.a("exp_story", 2);
      }
    }
    else if (this.a.p.a())
    {
      if (this.a.h()) {
        this.a.k.a("exp_story", 5);
      }
    }
    else
    {
      if (localMsgTabStoryManager.g())
      {
        this.a.g();
        localMsgTabStoryManager.h();
        this.a.k.a("exp_hide", 0);
        return;
      }
      this.a.k.a("exp_hide", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.4
 * JD-Core Version:    0.7.0.1
 */