package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator
  extends SimpleItemAnimator
{
  private static final boolean DEBUG = false;
  private ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList();
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList();
  private ArrayList<ArrayList<DefaultItemAnimator.ChangeInfo>> mChangesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList();
  private ArrayList<ArrayList<DefaultItemAnimator.MoveInfo>> mMovesList = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList();
  private ArrayList<DefaultItemAnimator.ChangeInfo> mPendingChanges = new ArrayList();
  private ArrayList<DefaultItemAnimator.MoveInfo> mPendingMoves = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList();
  
  private void animateAddImpl(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.mAddAnimations.add(paramViewHolder);
    localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(getAddDuration()).setListener(new DefaultItemAnimator.5(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void animateChangeImpl(DefaultItemAnimator.ChangeInfo paramChangeInfo)
  {
    Object localObject = paramChangeInfo.oldHolder;
    View localView = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((RecyclerView.ViewHolder)localObject).itemView;
    }
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.newHolder;
    if (localViewHolder != null) {
      localView = localViewHolder.itemView;
    }
    if (localObject != null)
    {
      localObject = ViewCompat.animate((View)localObject).setDuration(getChangeDuration());
      this.mChangeAnimations.add(paramChangeInfo.oldHolder);
      ((ViewPropertyAnimatorCompat)localObject).translationX(paramChangeInfo.toX - paramChangeInfo.fromX);
      ((ViewPropertyAnimatorCompat)localObject).translationY(paramChangeInfo.toY - paramChangeInfo.fromY);
      ((ViewPropertyAnimatorCompat)localObject).alpha(0.0F).setListener(new DefaultItemAnimator.7(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject)).start();
    }
    if (localView != null)
    {
      localObject = ViewCompat.animate(localView);
      this.mChangeAnimations.add(paramChangeInfo.newHolder);
      ((ViewPropertyAnimatorCompat)localObject).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new DefaultItemAnimator.8(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject, localView)).start();
    }
  }
  
  private void animateMoveImpl(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = paramViewHolder.itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      ViewCompat.animate((View)localObject).translationX(0.0F);
    }
    if (paramInt2 != 0) {
      ViewCompat.animate((View)localObject).translationY(0.0F);
    }
    localObject = ViewCompat.animate((View)localObject);
    this.mMoveAnimations.add(paramViewHolder);
    ((ViewPropertyAnimatorCompat)localObject).setDuration(getMoveDuration()).setListener(new DefaultItemAnimator.6(this, paramViewHolder, paramInt1, paramInt2, (ViewPropertyAnimatorCompat)localObject)).start();
  }
  
  private void animateRemoveImpl(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.mRemoveAnimations.add(paramViewHolder);
    localViewPropertyAnimatorCompat.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new DefaultItemAnimator.4(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void endChangeAnimation(List<DefaultItemAnimator.ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      DefaultItemAnimator.ChangeInfo localChangeInfo = (DefaultItemAnimator.ChangeInfo)paramList.get(i);
      if ((endChangeAnimationIfNecessary(localChangeInfo, paramViewHolder)) && (localChangeInfo.oldHolder == null) && (localChangeInfo.newHolder == null)) {
        paramList.remove(localChangeInfo);
      }
      i -= 1;
    }
  }
  
  private void endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo paramChangeInfo)
  {
    if (paramChangeInfo.oldHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.oldHolder);
    }
    if (paramChangeInfo.newHolder != null) {
      endChangeAnimationIfNecessary(paramChangeInfo, paramChangeInfo.newHolder);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(DefaultItemAnimator.ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.newHolder;
    boolean bool = false;
    if (localViewHolder == paramViewHolder)
    {
      paramChangeInfo.newHolder = null;
    }
    else
    {
      if (paramChangeInfo.oldHolder != paramViewHolder) {
        break label69;
      }
      paramChangeInfo.oldHolder = null;
      bool = true;
    }
    ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
    ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
    ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
    label69:
    return false;
  }
  
  private void resetAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.clearInterpolator(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
    this.mPendingAdditions.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    resetAnimation(paramViewHolder1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null)
    {
      resetAnimation(paramViewHolder2);
      ViewCompat.setTranslationX(paramViewHolder2.itemView, -i);
      ViewCompat.setTranslationY(paramViewHolder2.itemView, -j);
      ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
    }
    this.mPendingChanges.add(new DefaultItemAnimator.ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    resetAnimation(paramViewHolder);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (i != 0) {
      ViewCompat.setTranslationX(localView, -i);
    }
    if (j != 0) {
      ViewCompat.setTranslationY(localView, -j);
    }
    this.mPendingMoves.add(new DefaultItemAnimator.MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    resetAnimation(paramViewHolder);
    this.mPendingRemovals.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  void cancelAll(List<RecyclerView.ViewHolder> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(i)).itemView).cancel();
      i -= 1;
    }
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    int i = this.mPendingMoves.size() - 1;
    while (i >= 0)
    {
      if (((DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(i)).holder == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.mPendingMoves.remove(i);
      }
      i -= 1;
    }
    endChangeAnimation(this.mPendingChanges, paramViewHolder);
    if (this.mPendingRemovals.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.mPendingAdditions.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    i = this.mChangesList.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.mChangesList.get(i);
      endChangeAnimation(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        this.mChangesList.remove(i);
      }
      i -= 1;
    }
    i = this.mMovesList.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.mMovesList.get(i);
      int j = localArrayList.size() - 1;
      while (j >= 0)
      {
        if (((DefaultItemAnimator.MoveInfo)localArrayList.get(j)).holder == paramViewHolder)
        {
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList.remove(j);
          if (!localArrayList.isEmpty()) {
            break;
          }
          this.mMovesList.remove(i);
          break;
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.mAdditionsList.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.mAdditionsList.get(i);
      if (localArrayList.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          this.mAdditionsList.remove(i);
        }
      }
      i -= 1;
    }
    this.mRemoveAnimations.remove(paramViewHolder);
    this.mAddAnimations.remove(paramViewHolder);
    this.mChangeAnimations.remove(paramViewHolder);
    this.mMoveAnimations.remove(paramViewHolder);
    dispatchFinishedWhenDone();
  }
  
  public void endAnimations()
  {
    int i = this.mPendingMoves.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (DefaultItemAnimator.MoveInfo)this.mPendingMoves.get(i);
      localObject2 = ((DefaultItemAnimator.MoveInfo)localObject1).holder.itemView;
      ViewCompat.setTranslationY((View)localObject2, 0.0F);
      ViewCompat.setTranslationX((View)localObject2, 0.0F);
      dispatchMoveFinished(((DefaultItemAnimator.MoveInfo)localObject1).holder);
      this.mPendingMoves.remove(i);
      i -= 1;
    }
    i = this.mPendingRemovals.size() - 1;
    while (i >= 0)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.mPendingRemovals.get(i));
      this.mPendingRemovals.remove(i);
      i -= 1;
    }
    i = this.mPendingAdditions.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.ViewHolder)this.mPendingAdditions.get(i);
      ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject1).itemView, 1.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject1);
      this.mPendingAdditions.remove(i);
      i -= 1;
    }
    i = this.mPendingChanges.size() - 1;
    while (i >= 0)
    {
      endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)this.mPendingChanges.get(i));
      i -= 1;
    }
    this.mPendingChanges.clear();
    if (!isRunning()) {
      return;
    }
    i = this.mMovesList.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.mMovesList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (DefaultItemAnimator.MoveInfo)((ArrayList)localObject1).get(j);
        View localView = ((DefaultItemAnimator.MoveInfo)localObject2).holder.itemView;
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(((DefaultItemAnimator.MoveInfo)localObject2).holder);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.mMovesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.mAdditionsList.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.mAdditionsList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(j);
        ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject2).itemView, 1.0F);
        dispatchAddFinished((RecyclerView.ViewHolder)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.mAdditionsList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.mChangesList.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.mChangesList.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        endChangeAnimationIfNecessary((DefaultItemAnimator.ChangeInfo)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.mChangesList.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    cancelAll(this.mRemoveAnimations);
    cancelAll(this.mMoveAnimations);
    cancelAll(this.mAddAnimations);
    cancelAll(this.mChangeAnimations);
    dispatchAnimationsFinished();
  }
  
  public boolean isRunning()
  {
    return (!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || (!this.mMoveAnimations.isEmpty()) || (!this.mRemoveAnimations.isEmpty()) || (!this.mAddAnimations.isEmpty()) || (!this.mChangeAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty());
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.mPendingRemovals.isEmpty() ^ true;
    boolean bool2 = this.mPendingMoves.isEmpty() ^ true;
    boolean bool3 = this.mPendingChanges.isEmpty() ^ true;
    boolean bool4 = this.mPendingAdditions.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool3)) {
      return;
    }
    Object localObject1 = this.mPendingRemovals.iterator();
    while (((Iterator)localObject1).hasNext()) {
      animateRemoveImpl((RecyclerView.ViewHolder)((Iterator)localObject1).next());
    }
    this.mPendingRemovals.clear();
    Object localObject2;
    if (bool2)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.mPendingMoves);
      this.mMovesList.add(localObject1);
      this.mPendingMoves.clear();
      localObject2 = new DefaultItemAnimator.1(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.MoveInfo)((ArrayList)localObject1).get(0)).holder.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool3)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.mPendingChanges);
      this.mChangesList.add(localObject1);
      this.mPendingChanges.clear();
      localObject2 = new DefaultItemAnimator.2(this, (ArrayList)localObject1);
      if (bool1) {
        ViewCompat.postOnAnimationDelayed(((DefaultItemAnimator.ChangeInfo)((ArrayList)localObject1).get(0)).oldHolder.itemView, (Runnable)localObject2, getRemoveDuration());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool4)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.mPendingAdditions);
      this.mAdditionsList.add(localObject1);
      this.mPendingAdditions.clear();
      localObject2 = new DefaultItemAnimator.3(this, (ArrayList)localObject1);
      if ((!bool1) && (!bool2) && (!bool3))
      {
        ((Runnable)localObject2).run();
        return;
      }
      long l3 = 0L;
      long l1;
      if (bool1) {
        l1 = getRemoveDuration();
      } else {
        l1 = 0L;
      }
      if (bool2) {
        l2 = getMoveDuration();
      } else {
        l2 = 0L;
      }
      if (bool3) {
        l3 = getChangeDuration();
      }
      long l2 = Math.max(l2, l3);
      ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)((ArrayList)localObject1).get(0)).itemView, (Runnable)localObject2, l1 + l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator
 * JD-Core Version:    0.7.0.1
 */