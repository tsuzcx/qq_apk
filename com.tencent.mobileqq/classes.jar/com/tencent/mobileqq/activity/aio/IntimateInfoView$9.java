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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      IntimateInfoView.a(this.a).a(paramBitmap, paramString);
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("onDecodeTaskCompleted, uin: ");
        paramBitmap.append(paramString);
        paramBitmap.append(", type: ");
        paramBitmap.append(paramInt2);
        QLog.d("intimate_relationship", 2, paramBitmap.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.9
 * JD-Core Version:    0.7.0.1
 */