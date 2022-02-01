package com.tencent.hippy.qq.view.viola.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;

@HippyController(name="tkdListView")
public class TkdListViewController
  extends HippyListViewController
{
  public static final String CLASS_NAME = "tkdListView";
  private static final String SCROLL_TO_POSITION = "scrollToPosition";
  
  protected View createViewImpl(Context paramContext)
  {
    return new TkdListView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    int i;
    if ((paramHippyMap != null) && (((paramHippyMap.containsKey("direction")) && (paramHippyMap.getString("direction").equals("horizontal"))) || (paramHippyMap.containsKey("horizontal")))) {
      i = 0;
    } else {
      i = 1;
    }
    return new TkdListView(paramContext, i);
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray);
    if ((!TextUtils.isEmpty(paramString)) && ((paramHippyListView instanceof TkdListView)) && (paramString.equals("loadMoreFinish"))) {
      ((TkdListView)paramHippyListView).setIsLoading(false);
    }
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray, paramPromise);
    if (((paramHippyListView instanceof TkdListView)) && (TextUtils.equals("scrollToPosition", paramString)))
    {
      int i = 0;
      int j = 0;
      if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
      {
        paramString = paramHippyArray.getMap(0);
        if (paramString != null)
        {
          i = (int)PixelUtil.dp2px(paramString.getInt("distance"));
          j = paramString.getInt("duration");
        }
        else
        {
          i = 0;
        }
        paramString = "";
      }
      else
      {
        paramString = "invalid parameter!";
        j = 0;
      }
      if (i != 0) {
        ((TkdListView)paramHippyListView).scrollWithDistance(i, j, paramPromise);
      } else {
        paramString = "invalid distance parameter!";
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramPromise != null))
      {
        paramHippyListView = new HippyMap();
        paramHippyListView.pushString("msg", paramString);
        paramPromise.resolve(paramHippyListView);
      }
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="preloadDistance")
  public void setPreloadDistance(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof TkdListView)) {
      ((TkdListView)paramHippyListView).setPreloadDistance(paramInt);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="scrollMinOffset")
  public void setScrollMinOffset(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof TkdListView)) {
      ((TkdListView)paramHippyListView).setScrollMinOffset(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.list.TkdListViewController
 * JD-Core Version:    0.7.0.1
 */