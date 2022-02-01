package com.tencent.mobileqq.activity.aio.rebuild.input.clearinput;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IClearInputCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;

public class RichMediaClearInputCallback
  implements IClearInputCallback
{
  public void a(AIOContext paramAIOContext)
  {
    paramAIOContext = (PhotoListPanel)paramAIOContext.a().b(4);
    if (paramAIOContext != null) {
      paramAIOContext.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.RichMediaClearInputCallback
 * JD-Core Version:    0.7.0.1
 */