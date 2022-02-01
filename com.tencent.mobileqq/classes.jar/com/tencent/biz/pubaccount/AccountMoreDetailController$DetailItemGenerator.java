package com.tencent.biz.pubaccount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AccountMoreDetailController$DetailItemGenerator
{
  private ViewGroup a;
  
  public AccountMoreDetailController$DetailItemGenerator(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, String paramString1, String paramString2)
  {
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2131558434, paramViewGroup));
    paramLayoutInflater = (TextView)this.a.findViewById(2131361921);
    paramViewGroup = (TextView)this.a.findViewById(2131361920);
    paramLayoutInflater.setText(paramString1);
    paramViewGroup.setText(paramString2);
  }
  
  public View a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountMoreDetailController.DetailItemGenerator
 * JD-Core Version:    0.7.0.1
 */