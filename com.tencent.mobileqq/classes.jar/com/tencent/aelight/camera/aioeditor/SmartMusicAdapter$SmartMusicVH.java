package com.tencent.aelight.camera.aioeditor;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SmartMusicAdapter$SmartMusicVH
  extends RecyclerView.ViewHolder
{
  private final View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public SmartMusicAdapter$SmartMusicVH(SmartMusicAdapter paramSmartMusicAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122329));
    this.b = paramView.findViewById(2064122214);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122445);
  }
  
  private RotateAnimation a()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(3000L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    return localRotateAnimation;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.b.getVisibility() == 8) {
        this.b.setVisibility(0);
      }
    }
    else if (this.b.getVisibility() == 0)
    {
      this.b.setVisibility(8);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c()
  {
    b(true);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.SmartMusicVH
 * JD-Core Version:    0.7.0.1
 */