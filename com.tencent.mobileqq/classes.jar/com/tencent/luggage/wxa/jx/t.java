package com.tencent.luggage.wxa.jx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;

public class t
  extends n
{
  private static final int CTRL_INDEX = 494;
  private static final String NAME = "onViewDidResize";
  
  public void a(@NonNull u paramu, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, e.b paramb, @Nullable Map<String, Object> paramMap)
  {
    HashMap localHashMap1 = new HashMap(10);
    localHashMap1.put("windowWidth", Integer.valueOf(g.a(paramInt2)));
    localHashMap1.put("windowHeight", Integer.valueOf(g.a(paramInt3)));
    localHashMap1.put("screenWidth", Integer.valueOf(g.a(paramInt4)));
    localHashMap1.put("screenHeight", Integer.valueOf(g.a(paramInt5)));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("size", localHashMap1);
    localHashMap2.put("changedWebviewIds", new int[] { paramInt1 });
    if (ArrayUtils.contains(e.b.h, paramb)) {
      localHashMap2.put("deviceOrientation", "landscape");
    } else if (e.b.a == paramb) {
      localHashMap2.put("deviceOrientation", "portrait");
    }
    if (paramMap != null) {
      localHashMap2.put("pageOrientation", new HashMap(paramMap));
    }
    paramb = h.a(localHashMap2).toString();
    o.d("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", new Object[] { d(), paramu.getAppId(), paramu.an(), paramb });
    a(paramb).a(paramu, paramu.getComponentId()).a();
    a(paramb).a(paramu.p(), paramu.getComponentId()).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.t
 * JD-Core Version:    0.7.0.1
 */