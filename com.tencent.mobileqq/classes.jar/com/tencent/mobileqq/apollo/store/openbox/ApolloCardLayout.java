package com.tencent.mobileqq.apollo.store.openbox;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ApolloCardLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AnimationableProgressView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView;
  private ApolloBoxData.ApolloBoxDataItem jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem;
  private MultiURLImageView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView;
  private int jdField_b_of_type_Int;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private int jdField_c_of_type_Int;
  private Path jdField_c_of_type_AndroidGraphicsPath;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  
  public ApolloCardLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ApolloCardLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
  }
  
  public void a(int paramInt1, ApolloBoxData.ApolloBoxDataItem paramApolloBoxDataItem, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem = paramApolloBoxDataItem;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem == null) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView == null)
    {
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView = new AnimationableProgressView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView, paramApolloBoxDataItem);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, AIOUtils.b(48.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramApolloBoxDataItem.addRule(3, 2131362750);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramApolloBoxDataItem.topMargin = AIOUtils.b(9.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(49);
      this.jdField_d_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      super.addView(this.jdField_d_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.getLayoutParams();
      f1 = paramInt2;
      paramApolloBoxDataItem.width = ((int)(0.535F * f1));
      paramApolloBoxDataItem.height = ((int)(0.113F * f1));
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.bottomMargin = ((int)(paramInt3 * 0.129F));
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramApolloBoxDataItem.width = ((int)(f1 * 0.78F));
      paramApolloBoxDataItem.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.addRule(10);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.703F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362750);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      super.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_JavaLangString);
    paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    float f3 = paramInt2;
    ((TextView)localObject).setMaxWidth((int)(0.8F * f3));
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700527));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.806F));
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int);
      localStringBuilder.append(HardCodeUtil.a(2131700533));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.697F));
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int);
      localStringBuilder.append(HardCodeUtil.a(2131700528));
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.697F));
    }
    else
    {
      paramApolloBoxDataItem.topMargin = ((int)(paramInt3 * 0.703F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramInt1 = this.jdField_c_of_type_Int;
      if (paramInt1 == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      } else if (paramInt1 == 2) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      } else if (paramInt1 == 3) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      }
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      super.addView(this.jdField_c_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 1)
    {
      paramApolloBoxDataItem = getContext().getResources().getDrawable(2130838417);
      int j = paramApolloBoxDataItem.getIntrinsicWidth();
      int i = paramApolloBoxDataItem.getIntrinsicHeight();
      int k = this.jdField_c_of_type_Int;
      float f2;
      if (k == 2)
      {
        paramInt1 = (int)(j * 0.55F);
        f1 = i;
        f2 = 0.55F;
      }
      for (;;)
      {
        paramInt2 = (int)(f1 * f2);
        break;
        if (k == 3)
        {
          paramInt1 = (int)(j * 0.38F);
          f1 = i;
          f2 = 0.38F;
        }
        else
        {
          paramInt1 = j;
          paramInt2 = i;
          if (k != 4) {
            break;
          }
          paramInt1 = (int)(j * 0.28F);
          f1 = i;
          f2 = 0.28F;
        }
      }
      localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.588F) - paramInt2 / 2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
    {
      f1 = paramInt3;
      paramInt1 = (int)(0.38F * f1);
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.bottomMargin = ((int)(f1 * 0.574F) - paramInt1 / 2);
      localObject = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_icon.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_icon.png"));
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(paramApolloBoxDataItem);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3)
    {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_image.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_image.png"));
      paramApolloBoxDataItem.startDownload();
      f1 = paramInt3;
      paramInt1 = (int)(0.363F * f1);
      localObject = new RelativeLayout.LayoutParams((int)(0.3F * f1), paramInt1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(f1 * 0.574F) - paramInt1 / 2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      paramInt1 = (int)(0.488F * f3);
      f1 = paramInt3;
      paramInt2 = (int)(0.531F * f1);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short == 3) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.h == 1))
      {
        paramInt1 = (int)(0.714F * f3);
        paramInt2 = (int)(0.497F * f1);
      }
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.addRule(14);
      paramApolloBoxDataItem.width = paramInt1;
      paramApolloBoxDataItem.height = paramInt2;
      paramApolloBoxDataItem.bottomMargin = ((int)(f1 * 0.373F));
      if ((3 != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short) && ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString.endsWith(".gif"))))
      {
        paramApolloBoxDataItem = null;
      }
      else
      {
        paramApolloBoxDataItem = URLDrawable.URLDrawableOptions.obtain();
        paramApolloBoxDataItem.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramApolloBoxDataItem.mFailedDrawable = URLDrawableHelperConstants.a;
        paramApolloBoxDataItem.mExtraInfo = null;
        paramApolloBoxDataItem.mPlayGifImage = true;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString))
      {
        localObject = paramApolloBoxDataItem;
        if (paramApolloBoxDataItem == null) {
          localObject = URLDrawable.URLDrawableOptions.obtain();
        }
        if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        }
        if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
        }
        paramApolloBoxDataItem = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      }
      else
      {
        localObject = (IApolloUtil)QRoute.api(IApolloUtil.class);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task_detail");
        localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short));
        localStringBuilder.append("_");
        localStringBuilder.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Int));
        paramApolloBoxDataItem = ((IApolloUtil)localObject).getDrawable(localStringBuilder.toString(), paramApolloBoxDataItem, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getBoxFloatUrl(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Short, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Int));
      }
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
    }
    if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      super.addView(this.jdField_b_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
    }
    paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramApolloBoxDataItem.addRule(11);
    paramApolloBoxDataItem.addRule(10);
    paramApolloBoxDataItem.rightMargin = ((int)(0.103F * f3));
    float f1 = paramInt3;
    paramApolloBoxDataItem.topMargin = ((int)(0.074F * f1));
    paramInt1 = (int)(0.2F * f3);
    paramInt2 = (int)(0.252F * f3);
    paramApolloBoxDataItem.width = paramInt1;
    paramApolloBoxDataItem.height = paramInt2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString), null, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_JavaLangString);
    } else if ("A".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_box_card_a_2016_09_20.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_box_card_a_2016_09_20.png"));
    } else if ("B".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_box_card_b_2016_09_20.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_box_card_b_2016_09_20.png"));
    } else if ("C".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_box_card_c_2016_09_20.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_box_card_c_2016_09_20.png"));
    } else if ("S".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_box_card_s_2016_09_20.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_box_card_s_2016_09_20.png"));
    } else if ("V".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_JavaLangString)) {
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_box_card_v_2017_11_03.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_box_card_v_2017_11_03.png"));
    } else {
      paramApolloBoxDataItem = null;
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramApolloBoxDataItem);
    }
    paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramApolloBoxDataItem.addRule(14);
    paramApolloBoxDataItem.addRule(12);
    paramApolloBoxDataItem.bottomMargin = ((int)(0.073F * f1));
    if (this.jdField_d_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_d_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_d_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_ComTencentImageURLImageView, paramApolloBoxDataItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_d_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(15);
      paramApolloBoxDataItem.addRule(9);
      paramInt2 = (int)(0.15F * f3);
      paramApolloBoxDataItem.width = paramInt2;
      paramApolloBoxDataItem.height = paramInt2;
      this.jdField_d_of_type_ComTencentImageURLImageView.setBackgroundResource(2130838440);
      this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_d_of_type_ComTencentImageURLImageView.setPadding(1, 1, 1, 1);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString)))
    {
      paramApolloBoxDataItem = URLDrawable.URLDrawableOptions.obtain();
      paramApolloBoxDataItem.mLoadingDrawable = ImageUtil.e();
      paramApolloBoxDataItem.mFailedDrawable = paramApolloBoxDataItem.mLoadingDrawable;
      localObject = new ApolloDrawableExtraInfo();
      ((ApolloDrawableExtraInfo)localObject).mDrawableType = ApolloConstant.jdField_g_of_type_Int;
      paramApolloBoxDataItem.mExtraInfo = localObject;
      paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString), paramApolloBoxDataItem, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(paramApolloBoxDataItem);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(f3 * 0.5F));
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramApolloBoxDataItem.addRule(9);
      paramApolloBoxDataItem.addRule(10);
      paramApolloBoxDataItem.topMargin = ((int)(0.017F * f1));
      paramApolloBoxDataItem.leftMargin = paramInt1;
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramApolloBoxDataItem = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramApolloBoxDataItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
      paramApolloBoxDataItem.addRule(9);
      paramApolloBoxDataItem.addRule(10);
      paramApolloBoxDataItem.topMargin = ((int)(0.065F * f1));
      paramApolloBoxDataItem.leftMargin = paramInt1;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
    paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramApolloBoxDataItem.addRule(11);
    paramApolloBoxDataItem.addRule(10);
    paramApolloBoxDataItem.width = (paramInt3 * 130 / 760);
    paramApolloBoxDataItem.height = (paramInt3 * 142 / 760);
    paramApolloBoxDataItem.topMargin = ((int)(f1 * 0.45F));
    paramApolloBoxDataItem.rightMargin = (paramInt3 * 25 / 760);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 1)
    {
      if (this.jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView;
      if (paramApolloBoxDataItem != null) {
        paramApolloBoxDataItem.setVisibility(4);
      }
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3))
    {
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long)
        {
          paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_self_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_self_stolen_got_2016_9_22.png"));
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
        }
        else
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
        }
        if (this.jdField_c_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Long);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_JavaLangString))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_JavaLangString);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
        if (this.jdField_c_of_type_Int == 1) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        } else {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Long * 1000L));
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
          paramApolloBoxDataItem = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long);
        } else {
          paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString;
        }
        ((TextView)localObject).setText(paramApolloBoxDataItem);
        paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_other_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_other_stolen_got_2016_9_22.png"));
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
      }
      paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView;
      if (paramApolloBoxDataItem != null) {
        paramApolloBoxDataItem.setVisibility(4);
      }
    }
    else
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
      else {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      } else {
        this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(4);
      }
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Int == 1))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(TimeFormatterUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_Long * 1000L));
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString)) {
          paramApolloBoxDataItem = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long);
        } else {
          paramApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_c_of_type_JavaLangString;
        }
        ((TextView)localObject).setText(paramApolloBoxDataItem);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Long)
        {
          paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_self_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_self_stolen_got_2016_9_22.png"));
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
        }
        else
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
        }
      }
      else
      {
        paramApolloBoxDataItem = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_other_stolen_got_2016_9_22.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_other_stolen_got_2016_9_22.png"));
        this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramApolloBoxDataItem);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView = new MultiURLImageView(getContext());
        super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView);
      }
      paramApolloBoxDataItem = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.getLayoutParams();
      paramApolloBoxDataItem.addRule(11);
      paramApolloBoxDataItem.addRule(12);
      paramApolloBoxDataItem.rightMargin = (paramInt3 * 155 / 760);
      paramApolloBoxDataItem.bottomMargin = (paramInt3 * 320 / 760);
      localObject = new MultiURLImageView.ViewLayoutData();
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 46 / 760);
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 68 / 760);
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_END;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2) {
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = "apollo_card_gold_add.png";
      } else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3) {
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = "apollo_card_crystal_add.png";
      }
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
      paramApolloBoxDataItem = new ArrayList();
      paramApolloBoxDataItem.add(localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int >= 10)
      {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int % 100 / 10;
        localObject = new MultiURLImageView.ViewLayoutData();
        if (paramInt1 == 1)
        {
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
        }
        else
        {
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("apollo_card_gold_");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(".png");
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("apollo_card_crystal_");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(".png");
          ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
        }
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
        paramApolloBoxDataItem.add(localObject);
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_f_of_type_Int % 10;
      localObject = new MultiURLImageView.ViewLayoutData();
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
      if (paramInt1 == 1)
      {
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
      }
      else
      {
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_card_gold_");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".png");
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_card_crystal_");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".png");
        ((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      }
      ((MultiURLImageView.ViewLayoutData)localObject).jdField_a_of_type_JavaLangString = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl(((MultiURLImageView.ViewLayoutData)localObject).jdField_b_of_type_JavaLangString);
      paramApolloBoxDataItem.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setOrientation(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setViewLayoutDatas(paramApolloBoxDataItem);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
    }
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(21)
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null);
    } else {
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null, 1);
    }
    ApolloBoxData.ApolloBoxDataItem localApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem;
    if (localApolloBoxDataItem != null) {
      if ((localApolloBoxDataItem.jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int != 3))
      {
        if (this.jdField_a_of_type_AndroidGraphicsPath != null)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsPath != null)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(654311423);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      else
      {
        super.drawChild(paramCanvas, this.jdField_c_of_type_ComTencentImageURLImageView, getDrawingTime());
        super.drawChild(paramCanvas, this.jdField_a_of_type_AndroidWidgetTextView, getDrawingTime());
        super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView, getDrawingTime());
        if (this.jdField_b_of_type_AndroidGraphicsPath != null)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1778384896);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        if (this.jdField_c_of_type_AndroidGraphicsPath != null)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
          paramCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
    super.dispatchDraw(paramCanvas);
    localApolloBoxDataItem = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem;
    if ((localApolloBoxDataItem != null) && (!localApolloBoxDataItem.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_g_of_type_Int == 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData$ApolloBoxDataItem.jdField_e_of_type_Int);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1728053248);
      }
      if (this.jdField_c_of_type_Int == 1) {
        paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, 0.78F * this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      } else {
        paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentImageURLImageView, getDrawingTime());
    }
    paramCanvas.restoreToCount(i);
    if (QLog.isColorLevel())
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("ApolloCardLayout onDraw use");
      paramCanvas.append(System.currentTimeMillis() - l);
      QLog.e("[cmshow]ApolloCardWindow", 2, paramCanvas.toString());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      }
      paramInt1 = this.jdField_a_of_type_Int;
      paramInt3 = (int)(paramInt1 * 0.037F);
      paramInt1 = (int)(paramInt1 * 0.047F);
      paramInt2 = (int)(this.jdField_b_of_type_Int * 0.026F);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      float f1 = paramInt1 + paramInt3;
      localPath.moveTo(f1, this.jdField_b_of_type_Int - paramInt2);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      float f2 = paramInt1;
      paramInt4 = this.jdField_b_of_type_Int;
      paramInt3 *= 2;
      float f4 = paramInt4 - paramInt3 - paramInt2;
      float f3 = paramInt1 + paramInt3;
      localPath.arcTo(new RectF(f2, f4, f3, paramInt4 - paramInt2), 90.0F, 90.0F);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      f4 = paramInt2;
      float f5 = paramInt2 + paramInt3;
      localPath.arcTo(new RectF(f2, f4, f3, f5), 180.0F, 90.0F);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      paramInt4 = this.jdField_a_of_type_Int;
      localPath.arcTo(new RectF(paramInt4 - paramInt3 - paramInt1, f4, paramInt4 - paramInt1, f5), -90.0F, 90.0F);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      paramInt4 = this.jdField_a_of_type_Int;
      float f6 = paramInt4 - paramInt3 - paramInt1;
      int i = this.jdField_b_of_type_Int;
      localPath.arcTo(new RectF(f6, i - paramInt3 - paramInt2, paramInt4 - paramInt1, i - paramInt2), 0.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      if (this.jdField_b_of_type_AndroidGraphicsPath == null) {
        this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      paramInt4 = (int)(this.jdField_b_of_type_Int * 0.78F);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      f6 = paramInt4;
      localPath.moveTo(f2, f6);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(new RectF(f2, f4, f3, f5), 180.0F, 90.0F);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      paramInt4 = this.jdField_a_of_type_Int;
      localPath.arcTo(new RectF(paramInt4 - paramInt3 - paramInt1, f4, paramInt4 - paramInt1, f5), -90.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt1, f6);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      if (this.jdField_c_of_type_AndroidGraphicsPath == null) {
        this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(f1, this.jdField_b_of_type_Int - paramInt2);
      localPath = this.jdField_c_of_type_AndroidGraphicsPath;
      paramInt4 = this.jdField_b_of_type_Int;
      localPath.arcTo(new RectF(f2, paramInt4 - paramInt3 - paramInt2, f3, paramInt4 - paramInt2), 90.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(f2, f6);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt1, f6);
      localPath = this.jdField_c_of_type_AndroidGraphicsPath;
      paramInt4 = this.jdField_a_of_type_Int;
      f1 = paramInt4 - paramInt3 - paramInt1;
      i = this.jdField_b_of_type_Int;
      localPath.arcTo(new RectF(f1, i - paramInt3 - paramInt2, paramInt4 - paramInt1, i - paramInt2), 0.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardLayout
 * JD-Core Version:    0.7.0.1
 */