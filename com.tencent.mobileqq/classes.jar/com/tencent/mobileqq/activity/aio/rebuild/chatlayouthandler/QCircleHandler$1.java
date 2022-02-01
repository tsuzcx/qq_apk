package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.Intent;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.util.QZLog;

class QCircleHandler$1
  implements QZoneApiProxy.QZoneLoadCallback
{
  QCircleHandler$1(QCircleHandler paramQCircleHandler, Context paramContext, String paramString, Intent paramIntent) {}
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      QzonePluginProxyActivity.launchPluingActivityForResult(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentIntent, 0);
      return;
    }
    catch (Exception localException)
    {
      QZLog.e("QZLog", "QzonePluginInstalled failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.QCircleHandler.1
 * JD-Core Version:    0.7.0.1
 */