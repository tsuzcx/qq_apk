package com.tencent.mobileqq.app.avgameshare;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameShareUtil$2
  implements AVGameShareUtil.AVGameShareProxy
{
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShareLinkCallback isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" shareUrl: ");
    localStringBuilder.append(paramString);
    QLog.d("AVGameShareUtil", 1, localStringBuilder.toString());
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      new AVGameShareH5Entry(this.a, String.valueOf(this.b), paramString, this.c, this.d, this.e, "", "", "", "").p();
      return;
    }
    QQToast.makeText(this.a, 1, 2131887438, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.2
 * JD-Core Version:    0.7.0.1
 */