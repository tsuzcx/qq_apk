package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class QQVasH5PayBrowserActivity
  extends QQBrowserActivity
{
  public QQVasH5PayBrowserActivity()
  {
    this.a = QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.class;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    overridePendingTransition(0, 0);
    return bool;
  }
  
  public void doOnDestroy()
  {
    setResult(-1);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    getWindow().setBackgroundDrawableResource(2131492923);
    findViewById(2131363436).setBackgroundResource(2131492923);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity
 * JD-Core Version:    0.7.0.1
 */