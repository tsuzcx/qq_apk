package com.tencent.mobileqq.ark.setting;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ArkAppListActivity
  extends IphoneTitleBarActivity
{
  private ViewGroup a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838959);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setOrientation(1);
    int j = AIOUtils.b(20.0F, getResources());
    int i = 0;
    paramBundle.setPadding(0, j, 0, 0);
    this.a = paramBundle;
    paramBundle = getIntent().getStringArrayExtra("intent_extra_authority_app_list");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      j = paramBundle.length;
      while (i < j)
      {
        localLayoutParams = paramBundle[i];
        if (!TextUtils.isEmpty(localLayoutParams))
        {
          FormSimpleItem localFormSimpleItem = new FormSimpleItem(this);
          localFormSimpleItem.setLeftText(localLayoutParams);
          localFormSimpleItem.a(true);
          localFormSimpleItem.setOnClickListener(new ArkAppListActivity.1(this, localLayoutParams));
          this.a.addView(localFormSimpleItem);
        }
        i += 1;
      }
    }
    super.setContentView(this.a);
    super.setTitle(2131887022);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAppListActivity
 * JD-Core Version:    0.7.0.1
 */