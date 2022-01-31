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
import ayhk;
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
import java.util.ArrayList;
import java.util.List;
import zgq;

public class HotWordTipsContainer
  extends LinearLayout
  implements View.OnClickListener
{
  protected Context a;
  private HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  zgq jdField_a_of_type_Zgq;
  
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
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.size() < 2)) {}
    for (;;)
    {
      return;
      new ArrayList();
      int m = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.size() / 2;
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
          HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_JavaUtilList.get(j);
          String str1 = a(localHotSearchItem.indexTextColor, "#777777");
          String str2 = a(localHotSearchItem.indexBgColor, "#00000000");
          RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560776, null);
          Object localObject1 = new LinearLayout.LayoutParams(0, -2);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramHotWordSearchEntryDataModel.addView(localRelativeLayout);
          Object localObject2 = (LinearLayout)localRelativeLayout.findViewById(2131367774);
          ((LinearLayout)localObject2).setVisibility(0);
          Object localObject3 = (TextView)((LinearLayout)localObject2).findViewById(2131377999);
          localObject1 = (TextView)((LinearLayout)localObject2).findViewById(2131368220);
          URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject2).findViewById(2131375812);
          Object localObject4 = (URLImageView)localRelativeLayout.findViewById(2131363186);
          ((URLImageView)localObject4).setVisibility(8);
          if ((paramInt == 10) && (UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, localHotSearchItem.title)) && (!ayhk.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrl))) {
            ayhk.a(getContext(), (URLImageView)localObject4, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrlNight, null);
          }
          localObject2 = ((LinearLayout)localObject2).findViewById(2131368218);
          ((TextView)localObject3).setText(localHotSearchItem.title);
          if (!TextUtils.isEmpty(localHotSearchItem.titleTextColor)) {
            ((TextView)localObject3).setTextColor(Color.parseColor(localHotSearchItem.titleTextColor));
          }
          if (!TextUtils.isEmpty(localHotSearchItem.rightIconUrl))
          {
            localObject3 = new ColorDrawable();
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
            {
              ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167169));
              label491:
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
              localObject3 = URLDrawable.getDrawable(localHotSearchItem.rightIconUrl, (URLDrawable.URLDrawableOptions)localObject4);
              if (((URLDrawable)localObject3).getStatus() != 1) {
                ((URLDrawable)localObject3).startDownload();
              }
              localURLImageView.setVisibility(0);
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          else
          {
            ((TextView)localObject1).setText(String.valueOf(j + 1));
            ((View)localObject2).setBackgroundColor(Color.parseColor(str2));
            if (!bool) {
              break label644;
            }
            ((TextView)localObject1).setTextColor(Color.parseColor("#5F6062"));
            if (!TextUtils.equals(str2, "#00000000")) {
              ((TextView)localObject1).setTextColor(-1);
            }
          }
          for (;;)
          {
            localRelativeLayout.setTag(localHotSearchItem);
            localRelativeLayout.setOnClickListener(this);
            i += 1;
            break;
            ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167168));
            break label491;
            label644:
            ((TextView)localObject1).setTextColor(Color.parseColor(str1));
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Zgq != null) {
      this.jdField_a_of_type_Zgq.a((HotWordSearchEntryDataModel.HotSearchItem)paramView.getTag());
    }
  }
  
  public void setOnTipsClickListener(zgq paramzgq)
  {
    this.jdField_a_of_type_Zgq = paramzgq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.widgets.HotWordTipsContainer
 * JD-Core Version:    0.7.0.1
 */