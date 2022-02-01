package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Observer;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  Handler jdField_a_of_type_AndroidOsHandler = new QQBroadcastActivity.1(this);
  QQBroadcastActivity.Adapter jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter;
  
  private void c()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
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
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131719718) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131719718)));
      return;
      label99:
      i = j;
    }
  }
  
  protected Cursor a()
  {
    return this.app.getMessageProxy(0).a(a(), 0);
  }
  
  protected CursorAdapter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter = new QQBroadcastActivity.Adapter(this, this, this.app.getMessageProxy(0).a(a(), 0));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter;
  }
  
  protected CharSequence a()
  {
    return getString(2131719682);
  }
  
  protected String a()
  {
    return String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
  }
  
  protected void a()
  {
    c();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    this.app.getMessageFacade().c(a(), 0);
    c();
    this.rightViewText.setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$Adapter.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */