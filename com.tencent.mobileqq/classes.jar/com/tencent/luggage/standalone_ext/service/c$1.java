package com.tencent.luggage.standalone_ext.service;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.of.b.a;
import org.json.JSONException;
import org.json.JSONObject;

final class c$1
  implements b.a
{
  public void a(@NonNull d paramd, @NonNull JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("notSupport", false);
      paramJSONObject.put("switchWebsocket", false);
      paramJSONObject.put("switchFs", true);
      return;
    }
    catch (JSONException paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.c.1
 * JD-Core Version:    0.7.0.1
 */