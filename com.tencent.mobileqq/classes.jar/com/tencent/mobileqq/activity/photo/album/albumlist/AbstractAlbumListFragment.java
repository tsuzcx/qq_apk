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
  public IAlbumListChoose a;
  public AlbumListAdapter b;
  public AlbumListCustomization<? extends OtherCommonData> c;
  public AlbumListBaseData d;
  public FrameLayout e;
  public XListView f;
  public XFrameLayout g;
  
  @TargetApi(14)
  private void a(View paramView)
  {
    this.g = ((XFrameLayout)paramView.findViewById(2131437304));
    this.g.setCornerRadiusAndMode(20, 5);
    this.f = ((XListView)paramView.findViewById(2131428186));
    this.f.setWrapByScroll(true);
    this.f.setAdapter(this.b);
    this.f.setOnItemClickListener(new AbstractAlbumListFragment.AlbumListItemClickListener(this, null));
    this.f.setOverScrollMode(2);
    this.e = ((FrameLayout)paramView.findViewById(2131428217));
    this.e.setOnClickListener(new AbstractAlbumListFragment.1(this));
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new AbstractAlbumListFragment.2(this, i, j));
    this.c.h();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131627298, paramViewGroup, false);
    this.c = a();
    this.d = this.c.f;
    paramViewGroup = getActivity().getIntent();
    this.c.a(paramViewGroup);
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
    AlbumListCustomization localAlbumListCustomization = this.c;
    if (localAlbumListCustomization != null) {
      localAlbumListCustomization.g();
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      this.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment
 * JD-Core Version:    0.7.0.1
 */