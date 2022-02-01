package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloMessageService;", "Lmqq/app/api/IRuntimeService;", "apolloStatusOrDressChange", "", "type", "", "uinList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "reportTraceSpanMsg", "errCode", "msg", "", "", "(I[Ljava/lang/Object;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloMessageService
  extends IRuntimeService
{
  public abstract void apolloStatusOrDressChange(int paramInt, @NotNull ArrayList<String> paramArrayList);
  
  public abstract void reportTraceSpanMsg(int paramInt, @NotNull Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloMessageService
 * JD-Core Version:    0.7.0.1
 */