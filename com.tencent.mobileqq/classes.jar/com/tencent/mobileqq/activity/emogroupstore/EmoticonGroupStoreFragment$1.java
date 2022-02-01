package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.qphone.base.util.QLog;

class EmoticonGroupStoreFragment$1
  extends SVIPObserver
{
  EmoticonGroupStoreFragment$1(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onVipStatusChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "vip status change in EmoticonGroupStoreFragment.");
    }
    IFavroamingManagerService localIFavroamingManagerService = (IFavroamingManagerService)EmoticonGroupStoreFragment.a(this.a).getRuntimeService(IFavroamingManagerService.class);
    if (localIFavroamingManagerService != null) {
      localIFavroamingManagerService.syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.1
 * JD-Core Version:    0.7.0.1
 */