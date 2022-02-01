package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.paiyipai.PaiYiPaiObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AioPaiYiPaiHelper$1
  extends PaiYiPaiObserver
{
  AioPaiYiPaiHelper$1(AioPaiYiPaiHelper paramAioPaiYiPaiHelper) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPaiYiPaiRevokeNotice isSuccess=");
    localStringBuilder.append(paramBoolean);
    QLog.d("AioPaiYiPaiHelper", 1, localStringBuilder.toString());
    AioPaiYiPaiHelper.a(this.a).a().removeMessages(267387140);
    if (paramBoolean) {
      AioPaiYiPaiHelper.a(this.a).a().sendEmptyMessage(267387139);
    } else {
      AioPaiYiPaiHelper.a(this.a).a().sendEmptyMessage(267387140);
    }
    AioPaiYiPaiHelper.a(this.a).a(false, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPaiYiPaiRevokeError() called with: isSuccess = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], data = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.d("AioPaiYiPaiHelper", 1, localStringBuilder.toString());
    if (paramInt == 1008) {
      DialogUtil.a(AioPaiYiPaiHelper.a(this.a), 230).setMessage(AioPaiYiPaiHelper.a(this.a).getString(2131694687)).setPositiveButton(17039370, new AioPaiYiPaiHelper.1.1(this)).show();
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper.1
 * JD-Core Version:    0.7.0.1
 */