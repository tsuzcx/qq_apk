package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.filter.FilterData;
import com.tencent.biz.qqstory.takevideo.filter.FilterData.FilterPageItem;
import com.tencent.biz.qqstory.takevideo.filter.VideoEffectsFilterData.VideoEffectsFilterPageItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import oen;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private EditVideoFilter.ItemViewGestureListener jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$ItemViewGestureListener;
  private final List jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public EditVideoFilter$FilterPagerAdapter(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    return paramInt % this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @Nullable
  public FilterData.FilterPageItem a(int paramInt)
  {
    return (FilterData.FilterPageItem)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public FilterData a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FilterData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FilterData localFilterData = (FilterData)((Iterator)localObject).next();
      if (paramInt == localFilterData.jdField_b_of_type_Int) {
        localFilterData.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (FilterData.FilterPageItem)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((FilterData.FilterPageItem)localObject).jdField_a_of_type_ComTencentBizQqstoryTakevideoFilterFilterData.jdField_b_of_type_Int == paramInt) && ((localObject instanceof VideoEffectsFilterData.VideoEffectsFilterPageItem)))
      {
        localObject = (VideoEffectsFilterData.VideoEffectsFilterPageItem)localObject;
        ((VideoEffectsFilterData.VideoEffectsFilterPageItem)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((FilterData.FilterPageItem)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(EditVideoFilter.ItemViewGestureListener paramItemViewGestureListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$ItemViewGestureListener = paramItemViewGestureListener;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    FilterData.FilterPageItem localFilterPageItem = (FilterData.FilterPageItem)paramObject;
    paramViewGroup.removeView(localFilterPageItem.jdField_a_of_type_AndroidViewView);
    localFilterPageItem.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localFilterPageItem.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localFilterPageItem.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localFilterPageItem.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localFilterPageItem);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    FilterData localFilterData = a(paramInt);
    if (localFilterData == null)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localFilterData.a());
    if (localObject1 != null) {}
    for (localObject1 = (FilterData.FilterPageItem)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localFilterData.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((FilterData.FilterPageItem)localObject2).jdField_a_of_type_AndroidViewView);
      ((FilterData.FilterPageItem)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new oen(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$ItemViewGestureListener));
      ((FilterData.FilterPageItem)localObject2).a(localFilterData, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof FilterData.FilterPageItem)) && (((FilterData.FilterPageItem)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */