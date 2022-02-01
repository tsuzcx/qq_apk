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
import ykq;
import yna;
import ynb;
import yvr;
import yvs;
import ywc;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<yvs> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<yvr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends yvs>, Queue<yvs>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private yna jdField_a_of_type_Yna;
  
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
  
  public yvr a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (yvr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public yvs a(int paramInt)
  {
    return (yvs)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      yvr localyvr = (yvr)((Iterator)localObject).next();
      if (paramInt == localyvr.jdField_b_of_type_Int) {
        localyvr.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (yvs)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((yvs)localObject).jdField_a_of_type_Yvr.jdField_b_of_type_Int == paramInt) && ((localObject instanceof ywc)))
      {
        localObject = (ywc)localObject;
        ((ywc)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((yvs)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<yvr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(yna paramyna)
  {
    this.jdField_a_of_type_Yna = paramyna;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    yvs localyvs = (yvs)paramObject;
    paramViewGroup.removeView(localyvs.jdField_a_of_type_AndroidViewView);
    localyvs.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localyvs.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localyvs.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localyvs.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localyvs);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    yvr localyvr = a(paramInt);
    if (localyvr == null)
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localyvr.a());
    if (localObject1 != null) {}
    for (localObject1 = (yvs)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localyvr.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((yvs)localObject2).jdField_a_of_type_AndroidViewView);
      ((yvs)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new ynb(this.jdField_a_of_type_Yna));
      ((yvs)localObject2).a(localyvr, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof yvs)) && (((yvs)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */