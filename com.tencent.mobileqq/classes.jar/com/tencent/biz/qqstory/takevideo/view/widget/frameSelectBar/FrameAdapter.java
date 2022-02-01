package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FrameAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLoader jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader;
  private int b;
  private int c;
  
  public FrameAdapter(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public Bitmap a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(FrameLoader paramFrameLoader)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader = paramFrameLoader;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      float f = TakeVideoUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources());
      int i = this.b;
      paramView = new ViewGroup.LayoutParams(i, (int)(f * i));
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setLayoutParams(paramView);
      paramView = new FrameAdapter.Holder();
      paramView.a = ((ImageView)localObject);
      paramView.a.setImageDrawable(new ColorDrawable(-12303292));
      ((View)localObject).setTag(paramView);
    }
    else
    {
      FrameAdapter.Holder localHolder = (FrameAdapter.Holder)paramView.getTag();
      localObject = paramView;
      paramView = localHolder;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader.a(paramView.a, Integer.valueOf(paramInt));
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */