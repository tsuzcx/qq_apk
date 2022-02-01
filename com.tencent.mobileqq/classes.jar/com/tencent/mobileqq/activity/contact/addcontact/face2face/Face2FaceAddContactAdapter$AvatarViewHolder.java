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
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  String jdField_a_of_type_JavaLangString;
  
  public Face2FaceAddContactAdapter$AvatarViewHolder(Face2FaceAddContactAdapter paramFace2FaceAddContactAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131376844));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371697));
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    Face2FaceAddContactAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter).add(this.jdField_a_of_type_JavaLangString);
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
    if (paramView.getId() == 2131368343) {
      Face2FaceAddContactAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactAdapter.AvatarViewHolder
 * JD-Core Version:    0.7.0.1
 */