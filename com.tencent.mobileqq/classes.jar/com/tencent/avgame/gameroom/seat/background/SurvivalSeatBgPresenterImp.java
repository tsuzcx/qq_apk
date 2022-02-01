package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class SurvivalSeatBgPresenterImp
  implements ISurvivalSeatBgPresenter
{
  private SurvivalMemberDataSource jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource;
  private SurvivalSeatBgGridAdapter jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter;
  private List<Animator> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  private boolean a()
  {
    boolean bool = false;
    Random localRandom = new Random();
    int i = localRandom.nextInt(50);
    if (localRandom.nextInt(100) % 101 + 0 < 20 + i % 31) {
      bool = true;
    }
    return bool;
  }
  
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
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SurvivalSeatBgPresenterImp", 4, "cancelAllAnimation " + this.jdField_a_of_type_JavaUtilList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      localAnimator.cancel();
      this.jdField_a_of_type_JavaUtilList.remove(localAnimator);
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
  
  public void a(SurvivalMemberDataSource paramSurvivalMemberDataSource)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource = paramSurvivalMemberDataSource;
  }
  
  public void a(SurvivalSeatBgGridAdapter paramSurvivalSeatBgGridAdapter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter = paramSurvivalSeatBgGridAdapter;
  }
  
  public void a(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter == null)) {}
    for (;;)
    {
      return;
      paramList = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a(paramList).iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter.a(localInteger.intValue());
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.a();
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter.notifyDataSetChanged();
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
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter == null)) {}
    for (;;)
    {
      return;
      paramList = this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalMemberDataSource.b(paramList).iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatBackgroundSurvivalSeatBgGridAdapter.a(localInteger.intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalSeatBgPresenterImp
 * JD-Core Version:    0.7.0.1
 */