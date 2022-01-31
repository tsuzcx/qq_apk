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
import veg;
import vgs;
import vgt;
import vpu;
import vpv;
import vqf;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<vpv> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final List<vpu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<Class<? extends vpv>, Queue<vpv>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vgs jdField_a_of_type_Vgs;
  
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
  
  public vpu a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (vpu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public vpv a(int paramInt)
  {
    return (vpv)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      vpu localvpu = (vpu)((Iterator)localObject).next();
      if (paramInt == localvpu.jdField_b_of_type_Int) {
        localvpu.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (vpv)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((vpv)localObject).jdField_a_of_type_Vpu.jdField_b_of_type_Int == paramInt) && ((localObject instanceof vqf)))
      {
        localObject = (vqf)localObject;
        ((vqf)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((vpv)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<vpu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void a(vgs paramvgs)
  {
    this.jdField_a_of_type_Vgs = paramvgs;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    vpv localvpv = (vpv)paramObject;
    paramViewGroup.removeView(localvpv.jdField_a_of_type_AndroidViewView);
    localvpv.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localvpv.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvpv.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localvpv.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localvpv);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    vpu localvpu = a(paramInt);
    if (localvpu == null)
    {
      veg.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localvpu.a());
    if (localObject1 != null) {}
    for (localObject1 = (vpv)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localvpu.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((vpv)localObject2).jdField_a_of_type_AndroidViewView);
      ((vpv)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new vgt(this.jdField_a_of_type_Vgs));
      ((vpv)localObject2).a(localvpu, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof vpv)) && (((vpv)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */