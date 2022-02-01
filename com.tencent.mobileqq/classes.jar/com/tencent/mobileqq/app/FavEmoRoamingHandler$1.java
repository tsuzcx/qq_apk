package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import anhk;
import anlh;
import arrm;
import arro;
import awmr;
import bgmg;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;

public class FavEmoRoamingHandler$1
  implements Runnable
{
  public FavEmoRoamingHandler$1(anlh paramanlh, faceroam_sso.RspUserInfo paramRspUserInfo, long paramLong) {}
  
  public void run()
  {
    int j = -1;
    for (;;)
    {
      List localList2;
      try
      {
        bgmg.c(anhk.bl + ".nomedia");
        localList1 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.filename.get();
        localList2 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.delete_file.get();
        localList3 = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.uint32_emoji_type.get();
        localObject = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.bid.get();
        k = this.jdField_a_of_type_TencentImCsFaceroam_ssoFaceroam_sso$RspUserInfo.max_roam_size.get();
        arrm.a = k;
        String str = this.this$0.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(str)) {
          BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("fav_roaming_max" + str, k).apply();
        }
        if (localList1 == null) {
          continue;
        }
        i = localList1.size();
        if (i <= arrm.a) {
          continue;
        }
        arrm.b = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        if (localList1 != null) {
          continue;
        }
        i = -1;
      }
      catch (Exception localException)
      {
        List localList1;
        List localList3;
        Object localObject;
        int k;
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet error", localException);
        return;
        int i = localList1.size();
        break label492;
        j = localList2.size();
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom2");
        return;
      }
      QLog.d("FavEmoRoamingHandler", 2, "local max size:" + arrm.a + ",server max size:" + arrm.b + ",delListSize=" + j + ",fileListSize=" + i);
      if ((QLog.isColorLevel()) && (localList1 != null) && (localList2 != null)) {
        QLog.d("FavEmoRoamingHandler", 2, "ret = " + this.jdField_a_of_type_Long + " userlist= " + localList1.toString() + " delList=" + localList2.toString() + " bid=" + (String)localObject + " local_max =" + k);
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = "qq_expression";
        anlh.a(this.this$0, localList2, localList1);
        localList1 = ((arro)this.this$0.app.getManager(149)).a(localList2, localList1, (String)localObject, localList3);
        localObject = localList1;
        if (localList1 == null) {
          localObject = new ArrayList();
        }
        this.this$0.notifyUI(1, true, localObject);
        awmr.e("0", 1);
        return;
        i = arrm.a;
        continue;
        arrm.b = arrm.a;
      }
      else
      {
        continue;
        label492:
        if (localList2 != null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */