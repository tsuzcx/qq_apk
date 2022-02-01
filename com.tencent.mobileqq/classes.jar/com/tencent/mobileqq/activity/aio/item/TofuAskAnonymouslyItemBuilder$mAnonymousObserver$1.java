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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetLatestAnonymousInfo() success = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" and data is ");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.i("TofuAskAnonymouslyItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 5)
      {
        TofuAskAnonymouslyItemBuilder.a(this.a).a(true);
        localObject1 = TofuAskAnonymouslyItemBuilder.a(this.a);
        Object localObject2 = paramObject[0];
        if (localObject2 != null)
        {
          ((TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo)localObject1).a((String)localObject2);
          localObject1 = TofuAskAnonymouslyItemBuilder.a(this.a);
          localObject2 = paramObject[1];
          if (localObject2 != null)
          {
            ((TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo)localObject1).a(((Long)localObject2).longValue());
            localObject1 = TofuAskAnonymouslyItemBuilder.a(this.a);
            localObject2 = paramObject[2];
            if (localObject2 != null)
            {
              ((TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo)localObject1).b(((Boolean)localObject2).booleanValue());
              localObject1 = TofuAskAnonymouslyItemBuilder.a(this.a);
              localObject2 = paramObject[3];
              if (localObject2 != null)
              {
                ((TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo)localObject1).b(((Long)localObject2).longValue());
                localObject1 = TofuAskAnonymouslyItemBuilder.a(this.a);
                paramObject = paramObject[4];
                if (paramObject != null)
                {
                  ((TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo)localObject1).c(((Long)paramObject).longValue());
                  if ((TofuAskAnonymouslyItemBuilder.a(this.a).equals(TofuAskAnonymouslyItemBuilder.a(this.a).a())) && (TofuAskAnonymouslyItemBuilder.a(this.a).getAskAnonymouslyQuestion() != null))
                  {
                    TofuAskAnonymouslyItemBuilder.a(this.a);
                    TofuAskAnonymouslyItemBuilder.b(this.a);
                  }
                }
                else
                {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
                }
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.mAnonymousObserver.1
 * JD-Core Version:    0.7.0.1
 */