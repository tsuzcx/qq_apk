package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadInJoyTabTopSearchHeaderController$7
  extends BroadcastReceiver
{
  ReadInJoyTabTopSearchHeaderController$7(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.a.a);
    this.a.b(false, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.7
 * JD-Core Version:    0.7.0.1
 */