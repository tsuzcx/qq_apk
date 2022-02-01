package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanelManager$2
  implements Runnable
{
  ApolloPanelManager$2(ApolloPanelManager paramApolloPanelManager) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    int i = ((ApolloPanelManager)localObject).c.get();
    boolean bool;
    if (this.this$0.g != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((ApolloPanelManager)localObject).a(i, bool, ApolloPanelManager.a(this.this$0));
    if ((this.this$0.c.get() == 0) && (!ApolloPanelManager.a(this.this$0)) && (this.this$0.a() != null) && (this.this$0.g != null))
    {
      localObject = ((SpriteScriptManagerImpl)this.this$0.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteActionMessage();
      if (localObject != null) {
        ((SpriteActionMessage)localObject).a(this.this$0.e);
      }
    }
    if (((ApolloPanelManager.a(this.this$0)) || (this.this$0.c.get() > 0)) && (this.this$0.g != null))
    {
      localObject = this.this$0;
      ApolloPanelManager.a((ApolloPanelManager)localObject, ((ApolloPanelManager)localObject).g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager.2
 * JD-Core Version:    0.7.0.1
 */