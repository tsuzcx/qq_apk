package com.tencent.luggage.wxa.lh;

import android.os.Bundle;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends ah
{
  private static final int CTRL_INDEX = 355;
  private static final String NAME = "onHCEMessage";
  private static final a a = new a();
  
  static void a(c paramc, int paramInt, Bundle paramBundle)
  {
    try
    {
      o.d("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", new Object[] { paramc.getAppId(), Integer.valueOf(paramInt) });
      HashMap localHashMap;
      if (paramInt == 31)
      {
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getString("key_apdu_command");
          localHashMap = new HashMap();
          localHashMap.put("messageType", Integer.valueOf(1));
          localHashMap.put("data", paramBundle);
          a.b(paramc).b(localHashMap).a();
        }
      }
      else if ((paramInt == 41) && (paramBundle != null))
      {
        localHashMap = new HashMap();
        localHashMap.put("messageType", Integer.valueOf(2));
        localHashMap.put("reason", Integer.valueOf(paramBundle.getInt("key_on_deactivated_reason")));
        a.b(paramc).b(localHashMap).a();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.a
 * JD-Core Version:    0.7.0.1
 */