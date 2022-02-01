package com.tencent.comic;

import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class VipComicProxyActivity
  extends PluginProxyFragmentActivity
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (paramString.equals("com.qqcomic.activity.media.VipComicMediaPlayActivity")) {
      return VipComicPlayProxyActivity.class;
    }
    if (paramString.equals("com.qqcomic.preread.VipComicPreReadActivity")) {
      return VipComicPreReadProxyActivity.class;
    }
    return VipComicProxyActivity.class;
  }
  
  public String getPluginID()
  {
    return "comic_plugin.apk";
  }
  
  protected int getPluginResType()
  {
    return 2;
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return a(paramString);
  }
  
  protected int getThemeResId()
  {
    return 0;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicProxyActivity
 * JD-Core Version:    0.7.0.1
 */