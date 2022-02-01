package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCircleNewPublishSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(Context paramContext, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    QCircleLauncherUtil.a(localIntent, paramHashMap);
    QCirclePluginConfig.a().f();
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("PhotoConst.timestamp", System.currentTimeMillis());
    ((Bundle)localObject).putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
    ((Bundle)localObject).putInt("key_qcircle_entrance_type", 3);
    ((Bundle)localObject).putBoolean("key_is_take_photo", paramBoolean);
    ((Bundle)localObject).putBoolean("key_qcircle_publish_finish_jump_to_mainpage", true);
    ((Bundle)localObject).putBoolean("key_need_use_draft", false);
    localIntent.putExtra("key_enable_splash", false);
    localIntent.putExtras((Bundle)localObject);
    localIntent.addFlags(268435456);
    int i;
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("fromtype");
      try
      {
        i = Integer.parseInt(paramHashMap);
      }
      catch (Exception paramHashMap)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("launchPublishFragmentByScheme parseNumError:");
        ((StringBuilder)localObject).append(paramHashMap.getMessage());
        QLog.e("QCircleBaseSchemeParser", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      i = 7;
    }
    localIntent.getIntExtra("fromType", i);
    QCircleLauncher.a(paramContext, localIntent.getExtras(), HostDataTransUtils.getAccount(), i, null);
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleNewPublishSchemeParser
 * JD-Core Version:    0.7.0.1
 */