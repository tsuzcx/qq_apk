package com.tencent.biz.richframework.part.block;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView.IInteractor;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class MultiViewBlock<E>
  extends BaseListViewAdapter<E>
  implements BlockMerger.ShareDataChangeListener
{
  private static final String TAG = "MultiViewBlock";
  protected static final int VIEW_TYPE_FOOTER = 100001;
  protected static final int VIEW_TYPE_HEADER = 100000;
  protected static final int VIEW_TYPE_ITEM = 100002;
  protected static final int VIEW_TYPE_LIVE = 100003;
  private BlockMerger mBlockMerger;
  private final RecyclerView.AdapterDataObserver mDataSetObserver = new MultiViewBlock.1(this);
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  protected boolean mHasInitialized;
  private Bundle mInitData;
  protected BaseWidgetView.IInteractor mInteractor;
  protected boolean mIsDestroyed;
  private final LoadInfo mLoadInfo = new LoadInfo();
  private MultiViewBlock.OnLoadDataDelegate mOnLoadDataDelegate;
  private int mPositionOffsetStart;
  private String mUniqueKey = String.valueOf(hashCode());
  private int mViewTypeOffsetStart;
  
  public MultiViewBlock(Bundle paramBundle)
  {
    this.mInitData = paramBundle;
    setHasStableIds(true);
  }
  
  private void innerloadData(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.OnLoadDataDelegate localOnLoadDataDelegate = this.mOnLoadDataDelegate;
    if (localOnLoadDataDelegate != null)
    {
      localOnLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    loadData(paramLoadInfo);
  }
  
  public void addFixViewOccupySpaceAtTop(View paramView, int paramInt)
  {
    if ((paramView != null) && (getBlockContainer() != null))
    {
      if (getParentRecyclerView() == null) {
        return;
      }
      if (paramView.getLayoutParams() != null) {
        ((FrameLayout.LayoutParams)paramView.getLayoutParams()).gravity = 48;
      }
      getBlockContainer().addView(paramView);
      getParentRecyclerView().setPadding(0, paramInt, 0, 0);
    }
  }
  
  public void addFloatView(View paramView)
  {
    if (getBlockContainer() != null) {
      getBlockContainer().addView(paramView);
    }
  }
  
  public void addOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (getParentRecyclerView() != null) {
      getParentRecyclerView().addOnScrollListener(paramOnScrollListener);
    }
  }
  
  protected Activity getActivity()
  {
    if ((getBlockContainer() != null) && (getBlockContainer().getFragment() != null)) {
      return getBlockContainer().getFragment().getActivity();
    }
    return null;
  }
  
  public BlockContainer getBlockContainer()
  {
    if (getBlockMerger() != null) {
      return getBlockMerger().h();
    }
    return null;
  }
  
  public BlockMerger getBlockMerger()
  {
    return this.mBlockMerger;
  }
  
  protected FrameLayout getCommonHeaderFooterWrapper(@Nullable View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
    return localFrameLayout;
  }
  
  protected Context getContext()
  {
    return getActivity();
  }
  
  public Serializable getExtraTypeInfo()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().getExtraTypeInfo();
    }
    return null;
  }
  
  protected int getFixedViewTypeOffset()
  {
    return 0;
  }
  
  public int getGlobalPosition(int paramInt)
  {
    return this.mPositionOffsetStart + paramInt;
  }
  
  public int getGlobalViewType(int paramInt)
  {
    return this.mViewTypeOffsetStart + paramInt;
  }
  
  public Bundle getInitParams()
  {
    return this.mInitData;
  }
  
  public BaseWidgetView.IInteractor getInteractor()
  {
    return this.mInteractor;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.mDataList != null) && (!ArrayUtils.a(paramInt, this.mDataList))) {
      return this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public abstract int getItemCount();
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public LoadInfo getLoadInfo()
  {
    return this.mLoadInfo;
  }
  
  public int getLocalPosition(int paramInt)
  {
    return paramInt - this.mPositionOffsetStart;
  }
  
  public Handler getMainHandler()
  {
    return this.mHandler;
  }
  
  public MultiViewBlock.OnLoadDataDelegate getOnLoadDataDelegate()
  {
    return this.mOnLoadDataDelegate;
  }
  
  public Fragment getParentFragment()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().getFragment();
    }
    return null;
  }
  
  public NestScrollRecyclerView getParentRecyclerView()
  {
    if (getBlockContainer() != null) {
      return getBlockContainer().getRecyclerView();
    }
    return null;
  }
  
  public int getPositionOffsetStart()
  {
    return this.mPositionOffsetStart;
  }
  
  public BlockMerger.ShareData getShareData(String paramString)
  {
    BlockMerger localBlockMerger = this.mBlockMerger;
    if (localBlockMerger != null) {
      return localBlockMerger.a(paramString);
    }
    return null;
  }
  
  public int getSpanCount(int paramInt)
  {
    return 1;
  }
  
  public String getUniqueKey()
  {
    return this.mUniqueKey;
  }
  
  public <T extends BaseViewModel> T getViewModel(Class<T> paramClass)
  {
    if ((getBlockMerger() != null) && (getBlockMerger().f() != null)) {
      return getBlockMerger().f().a(paramClass);
    }
    return null;
  }
  
  public abstract int getViewTypeCount();
  
  public int getViewTypeOffsetStart()
  {
    return this.mViewTypeOffsetStart;
  }
  
  protected void handleBlockChange(MultiViewBlock paramMultiViewBlock, int paramInt) {}
  
  public void handleShareDataChange(String paramString, BlockMerger.ShareData paramShareData) {}
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isEnableRefresh()
  {
    return true;
  }
  
  public boolean isLastPeerBlock()
  {
    BlockMerger localBlockMerger = getBlockMerger();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBlockMerger != null)
    {
      bool1 = bool2;
      if (getDataList().size() > 0)
      {
        bool1 = bool2;
        if (getBlockMerger().getDataList().get(getBlockMerger().getDataList().size() - 1) == this) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean isLazyLoad()
  {
    return false;
  }
  
  public boolean isOnScreen()
  {
    return true;
  }
  
  public abstract void loadData(LoadInfo paramLoadInfo);
  
  public void loadMoreData(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.OnLoadDataDelegate localOnLoadDataDelegate = this.mOnLoadDataDelegate;
    if (localOnLoadDataDelegate != null)
    {
      localOnLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    innerloadData(paramLoadInfo);
  }
  
  public void notifyLoadingComplete(boolean paramBoolean)
  {
    notifyLoadingComplete(paramBoolean, getLoadInfo().a());
  }
  
  public void notifyLoadingComplete(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getBlockContainer() != null)
    {
      if (getBlockMerger() == null) {
        return;
      }
      getLoadInfo().a(4);
      Object localObject = getBlockContainer();
      boolean bool2 = false;
      ((BlockContainer)localObject).setRefreshing(false);
      if (!isLastPeerBlock()) {
        return;
      }
      int i;
      if (getItemCount() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = getBlockMerger();
      boolean bool1 = bool2;
      if (paramBoolean2)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      ((BlockMerger)localObject).a(paramBoolean1, bool1);
    }
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (!hasObservers()) {
      registerAdapterDataObserver(this.mDataSetObserver);
    }
    this.mIsDestroyed = false;
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.mIsDestroyed = true;
    if (hasObservers()) {
      unregisterAdapterDataObserver(this.mDataSetObserver);
    }
    paramRecyclerView = this.mHandler;
    if (paramRecyclerView != null) {
      paramRecyclerView.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDrawItemDecoration(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  protected void onInit()
  {
    if (!this.mHasInitialized)
    {
      onInitBlock(getInitParams());
      this.mLoadInfo.a(1);
      innerloadData(this.mLoadInfo);
      this.mHasInitialized = true;
    }
  }
  
  public abstract void onInitBlock(Bundle paramBundle);
  
  public void onRefreshData()
  {
    this.mLoadInfo.a(2);
    MultiViewBlock.OnLoadDataDelegate localOnLoadDataDelegate = this.mOnLoadDataDelegate;
    if (localOnLoadDataDelegate != null)
    {
      localOnLoadDataDelegate.a(this.mLoadInfo, this);
      return;
    }
    innerloadData(this.mLoadInfo);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (isLazyLoad()) {
      onInit();
    }
  }
  
  public void removeOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    if (getParentRecyclerView() != null) {
      getParentRecyclerView().removeOnScrollListener(paramOnScrollListener);
    }
  }
  
  public void setBlockMerger(BlockMerger paramBlockMerger)
  {
    this.mBlockMerger = paramBlockMerger;
  }
  
  public void setGlobalPositionOffset(int paramInt)
  {
    this.mPositionOffsetStart = paramInt;
  }
  
  public void setInteractor(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.mInteractor = paramIInteractor;
  }
  
  public void setOnLoadDataDelegate(MultiViewBlock.OnLoadDataDelegate paramOnLoadDataDelegate)
  {
    this.mOnLoadDataDelegate = paramOnLoadDataDelegate;
  }
  
  public void setShareData(String paramString, BlockMerger.ShareData paramShareData)
  {
    BlockMerger localBlockMerger = this.mBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public void setViewTypeOffset(int paramInt)
  {
    this.mViewTypeOffsetStart = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock
 * JD-Core Version:    0.7.0.1
 */