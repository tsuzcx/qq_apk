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
  public AECircleAlbumListFragment.IAlbumListBack a;
  public AECircleAlbumListLogic b;
  AlbumListBaseData c;
  FrameLayout d;
  public AlbumListAdapter e;
  public XListView f;
  XFrameLayout g;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.g = ((XFrameLayout)paramView.findViewById(2063991219));
    this.g.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.f = ((XListView)paramView.findViewById(2063990876));
    this.f.setWrapByScroll(true);
    this.f.setAdapter(this.e);
    this.f.setOnItemClickListener(new AECircleAlbumListFragment.AlbumListItemClickListener(this, null));
    this.f.setOverScrollMode(2);
    this.f.setVerticalScrollBarEnabled(false);
    this.d = ((FrameLayout)paramView.findViewById(2063990879));
    this.d.setOnClickListener(new AECircleAlbumListFragment.1(this));
    paramView.findViewById(2063990878).setVisibility(8);
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
    this.a = paramIAlbumListBack;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2064056510, paramViewGroup, false);
    this.b = a();
    this.c = this.b.c;
    paramViewGroup = getActivity().getIntent();
    this.b.a(paramViewGroup);
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    AECircleAlbumListLogic localAECircleAlbumListLogic = this.b;
    if (localAECircleAlbumListLogic != null) {
      localAECircleAlbumListLogic.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */