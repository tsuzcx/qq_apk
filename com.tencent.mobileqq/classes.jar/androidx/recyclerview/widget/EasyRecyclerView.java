package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class EasyRecyclerView
  extends RecyclerView
{
  protected OverPullHelper overPullHelper;
  protected OverPullListener overPullListener;
  protected VelocityTracker velocityTracker;
  
  public EasyRecyclerView(@NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public EasyRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EasyRecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int getCachedViewHolderCount()
  {
    int j = this.mRecycler.mAttachedScrap.size() + this.mRecycler.mCachedViews.size();
    int i = 0;
    while (i < this.mRecycler.getRecycledViewPool().mScrap.size())
    {
      j += ((RecyclerView.RecycledViewPool.ScrapData)this.mRecycler.getRecycledViewPool().mScrap.valueAt(i)).mScrapHeap.size();
      i += 1;
    }
    return j;
  }
  
  public boolean didStructureChange()
  {
    return this.mState.didStructureChange();
  }
  
  public void dispatchLayout()
  {
    super.dispatchLayout();
  }
  
  public ArrayList<RecyclerView.ViewHolder> getCachedViewHolders()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.mRecycler.mAttachedScrap);
    localArrayList.addAll(this.mRecycler.mCachedViews);
    int i = 0;
    while (i < this.mRecycler.getRecycledViewPool().mScrap.size())
    {
      localArrayList.addAll(((RecyclerView.RecycledViewPool.ScrapData)this.mRecycler.getRecycledViewPool().mScrap.valueAt(i)).mScrapHeap);
      i += 1;
    }
    return localArrayList;
  }
  
  public View getChildAtWithCaches(int paramInt)
  {
    ArrayList localArrayList = getCachedViewHolders();
    if (paramInt < localArrayList.size()) {
      return ((RecyclerView.ViewHolder)localArrayList.get(paramInt)).itemView;
    }
    return getChildAt(paramInt - localArrayList.size());
  }
  
  public int getChildCountWithCaches()
  {
    return getCachedViewHolderCount() + getChildCount();
  }
  
  public int getFirstChildPosition()
  {
    View localView;
    if (getChildCount() > 0) {
      localView = getChildAt(0);
    } else {
      localView = null;
    }
    return getChildLayoutPosition(localView);
  }
  
  public RecyclerView.ViewHolder getFistChildViewHolder()
  {
    View localView = getChildAt(0);
    if ((localView != null) && ((localView.getLayoutParams() instanceof RecyclerView.LayoutParams))) {
      return ((RecyclerView.LayoutParams)localView.getLayoutParams()).mViewHolder;
    }
    return null;
  }
  
  public int getLashChildPosition()
  {
    View localView;
    if (getChildCount() > 0) {
      localView = getChildAt(getChildCount() - 1);
    } else {
      localView = null;
    }
    return getChildLayoutPosition(localView);
  }
  
  public int getOverPullDownOffset()
  {
    OverPullHelper localOverPullHelper = this.overPullHelper;
    if (localOverPullHelper != null) {
      return localOverPullHelper.getOverPullDownOffset();
    }
    return 0;
  }
  
  public int getOverPullState()
  {
    OverPullHelper localOverPullHelper = this.overPullHelper;
    if (localOverPullHelper != null) {
      return localOverPullHelper.getOverPullState();
    }
    return 0;
  }
  
  public int getOverPullUpOffset()
  {
    OverPullHelper localOverPullHelper = this.overPullHelper;
    if (localOverPullHelper != null) {
      return localOverPullHelper.getOverPullUpOffset();
    }
    return 0;
  }
  
  public VelocityTracker getVelocityTracker()
  {
    if (this.velocityTracker == null) {
      try
      {
        Field localField = RecyclerView.class.getDeclaredField("mVelocityTracker");
        localField.setAccessible(true);
        this.velocityTracker = ((VelocityTracker)localField.get(this));
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    return this.velocityTracker;
  }
  
  public RecyclerView.ViewHolder getViewHolderForPosition(int paramInt)
  {
    View localView = this.mRecycler.getViewForPosition(paramInt);
    if ((localView.getLayoutParams() instanceof RecyclerView.LayoutParams)) {
      return ((RecyclerView.LayoutParams)localView.getLayoutParams()).mViewHolder;
    }
    return null;
  }
  
  protected void init() {}
  
  public void invalidateGlows()
  {
    super.invalidateGlows();
  }
  
  public boolean isDataChangedWithoutNotify()
  {
    return getAdapter().getItemCount() != this.mState.getItemCount();
  }
  
  public boolean isOverPulling()
  {
    int i = getOverPullState();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 2)
      {
        if (i == 4) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    OverPullHelper localOverPullHelper = this.overPullHelper;
    if ((localOverPullHelper != null) && (localOverPullHelper.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    localOverPullHelper = this.overPullHelper;
    if (localOverPullHelper != null) {
      localOverPullHelper.handleEventUp(paramMotionEvent);
    }
    return bool;
  }
  
  public void recycleAndClearCachedViews()
  {
    this.mRecycler.recycleAndClearCachedViews();
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setEnableOverPull(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.overPullHelper == null) {
        this.overPullHelper = new OverPullHelper(this);
      }
      this.overPullHelper.setOverPullListener(this.overPullListener);
      return;
    }
    this.overPullHelper = null;
  }
  
  public void setOverPullListener(OverPullListener paramOverPullListener)
  {
    this.overPullListener = paramOverPullListener;
    OverPullHelper localOverPullHelper = this.overPullHelper;
    if (localOverPullHelper != null) {
      localOverPullHelper.setOverPullListener(paramOverPullListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.EasyRecyclerView
 * JD-Core Version:    0.7.0.1
 */