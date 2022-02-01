package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoView$9
  implements DecodeTaskCompletionListener
{
  IntimateInfoView$9(IntimateInfoView paramIntimateInfoView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    do
    {
      return;
      IntimateInfoView.a(this.a).a(paramBitmap, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("intimate_relationship", 2, "onDecodeTaskCompleted, uin: " + paramString + ", type: " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.9
 * JD-Core Version:    0.7.0.1
 */