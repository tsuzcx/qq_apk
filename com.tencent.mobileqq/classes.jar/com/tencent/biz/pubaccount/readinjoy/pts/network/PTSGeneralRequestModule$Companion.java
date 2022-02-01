package com.tencent.biz.pubaccount.readinjoy.pts.network;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/network/PTSGeneralRequestModule$Companion;", "", "()V", "CMD_PTS_REQUEST_DATA", "", "KEY_PTS_APP_INSTANCE_ID", "SERVICE_TYPE_DEFAULT", "", "TAG", "requestPtsBusinessData", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "businessType", "requestParamsJson", "extendInfoJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSGeneralRequestModule$Companion
{
  public final void a(@Nullable PTSComposer paramPTSComposer, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramPTSComposer == null) {
      QLog.i("PTSGeneralRequestModule", 1, "[requestPtsBusinessData] ptsComposer is null, businessType = " + paramInt);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = ReadInJoyUtils.a();
          if (localObject == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
          }
          localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        } while (localObject == null);
        localObject = ((ReadInJoyLogicManager)localObject).a();
      } while (localObject == null);
      localObject = ((ReadInJoyLogicEngine)localObject).a();
    } while (localObject == null);
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label121;
      }
    }
    for (;;)
    {
      ((PTSGeneralRequestModule)localObject).a(paramPTSComposer, paramInt, paramString1, paramString2);
      return;
      paramString1 = "";
      break;
      label121:
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule.Companion
 * JD-Core Version:    0.7.0.1
 */