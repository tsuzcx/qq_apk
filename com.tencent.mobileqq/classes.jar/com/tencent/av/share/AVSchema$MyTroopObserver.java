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
  String jdField_a_of_type_JavaLangString;
  
  private AVSchema$MyTroopObserver(AVSchema paramAVSchema) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema.a("onGetSimpleTroopInfoResult", l)) {
      return;
    }
    if (paramTroopInfo == null) {
      return;
    }
    paramString = paramTroopInfo.troopuin;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {
      return;
    }
    paramString = AVSchema.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetSimpleTroopInfoResult, isSuc[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], enumVerifyStatus[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareAVSchema.a.a);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(paramString, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvShareAVSchema.a.b = paramTroopInfo.troopname;
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema.a.a == 0)
    {
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvShareAVSchema.getBaseActivity(), true, new AVSchema.MyTroopObserver.1(this, l)))
      {
        this.jdField_a_of_type_ComTencentAvShareAVSchema.b(l, this.jdField_a_of_type_JavaLangString);
        return;
      }
      paramTroopInfo = AVSchema.a();
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
      String str = AVSchema.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateTroopList, isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */