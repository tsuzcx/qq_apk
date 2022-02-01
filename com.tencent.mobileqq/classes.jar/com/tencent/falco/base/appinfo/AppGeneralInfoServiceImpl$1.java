package com.tencent.falco.base.appinfo;

import android.content.SharedPreferences.Editor;
import android.util.Log;

class AppGeneralInfoServiceImpl$1
  implements Runnable
{
  AppGeneralInfoServiceImpl$1(AppGeneralInfoServiceImpl paramAppGeneralInfoServiceImpl, SharedPreferences.Editor paramEditor) {}
  
  public void run()
  {
    this.a.commit();
    Log.d("AppGeneralInfoService", "initShareBugly end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.appinfo.AppGeneralInfoServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */