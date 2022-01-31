package com.tencent.biz.pubaccount.readinjoy.view.appinpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.OrangeControlInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.OrdinaryPushInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.SocialPushInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.UGCPushInfo;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mlq;
import mls;
import mlt;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class KandianAppInPush
{
  private static KandianAppInPush jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush;
  private Kandian210Msg0xeeInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo;
  private AppInPushNotification.OnDismissListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnDismissListener = new mlq(this);
  private AppInPushNotification jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification;
  private Kandian210Msg0xeeInfo b;
  
  private AppInPushNotification a(Context paramContext, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo, AppInPushNotification.OnDismissListener paramOnDismissListener)
  {
    Object localObject1 = paramNotifyInfo.contextTitle;
    String str5 = paramNotifyInfo.contextBrief;
    String str6 = paramNotifyInfo.username;
    String str7 = paramNotifyInfo.userIconURL;
    int j = paramNotifyInfo.styleType;
    long l = paramNotifyInfo.duration;
    String str2;
    label67:
    String str8;
    int k;
    Object localObject2;
    String str3;
    String str1;
    Object localObject3;
    if ((paramNotifyInfo.picturesURLList != null) && (paramNotifyInfo.picturesURLList.size() > 0))
    {
      str2 = (String)paramNotifyInfo.picturesURLList.get(0);
      str8 = paramNotifyInfo.pictureJumpURL;
      k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.bid;
      switch (paramNotifyInfo.appPushType)
      {
      default: 
        localObject2 = paramNotifyInfo.orangeWord;
        if ((paramNotifyInfo.ordinaryPushInfo != null) && (paramNotifyInfo.ordinaryPushInfo.orangeControlInfo != null))
        {
          str3 = paramNotifyInfo.ordinaryPushInfo.orangeControlInfo.color;
          str1 = "";
          localObject3 = localObject1;
        }
        break;
      }
    }
    for (localObject1 = str3;; localObject1 = "")
    {
      try
      {
        for (;;)
        {
          str3 = Long.valueOf(paramNotifyInfo.uin).toString();
          switch (paramNotifyInfo.contextType)
          {
          case 2: 
          default: 
            i = 0;
            return AppInPushNotification.a().a(paramContext).a((QQAppInterface)ReadInJoyUtils.a()).b((String)localObject3).c(str5).a(str2).d(str7).f(str3).e(str6).g(str1).b(i).a(j).h((String)localObject2).i((String)localObject1).a(l).a(new mlt(this, str8, k, paramNotifyInfo)).a(paramOnDismissListener).a();
            str2 = "";
            break label67;
            str1 = paramNotifyInfo.socialPushInfo.biuReason;
            localObject1 = paramNotifyInfo.socialPushInfo.biuComment;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject3 = (String)localObject1 + "//" + paramNotifyInfo.contextTitle;
              localObject2 = "";
              localObject1 = "";
            }
            else
            {
              localObject3 = paramNotifyInfo.contextTitle;
              localObject2 = "";
              localObject1 = "";
              continue;
              str1 = paramNotifyInfo.ugcPushInfo.ugcReason;
              localObject2 = "";
              localObject3 = localObject1;
              str3 = "";
              localObject1 = localObject2;
              localObject2 = str3;
            }
            break;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("KandianAppInPush", 2, "buildBubbleAppInPushNotification: ", localNumberFormatException);
          String str4 = "";
          continue;
          int i = 1;
        }
      }
      str1 = "";
      localObject3 = localObject1;
    }
  }
  
  public static KandianAppInPush a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush = new KandianAppInPush();
      }
      KandianAppInPush localKandianAppInPush = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushKandianAppInPush;
      return localKandianAppInPush;
    }
    finally {}
  }
  
  public void a(Kandian210Msg0xeeInfo paramKandian210Msg0xeeInfo)
  {
    for (;;)
    {
      try
      {
        long l = NetConnInfoCenter.getServerTime();
        if ((paramKandian210Msg0xeeInfo != null) && (paramKandian210Msg0xeeInfo.notifyInfos != null))
        {
          boolean bool = paramKandian210Msg0xeeInfo.notifyInfos.isEmpty();
          if (!bool) {}
        }
        else
        {
          return;
        }
        Kandian210Msg0xeeInfo.NotifyInfo localNotifyInfo = (Kandian210Msg0xeeInfo.NotifyInfo)paramKandian210Msg0xeeInfo.notifyInfos.get(0);
        if (localNotifyInfo.endTime <= l) {
          QLog.d("KandianAppInPush", 2, "app in push, is skip end time , seq : " + paramKandian210Msg0xeeInfo.msgSeq);
        } else {
          ThreadManager.getUIHandler().post(new mls(this, paramKandian210Msg0xeeInfo, localNotifyInfo));
        }
      }
      finally {}
    }
  }
  
  public void a(String paramString, int paramInt, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo)
  {
    Object localObject = BaseActivity.sTopActivity;
    int i;
    if ((localObject instanceof SplashActivity))
    {
      i = ((SplashActivity)localObject).a();
      if (i != MainFragment.a) {
        break label304;
      }
      i = 1;
    }
    label405:
    label408:
    for (;;)
    {
      label34:
      int j = 0;
      long l1 = 0L;
      if ("0X8008458".equals(paramString)) {
        j = 1;
      }
      for (;;)
      {
        label53:
        long l2 = paramNotifyInfo.contextId;
        long l3 = paramNotifyInfo.strategyID;
        localObject = new JSONObject();
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("algorithm_id", paramNotifyInfo.algorithmID);
            ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
            if ((paramNotifyInfo.picturesURLList == null) || (paramNotifyInfo.picturesURLList.size() <= 0)) {
              continue;
            }
            k = 1;
            ((JSONObject)localObject).put("content_style", k);
            ((JSONObject)localObject).put("push_style", paramNotifyInfo.styleType);
            ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
            ((JSONObject)localObject).put("bid", paramInt);
            ((JSONObject)localObject).put("folder_status", paramNotifyInfo.folderStatus);
            ((JSONObject)localObject).put("strategy_id", paramNotifyInfo.strategyID);
            if (j == 2) {
              ((JSONObject)localObject).put("costtime", l1);
            }
          }
          catch (JSONException localJSONException)
          {
            int k;
            label304:
            localJSONException.printStackTrace();
            continue;
          }
          ReadinjoySPEventReport.a().a(j, paramNotifyInfo);
          PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramNotifyInfo.uin), paramString, paramString, 0, 0, String.valueOf(i), String.valueOf(l2), String.valueOf(l3), ((JSONObject)localObject).toString(), false);
          if (j == 2) {
            ReadInJoyUtils.a(21, String.valueOf(l2), String.valueOf(l3), String.valueOf(paramNotifyInfo.algorithmID), "", (int)paramNotifyInfo.folderStatus);
          }
          return;
          i = -1;
          break;
          if (i == MainFragment.c)
          {
            i = 2;
            break label34;
          }
          if (i == MainFragment.g)
          {
            i = 3;
            break label34;
          }
          if (i != MainFragment.d) {
            break label408;
          }
          i = 4;
          break label34;
          if (!"0X8008459".equals(paramString)) {
            break label405;
          }
          j = 2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification == null) {
            break label405;
          }
          l1 = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification.b) / 1000L;
          j = 2;
          break label53;
          k = 0;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification.b() != 2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification.a(paramBoolean, false);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification.a());
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandian210Msg0xeeInfo.bid == paramInt) && (a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush
 * JD-Core Version:    0.7.0.1
 */