package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;

class FavEmoRoamingHandler$1
  implements Runnable
{
  FavEmoRoamingHandler$1(FavEmoRoamingHandler paramFavEmoRoamingHandler, faceroam_sso.RspUserInfo paramRspUserInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_FAVORITE);
      ((StringBuilder)localObject1).append(".nomedia");
      FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
      localList1 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.filename.get();
      localList2 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.delete_file.get();
      localList3 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.uint32_emoji_type.get();
      localObject2 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.bid.get();
      k = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.max_roam_size.get();
      FavEmoConstant.a = k;
      localObject1 = this.this$0.a.getCurrentAccountUin();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fav_roaming_max");
        localStringBuilder.append((String)localObject1);
        localEditor.putInt(localStringBuilder.toString(), k).apply();
      }
      if (localList1 != null)
      {
        i = localList1.size();
        if (i <= FavEmoConstant.a) {
          i = FavEmoConstant.a;
        }
        FavEmoConstant.b = i;
      }
      else
      {
        FavEmoConstant.b = FavEmoConstant.a;
      }
      if (!QLog.isColorLevel()) {
        break label337;
      }
      j = -1;
      if (localList1 == null) {
        i = -1;
      } else {
        i = localList1.size();
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      List localList1;
      List localList3;
      Object localObject2;
      int k;
      int i;
      int j;
      QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet error", localException);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        List localList2;
        label337:
        continue;
        if (localList2 != null) {}
      }
    }
    j = localList2.size();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("local max size:");
    ((StringBuilder)localObject1).append(FavEmoConstant.a);
    ((StringBuilder)localObject1).append(",server max size:");
    ((StringBuilder)localObject1).append(FavEmoConstant.b);
    ((StringBuilder)localObject1).append(",delListSize=");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(",fileListSize=");
    ((StringBuilder)localObject1).append(i);
    QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
    if ((QLog.isColorLevel()) && (localList1 != null) && (localList2 != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ret = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" userlist= ");
      ((StringBuilder)localObject1).append(localList1.toString());
      ((StringBuilder)localObject1).append(" delList=");
      ((StringBuilder)localObject1).append(localList2.toString());
      ((StringBuilder)localObject1).append(" bid=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" local_max =");
      ((StringBuilder)localObject1).append(k);
      QLog.d("FavEmoRoamingHandler", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "qq_expression";
    }
    FavEmoRoamingHandler.a(this.this$0, localList2, localList1);
    localObject2 = ((IFavroamingDBManagerService)this.this$0.a.getRuntimeService(IFavroamingDBManagerService.class, "")).updateFavEmotionsInLocalEx(localList2, localList1, (String)localObject1, localList3);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    this.this$0.notifyUI(1, true, localObject1);
    EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", 1);
    return;
    QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */