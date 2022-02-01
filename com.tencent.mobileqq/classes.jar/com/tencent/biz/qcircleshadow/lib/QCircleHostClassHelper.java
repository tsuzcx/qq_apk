package com.tencent.biz.qcircleshadow.lib;

import com.ae.light.camera.api.IAEEditorManagerForQzone;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleHostClassHelper
{
  public static Class getAECoverSelectFragmentClass()
  {
    return ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).getAECoverSelectFragmentClass();
  }
  
  public static Class getAEVideoPreviewFragmentClass()
  {
    return ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).getAEVideoPreviewFragmentClass();
  }
  
  public static Class getChatActivityClass()
  {
    return QCircleServiceImpl.getChatActivityApi().getChatActivityClass();
  }
  
  public static Class getForwardRecentActivityClass()
  {
    return QCircleServiceImpl.getForwardApi().getForwardRecentActivityClass();
  }
  
  public static Class getForwardRecentTranslucentActivityClass()
  {
    return QCircleServiceImpl.getForwardApi().getForwardRecentTranslucentActivityClass();
  }
  
  public static Class getJumpActivityClass()
  {
    return QCircleServiceImpl.getJumpApi().getJumpActivityClass();
  }
  
  public static Class getPublicFragmentActivityForPeakClass()
  {
    return ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).getPublicFragmentActivityForPeakClass();
  }
  
  public static Class getQCircleHippyFragmentClass()
  {
    return QCircleServiceImpl.getQQService().getQCircleHippyFragmentClass();
  }
  
  public static Class getQQBrowserActivityClass()
  {
    return QCircleServiceImpl.getQQService().getQQBrowserActivityClass();
  }
  
  public static Class getQQTranslucentBrowserActivityClass()
  {
    return QCircleServiceImpl.getQQService().getQQTranslucentBrowserActivityClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper
 * JD-Core Version:    0.7.0.1
 */