package com.tencent.biz.troop;

import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

class TroopMemberApiService$9
  extends NearbyCardObserver
{
  TroopMemberApiService$9(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberApiService", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((NearbyCardManager)TroopMemberApiService.g(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(((QQAppInterface)TroopMemberApiService.h(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean)
    {
      SharedPreUtils.a(BaseApplication.getContext(), false);
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131715412), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
      if (!paramBoolean) {
        break label164;
      }
    }
    label164:
    for (String str = "1";; str = "2")
    {
      NearbyVideoUtils.a("clk_del_video", new String[] { str });
      return;
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131715489), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
      break;
    }
  }
  
  public void a(boolean paramBoolean, UpdatePhotoList.HeadInfo paramHeadInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramHeadInfo != null) {
        QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo + HeadInfo = " + paramHeadInfo.toString());
      }
    }
    else
    {
      ((NearbyCardManager)TroopMemberApiService.i(this.a).getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(((QQAppInterface)TroopMemberApiService.j(this.a)).getCurrentAccountUin(), Integer.valueOf(1));
      if (!paramBoolean) {
        break label150;
      }
      SharedPreUtils.a(BaseApplication.getContext(), true);
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131715490), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
      label118:
      if (!paramBoolean) {
        break label182;
      }
    }
    label150:
    label182:
    for (paramHeadInfo = "1";; paramHeadInfo = "2")
    {
      NearbyVideoUtils.a("clk_upload_video", new String[] { paramHeadInfo });
      return;
      QLog.d("TroopMemberApiService", 2, "onUpdateNearbyPeopleAuthVideo , headInfo is null");
      break;
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131715418), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.9
 * JD-Core Version:    0.7.0.1
 */