package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public abstract class SubscribeBaseBottomPersonalFragment
  extends BaseFragment
{
  protected View a;
  protected BlockContainer b;
  protected SubscribeBaseBottomPersonalFragment.BottomData c;
  protected StatusView d;
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData);
  
  abstract ExtraTypeInfo b();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = paramLayoutInflater.inflate(2131624369, paramViewGroup, false);
    this.b = ((BlockContainer)this.a.findViewById(2131440000));
    this.d = ((StatusView)this.a.findViewById(2131446348));
    this.b.getRecyclerView().setNestedScrollingEnabled(true);
    this.b.getBlockMerger().b(2);
    this.b.setEnableRefresh(false);
    this.b.setEnableLoadMore(true);
    this.b.setExtraTypeInfo(b());
    this.b.setParentFragment(this);
    this.b.setLayoutManagerType(3, 2);
    a();
    paramLayoutInflater = this.a;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
 * JD-Core Version:    0.7.0.1
 */