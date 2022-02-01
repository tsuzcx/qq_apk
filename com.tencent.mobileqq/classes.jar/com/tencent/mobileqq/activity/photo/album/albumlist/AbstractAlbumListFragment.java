package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public class AbstractAlbumListFragment
  extends QBaseFragment
{
  public FrameLayout a;
  public AlbumListAdapter a;
  public AlbumListBaseData a;
  public AlbumListCustomization<? extends OtherCommonData> a;
  public IAlbumListChoose a;
  public XFrameLayout a;
  public XListView a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2131370141));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(20, 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2131362572));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new AbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131362603));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AbstractAlbumListFragment.1(this));
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AbstractAlbumListFragment.2(this, i, j));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization.b();
  }
  
  protected AlbumListCustomization<? extends OtherCommonData> a()
  {
    return new AlbumListCustomizationBase(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    TranslateAnimation localTranslateAnimation;
    if (paramBoolean) {
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    } else {
      localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    }
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener(new AbstractAlbumListFragment.3(this));
    return localTranslateAnimation;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560957, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization.a(paramViewGroup);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    AlbumListCustomization localAlbumListCustomization = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization;
    if (localAlbumListCustomization != null) {
      localAlbumListCustomization.a();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */