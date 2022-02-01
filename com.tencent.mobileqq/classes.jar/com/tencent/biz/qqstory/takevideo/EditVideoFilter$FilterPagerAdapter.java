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
import yuk;
import yww;
import ywx;
import zfy;
import zfz;
import zgj;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<zfz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<zfy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends zfz>, Queue<zfz>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private yww jdField_a_of_type_Yww;
  
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
  
  public zfy a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (zfy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public zfz a(int paramInt)
  {
    return (zfz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      zfy localzfy = (zfy)((Iterator)localObject).next();
      if (paramInt == localzfy.jdField_b_of_type_Int) {
        localzfy.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (zfz)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((zfz)localObject).jdField_a_of_type_Zfy.jdField_b_of_type_Int == paramInt) && ((localObject instanceof zgj)))
      {
        localObject = (zgj)localObject;
        ((zgj)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((zfz)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<zfy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(yww paramyww)
  {
    this.jdField_a_of_type_Yww = paramyww;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    zfz localzfz = (zfz)paramObject;
    paramViewGroup.removeView(localzfz.jdField_a_of_type_AndroidViewView);
    localzfz.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localzfz.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localzfz.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localzfz.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localzfz);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    zfy localzfy = a(paramInt);
    if (localzfy == null)
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localzfy.a());
    if (localObject1 != null) {}
    for (localObject1 = (zfz)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localzfy.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((zfz)localObject2).jdField_a_of_type_AndroidViewView);
      ((zfz)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new ywx(this.jdField_a_of_type_Yww));
      ((zfz)localObject2).a(localzfy, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof zfz)) && (((zfz)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */