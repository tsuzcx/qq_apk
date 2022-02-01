package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.JumpActivity;
import mqq.os.MqqHandler;

public class ShortCutJumpQFileResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity)
  {
    new MqqHandler(Looper.getMainLooper()).postDelayed(new ShortCutJumpQFileResultPlugin.1(paramJumpActivity), 10L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQFileResultPlugin
 * JD-Core Version:    0.7.0.1
 */