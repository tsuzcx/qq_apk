package com.tencent.beacon.event.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.c.e;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.qimei.a;
import java.util.HashMap;
import java.util.Map;

public class b
  extends c
  implements d
{
  private boolean b = false;
  private String c;
  
  public b()
  {
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  BeaconEvent a(BeaconEvent paramBeaconEvent)
  {
    if ((this.b) && (!com.tencent.beacon.base.util.b.a(paramBeaconEvent.getCode()))) {
      return paramBeaconEvent;
    }
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    Context localContext = localc.c();
    Map localMap = paramBeaconEvent.getParams();
    Object localObject = a.a().b();
    if ((localObject != null) && (!((Qimei)localObject).isEmpty())) {
      localMap.putAll(((Qimei)localObject).getQimeiMap());
    }
    localMap.put("A143", QimeiSDK.getInstance().getOmgID());
    localMap.put("A144", f.p().y());
    localMap.put("A19", f.p().w());
    localMap.put("QQ", com.tencent.beacon.a.c.b.c());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(com.tencent.beacon.a.c.b.a());
    localMap.put("A95", ((StringBuilder)localObject).toString());
    localMap.put("A141", QimeiSDK.getInstance().getBeaconIdInfo());
    localMap.put("A23", localc.a());
    localMap.put("A48", com.tencent.beacon.a.c.c.d().e());
    String str = paramBeaconEvent.getAppKey();
    EventModule localEventModule = (EventModule)localc.a(ModuleName.EVENT);
    localMap.put("A1", localEventModule.b(str));
    if (paramBeaconEvent.isRealtime()) {
      localObject = "Y";
    } else {
      localObject = "N";
    }
    localMap.put("A99", localObject);
    localMap.put("A72", localc.i());
    localMap.put("A34", String.valueOf(com.tencent.beacon.base.util.b.b()));
    if (!localMap.containsKey("A88"))
    {
      if (TextUtils.isEmpty(this.c)) {
        this.c = com.tencent.beacon.a.c.b.a(localContext);
      }
      localMap.put("A88", this.c);
    }
    localMap.put("A100", e.a(localContext, str).a(paramBeaconEvent.getCode(), paramBeaconEvent.isRealtime()));
    localObject = localEventModule.a(str);
    if (localObject != null) {
      localMap.putAll((Map)localObject);
    }
    paramBeaconEvent.setParams(localMap);
    return paramBeaconEvent;
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    if (paramc.a != 2) {
      return;
    }
    paramc = (HashMap)paramc.b.get("d_m");
    if (paramc != null) {
      this.b = com.tencent.beacon.base.util.b.a((String)paramc.get("tidyEF"), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.b.b
 * JD-Core Version:    0.7.0.1
 */