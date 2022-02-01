package com.tencent.biz.pubaccount.readinjoy.viola.wormhole;

import com.tencent.nativevue.NativeVueLogAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;

class NativeVueLoaderManager$NVLogAdapter
  implements NativeVueLogAdapter
{
  public void logD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeVueLoaderManager", 2, "[NativeVue Debug]: " + paramString);
    }
  }
  
  public void logE(String paramString)
  {
    QLog.e("NativeVueLoaderManager", 1, "[NativeVue Error]: " + paramString);
  }
  
  public void onNativeVueError(String paramString)
  {
    ViolaUtils.reportNVError(paramString, NativeVueLoaderManager.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager.NVLogAdapter
 * JD-Core Version:    0.7.0.1
 */