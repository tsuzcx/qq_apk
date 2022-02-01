package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class HotWordTipsContainer
  extends LinearLayout
  implements View.OnClickListener
{
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  HotWordTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener;
  private HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = null;
  private final String jdField_a_of_type_JavaLangString = "defaultmode";
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_1@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_2@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_3@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_4@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_5@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_6@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_7@3x.png", "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/870/qsearch_qcircle/hotseatch_order_8@3x.png" };
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = "darkmode";
  
  public HotWordTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOrientation(1);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    try
    {
      Color.parseColor(paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getValidColor ");
        localStringBuilder.append(paramString1);
        QLog.d("HotWordTipsContainer", 2, localStringBuilder.toString());
      }
    }
    return paramString2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  private void a(int paramInt, URLImageView paramURLImageView, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (paramHotSearchItem != null)
    {
      if (paramURLImageView == null) {
        return;
      }
      paramURLImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      Object localObject = paramHotSearchItem.imgUrl;
      paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        paramHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
        if (paramInt < arrayOfString.length) {
          paramHotSearchItem = arrayOfString[paramInt];
        }
      }
      if (!TextUtils.isEmpty(paramHotSearchItem))
      {
        localObject = paramHotSearchItem;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          localObject = paramHotSearchItem.replace("defaultmode", "darkmode");
        }
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, URLDrawable.URLDrawableOptions.obtain()));
      }
      paramURLImageView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramURLImageView.setMargins(DisplayUtil.a(getContext(), 2.0F), 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramURLImageView);
    }
  }
  
  private void a(int paramInt, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      localObject = (URLImageView)((RelativeLayout)localObject).findViewById(2131363504);
      ((URLImageView)localObject).setVisibility(8);
      if ((paramInt == 10) && (UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, paramHotSearchItem.title)) && (!HotWordSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl))) {
        HotWordSearchEntryModel.a(getContext(), (URLImageView)localObject, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrlNight, null);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt + 1));
      String str = a(paramHotSearchItem.indexTextColor, "#777777");
      paramHotSearchItem = a(paramHotSearchItem.indexBgColor, "#00000000");
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(paramHotSearchItem));
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#5F6062"));
        if (!TextUtils.equals(paramHotSearchItem, "#00000000")) {
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
      }
    }
  }
  
  private void a(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (paramHotSearchItem == null) {
        return;
      }
      localTextView.setText(paramHotSearchItem.title);
      if (!TextUtils.isEmpty(paramHotSearchItem.titleTextColor)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramHotSearchItem.titleTextColor));
      }
    }
  }
  
  private void b(int paramInt, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if (paramHotSearchItem == null) {
      return;
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379616);
    localTextView.setVisibility(0);
    localTextView.setText(paramHotSearchItem.detailText);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376706);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    int i = DisplayUtil.a(getContext(), 12.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
    localLayoutParams.height = DisplayUtil.a(getContext(), 20.0F);
    if (paramInt % 2 == 0)
    {
      localTextView.setPadding(i, 0, 0, 0);
      localLayoutParams.setMargins(i, i, i, 0);
    }
    else
    {
      localLayoutParams.setMargins(0, i, i, 0);
    }
    localRelativeLayout.setLayoutParams(localLayoutParams);
    a(paramInt, (URLImageView)localRelativeLayout.findViewById(2131369391), paramHotSearchItem);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramHotSearchItem != null))
    {
      if (TextUtils.isEmpty(paramHotSearchItem.rightIconUrl)) {
        return;
      }
      URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376568);
      ColorDrawable localColorDrawable = new ColorDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        localColorDrawable.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167365));
      } else {
        localColorDrawable.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167364));
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      paramHotSearchItem = URLDrawable.getDrawable(paramHotSearchItem.rightIconUrl, localURLDrawableOptions);
      if (paramHotSearchItem.getStatus() != 1) {
        paramHotSearchItem.startDownload();
      }
      localURLImageView.setVisibility(0);
      localURLImageView.setImageDrawable(paramHotSearchItem);
    }
  }
  
  public void a(HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel, int paramInt)
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = paramHotWordSearchEntryDataModel;
    paramHotWordSearchEntryDataModel = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
    if ((paramHotWordSearchEntryDataModel != null) && (paramHotWordSearchEntryDataModel.b() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b().size() < 2) {
        return;
      }
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
        while (i < 2)
        {
          j += i;
          HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b().get(j);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560891, null));
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
          localLayoutParams.weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
          paramHotWordSearchEntryDataModel.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368294));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378848));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368758));
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368756);
          a(paramInt, localHotSearchItem);
          a(localHotSearchItem);
          b(localHotSearchItem);
          a(j, bool, localHotSearchItem);
          k = localHotSearchItem.type;
          if (k != 7)
          {
            if (k == 8) {
              b(j, localHotSearchItem);
            }
          }
          else {
            a();
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localHotSearchItem);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          i += 1;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    HotWordTipsContainer.OnTipClickListener localOnTipClickListener = this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener;
    if (localOnTipClickListener != null) {
      localOnTipClickListener.a((HotWordSearchEntryDataModel.HotSearchItem)paramView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnTipsClickListener(HotWordTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer$OnTipClickListener = paramOnTipClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.HotWordTipsContainer
 * JD-Core Version:    0.7.0.1
 */