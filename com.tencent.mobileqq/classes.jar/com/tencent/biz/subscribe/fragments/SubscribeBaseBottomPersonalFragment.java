package com.tencent.biz.subscribe.fragments;

import aabj;
import aaks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public abstract class SubscribeBaseBottomPersonalFragment
  extends ReportV4Fragment
{
  public aaks a;
  protected View a;
  protected BlockContainer a;
  protected StatusView a;
  
  abstract ExtraTypeInfo a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString, aaks paramaaks);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558778, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131372417));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377987));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().a(2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(a());
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
 * JD-Core Version:    0.7.0.1
 */