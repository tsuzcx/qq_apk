package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$ItemAnimator
{
  public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
  public static final int FLAG_CHANGED = 2;
  public static final int FLAG_INVALIDATED = 4;
  public static final int FLAG_MOVED = 2048;
  public static final int FLAG_REMOVED = 8;
  private long mAddDuration = 120L;
  private long mChangeDuration = 250L;
  private ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mListener = null;
  private long mMoveDuration = 250L;
  private long mRemoveDuration = 120L;
  
  static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
  {
    int j = paramViewHolder.mFlags & 0xE;
    int i;
    if (paramViewHolder.isInvalid()) {
      i = 4;
    }
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            i = j;
          } while ((j & 0x4) != 0);
          k = paramViewHolder.getOldPosition();
          m = paramViewHolder.getAdapterPosition();
          i = j;
        } while (k == -1);
        i = j;
      } while (m == -1);
      i = j;
    } while (k == m);
    return j | 0x800;
  }
  
  public abstract boolean animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateChange(@NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
  
  public abstract boolean animatePersistence(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    return canReuseUpdatedViewHolder(paramViewHolder);
  }
  
  public final void dispatchAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    onAnimationFinished(paramViewHolder);
    if (this.mListener != null) {
      this.mListener.onAnimationFinished(paramViewHolder);
    }
  }
  
  public final void dispatchAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    onAnimationStarted(paramViewHolder);
  }
  
  public final void dispatchAnimationsFinished()
  {
    int j = this.mFinishedListeners.size();
    int i = 0;
    while (i < j)
    {
      ((RecyclerView.ItemAnimator.ItemAnimatorFinishedListener)this.mFinishedListeners.get(i)).onAnimationsFinished();
      i += 1;
    }
    this.mFinishedListeners.clear();
  }
  
  public abstract void endAnimation(@NonNull RecyclerView.ViewHolder paramViewHolder);
  
  public abstract void endAnimations();
  
  public long getAddDuration()
  {
    return this.mAddDuration;
  }
  
  public long getChangeDuration()
  {
    return this.mChangeDuration;
  }
  
  public long getMoveDuration()
  {
    return this.mMoveDuration;
  }
  
  public long getRemoveDuration()
  {
    return this.mRemoveDuration;
  }
  
  public abstract boolean isRunning();
  
  public final boolean isRunning(@Nullable RecyclerView.ItemAnimator.ItemAnimatorFinishedListener paramItemAnimatorFinishedListener)
  {
    boolean bool = isRunning();
    if (paramItemAnimatorFinishedListener != null)
    {
      if (!bool) {
        paramItemAnimatorFinishedListener.onAnimationsFinished();
      }
    }
    else {
      return bool;
    }
    this.mFinishedListeners.add(paramItemAnimatorFinishedListener);
    return bool;
  }
  
  @NonNull
  public RecyclerView.ItemAnimator.ItemHolderInfo obtainHolderInfo()
  {
    return new RecyclerView.ItemAnimator.ItemHolderInfo();
  }
  
  public void onAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
  
  @NonNull
  public RecyclerView.ItemAnimator.ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    return obtainHolderInfo().setFrom(paramViewHolder);
  }
  
  @NonNull
  public RecyclerView.ItemAnimator.ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt, @NonNull List<Object> paramList)
  {
    return obtainHolderInfo().setFrom(paramViewHolder);
  }
  
  public abstract void runPendingAnimations();
  
  public void setAddDuration(long paramLong)
  {
    this.mAddDuration = paramLong;
  }
  
  public void setChangeDuration(long paramLong)
  {
    this.mChangeDuration = paramLong;
  }
  
  void setListener(RecyclerView.ItemAnimator.ItemAnimatorListener paramItemAnimatorListener)
  {
    this.mListener = paramItemAnimatorListener;
  }
  
  public void setMoveDuration(long paramLong)
  {
    this.mMoveDuration = paramLong;
  }
  
  public void setRemoveDuration(long paramLong)
  {
    this.mRemoveDuration = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ItemAnimator
 * JD-Core Version:    0.7.0.1
 */