package com.tencent.hippy.qq.view.viola.scroll;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;

@HippyController(name="tkdScrollView")
public class TkdScrollViewController
  extends HippyScrollViewController
{
  public static final String CLASS_NAME = "tkdScrollView";
  private static final String LOAD_MORE_FINISH = "loadMoreFinish";
  private static final String SCROLL_TO_POSITION = "scrollToPosition";
  private static final String SCROLL_TO_TOP = "scrollToTop";
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal"))) {
      return new TkdHorizontalScrollView(paramContext);
    }
    return new TkdVerticalScrollView(paramContext);
  }
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramView, paramString, paramHippyArray);
    if ((paramView instanceof TkdScrollView))
    {
      if (TextUtils.equals("scrollTo", paramString))
      {
        int i = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(0)));
        int j = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(1)));
        if (paramHippyArray.getBoolean(2))
        {
          ((TkdScrollView)paramView).callSmoothScrollTo(i, j, 0);
          return;
        }
        paramView.scrollTo(i, j);
        return;
      }
      if (TextUtils.equals("loadMoreFinish", paramString))
      {
        ((TkdScrollView)paramView).callLoadMoreFinish();
        return;
      }
      if (TextUtils.equals("scrollToTop", paramString))
      {
        boolean bool = paramHippyArray.getBoolean(0);
        ((TkdScrollView)paramView).callScrollToTop(bool);
      }
    }
  }
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    super.dispatchFunction(paramView, paramString, paramHippyArray, paramPromise);
    if (((paramView instanceof TkdScrollView)) && (TextUtils.equals("scrollToPosition", paramString)))
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
        ((TkdScrollView)paramView).callScrollToPosition(i, j, paramPromise);
      } else {
        paramString = "invalid distance parameter!";
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramPromise != null))
      {
        paramView = new HippyMap();
        paramView.pushString("msg", paramString);
        paramPromise.resolve(paramView);
      }
    }
  }
  
  @HippyControllerProps(defaultNumber=200.0D, defaultType="number", name="preloadDistance")
  public void setPreloadDistance(TkdScrollView paramTkdScrollView, int paramInt)
  {
    paramTkdScrollView.setPreloadDistance(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.scroll.TkdScrollViewController
 * JD-Core Version:    0.7.0.1
 */