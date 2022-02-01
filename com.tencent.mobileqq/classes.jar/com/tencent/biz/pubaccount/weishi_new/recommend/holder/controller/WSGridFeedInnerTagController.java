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

public class WSGridFeedInnerTagController
  extends AbsWsUIGroup<stSimpleMetaFeed>
{
  private stVideoTag a;
  public TextView a;
  
  public WSGridFeedInnerTagController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void f()
  {
    stVideoTag localstVideoTag = this.jdField_a_of_type_UserGrowthStVideoTag;
    if ((localstVideoTag == null) || (TextUtils.isEmpty(localstVideoTag.text)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    String str;
    Object localObject;
    label83:
    GradientDrawable localGradientDrawable;
    if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
    {
      str = localstVideoTag.textColor;
      if ((TextUtils.isEmpty(localstVideoTag.bgColor)) || (!localstVideoTag.bgColor.startsWith("#"))) {
        break label205;
      }
      localObject = localstVideoTag.bgColor;
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(WeishiUIUtil.d);
      localGradientDrawable.setStroke(WeishiUIUtil.a, Color.parseColor("#4CFFFFFF"));
      if (!WeishiUIUtil.a((String)localObject)) {
        break label231;
      }
      label121:
      localGradientDrawable.setColor(Color.parseColor((String)localObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localstVideoTag.text);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!WeishiUIUtil.a(str)) {
        break label237;
      }
    }
    for (;;)
    {
      ((TextView)localObject).setTextColor(Color.parseColor(str));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      str = "#" + localstVideoTag.textColor;
      break;
      label205:
      localObject = "#" + localstVideoTag.bgColor;
      break label83;
      label231:
      localObject = "#80000000";
      break label121;
      label237:
      str = "#FFFFFF";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_UserGrowthStVideoTag = ((stSimpleMetaFeed)a()).videoTag;
  }
  
  public int b()
  {
    return 2131560540;
  }
  
  public void b()
  {
    f();
  }
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369400));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTagController
 * JD-Core Version:    0.7.0.1
 */