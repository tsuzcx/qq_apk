package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resCode", "", "<anonymous parameter 1>", "Lcom/tencent/mobileqq/soload/biz/entity/LoadExtResult;", "kotlin.jvm.PlatformType", "onLoadResult"}, k=3, mv={1, 1, 16})
final class ApolloApngEncoder$Companion$loadLibIfNeed$1
  implements OnLoadListener
{
  public static final 1 a = new 1();
  
  public final void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      QLog.d(ApolloApngEncoder.a.a(), 1, "loadLibIfNeed Success");
      ApolloApngEncoder.a.a(true);
      return;
    }
    paramLoadExtResult = ApolloApngEncoder.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadLibIfNeed Error: ");
    localStringBuilder.append(paramInt);
    QLog.e(paramLoadExtResult, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder.Companion.loadLibIfNeed.1
 * JD-Core Version:    0.7.0.1
 */