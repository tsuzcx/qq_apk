package com.tencent.biz.pubaccount.readinjoy.webarticle;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebResourceUtil$updateResourceOfflinePkg$runnable$1$asyncBack$1", "Lcom/tencent/biz/common/offline/AsyncBack;", "loaded", "", "param", "", "code", "", "progress", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebResourceUtil$updateResourceOfflinePkg$runnable$1$asyncBack$1
  implements AsyncBack
{
  public void loaded(@Nullable String paramString, int paramInt)
  {
    QLog.i("RIJWebResourceUtil", 1, "[updateResourceOfflinePkg], loaded param = " + paramString + ", code = " + paramInt);
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("RIJWebResourceUtil", 1, "[updateResourceOfflinePkg] download finished.");
      RIJWebResourceUtil.a.a(true);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebResourceUtil.updateResourceOfflinePkg.runnable.1.asyncBack.1
 * JD-Core Version:    0.7.0.1
 */