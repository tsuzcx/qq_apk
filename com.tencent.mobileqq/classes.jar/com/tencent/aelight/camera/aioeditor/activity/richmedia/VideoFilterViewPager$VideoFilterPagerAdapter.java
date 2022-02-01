package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class VideoFilterViewPager$VideoFilterPagerAdapter
  extends PagerAdapter
{
  public final Map<Class<? extends View>, Queue<View>> a = new HashMap();
  public final SparseArray<View> b = new SparseArray();
  public ArrayList<QIMFilterCategoryItem> c = new ArrayList();
  
  public VideoFilterViewPager$VideoFilterPagerAdapter(VideoFilterViewPager paramVideoFilterViewPager) {}
  
  public int a()
  {
    return this.c.size();
  }
  
  public QIMFilterCategoryItem a(int paramInt)
  {
    paramInt = b(paramInt);
    if ((paramInt >= 0) && (paramInt < this.c.size())) {
      return (QIMFilterCategoryItem)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
    while (i < this.c.size())
    {
      if (paramString.equals(((QIMFilterCategoryItem)this.c.get(i)).a))
      {
        this.d.a(i);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onResourceDownload - selectFilterById() - set last selected item: (");
          localStringBuilder.append(i);
          localStringBuilder.append(", ");
          localStringBuilder.append(((QIMFilterCategoryItem)this.c.get(i)).a);
          localStringBuilder.append(")");
          QLog.d("VideoFilterViewPager", 2, localStringBuilder.toString());
        }
      }
      i += 1;
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.c.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)paramList.next();
      if (!localQIMFilterCategoryItem.g()) {
        this.c.add(localQIMFilterCategoryItem);
      }
    }
    if (!VideoFilterTools.a().k()) {
      VideoFilterTools.b(this.c);
    }
    VideoFilterTools.a(this.d.getContext(), this.c);
    notifyDataSetChanged();
  }
  
  public int b(int paramInt)
  {
    int i = this.c.size();
    if (i > 0) {
      return paramInt % i;
    }
    return -1;
  }
  
  @Nullable
  public View c(int paramInt)
  {
    return (View)this.b.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroyItem position: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (View)paramObject;
    ((View)localObject).removeCallbacks((Runnable)((View)localObject).getTag());
    ((View)localObject).clearAnimation();
    paramViewGroup.removeView((View)localObject);
    paramObject = (Queue)this.a.get(localObject.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.a.put(localObject.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localObject);
    this.b.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.c.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = a(paramInt);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("instantiateItem position: ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("VideoFilterViewPager", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("VideoFilterViewPager", 2, "instantiateItem find data is null!");
      }
      return null;
    }
    localObject1 = (Queue)this.a.get(localObject1.getClass());
    if (localObject1 != null) {
      localObject1 = (View)((Queue)localObject1).poll();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = ((LayoutInflater)this.d.getContext().getSystemService("layout_inflater")).inflate(2131624731, null);
      ((View)localObject2).setVisibility(8);
    }
    paramViewGroup.addView((View)localObject2);
    this.b.put(paramInt, localObject2);
    return localObject2;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof View)) && (paramObject == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.VideoFilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */