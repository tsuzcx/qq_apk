package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopRequestActivity$23
  extends TroopBindPubAccountProtocol.FollowPublicAccountObserver
{
  TroopRequestActivity$23(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        new structmsg.StructMsg().mergeFrom(paramBundle);
        TroopRequestActivity.a(this.a, 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, "structMsg merge error");
        }
        this.a.h();
        QQToast.a(this.a, this.a.getString(2131697365), 0).b(this.a.getTitleBarHeight());
        return;
      }
    }
    this.a.h();
    QQToast.a(this.a, this.a.getString(2131697365), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.23
 * JD-Core Version:    0.7.0.1
 */