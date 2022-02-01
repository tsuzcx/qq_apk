package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BetterGestureDetector;

public class PlayerGestureGroupHolder
  extends GroupHolderBase
{
  public ImageView a;
  private PlayerGestureGroupHolder.OnViewPagerGestureListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerGestureGroupHolder$OnViewPagerGestureListener;
  private BetterGestureDetector jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector;
  private boolean c = false;
  
  public PlayerGestureGroupHolder(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    SLog.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380701));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new PlayerGestureGroupHolder.ViewPagerTouchListener(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerGestureGroupHolder$OnViewPagerGestureListener = new PlayerGestureGroupHolder.OnViewPagerGestureListener(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector = new BetterGestureDetector(a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetPlayerGestureGroupHolder$OnViewPagerGestureListener);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsBetterGestureDetector.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerGestureGroupHolder
 * JD-Core Version:    0.7.0.1
 */