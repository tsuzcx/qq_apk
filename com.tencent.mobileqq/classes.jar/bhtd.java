import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.8.4;
import com.tencent.open.agent.OpenAuthorityFragment.8.5;
import com.tencent.open.agent.OpenAuthorityFragment.8.6;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bhtd
  implements Handler.Callback
{
  public bhtd(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    preAuth.PreAuthResponse localPreAuthResponse;
    int i;
    switch (paramMessage.what)
    {
    case 2: 
    case 10: 
    default: 
    case 0: 
      for (;;)
      {
        return true;
        localPreAuthResponse = (preAuth.PreAuthResponse)paramMessage.obj;
        OpenAuthorityFragment.a(this.a, localPreAuthResponse);
        if (localPreAuthResponse != null) {
          break;
        }
        this.a.h();
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "GET_API_LIST_DONE  response = null");
      }
      i = localPreAuthResponse.ret.get();
      if (i != 0) {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | uin : *" + bhwf.a(OpenAuthorityFragment.a(this.a).a) + " | ret : success | code : " + i);
      }
      break;
    }
    label1319:
    label2140:
    label3309:
    label3314:
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        Object localObject3;
        try
        {
          bhvw.a().a(OpenAuthorityFragment.a(this.a).a, "", OpenAuthorityFragment.a(this.a), "1", "6", "" + i, false);
          if (TextUtils.isEmpty(localPreAuthResponse.msg.get()))
          {
            paramMessage = String.format(this.a.getResources().getString(2131694252), new Object[] { Integer.valueOf(i) });
            if (i == 110405)
            {
              bhwf.a(this.a.getActivity(), paramMessage, new bhte(this));
              OpenAuthorityFragment.a(this.a, i, paramMessage);
              return true;
            }
          }
          else
          {
            paramMessage = String.format(this.a.getResources().getString(2131695971), new Object[] { localPreAuthResponse.msg.get(), Integer.valueOf(i) });
            continue;
          }
          if ((i == 110509) && (OpenAuthorityFragment.d(this.a) < 0))
          {
            OpenAuthorityFragment.b(this.a, 0);
            atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            biek.a().a(OpenAuthorityFragment.b(this.a), this.a.jdField_a_of_type_MqqObserverSSOAccountObserver, OpenAuthorityFragment.a(this.a), 3);
            OpenAuthorityFragment.a(this.a).a = System.currentTimeMillis();
            return true;
          }
          if (i == 110513)
          {
            this.a.b(110513, "", "", "");
            return true;
          }
          if (i == 100044)
          {
            localObject2 = this.a.getActivity().getIntent().getBundleExtra("key_params");
            localObject1 = ((Bundle)localObject2).getString("packagename");
            if (localObject1 != null) {
              break label3314;
            }
            localObject1 = "";
            localObject3 = ((Bundle)localObject2).getString("packagesign");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", OpenAuthorityFragment.a(this.a).a);
            ((Bundle)localObject3).putString("openid", "");
            ((Bundle)localObject3).putString("report_type", "1");
            ((Bundle)localObject3).putString("act_type", "7");
            ((Bundle)localObject3).putString("via", "2");
            ((Bundle)localObject3).putString("app_id", OpenAuthorityFragment.a(this.a));
            ((Bundle)localObject3).putString("packagename", (String)localObject1);
            ((Bundle)localObject3).putString("stringext_1", (String)localObject2);
            ((Bundle)localObject3).putString("result", "0");
            bhvw.a().a((Bundle)localObject3, OpenAuthorityFragment.a(this.a), OpenAuthorityFragment.a(this.a).a, false);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("ret", localPreAuthResponse.ret.get());
          ((JSONObject)localObject1).put("msg", localPreAuthResponse.msg.get());
          bhwf.a(this.a.getActivity(), paramMessage, new bhtf(this, localPreAuthResponse, (JSONObject)localObject1));
          continue;
          OpenAuthorityFragment.c(this.a, SystemClock.elapsedRealtime());
        }
        catch (JSONException paramMessage) {}
        OpenAuthorityFragment.a(this.a).a(OpenAuthorityFragment.a(this.a), OpenAuthorityFragment.e(this.a));
        if (OpenAuthorityFragment.a(this.a).a(OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a)), localPreAuthResponse.authorized_union_text.get()))
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | authorized");
          OpenAuthorityFragment.b(this.a, true);
          OpenAuthorityFragment.a(this.a).setTag(OpenAuthorityFragment.e(this.a));
          if (!OpenAuthorityFragment.c(this.a)) {
            OpenAuthorityFragment.a(this.a).setEnabled(true);
          }
          paramMessage = new HashMap();
          paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "auth");
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_pageview", false, System.currentTimeMillis() - OpenAuthorityFragment.c(this.a), 0L, paramMessage, "");
          this.a.b("wtl_loggednunauthorized", OpenAuthorityFragment.a(this.a).a);
          if (!OpenAuthorityFragment.d(this.a)) {
            this.a.h();
          }
        }
        for (;;)
        {
          OpenAuthorityFragment.a(this.a);
          break;
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | not authorized");
          OpenAuthorityFragment.b(this.a, false);
          OpenAuthorityFragment.a(this.a).setTag(OpenAuthorityFragment.d(this.a));
          OpenAuthorityFragment.a(this.a).setEnabled(true);
          paramMessage = new HashMap();
          paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_pageview", false, System.currentTimeMillis() - OpenAuthorityFragment.c(this.a), 0L, paramMessage, "");
          if (!OpenAuthorityFragment.e(this.a)) {
            this.a.b("wtl_loggednauthorized", OpenAuthorityFragment.a(this.a).a);
          }
          this.a.h();
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "handleMessage AUTHORIZE_DONE");
        localObject1 = (bhvg)paramMessage.obj;
        i = ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get();
        if (i != 0)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: A_D | uin : *" + bhwf.a(OpenAuthorityFragment.a(this.a).a) + " | state : success | ret : " + i);
          try
          {
            localObject2 = ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBStringField.get();
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramMessage = String.format(this.a.getResources().getString(2131694252), new Object[] { Integer.valueOf(i) });
              if (i != 110405) {
                break label1319;
              }
              bhwf.a(this.a.getActivity(), paramMessage, new bhtg(this));
            }
            do
            {
              OpenAuthorityFragment.a(this.a, i, paramMessage);
              return true;
              paramMessage = String.format(this.a.getResources().getString(2131695971), new Object[] { localObject2, Integer.valueOf(i) });
              break;
              if ((i == 110509) && (OpenAuthorityFragment.d(this.a) < 1))
              {
                OpenAuthorityFragment.b(this.a, 1);
                QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ret == SKEY_CHECK_ERROR && mSKeyErrorStep < AUTHORIZE_DONE");
                atqa.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                biek.a().a(OpenAuthorityFragment.b(this.a), this.a.jdField_a_of_type_MqqObserverSSOAccountObserver, OpenAuthorityFragment.a(this.a), 3);
                OpenAuthorityFragment.a(this.a).a = System.currentTimeMillis();
                return true;
              }
            } while (i != 1105030);
            OpenAuthorityFragment.b(this.a, i, (String)localObject2);
            paramMessage = bifi.a(OpenAuthorityFragment.a(this.a), OpenAuthorityFragment.a(this.a).a);
            if ((paramMessage != null) && (paramMessage.length > 0))
            {
              localObject3 = new SdkAuthorize.AuthorizeResponse();
              try
              {
                paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
                localObject3 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
                ((Message)localObject3).what = 1;
                ((Message)localObject3).obj = bhvg.a(paramMessage);
                this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject3);
                return true;
              }
              catch (InvalidProtocolBufferMicroException paramMessage) {}
            }
            OpenAuthorityFragment.c(this.a, i, (String)localObject2);
            return true;
          }
          catch (JSONException paramMessage) {}
        }
        this.a.b(((bhvg)localObject1).c.get());
        this.a.a(((bhvg)localObject1).c.get(), ((bhvg)localObject1).e.get());
        try
        {
          paramMessage = new JSONObject();
          paramMessage.put("ret", ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get());
          paramMessage.put("openid", ((bhvg)localObject1).c.get());
          paramMessage.put("access_token", ((bhvg)localObject1).jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
          paramMessage.put("pay_token", ((bhvg)localObject1).d.get());
          paramMessage.put("expires_in", ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBInt64Field.get());
          paramMessage.put("code", ((bhvg)localObject1).n.get());
          paramMessage.put("proxy_code", ((bhvg)localObject1).jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.code.get());
          paramMessage.put("proxy_expires_in", ((bhvg)localObject1).jdField_a_of_type_ComTencentQconnProtofileAuth$ProxyAuthResponse.expires_in.get());
          paramMessage.put("pf", ((bhvg)localObject1).f.get());
          paramMessage.put("pfkey", ((bhvg)localObject1).g.get());
          paramMessage.put("msg", ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBStringField.get());
          paramMessage.put("login_cost", OpenAuthorityFragment.a(this.a) - OpenAuthorityFragment.b(this.a));
          paramMessage.put("query_authority_cost", OpenAuthorityFragment.f(this.a) - OpenAuthorityFragment.g(this.a));
          if (OpenAuthorityFragment.h(this.a) == 0L)
          {
            paramMessage.put("authority_cost", 0);
            if (((bhvg)localObject1).jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.has()) {
              paramMessage.put("sendinstall", ((bhvg)localObject1).jdField_b_of_type_ComTencentMobileqqPbPBUInt32Field.get());
            }
            if ((((bhvg)localObject1).j.has()) && (!TextUtils.isEmpty(((bhvg)localObject1).j.get()))) {
              paramMessage.put("installwording", ((bhvg)localObject1).j.get());
            }
            if ((!((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.has()) || (((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.size() <= 0)) {
              break label2140;
            }
            localObject2 = ((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBRepeatMessageField.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (appType.PassData)((Iterator)localObject2).next();
              paramMessage.put(((appType.PassData)localObject3).key.get(), ((appType.PassData)localObject3).value.get());
            }
          }
        }
        catch (JSONException paramMessage)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "JSONException", paramMessage);
          for (;;)
          {
            paramMessage = new HashMap();
            paramMessage.put("autologin", "0");
            if (!OpenAuthorityFragment.e(this.a)) {
              break label2304;
            }
            if (!OpenAuthorityFragment.g(this.a)) {
              break label2209;
            }
            paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
            paramMessage.put("p1", "notlogged");
            paramMessage.put("p2", "auth");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.a), 0L, paramMessage, "");
            this.a.b("wtl_lognback", OpenAuthorityFragment.a(this.a).a);
            break;
            paramMessage.put("authority_cost", OpenAuthorityFragment.h(this.a) - OpenAuthorityFragment.e(this.a));
            break label1818;
            if (OpenAuthorityFragment.f(this.a))
            {
              ForwardUtils.reportAuthorityTotal(((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), OpenAuthorityFragment.a(this.a));
              bhuh.a().a(OpenAuthorityFragment.a(this.a), true);
            }
            else
            {
              this.a.b(((bhvg)localObject1).jdField_a_of_type_ComTencentMobileqqPbPBUInt32Field.get(), paramMessage.toString(), null, null);
            }
          }
          paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
          paramMessage.put("p1", "notlogged");
          paramMessage.put("p2", "uauth");
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.a), 0L, paramMessage, "");
          this.a.b("wtl_lognauthorizenback", OpenAuthorityFragment.a(this.a).a);
          break;
          if (OpenAuthorityFragment.g(this.a))
          {
            paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
            paramMessage.put("p1", "logged");
            paramMessage.put("p2", "auth");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.a), 0L, paramMessage, "");
            this.a.b("wtl_loggednunauthorizedback", OpenAuthorityFragment.a(this.a).a);
            break;
          }
          paramMessage.put("appid", OpenAuthorityFragment.a(this.a));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.a), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.a), 0L, paramMessage, "");
          this.a.b("wtl_loggednauthorizedback", OpenAuthorityFragment.a(this.a).a);
        }
      }
      break;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "handleMessage GET_APP_INFO_DONE");
      paramMessage = (atks)paramMessage.obj;
      if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.c()))) {
        OpenAuthorityFragment.a(this.a).a(paramMessage.c(), null);
      }
      int k;
      int j;
      int n;
      if ((!OpenAuthorityFragment.h(this.a)) && (paramMessage != null) && (paramMessage.jdField_a_of_type_JavaUtilList != null) && (!paramMessage.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        k = 0;
        j = 0;
        i = 0;
        if (i >= paramMessage.jdField_a_of_type_JavaUtilList.size()) {
          break label3309;
        }
        n = ForwardUtils.parseInt(((aadk)paramMessage.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_ComTencentMobileqqPbPBStringField.get());
        if (n < 100) {
          break label2944;
        }
      }
      for (;;)
      {
        localObject1 = (aadk)paramMessage.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject1 != null) {
          ThreadManager.executeOnNetWorkThread(new OpenAuthorityFragment.8.4(this, (aadk)localObject1));
        }
        if (OpenAuthorityFragment.a(this.a) != null) {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "user uin = ", bhwf.a(OpenAuthorityFragment.a(this.a)) });
        }
        if (paramMessage != null)
        {
          if ((paramMessage.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads != null) && (paramMessage.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads.has()))
          {
            paramMessage = (GetAppInfoProto.Ads)paramMessage.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$Ads.get();
            if ((paramMessage.beginTime.has()) && (paramMessage.endTime.has()))
            {
              long l1 = paramMessage.beginTime.get();
              long l2 = paramMessage.endTime.get();
              long l3 = paramMessage.serverTime.get();
              localObject1 = paramMessage.imgURL.get();
              QLog.i("AuthorityActivity", 1, "Ads begin time = " + l1 + " endTime = " + l2 + " serverTime = " + l3 + " imgURL = " + (String)localObject1 + " adsTxt = " + paramMessage.txt.get());
              if ((l3 >= l1) && (l3 <= l2))
              {
                localObject2 = new Message();
                ((Message)localObject2).obj = paramMessage.txt.get();
                ((Message)localObject2).what = 8;
                this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
                ThreadManager.executeOnNetWorkThread(new OpenAuthorityFragment.8.5(this, (String)localObject1));
                break;
                int m = k;
                if (n > k)
                {
                  j = i;
                  m = n;
                }
                i += 1;
                k = m;
                break label2590;
              }
              OpenAuthorityFragment.a(this.a).a = false;
              OpenAuthorityFragment.a(this.a).a(null);
              break;
            }
            OpenAuthorityFragment.a(this.a).a = false;
            OpenAuthorityFragment.a(this.a).a(null);
            QLog.i("AuthorityActivity", 1, "Ads begin time or endTime = null");
            break;
          }
          OpenAuthorityFragment.a(this.a).a = false;
          OpenAuthorityFragment.a(this.a).a(null);
          QLog.i("AuthorityActivity", 1, "Ads = null");
          break;
        }
        OpenAuthorityFragment.a(this.a).a = false;
        OpenAuthorityFragment.a(this.a).a(null);
        QLog.i("AuthorityActivity", 1, "response = null");
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        OpenAuthorityFragment.c(this.a, true);
        OpenAuthorityFragment.a(this.a).a("", paramMessage);
        break;
        OpenAuthorityFragment.a(this.a).a = true;
        paramMessage = (String)paramMessage.obj;
        OpenAuthorityFragment.a(this.a).a(paramMessage);
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        OpenAuthorityFragment.a(this.a).a(paramMessage);
        break;
        this.a.a();
        break;
        ThreadManager.postImmediately(new OpenAuthorityFragment.8.6(this), null, true);
        break;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        OpenAuthorityFragment.a(this.a, i, paramMessage);
        break;
        this.a.h();
        localObject2 = paramMessage.getData();
        i = ((Bundle)localObject2).getInt("error", -1);
        paramMessage = ((Bundle)localObject2).getString("response");
        localObject1 = ((Bundle)localObject2).getString("msg");
        localObject2 = ((Bundle)localObject2).getString("detail");
        this.a.b(i, paramMessage, (String)localObject1, (String)localObject2);
        break;
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtd
 * JD-Core Version:    0.7.0.1
 */