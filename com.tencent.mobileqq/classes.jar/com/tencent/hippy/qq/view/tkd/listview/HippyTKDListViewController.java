package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;
import com.tencent.widget.immersive.ImmersiveUtils;

@HippyController(name="ListView")
public class HippyTKDListViewController
  extends HippyListViewController
{
  private static final String TAG = "HippyQBListViewController";
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyTKDListView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new HippyTKDListView(paramContext);
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray);
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramHippyListView = (HippyTKDListView)paramHippyListView;
      boolean bool = "endReachedCompleted".equals(paramString);
      int i = 6;
      int j;
      if (bool)
      {
        j = paramHippyArray.getInt(0);
        paramString = paramHippyArray.getString(1);
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2) {
              if (j != 3)
              {
                if (j != 4) {
                  i = 1;
                } else {
                  i = 0;
                }
              }
              else {
                i = 100;
              }
            }
          }
          else {
            i = 4;
          }
        }
        else {
          i = 2;
        }
        paramHippyListView.setLoadingStatus(i, paramString);
        return;
      }
      int k;
      String str;
      int m;
      int n;
      if ("refreshCompleted".equals(paramString))
      {
        i = paramHippyArray.getInt(0);
        paramString = paramHippyArray.getString(1);
        j = paramHippyArray.getInt(2);
        k = paramHippyArray.getInt(3);
        str = paramHippyArray.getString(4);
        m = paramHippyArray.getInt(5);
        n = paramHippyArray.getInt(6);
        int i1 = ImmersiveUtils.dpToPx(paramHippyArray.getInt(7));
        int i2 = paramHippyArray.getInt(8);
        int i3 = paramHippyArray.getInt(9);
        if (i != 0)
        {
          if (i != 1) {
            i = 1;
          } else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
        paramHippyListView.completeRefresh(i, paramString, m, n, k, i1, str, true, j, i2, null, i3);
        return;
      }
      if ("startRefresh".equals(paramString))
      {
        paramHippyListView.startRefresh(1);
        return;
      }
      if ("startRefreshWithType".equals(paramString))
      {
        paramHippyListView.startRefresh(paramHippyArray.getInt(0));
        return;
      }
      if ("startLoadMore".equals(paramString))
      {
        paramHippyListView.startLoadMore();
        return;
      }
      if ("callExposureReport".equals(paramString))
      {
        paramHippyListView.onScrollStateChanged(paramHippyListView.getScrollState(), paramHippyListView.getScrollState());
        return;
      }
      if ("callOnScroll".equals(paramString))
      {
        ((HippyTKDListViewAdapter)paramHippyListView.getAdapter()).checkOnScrollEvent();
        return;
      }
      if ("setRefreshPromptInfo".equals(paramString))
      {
        paramString = paramHippyArray.getString(0);
        j = paramHippyArray.getInt(1);
        k = ImmersiveUtils.dpToPx(paramHippyArray.getInt(2));
        str = paramHippyArray.getString(3);
        m = ImmersiveUtils.dpToPx(paramHippyArray.getInt(4));
        n = ImmersiveUtils.dpToPx(paramHippyArray.getInt(5));
        if (paramHippyArray.size() >= 7) {
          i = ImmersiveUtils.dpToPx(paramHippyArray.getInt(6));
        } else {
          i = 0;
        }
        paramHippyListView.setRefreshPromptInfo(paramString, j, k, str, m, n, i);
      }
    }
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray, paramPromise);
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramHippyListView = (HippyTKDListView)paramHippyListView;
      if ("getVisibleItems".equals(paramString))
      {
        paramPromise.resolve(paramHippyListView.getVisibleItems());
        return;
      }
      if ("refreshCompleted".equals(paramString))
      {
        int i4 = paramHippyArray.getInt(0);
        paramString = paramHippyArray.getString(1);
        int i = 2;
        int j = paramHippyArray.getInt(2);
        int k = paramHippyArray.getInt(3);
        String str = paramHippyArray.getString(4);
        int m = paramHippyArray.getInt(5);
        int n = paramHippyArray.getInt(6);
        int i1 = ImmersiveUtils.dpToPx(paramHippyArray.getInt(7));
        int i2 = paramHippyArray.getInt(8);
        int i3 = paramHippyArray.getInt(9);
        if (i4 != 0) {
          if (i4 != 1) {
            i = 1;
          } else {
            i = 3;
          }
        }
        paramHippyListView.completeRefresh(i, paramString, m, n, k, i1, str, true, j, i2, paramPromise, i3);
      }
    }
  }
  
  @HippyControllerProps(name="enableLoadingFooter")
  public void setEnableLoadingFooter(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramHippyListView = (HippyTKDListView)paramHippyListView;
      if (paramBoolean)
      {
        paramHippyListView.mEnableFooter = true;
        paramHippyListView.setLoadingStatus(2, "");
        return;
      }
      paramHippyListView.setLoadingStatus(0, "");
      paramHippyListView.mEnableFooter = false;
    }
  }
  
  @HippyControllerProps(name="enableOnScrollForReport")
  public void setEnableOnScrollForReport(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setEnableScrollForReport(paramBoolean);
    }
  }
  
  @HippyControllerProps(name="enableRefresh")
  public void setEnableRefresh(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramHippyListView = (HippyTKDListView)paramHippyListView;
      if ((paramBoolean) && (paramHippyListView.mEnableRefresh)) {
        return;
      }
      paramHippyListView.setRefreshEnabled(paramBoolean);
      if ((paramHippyListView.mRefreshColors != null) && (paramBoolean)) {
        paramHippyListView.setCustomRefreshColor(HippyTKDSkinHandler.getColor(paramHippyListView.mRefreshColors), 0, 0);
      }
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="enableScrollToContentOffset")
  public void setEnableScrollToContentOffset(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setEnableScrollToContentOffset(paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="initialContentOffset")
  public void setInitialContentOffset(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramInt = ImmersiveUtils.dpToPx(paramInt);
      ((HippyTKDListView)paramHippyListView).setInitialContentOffset(paramInt);
    }
  }
  
  @HippyControllerProps(name="enableExposureReport")
  public void setOnExposureReport(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setEnableExposureReport(paramBoolean);
    }
  }
  
  @HippyControllerProps(name="onScrollForReportThrottle")
  public void setOnScrollForReportThrottle(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setScrollForReportThrottle(paramInt);
    }
  }
  
  @HippyControllerProps(name="preloadItemNumber")
  public void setPreloadItemNumber(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setPreloadItemNumber(paramInt);
    }
  }
  
  @HippyControllerProps(name="refreshColor")
  public void setRefreshColor(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setCustomRefreshColor(paramInt, 0, 0);
    }
  }
  
  @HippyControllerProps(name="refreshColors")
  public void setRefreshColors(HippyListView paramHippyListView, HippyArray paramHippyArray)
  {
    if ((paramHippyListView instanceof HippyTKDListView))
    {
      paramHippyListView = (HippyTKDListView)paramHippyListView;
      int i = HippyTKDSkinHandler.getColor(paramHippyArray);
      paramHippyListView.setRefreshColors(paramHippyArray);
      paramHippyListView.setCustomRefreshColor(i, 0, 0);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="responseToDoubleScroll")
  public void setResponseToDoubleScroll(HippyListView paramHippyListView, boolean paramBoolean)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).handleDoubleScrollResponseChange(paramBoolean);
    }
  }
  
  @HippyControllerProps(name="scrollEventThrottle")
  public void setscrollEventThrottle(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof HippyTKDListView)) {
      ((HippyTKDListView)paramHippyListView).setScrollEventThrottle(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewController
 * JD-Core Version:    0.7.0.1
 */