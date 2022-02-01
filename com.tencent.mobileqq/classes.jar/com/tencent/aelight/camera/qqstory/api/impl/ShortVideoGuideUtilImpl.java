package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.common.app.AppInterface;

public class ShortVideoGuideUtilImpl
  implements IShortVideoGuideUtil
{
  public boolean isAllResourceReady(AppInterface paramAppInterface)
  {
    return ShortVideoGuideUtil.a(paramAppInterface);
  }
  
  public boolean isResourceReady(AppInterface paramAppInterface)
  {
    return ShortVideoGuideUtil.b(paramAppInterface);
  }
  
  public boolean startPTVActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    return ShortVideoGuideUtil.a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.ShortVideoGuideUtilImpl
 * JD-Core Version:    0.7.0.1
 */