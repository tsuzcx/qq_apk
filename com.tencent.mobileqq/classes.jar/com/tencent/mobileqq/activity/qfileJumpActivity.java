package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import wvv;
import wvw;

public class qfileJumpActivity
  extends BaseActivity
{
  protected int a;
  public String a;
  
  private int a()
  {
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 1)) {}
    while ((!AppConstants.y.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (!AppConstants.z.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
      return -1;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (!AppConstants.y.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        return -2;
      }
    }
    else if (!AppConstants.z.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
      return -2;
    }
    return 0;
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
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 8);
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
    b();
  }
  
  protected void b()
  {
    new Handler().postDelayed(new wvv(this), 10L);
  }
  
  protected void c()
  {
    new Handler().postDelayed(new wvw(this), 10L);
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
    Intent localIntent;
    try
    {
      super.doOnCreate(paramBundle);
      this.jdField_a_of_type_JavaLangString = AppConstants.y;
      paramBundle = getIntent();
      if (paramBundle != null)
      {
        this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("targetUin");
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("device_type", -1);
        int i = a();
        if (i != 0)
        {
          QLog.w("qfileJump", 1, "targetparam no match, modify it " + i);
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_JavaLangString = AppConstants.y;
          paramBundle.putExtra("device_type", this.jdField_a_of_type_Int);
          paramBundle.putExtra("targetUin", this.jdField_a_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(paramBundle.getAction())) && ((paramBundle.getAction().equals("android.intent.action.SEND")) || (paramBundle.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
        {
          a();
          return true;
        }
        if (paramBundle.getBooleanExtra("jump_shortcut_dataline", false))
        {
          if (this.app.isLogin()) {
            break label223;
          }
          localIntent = new Intent();
          localIntent.setClass(this, LoginActivity.class);
          localIntent.addFlags(67371008);
          localIntent.putExtras(paramBundle.getExtras());
          startActivityForResult(localIntent, 9);
          return true;
        }
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    label223:
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (!GesturePWDUtils.getAppForground(this)))
    {
      localIntent = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      localIntent.putExtra("key_gesture_from_jumpactivity", true);
      localIntent.putExtras(paramBundle.getExtras());
      startActivityForResult(localIntent, 9);
      return true;
    }
    c();
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity
 * JD-Core Version:    0.7.0.1
 */