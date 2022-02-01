package com.tencent.comic.hippy.api;

import android.app.Activity;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.comic.data.ComicCancelRedPointPopIntercetorParams;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.VipComicDC01327ReportData;
import java.util.List;

public class ComicHippyBackEventInterceptorProxy
  implements IComicHippyBackEventInterceptor
{
  public static final ComicHippyBackEventInterceptorProxy INSTANCE = new ComicHippyBackEventInterceptorProxy();
  public IComicHippyBackEventInterceptor mProxy = null;
  
  public boolean canShowCancelRedPoinDialog(ComicCancelRedPointPopIntercetorParams paramComicCancelRedPointPopIntercetorParams)
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      return localIComicHippyBackEventInterceptor.canShowCancelRedPoinDialog(paramComicCancelRedPointPopIntercetorParams);
    }
    return false;
  }
  
  public void doClear()
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      localIComicHippyBackEventInterceptor.doClear();
    }
  }
  
  public List<ComicCancelRedPointPopItemData> getValidCancelRedPointDialogData()
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      return localIComicHippyBackEventInterceptor.getValidCancelRedPointDialogData();
    }
    return null;
  }
  
  public void openReader(Activity paramActivity, String paramString)
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      localIComicHippyBackEventInterceptor.openReader(paramActivity, paramString);
    }
  }
  
  public void prepareData()
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      localIComicHippyBackEventInterceptor.prepareData();
    }
  }
  
  public void recordDialogShowTime()
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      localIComicHippyBackEventInterceptor.recordDialogShowTime();
    }
  }
  
  public void reportData(VipComicDC01327ReportData paramVipComicDC01327ReportData)
  {
    IComicHippyBackEventInterceptor localIComicHippyBackEventInterceptor = this.mProxy;
    if (localIComicHippyBackEventInterceptor != null) {
      localIComicHippyBackEventInterceptor.reportData(paramVipComicDC01327ReportData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy
 * JD-Core Version:    0.7.0.1
 */