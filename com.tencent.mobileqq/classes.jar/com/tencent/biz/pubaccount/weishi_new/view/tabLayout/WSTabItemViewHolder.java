package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;
import com.tencent.qphone.base.util.BaseApplication;

public class WSTabItemViewHolder
{
  public static float a;
  public static float b;
  public static float c;
  private int jdField_a_of_type_Int = 0;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSTabInfo jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabInfo;
  private WSTabLayout.TabContentClickListener jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout$TabContentClickListener;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private TabLayoutCompat.Tab jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  static
  {
    jdField_a_of_type_Float = ScreenUtil.dip2px(22.0F);
    jdField_b_of_type_Float = ScreenUtil.dip2px(15.0F);
    jdField_c_of_type_Float = ScreenUtil.dip2px(2.0F);
  }
  
  public WSTabItemViewHolder(@NonNull View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381252));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381251));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381242));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131381223));
    paramView.setOnClickListener(new WSTabItemViewHolder.1(this));
  }
  
  private String a(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public TabLayoutCompat.Tab a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(153, 153, 153));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(153, 153, 153));
  }
  
  public void a(float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f < 0.6D) {
      paramFloat = 0.6F;
    }
    int i = (int)(paramFloat * 255.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(i, i, i));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void a(WSTabInfo paramWSTabInfo)
  {
    if (paramWSTabInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabInfo = paramWSTabInfo;
    if ((TextUtils.isEmpty(paramWSTabInfo.d())) && (TextUtils.isEmpty(paramWSTabInfo.b())))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(paramWSTabInfo.d()))
    {
      this.jdField_b_of_type_Int = 2;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130851261);
      WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramWSTabInfo.d(), localDrawable);
      return;
    }
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramWSTabInfo.b());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramWSTabInfo.a());
    a(paramWSTabInfo.a());
    if (!TextUtils.isEmpty(paramWSTabInfo.c()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramWSTabInfo.c());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout$TabContentClickListener = paramTabContentClickListener;
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$Tab = paramTab;
  }
  
  public void b(float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f > 0.6D) {
      paramFloat = 0.6F;
    }
    int i = (int)(paramFloat * 255.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(i, i, i));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      String str = a(paramInt);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder
 * JD-Core Version:    0.7.0.1
 */