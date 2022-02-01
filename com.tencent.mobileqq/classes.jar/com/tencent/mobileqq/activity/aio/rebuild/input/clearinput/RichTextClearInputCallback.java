package com.tencent.mobileqq.activity.aio.rebuild.input.clearinput;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IClearInputCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;

public class RichTextClearInputCallback
  implements IClearInputCallback
{
  public void a(AIOContext paramAIOContext)
  {
    if (paramAIOContext.q().b() == 28) {
      paramAIOContext.q().a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.RichTextClearInputCallback
 * JD-Core Version:    0.7.0.1
 */