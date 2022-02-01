package com.tencent.comic.api;

import android.content.Context;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQQComicConfigApi
  extends QRouteApi
{
  public static final String ACTION_GET_COMIC_CONFIG = "getComicConfig";
  public static final String ACTION_GET_IP_EXPRESSION_CONFIG = "getIpExpressionConfig";
  public static final String NAV_SWITCH_ANIMATION = "navSwitchAnimation";
  
  public abstract List<ComicCancelRedPointPopItemData> getCancelRedPointDialogDefaultData();
  
  public abstract int getCancelRedPointPopDayCount();
  
  public abstract int getReaderPreloadNum();
  
  public abstract boolean getSectionCommentMasterSwitch();
  
  public abstract int getSectionCommentNumVS();
  
  public abstract boolean isEnableCancelRedPointDataCache();
  
  public abstract boolean isEnableShowCancelRedPointDialog();
  
  public abstract boolean isIgnoreInteractiveControll();
  
  public abstract boolean isIgnoreReddotControll();
  
  public abstract boolean isMatched(String paramString);
  
  public abstract boolean isReaderEnablePreload();
  
  public abstract boolean isReaderEnablePreread();
  
  public abstract boolean launchIfMatched(String paramString, Context paramContext, int paramInt, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicConfigApi
 * JD-Core Version:    0.7.0.1
 */