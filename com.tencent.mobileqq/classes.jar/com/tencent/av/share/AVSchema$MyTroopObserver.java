package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class AVSchema$MyTroopObserver
  extends TroopObserver
{
  String a;
  
  private AVSchema$MyTroopObserver(AVSchema paramAVSchema) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    long l = AudioHelper.c();
    if (this.b.a("onGetSimpleTroopInfoResult", l)) {
      return;
    }
    if (paramTroopInfo == null) {
      return;
    }
    paramString = paramTroopInfo.troopuin;
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    if (!TextUtils.equals(this.a, paramString)) {
      return;
    }
    paramString = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSimpleTroopInfoResult, isSuc[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], enumVerifyStatus[");
    localStringBuilder.append(this.b.a.c);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(paramString, 1, localStringBuilder.toString());
    this.b.a.b = paramTroopInfo.troopname;
    if (this.b.a.c == 0)
    {
      if (ChatActivityUtils.b(this.b.getBaseActivity(), true, new AVSchema.MyTroopObserver.1(this, l)))
      {
        this.b.b(l, this.a);
        return;
      }
      paramTroopInfo = AVSchema.e();
      paramString = new StringBuilder();
      paramString.append("onGetSimpleTroopInfoResult, 等权限确认, seq[");
      paramString.append(l);
      paramString.append("]");
      QLog.w(paramTroopInfo, 1, paramString.toString());
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = AVSchema.e();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateTroopList, isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */