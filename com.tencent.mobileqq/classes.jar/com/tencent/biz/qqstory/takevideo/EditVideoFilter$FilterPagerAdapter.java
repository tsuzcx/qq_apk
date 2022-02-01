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
import yqp;
import ytb;
import ytc;
import zcd;
import zce;
import zco;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<zce> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<zcd> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends zce>, Queue<zce>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ytb jdField_a_of_type_Ytb;
  
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
  
  public zcd a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (zcd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public zce a(int paramInt)
  {
    return (zce)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      zcd localzcd = (zcd)((Iterator)localObject).next();
      if (paramInt == localzcd.jdField_b_of_type_Int) {
        localzcd.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (zce)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((zce)localObject).jdField_a_of_type_Zcd.jdField_b_of_type_Int == paramInt) && ((localObject instanceof zco)))
      {
        localObject = (zco)localObject;
        ((zco)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((zce)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<zcd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(ytb paramytb)
  {
    this.jdField_a_of_type_Ytb = paramytb;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    zce localzce = (zce)paramObject;
    paramViewGroup.removeView(localzce.jdField_a_of_type_AndroidViewView);
    localzce.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localzce.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localzce.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localzce.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localzce);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    zcd localzcd = a(paramInt);
    if (localzcd == null)
    {
      yqp.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localzcd.a());
    if (localObject1 != null) {}
    for (localObject1 = (zce)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localzcd.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((zce)localObject2).jdField_a_of_type_AndroidViewView);
      ((zce)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new ytc(this.jdField_a_of_type_Ytb));
      ((zce)localObject2).a(localzcd, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof zce)) && (((zce)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */