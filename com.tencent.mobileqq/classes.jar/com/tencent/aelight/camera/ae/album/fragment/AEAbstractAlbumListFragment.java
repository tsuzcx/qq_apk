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
  public AEAbstractAlbumListFragment.IAlbumListBack a;
  public AEAlbumListLogic b;
  AlbumListBaseData c;
  FrameLayout d;
  public AEAlbumListAdapter e;
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
    this.f.setOnItemClickListener(new AEAbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.f.setOverScrollMode(2);
    this.f.setDivider(null);
    this.f.setVerticalScrollBarEnabled(false);
    this.d = ((FrameLayout)paramView.findViewById(2063990879));
    this.d.setOnClickListener(new AEAbstractAlbumListFragment.1(this));
    paramView.findViewById(2063990878).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AEAbstractAlbumListFragment.2(this, i, j));
    this.b.b();
  }
  
  protected abstract AEAlbumListLogic a();
  
  public void a(AEAbstractAlbumListFragment.IAlbumListBack paramIAlbumListBack)
  {
    this.a = paramIAlbumListBack;
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131627298, paramViewGroup, false);
    this.b = a();
    this.c = this.b.c;
    paramViewGroup = getActivity().getIntent();
    this.b.a(paramViewGroup);
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
    AEAlbumListLogic localAEAlbumListLogic = this.b;
    if (localAEAlbumListLogic != null) {
      localAEAlbumListLogic.ai_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */