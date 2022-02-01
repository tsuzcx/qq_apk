package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.Intent;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.util.QZLog;

final class QCircleHandler$2
  implements QZoneApiProxy.QZoneLoadCallback
{
  QCircleHandler$2(Context paramContext, String paramString, Intent paramIntent) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      QZLog.d("QCircleHandler start activity: timestamp = ", 1, new Object[] { Long.valueOf(System.currentTimeMillis()) });
      QzonePluginProxyActivity.launchPluingActivityForResult(this.a, this.b, this.c, 0);
      return;
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    QZLog.e("QZLog", "QzonePluginInstalled failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler.2
 * JD-Core Version:    0.7.0.1
 */