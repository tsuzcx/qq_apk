package com.tencent.mobileqq.app.readinjoy;

import agca;
import akfg;
import akuc;
import ando;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import andx;
import bhvh;
import bhvt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import noo;
import onk;
import osj;
import pbx;
import sgj;

class ReadInJoyManager$NotifyReceiver$1
  implements Runnable
{
  ReadInJoyManager$NotifyReceiver$1(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyManager.a, 2, String.format("receive %s", new Object[] { this.jdField_a_of_type_AndroidContentIntent.getAction() }));
    }
    long l1;
    if (this.jdField_a_of_type_AndroidContentIntent.getAction().equalsIgnoreCase("notify_main_feeds_msg_newfeeds_read"))
    {
      if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
        return;
      }
      l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newfeeds_leba_max_id", 0L);
      localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
      ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newfeeds_leba_read_id", l1);
      bhvh.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
    }
    label232:
    Object localObject2;
    label292:
    int i;
    int j;
    label1069:
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = new Intent("notify_main_feeds_msg_response");
          BaseApplication.getContext().sendBroadcast((Intent)localObject1);
          return;
          if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_newcomment_read"))
          {
            l1 = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("read_id");
            if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
              break;
            }
            long l2 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_max_id", 0L);
            long l3 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_newcomment_leba_read_id", 0L);
            if (l1 >= l3) {
              if (l2 <= l1) {
                break label292;
              }
            }
            for (;;)
            {
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
              bhvh.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              break;
              l1 = l3;
              break label232;
              l1 = l2;
            }
          }
          if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_publish_fail"))
          {
            localObject1 = new bhvt();
            ((bhvt)localObject1).c = 999999;
            ((bhvt)localObject1).a = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("feed_owner");
            ((bhvt)localObject1).d = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("fail_reason");
            localObject2 = new ArrayList();
            ((List)localObject2).add(localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a.a((List)localObject2);
          }
          else
          {
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_republish"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              l1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getLong("config_feeds_publishfail_leba_max_id", 0L);
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putLong("config_feeds_publishfail_leba_read_id", l1);
              bhvh.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_new_channel_clear"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_new_channel_notify_flag", -1);
              bhvh.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_guide_clear"))
            {
              if (ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a) == null) {
                break;
              }
              localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
              ((SharedPreferences.Editor)localObject1).putInt("config_notify_guide_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
              ((SharedPreferences.Editor)localObject1).putInt("readinjoy_push_channel_article_flag", -1);
              ((SharedPreferences.Editor)localObject1).putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
              bhvh.a((SharedPreferences.Editor)localObject1, true);
              ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
              continue;
            }
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_local_channel_flag"))
            {
              ando.d(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getCurrentAccountUin());
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_follow_uin"))
            {
              i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_position", -1);
              j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_smooth_dx", 0);
              localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("follow_uin");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                osj.a().a().a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getAccount(), (String)localObject1, true, new akuc(i, j, (String)localObject1));
              }
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_update_app_setting"))
            {
              localObject1 = bhvh.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a));
              if ((localObject1 != null) && (((andx)localObject1).jdField_a_of_type_Byte != 0))
              {
                ((andx)localObject1).jdField_a_of_type_Byte = 0;
                agca.a().a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ((andx)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
                localObject2 = (akfg)ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).a(31);
                if (localObject2 != null)
                {
                  ((akfg)localObject2).a(String.valueOf(((andx)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
                  ((akfg)localObject2).notifyUI(1, true, null);
                }
              }
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("readInJoy_video_play_real_time_report"))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
              if (localObject1 != null) {
                sgj.b(((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID"), ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE"), ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE"));
              }
            }
            else
            {
              if (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_share_friend_video")) {
                break label1069;
              }
              ForwardUtils.a((QQAppInterface)onk.a(), null, ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getApp(), this.jdField_a_of_type_AndroidContentIntent, null);
            }
          }
        }
      } while (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO"));
      localObject2 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    } while (localObject2 == null);
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      String str1 = ((Bundle)localObject2).getString("VIDEO_REPORT_TOUIN");
      String str2 = ((Bundle)localObject2).getString("VIDEO_REPORT_SUBACTION");
      i = ((Bundle)localObject2).getInt("VIDEO_REPORT_FROM_TYPE");
      j = ((Bundle)localObject2).getInt("VIDEO_REPORT_RESULT");
      noo.c((QQAppInterface)localObject1, str1, str2, ((Bundle)localObject2).getString("VIDEO_REPORT_ACTION_NAME"), i, j, ((Bundle)localObject2).getString("VIDEO_REPORT_R2"), ((Bundle)localObject2).getString("VIDEO_REPORT_R3"), ((Bundle)localObject2).getString("VIDEO_REPORT_R4"), ((Bundle)localObject2).getString("VIDEO_REPORT_R5"), ((Bundle)localObject2).getBoolean("VIDEO_REPORT_SHOULD_ENCODE"));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver.1
 * JD-Core Version:    0.7.0.1
 */