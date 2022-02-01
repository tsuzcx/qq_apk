package com.tencent.aelight.camera.ae.album.fragment;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public abstract class AEAbstractAlbumListFragment
  extends Fragment
{
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public AEAlbumListAdapter a;
  public AEAbstractAlbumListFragment.IAlbumListBack a;
  public AEAlbumListLogic a;
  AlbumListBaseData jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData;
  XFrameLayout jdField_a_of_type_ComTencentWidgetXFrameLayout;
  public XListView a;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout = ((XFrameLayout)paramView.findViewById(2064122346));
    this.jdField_a_of_type_ComTencentWidgetXFrameLayout.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramView.findViewById(2064121941));
    this.jdField_a_of_type_ComTencentWidgetXListView.setWrapByScroll(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAdapterAEAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new AEAbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064121944));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEAbstractAlbumListFragment.1(this));
    paramView.findViewById(2064121943).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AEAbstractAlbumListFragment.2(this, i, j));
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic.b();
  }
  
  protected abstract AEAlbumListLogic a();
  
  public void a(AEAbstractAlbumListFragment.IAlbumListBack paramIAlbumListBack)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractAlbumListFragment$IAlbumListBack = paramIAlbumListBack;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560957, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic.a(paramViewGroup);
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
    AEAlbumListLogic localAEAlbumListLogic = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic;
    if (localAEAlbumListLogic != null) {
      localAEAlbumListLogic.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */