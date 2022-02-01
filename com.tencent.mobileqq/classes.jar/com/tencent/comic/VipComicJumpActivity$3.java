package com.tencent.comic;

import android.app.Activity;
import com.tencent.comic.hippy.BoodoHippyBirdge.ICheckPluginListener;
import com.tencent.qphone.base.util.QLog;

final class VipComicJumpActivity$3
  implements BoodoHippyBirdge.ICheckPluginListener
{
  VipComicJumpActivity$3(VipComicJumpActivity.LoadingCondition paramLoadingCondition, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam) {}
  
  public void onResult(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkBoodoPlugin retCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramString);
    QLog.i("VipComicJumpActivity", 1, localStringBuilder.toString());
    VipComicJumpActivity.access$100(paramInt, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */