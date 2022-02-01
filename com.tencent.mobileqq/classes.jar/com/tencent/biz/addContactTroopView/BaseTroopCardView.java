package com.tencent.biz.addContactTroopView;

import aisn;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseTroopCardView
  extends RelativeLayout
{
  protected aisn a;
  protected Context a;
  protected QQAppInterface a;
  
  public void setContentView(int paramInt)
  {
    LayoutInflater.from(this.a).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.BaseTroopCardView
 * JD-Core Version:    0.7.0.1
 */