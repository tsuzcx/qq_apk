package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.PressedSpan;

public class JumpSpan
  extends PressedSpan
{
  private final String a;
  
  public JumpSpan(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3);
    this.a = paramString;
  }
  
  public JumpSpan(String paramString, int paramInt)
  {
    super(-15504151, paramInt, 860716207);
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    ReadInJoyUtils.a(paramView.getContext(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.JumpSpan
 * JD-Core Version:    0.7.0.1
 */