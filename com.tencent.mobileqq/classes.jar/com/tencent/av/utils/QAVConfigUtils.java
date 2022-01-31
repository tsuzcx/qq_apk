package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class QAVConfigUtils
{
  public static void a(Intent paramIntent, ConfigurationService.Config paramConfig, Context paramContext)
  {
    int j = 1;
    int k = paramConfig.version.get();
    int m = SharedPreUtils.g(paramContext);
    int i;
    if (paramConfig.msg_content_list != null)
    {
      i = paramConfig.msg_content_list.size();
      if (QLog.isColorLevel()) {
        QLog.d("handleGetQAVGeneralConfig", 2, String.format("QAV Config回包, serverVersion[%s], localVersion[%s], size[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) }));
      }
      if (k != m) {
        break label90;
      }
    }
    label90:
    do
    {
      do
      {
        return;
        i = -1;
        break;
      } while (i <= 0);
      paramIntent = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    } while (paramIntent == null);
    if (paramIntent.compress.get() == 1)
    {
      paramConfig = OlympicUtil.a(paramIntent.content.get().toByteArray());
      if (paramConfig == null)
      {
        QLog.d("handleGetQAVGeneralConfig", 2, "解压错误");
        paramIntent = "";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("handleGetQAVGeneralConfig", 2, "config content is: " + paramIntent);
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      try
      {
        paramIntent = new JSONObject(paramIntent);
        i = j;
        if (paramIntent.has("isBlueToothSwitchForAndroid")) {
          i = paramIntent.getInt("isBlueToothSwitchForAndroid");
        }
        long l = 1000L;
        if (paramIntent.has("bluetoothDelayTime")) {
          l = paramIntent.getLong("bluetoothDelayTime");
        }
        BaseApplicationImpl.getApplication().getSharedPreferences("qav_mode", 4).edit().putInt("isBlueToothSwitch", i).putLong("bluetoothDelayTime", l).commit();
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(paramIntent));
      return;
      try
      {
        paramIntent = new String(paramConfig, "UTF-8");
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        paramIntent = "";
      }
      catch (OutOfMemoryError paramIntent)
      {
        if (QLog.isColorLevel()) {
          paramIntent.printStackTrace();
        }
        System.gc();
        try
        {
          paramIntent = new String(paramConfig, "UTF-8");
        }
        catch (Throwable paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.i("handleGetQAVGeneralConfig", 2, " new string: " + QLog.getStackTraceString(paramIntent));
          }
          paramIntent = "";
        }
      }
      continue;
      paramIntent = paramIntent.content.get().toStringUtf8();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.QAVConfigUtils
 * JD-Core Version:    0.7.0.1
 */