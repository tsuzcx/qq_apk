package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class QQTranslucentBrowserActivity
  extends QQBrowserActivity
{
  public QQTranslucentBrowserActivity()
  {
    this.a = QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.class;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131492923);
    paramBundle = findViewById(2131363436);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131492923);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity
 * JD-Core Version:    0.7.0.1
 */