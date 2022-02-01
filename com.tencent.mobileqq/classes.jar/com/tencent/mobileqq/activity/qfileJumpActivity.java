package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.utils.JumpForwardPkgUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qfileJumpActivity
  extends BaseActivity
{
  protected String a;
  protected int b;
  
  private int d()
  {
    int i = this.b;
    if ((i != 0) && (i != 1)) {
      return -1;
    }
    if ((!AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.a)) && (!AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(this.a))) {
      return -1;
    }
    if (this.b == 0)
    {
      if (!AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(this.a)) {
        return -2;
      }
    }
    else if (!AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(this.a)) {
      return -2;
    }
    return 0;
  }
  
  private void e()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new qfileJumpActivity.1(this), 10L);
  }
  
  protected void a()
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if (!this.app.isLogin())
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      RouteUtils.a(this, (Intent)localObject2, "/base/login", 8);
      return;
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 8);
      return;
    }
    if (QFileAssistantUtils.a(this.app))
    {
      e();
      return;
    }
    b();
  }
  
  protected void b()
  {
    new Handler().postDelayed(new qfileJumpActivity.2(this), 10L);
  }
  
  protected void c()
  {
    new Handler().postDelayed(new qfileJumpActivity.3(this), 10L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 8)
      {
        b();
        return;
      }
      if (paramInt1 == 9)
      {
        c();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      super.doOnCreate(paramBundle);
      if (!JumpForwardPkgUtil.a(this, true))
      {
        super.finish();
        return false;
      }
      this.a = AppConstants.DATALINE_PC_UIN;
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        this.a = paramBundle.getStringExtra("targetUin");
        this.b = paramBundle.getIntExtra("device_type", -1);
        int i = d();
        Object localObject;
        if (i != 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("targetparam no match, modify it ");
          ((StringBuilder)localObject).append(i);
          QLog.w("qfileJump", 1, ((StringBuilder)localObject).toString());
          this.b = 0;
          this.a = AppConstants.DATALINE_PC_UIN;
          paramBundle.putExtra("device_type", this.b);
          paramBundle.putExtra("targetUin", this.a);
        }
        if ((!TextUtils.isEmpty(paramBundle.getAction())) && ((paramBundle.getAction().equals("android.intent.action.SEND")) || (paramBundle.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
        {
          a();
          return true;
        }
        if (paramBundle.getBooleanExtra("jump_shortcut_dataline", false))
        {
          if (!this.app.isLogin())
          {
            localObject = new Intent();
            ((Intent)localObject).addFlags(67371008);
            ((Intent)localObject).putExtras(paramBundle.getExtras());
            RouteUtils.a(this, (Intent)localObject, "/base/login", 9);
            return true;
          }
          if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
          {
            localObject = new Intent(getActivity(), GesturePWDUnlockActivity.class);
            ((Intent)localObject).putExtra("key_gesture_from_jumpactivity", true);
            ((Intent)localObject).putExtras(paramBundle.getExtras());
            startActivityForResult((Intent)localObject, 9);
            return true;
          }
          c();
          return true;
        }
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public boolean showPreview()
  {
    try
    {
      boolean bool = JumpForwardPkgManager.a(this);
      if (bool) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity
 * JD-Core Version:    0.7.0.1
 */