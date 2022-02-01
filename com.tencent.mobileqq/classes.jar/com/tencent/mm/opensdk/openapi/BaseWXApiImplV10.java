package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.channel.a.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult.Resp;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom.Resp;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Req;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage.Resp;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Req;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg.Resp;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Req;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken.Resp;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Req;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Req;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Req;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance.Resp;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Req;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram.Resp;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Resp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class BaseWXApiImplV10
  implements IWXAPI
{
  protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  private static String wxappPayEntryClassname;
  protected String appId;
  protected boolean checkSignature = false;
  protected Context context;
  protected boolean detached = false;
  private int wxSdkVersion;
  
  BaseWXApiImplV10(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("<init>, appId = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", checkSignature = ");
    localStringBuilder.append(paramBoolean);
    Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
    d.D = paramContext.getApplicationContext();
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
      if (paramArrayOfByte1.length == paramArrayOfByte2.length) {}
    }
    for (paramArrayOfByte1 = "checkSumConsistent fail, length is different";; paramArrayOfByte1 = "checkSumConsistent fail, invalid arguments")
    {
      Log.e("MicroMsg.SDK.WXApiImplV10", paramArrayOfByte1);
      return false;
      int i = 0;
      while (i < paramArrayOfByte1.length)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
  }
  
  private boolean createChatroom(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_create_chatroom_group_id", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_name", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_create_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private String getTokenFromWX(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[] { this.appId, "621086464" }, null);
    if ((paramContext != null) && (paramContext.moveToFirst()))
    {
      String str = paramContext.getString(0);
      StringBuilder localStringBuilder = new StringBuilder("getTokenFromWX token is ");
      localStringBuilder.append(str);
      Log.i("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
      paramContext.close();
      return str;
    }
    return null;
  }
  
  private boolean handleWxInternalRespType(String paramString, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    Object localObject1 = new StringBuilder("handleWxInternalRespType, extInfo = ");
    ((StringBuilder)localObject1).append(paramString);
    Log.i("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject1).toString());
    try
    {
      paramString = Uri.parse(paramString);
      localObject1 = paramString.getQueryParameter("wx_internal_resptype");
      Object localObject2 = new StringBuilder("handleWxInternalRespType, respType = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.i("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject2).toString());
      if (d.b((String)localObject1))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
        return false;
      }
      boolean bool = ((String)localObject1).equals("subscribemessage");
      if (bool)
      {
        localObject1 = new SubscribeMessage.Resp();
        localObject2 = paramString.getQueryParameter("ret");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((SubscribeMessage.Resp)localObject1).errCode = d.c((String)localObject2);
        }
        ((SubscribeMessage.Resp)localObject1).openId = paramString.getQueryParameter("openid");
        ((SubscribeMessage.Resp)localObject1).templateID = paramString.getQueryParameter("template_id");
        ((SubscribeMessage.Resp)localObject1).scene = d.c(paramString.getQueryParameter("scene"));
        ((SubscribeMessage.Resp)localObject1).action = paramString.getQueryParameter("action");
        ((SubscribeMessage.Resp)localObject1).reserved = paramString.getQueryParameter("reserved");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject1);
        return true;
      }
      bool = ((String)localObject1).contains("invoice_auth_insert");
      if (bool)
      {
        localObject1 = new WXInvoiceAuthInsert.Resp();
        localObject2 = paramString.getQueryParameter("ret");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((WXInvoiceAuthInsert.Resp)localObject1).errCode = d.c((String)localObject2);
        }
        ((WXInvoiceAuthInsert.Resp)localObject1).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject1);
        return true;
      }
      if (((String)localObject1).contains("payinsurance"))
      {
        localObject1 = new WXPayInsurance.Resp();
        localObject2 = paramString.getQueryParameter("ret");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((WXPayInsurance.Resp)localObject1).errCode = d.c((String)localObject2);
        }
        ((WXPayInsurance.Resp)localObject1).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject1);
        return true;
      }
      if (((String)localObject1).contains("nontaxpay"))
      {
        localObject1 = new WXNontaxPay.Resp();
        localObject2 = paramString.getQueryParameter("ret");
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          ((WXNontaxPay.Resp)localObject1).errCode = d.c((String)localObject2);
        }
        ((WXNontaxPay.Resp)localObject1).wxOrderId = paramString.getQueryParameter("wx_order_id");
        paramIWXAPIEventHandler.onResp((BaseResp)localObject1);
        return true;
      }
      if ((!"subscribeminiprogrammsg".equals(localObject1)) && (!"5".equals(localObject1)))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
        return false;
      }
      localObject1 = new SubscribeMiniProgramMsg.Resp();
      localObject2 = paramString.getQueryParameter("ret");
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        ((SubscribeMiniProgramMsg.Resp)localObject1).errCode = d.c((String)localObject2);
      }
      ((SubscribeMiniProgramMsg.Resp)localObject1).openId = paramString.getQueryParameter("openid");
      ((SubscribeMiniProgramMsg.Resp)localObject1).unionId = paramString.getQueryParameter("unionid");
      ((SubscribeMiniProgramMsg.Resp)localObject1).nickname = paramString.getQueryParameter("nickname");
      ((SubscribeMiniProgramMsg.Resp)localObject1).errStr = paramString.getQueryParameter("errmsg");
      paramIWXAPIEventHandler.onResp((BaseResp)localObject1);
      return true;
    }
    catch (Exception paramString)
    {
      paramIWXAPIEventHandler = new StringBuilder("handleWxInternalRespType fail, ex = ");
      paramIWXAPIEventHandler.append(paramString.getMessage());
      Log.e("MicroMsg.SDK.WXApiImplV10", paramIWXAPIEventHandler.toString());
    }
    return false;
  }
  
  private boolean joinChatroom(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_join_chatroom_group_id", ""), paramBundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_join_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private void launchWXIfNeed()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      Log.i("MicroMsg.SDK.WXApiImplV10", "openWXApp before api call");
      openWXApp();
    }
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendChooseCardFromWX(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { paramBundle.getString("_wxapi_choose_card_from_wx_card_app_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_location_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), paramBundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), paramBundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendHandleScanResult(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_scan_qrcode_result") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendInvoiceAuthInsert(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXInvoiceAuthInsert.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "2", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendJumpToOfflinePayReq(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[] { this.appId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendLaunchWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXLaunchMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
    String str1 = this.appId;
    String str2 = paramBaseReq.userName;
    String str3 = paramBaseReq.path;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBaseReq.miniprogramType);
    paramContext = paramContext.query(localUri, null, null, new String[] { str1, str2, str3, localStringBuilder.toString(), paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendLaunchWXMiniprogramWithToken(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXLaunchMiniProgramWithToken.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[] { this.appId, paramBaseReq.token }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendNonTaxPay(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXNontaxPay.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "3", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenBusiLuckyMoney(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), paramBundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), paramBundle.getString("_wxapi_open_busi_lucky_money_signType"), paramBundle.getString("_wxapi_open_busi_lucky_money_signature"), paramBundle.getString("_wxapi_open_busi_lucky_money_package") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenBusinessView(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXOpenBusinessView.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[] { this.appId, paramBaseReq.businessType, paramBaseReq.query, paramBaseReq.extInfo, paramBaseReq.transaction }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenBusinessWebview(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXOpenBusinessWebview.Req)paramBaseReq;
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
    if ((paramBaseReq.queryInfo != null) && (paramBaseReq.queryInfo.size() > 0)) {
      paramContext = new JSONObject(paramBaseReq.queryInfo).toString();
    } else {
      paramContext = "";
    }
    String str = this.appId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBaseReq.businessType);
    paramContext = localContentResolver.query(localUri, null, null, new String[] { str, localStringBuilder.toString(), paramContext }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenRankListReq(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendOpenWebview(Context paramContext, Bundle paramBundle)
  {
    launchWXIfNeed();
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_webview_url"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendPayInSurance(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (WXPayInsurance.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview");
    paramBaseReq = URLEncoder.encode(String.format("url=%s", new Object[] { URLEncoder.encode(paramBaseReq.url) }));
    paramContext = paramContext.query(localUri, null, null, new String[] { this.appId, "4", paramBaseReq }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle)
  {
    if (wxappPayEntryClassname == null)
    {
      wxappPayEntryClassname = new MMSharedPreferences(paramContext).getString("_wxapp_pay_entry_classname_", null);
      StringBuilder localStringBuilder1 = new StringBuilder("pay, set wxappPayEntryClassname = ");
      localStringBuilder1.append(wxappPayEntryClassname);
      Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder1.toString());
      if (wxappPayEntryClassname == null) {
        try
        {
          wxappPayEntryClassname = paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder("get from metaData failed : ");
          localStringBuilder2.append(localException.getMessage());
          Log.e("MicroMsg.SDK.WXApiImplV10", localStringBuilder2.toString());
        }
      }
      if (wxappPayEntryClassname == null)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
        return false;
      }
    }
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.bundle = paramBundle;
    localArgs.targetPkgName = "com.tencent.mm";
    localArgs.targetClassName = wxappPayEntryClassname;
    return MMessageActV2.send(paramContext, localArgs);
  }
  
  private boolean sendPreloadWXMiniprogram(Context paramContext, BaseReq paramBaseReq)
  {
    paramBaseReq = (WXPreloadMiniProgram.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver();
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
    String str1 = this.appId;
    String str2 = paramBaseReq.userName;
    String str3 = paramBaseReq.path;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBaseReq.miniprogramType);
    paramContext = paramContext.query(localUri, null, null, new String[] { str1, str2, str3, localStringBuilder.toString(), paramBaseReq.extData }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendSubscribeMessage(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (SubscribeMessage.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "1", String.valueOf(paramBaseReq.scene), paramBaseReq.templateID, paramBaseReq.reserved }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  private boolean sendSubscribeMiniProgramMsg(Context paramContext, BaseReq paramBaseReq)
  {
    launchWXIfNeed();
    paramBaseReq = (SubscribeMiniProgramMsg.Req)paramBaseReq;
    paramContext = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[] { this.appId, "5", paramBaseReq.miniProgramAppId }, null);
    if (paramContext != null) {
      paramContext.close();
    }
    return true;
  }
  
  public void detach()
  {
    Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
  }
  
  public int getWXAppSupportAPI()
  {
    if (!this.detached)
    {
      if (!isWXAppInstalled())
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        return 0;
      }
      this.wxSdkVersion = 0;
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      d.E.submit(new BaseWXApiImplV10.1(this, localCountDownLatch));
      try
      {
        localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.w("MicroMsg.SDK.WXApiImplV10", localInterruptedException.getMessage());
      }
      StringBuilder localStringBuilder1 = new StringBuilder("wxSdkVersion = ");
      localStringBuilder1.append(this.wxSdkVersion);
      Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder1.toString());
      if (this.wxSdkVersion == 0) {
        try
        {
          this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
          localStringBuilder1 = new StringBuilder("OPEN_SDK_VERSION = ");
          localStringBuilder1.append(this.wxSdkVersion);
          Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder1.toString());
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder("get from metaData failed : ");
          localStringBuilder2.append(localException.getMessage());
          Log.e("MicroMsg.SDK.WXApiImplV10", localStringBuilder2.toString());
        }
      }
      return this.wxSdkVersion;
    }
    throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
  }
  
  public boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler)
  {
    for (;;)
    {
      try
      {
        if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token"))
        {
          Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
          return false;
        }
        Object localObject1;
        int i;
        Object localObject2;
        if (!this.detached)
        {
          localObject1 = paramIntent.getStringExtra("_mmessage_content");
          i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
          localObject2 = paramIntent.getStringExtra("_mmessage_appPackage");
          if ((localObject2 != null) && (((String)localObject2).length() != 0))
          {
            if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a((String)localObject1, i, (String)localObject2)))
            {
              Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
              return false;
            }
            i = paramIntent.getIntExtra("_wxapi_command_type", 0);
            localObject1 = new StringBuilder("handleIntent, cmd = ");
            ((StringBuilder)localObject1).append(i);
            Log.i("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject1).toString());
          }
        }
        switch (i)
        {
        case 29: 
          paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(paramIntent.getExtras()));
          return true;
        case 28: 
          paramIWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(paramIntent.getExtras()));
          return true;
        case 27: 
          paramIWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(paramIntent.getExtras()));
          return true;
        case 26: 
          paramIWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(paramIntent.getExtras()));
          return true;
        case 25: 
          paramIWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(paramIntent.getExtras()));
          return true;
        case 24: 
          paramIWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(paramIntent.getExtras()));
          return true;
        case 19: 
          paramIWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(paramIntent.getExtras()));
          return true;
        case 17: 
          paramIWXAPIEventHandler.onResp(new HandleScanResult.Resp(paramIntent.getExtras()));
          return true;
        case 16: 
          paramIWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(paramIntent.getExtras()));
          return true;
        case 15: 
          paramIWXAPIEventHandler.onResp(new JoinChatroom.Resp(paramIntent.getExtras()));
          return true;
        case 14: 
          paramIWXAPIEventHandler.onResp(new CreateChatroom.Resp(paramIntent.getExtras()));
          return true;
        case 12: 
          paramIWXAPIEventHandler.onResp(new OpenWebview.Resp(paramIntent.getExtras()));
          return true;
        case 9: 
          paramIWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
          return true;
        case 6: 
          paramIWXAPIEventHandler.onReq(new LaunchFromWX.Req(paramIntent.getExtras()));
          return true;
        case 5: 
          paramIWXAPIEventHandler.onResp(new PayResp(paramIntent.getExtras()));
          return true;
        case 4: 
          paramIntent = new ShowMessageFromWX.Req(paramIntent.getExtras());
          localObject2 = paramIntent.message.messageExt;
          boolean bool;
          if ((localObject2 != null) && (((String)localObject2).contains("wx_internal_resptype")))
          {
            bool = handleWxInternalRespType((String)localObject2, paramIWXAPIEventHandler);
            paramIntent = new StringBuilder("handleIntent, extInfo contains wx_internal_resptype, ret = ");
            paramIntent.append(bool);
            Log.i("MicroMsg.SDK.WXApiImplV10", paramIntent.toString());
            return bool;
          }
          if (localObject2 != null)
          {
            bool = ((String)localObject2).contains("openbusinesswebview");
            if (bool) {
              try
              {
                localObject1 = Uri.parse((String)localObject2);
                if ((localObject1 != null) && ("openbusinesswebview".equals(((Uri)localObject1).getHost())))
                {
                  localObject2 = new WXOpenBusinessWebview.Resp();
                  String str = ((Uri)localObject1).getQueryParameter("ret");
                  if ((str != null) && (str.length() > 0)) {
                    ((WXOpenBusinessWebview.Resp)localObject2).errCode = d.c(str);
                  }
                  ((WXOpenBusinessWebview.Resp)localObject2).resultInfo = ((Uri)localObject1).getQueryParameter("resultInfo");
                  ((WXOpenBusinessWebview.Resp)localObject2).errStr = ((Uri)localObject1).getQueryParameter("errmsg");
                  localObject1 = ((Uri)localObject1).getQueryParameter("type");
                  if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
                    ((WXOpenBusinessWebview.Resp)localObject2).businessType = d.c((String)localObject1);
                  }
                  paramIWXAPIEventHandler.onResp((BaseResp)localObject2);
                  return true;
                }
                localObject1 = new StringBuilder("not openbusinesswebview %");
                ((StringBuilder)localObject1).append((String)localObject2);
                Log.d("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject1).toString());
              }
              catch (Exception localException)
              {
                localObject2 = new StringBuilder("parse fail, ex = ");
                ((StringBuilder)localObject2).append(localException.getMessage());
                Log.e("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject2).toString());
              }
            }
          }
          paramIWXAPIEventHandler.onReq(paramIntent);
          return true;
        case 3: 
          paramIWXAPIEventHandler.onReq(new GetMessageFromWX.Req(paramIntent.getExtras()));
          return true;
        case 2: 
          paramIWXAPIEventHandler.onResp(new SendMessageToWX.Resp(paramIntent.getExtras()));
          return true;
        case 1: 
          paramIWXAPIEventHandler.onResp(new SendAuth.Resp(paramIntent.getExtras()));
          return true;
          paramIntent = new StringBuilder("unknown cmd = ");
          paramIntent.append(i);
          Log.e("MicroMsg.SDK.WXApiImplV10", paramIntent.toString());
          return false;
          Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
          return false;
          throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
      }
      catch (Exception paramIntent)
      {
        paramIWXAPIEventHandler = new StringBuilder("handleIntent fail, ex = ");
        paramIWXAPIEventHandler.append(paramIntent.getMessage());
        Log.e("MicroMsg.SDK.WXApiImplV10", paramIWXAPIEventHandler.toString());
        return false;
      }
    }
  }
  
  public boolean isWXAppInstalled()
  {
    if (!this.detached) {}
    try
    {
      PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (localPackageInfo == null) {
        return false;
      }
      boolean bool = WXApiImplComm.validateAppSignature(this.context, localPackageInfo.signatures, this.checkSignature);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
    return false;
  }
  
  public boolean openWXApp()
  {
    if (!this.detached)
    {
      String str;
      if (!isWXAppInstalled()) {
        str = "open wx app failed, not installed or signature check failed";
      }
      for (;;)
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
        try
        {
          this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
          return true;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder("startActivity fail, exception = ");
          localStringBuilder.append(localException.getMessage());
          localObject = localStringBuilder.toString();
        }
      }
    }
    Object localObject = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public boolean registerApp(String paramString)
  {
    return registerApp(paramString, 0L);
  }
  
  public boolean registerApp(String paramString, long paramLong)
  {
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder("registerApp, appId = ");
      localStringBuilder.append(paramString);
      Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
      if (paramString != null) {
        this.appId = paramString;
      }
      localStringBuilder = new StringBuilder("registerApp, appId = ");
      localStringBuilder.append(paramString);
      Log.d("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
      if (paramString != null) {
        this.appId = paramString;
      }
      paramString = new StringBuilder("register app ");
      paramString.append(this.context.getPackageName());
      Log.d("MicroMsg.SDK.WXApiImplV10", paramString.toString());
      paramString = new a.a();
      paramString.a = "com.tencent.mm";
      paramString.action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      localStringBuilder = new StringBuilder("weixin://registerapp?appid=");
      localStringBuilder.append(this.appId);
      paramString.content = localStringBuilder.toString();
      paramString.b = paramLong;
      return a.a(this.context, paramString);
    }
    throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
  }
  
  public boolean sendReq(BaseReq paramBaseReq)
  {
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {}
      for (paramBaseReq = "sendReq failed for wechat app signature check failed";; paramBaseReq = "sendReq checkArgs fail")
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", paramBaseReq);
        return false;
        if (paramBaseReq.checkArgs()) {
          break;
        }
      }
      Object localObject = new StringBuilder("sendReq, req type = ");
      ((StringBuilder)localObject).append(paramBaseReq.getType());
      Log.i("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject).toString());
      Bundle localBundle = new Bundle();
      paramBaseReq.toBundle(localBundle);
      if ((paramBaseReq.getType() != 5) && (paramBaseReq.getType() != 27))
      {
        if (paramBaseReq.getType() == 9) {
          return sendAddCardToWX(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 16) {
          return sendChooseCardFromWX(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 11) {
          return sendOpenRankListReq(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 12) {
          return sendOpenWebview(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 25) {
          return sendOpenBusinessWebview(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 13) {
          return sendOpenBusiLuckyMoney(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 14) {
          return createChatroom(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 15) {
          return joinChatroom(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 17) {
          return sendHandleScanResult(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 18) {
          return sendSubscribeMessage(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 28) {
          return sendPreloadWXMiniprogram(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 29) {
          return sendLaunchWXMiniprogramWithToken(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 23) {
          return sendSubscribeMiniProgramMsg(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 19) {
          return sendLaunchWXMiniprogram(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 26) {
          return sendOpenBusinessView(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 20) {
          return sendInvoiceAuthInsert(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 21) {
          return sendNonTaxPay(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 22) {
          return sendPayInSurance(this.context, paramBaseReq);
        }
        if (paramBaseReq.getType() == 24) {
          return sendJumpToOfflinePayReq(this.context, localBundle);
        }
        if (paramBaseReq.getType() == 2)
        {
          SendMessageToWX.Req localReq = (SendMessageToWX.Req)paramBaseReq;
          int i = localReq.message.getType();
          if (d.a(i))
          {
            if (getWXAppSupportAPI() < 620756993) {}
            for (localObject = new WXWebpageObject();; localObject = new WXWebpageObject())
            {
              ((WXWebpageObject)localObject).webpageUrl = localBundle.getString("_wxminiprogram_webpageurl");
              localReq.message.mediaObject = ((WXMediaMessage.IMediaObject)localObject);
              break label731;
              if ((i != 46) || (getWXAppSupportAPI() >= 620953856)) {
                break;
              }
            }
            WXMiniProgramObject localWXMiniProgramObject = (WXMiniProgramObject)localReq.message.mediaObject;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localWXMiniProgramObject.userName);
            ((StringBuilder)localObject).append("@app");
            localWXMiniProgramObject.userName = ((StringBuilder)localObject).toString();
            localObject = localWXMiniProgramObject.path;
            if (!d.b((String)localObject))
            {
              localObject = ((String)localObject).split("\\?");
              if (localObject.length > 1)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject[0]);
                localStringBuilder.append(".html?");
                localObject = localObject[1];
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(localObject[0]);
                localObject = ".html";
              }
              localStringBuilder.append((String)localObject);
              localWXMiniProgramObject.path = localStringBuilder.toString();
            }
            label731:
            if (localReq.scene != 3) {
              localReq.scene = 0;
            }
            paramBaseReq.toBundle(localBundle);
          }
        }
        localObject = new MMessageActV2.Args();
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        StringBuilder localStringBuilder = new StringBuilder("weixin://sendreq?appid=");
        localStringBuilder.append(this.appId);
        ((MMessageActV2.Args)localObject).content = localStringBuilder.toString();
        ((MMessageActV2.Args)localObject).targetPkgName = "com.tencent.mm";
        ((MMessageActV2.Args)localObject).targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
        if (paramBaseReq.getType() == 2) {
          try
          {
            ((MMessageActV2.Args)localObject).token = getTokenFromWX(this.context);
          }
          catch (Exception paramBaseReq)
          {
            localStringBuilder = new StringBuilder("getTokenFromWX fail, exception = ");
            localStringBuilder.append(paramBaseReq.getMessage());
            Log.e("MicroMsg.SDK.WXApiImplV10", localStringBuilder.toString());
          }
        }
        return MMessageActV2.send(this.context, (MMessageActV2.Args)localObject);
      }
      return sendPayReq(this.context, localBundle);
    }
    paramBaseReq = new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    for (;;)
    {
      throw paramBaseReq;
    }
  }
  
  public boolean sendResp(BaseResp paramBaseResp)
  {
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {}
      for (paramBaseResp = "sendResp failed for wechat app signature check failed";; paramBaseResp = "sendResp checkArgs fail")
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", paramBaseResp);
        return false;
        if (paramBaseResp.checkArgs()) {
          break;
        }
      }
      Object localObject = new Bundle();
      paramBaseResp.toBundle((Bundle)localObject);
      paramBaseResp = new MMessageActV2.Args();
      paramBaseResp.bundle = ((Bundle)localObject);
      localObject = new StringBuilder("weixin://sendresp?appid=");
      ((StringBuilder)localObject).append(this.appId);
      paramBaseResp.content = ((StringBuilder)localObject).toString();
      paramBaseResp.targetPkgName = "com.tencent.mm";
      paramBaseResp.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
      return MMessageActV2.send(this.context, paramBaseResp);
    }
    paramBaseResp = new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    for (;;)
    {
      throw paramBaseResp;
    }
  }
  
  public void setLogImpl(ILog paramILog)
  {
    Log.setLogImpl(paramILog);
  }
  
  public void unregisterApp()
  {
    if (!this.detached)
    {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature))
      {
        Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        return;
      }
      Object localObject = new StringBuilder("unregisterApp, appId = ");
      ((StringBuilder)localObject).append(this.appId);
      Log.d("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject).toString());
      localObject = this.appId;
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        localObject = new StringBuilder("unregister app ");
        ((StringBuilder)localObject).append(this.context.getPackageName());
        Log.d("MicroMsg.SDK.WXApiImplV10", ((StringBuilder)localObject).toString());
        localObject = new a.a();
        ((a.a)localObject).a = "com.tencent.mm";
        ((a.a)localObject).action = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
        StringBuilder localStringBuilder = new StringBuilder("weixin://unregisterapp?appid=");
        localStringBuilder.append(this.appId);
        ((a.a)localObject).content = localStringBuilder.toString();
        a.a(this.context, (a.a)localObject);
        return;
      }
      Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      return;
    }
    throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.openapi.BaseWXApiImplV10
 * JD-Core Version:    0.7.0.1
 */