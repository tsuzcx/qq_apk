package com.tencent.mm.opensdk.channel;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class MMessageActV2
{
  public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
  public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
  public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
  private static final String TAG = "MicroMsg.SDK.MMessageAct";
  
  public static boolean send(Context paramContext, MMessageActV2.Args paramArgs)
  {
    if ((paramContext != null) && (paramArgs != null)) {
      if (b.b(paramArgs.targetPkgName))
      {
        paramContext = new StringBuilder();
        paramContext.append("send fail, invalid targetPkgName, targetPkgName = ");
        paramContext.append(paramArgs.targetPkgName);
        paramContext = paramContext.toString();
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.SDK.MMessageAct", paramContext);
      return false;
      if (b.b(paramArgs.targetClassName))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramArgs.targetPkgName);
        ((StringBuilder)localObject1).append(".wxapi.WXEntryActivity");
        paramArgs.targetClassName = ((StringBuilder)localObject1).toString();
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send, targetPkgName = ");
      ((StringBuilder)localObject1).append(paramArgs.targetPkgName);
      ((StringBuilder)localObject1).append(", targetClassName = ");
      ((StringBuilder)localObject1).append(paramArgs.targetClassName);
      ((StringBuilder)localObject1).append(", launchMode = ");
      ((StringBuilder)localObject1).append(paramArgs.launchMode);
      Log.d("MicroMsg.SDK.MMessageAct", ((StringBuilder)localObject1).toString());
      localObject1 = new Intent();
      ((Intent)localObject1).setClassName(paramArgs.targetPkgName, paramArgs.targetClassName);
      Object localObject2 = paramArgs.bundle;
      if (localObject2 != null) {
        ((Intent)localObject1).putExtras((Bundle)localObject2);
      }
      localObject2 = paramContext.getPackageName();
      ((Intent)localObject1).putExtra("_mmessage_sdkVersion", 637992960);
      ((Intent)localObject1).putExtra("_mmessage_appPackage", (String)localObject2);
      ((Intent)localObject1).putExtra("_mmessage_content", paramArgs.content);
      ((Intent)localObject1).putExtra("_mmessage_checksum", a.a(paramArgs.content, 637992960, (String)localObject2));
      ((Intent)localObject1).putExtra("_message_token", paramArgs.token);
      int i = paramArgs.flags;
      if (i == -1) {
        ((Intent)localObject1).addFlags(268435456).addFlags(134217728);
      } else {
        ((Intent)localObject1).setFlags(i);
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 29) && (paramArgs.launchMode == 2)) {
          sendUsingPendingIntent(paramContext, (Intent)localObject1);
        } else {
          paramContext.startActivity((Intent)localObject1);
        }
        paramContext = new StringBuilder();
        paramContext.append("send mm message, intent=");
        paramContext.append(localObject1);
        Log.d("MicroMsg.SDK.MMessageAct", paramContext.toString());
        return true;
      }
      catch (Exception paramContext)
      {
        paramArgs = new StringBuilder();
        paramArgs.append("send fail, ex = ");
        paramArgs.append(paramContext.getMessage());
        paramContext = paramArgs.toString();
      }
      continue;
      paramContext = "send fail, invalid argument";
    }
  }
  
  private static void sendUsingPendingIntent(Context paramContext, Intent paramIntent)
  {
    try
    {
      Log.i("MicroMsg.SDK.MMessageAct", "sendUsingPendingIntent");
      PendingIntent.getActivity(paramContext, 3, paramIntent, 134217728).send(paramContext, 4, null, new MMessageActV2.1(), null);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendUsingPendingIntent fail, ex = ");
      localStringBuilder.append(localException.getMessage());
      Log.e("MicroMsg.SDK.MMessageAct", localStringBuilder.toString());
      paramContext.startActivity(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2
 * JD-Core Version:    0.7.0.1
 */