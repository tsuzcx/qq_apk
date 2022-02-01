package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/aio/helper/TroopAskAnonymouslyHelper$1", "Lcom/tencent/mobileqq/app/MessageObserver;", "onSendResult", "", "isSuccess", "", "uin", "", "uniseq", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopAskAnonymouslyHelper$1
  extends MessageObserver
{
  public void onSendResult(boolean paramBoolean, @Nullable String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAskAnonymouslyHelper", 2, "onSendResult called isSuccess = " + paramBoolean + " and uniseq = " + paramLong);
    }
    if (paramBoolean)
    {
      paramString = Message.obtain();
      paramString.obj = Long.valueOf(paramLong);
      paramString.what = 0;
      this.a.a().sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper.1
 * JD-Core Version:    0.7.0.1
 */