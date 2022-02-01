package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;

public class LoadingMoreHelper
{
  protected int a;
  Context a;
  protected LoadingMoreHelper.OnLoadMoreListener a;
  protected ILoadMoreLayout a;
  protected boolean a;
  
  public LoadingMoreHelper(ILoadMoreLayout paramILoadMoreLayout, Context paramContext)
  {
    this.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout = paramILoadMoreLayout;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener = paramOnLoadMoreListener;
    if (paramOnLoadMoreListener != null)
    {
      a(true);
      a(true, false);
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setOnClickListener(new LoadingMoreHelper.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setState(3);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setState(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setState(5);
      return;
    }
    int i;
    if (paramBoolean2) {
      i = 3;
    } else {
      i = 4;
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setState(i);
    if (!this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.checkState(i)) {
      return;
    }
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener;
    if (localOnLoadMoreListener != null) {
      localOnLoadMoreListener.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.getState() == 0) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.checkState(2)) {
      return;
    }
    boolean bool = true;
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadingMoreHelper$OnLoadMoreListener;
    if (localOnLoadMoreListener != null) {
      bool = localOnLoadMoreListener.a(paramBoolean);
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshILoadMoreLayout.setState(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadingMoreHelper
 * JD-Core Version:    0.7.0.1
 */