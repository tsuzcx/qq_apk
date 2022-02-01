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
    Object localObject = this.a;
    ((MsgTabStoryNodeConfigManager)localObject).a = paramByte;
    boolean bool = true;
    MsgTabStoryNodeConfigManager.c((MsgTabStoryNodeConfigManager)localObject, true);
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        MsgTabStoryNodeConfigManager.b(this.a);
      }
      localObject = this.a;
      if (paramByte != 2) {
        bool = false;
      }
      ((MsgTabStoryNodeConfigManager)localObject).a(bool);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabStoryOIDBReceived:");
      ((StringBuilder)localObject).append(this.a.c);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    this.a.b = ((Boolean)((StoryConfigManager)localObject).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("commonConfigReceived:");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    MsgTabStoryNodeConfigManager.a(this.a);
    MsgTabStoryNodeConfigManager.a(this.a, true);
    MsgTabStoryNodeConfigManager.a(this.a, true);
    MsgTabStoryNodeConfigManager.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    Object localObject;
    if (!MsgTabStoryNodeConfigManager.a(this.a))
    {
      if (paramBoolean)
      {
        localObject = this.a;
        ((MsgTabStoryNodeConfigManager)localObject).c = ((MsgTabStoryNodeConfigManager)localObject).a();
        MsgTabStoryNodeConfigManager.a(this.a);
        MsgTabStoryNodeConfigManager.a(this.a, true);
      }
      MsgTabStoryNodeConfigManager.b(this.a, true);
      MsgTabStoryNodeConfigManager.b(this.a);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabStoryDPCCfgHasContentReceived:");
      ((StringBuilder)localObject).append(this.a.c);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.2
 * JD-Core Version:    0.7.0.1
 */