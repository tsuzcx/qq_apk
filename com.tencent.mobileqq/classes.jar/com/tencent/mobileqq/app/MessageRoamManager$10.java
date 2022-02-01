package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class MessageRoamManager$10
  implements Runnable
{
  MessageRoamManager$10(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    Object localObject1 = new File(this.this$0.a.getApp().getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkBlueBanner local file exists: ");
      ((StringBuilder)localObject2).append(((File)localObject1).exists());
      QLog.d("Q.roammsg.MessageRoamManager", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool;
    if (((File)localObject1).exists())
    {
      Object localObject3 = this.this$0.a.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      localObject2 = this.this$0.a.getCurrentAccountUin();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("message_roam_is_first_show");
      ((StringBuilder)localObject1).append((String)localObject2);
      int i = ((SharedPreferences)localObject3).getInt(((StringBuilder)localObject1).toString(), 0);
      bool = this.this$0.h();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("banner_last_show_timestamp");
      ((StringBuilder)localObject1).append((String)localObject2);
      long l1 = ((SharedPreferences)localObject3).getLong(((StringBuilder)localObject1).toString(), 0L);
      long l2 = ((SharedPreferences)localObject3).getInt("blue_banner_show_internal", 24);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      long l4 = ((SharedPreferences)localObject3).getInt("blue_banner_show_time", 0);
      if (((!bool) && ((l3 - l1 > l2 * 3600000L) || (l3 < l1))) || ((i == 0) && (l4 * 1000L != 0L)))
      {
        if (VasUtil.a(this.this$0.a).getVipStatus().isSVip()) {
          localObject1 = ((SharedPreferences)localObject3).getString("blue_banner_svip_text", null);
        } else if (VasUtil.a(this.this$0.a).getVipStatus().isVip()) {
          localObject1 = ((SharedPreferences)localObject3).getString("blue_banner_vip_text", null);
        } else {
          localObject1 = ((SharedPreferences)localObject3).getString("blue_banner_notvip_text", null);
        }
        if (i == 0) {
          localObject1 = this.this$0.a.getApp().getResources().getString(2131693910);
        }
        String str = ((SharedPreferences)localObject3).getString("blue_banner_go_url", null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("showText", (String)localObject1);
          localBundle.putString("goUrl", str);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkBlueBanner showText: ");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(", goUrl: ");
            localStringBuilder.append(str);
            QLog.d("Q.roammsg.MessageRoamManager", 2, localStringBuilder.toString());
          }
          this.this$0.a(14, localBundle);
          if (i == 0)
          {
            localObject1 = ((SharedPreferences)localObject3).edit();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("message_roam_is_first_show");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject3).toString(), 1).commit();
          }
          else
          {
            localObject1 = ((SharedPreferences)localObject3).edit();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("banner_last_show_timestamp");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject3).toString(), NetConnInfoCenter.getServerTimeMillis()).commit();
          }
        }
      }
      bool = false;
    }
    else
    {
      bool = true;
    }
    this.this$0.e(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.10
 * JD-Core Version:    0.7.0.1
 */