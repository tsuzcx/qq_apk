package com.tencent.biz.troopplugin;

import android.app.Activity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;

class PluginJumpManager$2
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  PluginJumpManager$2(PluginJumpManager paramPluginJumpManager, PluginJumpManager.BidInfo paramBidInfo, Activity paramActivity, String paramString1, String paramString2, String paramString3, long paramLong, PluginJumpManager.UrlMappingInfo paramUrlMappingInfo, String paramString4) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    PluginJumpManager localPluginJumpManager = this.i;
    localPluginJumpManager.mPluginManager = paramPluginManagerClient;
    paramPluginManagerClient = localPluginJumpManager.mPluginManager.queryPlugin(this.a.b);
    if (paramPluginManagerClient != null)
    {
      if (paramPluginManagerClient.mState == 4)
      {
        j = 1;
        this.i.launchPlugin(this.b, this.a.b, this.a.c, this.c, this.d, this.e, this.f, this.g.b, this.g.d);
        break label165;
      }
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.d, this.g.b, null, null);
      this.i.mPluginManager.installPlugin(this.a.b);
    }
    else
    {
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.d, this.g.b, null, null);
    }
    int j = 0;
    label165:
    if (j == 0) {
      this.i.openLinkInNewWebView(this.b, this.d, this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopplugin.PluginJumpManager.2
 * JD-Core Version:    0.7.0.1
 */