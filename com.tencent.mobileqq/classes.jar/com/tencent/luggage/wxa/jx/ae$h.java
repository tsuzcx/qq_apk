package com.tencent.luggage.wxa.jx;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jj.s;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroidx/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ae$h
  implements Function<List<? extends s>, Boolean>
{
  private boolean e;
  
  ae$h(WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  @NotNull
  public Boolean a(@NotNull List<s> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "input");
    boolean bool2 = this.e;
    boolean bool1 = true;
    if (!bool2) {}
    try
    {
      b localb = (b)this.b.get();
      if (localb == null) {
        break label133;
      }
      int i = this.c;
      ae localae = this.a;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("contactList", ae.c().a(paramList));
      localJSONObject.put("callbackId", this.d);
      localb.a(i, localae.a("ok", localJSONObject));
    }
    catch (JSONException paramList)
    {
      label101:
      break label101;
    }
    paramList = (b)this.b.get();
    if (paramList != null) {
      paramList.a(this.c, this.a.b("fail: toJson fail"));
    }
    label133:
    this.e = true;
    break label143;
    bool1 = false;
    label143:
    return Boolean.valueOf(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.h
 * JD-Core Version:    0.7.0.1
 */