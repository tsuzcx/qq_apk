package com.tencent.luggage.wxa.ks;

import android.view.View;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.kd.b
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
  
  protected View a(com.tencent.luggage.wxa.jx.e parame, JSONObject paramJSONObject)
  {
    a locala = new a(parame.getContext());
    int i = 0;
    locala.setBackgroundColor(0);
    boolean bool1 = paramJSONObject.optBoolean("visible", true);
    boolean bool2 = paramJSONObject.optBoolean("canFullScreenByChild", false);
    int j = g.a(paramJSONObject, "contentOffsetLeft", 0);
    int k = g.a(paramJSONObject, "contentOffsetTop", 0);
    locala.setX(-j);
    locala.setY(-k);
    parame = new e(parame.getContext(), locala);
    if (!bool1) {
      i = 4;
    }
    parame.setVisibility(i);
    parame.setDuplicateParentStateEnabled(true);
    locala.setDuplicateParentStateEnabled(true);
    locala.setFullscreenWithChild(bool2);
    return parame;
  }
  
  protected void a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    paramView.setOnTouchListener(new b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ks.b
 * JD-Core Version:    0.7.0.1
 */