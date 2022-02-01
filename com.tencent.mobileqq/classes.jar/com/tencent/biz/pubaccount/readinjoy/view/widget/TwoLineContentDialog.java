package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;

public class TwoLineContentDialog
  extends QQCustomDialog
{
  AnimationTextView a;
  
  public TwoLineContentDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131377669));
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TwoLineContentDialog
 * JD-Core Version:    0.7.0.1
 */