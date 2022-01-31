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
import urk;
import utw;
import utx;
import vcy;
import vcz;
import vdj;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<vcz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<vcy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends vcz>, Queue<vcz>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private utw jdField_a_of_type_Utw;
  
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
  
  public vcy a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (vcy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public vcz a(int paramInt)
  {
    return (vcz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      vcy localvcy = (vcy)((Iterator)localObject).next();
      if (paramInt == localvcy.jdField_b_of_type_Int) {
        localvcy.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (vcz)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((vcz)localObject).jdField_a_of_type_Vcy.jdField_b_of_type_Int == paramInt) && ((localObject instanceof vdj)))
      {
        localObject = (vdj)localObject;
        ((vdj)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((vcz)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<vcy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(utw paramutw)
  {
    this.jdField_a_of_type_Utw = paramutw;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    vcz localvcz = (vcz)paramObject;
    paramViewGroup.removeView(localvcz.jdField_a_of_type_AndroidViewView);
    localvcz.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localvcz.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvcz.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localvcz.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localvcz);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    vcy localvcy = a(paramInt);
    if (localvcy == null)
    {
      urk.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvcy.a());
    if (localObject1 != null) {}
    for (localObject1 = (vcz)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localvcy.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((vcz)localObject2).jdField_a_of_type_AndroidViewView);
      ((vcz)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new utx(this.jdField_a_of_type_Utw));
      ((vcz)localObject2).a(localvcy, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof vcz)) && (((vcz)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */