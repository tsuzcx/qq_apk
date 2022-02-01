package com.tencent.mobileqq.apollo.makeup;

import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloDressInfo;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.utils.ApolloAEUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "apolloDressInfo", "Lcom/tencent/mobileqq/apollo/api/res/impl/ApolloResManagerImpl$ApolloDressInfo;", "kotlin.jvm.PlatformType", "errMsg", "", "errCode", "", "onGetApolloUserDressInfo"}, k=3, mv={1, 1, 16})
final class CmShowEALoader$CmShowResDownloadTask$executeAsync$1
  implements ApolloResManagerImpl.ApolloUserDressInfoListener
{
  CmShowEALoader$CmShowResDownloadTask$executeAsync$1(CmShowEALoader.CmShowResDownloadTask paramCmShowResDownloadTask) {}
  
  public final void a(ApolloResManagerImpl.ApolloDressInfo paramApolloDressInfo, String paramString, int paramInt)
  {
    if (paramApolloDressInfo == null)
    {
      QLog.e(CmShowEALoader.a.a(), 1, "getApolloUserRes return null " + paramString);
      this.a.a(-5031, "");
      return;
    }
    paramApolloDressInfo = ApolloAEUtil.a(paramApolloDressInfo);
    this.a.a(paramApolloDressInfo);
    QLog.i(CmShowEALoader.a.a(), 1, "[CmShowAELoader][CmShowResDownloadTask] success");
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.CmShowResDownloadTask.executeAsync.1
 * JD-Core Version:    0.7.0.1
 */