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
import wsv;
import wvh;
import wvi;
import xej;
import xek;
import xeu;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<xek> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<xej> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends xek>, Queue<xek>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wvh jdField_a_of_type_Wvh;
  
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
  
  public xej a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (xej)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public xek a(int paramInt)
  {
    return (xek)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xej localxej = (xej)((Iterator)localObject).next();
      if (paramInt == localxej.jdField_b_of_type_Int) {
        localxej.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (xek)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((xek)localObject).jdField_a_of_type_Xej.jdField_b_of_type_Int == paramInt) && ((localObject instanceof xeu)))
      {
        localObject = (xeu)localObject;
        ((xeu)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((xek)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<xej> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(wvh paramwvh)
  {
    this.jdField_a_of_type_Wvh = paramwvh;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    xek localxek = (xek)paramObject;
    paramViewGroup.removeView(localxek.jdField_a_of_type_AndroidViewView);
    localxek.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localxek.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localxek.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localxek.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localxek);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    xej localxej = a(paramInt);
    if (localxej == null)
    {
      wsv.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localxej.a());
    if (localObject1 != null) {}
    for (localObject1 = (xek)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localxej.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((xek)localObject2).jdField_a_of_type_AndroidViewView);
      ((xek)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new wvi(this.jdField_a_of_type_Wvh));
      ((xek)localObject2).a(localxej, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof xek)) && (((xek)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */