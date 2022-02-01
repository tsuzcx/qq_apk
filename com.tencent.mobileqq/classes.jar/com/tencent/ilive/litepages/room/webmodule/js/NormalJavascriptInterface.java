package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.falco.utils.SPUtil;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
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
    if (this.mAudienceRoomPager == null) {}
    AudienceRoomViewPager localAudienceRoomViewPager;
    do
    {
      return;
      localAudienceRoomViewPager = (AudienceRoomViewPager)this.mAudienceRoomPager.getViewPager();
    } while (this.ignoreScrollForbidden);
    localAudienceRoomViewPager.setScrollForbidden(true);
    saveForbiddenSPValue(true);
  }
  
  @JavascriptInterface
  public void endDraw()
  {
    if (this.mAudienceRoomPager == null) {}
    while ((isLandscape) || (isNetWorkClose) || (this.mContentType == 5)) {
      return;
    }
    ((AudienceRoomViewPager)this.mAudienceRoomPager.getViewPager()).setScrollForbidden(false);
    saveForbiddenSPValue(false);
  }
  
  public boolean getForbiddenSPValue()
  {
    boolean bool = false;
    if (this.mContext != null) {
      bool = SPUtil.get(this.mContext, "nowlive_config").getBoolean("scrollForbidden", false);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.mContext = null;
    this.mAudienceRoomPager = null;
  }
  
  public void saveForbiddenSPValue(boolean paramBoolean)
  {
    if (this.mContext != null) {
      SPUtil.get(this.mContext, "nowlive_config").putBoolean("scrollForbidden", paramBoolean);
    }
  }
  
  public void setIgnoreScrollForbidden(boolean paramBoolean)
  {
    this.ignoreScrollForbidden = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.NormalJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */