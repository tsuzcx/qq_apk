package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ServiceAccountFolderActivityNew$2
  implements View.OnClickListener
{
  ServiceAccountFolderActivityNew$2(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew.2
 * JD-Core Version:    0.7.0.1
 */