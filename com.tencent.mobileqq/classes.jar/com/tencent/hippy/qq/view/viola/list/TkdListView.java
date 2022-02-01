package com.tencent.hippy.qq.view.viola.list;

import android.content.Context;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListView.OnScrollEvent;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.State;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.ViewFlinger;

public class TkdListView
  extends HippyListView
  implements RecyclerView.OnListScrollListener
{
  public static final String EVENT_TYPE_DRAG_END = "onDragEnd";
  public static final String EVENT_TYPE_SCROLL_END = "onScrollEnd";
  private boolean mIsLoading = false;
  private int mPreloadDistance = 0;
  private Promise mPromise = null;
  protected int mScrollMinOffset = 0;
  
  public TkdListView(Context paramContext)
  {
    super(paramContext);
    addOnListScrollListener(this);
  }
  
  public TkdListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    addOnListScrollListener(this);
  }
  
  protected HippyListAdapter createAdapter(RecyclerView paramRecyclerView, HippyEngineContext paramHippyEngineContext)
  {
    return new TkdListViewAdapter(paramRecyclerView, paramHippyEngineContext);
  }
  
  protected HippyMap generateScrollEvent()
  {
    HippyMap localHippyMap1 = new HippyMap();
    HippyMap localHippyMap2 = new HippyMap();
    HippyMap localHippyMap3 = new HippyMap();
    if (this.mLayout.canScrollHorizontally())
    {
      localHippyMap1.pushInt("x", (int)PixelUtil.px2dp(this.mOffsetX - this.mState.mCustomHeaderWidth));
      localHippyMap1.pushInt("y", (int)PixelUtil.px2dp(0.0F));
      localHippyMap2.pushInt("width", (int)PixelUtil.px2dp(this.mState.mTotalHeight));
      localHippyMap2.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
      localHippyMap3.pushInt("x", (int)PixelUtil.px2dp(getX()));
      localHippyMap3.pushInt("y", (int)PixelUtil.px2dp(getY()));
      localHippyMap3.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap3.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
    }
    else
    {
      localHippyMap1.pushInt("x", (int)PixelUtil.px2dp(0.0F));
      localHippyMap1.pushInt("y", (int)PixelUtil.px2dp(this.mOffsetY - this.mState.mCustomHeaderHeight));
      localHippyMap2.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap2.pushInt("height", (int)PixelUtil.px2dp(this.mState.mTotalHeight));
      localHippyMap3.pushInt("x", (int)PixelUtil.px2dp(getX()));
      localHippyMap3.pushInt("y", (int)PixelUtil.px2dp(getY()));
      localHippyMap3.pushInt("width", (int)PixelUtil.px2dp(getWidth()));
      localHippyMap3.pushInt("height", (int)PixelUtil.px2dp(getHeight()));
    }
    HippyMap localHippyMap4 = new HippyMap();
    localHippyMap4.pushMap("contentOffset", localHippyMap1);
    localHippyMap4.pushMap("contentSize", localHippyMap2);
    localHippyMap4.pushMap("frame", localHippyMap3);
    return localHippyMap4;
  }
  
  public boolean isLoading()
  {
    return this.mIsLoading;
  }
  
  public void onDragEnd()
  {
    new HippyListView.OnScrollEvent(this, "onDragEnd").send(this, null);
  }
  
  public void onScroll(int paramInt1, int paramInt2) {}
  
  public void onScrollEnd()
  {
    new HippyListView.OnScrollEvent(this, "onScrollEnd").send(this, null);
    if (this.mPromise != null)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("msg", "on scroll end!");
      this.mPromise.resolve(localHippyMap);
      this.mPromise = null;
    }
  }
  
  public void onScrolled(int paramInt1, int paramInt2)
  {
    super.onScrolled(paramInt1, paramInt2);
    this.mAdapter.notifyEndReached();
  }
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
  
  public void scrollWithDistance(int paramInt1, int paramInt2, Promise paramPromise)
  {
    if (!this.mState.didStructureChange())
    {
      if (this.mLayout.canScrollHorizontally()) {
        this.mViewFlinger.smoothScrollBy(paramInt1, 0, paramInt2, true);
      } else {
        this.mViewFlinger.smoothScrollBy(0, paramInt1, paramInt2, true);
      }
      this.mPromise = paramPromise;
    }
  }
  
  protected void sendOnScrollEvent()
  {
    if (this.mScrollEventEnable)
    {
      long l = System.currentTimeMillis();
      int i = this.mScrollMinOffset;
      if (i > 0)
      {
        if (this.mLayout.canScrollHorizontally())
        {
          if (this.mLastOffsetX == -2147483648) {
            this.mLastOffsetX = this.mState.mCustomHeaderWidth;
          }
          if (this.mOffsetX - this.mLastOffsetX >= this.mScrollMinOffset)
          {
            this.mLastOffsetX = this.mOffsetX;
            getOnScrollEvent().send(this, generateScrollEvent());
          }
        }
        else
        {
          if (this.mLastOffsetY == -2147483648) {
            this.mLastOffsetY = this.mState.mCustomHeaderHeight;
          }
          if (this.mOffsetY - this.mLastOffsetY >= this.mScrollMinOffset)
          {
            this.mLastOffsetY = this.mOffsetY;
            getOnScrollEvent().send(this, generateScrollEvent());
          }
        }
      }
      else if ((i == 0) && (l - this.mLastScrollEventTimeStamp >= this.mScrollEventThrottle))
      {
        this.mLastScrollEventTimeStamp = l;
        getOnScrollEvent().send(this, generateScrollEvent());
      }
    }
  }
  
  public void setIsLoading(boolean paramBoolean)
  {
    this.mIsLoading = paramBoolean;
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = ((int)PixelUtil.dp2px(Math.max(0, paramInt)));
  }
  
  public void setScrollMinOffset(int paramInt)
  {
    this.mScrollMinOffset = ((int)PixelUtil.dp2px(Math.max(200, paramInt)));
  }
  
  public boolean shouldEmitEndReachedEvent()
  {
    if (this.mLayout.canScrollHorizontally())
    {
      if (this.mState.mTotalHeight - this.mOffsetX - getWidth() <= this.mPreloadDistance) {
        return true;
      }
    }
    else if (this.mState.mTotalHeight - this.mOffsetY - getHeight() <= this.mPreloadDistance) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.list.TkdListView
 * JD-Core Version:    0.7.0.1
 */