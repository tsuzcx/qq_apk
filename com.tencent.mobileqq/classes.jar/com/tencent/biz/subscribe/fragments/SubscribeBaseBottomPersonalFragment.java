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
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public abstract class SubscribeBaseBottomPersonalFragment
  extends ReportV4Fragment
{
  protected View a;
  protected SubscribeBaseBottomPersonalFragment.BottomData a;
  protected BlockContainer a;
  protected StatusView a;
  
  abstract ExtraTypeInfo a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString, SubscribeBaseBottomPersonalFragment.BottomData paramBottomData);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558851, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131372891));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378457));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().a(2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(a());
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setLayoutManagerType(3, 2);
    a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
 * JD-Core Version:    0.7.0.1
 */