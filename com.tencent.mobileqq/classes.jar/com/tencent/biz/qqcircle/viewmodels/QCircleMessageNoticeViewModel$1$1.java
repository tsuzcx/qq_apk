package com.tencent.biz.qqcircle.viewmodels;

import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QCircleMessageNoticeViewModel$1$1
  implements OnGetQQCircleNumRedMsgListener
{
  QCircleMessageNoticeViewModel$1$1(QCircleMessageNoticeViewModel.1 param1) {}
  
  public void onGet(List<String> paramList, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChatUnReadInfo currentTime:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("QCircleMessageNoticeViewModel", 1, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chatUnReadInfo not null currentTime:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d("QCircleMessageNoticeViewModel", 1, localStringBuilder.toString());
    QCircleMessageNoticeViewModel.a(this.a.this$0, paramList, paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1.1
 * JD-Core Version:    0.7.0.1
 */