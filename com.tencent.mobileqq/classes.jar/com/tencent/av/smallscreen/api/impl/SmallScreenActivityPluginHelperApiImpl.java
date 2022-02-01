package com.tencent.av.smallscreen.api.impl;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenActivityPluginHelperApiImpl
  implements ISmallScreenActivityPluginHelperApi
{
  private static final String TAG = "SmallScreenActivityPluginHelperApiImpl";
  
  public void onPauseRender(long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseVideoAppInterface instanceof VideoAppInterface))
    {
      VideoAppInterface localVideoAppInterface = (VideoAppInterface)paramBaseVideoAppInterface;
      boolean bool = VideoController.b(paramBaseVideoAppInterface.getApp());
      Object localObject;
      if ((QLog.isColorLevel()) || (!bool) || (paramBoolean2))
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPauseRender, isQuit[");
        localStringBuilder.append(paramBoolean2);
        localStringBuilder.append("], isScreenOn[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      if (!paramBoolean2)
      {
        if (SmallScreenUtils.g())
        {
          localObject = localVideoAppInterface.b().k();
          int i = ((SessionInfo)localObject).g;
          if ((i != 2) && (i != 4)) {
            paramBoolean2 = false;
          } else {
            paramBoolean2 = true;
          }
          ThreadManager.excute(new SmallScreenActivityPluginHelperApiImpl.1(this, paramLong, paramBaseVideoAppInterface, paramBoolean1, bool, localVideoAppInterface.b().aE().e(), paramBoolean2), 16, null, false);
          SmallScreenUtilsApiImpl.reportActionOn(paramBaseVideoAppInterface.getApp(), (SessionInfo)localObject);
          return;
        }
        SmallScreenUtils.a(paramLong, paramBaseVideoAppInterface, 2);
      }
      return;
    }
    QLog.e(TAG, 1, "invalid BaseVideoAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.impl.SmallScreenActivityPluginHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */