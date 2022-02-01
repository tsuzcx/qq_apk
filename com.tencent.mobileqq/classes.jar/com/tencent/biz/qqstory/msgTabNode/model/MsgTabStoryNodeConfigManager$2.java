package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;

class MsgTabStoryNodeConfigManager$2
  extends QQStoryObserver
{
  MsgTabStoryNodeConfigManager$2(MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    MsgTabStoryNodeConfigManager.c(this.a, true);
    MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        MsgTabStoryNodeConfigManager.b(this.a);
      }
      localMsgTabStoryNodeConfigManager = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localMsgTabStoryNodeConfigManager.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryOIDBReceived:" + this.a.c);
      }
      return;
      label88:
      bool = false;
    }
  }
  
  public void b()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    this.a.b = ((Boolean)localStoryConfigManager.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    MsgTabStoryNodeConfigManager.a(this.a);
    MsgTabStoryNodeConfigManager.a(this.a, true);
    MsgTabStoryNodeConfigManager.a(this.a, true);
    MsgTabStoryNodeConfigManager.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!MsgTabStoryNodeConfigManager.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        MsgTabStoryNodeConfigManager.a(this.a);
        MsgTabStoryNodeConfigManager.a(this.a, true);
      }
      MsgTabStoryNodeConfigManager.b(this.a, true);
      MsgTabStoryNodeConfigManager.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.2
 * JD-Core Version:    0.7.0.1
 */