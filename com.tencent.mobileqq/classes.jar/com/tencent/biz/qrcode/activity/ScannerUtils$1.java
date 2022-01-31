package com.tencent.biz.qrcode.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import ndd;
import org.json.JSONObject;

public final class ScannerUtils$1
  extends Thread
{
  public void run()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong("lastCheckOrientation", System.currentTimeMillis());
    localEditor.commit();
    Object localObject = "http://qm.qq.com/cgi-bin/check_orientation?product=" + Build.PRODUCT + "&os=" + Build.VERSION.RELEASE + "&" + "mType" + "=" + "qb_qrcode";
    try
    {
      String str = ndd.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, "GET", null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRHttpUtil", 2, "open :" + (String)localObject + ", result: " + str);
      }
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).getInt("r") == 0)
      {
        if (((JSONObject)localObject).getInt("orientation") == 1)
        {
          localEditor.putBoolean("needLandScape", true);
          localEditor.commit();
        }
      }
      else {
        throw new IOException();
      }
    }
    catch (Exception localException)
    {
      localEditor.putLong("lastCheckOrientation", 0L);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerUtils.1
 * JD-Core Version:    0.7.0.1
 */