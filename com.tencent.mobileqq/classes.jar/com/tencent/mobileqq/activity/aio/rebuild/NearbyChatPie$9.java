package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class NearbyChatPie$9
  extends NearbyRelevantObserver
{
  NearbyChatPie$9(NearbyChatPie paramNearbyChatPie) {}
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAutoInput, [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(",");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    if (!"tag_nearby_chat".equals(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if (this.a.Y != null)
    {
      this.a.aF();
      this.a.Y.setText(paramString2);
      this.a.Y.selectAll();
      this.a.bk = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9
 * JD-Core Version:    0.7.0.1
 */