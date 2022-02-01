package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lbd;

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
    if (paramFilterItem == null) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    for (;;)
    {
      if ((!localIterator.hasNext()) || (((FilterItem)localIterator.next()).getId().equals(paramFilterItem.getId()))) {
        return i;
      }
      i += 1;
    }
  }
  
  public FilterItem a(int paramInt)
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
    Object localObject = (FilterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131559829, null);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131373499);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if (localObject != null) {}
      for (localObject = ((FilterItem)localObject).getIconurl();; localObject = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          lbd.f("EffectFilterTextPager", "decodeFile url is null.");
          localImageView.setImageDrawable(null);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            localObject = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
            float f = localContext.getResources().getDimension(2131297706);
            ((LinearLayout.LayoutParams)localObject).setMargins(((LinearLayout.LayoutParams)localObject).leftMargin, (int)f, ((LinearLayout.LayoutParams)localObject).rightMargin, ((LinearLayout.LayoutParams)localObject).bottomMargin);
            localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            localImageView.setScaleX(0.6F);
            localImageView.setScaleY(0.6F);
          }
          paramViewGroup.addView(localViewGroup);
          return localViewGroup;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestWidth = localContext.getResources().getDimensionPixelSize(2131297711);
          localURLDrawableOptions.mRequestHeight = localContext.getResources().getDimensionPixelSize(2131297710);
          localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, localURLDrawableOptions));
        }
      }
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.FilterTextAdapter
 * JD-Core Version:    0.7.0.1
 */