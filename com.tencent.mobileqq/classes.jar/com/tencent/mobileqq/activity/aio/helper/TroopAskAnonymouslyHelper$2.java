package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/aio/helper/TroopAskAnonymouslyHelper$2", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "onReplyTroopAskAnonymously", "", "success", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopAskAnonymouslyHelper$2
  extends AnonymousObserver
{
  public void onReplyTroopAskAnonymously(boolean paramBoolean, @Nullable Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReplyTroopAskAnonymously() success = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" and data is ");
    localStringBuilder.append(paramObject);
    QLog.i("TroopAskAnonymouslyHelper", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper.2
 * JD-Core Version:    0.7.0.1
 */