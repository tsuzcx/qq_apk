package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView;
import com.tencent.biz.pubaccount.readinjoy.view.SquareCornerTextImageView.PicInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class NativeGridImageView$Adapter
  extends BaseAdapter
{
  List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  List<SquareCornerTextImageView.PicInfo> b = new ArrayList();
  
  public NativeGridImageView$Adapter(NativeGridImageView paramNativeGridImageView) {}
  
  public List<URL> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NativeGridImageView.GridImageModel paramGridImageModel)
  {
    this.b = paramGridImageModel.a();
    this.jdField_a_of_type_JavaUtilList = paramGridImageModel.b();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Context localContext = paramViewGroup.getContext();
    if (paramView == null)
    {
      paramView = new SquareCornerTextImageView(localContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    }
    for (;;)
    {
      ((SquareCornerTextImageView)paramView).a((SquareCornerTextImageView.PicInfo)this.b.get(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView.Adapter
 * JD-Core Version:    0.7.0.1
 */