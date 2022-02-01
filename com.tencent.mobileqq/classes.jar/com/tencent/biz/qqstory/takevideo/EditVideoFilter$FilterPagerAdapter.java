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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import xvv;
import xyh;
import xyi;
import ygy;
import ygz;
import yhj;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<ygz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<ygy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends ygz>, Queue<ygz>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private xyh jdField_a_of_type_Xyh;
  
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
  
  public ygy a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (ygy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public ygz a(int paramInt)
  {
    return (ygz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ygy localygy = (ygy)((Iterator)localObject).next();
      if (paramInt == localygy.jdField_b_of_type_Int) {
        localygy.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (ygz)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((ygz)localObject).jdField_a_of_type_Ygy.jdField_b_of_type_Int == paramInt) && ((localObject instanceof yhj)))
      {
        localObject = (yhj)localObject;
        ((yhj)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((ygz)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<ygy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(xyh paramxyh)
  {
    this.jdField_a_of_type_Xyh = paramxyh;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ygz localygz = (ygz)paramObject;
    paramViewGroup.removeView(localygz.jdField_a_of_type_AndroidViewView);
    localygz.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localygz.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localygz.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localygz.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localygz);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ygy localygy = a(paramInt);
    if (localygy == null)
    {
      xvv.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localygy.a());
    if (localObject1 != null) {}
    for (localObject1 = (ygz)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localygy.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((ygz)localObject2).jdField_a_of_type_AndroidViewView);
      ((ygz)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new xyi(this.jdField_a_of_type_Xyh));
      ((ygz)localObject2).a(localygy, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof ygz)) && (((ygz)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */