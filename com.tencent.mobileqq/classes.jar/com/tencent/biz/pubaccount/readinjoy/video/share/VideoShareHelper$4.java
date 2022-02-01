package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class VideoShareHelper$4
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  VideoShareHelper$4(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!VideoShareHelper.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(VideoShareHelper.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(QQToast.a(2));
      paramString2.c(2131692259);
      paramString2.b(VideoShareHelper.a(this.a).getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(VideoShareHelper.a(this.a), 5.0F));
    }
    for (;;)
    {
      VideoShareHelper.a(this.a).remove(paramString1);
      return;
      paramString2.a(QQToast.a(1));
      paramString2.c(2131692260);
      paramString2.b(VideoShareHelper.a(this.a).getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(VideoShareHelper.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.4
 * JD-Core Version:    0.7.0.1
 */