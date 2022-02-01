package com.tencent.luggage.wxa.lq;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class b$1
  implements Runnable
{
  b$1(b paramb, h paramh, u paramu, String paramString, JSONObject paramJSONObject, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    this.b.ab().a(ak.b);
    Activity localActivity = this.a.G();
    int i = 0;
    MMBottomSheet localMMBottomSheet = new MMBottomSheet(localActivity, 1, false);
    if (!af.c(this.c)) {
      b.a(this.g, localActivity, localMMBottomSheet, this.c);
    }
    JSONArray localJSONArray = this.d.optJSONArray("newTipsList");
    HashMap localHashMap = new HashMap();
    if (localJSONArray != null) {
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localHashMap.put(Integer.valueOf(localJSONObject.optInt("index", -1)), Integer.valueOf(localJSONObject.optInt("type", -1)));
        }
        i += 1;
      }
    }
    if (k.a.a()) {
      i = g.a(this.d.optString("itemColorDark", ""), localActivity.getResources().getColor(2131166595));
    } else {
      i = g.a(this.d.optString("itemColor", ""), localActivity.getResources().getColor(2131166595));
    }
    localMMBottomSheet.setOnCreateMenuListener(new b.1.1(this, localMMBottomSheet, localHashMap, i));
    localMMBottomSheet.setOnMenuSelectedListener(new b.1.2(this, localHashMap));
    localMMBottomSheet.setOnBottomSheetDismissListener(new b.1.3(this));
    localMMBottomSheet.tryShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.b.1
 * JD-Core Version:    0.7.0.1
 */