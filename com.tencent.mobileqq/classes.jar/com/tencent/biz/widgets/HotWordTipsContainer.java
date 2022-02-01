package com.tencent.biz.widgets;

import aadx;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import basg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class HotWordTipsContainer
  extends LinearLayout
  implements View.OnClickListener
{
  aadx jdField_a_of_type_Aadx;
  protected Context a;
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
  
  public void a(HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel, int paramInt)
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = paramHotWordSearchEntryDataModel;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b() == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b().size() < 2)) {}
    for (;;)
    {
      return;
      new ArrayList();
      int m = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b().size() / 2;
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      int j;
      for (int i = 0; i < m * 2; i = j + 1)
      {
        paramHotWordSearchEntryDataModel = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramHotWordSearchEntryDataModel.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramHotWordSearchEntryDataModel.setOrientation(0);
        super.addView(paramHotWordSearchEntryDataModel);
        int k = 0;
        j = i;
        i = k;
        if (i < 2)
        {
          j += i;
          HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b().get(j);
          String str1 = a(localHotSearchItem.indexTextColor, "#777777");
          String str2 = a(localHotSearchItem.indexBgColor, "#00000000");
          RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560881, null);
          Object localObject1 = new LinearLayout.LayoutParams(0, -2);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramHotWordSearchEntryDataModel.addView(localRelativeLayout);
          Object localObject3 = (LinearLayout)localRelativeLayout.findViewById(2131368189);
          ((LinearLayout)localObject3).setVisibility(0);
          localObject1 = (TextView)((LinearLayout)localObject3).findViewById(2131378772);
          TextView localTextView = (TextView)((LinearLayout)localObject3).findViewById(2131368645);
          Object localObject2 = (URLImageView)((LinearLayout)localObject3).findViewById(2131376441);
          Object localObject4 = (URLImageView)localRelativeLayout.findViewById(2131363425);
          ((URLImageView)localObject4).setVisibility(8);
          if ((paramInt == 10) && (UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, localHotSearchItem.title)) && (!basg.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl))) {
            basg.a(getContext(), (URLImageView)localObject4, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrlNight, null);
          }
          localObject3 = ((LinearLayout)localObject3).findViewById(2131368643);
          ((TextView)localObject1).setText(localHotSearchItem.title);
          if (!TextUtils.isEmpty(localHotSearchItem.titleTextColor)) {
            ((TextView)localObject1).setTextColor(Color.parseColor(localHotSearchItem.titleTextColor));
          }
          if (!TextUtils.isEmpty(localHotSearchItem.rightIconUrl))
          {
            localObject4 = new ColorDrawable();
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
            {
              ((ColorDrawable)localObject4).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167308));
              label491:
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
              localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject4);
              localObject4 = URLDrawable.getDrawable(localHotSearchItem.rightIconUrl, localURLDrawableOptions);
              if (((URLDrawable)localObject4).getStatus() != 1) {
                ((URLDrawable)localObject4).startDownload();
              }
              ((URLImageView)localObject2).setVisibility(0);
              ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
            }
          }
          else
          {
            localTextView.setText(String.valueOf(j + 1));
            ((View)localObject3).setBackgroundColor(Color.parseColor(str2));
            if (localHotSearchItem.type == 7)
            {
              ((View)localObject3).setVisibility(8);
              localTextView.setVisibility(8);
              localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
              ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            if (!bool) {
              break label691;
            }
            localTextView.setTextColor(Color.parseColor("#5F6062"));
            if (!TextUtils.equals(str2, "#00000000")) {
              localTextView.setTextColor(-1);
            }
          }
          for (;;)
          {
            localRelativeLayout.setTag(localHotSearchItem);
            localRelativeLayout.setOnClickListener(this);
            i += 1;
            break;
            ((ColorDrawable)localObject4).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167307));
            break label491;
            label691:
            localTextView.setTextColor(Color.parseColor(str1));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aadx != null) {
      this.jdField_a_of_type_Aadx.a((HotWordSearchEntryDataModel.HotSearchItem)paramView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnTipsClickListener(aadx paramaadx)
  {
    this.jdField_a_of_type_Aadx = paramaadx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.widgets.HotWordTipsContainer
 * JD-Core Version:    0.7.0.1
 */