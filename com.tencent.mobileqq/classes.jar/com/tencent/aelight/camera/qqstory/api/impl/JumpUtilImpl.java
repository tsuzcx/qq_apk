package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;

public class JumpUtilImpl
  implements IJumpUtil
{
  public String getCircleScheme(String paramString1, String paramString2)
  {
    return JumpUtil.a(paramString1, paramString2);
  }
  
  public String getSchemeForTail(@Nullable String paramString)
  {
    return JumpUtil.a(paramString);
  }
  
  public Bundle handleWidgetInfo(Bundle paramBundle, String paramString)
  {
    return JumpUtil.a(paramBundle, paramString);
  }
  
  public void jumpToCameraActivityForAio(Activity paramActivity, String paramString)
  {
    JumpUtil.a(paramActivity, paramString);
  }
  
  public void jumpToCameraForTakeSameGif(Activity paramActivity, String paramString)
  {
    JumpUtil.b(paramActivity, paramString);
  }
  
  public void jumpToSlideShowEditVideoActivityForQzone(Activity paramActivity, Bundle paramBundle)
  {
    JumpUtil.a(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.JumpUtilImpl
 * JD-Core Version:    0.7.0.1
 */