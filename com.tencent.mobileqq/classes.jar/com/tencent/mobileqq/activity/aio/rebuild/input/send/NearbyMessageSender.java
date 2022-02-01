package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;

public class NearbyMessageSender
  extends BaseMessageSender
{
  public NearbyMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(String paramString)
  {
    if (this.a.a().a().a() != null) {
      this.a.a().a().a().a(paramString);
    }
    super.b();
    ((NearbyContext)this.a).a(paramString);
  }
  
  public void b()
  {
    String str;
    if (this.a.a().a().a() != null) {
      str = this.a.a().a().a().a().toString();
    } else {
      str = null;
    }
    super.b();
    ((NearbyContext)this.a).a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.NearbyMessageSender
 * JD-Core Version:    0.7.0.1
 */