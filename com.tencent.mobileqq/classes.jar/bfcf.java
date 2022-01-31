import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.8.5;
import com.tencent.open.agent.AuthorityActivity.8.6;
import com.tencent.open.agent.AuthorityActivity.8.7;
import com.tencent.open.agent.CardContainer;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.PassData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bfcf
  implements Handler.Callback
{
  public bfcf(AuthorityActivity paramAuthorityActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse;
    int i;
    switch (paramMessage.what)
    {
    case 10: 
    default: 
    case 0: 
      for (;;)
      {
        return true;
        localGetAuthApiListResponse = (SdkAuthorize.GetAuthApiListResponse)paramMessage.obj;
        if (localGetAuthApiListResponse != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "GET_API_LIST_DONE  response = null");
        }
      }
      i = localGetAuthApiListResponse.ret.get();
      if (i != 0) {
        QLog.d("AuthorityActivity", 1, "rec | cmd: G_A_L_D | uin : *" + bfii.a(this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + i);
      }
      break;
    }
    label3592:
    label3597:
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      long l1;
      for (;;)
      {
        Object localObject3;
        try
        {
          bfhz.a().a(this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, "", AuthorityActivity.jdField_e_of_type_JavaLangString, "1", "6", "" + i, false);
          if (TextUtils.isEmpty(localGetAuthApiListResponse.msg.get()))
          {
            paramMessage = String.format(this.a.getResources().getString(2131695053), new Object[] { Integer.valueOf(i) });
            if (i == 110405)
            {
              this.a.a(paramMessage, new bfcg(this));
              this.a.b(i, paramMessage);
              return true;
            }
          }
          else
          {
            paramMessage = String.format(this.a.getResources().getString(2131696959), new Object[] { localGetAuthApiListResponse.msg.get(), Integer.valueOf(i) });
            continue;
          }
          if ((i == 110509) && (AuthorityActivity.a(this.a) < 0))
          {
            AuthorityActivity.a(this.a, 0);
            aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            bfqw.a().a(this.a.jdField_a_of_type_JavaLangString, 4096, this.a.jdField_a_of_type_MqqObserverSSOAccountObserver, true);
            AuthorityActivity.a(this.a).jdField_a_of_type_Long = System.currentTimeMillis();
            return true;
          }
          if (i == 110513)
          {
            this.a.b(110513, "", "", "");
            return true;
          }
          if (i == 100044)
          {
            localObject2 = AuthorityActivity.a(this.a).getBundleExtra("key_params");
            localObject1 = ((Bundle)localObject2).getString("packagename");
            if (localObject1 != null) {
              break label3597;
            }
            localObject1 = "";
            localObject3 = ((Bundle)localObject2).getString("packagesign");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
            ((Bundle)localObject3).putString("openid", "");
            ((Bundle)localObject3).putString("report_type", "1");
            ((Bundle)localObject3).putString("act_type", "7");
            ((Bundle)localObject3).putString("via", "2");
            ((Bundle)localObject3).putString("app_id", AuthorityActivity.jdField_e_of_type_JavaLangString);
            ((Bundle)localObject3).putString("packagename", (String)localObject1);
            ((Bundle)localObject3).putString("stringext_1", (String)localObject2);
            ((Bundle)localObject3).putString("result", "0");
            bfhz.a().a((Bundle)localObject3, AuthorityActivity.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString, false);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("ret", localGetAuthApiListResponse.ret.get());
          ((JSONObject)localObject1).put("msg", localGetAuthApiListResponse.msg.get());
          this.a.a(paramMessage, new bfch(this, localGetAuthApiListResponse, (JSONObject)localObject1));
          continue;
          this.a.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
        }
        catch (JSONException paramMessage) {}
        if (this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(localGetAuthApiListResponse))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | authorized");
          }
          this.a.jdField_f_of_type_Boolean = true;
          this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131695060);
          this.a.jdField_a_of_type_AndroidWidgetButton.setTag(this.a.jdField_b_of_type_JavaLangString);
          if (localGetAuthApiListResponse.auth_response != null) {
            this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = ((SdkAuthorize.AuthorizeResponse)localGetAuthApiListResponse.auth_response.get());
          }
          if ((this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse == null) && (this.a.jdField_c_of_type_Boolean))
          {
            this.a.k();
            return true;
          }
          if (!this.a.jdField_b_of_type_Boolean) {
            this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          }
          paramMessage = new HashMap();
          paramMessage.put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "auth");
          azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, 0L, paramMessage, "");
          this.a.b("wtl_loggednunauthorized", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
          if ((this.a.jdField_b_of_type_Boolean) && (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("SDKQQAgentPref", 2, "AutoLogin: " + SystemClock.elapsedRealtime());
            }
            this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            paramMessage = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
            paramMessage.what = 1;
            paramMessage.obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
            this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramMessage);
          }
          if (!AuthorityActivity.a(this.a)) {
            this.a.j();
          }
        }
        for (;;)
        {
          l1 = Long.parseLong(AuthorityActivity.jdField_e_of_type_JavaLangString);
          this.a.a(l1);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | not authorized");
          }
          this.a.jdField_f_of_type_Boolean = false;
          this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131695060);
          this.a.jdField_a_of_type_AndroidWidgetButton.setTag(this.a.jdField_c_of_type_JavaLangString);
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          paramMessage = new HashMap();
          paramMessage.put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_a_of_type_Long, 0L, paramMessage, "");
          if (!this.a.jdField_e_of_type_Boolean) {
            this.a.b("wtl_loggednauthorized", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
          }
          this.a.j();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "AUTHORIZE_DONE:" + SystemClock.elapsedRealtime());
        }
        localObject1 = (SdkAuthorize.AuthorizeResponse)paramMessage.obj;
        i = ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get();
        if (i != 0)
        {
          QLog.d("AuthorityActivity", 1, "rec | cmd: A_D | uin : *" + bfii.a(this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString) + " | ret : success | code : " + i);
          try
          {
            localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get();
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramMessage = String.format(this.a.getResources().getString(2131695053), new Object[] { Integer.valueOf(i) });
              if (i != 110405) {
                break label1451;
              }
              this.a.a(paramMessage, new bfci(this));
            }
            for (;;)
            {
              this.a.b(i, paramMessage);
              return true;
              paramMessage = String.format(this.a.getResources().getString(2131696959), new Object[] { localObject2, Integer.valueOf(i) });
              break;
              label1451:
              if ((i == 110509) && (AuthorityActivity.a(this.a) < 1))
              {
                AuthorityActivity.a(this.a, 1);
                aseh.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                bfqw.a().a(this.a.jdField_a_of_type_JavaLangString, 4096, this.a.jdField_a_of_type_MqqObserverSSOAccountObserver, true);
                AuthorityActivity.a(this.a).jdField_a_of_type_Long = System.currentTimeMillis();
                return true;
              }
              if (i == 1105030)
              {
                this.a.d(i, (String)localObject2);
                paramMessage = bfru.a(AuthorityActivity.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
                if ((paramMessage != null) && (paramMessage.length > 0))
                {
                  localObject3 = new SdkAuthorize.AuthorizeResponse();
                  try
                  {
                    paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
                    localObject3 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
                    ((Message)localObject3).what = 1;
                    ((Message)localObject3).obj = paramMessage;
                    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject3);
                    return true;
                  }
                  catch (InvalidProtocolBufferMicroException paramMessage) {}
                }
                this.a.c(i, (String)localObject2);
                return true;
              }
              if (i == 100044)
              {
                localObject2 = new JSONObject();
                ((JSONObject)localObject2).put("ret", ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get());
                ((JSONObject)localObject2).put("msg", ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get());
                this.a.a(paramMessage, new bfcj(this, (SdkAuthorize.AuthorizeResponse)localObject1, (JSONObject)localObject2));
              }
            }
            this.a.b(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
          }
          catch (JSONException paramMessage) {}
        }
        this.a.a(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get(), ((SdkAuthorize.AuthorizeResponse)localObject1).encrytoken.get());
        try
        {
          paramMessage = new JSONObject();
          paramMessage.put("ret", ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get());
          paramMessage.put("openid", ((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
          paramMessage.put("access_token", ((SdkAuthorize.AuthorizeResponse)localObject1).access_token.get());
          paramMessage.put("pay_token", ((SdkAuthorize.AuthorizeResponse)localObject1).pay_token.get());
          paramMessage.put("expires_in", ((SdkAuthorize.AuthorizeResponse)localObject1).expires_in.get());
          paramMessage.put("pf", ((SdkAuthorize.AuthorizeResponse)localObject1).pf.get());
          paramMessage.put("pfkey", ((SdkAuthorize.AuthorizeResponse)localObject1).pfkey.get());
          paramMessage.put("msg", ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get());
          paramMessage.put("login_cost", this.a.jdField_e_of_type_Long - this.a.d);
          paramMessage.put("query_authority_cost", this.a.jdField_g_of_type_Long - this.a.jdField_f_of_type_Long);
          if (this.a.i == 0L)
          {
            paramMessage.put("authority_cost", 0);
            label1948:
            if (((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.has()) {
              paramMessage.put("sendinstall", ((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.get());
            }
            if ((((SdkAuthorize.AuthorizeResponse)localObject1).installwording.has()) && (!TextUtils.isEmpty(((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get()))) {
              paramMessage.put("installwording", ((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get());
            }
            if ((!((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.has()) || (((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.size() <= 0)) {
              break label2274;
            }
            localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SdkAuthorize.PassData)((Iterator)localObject2).next();
              paramMessage.put(((SdkAuthorize.PassData)localObject3).key.get(), ((SdkAuthorize.PassData)localObject3).value.get());
            }
          }
        }
        catch (JSONException paramMessage)
        {
          label2100:
          localObject1 = new HashMap();
          if (this.a.jdField_h_of_type_Boolean) {}
          for (paramMessage = "1";; paramMessage = "0")
          {
            ((HashMap)localObject1).put("autologin", paramMessage);
            if (!this.a.jdField_e_of_type_Boolean) {
              break label2445;
            }
            if (!this.a.jdField_f_of_type_Boolean) {
              break label2349;
            }
            ((HashMap)localObject1).put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
            ((HashMap)localObject1).put("p1", "notlogged");
            ((HashMap)localObject1).put("p2", "auth");
            azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, (HashMap)localObject1, "");
            this.a.b("wtl_lognback", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
            break;
            paramMessage.put("authority_cost", this.a.i - this.a.jdField_h_of_type_Long);
            break label1948;
            label2274:
            if (AuthorityActivity.b(this.a))
            {
              ForwardUtils.a(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), this.a.jdField_a_of_type_Bfqv);
              bfgo.a().a(this.a.jdField_a_of_type_AndroidOsBundle, true);
              break label2100;
            }
            this.a.b(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), paramMessage.toString(), null, null);
            break label2100;
          }
          label2349:
          ((HashMap)localObject1).put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
          ((HashMap)localObject1).put("p1", "notlogged");
          ((HashMap)localObject1).put("p2", "uauth");
          azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_lognauthorizenback", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
        }
      }
      break;
      label2445:
      if (this.a.jdField_f_of_type_Boolean)
      {
        ((HashMap)localObject1).put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
        ((HashMap)localObject1).put("p1", "logged");
        ((HashMap)localObject1).put("p2", "auth");
        azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_loggednunauthorizedback", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
        break;
      }
      ((HashMap)localObject1).put("appid", AuthorityActivity.jdField_e_of_type_JavaLangString);
      ((HashMap)localObject1).put("p1", "logged");
      ((HashMap)localObject1).put("p2", "uauth");
      azri.a(this.a).a(this.a.jdField_a_of_type_JavaLangString, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, (HashMap)localObject1, "");
      this.a.b("wtl_loggednauthorizedback", this.a.jdField_a_of_type_Bfqv.jdField_a_of_type_JavaLangString);
      break;
      paramMessage = (SdkAuthorize.GetAuthApiListRequest)paramMessage.obj;
      this.a.a(paramMessage);
      break;
      paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.appName != null) && (!TextUtils.isEmpty(paramMessage.appName.get())))
      {
        localObject1 = paramMessage.appName.get();
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject1, null);
        QLog.i("AuthorityActivity", 1, "get app info done, appName is " + (String)localObject1);
      }
      int m;
      int j;
      if ((!this.a.jdField_g_of_type_Boolean) && (paramMessage != null) && (paramMessage.iconsURL != null) && (paramMessage.iconsURL.has()))
      {
        m = 0;
        j = 0;
        i = 0;
        label2785:
        if (i >= paramMessage.iconsURL.get().size()) {
          break label3592;
        }
        localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
      }
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((GetAppInfoProto.MsgIconsurl)localObject1).size.get());
          if (k >= 100)
          {
            localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
            if (localObject1 != null)
            {
              QLog.i("AuthorityActivity", 1, "get app info done, imgUrl is " + localObject1);
              ThreadManager.executeOnNetWorkThread(new AuthorityActivity.8.5(this, (GetAppInfoProto.MsgIconsurl)localObject1));
            }
            if ((this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (QLog.isColorLevel())) {
              QLog.i("AuthorityActivity", 2, "user uin = " + this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getCurrentAccountUin());
            }
            if (paramMessage == null) {
              break label3327;
            }
            if ((paramMessage.ads == null) || (!paramMessage.ads.has())) {
              break label3287;
            }
            paramMessage = (GetAppInfoProto.Ads)paramMessage.ads.get();
            if ((!paramMessage.beginTime.has()) || (!paramMessage.endTime.has())) {
              break label3247;
            }
            l1 = paramMessage.beginTime.get();
            long l2 = paramMessage.endTime.get();
            long l3 = paramMessage.serverTime.get();
            localObject1 = paramMessage.imgURL.get();
            if (QLog.isColorLevel()) {
              QLog.i("AuthorityActivity", 2, "Ads begin time = " + l1 + " endTime = " + l2 + " serverTime = " + l3 + " imgURL = " + (String)localObject1 + " adsTxt = " + paramMessage.txt.get());
            }
            if ((l3 < l1) || (l3 > l2)) {
              break label3222;
            }
            localObject2 = new Message();
            ((Message)localObject2).obj = paramMessage.txt.get();
            ((Message)localObject2).what = 8;
            this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
            ThreadManager.executeOnNetWorkThread(new AuthorityActivity.8.6(this, (String)localObject1));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int k = 0;
          continue;
          int n = m;
          if (k > m)
          {
            j = i;
            n = k;
          }
          i += 1;
          m = n;
        }
        break label2785;
        label3222:
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a = false;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(null);
        break;
        label3247:
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a = false;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "Ads begin time or endTime = null");
        break;
        label3287:
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a = false;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "Ads = null");
        break;
        label3327:
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a = false;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "response = null");
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        this.a.jdField_g_of_type_Boolean = true;
        QLog.i("AuthorityActivity", 1, "get app icon done");
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", paramMessage);
        break;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a = true;
        paramMessage = (String)paramMessage.obj;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramMessage);
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramMessage);
        break;
        this.a.a();
        break;
        ThreadManager.postImmediately(new AuthorityActivity.8.7(this), null, true);
        break;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        this.a.b(i, paramMessage);
        break;
        this.a.j();
        if (this.a.j) {
          break;
        }
        localObject2 = paramMessage.getData();
        i = ((Bundle)localObject2).getInt("error", -1);
        paramMessage = ((Bundle)localObject2).getString("response");
        String str = ((Bundle)localObject2).getString("msg");
        localObject2 = ((Bundle)localObject2).getString("detail");
        this.a.b(i, paramMessage, str, (String)localObject2);
        break;
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcf
 * JD-Core Version:    0.7.0.1
 */