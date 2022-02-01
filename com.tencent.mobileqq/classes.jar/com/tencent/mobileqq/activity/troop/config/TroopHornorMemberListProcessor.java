package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopHornorMemberListProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopMemberInfo> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ITroopInfoService localITroopInfoService = (ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "");
    paramString = localITroopInfoService.findTroopInfo(paramString);
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramArrayList = (stTroopMemberInfo)localIterator.next();
      if (paramArrayList != null)
      {
        long l = paramArrayList.MemberUin;
        if ((!TextUtils.isEmpty(paramAppInterface.getAccount())) && (paramAppInterface.getAccount().equals(String.valueOf(l)))) {
          if ((paramArrayList.vecGroupHonor != null) && (paramString != null))
          {
            paramString.myHonorList = TroopHonorUtils.a(paramArrayList.vecGroupHonor);
            paramString.myHonorRichFlag = paramArrayList.cRichFlag;
            localITroopInfoService.saveTroopInfo(paramString);
            if ((QLog.isColorLevel()) && (paramArrayList.cRichFlag != 0))
            {
              paramAppInterface = new StringBuilder();
              paramAppInterface.append("honor_rich_friend_me,");
              paramAppInterface.append(paramArrayList.cRichFlag);
              QLog.d("TroopHornorMemberListProcessor", 2, paramAppInterface.toString());
            }
          }
        }
      }
    }
  }
  
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo != null)
    {
      if (paramstTroopMemberInfo.vecGroupHonor == null) {
        return;
      }
      paramTroopMemberInfo.honorList = TroopHonorUtils.a(paramstTroopMemberInfo.vecGroupHonor);
    }
  }
  
  public void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo != null)
    {
      if (paramstTroopMemberInfo.vecGroupHonor == null) {
        return;
      }
      paramTroopMemberInfo.honorList = TroopHonorUtils.a(paramstTroopMemberInfo.vecGroupHonor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopHornorMemberListProcessor
 * JD-Core Version:    0.7.0.1
 */