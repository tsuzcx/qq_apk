package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "TAG", "", "parseFromJson", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "jsonStr", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class r$a
{
  @Nullable
  public final r a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jsonStr");
    try
    {
      Object localObject2 = new JSONObject(paramString);
      Object localObject1 = ((JSONObject)localObject2).optString("mobile");
      String str1 = ((JSONObject)localObject2).optString("show_mobile");
      boolean bool1 = ((JSONObject)localObject2).optBoolean("need_auth", true);
      boolean bool2 = ((JSONObject)localObject2).optBoolean("allow_send_sms", true);
      String str2 = ((JSONObject)localObject2).optString("encryptedData");
      String str3 = ((JSONObject)localObject2).optString("iv");
      boolean bool3 = ((JSONObject)localObject2).optBoolean("is_wechat", false);
      boolean bool4 = ((JSONObject)localObject2).optBoolean("is_check", false);
      localObject2 = ((JSONObject)localObject2).optString("cloud_id", "");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mobile");
      Intrinsics.checkExpressionValueIsNotNull(str1, "showMobile");
      Intrinsics.checkExpressionValueIsNotNull(str2, "encryptedData");
      Intrinsics.checkExpressionValueIsNotNull(str3, "iv");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "cloud_id");
      localObject1 = new r((String)localObject1, str1, str2, str3, (String)localObject2, bool1, bool2, bool3, bool4);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      label164:
      break label164;
    }
    o.b("MicroMsg.PhoneItem", "jsonStr:%s", new Object[] { paramString });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.r.a
 * JD-Core Version:    0.7.0.1
 */