package com.tencent.mobileqq.activity;

import Override;
import adai;
import affb;
import affc;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.CursorAdapter;
import android.widget.TextView;
import antf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  public affc a;
  public Handler a;
  
  public QQBroadcastActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new affb(this);
  }
  
  private void c()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.a();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.b();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131718523) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131718523)));
      return;
      label99:
      i = j;
    }
  }
  
  public Cursor a()
  {
    return this.app.a(0).a(a(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_Affc == null) {
      this.jdField_a_of_type_Affc = new affc(this, this, this.app.a(0).a(a(), 0));
    }
    return this.jdField_a_of_type_Affc;
  }
  
  protected CharSequence a()
  {
    return getString(2131718502);
  }
  
  public String a()
  {
    return String.valueOf(antf.J);
  }
  
  protected void a()
  {
    c();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.a().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Affc != null) {
      this.jdField_a_of_type_Affc.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */