package com.tencent.mobileqq.activity.emogroupstore;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
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
    FavroamingManager localFavroamingManager = (FavroamingManager)EmoticonGroupStoreFragment.a(this.a).getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
    if (localFavroamingManager != null) {
      localFavroamingManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.1
 * JD-Core Version:    0.7.0.1
 */