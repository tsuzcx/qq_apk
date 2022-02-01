package com.tencent.mobileqq.activity.contact.newfriend;

import Override;
import aizi;
import aizr;
import amik;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendMoreSysMsgActivity
  extends BaseActivity
{
  private amik a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, NewFriendMoreSysMsgActivity.class);
    localIntent.putExtra("first_visible_index", paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("first_visible_index", 0);
    setContentView(2131561300);
    paramBundle = (LinearLayout)findViewById(2131376947);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    paramBundle = (SwipListView)findViewById(2131378382);
    View localView = findViewById(2131372003);
    TextView localTextView = (TextView)findViewById(2131369278);
    localTextView.setVisibility(0);
    localTextView.setText(2131694275);
    setTitle(getString(2131694275));
    localTextView = (TextView)findViewById(2131369231);
    localTextView.setVisibility(0);
    localTextView.setText("");
    localTextView.setOnClickListener(new aizr(this));
    localTextView = (TextView)findViewById(2131369262);
    localTextView.setVisibility(0);
    localTextView.setText(2131698931);
    this.a = new amik(this, this.app, paramBundle, localView, localTextView, this.mFlingHandler, i);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    aizi localaizi = (aizi)this.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
    localaizi.g();
    localaizi.k();
    this.a.a();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity
 * JD-Core Version:    0.7.0.1
 */