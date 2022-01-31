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
import ved;
import vgp;
import vgq;
import vpr;
import vps;
import vqc;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<vps> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<vpr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends vps>, Queue<vps>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vgp jdField_a_of_type_Vgp;
  
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
  
  public vpr a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (vpr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public vps a(int paramInt)
  {
    return (vps)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      vpr localvpr = (vpr)((Iterator)localObject).next();
      if (paramInt == localvpr.jdField_b_of_type_Int) {
        localvpr.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (vps)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((vps)localObject).jdField_a_of_type_Vpr.jdField_b_of_type_Int == paramInt) && ((localObject instanceof vqc)))
      {
        localObject = (vqc)localObject;
        ((vqc)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((vps)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<vpr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(vgp paramvgp)
  {
    this.jdField_a_of_type_Vgp = paramvgp;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    vps localvps = (vps)paramObject;
    paramViewGroup.removeView(localvps.jdField_a_of_type_AndroidViewView);
    localvps.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localvps.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvps.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localvps.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localvps);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    vpr localvpr = a(paramInt);
    if (localvpr == null)
    {
      ved.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvpr.a());
    if (localObject1 != null) {}
    for (localObject1 = (vps)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localvpr.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((vps)localObject2).jdField_a_of_type_AndroidViewView);
      ((vps)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new vgq(this.jdField_a_of_type_Vgp));
      ((vps)localObject2).a(localvpr, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof vps)) && (((vps)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */