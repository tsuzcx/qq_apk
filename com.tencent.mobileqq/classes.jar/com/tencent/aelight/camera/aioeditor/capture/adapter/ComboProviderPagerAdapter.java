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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class ComboProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a = AIOUtils.b(7.0F, BaseApplication.getContext().getResources());
  public static final int b = AIOUtils.b(0.0F, BaseApplication.getContext().getResources());
  public SparseArray<GridView> c = new SparseArray();
  int d;
  private Context e;
  private ArrayList<FilterCategory> f;
  private AdapterView.OnItemClickListener g;
  
  public ComboProviderPagerAdapter(Context paramContext, int paramInt)
  {
    this.d = paramInt;
    this.e = paramContext;
  }
  
  public GridView a(int paramInt)
  {
    return (GridView)this.c.get(paramInt);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.g = paramOnItemClickListener;
  }
  
  public void a(ArrayList<FilterCategory> paramArrayList)
  {
    this.f = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.c.get(paramInt));
  }
  
  public int getCount()
  {
    return this.f.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ComboProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (GridView)this.c.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.e);
      ((GridView)localObject1).setNumColumns(3);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setClipToPadding(false);
      int i = a;
      ((GridView)localObject1).setPadding(i, i, i, AIOUtils.b(36.0F, this.e.getResources()) + i);
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new ComboProviderGridAdapter(this.e, this.d);
      ((ComboProviderGridAdapter)localObject2).b = ((GridView)localObject1);
      ((ComboProviderGridAdapter)localObject2).a(((FilterCategory)this.f.get(paramInt)).c);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      ((ComboProviderGridAdapter)localObject2).a(((FilterCategory)this.f.get(paramInt)).a);
      ((GridView)localObject1).setOnItemClickListener(this.g);
      this.c.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.ComboProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */