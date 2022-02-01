package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginUserPrivateHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import mqq.app.AppRuntime;

public class GuideBaseFragment
  extends QBaseFragment
{
  protected AppRuntime a;
  protected QBaseActivity b;
  protected GuideBaseFragment.GuideCallBack c;
  protected String d;
  protected LoginUserPrivateHelper e;
  
  public GuideBaseFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public GuideBaseFragment(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.e = new LoginUserPrivateHelper();
  }
  
  public Dialog a(int paramInt)
  {
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt, Dialog paramDialog) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(GuideBaseFragment.GuideCallBack paramGuideCallBack)
  {
    this.c = paramGuideCallBack;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.b = getQBaseActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment
 * JD-Core Version:    0.7.0.1
 */