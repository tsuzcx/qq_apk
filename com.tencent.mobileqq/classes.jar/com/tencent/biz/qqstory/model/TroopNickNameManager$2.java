package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.app.TroopManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class TroopNickNameManager$2
  implements Runnable
{
  TroopNickNameManager$2(TroopNickNameManager paramTroopNickNameManager, String paramString, QQUserUIItem paramQQUserUIItem, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.this$0.e.h(this.a, this.b.qq) != null)
    {
      TroopNickNameManager.TroopNickNameUpdateEvent localTroopNickNameUpdateEvent = new TroopNickNameManager.TroopNickNameUpdateEvent();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b.qq);
      localTroopNickNameUpdateEvent.a = localArrayList;
      localTroopNickNameUpdateEvent.b = this.a;
      StoryDispatcher.a().dispatch(localTroopNickNameUpdateEvent);
      return;
    }
    if (!this.c) {
      this.this$0.a(this.b, this.a, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.2
 * JD-Core Version:    0.7.0.1
 */