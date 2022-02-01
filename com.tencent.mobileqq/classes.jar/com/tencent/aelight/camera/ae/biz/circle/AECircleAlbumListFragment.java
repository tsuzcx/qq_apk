package com.tencent.aelight.camera.ae.biz.circle;

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
import com.tencent.aelight.camera.ae.biz.circle.adapter.AlbumListAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListBaseData;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public class AECircleAlbumListFragment
  extends Fragment
{
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public AECircleAlbumListFragment.IAlbumListBack a;
  public AECircleAlbumListLogic a;
  public AlbumListAdapter a;
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
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new AECircleAlbumListFragment.AlbumListItemClickListener(this, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064121944));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AECircleAlbumListFragment.1(this));
    paramView.findViewById(2064121943).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AECircleAlbumListFragment.2(this, i, j));
  }
  
  protected AECircleAlbumListLogic a()
  {
    return new AECircleAlbumListLogic(this);
  }
  
  public void a(AECircleAlbumListFragment.IAlbumListBack paramIAlbumListBack)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment$IAlbumListBack = paramIAlbumListBack;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2064318680, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListLogic = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListBaseData = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListLogic.a;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListLogic.a(paramViewGroup);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    AECircleAlbumListLogic localAECircleAlbumListLogic = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListLogic;
    if (localAECircleAlbumListLogic != null) {
      localAECircleAlbumListLogic.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */