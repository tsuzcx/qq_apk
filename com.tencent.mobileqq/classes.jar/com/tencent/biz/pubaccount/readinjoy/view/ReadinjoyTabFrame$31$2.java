package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.res.Resources;
import bcql;
import onh;
import rhf;

public class ReadinjoyTabFrame$31$2
  implements Runnable
{
  public ReadinjoyTabFrame$31$2(rhf paramrhf) {}
  
  public void run()
  {
    if (onh.g() >= 2)
    {
      bcql.a(this.a.a, 0, this.a.a.getString(2131718435), 0).b(this.a.a.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    ReadinjoyTabFrame.a(this.a.a);
    onh.a("1", "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.31.2
 * JD-Core Version:    0.7.0.1
 */