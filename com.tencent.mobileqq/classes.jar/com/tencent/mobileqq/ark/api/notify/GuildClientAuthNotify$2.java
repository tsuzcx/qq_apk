package com.tencent.mobileqq.ark.api.notify;

import com.tencent.ark.ark;
import org.json.JSONObject;

final class GuildClientAuthNotify$2
  implements Runnable
{
  GuildClientAuthNotify$2(String paramString, JSONObject paramJSONObject) {}
  
  public void run()
  {
    ark.arkNotify(this.a, "gpro_bind_app_callback", this.b.toString(), "json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify.2
 * JD-Core Version:    0.7.0.1
 */