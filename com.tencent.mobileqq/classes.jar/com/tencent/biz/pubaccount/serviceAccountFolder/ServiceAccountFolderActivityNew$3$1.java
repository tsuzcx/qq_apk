package com.tencent.biz.pubaccount.serviceAccountFolder;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ServiceAccountFolderActivityNew$3$1
  implements View.OnClickListener
{
  ServiceAccountFolderActivityNew$3$1(ServiceAccountFolderActivityNew.3 param3, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp) {}
  
  public void onClick(View paramView)
  {
    ServiceAccountFolderActivityNew.c(this.b.a, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.3.1
 * JD-Core Version:    0.7.0.1
 */