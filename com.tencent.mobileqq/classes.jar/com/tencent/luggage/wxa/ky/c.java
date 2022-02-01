package com.tencent.luggage.wxa.ky;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.rtmp.TXLiveBase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 364;
  public static final String NAME = "insertLivePlayer";
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!(paramc.getContext() instanceof Activity))
    {
      o.c("MicroMsg.JsApiInsertLivePlayer", "invokeAfterRequestPermission pageContext not activity");
      paramc.a(paramInt, b("fail"));
      return;
    }
    Activity localActivity = (Activity)paramc.getContext();
    try
    {
      int i = ContextCompat.checkSelfPermission(localActivity, "android.permission.RECORD_AUDIO");
      if (i == 0)
      {
        super.a(paramc, paramJSONObject, paramInt);
        return;
      }
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:system permission denied", paramJSONObject));
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.JsApiInsertLivePlayer", "check mpermission exception:%s.", new Object[] { paramJSONObject });
      paramc.a(paramInt, b("fail"));
    }
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("livePlayerId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = new a(parame.getContext());
    parame = new com.tencent.luggage.wxa.kt.b(parame.getContext(), paramJSONObject);
    parame.setBackgroundColor(-16777216);
    return parame;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    
    if (paramJSONObject.optInt("mode", 0) == 2)
    {
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    super.a(paramc, paramJSONObject, paramInt);
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiInsertLivePlayer", "onInsertView livePlayerId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiInsertLivePlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    a locala = (a)((com.tencent.luggage.wxa.kt.b)paramView).a(a.class);
    c.1 local1 = new c.1(this, locala);
    c.2 local2 = new c.2(this, locala);
    c.3 local3 = new c.3(this, parame, locala);
    c.4 local4 = new c.4(this, locala, parame);
    parame.a(local2);
    parame.a(local3);
    parame.a(local4);
    locala.a(new c.5(this, parame, h(paramJSONObject), paramInt, local1));
    locala.a(new c.6(this, parame, local3, local2));
    locala.a(paramJSONObject.optBoolean("needEvent", false));
    locala.a(new c.7(this, paramInt, parame));
    paramJSONObject = m.a(paramJSONObject);
    locala.a(paramJSONObject);
    locala.a(new c.8(this, paramInt, parame));
    locala.a(new c.9(this, paramInt, parame));
    if (paramJSONObject.getInt("mode", 0) == 5)
    {
      parame = paramView.getContext();
      paramInt = 2131886749;
    }
    else
    {
      parame = paramView.getContext();
      paramInt = 2131886748;
    }
    locala.setContentDescription(parame.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.c
 * JD-Core Version:    0.7.0.1
 */