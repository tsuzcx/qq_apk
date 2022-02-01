package com.tencent.mobileqq.activity.photo.album;

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
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public abstract class AbstractAlbumListFragment
  extends ReportV4Fragment
{
  public static final String TAG = "AlbumListFragment";
  public AbstractAlbumListFragment.IAlbumListChoose albumListChoose;
  ImageView albumListMask;
  FrameLayout albumListRoot;
  public AlbumListAdapter listAdapter;
  AlbumListBaseData mAlbumListData;
  AlbumListLogic mAlbumListLogic;
  XListView mListView;
  XFrameLayout xListLayout;
  
  @TargetApi(14)
  private void initUI(View paramView)
  {
    this.xListLayout = ((XFrameLayout)paramView.findViewById(2131370209));
    this.xListLayout.setCornerRadiusAndMode(20, 5);
    this.mListView = ((XListView)paramView.findViewById(2131362585));
    this.mListView.setWrapByScroll(true);
    this.mListView.setAdapter(this.listAdapter);
    this.mListView.setOnItemClickListener(new AbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.mListView.setOverScrollMode(2);
    this.albumListRoot = ((FrameLayout)paramView.findViewById(2131362616));
    this.albumListRoot.setOnClickListener(new AbstractAlbumListFragment.1(this));
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AbstractAlbumListFragment.2(this, i, j));
    this.mAlbumListLogic.postInitUI();
  }
  
  protected AlbumListLogic generateLogic()
  {
    return new AlbumListLogicBase(this);
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
      localTranslateAnimation.setAnimationListener(new AbstractAlbumListFragment.3(this));
      return localTranslateAnimation;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561007, paramViewGroup, false);
    this.mAlbumListLogic = generateLogic();
    this.mAlbumListData = this.mAlbumListLogic.mAlbumListData;
    paramViewGroup = getActivity().getIntent();
    this.albumListChoose = ((AbstractAlbumListFragment.IAlbumListChoose)getActivity());
    this.mAlbumListLogic.initData(paramViewGroup);
    initUI(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mAlbumListLogic != null) {
      this.mAlbumListLogic.close();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      this.listAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */