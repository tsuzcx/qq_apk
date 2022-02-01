package com.tencent.luggage.wxa.kp;

import android.util.Size;
import android.view.View;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONObject;

public class n
  extends com.tencent.luggage.wxa.kd.d
{
  private static final int CTRL_INDEX = 331;
  public static final String NAME = "updateCamera";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("cameraId");
  }
  
  protected boolean a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof b))
    {
      o.c("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((b)paramView).a(View.class);
    if ((paramView != null) && ((paramView instanceof e)))
    {
      paramView = (e)paramView;
      paramInt = paramJSONObject.optInt("cameraId");
      Object localObject = paramJSONObject.optString("devicePosition", "back");
      String str = paramJSONObject.optString("flash", "auto");
      boolean bool = paramJSONObject.optBoolean("needOutput", false);
      paramView.setAppId(parame.getAppId());
      paramView.a((String)localObject, false);
      paramView.setFlash(str);
      paramView.setNeedOutput(bool);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      int i = g.a(localJSONObject, "width", 0);
      int j = g.a(localJSONObject, "height", 0);
      o.e("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(paramInt), localObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      if ((i != 0) && (j != 0)) {
        bool = paramView.a(i, j, false);
      } else {
        bool = false;
      }
      localObject = (d)parame.a(d.class);
      if (localObject != null)
      {
        parame = ((d)localObject).a(parame);
        if ((parame != null) && (parame.length == 2) && (parame[0] > 0) && (parame[1] > 0))
        {
          paramView.setDisplayScreenSize(new Size(parame[0], parame[1]));
          o.d("MicroMsg.JsApiUpdateCamera", "onUpdateView screen width: %d, screen height: %d", new Object[] { Integer.valueOf(parame[0]), Integer.valueOf(parame[1]) });
        }
      }
      parame = paramJSONObject.optString("mode");
      if (!af.c(parame)) {
        paramView.setMode(parame);
      }
      parame = paramJSONObject.optJSONArray("scanArea");
      if ((parame != null) && (parame.length() == 4))
      {
        o.d("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
        paramView.a(g.c(parame.optInt(0)), g.c(parame.optInt(1)), g.c(parame.optInt(2)), g.c(parame.optInt(3)));
      }
      paramView.setScanFreq(paramJSONObject.optInt("scanFreq"));
      if (bool)
      {
        paramView.g();
        paramView.a();
        return true;
      }
      paramView.j();
      return true;
    }
    o.c("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.n
 * JD-Core Version:    0.7.0.1
 */