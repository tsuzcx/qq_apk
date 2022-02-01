package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class Face2FaceAddContactAdapter$AvatarViewHolder
  extends RecyclerView.ViewHolder
  implements Animator.AnimatorListener, View.OnClickListener
{
  String a;
  ImageView b;
  TextView c;
  DiniFlyAnimationView d;
  
  public Face2FaceAddContactAdapter$AvatarViewHolder(Face2FaceAddContactAdapter paramFace2FaceAddContactAdapter, View paramView)
  {
    super(paramView);
    this.d = ((DiniFlyAnimationView)paramView.findViewById(2131445176));
    this.b = ((ImageView)paramView.findViewById(2131435219));
    this.c = ((TextView)paramView.findViewById(2131439121));
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.d.setVisibility(4);
    this.d.cancelAnimation();
    this.b.setAlpha(1.0F);
    Face2FaceAddContactAdapter.a(this.e).add(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435219) {
      Face2FaceAddContactAdapter.a(this.e, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactAdapter.AvatarViewHolder
 * JD-Core Version:    0.7.0.1
 */