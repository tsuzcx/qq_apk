package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class NearbyChatPie$13
  extends NearbyRelevantObserver
{
  NearbyChatPie$13(NearbyChatPie paramNearbyChatPie) {}
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a.b, 4, "onAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    if (!"tag_nearby_chat".equals(paramString1)) {}
    while ((TextUtils.isEmpty(paramString2)) || (this.a.a == null)) {
      return;
    }
    this.a.ax();
    this.a.a.setText(paramString2);
    this.a.a.selectAll();
    this.a.f = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.13
 * JD-Core Version:    0.7.0.1
 */