package com.tencent.biz.qqcircle.datacenter.impl;

import android.text.TextUtils;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.sender.chain.SenderChain;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class QCircleNetListProvider$InnerRspHandleInterceptor
  implements RspInterceptor
{
  private QCircleNetListProvider$InnerRspHandleInterceptor(QCircleNetListProvider paramQCircleNetListProvider) {}
  
  public void interceptReturnRsp(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, SenderChain paramSenderChain)
  {
    if ((paramBoolean) && (paramLong == 0L) && (this.a.a() != null))
    {
      List localList = this.a.getListDataFromRsp(paramObject2);
      String str2 = this.a.getAttachInfoFromRsp(paramObject2);
      IDataStore localIDataStore = this.a.a();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
      localIDataStore.a(str1);
      if ((localList != null) && (localList.size() > 0))
      {
        this.a.a().a(localList);
        if (this.a.a().d())
        {
          paramSenderChain.a(true, 0L, paramString, paramObject1, new ArrayList(this.a.a().b().values()));
          return;
        }
      }
    }
    paramSenderChain.a(paramBoolean, paramLong, paramString, paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.impl.QCircleNetListProvider.InnerRspHandleInterceptor
 * JD-Core Version:    0.7.0.1
 */