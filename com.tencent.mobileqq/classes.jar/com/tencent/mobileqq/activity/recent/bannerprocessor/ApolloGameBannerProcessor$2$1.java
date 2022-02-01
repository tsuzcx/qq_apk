package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qphone.base.util.QLog;

class ApolloGameBannerProcessor$2$1
  implements DialogInterface.OnClickListener
{
  ApolloGameBannerProcessor$2$1(ApolloGameBannerProcessor.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (CmGameMainManager.a() != null) {
      CmGameUtil.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.", 2, " MSG_APOLLO_GAME_HIDE");
    }
    BannerManager.a().a(38, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ApolloGameBannerProcessor.2.1
 * JD-Core Version:    0.7.0.1
 */