package com.tencent.biz.qqcircle.polylike;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;

final class QCirclePolyLikeManager$1
  implements Call.OnRspCallBack
{
  QCirclePolyLikeManager$1(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    if (paramObject2 == null) {
      return;
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.a)
      {
        QLog.d("PL-QCirclePolyLikeManager", 1, "doLike success");
        return;
      }
      QLog.d("PL-QCirclePolyLikeManager", 1, "doUnLike success");
      return;
    }
    if (this.a)
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("doLike failed, retCode:");
      paramObject1.append(paramLong);
      paramObject1.append(", msg:");
      paramObject1.append(paramString);
      QLog.d("PL-QCirclePolyLikeManager", 1, paramObject1.toString());
      return;
    }
    paramObject1 = new StringBuilder();
    paramObject1.append("doUnLike failed, retCode:");
    paramObject1.append(paramLong);
    paramObject1.append(", msg:");
    paramObject1.append(paramString);
    QLog.d("PL-QCirclePolyLikeManager", 1, paramObject1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager.1
 * JD-Core Version:    0.7.0.1
 */