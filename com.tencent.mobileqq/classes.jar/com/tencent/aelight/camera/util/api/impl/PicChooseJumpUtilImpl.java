package com.tencent.aelight.camera.util.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;

public class PicChooseJumpUtilImpl
  implements IPicChooseJumpUtil
{
  public void jumpForAECircle(Context paramContext, Intent paramIntent)
  {
    PicChooseJumpUtil.a(paramContext, paramIntent);
  }
  
  public void jumpWithSinglePicResult(Activity paramActivity, int paramInt)
  {
    PicChooseJumpUtil.b(paramActivity, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.impl.PicChooseJumpUtilImpl
 * JD-Core Version:    0.7.0.1
 */