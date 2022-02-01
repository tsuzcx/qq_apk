package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;

public class ShortCutJumpQQComicResultPlugin
  extends BaseResultPlugin
{
  public static void a(JumpActivity paramJumpActivity)
  {
    if (paramJumpActivity.gotoQQComic != null) {
      JumpActivityHelper.b(paramJumpActivity, paramJumpActivity.gotoQQComic);
    }
    paramJumpActivity.finish();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, JumpActivity paramJumpActivity)
  {
    a(paramJumpActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQQComicResultPlugin
 * JD-Core Version:    0.7.0.1
 */