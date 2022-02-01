package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;

public class WebSecurityVerifyResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    JumpActivity.onWebSecVerifyResult(paramJumpActivity, true, paramIntent);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.WebSecurityVerifyResultPlugin
 * JD-Core Version:    0.7.0.1
 */