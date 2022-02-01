package com.tencent.comic.api.hippy;

import android.app.Activity;
import com.tencent.comic.data.ComicCancelRedPointPopIntercetorParams;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.VipComicDC01327ReportData;
import java.util.List;

public abstract interface IComicHippyBackEventInterceptor
{
  public abstract boolean canShowCancelRedPoinDialog(ComicCancelRedPointPopIntercetorParams paramComicCancelRedPointPopIntercetorParams);
  
  public abstract void doClear();
  
  public abstract List<ComicCancelRedPointPopItemData> getValidCancelRedPointDialogData();
  
  public abstract void openReader(Activity paramActivity, String paramString);
  
  public abstract void prepareData();
  
  public abstract void recordDialogShowTime();
  
  public abstract void reportData(VipComicDC01327ReportData paramVipComicDC01327ReportData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
 * JD-Core Version:    0.7.0.1
 */