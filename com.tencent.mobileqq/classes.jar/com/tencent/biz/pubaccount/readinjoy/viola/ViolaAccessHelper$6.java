package com.tencent.biz.pubaccount.readinjoy.viola;

import aljq;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bdcs;
import bduw;
import bfhh;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import srg;

public final class ViolaAccessHelper$6
  implements Runnable
{
  public ViolaAccessHelper$6(String paramString, srg paramsrg) {}
  
  public void run()
  {
    String str = bduw.a(aljq.cD + bfhh.a(this.jdField_a_of_type_JavaLangString) + ".js");
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
          bdcs.d(str);
        }
        boolean bool = HttpDownloadUtil.a(null, this.jdField_a_of_type_JavaLangString, new File(str));
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc" + bool);
        }
        if (bool) {}
        try
        {
          if (this.jdField_a_of_type_Srg != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.6.1(this, str), 0L);
          }
          if (TextUtils.isEmpty(bdcs.b(new File(str))))
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
    } while (this.jdField_a_of_type_Srg == null);
    new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.6.2(this), 0L);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.6
 * JD-Core Version:    0.7.0.1
 */