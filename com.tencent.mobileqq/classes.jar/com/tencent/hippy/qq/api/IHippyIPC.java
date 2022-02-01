package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHippyIPC
  extends QRouteApi
{
  public static final String ACTION_CANCLE_DOWNLOAD_TASK = "action_cancle_download_task";
  public static final String ACTION_GET_MAIN_STATE = "action_get_main_state";
  public static final String ACTION_PRELOAD_HIPPY = "action_preload_hippy";
  public static final String BUNDLE_HIPPY_INFO = "hippy_info";
  public static final String KEY_CURRENT_MAIN_STATE = "current_main_state";
  public static final String KEY_SHOW_TAB_NAME = "show_tab_name";
  public static final String NAME = "module_hippy";
  
  public abstract QIPCModule getIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyIPC
 * JD-Core Version:    0.7.0.1
 */