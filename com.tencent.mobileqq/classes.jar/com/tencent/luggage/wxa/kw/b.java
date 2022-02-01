package com.tencent.luggage.wxa.kw;

import android.os.Looper;
import android.widget.EditText;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pp.ab;
import com.tencent.luggage.wxa.pp.o;
import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.wxa.jx.u<com.tencent.mm.plugin.appbrand.page.u>
{
  private static final int CTRL_INDEX = 583;
  private static final String NAME = "getSelectedTextRange";
  
  @MainThread
  @Nullable
  private int[] a(com.tencent.mm.plugin.appbrand.page.u paramu)
  {
    paramu = o.c(paramu);
    if (paramu == null) {
      return null;
    }
    return new int[] { paramu.f().getSelectionStart(), paramu.f().getSelectionEnd() };
  }
  
  public String a(com.tencent.mm.plugin.appbrand.page.u paramu, JSONObject paramJSONObject)
  {
    paramu = (int[])new b.1(this, paramu).a(new s(Looper.getMainLooper()));
    if (paramu == null) {
      return b("fail:no focused input");
    }
    paramJSONObject = new HashMap(2);
    paramJSONObject.put("start", Integer.valueOf(paramu[0]));
    paramJSONObject.put("end", Integer.valueOf(paramu[1]));
    return a("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.b
 * JD-Core Version:    0.7.0.1
 */