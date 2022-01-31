package com.tencent.mobileqq.activity.photo.album;

import agff;
import agfg;
import agfh;
import agfi;
import agfj;
import agfk;
import agfp;
import agih;
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
  agff jdField_a_of_type_Agff;
  public agfj a;
  public agfk a;
  public agfp a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  XFrameLayout jdField_a_of_type_ComTencentWidgetXFrameLayout;
  public XListView a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296933));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2131303624));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(20, 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131296903));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agfp);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new agfi(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131296934));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new agfg(this));
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new agfh(this, i, j));
    this.jdField_a_of_type_Agfk.b();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131495065, paramViewGroup, false);
    this.jdField_a_of_type_Agfk = agih.a(getActivity().getIntent().getIntExtra("enter_from", 0), this);
    this.jdField_a_of_type_Agff = this.jdField_a_of_type_Agfk.jdField_a_of_type_Agff;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Agfj = ((agfj)getActivity());
    this.jdField_a_of_type_Agfk.a(paramViewGroup);
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
    if (this.jdField_a_of_type_Agfk != null) {
      this.jdField_a_of_type_Agfk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AlbumListFragment
 * JD-Core Version:    0.7.0.1
 */