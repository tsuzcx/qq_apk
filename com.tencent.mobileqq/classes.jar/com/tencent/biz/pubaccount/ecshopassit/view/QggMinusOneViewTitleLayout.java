package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.Date;
import opa;
import opg;

public class QggMinusOneViewTitleLayout
  extends FrameLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
  public QggMinusOneViewTitleLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QggMinusOneViewTitleLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    addView(localRelativeLayout);
    localRelativeLayout.getLayoutParams().width = -1;
    localRelativeLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramContext.width = -2;
    paramContext.height = -1;
    paramContext.addRule(11);
    paramContext = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = -1;; i = -16777216)
    {
      paramContext.setTextColor(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(8388613);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(15);
      return;
    }
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt)
  {
    if ((StringUtil.isEmpty(paramString)) || (paramImageView == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130850736);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = UIUtils.dip2px(getContext(), 40.0F);
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = (localURLDrawableOptions.mRequestHeight * 3 + UIUtils.dip2px(getContext(), 10.0F));
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width;
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString == null) {
          break;
        }
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramInt = -1;
          paramString.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
          paramImageView.setBackgroundDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramImageView.setVisibility(8);
        return;
      }
      paramInt = -16777216;
    }
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if ((StringUtil.isEmpty(paramString)) || (paramTextView == null)) {
      return;
    }
    paramTextView.setText(paramString);
  }
  
  public void setMinusViewTitle(opa paramopa)
  {
    if (paramopa == null) {
      return;
    }
    if (StringUtil.isEmpty(paramopa.c)) {}
    for (paramopa = "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png";; paramopa = paramopa.c)
    {
      a(paramopa, this.jdField_a_of_type_AndroidWidgetImageView, 0);
      paramopa = opg.a(NetConnInfoCenter.getServerTimeMillis(), "M月d日");
      String str = opg.a(getContext(), new Date());
      a(paramopa + "\n" + str, this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  public void setQggTitle(opa paramopa)
  {
    if (paramopa == null) {
      return;
    }
    if (StringUtil.isEmpty(paramopa.d)) {}
    for (paramopa = "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png";; paramopa = paramopa.d)
    {
      a(paramopa, this.jdField_a_of_type_AndroidWidgetImageView, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.QggMinusOneViewTitleLayout
 * JD-Core Version:    0.7.0.1
 */