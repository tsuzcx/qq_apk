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
    this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager = paramPluginManagerClient;
    paramPluginManagerClient = this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.queryPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b);
    int i;
    if (paramPluginManagerClient != null) {
      if (paramPluginManagerClient.mState == 4)
      {
        i = 1;
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.launchPlugin(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.c, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.a);
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.openLinkInNewWebView(this.jdField_a_of_type_AndroidAppActivity, this.b, this.d);
      }
      return;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, null, null);
      this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager.mPluginManager.installPlugin(this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$BidInfo.b);
      i = 0;
      continue;
      PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.b, this.jdField_a_of_type_ComTencentBizTrooppluginPluginJumpManager$UrlMappingInfo.b, null, null);
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopplugin.PluginJumpManager.2
 * JD-Core Version:    0.7.0.1
 */