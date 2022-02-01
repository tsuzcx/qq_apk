package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;

public class NearbyMessageSender
  extends BaseMessageSender
{
  public NearbyMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(String paramString)
  {
    if (this.a.p().d().f() != null) {
      this.a.p().d().f().a(paramString);
    }
    super.b();
    ((NearbyContext)this.a).a(paramString);
    if ((this.a != null) && (this.a.O() != null)) {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportNearbyAIOSendMsg(this.b, this.a.O().b, "2");
    }
  }
  
  public void b()
  {
    String str;
    if (this.a.p().d().f() != null) {
      str = this.a.p().d().f().a().toString();
    } else {
      str = null;
    }
    super.b();
    ((NearbyContext)this.a).a(str);
    if ((this.a != null) && (this.a.O() != null)) {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportNearbyAIOSendMsg(this.b, this.a.O().b, "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.NearbyMessageSender
 * JD-Core Version:    0.7.0.1
 */