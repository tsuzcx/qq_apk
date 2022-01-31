package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.widget.StatusView;
import wpw;

public abstract class SubscribeBaseBottomPersonalFragment
  extends Fragment
{
  protected View a;
  protected ComponentPageView a;
  protected StatusView a;
  public wpw a;
  
  abstract ExtraTypeInfo a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(String paramString, wpw paramwpw);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558679, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371395));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376476));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(a());
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment
 * JD-Core Version:    0.7.0.1
 */