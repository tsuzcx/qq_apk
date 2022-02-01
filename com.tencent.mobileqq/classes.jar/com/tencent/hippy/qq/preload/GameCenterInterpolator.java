package com.tencent.hippy.qq.preload;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import mqq.app.MobileQQ;

public class GameCenterInterpolator
  implements MainTabPreloadInterpolator
{
  public boolean hasNewMessage()
  {
    int i = MobileQQ.sProcessId;
    boolean bool2 = false;
    if (i != 1) {
      return false;
    }
    Object localObject = HippyUtils.getAppInterface();
    if (localObject == null) {
      return false;
    }
    localObject = ((IRedTouchManager)((AppInterface)localObject).getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("489");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.has())
      {
        bool1 = bool2;
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isCanPreload()
  {
    return ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isGameCenterPreloadByTab();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.GameCenterInterpolator
 * JD-Core Version:    0.7.0.1
 */