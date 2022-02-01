package com.tencent.mobileqq.activity.qwallet.preload;

import akwx;
import akxf;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class PreloadManagerProxy$1
  extends ResultReceiver
{
  public PreloadManagerProxy$1(akxf paramakxf, Handler paramHandler, akwx paramakwx, String paramString)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      String str1 = paramBundle.getString("id");
      paramInt = paramBundle.getInt("result");
      String str2 = paramBundle.getString("path");
      paramBundle = (ResourceInfo)paramBundle.getSerializable("res_info");
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "PreloadManagerProxy downloadModule" + str2 + "|" + paramBundle);
      }
      this.jdField_a_of_type_Akwx.onDownloadResFinished(str1, paramInt, str2, paramBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManagerProxy", 2, "PreloadManagerProxy downloadModule IPC wrong");
    }
    this.jdField_a_of_type_Akwx.onDownloadResFinished(this.jdField_a_of_type_JavaLangString, -8, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy.1
 * JD-Core Version:    0.7.0.1
 */