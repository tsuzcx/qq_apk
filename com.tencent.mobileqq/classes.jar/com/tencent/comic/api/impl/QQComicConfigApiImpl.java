package com.tencent.comic.api.impl;

import android.content.Context;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.config.QQComicConfBean.ComicReaderConfig;
import com.tencent.comic.config.QQComicConfBean.ServiceAccountConfig;
import com.tencent.comic.data.ComicCancelRedPointPopConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import java.util.List;

public class QQComicConfigApiImpl
  implements IQQComicConfigApi
{
  public List<ComicCancelRedPointPopItemData> getCancelRedPointDialogDefaultData()
  {
    return QQComicConfBean.e().list;
  }
  
  public int getCancelRedPointPopDayCount()
  {
    return QQComicConfBean.e().dayCount;
  }
  
  public int getReaderPreloadNum()
  {
    return QQComicConfBean.a().preloadNum;
  }
  
  public boolean getSectionCommentMasterSwitch()
  {
    return QQComicConfBean.a().sectionCommentMasterSwitch;
  }
  
  public int getSectionCommentNumVS()
  {
    return QQComicConfBean.a().sectionCommentNumVS;
  }
  
  public boolean isEnableCancelRedPointDataCache()
  {
    return QQComicConfBean.e().enableLocalCache == 1;
  }
  
  public boolean isEnableShowCancelRedPointDialog()
  {
    return QQComicConfBean.e().popSwitch == 1;
  }
  
  public boolean isIgnoreInteractiveControll()
  {
    return QQComicConfBean.e().ignoreInteractiveControll == 1;
  }
  
  public boolean isIgnoreReddotControll()
  {
    return QQComicConfBean.e().ignoreRedDot == 1;
  }
  
  public boolean isMatched(String paramString)
  {
    return QQComicConfBean.d().a(paramString);
  }
  
  public boolean isReaderEnablePreload()
  {
    return QQComicConfBean.a().enablePreload;
  }
  
  public boolean isReaderEnablePreread()
  {
    return QQComicConfBean.a().enablePreRead;
  }
  
  public boolean launchIfMatched(String paramString, Context paramContext, int paramInt, AppInterface paramAppInterface)
  {
    return QQComicConfBean.d().a(paramString, paramContext, paramInt, paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */