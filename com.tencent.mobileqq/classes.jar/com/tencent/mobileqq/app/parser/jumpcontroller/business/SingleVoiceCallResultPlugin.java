package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;

public class SingleVoiceCallResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity)
  {
    paramJumpActivity.finish();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.SingleVoiceCallResultPlugin
 * JD-Core Version:    0.7.0.1
 */