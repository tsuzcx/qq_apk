package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class SurvivalSeatBgPresenterImp
  implements ISurvivalSeatBgPresenter
{
  private SurvivalMemberDataSource a;
  private SurvivalSeatBgGridAdapter b;
  private List<Animator> c = new CopyOnWriteArrayList();
  
  private void b(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.2F, 0.5F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.2F, 0.5F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(2000L);
    localAnimatorSet.setStartDelay(1000L);
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator, paramView });
    localAnimatorSet.addListener(new SurvivalSeatBgPresenterImp.4(this));
    localAnimatorSet.start();
  }
  
  private boolean c()
  {
    Random localRandom = new Random();
    int i = localRandom.nextInt(50);
    int j = localRandom.nextInt(100);
    boolean bool = false;
    if (j % 101 + 0 < i % 31 + 20) {
      bool = true;
    }
    return bool;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelAllAnimation ");
      ((StringBuilder)localObject).append(this.c.size());
      QLog.d("SurvivalSeatBgPresenterImp", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Animator localAnimator = (Animator)((Iterator)localObject).next();
      localAnimator.cancel();
      this.c.remove(localAnimator);
    }
  }
  
  public void a(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.3F });
    paramView.setDuration(300L);
    paramView.addListener(new SurvivalSeatBgPresenterImp.3(this));
    paramView.start();
  }
  
  public void a(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.5F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(1000L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.addListener(new SurvivalSeatBgPresenterImp.1(this, paramAnimatorListener, paramView));
    localAnimatorSet.start();
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.b = ((SurvivalSeatBgGridAdapter)paramBaseAdapter);
  }
  
  public void a(SurvivalMemberDataSource paramSurvivalMemberDataSource)
  {
    this.a = paramSurvivalMemberDataSource;
  }
  
  public void a(List<Long> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (this.b == null) {
        return;
      }
      paramList = ((SurvivalMemberDataSource)localObject).a(paramList).iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        this.b.a(((Integer)localObject).intValue());
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((SurvivalMemberDataSource)localObject).a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((SurvivalSeatBgGridAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  public void b(View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.5F, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    localAnimatorSet.addListener(new SurvivalSeatBgPresenterImp.2(this, paramAnimatorListener));
    localAnimatorSet.start();
  }
  
  public void b(List<Long> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (this.b == null) {
        return;
      }
      paramList = ((SurvivalMemberDataSource)localObject).b(paramList).iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        this.b.a(((Integer)localObject).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp
 * JD-Core Version:    0.7.0.1
 */