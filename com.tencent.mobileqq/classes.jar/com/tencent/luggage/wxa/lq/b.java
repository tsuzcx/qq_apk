package com.tencent.luggage.wxa.lq;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.luggage.wxa.jx.a<h>
{
  private static final int CTRL_INDEX = 107;
  private static final String NAME = "showActionSheet";
  private static b.a a;
  
  private void a(@NonNull Context paramContext, @NonNull MMBottomSheet paramMMBottomSheet, @NonNull String paramString)
  {
    o.e("MicroMsg.JsApiShowActionSheet", "addAlertHeaderView");
    TextView localTextView = new TextView(paramContext);
    localTextView.setHeight(com.tencent.luggage.wxa.qx.a.d(paramContext, 2131296349));
    localTextView.setGravity(17);
    localTextView.setTextColor(paramContext.getResources().getColor(2131165951));
    localTextView.setTextSize(0, com.tencent.luggage.wxa.qx.a.d(paramContext, 2131296302));
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    int i = com.tencent.luggage.wxa.qx.a.e(paramContext, 18);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setText(paramString);
    paramMMBottomSheet.setTitleView(localTextView);
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    u localu = paramh.v();
    if (localu == null)
    {
      o.c("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
      paramh.a(paramInt, b("fail"));
      return;
    }
    String str = c.a(paramJSONObject, "alertText");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("invoke, alertText: ");
    ((StringBuilder)localObject1).append(str);
    o.d("MicroMsg.JsApiShowActionSheet", ((StringBuilder)localObject1).toString());
    Object localObject2 = paramJSONObject.optString("itemList");
    localObject1 = new ArrayList();
    try
    {
      localObject2 = new JSONArray((String)localObject2);
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        ((ArrayList)localObject1).add((String)((JSONArray)localObject2).get(i));
        i += 1;
      }
      paramh.a(new b.1(this, paramh, localu, str, paramJSONObject, (ArrayList)localObject1, paramInt));
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.JsApiShowActionSheet", paramJSONObject.getMessage());
      paramh.a(paramInt, b("fail"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.b
 * JD-Core Version:    0.7.0.1
 */