package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2
{
  public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
  public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
  public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
  private static final String TAG = "MicroMsg.SDK.MMessageAct";
  
  public static boolean send(Context paramContext, MMessageActV2.Args paramArgs)
  {
    if ((paramContext != null) && (paramArgs != null)) {
      if (d.b(paramArgs.targetPkgName))
      {
        paramContext = new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ");
        paramContext.append(paramArgs.targetPkgName);
        paramContext = paramContext.toString();
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.MMessageAct", paramContext);
      return false;
      if (d.b(paramArgs.targetClassName))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramArgs.targetPkgName);
        ((StringBuilder)localObject).append(".wxapi.WXEntryActivity");
        paramArgs.targetClassName = ((StringBuilder)localObject).toString();
      }
      Object localObject = new StringBuilder("send, targetPkgName = ");
      ((StringBuilder)localObject).append(paramArgs.targetPkgName);
      ((StringBuilder)localObject).append(", targetClassName = ");
      ((StringBuilder)localObject).append(paramArgs.targetClassName);
      Log.d("MicroMsg.SDK.MMessageAct", ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).setClassName(paramArgs.targetPkgName, paramArgs.targetClassName);
      if (paramArgs.bundle != null) {
        ((Intent)localObject).putExtras(paramArgs.bundle);
      }
      String str = paramContext.getPackageName();
      ((Intent)localObject).putExtra("_mmessage_sdkVersion", 621086464);
      ((Intent)localObject).putExtra("_mmessage_appPackage", str);
      ((Intent)localObject).putExtra("_mmessage_content", paramArgs.content);
      ((Intent)localObject).putExtra("_mmessage_checksum", b.a(paramArgs.content, 621086464, str));
      ((Intent)localObject).putExtra("_message_token", paramArgs.token);
      if (paramArgs.flags == -1) {
        ((Intent)localObject).addFlags(268435456).addFlags(134217728);
      } else {
        ((Intent)localObject).setFlags(paramArgs.flags);
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        paramContext = new StringBuilder("send mm message, intent=");
        paramContext.append(localObject);
        Log.d("MicroMsg.SDK.MMessageAct", paramContext.toString());
        return true;
      }
      catch (Exception paramContext)
      {
        paramArgs = new StringBuilder("send fail, ex = ");
        paramArgs.append(paramContext.getMessage());
        paramContext = paramArgs.toString();
      }
      continue;
      paramContext = "send fail, invalid argument";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2
 * JD-Core Version:    0.7.0.1
 */