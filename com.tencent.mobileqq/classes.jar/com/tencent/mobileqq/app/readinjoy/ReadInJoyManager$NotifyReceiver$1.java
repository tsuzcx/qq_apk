package com.tencent.mobileqq.app.readinjoy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.storage.ReadInJoyFeedsMsgRecord;
import java.util.ArrayList;
import java.util.List;

class ReadInJoyManager$NotifyReceiver$1
  implements Runnable
{
  ReadInJoyManager$NotifyReceiver$1(ReadInJoyManager.NotifyReceiver paramNotifyReceiver, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject1 = null;
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
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
      ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
    }
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
          label235:
          if (l2 <= l1) {
            break label295;
          }
        }
        for (;;)
        {
          localObject1 = ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).edit();
          ((SharedPreferences.Editor)localObject1).putLong("config_feeds_newcomment_leba_read_id", l1);
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          break;
          l1 = l3;
          break label235;
          label295:
          l1 = l2;
        }
      }
      Object localObject2;
      if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_feeds_msg_publish_fail"))
      {
        localObject1 = new ReadInJoyFeedsMsgRecord();
        ((ReadInJoyFeedsMsgRecord)localObject1).c = 999999;
        ((ReadInJoyFeedsMsgRecord)localObject1).a = this.jdField_a_of_type_AndroidContentIntent.getExtras().getLong("feed_owner");
        ((ReadInJoyFeedsMsgRecord)localObject1).d = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("fail_reason");
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
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
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
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
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
          ReadInJoyHelper.a((SharedPreferences.Editor)localObject1, true);
          ReadInJoyManager.b(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a);
          continue;
        }
        if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_local_channel_flag"))
        {
          ConfigServlet.d(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getCurrentAccountUin());
        }
        else
        {
          int i;
          int j;
          if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_follow_uin"))
          {
            i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_position", -1);
            j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("follow_uin_smooth_dx", 0);
            localObject1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("follow_uin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ReadInJoyLogicEngine.a().a().a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getAccount(), (String)localObject1, true, "", new ReadInJoyManager.ReadInJoyPublicAccountObserver(i, j, (String)localObject1));
            }
          }
          else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("config_update_app_setting"))
          {
            localObject1 = ReadInJoyHelper.a(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a));
            if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_Byte != 0))
            {
              ((LebaViewItem)localObject1).jdField_a_of_type_Byte = 0;
              localObject2 = (ILebaHelperService)ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getRuntimeService(ILebaHelperService.class, "");
              if (localObject2 != null)
              {
                ((ILebaHelperService)localObject2).updateAppSetting(ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a), ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
                ((ILebaHelperService)localObject2).netSetPluginState(String.valueOf(((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), true, NetConnInfoCenter.getServerTimeMillis());
                ((ILebaHelperService)localObject2).notifySetPluginState(1, true, null);
              }
              else
              {
                QLog.d(ReadInJoyManager.a, 1, "onReceive lebaHelperService == null");
              }
            }
          }
          else
          {
            Object localObject3;
            if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("readInJoy_video_play_real_time_report"))
            {
              localObject1 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
              if (localObject1 != null)
              {
                localObject2 = ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_AID");
                localObject3 = ((Bundle)localObject1).getString("VIDEO_REALTIME_REPORT_VID");
                i = ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RTYPE");
                j = ((Bundle)localObject1).getInt("VIDEO_REALTIME_REPORT_RCODE");
                ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).doVideoPlayRealtimeReport((String)localObject2, (String)localObject3, i, j);
              }
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("notify_main_share_friend_video"))
            {
              ForwardUtils.a((QQAppInterface)ReadInJoyUtils.a(), null, ReadInJoyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppReadinjoyReadInJoyManager$NotifyReceiver.a).getApp(), this.jdField_a_of_type_AndroidContentIntent, null);
            }
            else if (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("READINJOY_VIDEO_DATA_REPORT_WITH_FANS_INFO"))
            {
              localObject2 = this.jdField_a_of_type_AndroidContentIntent.getExtras();
              if (localObject2 != null)
              {
                localObject3 = BaseApplicationImpl.getApplication().getRuntime();
                if ((localObject3 instanceof QQAppInterface)) {
                  localObject1 = (QQAppInterface)localObject3;
                }
                localObject3 = ((Bundle)localObject2).getString("VIDEO_REPORT_TOUIN");
                String str1 = ((Bundle)localObject2).getString("VIDEO_REPORT_SUBACTION");
                i = ((Bundle)localObject2).getInt("VIDEO_REPORT_FROM_TYPE");
                j = ((Bundle)localObject2).getInt("VIDEO_REPORT_RESULT");
                String str2 = ((Bundle)localObject2).getString("VIDEO_REPORT_ACTION_NAME");
                String str3 = ((Bundle)localObject2).getString("VIDEO_REPORT_R2");
                String str4 = ((Bundle)localObject2).getString("VIDEO_REPORT_R3");
                String str5 = ((Bundle)localObject2).getString("VIDEO_REPORT_R4");
                String str6 = ((Bundle)localObject2).getString("VIDEO_REPORT_R5");
                boolean bool = ((Bundle)localObject2).getBoolean("VIDEO_REPORT_SHOULD_ENCODE");
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).doVideoDataReportWithFansInfoInR5((AppInterface)localObject1, (String)localObject3, str1, str2, i, j, str3, str4, str5, str6, bool);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.NotifyReceiver.1
 * JD-Core Version:    0.7.0.1
 */