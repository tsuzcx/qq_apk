package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

public class SimpleFeedbackPopupWindow
  extends ReadInJoyBasePopupWindow
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private SimpleFeedbackPopupWindow.Callback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetSimpleFeedbackPopupWindow$Callback;
  protected boolean b = false;
  
  public SimpleFeedbackPopupWindow(Activity paramActivity, SimpleFeedbackPopupWindow.Callback paramCallback)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetSimpleFeedbackPopupWindow$Callback = paramCallback;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560361, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131369351);
    localImageView.setImageResource(2130841844);
    ((TextView)paramLayoutInflater.findViewById(2131369431)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131369435)).setText(HardCodeUtil.a(2131714107));
    paramLayoutInflater.findViewById(2131369415).setVisibility(8);
    paramLayoutInflater.findViewById(2131377830).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new SimpleFeedbackPopupWindow.1(this));
    localImageView.setOnClickListener(new SimpleFeedbackPopupWindow.2(this));
    return paramLayoutInflater;
  }
  
  public void a(View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (!this.b)
    {
      a();
      this.b = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.SimpleFeedbackPopupWindow
 * JD-Core Version:    0.7.0.1
 */