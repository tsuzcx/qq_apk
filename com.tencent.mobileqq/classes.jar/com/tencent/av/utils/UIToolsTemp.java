package com.tencent.av.utils;

import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class UIToolsTemp
  extends AVCoreUtil
{
  public static int a(int paramInt)
  {
    return ((IUIToolsTempApi)QRoute.api(IUIToolsTempApi.class)).uinType2AVRelationType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.UIToolsTemp
 * JD-Core Version:    0.7.0.1
 */