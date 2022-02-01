package com.tencent.biz.richframework.animation.recyclerview;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.richframework.animation.support.AnimatorCompatHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnhanceItemAnimator
  extends SimpleItemAnimator
{
  private ArrayList<RecyclerView.ViewHolder> a = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> b = new ArrayList();
  private ArrayList<EnhanceItemAnimator.MoveInfo> c = new ArrayList();
  private ArrayList<EnhanceItemAnimator.ChangeInfo> d = new ArrayList();
  private ArrayList<ArrayList<RecyclerView.ViewHolder>> e = new ArrayList();
  private ArrayList<ArrayList<EnhanceItemAnimator.MoveInfo>> f = new ArrayList();
  private ArrayList<ArrayList<EnhanceItemAnimator.ChangeInfo>> g = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> h = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> i = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> j = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> k = new ArrayList();
  private EnhanceItemAnimator.AddAnimationConfig l;
  
  private void a()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1;
    if ((paramViewHolder instanceof EnhanceHolderAnimationInterface)) {
      localViewPropertyAnimatorCompat1 = ((EnhanceHolderAnimationInterface)paramViewHolder).a(paramViewHolder);
    } else {
      localViewPropertyAnimatorCompat1 = null;
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = localViewPropertyAnimatorCompat1;
    if (localViewPropertyAnimatorCompat1 == null)
    {
      localViewPropertyAnimatorCompat2 = ViewCompat.animate(localView).setDuration(getRemoveDuration());
      localViewPropertyAnimatorCompat2.setDuration(getRemoveDuration()).alpha(0.0F);
    }
    this.j.add(paramViewHolder);
    localViewPropertyAnimatorCompat2.setListener(new EnhanceItemAnimator.4(this, paramViewHolder, localViewPropertyAnimatorCompat2)).start();
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if (m != 0) {
      ViewCompat.animate(localView).translationX(0.0F);
    }
    if (n != 0) {
      ViewCompat.animate(localView).translationY(0.0F);
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = null;
    EnhanceItemAnimator.MoveInfo localMoveInfo = new EnhanceItemAnimator.MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null);
    if ((paramViewHolder instanceof EnhanceHolderAnimationInterface)) {
      localViewPropertyAnimatorCompat = ((EnhanceHolderAnimationInterface)paramViewHolder).a(localMoveInfo, getMoveDuration());
    }
    if (localViewPropertyAnimatorCompat == null) {
      localViewPropertyAnimatorCompat = ViewCompat.animate(localView).setDuration(getMoveDuration());
    }
    this.i.add(paramViewHolder);
    localViewPropertyAnimatorCompat.setListener(new EnhanceItemAnimator.6(this, paramViewHolder, m, n, localViewPropertyAnimatorCompat)).start();
  }
  
  private void a(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.a;
    Object localObject4 = null;
    Object localObject2;
    if (localViewHolder == null) {
      localObject2 = null;
    } else {
      localObject2 = localViewHolder.itemView;
    }
    Object localObject1 = paramChangeInfo.b;
    View localView;
    if (localObject1 != null) {
      localView = ((RecyclerView.ViewHolder)localObject1).itemView;
    } else {
      localView = null;
    }
    if (localObject2 != null)
    {
      if ((localViewHolder instanceof EnhanceHolderAnimationInterface)) {
        localObject1 = ((EnhanceHolderAnimationInterface)localViewHolder).a(paramChangeInfo, getChangeDuration(), true);
      } else {
        localObject1 = null;
      }
      this.k.add(paramChangeInfo.a);
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = ViewCompat.animate((View)localObject2).setDuration(getChangeDuration());
        ((ViewPropertyAnimatorCompat)localObject3).translationX(paramChangeInfo.e - paramChangeInfo.c);
        ((ViewPropertyAnimatorCompat)localObject3).scaleY(1.0F);
        ((ViewPropertyAnimatorCompat)localObject3).scaleX(1.0F);
        ((ViewPropertyAnimatorCompat)localObject3).translationY(paramChangeInfo.f - paramChangeInfo.d);
        ((ViewPropertyAnimatorCompat)localObject3).alpha(0.0F);
      }
      ((ViewPropertyAnimatorCompat)localObject3).setListener(new EnhanceItemAnimator.7(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject3)).start();
    }
    if (localView != null)
    {
      localObject1 = localObject4;
      if ((localViewHolder instanceof EnhanceHolderAnimationInterface)) {
        localObject1 = ((EnhanceHolderAnimationInterface)localViewHolder).a(paramChangeInfo, getChangeDuration(), false);
      }
      this.k.add(paramChangeInfo.b);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = ViewCompat.animate(localView);
        ((ViewPropertyAnimatorCompat)localObject2).translationX(0.0F).translationY(0.0F).scaleX(1.0F).scaleY(1.0F).setDuration(getChangeDuration()).alpha(1.0F);
      }
      ((ViewPropertyAnimatorCompat)localObject2).setListener(new EnhanceItemAnimator.8(this, paramChangeInfo, (ViewPropertyAnimatorCompat)localObject2, localView)).start();
    }
  }
  
  private void a(List<EnhanceItemAnimator.ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      EnhanceItemAnimator.ChangeInfo localChangeInfo = (EnhanceItemAnimator.ChangeInfo)paramList.get(m);
      if ((a(localChangeInfo, paramViewHolder)) && (localChangeInfo.a == null) && (localChangeInfo.b == null)) {
        paramList.remove(localChangeInfo);
      }
      m -= 1;
    }
  }
  
  private boolean a(EnhanceItemAnimator.ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.b;
    boolean bool = false;
    if (localViewHolder == paramViewHolder)
    {
      paramChangeInfo.b = null;
    }
    else
    {
      if (paramChangeInfo.a != paramViewHolder) {
        return false;
      }
      paramChangeInfo.a = null;
      bool = true;
    }
    ViewCompat.setAlpha(paramViewHolder.itemView, 1.0F);
    ViewCompat.setScaleX(paramViewHolder.itemView, 1.0F);
    ViewCompat.setScaleY(paramViewHolder.itemView, 1.0F);
    ViewCompat.setTranslationX(paramViewHolder.itemView, 0.0F);
    ViewCompat.setTranslationY(paramViewHolder.itemView, 0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = ViewCompat.animate(paramViewHolder.itemView);
    this.h.add(paramViewHolder);
    localViewPropertyAnimatorCompat.alpha(1.0F).setDuration(getAddDuration()).translationX(0.0F).translationY(0.0F).setInterpolator(new DecelerateInterpolator()).setListener(new EnhanceItemAnimator.5(this, paramViewHolder, localViewPropertyAnimatorCompat)).start();
  }
  
  private void b(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    if (paramChangeInfo.a != null) {
      a(paramChangeInfo, paramChangeInfo.a);
    }
    if (paramChangeInfo.b != null) {
      a(paramChangeInfo, paramChangeInfo.b);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder)
  {
    AnimatorCompatHelper.a(paramViewHolder.itemView);
    endAnimation(paramViewHolder);
  }
  
  public void a(EnhanceItemAnimator.AddAnimationConfig paramAddAnimationConfig)
  {
    this.l = paramAddAnimationConfig;
  }
  
  void a(List<RecyclerView.ViewHolder> paramList)
  {
    int m = paramList.size() - 1;
    while (m >= 0)
    {
      ViewCompat.animate(((RecyclerView.ViewHolder)paramList.get(m)).itemView).cancel();
      m -= 1;
    }
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    Object localObject = paramViewHolder.itemView.getTag(2131444770);
    if (Boolean.TRUE.equals(localObject))
    {
      localObject = this.l;
      if (localObject != null)
      {
        if (((EnhanceItemAnimator.AddAnimationConfig)localObject).a == 2)
        {
          localObject = new int[2];
          paramViewHolder.itemView.getLocationOnScreen((int[])localObject);
          int m = this.l.b;
          m = paramViewHolder.itemView.getWidth() / 2;
          m = this.l.c;
          m = paramViewHolder.itemView.getHeight() / 2;
          animateMove(paramViewHolder, this.l.b, this.l.c, 0, 0);
          return true;
        }
      }
      else {
        ViewCompat.setAlpha(paramViewHolder.itemView, 0.0F);
      }
    }
    this.b.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramViewHolder1 == paramViewHolder2) {
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    EnhanceItemAnimator.ChangeInfo localChangeInfo = new EnhanceItemAnimator.ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4, null);
    float f1 = ViewCompat.getTranslationX(paramViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(paramViewHolder1.itemView);
    float f3 = ViewCompat.getAlpha(paramViewHolder1.itemView);
    paramInt1 = (int)(paramInt3 - paramInt1 - f1);
    paramInt2 = (int)(paramInt4 - paramInt2 - f2);
    c(paramViewHolder1);
    ViewCompat.setTranslationX(paramViewHolder1.itemView, f1);
    ViewCompat.setTranslationY(paramViewHolder1.itemView, f2);
    ViewCompat.setAlpha(paramViewHolder1.itemView, f3);
    if (paramViewHolder2 != null)
    {
      c(paramViewHolder2);
      boolean bool = false;
      if ((paramViewHolder2 instanceof EnhanceHolderAnimationInterface)) {
        bool = ((EnhanceHolderAnimationInterface)paramViewHolder2).a(localChangeInfo);
      }
      if (!bool)
      {
        ViewCompat.setTranslationX(paramViewHolder2.itemView, -paramInt1);
        ViewCompat.setTranslationY(paramViewHolder2.itemView, -paramInt2);
        ViewCompat.setScaleX(paramViewHolder2.itemView, 1.0F);
        ViewCompat.setScaleY(paramViewHolder2.itemView, 1.0F);
        ViewCompat.setAlpha(paramViewHolder2.itemView, 0.0F);
      }
    }
    this.d.add(localChangeInfo);
    return true;
  }
  
  public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    return super.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2);
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramViewHolder.itemView;
    paramInt1 = (int)(paramInt1 + ViewCompat.getTranslationX(paramViewHolder.itemView));
    paramInt2 = (int)(paramInt2 + ViewCompat.getTranslationY(paramViewHolder.itemView));
    c(paramViewHolder);
    int m = paramInt3 - paramInt1;
    int n = paramInt4 - paramInt2;
    if ((m == 0) && (n == 0))
    {
      dispatchMoveFinished(paramViewHolder);
      return false;
    }
    if (m != 0) {
      ViewCompat.setTranslationX(localView, -m);
    }
    if (n != 0) {
      ViewCompat.setTranslationY(localView, -n);
    }
    this.c.add(new EnhanceItemAnimator.MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4, null));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder)
  {
    c(paramViewHolder);
    this.a.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    ViewCompat.animate(localView).cancel();
    int m = this.c.size() - 1;
    while (m >= 0)
    {
      if (((EnhanceItemAnimator.MoveInfo)this.c.get(m)).a == paramViewHolder)
      {
        ViewCompat.setTranslationY(localView, 0.0F);
        ViewCompat.setTranslationX(localView, 0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.c.remove(m);
      }
      m -= 1;
    }
    a(this.d, paramViewHolder);
    if (this.a.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchRemoveFinished(paramViewHolder);
    }
    if (this.b.remove(paramViewHolder))
    {
      ViewCompat.setAlpha(localView, 1.0F);
      dispatchAddFinished(paramViewHolder);
    }
    m = this.g.size() - 1;
    ArrayList localArrayList;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.g.get(m);
      a(localArrayList, paramViewHolder);
      if (localArrayList.isEmpty()) {
        this.g.remove(m);
      }
      m -= 1;
    }
    m = this.f.size() - 1;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.f.get(m);
      int n = localArrayList.size() - 1;
      while (n >= 0)
      {
        if (((EnhanceItemAnimator.MoveInfo)localArrayList.get(n)).a == paramViewHolder)
        {
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(paramViewHolder);
          localArrayList.remove(n);
          if (!localArrayList.isEmpty()) {
            break;
          }
          this.f.remove(m);
          break;
        }
        n -= 1;
      }
      m -= 1;
    }
    m = this.e.size() - 1;
    while (m >= 0)
    {
      localArrayList = (ArrayList)this.e.get(m);
      if (localArrayList.remove(paramViewHolder))
      {
        ViewCompat.setAlpha(localView, 1.0F);
        dispatchAddFinished(paramViewHolder);
        if (localArrayList.isEmpty()) {
          this.e.remove(m);
        }
      }
      m -= 1;
    }
    this.j.remove(paramViewHolder);
    this.h.remove(paramViewHolder);
    this.k.remove(paramViewHolder);
    this.i.remove(paramViewHolder);
    a();
  }
  
  public void endAnimations()
  {
    int m = this.c.size() - 1;
    Object localObject1;
    Object localObject2;
    while (m >= 0)
    {
      localObject1 = (EnhanceItemAnimator.MoveInfo)this.c.get(m);
      localObject2 = ((EnhanceItemAnimator.MoveInfo)localObject1).a.itemView;
      ViewCompat.setTranslationY((View)localObject2, 0.0F);
      ViewCompat.setTranslationX((View)localObject2, 0.0F);
      dispatchMoveFinished(((EnhanceItemAnimator.MoveInfo)localObject1).a);
      this.c.remove(m);
      m -= 1;
    }
    m = this.a.size() - 1;
    while (m >= 0)
    {
      dispatchRemoveFinished((RecyclerView.ViewHolder)this.a.get(m));
      this.a.remove(m);
      m -= 1;
    }
    m = this.b.size() - 1;
    while (m >= 0)
    {
      localObject1 = (RecyclerView.ViewHolder)this.b.get(m);
      ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject1).itemView, 1.0F);
      dispatchAddFinished((RecyclerView.ViewHolder)localObject1);
      this.b.remove(m);
      m -= 1;
    }
    m = this.d.size() - 1;
    while (m >= 0)
    {
      b((EnhanceItemAnimator.ChangeInfo)this.d.get(m));
      m -= 1;
    }
    this.d.clear();
    if (isRunning())
    {
      m = this.f.size() - 1;
      int n;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.f.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          localObject2 = (EnhanceItemAnimator.MoveInfo)((ArrayList)localObject1).get(n);
          View localView = ((EnhanceItemAnimator.MoveInfo)localObject2).a.itemView;
          ViewCompat.setTranslationY(localView, 0.0F);
          ViewCompat.setTranslationX(localView, 0.0F);
          dispatchMoveFinished(((EnhanceItemAnimator.MoveInfo)localObject2).a);
          ((ArrayList)localObject1).remove(n);
          if (((ArrayList)localObject1).isEmpty()) {
            this.f.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      m = this.e.size() - 1;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.e.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          localObject2 = (RecyclerView.ViewHolder)((ArrayList)localObject1).get(n);
          ViewCompat.setAlpha(((RecyclerView.ViewHolder)localObject2).itemView, 1.0F);
          dispatchAddFinished((RecyclerView.ViewHolder)localObject2);
          ((ArrayList)localObject1).remove(n);
          if (((ArrayList)localObject1).isEmpty()) {
            this.e.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      m = this.g.size() - 1;
      while (m >= 0)
      {
        localObject1 = (ArrayList)this.g.get(m);
        n = ((ArrayList)localObject1).size() - 1;
        while (n >= 0)
        {
          b((EnhanceItemAnimator.ChangeInfo)((ArrayList)localObject1).get(n));
          if (((ArrayList)localObject1).isEmpty()) {
            this.g.remove(localObject1);
          }
          n -= 1;
        }
        m -= 1;
      }
      a(this.j);
      a(this.i);
      a(this.h);
      a(this.k);
      dispatchAnimationsFinished();
    }
  }
  
  public boolean isRunning()
  {
    return (!this.b.isEmpty()) || (!this.d.isEmpty()) || (!this.c.isEmpty()) || (!this.a.isEmpty()) || (!this.i.isEmpty()) || (!this.j.isEmpty()) || (!this.h.isEmpty()) || (!this.k.isEmpty()) || (!this.f.isEmpty()) || (!this.e.isEmpty()) || (!this.g.isEmpty());
  }
  
  public void onChangeFinished(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder.itemView instanceof EnhanceItemAnimationInterface)) {
      ((EnhanceItemAnimationInterface)paramViewHolder.itemView).onChangeFinished(paramBoolean);
    }
  }
  
  public void onChangeStarting(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder.itemView instanceof EnhanceItemAnimationInterface)) {
      ((EnhanceItemAnimationInterface)paramViewHolder.itemView).onChangeStarting(paramBoolean);
    }
  }
  
  public void onMoveFinished(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof EnhanceItemAnimationInterface)) {
      ((EnhanceItemAnimationInterface)paramViewHolder.itemView).onMoveFinished();
    }
  }
  
  public void onMoveStarting(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof EnhanceItemAnimationInterface)) {
      ((EnhanceItemAnimationInterface)paramViewHolder.itemView).onMoveStarting();
    }
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.a.isEmpty() ^ true;
    boolean bool2 = this.c.isEmpty() ^ true;
    boolean bool3 = this.d.isEmpty() ^ true;
    boolean bool4 = this.b.isEmpty() ^ true;
    if ((bool1) || (bool2) || (bool4) || (bool3))
    {
      Object localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((RecyclerView.ViewHolder)((Iterator)localObject1).next());
      }
      this.a.clear();
      Object localObject2;
      if (bool2)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.c);
        this.f.add(localObject1);
        this.c.clear();
        localObject2 = new EnhanceItemAnimator.1(this, (ArrayList)localObject1);
        if (bool1) {
          ViewCompat.postOnAnimationDelayed(((EnhanceItemAnimator.MoveInfo)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
        } else {
          ((Runnable)localObject2).run();
        }
      }
      if (bool3)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.d);
        this.g.add(localObject1);
        this.d.clear();
        localObject2 = new EnhanceItemAnimator.2(this, (ArrayList)localObject1);
        if (bool1) {
          ViewCompat.postOnAnimationDelayed(((EnhanceItemAnimator.ChangeInfo)((ArrayList)localObject1).get(0)).a.itemView, (Runnable)localObject2, getRemoveDuration());
        } else {
          ((Runnable)localObject2).run();
        }
      }
      if (bool4)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.b);
        this.e.add(localObject1);
        this.b.clear();
        localObject2 = new EnhanceItemAnimator.3(this, (ArrayList)localObject1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator
 * JD-Core Version:    0.7.0.1
 */