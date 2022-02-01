package com.tencent.hippy.qq.module.gamecenter;

import bide;
import bidf;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQWadlModule$CheckUpdateCallback
  implements bidf
{
  private final Promise callback;
  private final String guid;
  
  QQWadlModule$CheckUpdateCallback(String paramString, Promise paramPromise)
  {
    this.guid = paramString;
    this.callback = paramPromise;
  }
  
  public void onException(String paramString)
  {
    QLog.e("QQWadlModule", 1, "checkUpdate.onException >>> " + paramString);
    paramString = new HippyMap();
    paramString.pushString("guid", this.guid);
    paramString.pushInt("r", -1);
    this.callback.resolve(paramString);
    bide.a().b(this);
  }
  
  public void onResult(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQWadlModule", 2, "checkUpdate(End) onResult()");
    }
    HippyArray localHippyArray = new HippyArray();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushString("packageName", localApkUpdateDetail.packageName);
      localHippyMap.pushInt("newapksize", localApkUpdateDetail.newapksize);
      localHippyMap.pushInt("patchsize", localApkUpdateDetail.patchsize);
      localHippyMap.pushInt("updatemethod", localApkUpdateDetail.updatemethod);
      localHippyMap.pushInt("versioncode", localApkUpdateDetail.versioncode);
      localHippyMap.pushString("versionname", localApkUpdateDetail.versionname);
      localHippyMap.pushString("fileMd5", localApkUpdateDetail.fileMd5);
      localHippyMap.pushString("sigMd5", localApkUpdateDetail.sigMd5);
      localHippyMap.pushString("url", localApkUpdateDetail.url);
      localHippyArray.pushMap(localHippyMap);
      i += 1;
    }
    paramArrayList = new HippyMap();
    paramArrayList.pushString("guid", this.guid);
    paramArrayList.pushInt("r", 0);
    paramArrayList.pushArray("data", localHippyArray);
    this.callback.resolve(paramArrayList);
    bide.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.gamecenter.QQWadlModule.CheckUpdateCallback
 * JD-Core Version:    0.7.0.1
 */