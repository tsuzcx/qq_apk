package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class HotWordTipsContainer
  extends LinearLayout
  implements View.OnClickListener
{
  protected Context a;
  HotWordTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener;
  private HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  
  public HotWordTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      try
      {
        Color.parseColor(paramString1);
        return paramString1;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("HotWordTipsContainer", 2, "getValidColor " + paramString1);
    return paramString2;
  }
  
  public void a(HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel)
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = paramHotWordSearchEntryDataModel;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() < 2)) {}
    int j;
    boolean bool;
    int i;
    do
    {
      return;
      new ArrayList();
      j = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() / 2;
      bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      i = 0;
    } while (i >= j * 2);
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get(i);
    Object localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    ((LinearLayout)localObject1).setOrientation(0);
    label150:
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject7;
    Object localObject5;
    if (bool)
    {
      ((LinearLayout)localObject1).setBackgroundResource(2130838586);
      localObject3 = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970178, null);
      paramHotWordSearchEntryDataModel = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970178, null);
      ((LinearLayout)localObject1).addView((View)localObject3);
      ((LinearLayout)localObject1).addView(paramHotWordSearchEntryDataModel);
      localObject2 = new LinearLayout.LayoutParams(0, -2);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramHotWordSearchEntryDataModel.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      super.addView((View)localObject1);
      localObject4 = (LinearLayout)((RelativeLayout)localObject3).findViewById(2131369387);
      localObject7 = (LinearLayout)((RelativeLayout)localObject3).findViewById(2131369391);
      localObject5 = (LinearLayout)((RelativeLayout)localObject3).findViewById(2131369385);
      localObject1 = a(localHotSearchItem.indexTextColor, "#777777");
      localObject2 = a(localHotSearchItem.indexBgColor, "#00000000");
      switch (localHotSearchItem.showType)
      {
      default: 
        label328:
        ((RelativeLayout)localObject3).setTag(localHotSearchItem);
        ((RelativeLayout)localObject3).setOnClickListener(this);
        i += 1;
        localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get(i);
        localObject4 = (LinearLayout)paramHotWordSearchEntryDataModel.findViewById(2131369387);
        localObject3 = (LinearLayout)paramHotWordSearchEntryDataModel.findViewById(2131369391);
        localObject5 = (LinearLayout)paramHotWordSearchEntryDataModel.findViewById(2131369385);
        switch (localHotSearchItem.showType)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramHotWordSearchEntryDataModel.setTag(localHotSearchItem);
      paramHotWordSearchEntryDataModel.setOnClickListener(this);
      i += 1;
      break;
      ((LinearLayout)localObject1).setBackgroundResource(2130838585);
      break label150;
      ((LinearLayout)localObject4).setVisibility(0);
      localObject5 = (TextView)((LinearLayout)localObject4).findViewById(2131369390);
      Object localObject6 = (TextView)((LinearLayout)localObject4).findViewById(2131369389);
      localObject4 = ((LinearLayout)localObject4).findViewById(2131369388);
      ((TextView)localObject5).setText(localHotSearchItem.title);
      ((TextView)localObject6).setText(String.valueOf(i + 1));
      if (bool)
      {
        ((TextView)localObject6).setTextColor(Color.parseColor("#5F6062"));
        ((View)localObject4).setBackgroundColor(0);
        break label328;
      }
      ((TextView)localObject6).setTextColor(Color.parseColor((String)localObject1));
      ((View)localObject4).setBackgroundColor(Color.parseColor((String)localObject2));
      break label328;
      ((LinearLayout)localObject7).setVisibility(0);
      Object localObject8 = (TextView)((LinearLayout)localObject7).findViewById(2131369394);
      localObject4 = (TextView)((LinearLayout)localObject7).findViewById(2131369393);
      localObject6 = (URLImageView)((LinearLayout)localObject7).findViewById(2131363068);
      localObject5 = (URLImageView)((LinearLayout)localObject7).findViewById(2131369392);
      localObject7 = (TextView)((LinearLayout)localObject7).findViewById(2131369395);
      ((TextView)localObject8).setText(localHotSearchItem.title);
      ((TextView)localObject4).setText(String.valueOf(i + 1));
      ((TextView)localObject7).setText(localHotSearchItem.detailText);
      Object localObject9 = new ColorDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        ((ColorDrawable)localObject9).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492956));
      }
      for (;;)
      {
        localObject8 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject8).mLoadingDrawable = ((Drawable)localObject9);
        ((URLDrawable.URLDrawableOptions)localObject8).mFailedDrawable = ((Drawable)localObject9);
        localObject9 = URLDrawable.getDrawable(localHotSearchItem.imgUrl, (URLDrawable.URLDrawableOptions)localObject8);
        if (((URLDrawable)localObject9).getStatus() != 1) {
          ((URLDrawable)localObject9).restartDownload();
        }
        ((URLImageView)localObject6).setImageDrawable((Drawable)localObject9);
        if (!TextUtils.isEmpty(localHotSearchItem.imgBgUrl))
        {
          localObject6 = URLDrawable.getDrawable(localHotSearchItem.imgBgUrl, (URLDrawable.URLDrawableOptions)localObject8);
          if (((URLDrawable)localObject6).getStatus() != 1) {
            ((URLDrawable)localObject6).startDownload();
          }
          ((URLImageView)localObject5).setImageDrawable((Drawable)localObject6);
        }
        if (!bool) {
          break label843;
        }
        ((TextView)localObject7).setTextColor(Color.parseColor("#5F6062"));
        ((TextView)localObject4).setTextColor(Color.parseColor("#5F6062"));
        break;
        ((ColorDrawable)localObject9).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492955));
      }
      label843:
      ((TextView)localObject4).setTextColor(Color.parseColor((String)localObject1));
      break label328;
      ((LinearLayout)localObject5).setVisibility(0);
      localObject4 = (TextView)((LinearLayout)localObject5).findViewById(2131369386);
      ((TextView)localObject4).setText(localHotSearchItem.title);
      if (!bool) {
        break label328;
      }
      ((TextView)localObject4).setTextColor(Color.parseColor("#5F6062"));
      break label328;
      ((LinearLayout)localObject4).setVisibility(0);
      localObject3 = (TextView)((LinearLayout)localObject4).findViewById(2131369390);
      localObject5 = (TextView)((LinearLayout)localObject4).findViewById(2131369389);
      localObject4 = ((LinearLayout)localObject4).findViewById(2131369388);
      ((TextView)localObject3).setText(localHotSearchItem.title);
      ((TextView)localObject5).setText(String.valueOf(i + 1));
      ((TextView)localObject5).setTextColor(Color.parseColor((String)localObject1));
      ((View)localObject4).setBackgroundColor(Color.parseColor((String)localObject2));
      if (bool)
      {
        ((TextView)localObject5).setTextColor(Color.parseColor("#5F6062"));
        ((View)localObject4).setBackgroundColor(0);
      }
      else
      {
        ((TextView)localObject5).setTextColor(Color.parseColor((String)localObject1));
        ((View)localObject4).setBackgroundColor(Color.parseColor((String)localObject2));
        continue;
        ((LinearLayout)localObject3).setVisibility(0);
        localObject6 = (TextView)((LinearLayout)localObject3).findViewById(2131369394);
        localObject2 = (TextView)((LinearLayout)localObject3).findViewById(2131369393);
        localObject5 = (URLImageView)((LinearLayout)localObject3).findViewById(2131363068);
        localObject4 = (TextView)((LinearLayout)localObject3).findViewById(2131369395);
        ((TextView)localObject6).setText(localHotSearchItem.title);
        ((TextView)localObject2).setText(String.valueOf(i + 1));
        ((TextView)localObject4).setText(localHotSearchItem.detailText);
        localObject7 = new ColorDrawable();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          ((ColorDrawable)localObject7).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492956));
        }
        for (;;)
        {
          localObject6 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = ((Drawable)localObject7);
          localObject3 = (URLImageView)((LinearLayout)localObject3).findViewById(2131369392);
          localObject7 = URLDrawable.getDrawable(localHotSearchItem.imgUrl, (URLDrawable.URLDrawableOptions)localObject6);
          if (((URLDrawable)localObject7).getStatus() != 1) {
            ((URLDrawable)localObject7).restartDownload();
          }
          ((URLImageView)localObject5).setImageDrawable((Drawable)localObject7);
          if (!TextUtils.isEmpty(localHotSearchItem.imgBgUrl))
          {
            localObject5 = URLDrawable.getDrawable(localHotSearchItem.imgBgUrl, (URLDrawable.URLDrawableOptions)localObject6);
            if (((URLDrawable)localObject5).getStatus() != 1) {
              ((URLDrawable)localObject5).startDownload();
            }
            ((URLImageView)localObject3).setImageDrawable((Drawable)localObject5);
          }
          if (!bool) {
            break label1310;
          }
          ((TextView)localObject4).setTextColor(Color.parseColor("#5F6062"));
          ((TextView)localObject2).setTextColor(Color.parseColor("#5F6062"));
          break;
          ((ColorDrawable)localObject7).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492955));
        }
        label1310:
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
        continue;
        ((LinearLayout)localObject5).setVisibility(0);
        localObject1 = (TextView)((LinearLayout)localObject5).findViewById(2131369386);
        ((TextView)localObject1).setText(localHotSearchItem.title);
        if (bool) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#5F6062"));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener != null) {
      this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener.a((HotWordSearchEntryDataModel.HotSearchItem)paramView.getTag());
    }
  }
  
  public void setOnTipsClickListener(HotWordTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener = paramOnTipClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.HotWordTipsContainer
 * JD-Core Version:    0.7.0.1
 */