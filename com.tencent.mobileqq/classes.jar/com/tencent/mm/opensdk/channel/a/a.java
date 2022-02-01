package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a
{
  public static boolean a(Context paramContext, a.a parama)
  {
    if (paramContext == null) {}
    for (paramContext = "send fail, invalid argument";; paramContext = "send fail, action is null")
    {
      Log.e("MicroMsg.SDK.MMessage", paramContext);
      return false;
      if (!d.b(parama.action)) {
        break;
      }
    }
    Object localObject = null;
    if (!d.b(parama.a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(parama.a);
      ((StringBuilder)localObject).append(".permission.MM_MESSAGE");
      localObject = ((StringBuilder)localObject).toString();
    }
    Intent localIntent = new Intent(parama.action);
    if (parama.bundle != null) {
      localIntent.putExtras(parama.bundle);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 621086464);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", parama.content);
    localIntent.putExtra("_mmessage_support_content_type", parama.b);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.content, 621086464, str));
    paramContext.sendBroadcast(localIntent, (String)localObject);
    paramContext = new StringBuilder("send mm message, intent=");
    paramContext.append(localIntent);
    paramContext.append(", perm=");
    paramContext.append((String)localObject);
    Log.d("MicroMsg.SDK.MMessage", paramContext.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.a
 * JD-Core Version:    0.7.0.1
 */