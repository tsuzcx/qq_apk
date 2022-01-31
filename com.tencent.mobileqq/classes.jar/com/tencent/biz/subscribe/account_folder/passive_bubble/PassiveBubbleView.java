package com.tencent.biz.subscribe.account_folder.passive_bubble;

import ajyc;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import axqw;
import wiv;

public class PassiveBubbleView
  extends LinearLayout
  implements View.OnClickListener
{
  private TextView a;
  
  public PassiveBubbleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PassiveBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PassiveBubbleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    axqw.b(null, "dc00898", "", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void a()
  {
    wiv.a("https://h5.qzone.qq.com/subscription/messagelist?_proxy=1&_wv=1&_wwv=4");
    setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      String str = paramInt + ajyc.a(2131707890);
      this.a.setText(str);
      a("auth_page", "msg_exp", "", "", "", "");
    }
  }
  
  protected void a(Context paramContext)
  {
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(2130838670);
    inflate(paramContext, 2131558678, this);
    this.a = ((TextView)findViewById(2131369944));
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    a();
    a("auth_page", "msg_clk", "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView
 * JD-Core Version:    0.7.0.1
 */