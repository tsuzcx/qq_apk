package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;

class ServiceAccountFolderActivityNew$3
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  ServiceAccountFolderActivityNew$3(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    Object localObject = (CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get();
    ServiceAccountFolderActivityNew.a(this.a, ((CertifiedAccountMeta.StUser)localObject).id.get());
    localObject = ((CertifiedAccountMeta.StUser)localObject).icon.get();
    if ((!TextUtils.isEmpty(paramStGetMainPageRsp.user.icon.get())) && (URLUtil.isNetworkUrl((String)localObject)))
    {
      ServiceAccountFolderActivityNew.a(this.a).setImageResource(2130840738);
      ServiceAccountFolderActivityNew.a(this.a).setOnClickListener(new ServiceAccountFolderActivityNew.3.1(this, paramStGetMainPageRsp));
    }
  }
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramBoolean)
    {
      if (paramStGetMainPageRsp != null)
      {
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
        SLog.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage success");
        a(paramStGetMainPageRsp);
        ServiceAccountFolderActivityNew.a(this.a);
        ServiceAccountFolderActivityNew.a(this.a, paramStGetMainPageRsp);
      }
      return;
    }
    SLog.c("ServiceAccountFolderActivityNew", "sendRequest GetMainPage error retCode:" + paramLong + ",errMsg:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.3
 * JD-Core Version:    0.7.0.1
 */