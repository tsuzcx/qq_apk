package com.tencent.biz.troop;

import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

class TroopMemberApiService$13
  extends NearbyCardObserver
{
  TroopMemberApiService$13(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteNearbyPeopleAuthVideo isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopMemberApiService", 2, ((StringBuilder)localObject).toString());
    }
    ((INearbyCardManager)TroopMemberApiService.c(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(((QQAppInterface)TroopMemberApiService.d(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      SharedPreUtils.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131715334), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131715411), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    }
    INearbyVideoUtils localINearbyVideoUtils = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localINearbyVideoUtils.report("clk_del_video", new String[] { localObject });
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (UpdatePhotoList.HeadInfo)paramObject;
    if (QLog.isColorLevel()) {
      if (paramObject != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUpdateNearbyPeopleAuthVideo + HeadInfo = ");
        ((StringBuilder)localObject).append(paramObject.toString());
        QLog.d("TroopMemberApiService", 2, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo , headInfo is null");
      }
    }
    ((INearbyCardManager)TroopMemberApiService.e(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a().put(((QQAppInterface)TroopMemberApiService.f(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      SharedPreUtils.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131715412), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131715340), 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
    }
    Object localObject = (INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class);
    if (paramBoolean) {
      paramObject = "1";
    } else {
      paramObject = "2";
    }
    ((INearbyVideoUtils)localObject).report("clk_upload_video", new String[] { paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.13
 * JD-Core Version:    0.7.0.1
 */