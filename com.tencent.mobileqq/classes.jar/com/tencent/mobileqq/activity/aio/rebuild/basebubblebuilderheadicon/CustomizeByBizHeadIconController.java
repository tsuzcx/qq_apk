package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class CustomizeByBizHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean k()
  {
    return ((ITempChatPluginManager)this.b.getRuntimeService(ITempChatPluginManager.class, "")).isCustomizeByBiz(this.a.istroop);
  }
  
  protected void b()
  {
    Object localObject = ((ITempChatPluginManager)this.b.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(this.a.istroop);
    if (localObject != null) {
      localObject = ((AbstractTempChatPlugin)localObject).a(this.a.senderuin, TempChatSource.SOURCE_FROM_AIO);
    } else {
      localObject = null;
    }
    b(localObject);
  }
  
  protected void c()
  {
    a(this.h);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    return k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.CustomizeByBizHeadIconController
 * JD-Core Version:    0.7.0.1
 */