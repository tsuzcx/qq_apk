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
import wxe;
import wzq;
import wzr;
import xis;
import xit;
import xjd;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<xit> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<xis> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends xit>, Queue<xit>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private wzq jdField_a_of_type_Wzq;
  
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
  
  public xis a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (xis)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public xit a(int paramInt)
  {
    return (xit)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      xis localxis = (xis)((Iterator)localObject).next();
      if (paramInt == localxis.jdField_b_of_type_Int) {
        localxis.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (xit)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((xit)localObject).jdField_a_of_type_Xis.jdField_b_of_type_Int == paramInt) && ((localObject instanceof xjd)))
      {
        localObject = (xjd)localObject;
        ((xjd)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((xit)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<xis> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(wzq paramwzq)
  {
    this.jdField_a_of_type_Wzq = paramwzq;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    xit localxit = (xit)paramObject;
    paramViewGroup.removeView(localxit.jdField_a_of_type_AndroidViewView);
    localxit.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localxit.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localxit.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localxit.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localxit);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    xis localxis = a(paramInt);
    if (localxis == null)
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localxis.a());
    if (localObject1 != null) {}
    for (localObject1 = (xit)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localxis.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((xit)localObject2).jdField_a_of_type_AndroidViewView);
      ((xit)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new wzr(this.jdField_a_of_type_Wzq));
      ((xit)localObject2).a(localxis, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof xit)) && (((xit)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */