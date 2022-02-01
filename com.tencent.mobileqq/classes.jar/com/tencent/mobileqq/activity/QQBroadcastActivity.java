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
  QQBroadcastActivity.Adapter d;
  Handler e = new QQBroadcastActivity.1(this);
  
  private void g()
  {
    Object localObject = this.app.getMessageFacade();
    if (localObject != null)
    {
      int j = ((QQMessageFacade)localObject).w();
      if (j > 0)
      {
        int i = j;
        if (j > 999) {
          i = 999;
        }
        localObject = getIntent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131917002));
        localStringBuilder.append("(");
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        setLeftViewName(((Intent)localObject).putExtra("leftViewText", localStringBuilder.toString()));
        return;
      }
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131917002)));
    }
  }
  
  protected CursorAdapter a()
  {
    if (this.d == null) {
      this.d = new QQBroadcastActivity.Adapter(this, this, this.app.getMessageProxy(0).a(b(), 0));
    }
    return this.d;
  }
  
  protected String b()
  {
    return String.valueOf(AppConstants.QQBROADCAST_MSG_UIN);
  }
  
  protected CharSequence c()
  {
    return getString(2131916962);
  }
  
  protected Cursor d()
  {
    return this.app.getMessageProxy(0).a(b(), 0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void e()
  {
    g();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.getMessageFacade().a(b(), 0);
    g();
    this.rightViewText.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QQBroadcastActivity.Adapter localAdapter = this.d;
    if (localAdapter != null) {
      localAdapter.changeCursor(null);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */