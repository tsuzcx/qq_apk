package com.tencent.avgame.gameroom.seat.background;

import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.BaseAdapter;
import java.util.List;

public abstract interface ISurvivalSeatBgPresenter
{
  public abstract void a();
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void a(BaseAdapter paramBaseAdapter);
  
  public abstract void a(SurvivalMemberDataSource paramSurvivalMemberDataSource);
  
  public abstract void a(List<Long> paramList);
  
  public abstract void b();
  
  public abstract void b(View paramView, Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void b(List<Long> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.ISurvivalSeatBgPresenter
 * JD-Core Version:    0.7.0.1
 */