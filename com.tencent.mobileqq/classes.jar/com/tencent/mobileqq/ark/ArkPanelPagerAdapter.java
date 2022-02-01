package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class ArkPanelPagerAdapter
  extends PagerAdapter
{
  ArrayList<ArkAppPanelData> a;
  View.OnClickListener b;
  int c = 4;
  int d = 2;
  PanelRecycleBin e;
  Context f;
  ViewGroup g;
  private final Drawable h = new ColorDrawable(0);
  private int i;
  
  public ArkPanelPagerAdapter(Context paramContext)
  {
    this.f = paramContext;
    this.e = new PanelRecycleBin();
    this.i = AIOUtils.b(50.0F, paramContext.getResources());
  }
  
  private void a(int paramInt, ArkPanelPagerAdapter.IconLinearLayout paramIconLinearLayout)
  {
    int i1 = this.c;
    int i2 = this.d;
    paramIconLinearLayout.a(paramInt);
    int k = 0;
    int j = 0;
    while (k < this.d)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramIconLinearLayout.getChildAt(k);
      int m = 0;
      while (m < this.c)
      {
        View localView = localLinearLayout.getChildAt(m);
        ArkPanelPagerAdapter.ViewHolder localViewHolder = (ArkPanelPagerAdapter.ViewHolder)localView.getTag();
        int i3 = i1 * i2 * paramInt + j;
        int i4 = this.a.size();
        int n = 8;
        if (i3 < i4)
        {
          ArkAppPanelData localArkAppPanelData = (ArkAppPanelData)this.a.get(i3);
          localViewHolder.a.setVisibility(0);
          if ((i3 == this.a.size() - 1) && (localArkAppPanelData.a))
          {
            localViewHolder.a.setBackgroundDrawable(localView.getResources().getDrawable(2130838736));
          }
          else
          {
            localObject = URLDrawable.URLDrawableOptions.obtain();
            Drawable localDrawable = this.h;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
            i3 = this.i;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i3;
            ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i3;
            localViewHolder.a.setBackgroundDrawable(URLDrawable.getDrawable(localArkAppPanelData.e, (URLDrawable.URLDrawableOptions)localObject));
          }
          localViewHolder.c.setText(localArkAppPanelData.d);
          Object localObject = localViewHolder.b;
          if (localArkAppPanelData.b) {
            n = 0;
          }
          ((ImageView)localObject).setVisibility(n);
          localViewHolder.d = localArkAppPanelData.c;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localArkAppPanelData.d);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131898962));
          localView.setContentDescription(((StringBuilder)localObject).toString());
          localView.setOnClickListener(this.b);
          localView.setEnabled(true);
          AccessibilityUtil.a(localView, true);
        }
        else
        {
          localViewHolder.a.setVisibility(4);
          localViewHolder.a.setImageBitmap(null);
          localViewHolder.c.setText(null);
          localViewHolder.b.setVisibility(8);
          localViewHolder.d = null;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          AccessibilityUtil.a(localView, false);
        }
        AccessibilityUtil.a(localViewHolder.c, false);
        j += 1;
        m += 1;
      }
      k += 1;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    if (paramInt >= 0)
    {
      int j = 0;
      while (j < this.g.getChildCount())
      {
        ArkPanelPagerAdapter.IconLinearLayout localIconLinearLayout = (ArkPanelPagerAdapter.IconLinearLayout)this.g.getChildAt(j);
        if ((localIconLinearLayout != null) && (paramInt == localIconLinearLayout.a))
        {
          a(paramInt, localIconLinearLayout);
          return;
        }
        j += 1;
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void a(ArrayList<ArkAppPanelData> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ArkPanelPagerAdapter.IconLinearLayout localIconLinearLayout = (ArkPanelPagerAdapter.IconLinearLayout)paramObject;
    ((ViewGroup)paramView).removeView(localIconLinearLayout);
    localIconLinearLayout.a();
    this.e.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.c != 0) && (this.d != 0))
    {
      ArrayList localArrayList = this.a;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int k = this.c;
        int m = this.d;
        return (j + k * m - 1) / (k * m);
      }
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (((paramObject instanceof ArkPanelPagerAdapter.IconLinearLayout)) && (((ArkPanelPagerAdapter.IconLinearLayout)paramObject).a >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("instantiateItem position=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ArkPanelPagerAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (ArkPanelPagerAdapter.IconLinearLayout)this.e.getScrapView();
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject3 = ((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getTag();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof Integer))
        {
          localObject1 = localObject2;
          if (((Integer)((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getTag()).intValue() != XPanelContainer.d)
          {
            this.e.clearScrapViews();
            localObject1 = null;
          }
        }
      }
    }
    Object localObject3 = (ViewGroup)paramView;
    this.g = ((ViewGroup)localObject3);
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArkPanelPagerAdapter.IconLinearLayout(this, this.f, null);
    }
    ((ArkPanelPagerAdapter.IconLinearLayout)localObject2).a(paramInt);
    a(paramInt, (ArkPanelPagerAdapter.IconLinearLayout)localObject2);
    if ((((ArkPanelPagerAdapter.IconLinearLayout)localObject2).getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)localObject3).addView((View)localObject2);
    }
    return localObject2;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkPanelPagerAdapter
 * JD-Core Version:    0.7.0.1
 */