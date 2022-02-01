package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectFilterTextPager$FilterTextAdapter
  extends PagerAdapter
{
  WeakReference<Context> a;
  ArrayList<FilterItem> b;
  private boolean c;
  private ColorDrawable d = new ColorDrawable(0);
  
  public EffectFilterTextPager$FilterTextAdapter(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
    this.b = new ArrayList();
  }
  
  public int a(FilterItem paramFilterItem)
  {
    int i = 0;
    if (paramFilterItem == null) {
      return 0;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      if (((FilterItem)localIterator.next()).getId().equals(paramFilterItem.getId())) {
        return i;
      }
      i += 1;
    }
    return i;
  }
  
  FilterItem a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (FilterItem)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a(List<FilterItem> paramList)
  {
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (FilterItem)this.b.get(paramInt);
    Context localContext = (Context)this.a.get();
    Object localObject1 = null;
    if (localContext != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131625818, null);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131441058);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if (localObject2 != null) {
        localObject1 = ((FilterItem)localObject2).getIconUrl();
      } else {
        localObject1 = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AVLog.printColorLog("EffectFilterTextPager", "decodeFile url is null.");
        localImageView.setImageDrawable(null);
      }
      else
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = this.d;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = localContext.getResources().getDimensionPixelSize(2131298438);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = localContext.getResources().getDimensionPixelSize(2131298437);
        localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
      }
      if (this.c)
      {
        localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
        float f = localContext.getResources().getDimension(2131298433);
        ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, (int)f, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localImageView.setScaleX(0.6F);
        localImageView.setScaleY(0.6F);
      }
      paramViewGroup.addView(localViewGroup);
      localObject1 = localViewGroup;
    }
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.FilterTextAdapter
 * JD-Core Version:    0.7.0.1
 */