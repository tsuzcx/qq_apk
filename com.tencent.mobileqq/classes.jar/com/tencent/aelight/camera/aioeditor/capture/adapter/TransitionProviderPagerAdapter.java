package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class TransitionProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = ViewUtils.b(0.0F);
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray<GridView> a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private ArrayList<FilterCategory> jdField_a_of_type_JavaUtilArrayList;
  public int c;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(7.0F);
  }
  
  public TransitionProviderPagerAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        GridView localGridView = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localGridView != null) && ((localGridView.getAdapter() instanceof TransitionProviderGridAdapter))) {
          ((TransitionProviderGridAdapter)localGridView.getAdapter()).b();
        }
        i += 1;
      }
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(ArrayList<FilterCategory> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        GridView localGridView = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localGridView != null) && ((localGridView.getAdapter() instanceof TransitionProviderGridAdapter))) {
          ((TransitionProviderGridAdapter)localGridView.getAdapter()).a();
        }
        i += 1;
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("TransitionProviderPagerAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.jdField_a_of_type_AndroidContentContext);
      ((GridView)localObject1).setNumColumns(3);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setClipToPadding(false);
      int i = jdField_a_of_type_Int;
      ((GridView)localObject1).setPadding(i, i, i, i + i + AIOUtils.b(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new TransitionProviderGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.c);
      ((TransitionProviderGridAdapter)localObject2).a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */