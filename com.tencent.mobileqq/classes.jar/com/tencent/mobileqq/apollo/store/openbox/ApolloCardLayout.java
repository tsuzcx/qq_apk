package com.tencent.mobileqq.apollo.store.openbox;

import aciy;
import aitu;
import aitv;
import aiur;
import aiuz;
import ajjy;
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
import axwd;
import bacm;
import baiu;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ApolloCardLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private aiur jdField_a_of_type_Aiur;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AnimationableProgressView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView;
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
  
  public void a(int paramInt1, aiur paramaiur, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Aiur = paramaiur;
    if (this.jdField_a_of_type_Aiur == null) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView == null)
    {
      paramaiur = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView = new AnimationableProgressView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView, paramaiur);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramaiur = new RelativeLayout.LayoutParams(-2, aciy.a(48.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramaiur.addRule(3, 2131297056);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramaiur.topMargin = aciy.a(9.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(49);
      this.jdField_d_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      super.addView(this.jdField_d_of_type_AndroidWidgetTextView, paramaiur);
    }
    label486:
    int k;
    int j;
    label600:
    Object localObject;
    if (this.jdField_c_of_type_Int == 1)
    {
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.getLayoutParams();
      paramaiur.width = ((int)(paramInt2 * 0.535F));
      paramaiur.height = ((int)(paramInt2 * 0.113F));
      paramaiur.addRule(14);
      paramaiur.addRule(12);
      paramaiur.bottomMargin = ((int)(paramInt3 * 0.129F));
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramaiur.width = ((int)(paramInt2 * 0.78F));
      paramaiur.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        paramaiur.addRule(14);
        paramaiur.addRule(10);
        paramaiur.topMargin = ((int)(paramInt3 * 0.703F));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131297056);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        super.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramaiur);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aiur.jdField_a_of_type_JavaLangString);
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.8F));
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 1) {
        break label1639;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634509));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramaiur.topMargin = ((int)(paramInt3 * 0.806F));
      if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_c_of_type_ComTencentImageURLImageView, paramaiur);
      }
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 1) {
        break label1958;
      }
      paramaiur = getContext().getResources().getDrawable(2130838268);
      k = paramaiur.getIntrinsicWidth();
      j = paramaiur.getIntrinsicHeight();
      if (this.jdField_c_of_type_Int != 2) {
        break label1891;
      }
      i = (int)(k * 0.55F);
      paramInt1 = (int)(j * 0.55F);
      localObject = new RelativeLayout.LayoutParams(i, paramInt1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.588F) - paramInt1 / 2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramaiur);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_b_of_type_ComTencentImageURLImageView, paramaiur);
      }
      paramInt1 = (int)(paramInt2 * 0.2F);
      i = (int)(paramInt2 * 0.252F);
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramaiur.addRule(11);
      paramaiur.addRule(10);
      paramaiur.rightMargin = ((int)(0.103F * paramInt2));
      paramaiur.topMargin = ((int)(0.074F * paramInt3));
      paramaiur.width = paramInt1;
      paramaiur.height = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_g_of_type_JavaLangString)) {
        break label2484;
      }
      paramaiur = aitu.a(Utils.Crc64String(this.jdField_a_of_type_Aiur.jdField_g_of_type_JavaLangString), null, this.jdField_a_of_type_Aiur.jdField_g_of_type_JavaLangString);
      label818:
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramaiur);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramaiur);
      }
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramaiur.addRule(14);
      paramaiur.addRule(12);
      paramaiur.bottomMargin = ((int)(paramInt3 * 0.073F));
      if (this.jdField_d_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_d_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_d_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_ComTencentImageURLImageView, paramaiur);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramInt1 = (int)(paramInt2 * 0.15F);
        paramaiur = (RelativeLayout.LayoutParams)this.jdField_d_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramaiur.addRule(15);
        paramaiur.addRule(9);
        paramaiur.width = paramInt1;
        paramaiur.height = paramInt1;
        this.jdField_d_of_type_ComTencentImageURLImageView.setBackgroundResource(2130838301);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_d_of_type_ComTencentImageURLImageView.setPadding(1, 1, 1, 1);
      }
      if ((!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_d_of_type_JavaLangString)))
      {
        paramaiur = URLDrawable.URLDrawableOptions.obtain();
        paramaiur.mLoadingDrawable = bacm.b();
        paramaiur.mFailedDrawable = paramaiur.mLoadingDrawable;
        localObject = new aitv();
        ((aitv)localObject).jdField_a_of_type_Int = aitu.jdField_a_of_type_Int;
        paramaiur.mExtraInfo = localObject;
        paramaiur = aitu.a(Utils.Crc64String(this.jdField_a_of_type_Aiur.jdField_d_of_type_JavaLangString), paramaiur, this.jdField_a_of_type_Aiur.jdField_d_of_type_JavaLangString);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(paramaiur);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramaiur);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.5F));
        paramaiur = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramaiur.addRule(9);
        paramaiur.addRule(10);
        paramaiur.topMargin = ((int)(paramInt3 * 0.017F));
        paramaiur.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramaiur = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramaiur);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramaiur = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramaiur.addRule(9);
        paramaiur.addRule(10);
        paramaiur.topMargin = ((int)(paramInt3 * 0.065F));
        paramaiur.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        super.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      }
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramaiur.addRule(11);
      paramaiur.addRule(10);
      paramaiur.width = (paramInt3 * 130 / 760);
      paramaiur.height = (paramInt3 * 142 / 760);
      paramaiur.topMargin = ((int)(paramInt3 * 0.45F));
      paramaiur.rightMargin = (paramInt3 * 25 / 760);
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 1) {
        break label2661;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label2649;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label1549:
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
      }
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label1639:
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aiur.jdField_f_of_type_Int + ajjy.a(2131634515));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramaiur.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aiur.jdField_f_of_type_Int + ajjy.a(2131634510));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramaiur.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      paramaiur.topMargin = ((int)(paramInt3 * 0.703F));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        break label486;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        break label486;
      }
      if (this.jdField_c_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        break label486;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(8.0F);
      break label486;
      label1891:
      if (this.jdField_c_of_type_Int == 3)
      {
        i = (int)(k * 0.38F);
        paramInt1 = (int)(j * 0.38F);
        break label600;
      }
      paramInt1 = j;
      i = k;
      if (this.jdField_c_of_type_Int != 4) {
        break label600;
      }
      i = (int)(k * 0.28F);
      paramInt1 = (int)(j * 0.28F);
      break label600;
      label1958:
      if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 2)
      {
        paramaiur = aitu.a("apollo_card_gold_icon.png", null, aitu.a("apollo_card_gold_icon.png"));
        paramInt1 = (int)(paramInt3 * 0.38F);
        localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramaiur);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 3) {
          break label2161;
        }
        paramaiur = aitu.a("apollo_card_crystal_image.png", null, aitu.a("apollo_card_crystal_image.png"));
        paramaiur.startDownload();
        paramInt1 = (int)(paramInt3 * 0.363F);
        localObject = new RelativeLayout.LayoutParams((int)(paramInt3 * 0.3F), paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramaiur);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label2161:
    paramInt1 = (int)(paramInt2 * 0.488F);
    int i = (int)(paramInt3 * 0.531F);
    if ((this.jdField_a_of_type_Aiur.jdField_a_of_type_Short == 3) || (this.jdField_a_of_type_Aiur.h == 1))
    {
      paramInt1 = (int)(paramInt2 * 0.714F);
      i = (int)(paramInt3 * 0.497F);
    }
    for (;;)
    {
      paramaiur = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramaiur.addRule(12);
      paramaiur.addRule(14);
      paramaiur.width = paramInt1;
      paramaiur.height = i;
      paramaiur.bottomMargin = ((int)(paramInt3 * 0.373F));
      if ((3 == this.jdField_a_of_type_Aiur.jdField_a_of_type_Short) || ((this.jdField_a_of_type_Aiur.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aiur.jdField_e_of_type_JavaLangString.endsWith(".gif"))))
      {
        paramaiur = URLDrawable.URLDrawableOptions.obtain();
        paramaiur.mLoadingDrawable = axwd.a;
        paramaiur.mFailedDrawable = axwd.a;
        paramaiur.mExtraInfo = null;
        paramaiur.mPlayGifImage = true;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_e_of_type_JavaLangString))
        {
          localObject = paramaiur;
          if (paramaiur == null) {
            localObject = URLDrawable.URLDrawableOptions.obtain();
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
          }
        }
        for (paramaiur = URLDrawable.getDrawable(this.jdField_a_of_type_Aiur.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);; paramaiur = aitu.a("task_detail" + String.valueOf(this.jdField_a_of_type_Aiur.jdField_a_of_type_Short) + "_" + String.valueOf(this.jdField_a_of_type_Aiur.jdField_a_of_type_Int), paramaiur, aitu.a(this.jdField_a_of_type_Aiur.jdField_a_of_type_Short, this.jdField_a_of_type_Aiur.jdField_a_of_type_Int)))
        {
          this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramaiur);
          break;
        }
        label2484:
        if ("A".equals(this.jdField_a_of_type_Aiur.jdField_b_of_type_JavaLangString))
        {
          paramaiur = aitu.a("apollo_box_card_a_2016_09_20.png", null, aitu.a("apollo_box_card_a_2016_09_20.png"));
          break label818;
        }
        if ("B".equals(this.jdField_a_of_type_Aiur.jdField_b_of_type_JavaLangString))
        {
          paramaiur = aitu.a("apollo_box_card_b_2016_09_20.png", null, aitu.a("apollo_box_card_b_2016_09_20.png"));
          break label818;
        }
        if ("C".equals(this.jdField_a_of_type_Aiur.jdField_b_of_type_JavaLangString))
        {
          paramaiur = aitu.a("apollo_box_card_c_2016_09_20.png", null, aitu.a("apollo_box_card_c_2016_09_20.png"));
          break label818;
        }
        if ("S".equals(this.jdField_a_of_type_Aiur.jdField_b_of_type_JavaLangString))
        {
          paramaiur = aitu.a("apollo_box_card_s_2016_09_20.png", null, aitu.a("apollo_box_card_s_2016_09_20.png"));
          break label818;
        }
        if ("V".equals(this.jdField_a_of_type_Aiur.jdField_b_of_type_JavaLangString))
        {
          paramaiur = aitu.a("apollo_box_card_v_2017_11_03.png", null, aitu.a("apollo_box_card_v_2017_11_03.png"));
          break label818;
          label2649:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1549;
          label2661:
          if ((this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 2) || (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 3))
          {
            if (this.jdField_c_of_type_Int == 1) {
              if (this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                if (!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) {
                  break label3405;
                }
                this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
                this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if ((this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Int != 1)) {
                  break label3427;
                }
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_c_of_type_AndroidWidgetTextView.setText(baiu.a(this.jdField_a_of_type_Aiur.jdField_c_of_type_Long * 1000L));
                localObject = this.jdField_b_of_type_AndroidWidgetTextView;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_c_of_type_JavaLangString)) {
                  break label3416;
                }
                paramaiur = String.valueOf(this.jdField_a_of_type_Aiur.jdField_a_of_type_Long);
                ((TextView)localObject).setText(paramaiur);
                this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
                if (!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) {
                  break label3450;
                }
                if (this.jdField_a_of_type_Aiur.jdField_b_of_type_Long == this.jdField_a_of_type_Aiur.jdField_a_of_type_Long) {
                  break label3439;
                }
                paramaiur = aitu.a("apollo_self_stolen_got_2016_9_22.png", null, aitu.a("apollo_self_stolen_got_2016_9_22.png"));
                this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramaiur);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView = new MultiURLImageView(getContext());
                  super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView);
                }
                paramaiur = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.getLayoutParams();
                paramaiur.addRule(11);
                paramaiur.addRule(12);
                paramaiur.rightMargin = (paramInt3 * 155 / 760);
                paramaiur.bottomMargin = (paramInt3 * 320 / 760);
                paramaiur = new ArrayList();
                localObject = new aiuz();
                ((aiuz)localObject).jdField_a_of_type_Int = (paramInt3 * 46 / 760);
                ((aiuz)localObject).jdField_b_of_type_Int = (paramInt3 * 68 / 760);
                ((aiuz)localObject).jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_END;
                if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 2) {
                  break label3475;
                }
                ((aiuz)localObject).jdField_b_of_type_JavaLangString = "apollo_card_gold_add.png";
                label3048:
                ((aiuz)localObject).jdField_a_of_type_JavaLangString = aitu.a(((aiuz)localObject).jdField_b_of_type_JavaLangString);
                paramaiur.add(localObject);
                if (this.jdField_a_of_type_Aiur.jdField_f_of_type_Int >= 10)
                {
                  paramInt1 = this.jdField_a_of_type_Aiur.jdField_f_of_type_Int % 100 / 10;
                  localObject = new aiuz();
                  if (paramInt1 != 1) {
                    break label3497;
                  }
                  ((aiuz)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                  ((aiuz)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                  if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 2) {
                    break label3528;
                  }
                  ((aiuz)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
                  label3180:
                  ((aiuz)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                  ((aiuz)localObject).jdField_a_of_type_JavaLangString = aitu.a(((aiuz)localObject).jdField_b_of_type_JavaLangString);
                  paramaiur.add(localObject);
                }
                paramInt1 = this.jdField_a_of_type_Aiur.jdField_f_of_type_Int % 10;
                localObject = new aiuz();
                ((aiuz)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                if (paramInt1 != 1) {
                  break label3573;
                }
                ((aiuz)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                ((aiuz)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 2) {
                  break label3604;
                }
                ((aiuz)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
              }
            }
            for (;;)
            {
              ((aiuz)localObject).jdField_a_of_type_JavaLangString = aitu.a(((aiuz)localObject).jdField_b_of_type_JavaLangString);
              paramaiur.add(localObject);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setOrientation(0);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setViewLayoutDatas(paramaiur);
              if (!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) {
                break label3649;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(0);
              return;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              break;
              this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(4);
              break label2727;
              paramaiur = this.jdField_a_of_type_Aiur.jdField_c_of_type_JavaLangString;
              break label2831;
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              break label2837;
              label3439:
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break label2895;
              label3450:
              paramaiur = aitu.a("apollo_other_stolen_got_2016_9_22.png", null, aitu.a("apollo_other_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramaiur);
              break label2895;
              if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 3) {
                break label3048;
              }
              ((aiuz)localObject).jdField_b_of_type_JavaLangString = "apollo_card_crystal_add.png";
              break label3048;
              ((aiuz)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((aiuz)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3138;
              if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 3) {
                break label3180;
              }
              ((aiuz)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              break label3180;
              label3573:
              ((aiuz)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((aiuz)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3283;
              if (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 3) {
                ((aiuz)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
            return;
          }
          label2727:
          label2895:
          label3283:
          label3416:
          label3427:
          this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
          label2831:
          label2837:
          label3138:
          label3405:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          label3475:
          label3497:
          label3528:
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          label3604:
          label3649:
          this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
          if (this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_Aiur.jdField_b_of_type_Long != this.jdField_a_of_type_Aiur.jdField_a_of_type_Long)
            {
              paramaiur = aitu.a("apollo_self_stolen_got_2016_9_22.png", null, aitu.a("apollo_self_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramaiur);
              if (this.jdField_c_of_type_Int == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.a(this.jdField_a_of_type_Aiur.jdField_d_of_type_Int, this.jdField_a_of_type_Aiur.jdField_c_of_type_Int, this.jdField_a_of_type_Aiur.jdField_d_of_type_Long, this.jdField_a_of_type_Aiur.jdField_e_of_type_Long);
                if (TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_f_of_type_JavaLangString)) {
                  break label3871;
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aiur.jdField_f_of_type_JavaLangString);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              label3844:
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null) {
                break label3996;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
              return;
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break;
              label3871:
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
          if (this.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            label3916:
            this.jdField_c_of_type_AndroidWidgetTextView.setText(baiu.a(this.jdField_a_of_type_Aiur.jdField_c_of_type_Long * 1000L));
            localObject = this.jdField_b_of_type_AndroidWidgetTextView;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Aiur.jdField_c_of_type_JavaLangString)) {
              break label4010;
            }
          }
          label3996:
          label4010:
          for (paramaiur = String.valueOf(this.jdField_a_of_type_Aiur.jdField_a_of_type_Long);; paramaiur = this.jdField_a_of_type_Aiur.jdField_c_of_type_JavaLangString)
          {
            ((TextView)localObject).setText(paramaiur);
            paramaiur = aitu.a("apollo_other_stolen_got_2016_9_22.png", null, aitu.a("apollo_other_stolen_got_2016_9_22.png"));
            this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramaiur);
            break label3844;
            break;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break label3916;
          }
        }
        paramaiur = null;
        break label818;
        paramaiur = null;
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  @TargetApi(21)
  protected void dispatchDraw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis();
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null);
      if (this.jdField_a_of_type_Aiur != null)
      {
        if ((this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int != 3)) {
          break label436;
        }
        if (!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) {
          break label317;
        }
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
      label138:
      super.dispatchDraw(paramCanvas);
      if ((this.jdField_a_of_type_Aiur != null) && (!this.jdField_a_of_type_Aiur.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aiur.jdField_g_of_type_Int == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
        if (this.jdField_a_of_type_Aiur.jdField_e_of_type_Int == -1) {
          break label475;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Aiur.jdField_e_of_type_Int);
        label207:
        if (this.jdField_c_of_type_Int != 1) {
          break label488;
        }
        paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int * 0.78F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    for (;;)
    {
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentImageURLImageView, getDrawingTime());
      paramCanvas.restoreToCount(i);
      if (QLog.isColorLevel()) {
        QLog.e("ApolloCardWindow", 2, "ApolloCardLayout onDraw use" + (System.currentTimeMillis() - l));
      }
      return;
      i = paramCanvas.saveLayer(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, null, 1);
      break;
      label317:
      super.drawChild(paramCanvas, this.jdField_c_of_type_ComTencentImageURLImageView, getDrawingTime());
      super.drawChild(paramCanvas, this.jdField_a_of_type_AndroidWidgetTextView, getDrawingTime());
      super.drawChild(paramCanvas, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView, getDrawingTime());
      if (this.jdField_b_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1778384896);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_c_of_type_AndroidGraphicsPath == null) {
        break label138;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      break label138;
      label436:
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        break label138;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      break label138;
      label475:
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1728053248);
      break label207;
      label488:
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      paramInt1 = (int)(this.jdField_a_of_type_Int * 0.037F);
      paramInt2 = (int)(this.jdField_a_of_type_Int * 0.047F);
      paramInt3 = (int)(this.jdField_b_of_type_Int * 0.026F);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(paramInt2 + paramInt1, this.jdField_b_of_type_Int - paramInt3);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.jdField_b_of_type_Int - paramInt3), 90.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, paramInt3, this.jdField_a_of_type_Int - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, this.jdField_a_of_type_Int - paramInt2, this.jdField_b_of_type_Int - paramInt3), 0.0F, 90.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      if (this.jdField_b_of_type_AndroidGraphicsPath == null) {
        this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      paramInt4 = (int)(this.jdField_b_of_type_Int * 0.78F);
      this.jdField_b_of_type_AndroidGraphicsPath.moveTo(paramInt2, paramInt4);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, paramInt3, paramInt1 * 2 + paramInt2, paramInt1 * 2 + paramInt3), 180.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, paramInt3, this.jdField_a_of_type_Int - paramInt2, paramInt1 * 2 + paramInt3), -90.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt2, paramInt4);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
      if (this.jdField_c_of_type_AndroidGraphicsPath == null) {
        this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_c_of_type_AndroidGraphicsPath.reset();
      this.jdField_c_of_type_AndroidGraphicsPath.moveTo(paramInt2 + paramInt1, this.jdField_b_of_type_Int - paramInt3);
      this.jdField_c_of_type_AndroidGraphicsPath.arcTo(new RectF(paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, paramInt1 * 2 + paramInt2, this.jdField_b_of_type_Int - paramInt3), 90.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(paramInt2, paramInt4);
      this.jdField_c_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int - paramInt2, paramInt4);
      this.jdField_c_of_type_AndroidGraphicsPath.arcTo(new RectF(this.jdField_a_of_type_Int - paramInt1 * 2 - paramInt2, this.jdField_b_of_type_Int - paramInt1 * 2 - paramInt3, this.jdField_a_of_type_Int - paramInt2, this.jdField_b_of_type_Int - paramInt3), 0.0F, 90.0F);
      this.jdField_c_of_type_AndroidGraphicsPath.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardLayout
 * JD-Core Version:    0.7.0.1
 */