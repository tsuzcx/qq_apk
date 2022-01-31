package com.tencent.biz.qqstory.storyHome.memory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import oce;

@TargetApi(9)
public class MemoriesInnerListView
  extends HorizontalListView
{
  protected int a;
  public MemoriesInnerListView.OnInnerListRefreshListener a;
  private MemoriesInnerListAdapter a;
  protected int b;
  
  public MemoriesInnerListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MemoriesInnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.b = DisplayUtil.a(paramContext, 82.0F);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter = new MemoriesInnerListAdapter(getContext());
    super.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter);
    super.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter);
    super.setOnScrollStateChangedListener(new oce(this));
    setOverScrollMode(1);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter;
  }
  
  public void setDate(List paramList, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter.a(paramList, paramString);
    int i = this.jdField_a_of_type_Int / this.b;
    if (paramList.size() >= i)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.MemoriesInnerListView
 * JD-Core Version:    0.7.0.1
 */