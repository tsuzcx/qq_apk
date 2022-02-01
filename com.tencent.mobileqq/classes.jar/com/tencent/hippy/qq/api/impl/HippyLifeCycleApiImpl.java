package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyLifeCycleApi;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.qphone.base.util.QLog;

public class HippyLifeCycleApiImpl
  implements IHippyLifeCycleApi
{
  public static final String TAG = "HippyLifeCycleApi";
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HippyLifeCycleApi", 2, "[onDestroy]");
    }
    HippyOfflineAssist.updateUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyLifeCycleApiImpl
 * JD-Core Version:    0.7.0.1
 */