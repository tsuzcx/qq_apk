package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.DoodleMusicCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.util.List;

public class MusicProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a = AIOUtils.b(7.0F, BaseApplication.getContext().getResources());
  public static final int b = AIOUtils.b(0.0F, BaseApplication.getContext().getResources());
  Drawable c = new ColorDrawable(0);
  MusicProviderView d;
  private Context e;
  private List<DoodleMusicCategoryItem> f;
  private SparseArray<GridView> g = new SparseArray();
  private AdapterView.OnItemClickListener h;
  
  public MusicProviderPagerAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.e = paramContext;
    this.d = paramMusicProviderView;
  }
  
  public int a()
  {
    return this.g.size();
  }
  
  public GridView a(int paramInt)
  {
    paramInt = this.g.keyAt(paramInt);
    return (GridView)this.g.get(paramInt);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.h = paramOnItemClickListener;
  }
  
  public void a(List<DoodleMusicCategoryItem> paramList)
  {
    this.f = paramList;
  }
  
  public GridView b(int paramInt)
  {
    return (GridView)this.g.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.g.get(paramInt));
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
      QLog.d("MusicProviderView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (GridView)this.g.get(paramInt);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new GridView(this.e);
      ((GridView)localObject1).setNumColumns(4);
      ((GridView)localObject1).setSelector(this.c);
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      int i = a;
      ((GridView)localObject1).setPadding(i, i, i, i * 2 + AIOUtils.b(36.0F, this.e.getResources()));
      ((GridView)localObject1).setClipToPadding(false);
      localObject2 = new MusicProviderGridAdapter(this.e, this.d);
      ((GridView)localObject1).setOnItemClickListener(this.h);
      this.g.put(paramInt, localObject1);
    }
    else
    {
      localObject2 = (MusicProviderGridAdapter)((GridView)localObject1).getAdapter();
    }
    ((MusicProviderGridAdapter)localObject2).a(((DoodleMusicCategoryItem)this.f.get(paramInt)).d);
    ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
    if (this.d.j == paramInt)
    {
      ((GridView)localObject1).setSelection(this.d.k);
      localObject2 = this.d;
      ((MusicProviderView)localObject2).j = -1;
      ((MusicProviderView)localObject2).k = -1;
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */