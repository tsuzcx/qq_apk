package com.tencent.mobileqq.apollo.makeup;

import com.tencent.mobileqq.apollo.model.ApolloDressInfo;
import com.tencent.mobileqq.apollo.utils.ApolloAEUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask$executeAsync$1", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager$ApolloUserDressInfoListener;", "onGetApolloUserDressInfo", "", "apolloDressInfo", "Lcom/tencent/mobileqq/apollo/model/ApolloDressInfo;", "errMsg", "", "errCode", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$CmShowResDownloadTask$executeAsync$1
  implements IApolloResManager.ApolloUserDressInfoListener
{
  public void a(@Nullable ApolloDressInfo paramApolloDressInfo, @Nullable String paramString, int paramInt)
  {
    if (paramApolloDressInfo == null)
    {
      paramApolloDressInfo = CmShowEALoader.f.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApolloUserRes return null ");
      localStringBuilder.append(paramString);
      QLog.e(paramApolloDressInfo, 1, localStringBuilder.toString());
      this.a.a(-5031, "");
      return;
    }
    paramApolloDressInfo = ApolloAEUtil.a(paramApolloDressInfo);
    this.a.a(paramApolloDressInfo);
    QLog.i(CmShowEALoader.f.a(), 1, "[CmShowAELoader][CmShowResDownloadTask] success");
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.CmShowResDownloadTask.executeAsync.1
 * JD-Core Version:    0.7.0.1
 */