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
import anev;
import anew;
import anfv;
import angd;
import anvx;
import bheg;
import bhid;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  private anfv jdField_a_of_type_Anfv;
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
  
  public void a(int paramInt1, anfv paramanfv, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Anfv = paramanfv;
    if (this.jdField_a_of_type_Anfv == null) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView == null)
    {
      paramanfv = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView = new AnimationableProgressView(getContext());
      super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView, paramanfv);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      paramanfv = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(48.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView = new TextView(getContext());
      paramanfv.addRule(3, 2131362769);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramanfv.topMargin = AIOUtils.dp2px(9.0F, getResources());
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(49);
      this.jdField_d_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_d_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      super.addView(this.jdField_d_of_type_AndroidWidgetTextView, paramanfv);
    }
    label486:
    int k;
    int j;
    label600:
    Object localObject;
    if (this.jdField_c_of_type_Int == 1)
    {
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.getLayoutParams();
      paramanfv.width = ((int)(paramInt2 * 0.535F));
      paramanfv.height = ((int)(paramInt2 * 0.113F));
      paramanfv.addRule(14);
      paramanfv.addRule(12);
      paramanfv.bottomMargin = ((int)(paramInt3 * 0.129F));
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
      paramanfv.width = ((int)(paramInt2 * 0.78F));
      paramanfv.addRule(14);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        paramanfv.addRule(14);
        paramanfv.addRule(10);
        paramanfv.topMargin = ((int)(paramInt3 * 0.703F));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131362769);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
        super.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramanfv);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Anfv.jdField_a_of_type_JavaLangString);
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.8F));
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 1) {
        break label1640;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699807));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramanfv.topMargin = ((int)(paramInt3 * 0.806F));
      if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_c_of_type_ComTencentImageURLImageView, paramanfv);
      }
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 1) {
        break label1959;
      }
      paramanfv = getContext().getResources().getDrawable(2130838501);
      k = paramanfv.getIntrinsicWidth();
      j = paramanfv.getIntrinsicHeight();
      if (this.jdField_c_of_type_Int != 2) {
        break label1892;
      }
      i = (int)(k * 0.55F);
      paramInt1 = (int)(j * 0.55F);
      localObject = new RelativeLayout.LayoutParams(i, paramInt1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.588F) - paramInt1 / 2);
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramanfv);
      this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        super.addView(this.jdField_b_of_type_ComTencentImageURLImageView, paramanfv);
      }
      paramInt1 = (int)(paramInt2 * 0.2F);
      i = (int)(paramInt2 * 0.252F);
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramanfv.addRule(11);
      paramanfv.addRule(10);
      paramanfv.rightMargin = ((int)(0.103F * paramInt2));
      paramanfv.topMargin = ((int)(0.074F * paramInt3));
      paramanfv.width = paramInt1;
      paramanfv.height = i;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_g_of_type_JavaLangString)) {
        break label2485;
      }
      paramanfv = anev.a(Utils.Crc64String(this.jdField_a_of_type_Anfv.jdField_g_of_type_JavaLangString), null, this.jdField_a_of_type_Anfv.jdField_g_of_type_JavaLangString);
      label819:
      this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramanfv);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        super.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramanfv);
      }
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramanfv.addRule(14);
      paramanfv.addRule(12);
      paramanfv.bottomMargin = ((int)(paramInt3 * 0.073F));
      if (this.jdField_d_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_d_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_d_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_ComTencentImageURLImageView, paramanfv);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramInt1 = (int)(paramInt2 * 0.15F);
        paramanfv = (RelativeLayout.LayoutParams)this.jdField_d_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramanfv.addRule(15);
        paramanfv.addRule(9);
        paramanfv.width = paramInt1;
        paramanfv.height = paramInt1;
        this.jdField_d_of_type_ComTencentImageURLImageView.setBackgroundResource(2130838523);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_d_of_type_ComTencentImageURLImageView.setPadding(1, 1, 1, 1);
      }
      if ((!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_d_of_type_JavaLangString)))
      {
        paramanfv = URLDrawable.URLDrawableOptions.obtain();
        paramanfv.mLoadingDrawable = bheg.b();
        paramanfv.mFailedDrawable = paramanfv.mLoadingDrawable;
        localObject = new anew();
        ((anew)localObject).jdField_a_of_type_Int = anev.jdField_a_of_type_Int;
        paramanfv.mExtraInfo = localObject;
        paramanfv = anev.a(Utils.Crc64String(this.jdField_a_of_type_Anfv.jdField_d_of_type_JavaLangString), paramanfv, this.jdField_a_of_type_Anfv.jdField_d_of_type_JavaLangString);
        this.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(paramanfv);
      }
      if (this.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, paramanfv);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(paramInt2 * 0.5F));
        paramanfv = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        paramanfv.addRule(9);
        paramanfv.addRule(10);
        paramanfv.topMargin = ((int)(paramInt3 * 0.017F));
        paramanfv.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
        paramanfv = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramanfv);
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        paramanfv = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        paramanfv.addRule(9);
        paramanfv.addRule(10);
        paramanfv.topMargin = ((int)(paramInt3 * 0.065F));
        paramanfv.leftMargin = ((int)(paramInt2 * 0.2F));
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        super.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
      }
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramanfv.addRule(11);
      paramanfv.addRule(10);
      paramanfv.width = (paramInt3 * 130 / 760);
      paramanfv.height = (paramInt3 * 142 / 760);
      paramanfv.topMargin = ((int)(paramInt3 * 0.45F));
      paramanfv.rightMargin = (paramInt3 * 25 / 760);
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 1) {
        break label2662;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label2650;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label1550:
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
      label1640:
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Anfv.jdField_f_of_type_Int + anvx.a(2131699813));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramanfv.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Anfv.jdField_f_of_type_Int + anvx.a(2131699808));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramanfv.topMargin = ((int)(paramInt3 * 0.697F));
        break label486;
      }
      paramanfv.topMargin = ((int)(paramInt3 * 0.703F));
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
      label1892:
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
      label1959:
      if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 2)
      {
        paramanfv = anev.a("apollo_card_gold_icon.png", null, anev.a("apollo_card_gold_icon.png"));
        paramInt1 = (int)(paramInt3 * 0.38F);
        localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramanfv);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 3) {
          break label2162;
        }
        paramanfv = anev.a("apollo_card_crystal_image.png", null, anev.a("apollo_card_crystal_image.png"));
        paramanfv.startDownload();
        paramInt1 = (int)(paramInt3 * 0.363F);
        localObject = new RelativeLayout.LayoutParams((int)(paramInt3 * 0.3F), paramInt1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt3 * 0.574F) - paramInt1 / 2);
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramanfv);
        this.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label2162:
    paramInt1 = (int)(paramInt2 * 0.488F);
    int i = (int)(paramInt3 * 0.531F);
    if ((this.jdField_a_of_type_Anfv.jdField_a_of_type_Short == 3) || (this.jdField_a_of_type_Anfv.h == 1))
    {
      paramInt1 = (int)(paramInt2 * 0.714F);
      i = (int)(paramInt3 * 0.497F);
    }
    for (;;)
    {
      paramanfv = (RelativeLayout.LayoutParams)this.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
      paramanfv.addRule(12);
      paramanfv.addRule(14);
      paramanfv.width = paramInt1;
      paramanfv.height = i;
      paramanfv.bottomMargin = ((int)(paramInt3 * 0.373F));
      if ((3 == this.jdField_a_of_type_Anfv.jdField_a_of_type_Short) || ((this.jdField_a_of_type_Anfv.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_Anfv.jdField_e_of_type_JavaLangString.endsWith(".gif"))))
      {
        paramanfv = URLDrawable.URLDrawableOptions.obtain();
        paramanfv.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        paramanfv.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        paramanfv.mExtraInfo = null;
        paramanfv.mPlayGifImage = true;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_e_of_type_JavaLangString))
        {
          localObject = paramanfv;
          if (paramanfv == null) {
            localObject = URLDrawable.URLDrawableOptions.obtain();
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          }
          if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
          }
        }
        for (paramanfv = URLDrawable.getDrawable(this.jdField_a_of_type_Anfv.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);; paramanfv = anev.a("task_detail" + String.valueOf(this.jdField_a_of_type_Anfv.jdField_a_of_type_Short) + "_" + String.valueOf(this.jdField_a_of_type_Anfv.jdField_a_of_type_Int), paramanfv, anev.a(this.jdField_a_of_type_Anfv.jdField_a_of_type_Short, this.jdField_a_of_type_Anfv.jdField_a_of_type_Int)))
        {
          this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(paramanfv);
          break;
        }
        label2485:
        if ("A".equals(this.jdField_a_of_type_Anfv.jdField_b_of_type_JavaLangString))
        {
          paramanfv = anev.a("apollo_box_card_a_2016_09_20.png", null, anev.a("apollo_box_card_a_2016_09_20.png"));
          break label819;
        }
        if ("B".equals(this.jdField_a_of_type_Anfv.jdField_b_of_type_JavaLangString))
        {
          paramanfv = anev.a("apollo_box_card_b_2016_09_20.png", null, anev.a("apollo_box_card_b_2016_09_20.png"));
          break label819;
        }
        if ("C".equals(this.jdField_a_of_type_Anfv.jdField_b_of_type_JavaLangString))
        {
          paramanfv = anev.a("apollo_box_card_c_2016_09_20.png", null, anev.a("apollo_box_card_c_2016_09_20.png"));
          break label819;
        }
        if ("S".equals(this.jdField_a_of_type_Anfv.jdField_b_of_type_JavaLangString))
        {
          paramanfv = anev.a("apollo_box_card_s_2016_09_20.png", null, anev.a("apollo_box_card_s_2016_09_20.png"));
          break label819;
        }
        if ("V".equals(this.jdField_a_of_type_Anfv.jdField_b_of_type_JavaLangString))
        {
          paramanfv = anev.a("apollo_box_card_v_2017_11_03.png", null, anev.a("apollo_box_card_v_2017_11_03.png"));
          break label819;
          label2650:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1550;
          label2662:
          if ((this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 2) || (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 3))
          {
            if (this.jdField_c_of_type_Int == 1) {
              if (this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                if (!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) {
                  break label3406;
                }
                this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
                this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                if ((this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Int != 1)) {
                  break label3428;
                }
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
                this.jdField_c_of_type_AndroidWidgetTextView.setText(bhid.a(this.jdField_a_of_type_Anfv.jdField_c_of_type_Long * 1000L));
                localObject = this.jdField_b_of_type_AndroidWidgetTextView;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_c_of_type_JavaLangString)) {
                  break label3417;
                }
                paramanfv = String.valueOf(this.jdField_a_of_type_Anfv.jdField_a_of_type_Long);
                ((TextView)localObject).setText(paramanfv);
                this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
                if (!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) {
                  break label3451;
                }
                if (this.jdField_a_of_type_Anfv.jdField_b_of_type_Long == this.jdField_a_of_type_Anfv.jdField_a_of_type_Long) {
                  break label3440;
                }
                paramanfv = anev.a("apollo_self_stolen_got_2016_9_22.png", null, anev.a("apollo_self_stolen_got_2016_9_22.png"));
                this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramanfv);
                if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView = new MultiURLImageView(getContext());
                  super.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView);
                }
                paramanfv = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.getLayoutParams();
                paramanfv.addRule(11);
                paramanfv.addRule(12);
                paramanfv.rightMargin = (paramInt3 * 155 / 760);
                paramanfv.bottomMargin = (paramInt3 * 320 / 760);
                paramanfv = new ArrayList();
                localObject = new angd();
                ((angd)localObject).jdField_a_of_type_Int = (paramInt3 * 46 / 760);
                ((angd)localObject).jdField_b_of_type_Int = (paramInt3 * 68 / 760);
                ((angd)localObject).jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_END;
                if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 2) {
                  break label3476;
                }
                ((angd)localObject).jdField_b_of_type_JavaLangString = "apollo_card_gold_add.png";
                label3049:
                ((angd)localObject).jdField_a_of_type_JavaLangString = anev.a(((angd)localObject).jdField_b_of_type_JavaLangString);
                paramanfv.add(localObject);
                if (this.jdField_a_of_type_Anfv.jdField_f_of_type_Int >= 10)
                {
                  paramInt1 = this.jdField_a_of_type_Anfv.jdField_f_of_type_Int % 100 / 10;
                  localObject = new angd();
                  if (paramInt1 != 1) {
                    break label3498;
                  }
                  ((angd)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                  ((angd)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                  if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 2) {
                    break label3529;
                  }
                  ((angd)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
                  label3181:
                  ((angd)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                  ((angd)localObject).jdField_a_of_type_JavaLangString = anev.a(((angd)localObject).jdField_b_of_type_JavaLangString);
                  paramanfv.add(localObject);
                }
                paramInt1 = this.jdField_a_of_type_Anfv.jdField_f_of_type_Int % 10;
                localObject = new angd();
                ((angd)localObject).jdField_c_of_type_Int = (-paramInt3 * 4 / 760);
                if (paramInt1 != 1) {
                  break label3574;
                }
                ((angd)localObject).jdField_a_of_type_Int = (paramInt3 * 35 / 760);
                ((angd)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
                if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 2) {
                  break label3605;
                }
                ((angd)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_gold_" + paramInt1 + ".png");
              }
            }
            for (;;)
            {
              ((angd)localObject).jdField_a_of_type_JavaLangString = anev.a(((angd)localObject).jdField_b_of_type_JavaLangString);
              paramanfv.add(localObject);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setOrientation(0);
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setViewLayoutDatas(paramanfv);
              if (!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) {
                break label3650;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(0);
              return;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              break;
              this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(4);
              break label2728;
              paramanfv = this.jdField_a_of_type_Anfv.jdField_c_of_type_JavaLangString;
              break label2832;
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              break label2838;
              label3440:
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break label2896;
              label3451:
              paramanfv = anev.a("apollo_other_stolen_got_2016_9_22.png", null, anev.a("apollo_other_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramanfv);
              break label2896;
              if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 3) {
                break label3049;
              }
              ((angd)localObject).jdField_b_of_type_JavaLangString = "apollo_card_crystal_add.png";
              break label3049;
              ((angd)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((angd)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3139;
              if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 3) {
                break label3181;
              }
              ((angd)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              break label3181;
              label3574:
              ((angd)localObject).jdField_a_of_type_Int = (paramInt3 * 55 / 760);
              ((angd)localObject).jdField_b_of_type_Int = (paramInt3 * 80 / 760);
              break label3284;
              if (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 3) {
                ((angd)localObject).jdField_b_of_type_JavaLangString = ("apollo_card_crystal_" + paramInt1 + ".png");
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
            return;
          }
          label2728:
          label2896:
          label3284:
          label3417:
          label3428:
          this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
          label2832:
          label2838:
          label3139:
          label3406:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          label3476:
          label3498:
          label3529:
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          label3605:
          label3650:
          this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
          if (this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean)
          {
            if (this.jdField_a_of_type_Anfv.jdField_b_of_type_Long != this.jdField_a_of_type_Anfv.jdField_a_of_type_Long)
            {
              paramanfv = anev.a("apollo_self_stolen_got_2016_9_22.png", null, anev.a("apollo_self_stolen_got_2016_9_22.png"));
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramanfv);
              if (this.jdField_c_of_type_Int == 1)
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.a(this.jdField_a_of_type_Anfv.jdField_d_of_type_Int, this.jdField_a_of_type_Anfv.jdField_c_of_type_Int, this.jdField_a_of_type_Anfv.jdField_d_of_type_Long, this.jdField_a_of_type_Anfv.jdField_e_of_type_Long);
                if (TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_f_of_type_JavaLangString)) {
                  break label3872;
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
                this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Anfv.jdField_f_of_type_JavaLangString);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
              label3845:
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView == null) {
                break label3997;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxMultiURLImageView.setVisibility(4);
              return;
              this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
              break;
              label3872:
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(0);
              this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxAnimationableProgressView.setVisibility(8);
          if (this.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            label3917:
            this.jdField_c_of_type_AndroidWidgetTextView.setText(bhid.a(this.jdField_a_of_type_Anfv.jdField_c_of_type_Long * 1000L));
            localObject = this.jdField_b_of_type_AndroidWidgetTextView;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_Anfv.jdField_c_of_type_JavaLangString)) {
              break label4011;
            }
          }
          label3997:
          label4011:
          for (paramanfv = String.valueOf(this.jdField_a_of_type_Anfv.jdField_a_of_type_Long);; paramanfv = this.jdField_a_of_type_Anfv.jdField_c_of_type_JavaLangString)
          {
            ((TextView)localObject).setText(paramanfv);
            paramanfv = anev.a("apollo_other_stolen_got_2016_9_22.png", null, anev.a("apollo_other_stolen_got_2016_9_22.png"));
            this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(paramanfv);
            break label3845;
            break;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            break label3917;
          }
        }
        paramanfv = null;
        break label819;
        paramanfv = null;
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
      if (this.jdField_a_of_type_Anfv != null)
      {
        if ((this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 2) && (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int != 3)) {
          break label436;
        }
        if (!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) {
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
      if ((this.jdField_a_of_type_Anfv != null) && (!this.jdField_a_of_type_Anfv.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Anfv.jdField_g_of_type_Int == 0))
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
        if (this.jdField_a_of_type_Anfv.jdField_e_of_type_Int == -1) {
          break label475;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Anfv.jdField_e_of_type_Int);
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