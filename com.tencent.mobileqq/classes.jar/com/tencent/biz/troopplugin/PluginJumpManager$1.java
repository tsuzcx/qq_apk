package com.tencent.biz.troopplugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;

class PluginJumpManager$1
  implements AsyncBack
{
  PluginJumpManager$1(PluginJumpManager paramPluginJumpManager) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      HtmlOffline.a("urlplugin.cfg", this.a.mContext, "1007", new PluginJumpManager.1.1(this));
      return;
    }
    if (TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      this.a.loadConfigFromFile();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopplugin.PluginJumpManager.1
 * JD-Core Version:    0.7.0.1
 */