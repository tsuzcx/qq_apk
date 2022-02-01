package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.falco.utils.SPUtil;
import com.tencent.ilive.interfaces.IAudienceRoomPager;

public class NormalJavascriptInterface
{
  public static final String KEY_SCROLL_FORBIDDEN = "scrollForbidden";
  private static final String SP_SCROLL_FORBIDDEN_NAME = "nowlive_config";
  public static final String TAG = "App";
  private static final int TYPE_TOPIC_LIVE_ROOM = 5;
  private static boolean isLandscape = false;
  private static boolean isNetWorkClose = false;
  private boolean ignoreScrollForbidden = false;
  private IAudienceRoomPager mAudienceRoomPager;
  private int mContentType;
  private Context mContext;
  
  public NormalJavascriptInterface(Context paramContext, IAudienceRoomPager paramIAudienceRoomPager, int paramInt)
  {
    this.mContext = paramContext;
    this.mAudienceRoomPager = paramIAudienceRoomPager;
    this.mContentType = paramInt;
  }
  
  public static void setLandscape(boolean paramBoolean)
  {
    isLandscape = paramBoolean;
  }
  
  public static void setNetWork(boolean paramBoolean)
  {
    isNetWorkClose = paramBoolean;
  }
  
  @JavascriptInterface
  public void beginDraw()
  {
    IAudienceRoomPager localIAudienceRoomPager = this.mAudienceRoomPager;
    if (localIAudienceRoomPager == null) {
      return;
    }
    if (!this.ignoreScrollForbidden)
    {
      localIAudienceRoomPager.setScrollForbidden(true);
      saveForbiddenSPValue(true);
    }
  }
  
  @JavascriptInterface
  public void endDraw()
  {
    IAudienceRoomPager localIAudienceRoomPager = this.mAudienceRoomPager;
    if (localIAudienceRoomPager == null) {
      return;
    }
    if (!isLandscape)
    {
      if (isNetWorkClose) {
        return;
      }
      if (this.mContentType == 5) {
        return;
      }
      localIAudienceRoomPager.setScrollForbidden(false);
      saveForbiddenSPValue(false);
    }
  }
  
  public boolean getForbiddenSPValue()
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      return SPUtil.get(localContext, "nowlive_config").getBoolean("scrollForbidden", false);
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.mContext = null;
    this.mAudienceRoomPager = null;
  }
  
  public void saveForbiddenSPValue(boolean paramBoolean)
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      SPUtil.get(localContext, "nowlive_config").putBoolean("scrollForbidden", paramBoolean);
    }
  }
  
  public void setIgnoreScrollForbidden(boolean paramBoolean)
  {
    this.ignoreScrollForbidden = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.NormalJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */