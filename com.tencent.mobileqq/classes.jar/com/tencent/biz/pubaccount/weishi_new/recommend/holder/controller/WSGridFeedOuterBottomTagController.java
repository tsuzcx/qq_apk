package com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;

public class WSGridFeedOuterBottomTagController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private stVideoTag jdField_a_of_type_UserGrowthStVideoTag;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public WSGridFeedOuterBottomTagController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void f()
  {
    stVideoTag localstVideoTag = this.jdField_a_of_type_UserGrowthStVideoTag;
    if ((localstVideoTag != null) && (!TextUtils.isEmpty(localstVideoTag.text)))
    {
      Object localObject1;
      if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
      {
        localObject1 = localstVideoTag.textColor;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("#");
        ((StringBuilder)localObject1).append(localstVideoTag.textColor);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if ((!TextUtils.isEmpty(localstVideoTag.bgColor)) && (localstVideoTag.bgColor.startsWith("#")))
      {
        localObject2 = localstVideoTag.bgColor;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append(localstVideoTag.bgColor);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(WeishiUIUtil.d);
      localGradientDrawable.setStroke(WeishiUIUtil.a, Color.parseColor("#4CFFFFFF"));
      if (!WeishiUIUtil.a((String)localObject2)) {
        localObject2 = "#1A000000";
      }
      localGradientDrawable.setColor(Color.parseColor((String)localObject2));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localstVideoTag.text);
      Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!WeishiUIUtil.a((String)localObject1)) {
        localObject1 = "#000000";
      }
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_UserGrowthStVideoTag = ((stSimpleMetaFeed)a()).bottomTag;
  }
  
  protected int b()
  {
    return 2131560421;
  }
  
  protected void b()
  {
    f();
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131363770));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedOuterBottomTagController
 * JD-Core Version:    0.7.0.1
 */