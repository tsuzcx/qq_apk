package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;

public class MultiVoiceCallResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null) {
        ((IQJumpApi)QRoute.api(IQJumpApi.class)).handleStartGroupAudio(paramJumpActivity, paramIntent);
      }
    }
    else
    {
      paramJumpActivity.finish();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity, paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.MultiVoiceCallResultPlugin
 * JD-Core Version:    0.7.0.1
 */