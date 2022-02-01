package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

final class ViolaAccessHelper$7
  implements Runnable
{
  ViolaAccessHelper$7(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack) {}
  
  public void run()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_VIOLA_JS_SOURCE_PATH + MD5.a(this.jdField_a_of_type_JavaLangString) + ".js");
    if (TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "loadJSFromNet [url:" + this.jdField_a_of_type_JavaLangString + "] get localPath error, download cancel");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet [ url:" + this.jdField_a_of_type_JavaLangString + "] Download to " + str);
        }
        if (new File(str).exists()) {
          FileUtils.e(str);
        }
        boolean bool = HttpDownloadUtil.download(null, this.jdField_a_of_type_JavaLangString, new File(str));
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc" + bool);
        }
        if (bool) {}
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.7.1(this, str), 0L);
          }
          if (TextUtils.isEmpty(FileUtils.b(new File(str))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc but readFileToString is null");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc and readFileToString succ");
            return;
          }
        }
        catch (IOException localIOException) {}
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$LoadAsyBack == null);
    new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.7.2(this), 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.7
 * JD-Core Version:    0.7.0.1
 */