package com.tencent.mobileqq.app.parser.jumpcontroller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public abstract interface IJumpControllerInterface
{
  public abstract Boolean a(JumpActivity paramJumpActivity, Uri paramUri);
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Intent paramIntent, JumpActivity paramJumpActivity);
  
  public abstract void a(JumpActivity paramJumpActivity);
  
  public abstract void a(JumpActivity paramJumpActivity, long paramLong, String paramString);
  
  public abstract void a(JumpActivity paramJumpActivity, Intent paramIntent);
  
  public abstract void a(JumpActivity paramJumpActivity, Intent paramIntent, int paramInt);
  
  public abstract void a(JumpActivity paramJumpActivity, Intent paramIntent, Uri paramUri);
  
  public abstract void a(JumpActivity paramJumpActivity, String paramString1, String paramString2);
  
  public abstract void a(JumpActivity paramJumpActivity, DevlockInfo paramDevlockInfo);
  
  public abstract void a(JumpActivity paramJumpActivity, boolean paramBoolean);
  
  public abstract void a(JumpActivity paramJumpActivity, boolean paramBoolean, Intent paramIntent);
  
  public abstract void a(QBaseActivity paramQBaseActivity);
  
  public abstract boolean a(JumpActivity paramJumpActivity, String paramString);
  
  public abstract void b(Context paramContext);
  
  public abstract void b(JumpActivity paramJumpActivity, long paramLong, String paramString);
  
  public abstract void b(JumpActivity paramJumpActivity, Intent paramIntent);
  
  public abstract String c(Context paramContext);
  
  public abstract boolean c(JumpActivity paramJumpActivity, Intent paramIntent);
  
  public abstract void d(JumpActivity paramJumpActivity, Intent paramIntent);
  
  public abstract void e(JumpActivity paramJumpActivity, Intent paramIntent);
  
  public abstract boolean f(JumpActivity paramJumpActivity, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.IJumpControllerInterface
 * JD-Core Version:    0.7.0.1
 */