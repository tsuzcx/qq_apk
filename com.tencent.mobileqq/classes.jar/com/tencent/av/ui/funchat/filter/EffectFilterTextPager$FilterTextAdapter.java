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
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<FilterItem> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public EffectFilterTextPager$FilterTextAdapter(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a(FilterItem paramFilterItem)
  {
    int i = 0;
    if (paramFilterItem == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (FilterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<FilterItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  @TargetApi(11)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (FilterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = null;
    if (localContext != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131559776, null);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131373385);
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
        ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = localContext.getResources().getDimensionPixelSize(2131297769);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = localContext.getResources().getDimensionPixelSize(2131297768);
        localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
        float f = localContext.getResources().getDimension(2131297764);
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