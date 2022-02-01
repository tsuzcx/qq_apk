package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.FilterData.FilterPageItem;
import com.tencent.aelight.camera.aioeditor.takevideo.filter.VideoEffectsFilterData.VideoEffectsFilterPageItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EditVideoSpeedFilter$FilterPagerAdapter
  extends PagerAdapter
{
  public final List<FilterData> a = new ArrayList();
  private final Map<Class<? extends FilterData.FilterPageItem>, Queue<FilterData.FilterPageItem>> b = new HashMap();
  private final SparseArray<FilterData.FilterPageItem> c = new SparseArray();
  private final Context d;
  
  public EditVideoSpeedFilter$FilterPagerAdapter(@NonNull Context paramContext)
  {
    this.d = paramContext;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public FilterData a(int paramInt)
  {
    paramInt = b(paramInt);
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (FilterData)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FilterData localFilterData = (FilterData)((Iterator)localObject).next();
      if (paramInt == localFilterData.c) {
        localFilterData.d = paramString;
      }
    }
    int i = 0;
    while (i < this.c.size())
    {
      localObject = (FilterData.FilterPageItem)this.c.valueAt(i);
      if ((localObject != null) && (((FilterData.FilterPageItem)localObject).b.c == paramInt) && ((localObject instanceof VideoEffectsFilterData.VideoEffectsFilterPageItem)))
      {
        localObject = (VideoEffectsFilterData.VideoEffectsFilterPageItem)localObject;
        ((VideoEffectsFilterData.VideoEffectsFilterPageItem)localObject).f.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoSpeedFilter.a((FilterData.FilterPageItem)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<FilterData> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.c.clear();
    notifyDataSetChanged();
  }
  
  public int b(int paramInt)
  {
    int i = this.a.size();
    if (i != 0) {
      return paramInt % i;
    }
    return 0;
  }
  
  @Nullable
  public FilterData.FilterPageItem c(int paramInt)
  {
    return (FilterData.FilterPageItem)this.c.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    FilterData.FilterPageItem localFilterPageItem = (FilterData.FilterPageItem)paramObject;
    paramViewGroup.removeView(localFilterPageItem.a);
    localFilterPageItem.a.setOnTouchListener(null);
    localFilterPageItem.a();
    paramObject = (Queue)this.b.get(localFilterPageItem.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.b.put(localFilterPageItem.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localFilterPageItem);
    this.c.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.a.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    FilterData localFilterData = a(paramInt);
    FilterData.FilterPageItem localFilterPageItem = null;
    if (localFilterData == null)
    {
      SLog.d("EditVideoSpeedFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject = (Queue)this.b.get(localFilterData.b());
    if (localObject != null) {
      localFilterPageItem = (FilterData.FilterPageItem)((Queue)localObject).poll();
    }
    localObject = localFilterPageItem;
    if (localFilterPageItem == null) {
      localObject = localFilterData.a(this.d, paramViewGroup);
    }
    paramViewGroup.addView(((FilterData.FilterPageItem)localObject).a);
    ((FilterData.FilterPageItem)localObject).a(localFilterData, paramInt);
    this.c.put(paramInt, localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof FilterData.FilterPageItem)) && (((FilterData.FilterPageItem)paramObject).a == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */