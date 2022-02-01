package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$mAnonymousObserver$1", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "onGetLatestAnonymousInfo", "", "success", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TofuAskAnonymouslyItemBuilder$mAnonymousObserver$1
  extends AnonymousObserver
{
  public void onGetLatestAnonymousInfo(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TofuAskAnonymouslyItemBuilder", 2, "onGetLatestAnonymousInfo() success = " + paramBoolean + " and data is " + paramObject);
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 5))
    {
      TofuAskAnonymouslyItemBuilder.a(this.a).a(true);
      TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo localLatestAnonymousInfo = TofuAskAnonymouslyItemBuilder.a(this.a);
      Object localObject = ((Object[])paramObject)[0];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      localLatestAnonymousInfo.a((String)localObject);
      localLatestAnonymousInfo = TofuAskAnonymouslyItemBuilder.a(this.a);
      localObject = ((Object[])paramObject)[1];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localLatestAnonymousInfo.a(((Long)localObject).longValue());
      localLatestAnonymousInfo = TofuAskAnonymouslyItemBuilder.a(this.a);
      localObject = ((Object[])paramObject)[2];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      }
      localLatestAnonymousInfo.b(((Boolean)localObject).booleanValue());
      localLatestAnonymousInfo = TofuAskAnonymouslyItemBuilder.a(this.a);
      localObject = ((Object[])paramObject)[3];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localLatestAnonymousInfo.b(((Long)localObject).longValue());
      localLatestAnonymousInfo = TofuAskAnonymouslyItemBuilder.a(this.a);
      paramObject = ((Object[])paramObject)[4];
      if (paramObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localLatestAnonymousInfo.c(((Long)paramObject).longValue());
      if ((TofuAskAnonymouslyItemBuilder.a(this.a).equals(TofuAskAnonymouslyItemBuilder.a(this.a).a())) && (TofuAskAnonymouslyItemBuilder.a(this.a).getAskAnonymouslyQuestion() != null))
      {
        TofuAskAnonymouslyItemBuilder.a(this.a);
        TofuAskAnonymouslyItemBuilder.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.mAnonymousObserver.1
 * JD-Core Version:    0.7.0.1
 */