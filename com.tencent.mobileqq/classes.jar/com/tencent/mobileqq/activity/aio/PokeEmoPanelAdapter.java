package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEItemData;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleLinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PokeEmoPanelAdapter
  extends BaseAdapter
{
  private float jdField_a_of_type_Float = 1.25F;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ArrayList<PEItemData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PokeEmoPanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130841546);
  }
  
  private int a()
  {
    return 4;
  }
  
  public Drawable a(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    return URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
  }
  
  public void a(List<PEItemData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = a();
      return (this.jdField_a_of_type_JavaUtilArrayList.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int m = a();
    int i = (XPanelContainer.jdField_a_of_type_Int - AIOUtils.b(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2) / 3;
    if (i < 0) {
      i = 0;
    }
    int k = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = i;
    if (i < k) {
      j = k;
    }
    i = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4) / 8;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramView == null)
    {
      paramView = new StickerBubbleLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + j);
      paramView.setOrientation(0);
      i = 0;
      while (i < m)
      {
        localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        ((LinearLayout)localObject1).setGravity(17);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        k = j / 2;
        ((LinearLayout.LayoutParams)localObject2).topMargin = k;
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = k;
        localObject3 = new StickerBubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject3).setPadding(14, 14, 14, 14);
        k = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        int n = AIOUtils.b(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localObject4 = new ShapeDrawable(new OvalShape());
        ((ShapeDrawable)localObject4).setIntrinsicHeight(k);
        ((ShapeDrawable)localObject4).setIntrinsicWidth(n);
        ((ShapeDrawable)localObject4).getPaint().setColor(1728053247);
        ((View)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout)localObject1).addView((View)localObject3);
        paramView.addView((View)localObject1);
        i += 1;
      }
    }
    Object localObject1 = (ViewGroup)paramView;
    if (paramInt == 0) {
      ((ViewGroup)localObject1).setPadding(0, j / 2, 0, 0);
    } else {
      ((ViewGroup)localObject1).setPadding(0, 0, 0, 0);
    }
    i = 0;
    while (i < m)
    {
      j = m * paramInt + i;
      localObject2 = ((ViewGroup)((ViewGroup)localObject1).getChildAt(i)).getChildAt(0);
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((View)localObject2).setVisibility(0);
        localObject3 = (PEItemData)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localObject3 != null) {
          ((ImageView)localObject2).setImageDrawable(a(((PEItemData)localObject3).jdField_a_of_type_JavaLangString));
        }
        ((View)localObject2).setTag(Integer.valueOf(j));
        if (AppSetting.d)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(PEPanelHelper.a(((PEItemData)localObject3).jdField_a_of_type_Int));
          ((StringBuilder)localObject4).append(HardCodeUtil.a(2131708315));
          ((View)localObject2).setContentDescription(((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        ((View)localObject2).setVisibility(4);
      }
      i += 1;
    }
    paramView.setOnLongClickListener(null);
    AccessibilityUtil.a(paramView, false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokeEmoPanelAdapter
 * JD-Core Version:    0.7.0.1
 */