package com.tencent.mobileqq.activity.photo.album;

import agrb;
import agrd;
import agre;
import agrf;
import agrg;
import agrh;
import agrm;
import aguq;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public class AlbumListFragment
  extends Fragment
{
  agrb jdField_a_of_type_Agrb;
  public agrg a;
  public agrh a;
  public agrm a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  XFrameLayout jdField_a_of_type_ComTencentWidgetXFrameLayout;
  public XListView a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362473));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2131369294));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(20, 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131362443));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agrm);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new agrf(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362474));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new agrd(this));
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new agre(this, i, j));
    this.jdField_a_of_type_Agrh.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);; localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F))
    {
      localTranslateAnimation.setDuration(300L);
      return localTranslateAnimation;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560639, paramViewGroup, false);
    this.jdField_a_of_type_Agrh = aguq.a(getActivity().getIntent().getIntExtra("enter_from", 0), this);
    this.jdField_a_of_type_Agrb = this.jdField_a_of_type_Agrh.jdField_a_of_type_Agrb;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Agrg = ((agrg)getActivity());
    this.jdField_a_of_type_Agrh.a(paramViewGroup);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Agrh != null) {
      this.jdField_a_of_type_Agrh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListFragment
 * JD-Core Version:    0.7.0.1
 */