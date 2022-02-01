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
  public TextView g;
  private stVideoTag h;
  
  public WSGridFeedInnerTagController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void l()
  {
    stVideoTag localstVideoTag = this.h;
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
        localObject2 = "#80000000";
      }
      localGradientDrawable.setColor(Color.parseColor((String)localObject2));
      this.g.setText(localstVideoTag.text);
      Object localObject2 = this.g;
      if (!WeishiUIUtil.a((String)localObject1)) {
        localObject1 = "#FFFFFF";
      }
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      this.g.setBackgroundDrawable(localGradientDrawable);
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  protected void a()
  {
    this.h = ((stSimpleMetaFeed)c()).videoTag;
  }
  
  protected void b()
  {
    l();
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626475;
  }
  
  protected void j()
  {
    this.g = ((TextView)c(2131436098));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.holder.controller.WSGridFeedInnerTagController
 * JD-Core Version:    0.7.0.1
 */