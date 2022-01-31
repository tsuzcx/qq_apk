package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2
{
  public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
  public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
  public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
  private static final String TAG = "MicroMsg.SDK.MMessageAct";
  
  public static boolean send(Context paramContext, Args paramArgs)
  {
    if ((paramContext == null) || (paramArgs == null))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return false;
    }
    if (d.h(paramArgs.targetPkgName))
    {
      Log.e("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + paramArgs.targetPkgName);
      return false;
    }
    if (d.h(paramArgs.targetClassName)) {
      paramArgs.targetClassName = (paramArgs.targetPkgName + ".wxapi.WXEntryActivity");
    }
    Log.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + paramArgs.targetPkgName + ", targetClassName = " + paramArgs.targetClassName);
    Intent localIntent = new Intent();
    localIntent.setClassName(paramArgs.targetPkgName, paramArgs.targetClassName);
    if (paramArgs.bundle != null) {
      localIntent.putExtras(paramArgs.bundle);
    }
    String str = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 620823552);
    localIntent.putExtra("_mmessage_appPackage", str);
    localIntent.putExtra("_mmessage_content", paramArgs.content);
    localIntent.putExtra("_mmessage_checksum", b.a(paramArgs.content, 620823552, str));
    if (paramArgs.flags == -1) {
      localIntent.addFlags(268435456).addFlags(134217728);
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        Log.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.SDK.MMessageAct", "send fail, ex = " + paramContext.getMessage());
      }
      localIntent.setFlags(paramArgs.flags);
    }
    return false;
  }
  
  public static class Args
  {
    public static final int INVALID_FLAGS = -1;
    public Bundle bundle;
    public String content;
    public int flags = -1;
    public String targetClassName;
    public String targetPkgName;
    
    public String toString()
    {
      return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2
 * JD-Core Version:    0.7.0.1
 */