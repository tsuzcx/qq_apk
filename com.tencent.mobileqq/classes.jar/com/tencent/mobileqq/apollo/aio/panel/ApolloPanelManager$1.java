package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanelManager$1
  implements Runnable
{
  ApolloPanelManager$1(ApolloPanelManager paramApolloPanelManager, ApolloInfo paramApolloInfo) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((ApolloPanelManager)localObject).a(((ApolloPanelManager)localObject).a.get(), true, ApolloPanelManager.a(this.this$0));
    if ((this.this$0.a.get() == 0) && (!ApolloPanelManager.a(this.this$0)) && (this.this$0.a() != null))
    {
      localObject = ((SpriteScriptManagerImpl)this.this$0.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteActionMessage();
      if (localObject != null) {
        ((SpriteActionMessage)localObject).a(this.this$0.b);
      }
    }
    if ((ApolloPanelManager.a(this.this$0)) || (this.this$0.a.get() > 0)) {
      ApolloPanelManager.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager.1
 * JD-Core Version:    0.7.0.1
 */