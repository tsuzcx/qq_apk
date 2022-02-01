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
  public static float a = ScreenUtil.dip2px(22.0F);
  public static float b = ScreenUtil.dip2px(15.0F);
  public static float c = ScreenUtil.dip2px(2.0F);
  private WSTabLayout.TabContentClickListener d;
  private TextView e;
  private TextView f;
  private TextView g;
  private KandianUrlImageView h;
  private int i = 0;
  private WSTabInfo j;
  private TabLayoutCompat.Tab k;
  private int l;
  
  public WSTabItemViewHolder(@NonNull View paramView)
  {
    this.e = ((TextView)paramView.findViewById(2131450300));
    this.f = ((TextView)paramView.findViewById(2131450299));
    this.g = ((TextView)paramView.findViewById(2131450290));
    this.h = ((KandianUrlImageView)paramView.findViewById(2131450271));
    paramView.setOnClickListener(new WSTabItemViewHolder.1(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setTypeface(Typeface.defaultFromStyle(1));
      return;
    }
    this.e.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private String c(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.e.setTextColor(Color.rgb(153, 153, 153));
    this.f.setTextColor(Color.rgb(153, 153, 153));
  }
  
  public void a(float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = 1.0F;
    }
    paramFloat = f1;
    if (f1 < 0.6D) {
      paramFloat = 0.6F;
    }
    int m = (int)(paramFloat * 255.0F);
    this.e.setTextColor(Color.rgb(m, m, m));
  }
  
  public void a(int paramInt)
  {
    this.e.setTextColor(paramInt);
    this.f.setTextColor(paramInt);
  }
  
  public void a(WSTabInfo paramWSTabInfo)
  {
    if (paramWSTabInfo == null) {
      return;
    }
    this.j = paramWSTabInfo;
    if ((TextUtils.isEmpty(paramWSTabInfo.d())) && (TextUtils.isEmpty(paramWSTabInfo.b())))
    {
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(paramWSTabInfo.d()))
    {
      this.l = 2;
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.h.setVisibility(0);
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130853523);
      WSPicLoader.a().a(this.h, paramWSTabInfo.d(), localDrawable);
      return;
    }
    this.l = 1;
    this.e.setVisibility(0);
    this.h.setVisibility(8);
    this.e.setText(paramWSTabInfo.b());
    this.e.setTextSize(paramWSTabInfo.f());
    a(paramWSTabInfo.e());
    if (!TextUtils.isEmpty(paramWSTabInfo.c()))
    {
      this.f.setVisibility(0);
      this.f.setText(paramWSTabInfo.c());
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void a(WSTabLayout.TabContentClickListener paramTabContentClickListener)
  {
    this.d = paramTabContentClickListener;
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    this.k = paramTab;
  }
  
  public TabLayoutCompat.Tab b()
  {
    return this.k;
  }
  
  public void b(float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    float f1 = paramFloat;
    if (paramFloat > 0.6D) {
      f1 = 0.6F;
    }
    int m = (int)(f1 * 255.0F);
    this.e.setTextColor(Color.rgb(m, m, m));
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
    if (paramInt > 0)
    {
      this.g.setVisibility(0);
      String str = c(paramInt);
      this.g.setText(str);
      return;
    }
    this.g.setVisibility(8);
  }
  
  public int c()
  {
    return this.i;
  }
  
  public TextView d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder
 * JD-Core Version:    0.7.0.1
 */