package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class SpriteActionMessage$2
  implements Runnable
{
  SpriteActionMessage$2(SpriteActionMessage paramSpriteActionMessage, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (SpriteActionMessage.a(this.this$0) != null)
    {
      if (SpriteActionMessage.a(this.this$0).a() == null) {
        return;
      }
      ApolloPanelManager localApolloPanelManager = ((ApolloManagerServiceImpl)SpriteActionMessage.a(this.this$0).a().getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
      if (localApolloPanelManager == null) {
        return;
      }
      localApolloPanelManager.a.set(this.jdField_a_of_type_Int);
      localApolloPanelManager.a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage.2
 * JD-Core Version:    0.7.0.1
 */