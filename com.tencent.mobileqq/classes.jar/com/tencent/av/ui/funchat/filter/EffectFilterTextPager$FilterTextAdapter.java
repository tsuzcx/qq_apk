package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.mobileqq.util.BitmapManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectFilterTextPager$FilterTextAdapter
  extends PagerAdapter
{
  private EffectFilterTools jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
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
  
  void a(EffectFilterTools paramEffectFilterTools)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools = paramEffectFilterTools;
  }
  
  public void a(List paramList)
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
    Object localObject1 = (FilterItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext != null)
    {
      ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2130969366, null);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131366291);
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerFilterEffectFilterTools.a((FilterItem)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label205;
        }
        localObject1 = BitmapManager.a((String)localObject2);
        if (localObject1 == null) {
          break label195;
        }
        localImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject1));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
          float f = localContext.getResources().getDimension(2131560070);
          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, (int)f, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localImageView.setScaleX(0.6F);
          localImageView.setScaleY(0.6F);
        }
        paramViewGroup.addView(localViewGroup);
        return localViewGroup;
        label195:
        AVLog.c("EffectFilterTextPager", "decodeFile error");
      }
      label205:
      Object localObject2 = new StringBuilder().append("iconpath error ");
      if (localObject1 != null) {}
      for (localObject1 = ((FilterItem)localObject1).getId();; localObject1 = "")
      {
        AVLog.c("EffectFilterTextPager", (String)localObject1);
        break;
      }
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager.FilterTextAdapter
 * JD-Core Version:    0.7.0.1
 */