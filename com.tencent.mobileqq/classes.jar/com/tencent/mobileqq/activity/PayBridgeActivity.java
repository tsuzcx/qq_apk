package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager.PCPayData;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import tbp;
import tbq;
import tbr;
import tbs;

public class PayBridgeActivity
  extends BaseActivity
{
  static HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private static boolean jdField_c_of_type_Boolean;
  protected int a;
  protected long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected ResultReceiver a;
  private DataFactory.EmojiPayReqData jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  private String g;
  private String h;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet.add("bindNewCard");
    jdField_a_of_type_JavaUtilHashSet.add("balance");
    jdField_a_of_type_JavaUtilHashSet.add("pswManage");
    jdField_a_of_type_JavaUtilHashSet.add("modifyPsw");
    jdField_a_of_type_JavaUtilHashSet.add("checkPsw");
    jdField_a_of_type_JavaUtilHashSet.add("withdraw");
    jdField_a_of_type_JavaUtilHashSet.add("transferInfor");
    jdField_a_of_type_JavaUtilHashSet.add("transfer");
    jdField_a_of_type_JavaUtilHashSet.add("graphb");
    jdField_a_of_type_JavaUtilHashSet.add("qpay_hb_share");
    jdField_a_of_type_JavaUtilHashSet.add("sendHb");
    jdField_a_of_type_JavaUtilHashSet.add("sendHbCallback");
    jdField_a_of_type_JavaUtilHashSet.add("makeHongbao");
    jdField_a_of_type_JavaUtilHashSet.add("parseqrcode");
    jdField_a_of_type_JavaUtilHashSet.add("verifyqrcode");
    jdField_a_of_type_JavaUtilHashSet.add("findPsw");
    jdField_a_of_type_JavaUtilHashSet.add("pushMsg");
    jdField_a_of_type_JavaUtilHashSet.add("transferPush");
    jdField_a_of_type_JavaUtilHashSet.add("transferqrcode");
    jdField_a_of_type_JavaUtilHashSet.add("transferInput");
    jdField_a_of_type_JavaUtilHashSet.add("redgiftDetail");
    jdField_a_of_type_JavaUtilHashSet.add("redgiftRecord");
    jdField_a_of_type_JavaUtilHashSet.add("idCardVerify");
    jdField_a_of_type_JavaUtilHashSet.add("payCode");
    jdField_a_of_type_JavaUtilHashSet.add("showWearPayAuthor");
    jdField_a_of_type_JavaUtilHashSet.add("rewardTransferInput");
    jdField_a_of_type_JavaUtilHashSet.add("hbPackConfirm");
    jdField_a_of_type_JavaUtilHashSet.add("qpayCert");
    jdField_a_of_type_JavaUtilHashSet.add("qrcodeHb");
    jdField_a_of_type_JavaUtilHashSet.add("qrcodeHbCallback");
    jdField_a_of_type_JavaUtilHashSet.add("payByFriendConfirm");
    jdField_a_of_type_JavaUtilHashSet.add("goldmsg_open");
    jdField_a_of_type_JavaUtilHashSet.add("goldmsg_close");
    jdField_a_of_type_JavaUtilHashSet.add("openEmbelUrl");
  }
  
  public PayBridgeActivity()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this, 2131624515);
    localDialog.setContentView(2130968842);
    TextView localTextView = (TextView)localDialog.findViewById(2131364010);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131362758);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131364013);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131364014);
    if (paramString1 != null) {
      paramString1.setText(2131432218);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  public static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    String str1 = "";
    Object localObject1 = null;
    int k = -1;
    long l1 = 0L;
    Object localObject3 = "";
    long l2 = 0L;
    Object localObject2 = null;
    if ((paramActivity != null) && ((paramActivity instanceof BasePluginActivity)))
    {
      paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      if ((paramActivity != null) && ((paramActivity instanceof BasePluginActivity))) {
        paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      }
    }
    for (;;)
    {
      int j = 1;
      if ((paramAppInterface == null) || (paramActivity == null)) {
        j = 0;
      }
      int i;
      if (paramBundle != null)
      {
        str1 = paramBundle.getString("payparmas_callback_sn");
        String str2 = paramBundle.getString("payparmas_json");
        int m = paramBundle.getInt("payparmas_paytype", -1);
        long l3 = paramBundle.getLong("payparmas_h5_start", 0L);
        String str3 = paramBundle.getString("payparmas_url_appinfo");
        long l4 = paramBundle.getLong("vacreport_key_seq", 0L);
        String str4 = paramBundle.getString("payparmas_h5_url");
        if ((m == -1) || (TextUtils.isEmpty(str2))) {
          j = 0;
        }
        i = j;
        paramBundle = str1;
        localObject1 = str2;
        k = m;
        l1 = l3;
        l2 = l4;
        localObject2 = str4;
        localObject3 = str3;
        if (paramInt != 6)
        {
          i = j;
          paramBundle = str1;
          localObject1 = str2;
          k = m;
          l1 = l3;
          l2 = l4;
          localObject2 = str4;
          localObject3 = str3;
          if (paramInt != 7)
          {
            i = j;
            paramBundle = str1;
            localObject1 = str2;
            k = m;
            l1 = l3;
            l2 = l4;
            localObject2 = str4;
            localObject3 = str3;
            if (paramInt != 8)
            {
              i = j;
              paramBundle = str1;
              localObject1 = str2;
              k = m;
              l1 = l3;
              l2 = l4;
              localObject2 = str4;
              localObject3 = str3;
              if (paramInt != 4)
              {
                i = j;
                paramBundle = str1;
                localObject1 = str2;
                k = m;
                l1 = l3;
                l2 = l4;
                localObject2 = str4;
                localObject3 = str3;
                if (paramInt != 9)
                {
                  i = j;
                  paramBundle = str1;
                  localObject1 = str2;
                  k = m;
                  l1 = l3;
                  l2 = l4;
                  localObject2 = str4;
                  localObject3 = str3;
                  if (paramInt != 14)
                  {
                    i = j;
                    paramBundle = str1;
                    localObject1 = str2;
                    k = m;
                    l1 = l3;
                    l2 = l4;
                    localObject2 = str4;
                    localObject3 = str3;
                    if (paramInt != 17)
                    {
                      i = 0;
                      localObject3 = str3;
                      localObject2 = str4;
                      l2 = l4;
                      l1 = l3;
                      k = m;
                      localObject1 = str2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (paramBundle = str1;; paramBundle = str1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity invokerId:" + paramInt + " request=" + localObject1 + ",callbackSn=" + paramBundle);
        }
        if (i != 0) {
          break;
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'System error.'}");
        return localBundle;
        i = 0;
      }
      if (paramInt == 6) {
        paramAppInterface = c(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
      }
      for (;;)
      {
        return paramAppInterface;
        if (paramInt == 7) {
          paramAppInterface = b(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
        } else if (paramInt == 8) {
          paramAppInterface = d(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
        } else if (paramInt == 4) {
          paramAppInterface = a(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
        } else if (paramInt == 9) {
          paramAppInterface = a(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, (String)localObject3, k, l1, l2, localObject2);
        } else if (paramInt == 14) {
          paramAppInterface = e(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
        } else if (paramInt == 17) {
          paramAppInterface = f(paramAppInterface, paramActivity, paramResultReceiver, paramBundle, localObject1, k, l1, l2, localObject2);
        } else {
          paramAppInterface = localBundle;
        }
      }
    }
  }
  
  protected static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str14 = ((JSONObject)localObject).getString("offerId");
        String str15 = ((JSONObject)localObject).getString("userId");
        String str16 = ((JSONObject)localObject).getString("serviceCode");
        String str17 = ((JSONObject)localObject).getString("serviceName");
        if (!((JSONObject)localObject).has("channel")) {
          break label1120;
        }
        str1 = ((JSONObject)localObject).getString("channel");
        if (!((JSONObject)localObject).has("unit")) {
          break label1126;
        }
        str2 = ((JSONObject)localObject).getString("unit");
        if (!((JSONObject)localObject).has("openMonth")) {
          break label1132;
        }
        str3 = ((JSONObject)localObject).getString("openMonth");
        if (!((JSONObject)localObject).has("isCanChange")) {
          break label1138;
        }
        bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
        if (!((JSONObject)localObject).has("remark")) {
          break label1144;
        }
        str4 = ((JSONObject)localObject).getString("remark");
        if (!((JSONObject)localObject).has("provideUin")) {
          break label1151;
        }
        str5 = ((JSONObject)localObject).getString("provideUin");
        if (!((JSONObject)localObject).has("provideType")) {
          break label1157;
        }
        str6 = ((JSONObject)localObject).getString("provideType");
        if (!((JSONObject)localObject).has("discountId")) {
          break label1163;
        }
        str7 = ((JSONObject)localObject).getString("discountId");
        if (!((JSONObject)localObject).has("other")) {
          break label1170;
        }
        str8 = ((JSONObject)localObject).getString("other");
        if (!((JSONObject)localObject).has("payload")) {
          break label1177;
        }
        str9 = ((JSONObject)localObject).getString("payload");
        if (!((JSONObject)localObject).has("autoPay")) {
          break label1184;
        }
        bool2 = ((JSONObject)localObject).getBoolean("autoPay");
        if (!((JSONObject)localObject).has("aid")) {
          break label1190;
        }
        str10 = ((JSONObject)localObject).getString("aid");
        if (!((JSONObject)localObject).has("couponId")) {
          break label1197;
        }
        str11 = ((JSONObject)localObject).getString("couponId");
        if ((((JSONObject)localObject).has("ticketName")) && (((JSONObject)localObject).has("ticketValue")))
        {
          str12 = ((JSONObject)localObject).getString("ticketName");
          str13 = ((JSONObject)localObject).getString("ticketValue");
          if (((JSONObject)localObject).has("pf"))
          {
            localObject = ((JSONObject)localObject).getString("pf");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("offerId", str14);
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", false);
            if ((str2 != null) && (str2.length() > 0)) {
              paramString2.putString("unit", str2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              paramString2.putString("payChannel", str1);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString2.putString("userId", str15);
            if (str13 != null)
            {
              paramString2.putString("sessionType", str12);
              paramString2.putString("userKey", str13);
            }
            paramString2.putString("sessionId", "uin");
            paramString2.putString("pf", (String)localObject);
            paramString2.putString("pfKey", "pfKey");
            paramString2.putString("serviceCode", str16);
            paramString2.putString("serviceName", str17);
            paramString2.putInt("resId", 0);
            if ((str3 != null) && (str3.length() > 0))
            {
              paramString2.putString("saveValue", str3);
              paramString2.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            paramString2.putString("remark", str4);
            paramString2.putString("provideUin", str5);
            paramString2.putString("provideType", str6);
            paramString2.putString("discountId", str7);
            paramString2.putString("other", str8);
            paramString2.putString("payload", str9);
            paramString2.putBoolean("autoPay", Boolean.valueOf(bool2).booleanValue());
            paramString2.putString("couponId", str11);
            paramString2.putInt("PayInvokerId", 4);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str14);
            localBundle.putString("aid", str10);
            return localBundle;
          }
          localObject = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str10;
          continue;
        }
        String str12 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'openService JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'openService Exception'}");
        return localBundle;
      }
      String str13 = null;
      continue;
      label1120:
      String str1 = null;
      continue;
      label1126:
      String str2 = null;
      continue;
      label1132:
      String str3 = null;
      continue;
      label1138:
      boolean bool1 = true;
      continue;
      label1144:
      String str4 = "";
      continue;
      label1151:
      String str5 = null;
      continue;
      label1157:
      String str6 = null;
      continue;
      label1163:
      String str7 = "";
      continue;
      label1170:
      String str8 = "";
      continue;
      label1177:
      String str9 = "";
      continue;
      label1184:
      boolean bool2 = true;
      continue;
      label1190:
      String str10 = "";
      continue;
      label1197:
      String str11 = "";
    }
  }
  
  /* Error */
  protected static Bundle a(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4)
  {
    // Byte code:
    //   0: new 147	android/os/Bundle
    //   3: dup
    //   4: invokespecial 148	android/os/Bundle:<init>	()V
    //   7: astore 24
    //   9: aload 5
    //   11: astore 17
    //   13: aload 5
    //   15: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +13 -> 31
    //   21: aload 5
    //   23: ldc_w 456
    //   26: invokestatic 462	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 17
    //   31: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +53 -> 87
    //   37: ldc 196
    //   39: iconst_2
    //   40: new 198	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   47: ldc 150
    //   49: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   55: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: ldc_w 464
    //   61: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 212
    //   71: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_3
    //   75: invokestatic 467	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 220	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 256	org/json/JSONObject
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 259	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   96: astore 26
    //   98: aload_0
    //   99: invokevirtual 472	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   102: astore 27
    //   104: aload_0
    //   105: invokevirtual 476	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   108: new 198	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   115: getstatic 482	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   118: invokevirtual 483	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   121: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 27
    //   126: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 488	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 28
    //   137: aload 26
    //   139: ldc_w 490
    //   142: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 25
    //   147: aload 26
    //   149: ldc_w 492
    //   152: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   155: ifeq +571 -> 726
    //   158: aload 26
    //   160: ldc_w 492
    //   163: invokevirtual 495	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 12
    //   168: aload 26
    //   170: ldc_w 497
    //   173: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   176: ifeq +556 -> 732
    //   179: aload 26
    //   181: ldc_w 497
    //   184: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 5
    //   189: aload 26
    //   191: ldc_w 499
    //   194: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   197: ifeq +1075 -> 1272
    //   200: aload 26
    //   202: ldc_w 499
    //   205: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 16
    //   210: aload 26
    //   212: ldc_w 501
    //   215: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   218: ifeq +1061 -> 1279
    //   221: aload 26
    //   223: ldc_w 501
    //   226: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   229: astore 18
    //   231: aload 5
    //   233: aload 17
    //   235: invokestatic 503	com/tencent/mobileqq/activity/PayBridgeActivity:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   238: astore 29
    //   240: aload 26
    //   242: ldc_w 505
    //   245: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq +1038 -> 1286
    //   251: aload 26
    //   253: ldc_w 505
    //   256: invokevirtual 262	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: astore 17
    //   261: iconst_1
    //   262: iload 6
    //   264: if_icmpne +1029 -> 1293
    //   267: aload 26
    //   269: ldc_w 507
    //   272: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   275: ifne +14 -> 289
    //   278: aload 26
    //   280: ldc_w 509
    //   283: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   286: ifeq +1007 -> 1293
    //   289: aload 26
    //   291: ldc_w 511
    //   294: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   297: istore 15
    //   299: iload 15
    //   301: ifeq +992 -> 1293
    //   304: iconst_1
    //   305: istore 15
    //   307: new 198	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   314: astore 19
    //   316: aload 19
    //   318: ldc_w 513
    //   321: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 25
    //   326: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 19
    //   332: ldc_w 515
    //   335: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: iload 12
    //   340: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 19
    //   346: ldc_w 517
    //   349: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 5
    //   354: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 19
    //   360: ldc_w 519
    //   363: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 16
    //   368: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 19
    //   374: ldc_w 521
    //   377: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 18
    //   382: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 19
    //   388: ldc_w 523
    //   391: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 26
    //   396: ldc_w 525
    //   399: invokevirtual 528	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   402: invokevirtual 531	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 11
    //   408: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   411: ifne +17 -> 428
    //   414: aload 19
    //   416: ldc_w 311
    //   419: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 11
    //   424: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: new 256	org/json/JSONObject
    //   431: dup
    //   432: aload 17
    //   434: invokespecial 259	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   437: astore 5
    //   439: aload 5
    //   441: ldc_w 533
    //   444: invokevirtual 537	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   447: pop
    //   448: aload 11
    //   450: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +14 -> 467
    //   456: aload 5
    //   458: ldc_w 533
    //   461: aload 11
    //   463: invokevirtual 541	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload 5
    //   469: invokevirtual 542	org/json/JSONObject:toString	()Ljava/lang/String;
    //   472: astore 23
    //   474: lload 9
    //   476: aload 25
    //   478: ldc_w 313
    //   481: aload 19
    //   483: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: iconst_0
    //   487: aconst_null
    //   488: invokestatic 318	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   491: ldc_w 544
    //   494: astore 5
    //   496: ldc_w 544
    //   499: astore 11
    //   501: ldc_w 544
    //   504: astore 16
    //   506: aload 16
    //   508: astore 20
    //   510: aload 11
    //   512: astore 17
    //   514: aload 5
    //   516: astore 18
    //   518: aload 16
    //   520: astore 22
    //   522: aload 11
    //   524: astore 19
    //   526: aload 5
    //   528: astore 21
    //   530: aload 29
    //   532: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: ifne +806 -> 1341
    //   538: aload 16
    //   540: astore 20
    //   542: aload 11
    //   544: astore 17
    //   546: aload 5
    //   548: astore 18
    //   550: aload 29
    //   552: ldc_w 546
    //   555: invokevirtual 550	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   558: astore 30
    //   560: iconst_0
    //   561: istore 13
    //   563: aload 16
    //   565: astore 20
    //   567: aload 11
    //   569: astore 17
    //   571: aload 5
    //   573: astore 18
    //   575: aload 16
    //   577: astore 22
    //   579: aload 11
    //   581: astore 19
    //   583: aload 5
    //   585: astore 21
    //   587: iload 13
    //   589: aload 30
    //   591: arraylength
    //   592: if_icmpge +749 -> 1341
    //   595: aload 16
    //   597: astore 20
    //   599: aload 11
    //   601: astore 17
    //   603: aload 5
    //   605: astore 18
    //   607: aload 30
    //   609: iload 13
    //   611: aaload
    //   612: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   615: ifne +642 -> 1257
    //   618: aload 16
    //   620: astore 20
    //   622: aload 11
    //   624: astore 17
    //   626: aload 5
    //   628: astore 18
    //   630: aload 30
    //   632: iload 13
    //   634: aaload
    //   635: bipush 35
    //   637: invokevirtual 554	java/lang/String:indexOf	(I)I
    //   640: istore 14
    //   642: iload 14
    //   644: iconst_m1
    //   645: if_icmpeq +612 -> 1257
    //   648: aload 16
    //   650: astore 20
    //   652: aload 11
    //   654: astore 17
    //   656: aload 5
    //   658: astore 18
    //   660: aload 30
    //   662: iload 13
    //   664: aaload
    //   665: iload 14
    //   667: iconst_1
    //   668: iadd
    //   669: invokevirtual 558	java/lang/String:substring	(I)Ljava/lang/String;
    //   672: astore 19
    //   674: aload 19
    //   676: astore 17
    //   678: iload 13
    //   680: ifne +619 -> 1299
    //   683: aload 11
    //   685: astore 5
    //   687: aload 17
    //   689: astore 11
    //   691: iload 13
    //   693: iconst_1
    //   694: iadd
    //   695: istore 13
    //   697: aload 11
    //   699: astore 17
    //   701: aload 5
    //   703: astore 11
    //   705: aload 17
    //   707: astore 5
    //   709: goto -146 -> 563
    //   712: astore 16
    //   714: aload 16
    //   716: invokevirtual 559	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   719: aload 5
    //   721: astore 17
    //   723: goto -692 -> 31
    //   726: iconst_1
    //   727: istore 12
    //   729: goto -561 -> 168
    //   732: ldc 150
    //   734: astore 5
    //   736: goto -547 -> 189
    //   739: astore 19
    //   741: aload 19
    //   743: invokevirtual 450	java/lang/Exception:printStackTrace	()V
    //   746: iconst_0
    //   747: istore 15
    //   749: goto -442 -> 307
    //   752: astore 5
    //   754: new 256	org/json/JSONObject
    //   757: dup
    //   758: invokespecial 560	org/json/JSONObject:<init>	()V
    //   761: astore 5
    //   763: aload 11
    //   765: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   768: ifne +14 -> 782
    //   771: aload 5
    //   773: ldc_w 533
    //   776: aload 11
    //   778: invokevirtual 541	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 5
    //   784: invokevirtual 542	org/json/JSONObject:toString	()Ljava/lang/String;
    //   787: astore 23
    //   789: goto -315 -> 474
    //   792: new 147	android/os/Bundle
    //   795: dup
    //   796: invokespecial 148	android/os/Bundle:<init>	()V
    //   799: astore 16
    //   801: aload 16
    //   803: ldc_w 338
    //   806: aload_3
    //   807: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: aload 16
    //   812: ldc_w 490
    //   815: aload 25
    //   817: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload 16
    //   822: ldc_w 264
    //   825: aload 27
    //   827: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 16
    //   832: ldc_w 562
    //   835: aload 28
    //   837: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload 16
    //   842: ldc_w 492
    //   845: iload 12
    //   847: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   850: aload 16
    //   852: ldc_w 497
    //   855: aload 29
    //   857: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 16
    //   862: ldc_w 505
    //   865: aload 23
    //   867: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 16
    //   872: ldc_w 525
    //   875: aload 26
    //   877: ldc_w 525
    //   880: invokevirtual 528	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   883: invokevirtual 328	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   886: aload 16
    //   888: ldc_w 363
    //   891: bipush 9
    //   893: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   896: aload 16
    //   898: ldc 166
    //   900: iload 6
    //   902: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   905: aload 16
    //   907: ldc 172
    //   909: lload 7
    //   911: invokevirtual 367	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   914: aload 16
    //   916: ldc 180
    //   918: lload 9
    //   920: invokevirtual 367	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   923: aload 16
    //   925: ldc_w 564
    //   928: iload 15
    //   930: invokevirtual 328	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   933: iload 15
    //   935: ifeq +13 -> 948
    //   938: aload 16
    //   940: ldc_w 566
    //   943: aload 4
    //   945: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   948: aload_2
    //   949: ifnull +44 -> 993
    //   952: invokestatic 373	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   955: astore_3
    //   956: aload_2
    //   957: aload_3
    //   958: iconst_0
    //   959: invokevirtual 379	android/os/ResultReceiver:writeToParcel	(Landroid/os/Parcel;I)V
    //   962: aload_3
    //   963: iconst_0
    //   964: invokevirtual 382	android/os/Parcel:setDataPosition	(I)V
    //   967: getstatic 386	android/os/ResultReceiver:CREATOR	Landroid/os/Parcelable$Creator;
    //   970: aload_3
    //   971: invokeinterface 392 2 0
    //   976: checkcast 375	android/os/ResultReceiver
    //   979: astore_2
    //   980: aload_3
    //   981: invokevirtual 395	android/os/Parcel:recycle	()V
    //   984: aload 16
    //   986: ldc_w 397
    //   989: aload_2
    //   990: invokevirtual 401	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   993: lload 9
    //   995: aconst_null
    //   996: ldc_w 403
    //   999: aconst_null
    //   1000: iconst_0
    //   1001: aconst_null
    //   1002: invokestatic 318	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1005: invokestatic 406	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1008: ifeq +32 -> 1040
    //   1011: ldc_w 408
    //   1014: iconst_4
    //   1015: new 198	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1022: ldc_w 410
    //   1025: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokestatic 416	java/lang/System:currentTimeMillis	()J
    //   1031: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 421	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: aload_1
    //   1041: aload_0
    //   1042: aload 16
    //   1044: invokestatic 427	cooperation/qwallet/plugin/QWalletPayBridge:launchService	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Landroid/os/Bundle;)Z
    //   1047: pop
    //   1048: aload 24
    //   1050: ldc 222
    //   1052: iconst_0
    //   1053: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1056: aload 24
    //   1058: ldc_w 568
    //   1061: aload 25
    //   1063: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1066: aload 24
    //   1068: ldc_w 570
    //   1071: aload 11
    //   1073: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload 24
    //   1078: ldc_w 270
    //   1081: aload 17
    //   1083: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: aload 24
    //   1088: ldc_w 572
    //   1091: aload 5
    //   1093: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1096: aload 24
    //   1098: areturn
    //   1099: astore 11
    //   1101: aload 20
    //   1103: astore 5
    //   1105: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1108: ifeq +8 -> 1116
    //   1111: aload 11
    //   1113: invokevirtual 450	java/lang/Exception:printStackTrace	()V
    //   1116: aload 18
    //   1118: astore 11
    //   1120: goto -328 -> 792
    //   1123: astore_0
    //   1124: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1127: ifeq +32 -> 1159
    //   1130: ldc 196
    //   1132: iconst_2
    //   1133: new 198	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1140: ldc_w 574
    //   1143: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload_0
    //   1147: invokevirtual 439	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1150: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 441	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: invokestatic 406	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1162: ifeq +7 -> 1169
    //   1165: aload_0
    //   1166: invokevirtual 444	org/json/JSONException:printStackTrace	()V
    //   1169: aload 24
    //   1171: ldc 222
    //   1173: iconst_m1
    //   1174: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1177: aload 24
    //   1179: ldc 228
    //   1181: ldc_w 576
    //   1184: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1187: aload 24
    //   1189: areturn
    //   1190: astore_0
    //   1191: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +32 -> 1226
    //   1197: ldc 196
    //   1199: iconst_2
    //   1200: new 198	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   1207: ldc_w 578
    //   1210: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: aload_0
    //   1214: invokevirtual 449	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1217: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 441	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: invokestatic 406	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1229: ifeq +7 -> 1236
    //   1232: aload_0
    //   1233: invokevirtual 450	java/lang/Exception:printStackTrace	()V
    //   1236: aload 24
    //   1238: ldc 222
    //   1240: iconst_m1
    //   1241: invokevirtual 226	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1244: aload 24
    //   1246: ldc 228
    //   1248: ldc_w 580
    //   1251: invokevirtual 234	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1254: aload 24
    //   1256: areturn
    //   1257: aload 5
    //   1259: astore 17
    //   1261: aload 11
    //   1263: astore 5
    //   1265: aload 17
    //   1267: astore 11
    //   1269: goto -578 -> 691
    //   1272: ldc 150
    //   1274: astore 16
    //   1276: goto -1066 -> 210
    //   1279: ldc 150
    //   1281: astore 18
    //   1283: goto -1052 -> 231
    //   1286: ldc 150
    //   1288: astore 17
    //   1290: goto -1029 -> 261
    //   1293: iconst_0
    //   1294: istore 15
    //   1296: goto -989 -> 307
    //   1299: iload 13
    //   1301: iconst_1
    //   1302: if_icmpne +22 -> 1324
    //   1305: aload 17
    //   1307: astore 16
    //   1309: aload 5
    //   1311: astore 17
    //   1313: aload 11
    //   1315: astore 5
    //   1317: aload 17
    //   1319: astore 11
    //   1321: goto -630 -> 691
    //   1324: iload 13
    //   1326: iconst_2
    //   1327: if_icmpne -70 -> 1257
    //   1330: aload 5
    //   1332: astore 11
    //   1334: aload 17
    //   1336: astore 5
    //   1338: goto -647 -> 691
    //   1341: aload 22
    //   1343: astore 5
    //   1345: aload 21
    //   1347: astore 11
    //   1349: aload 19
    //   1351: astore 17
    //   1353: goto -561 -> 792
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1356	0	paramAppInterface	AppInterface
    //   0	1356	1	paramActivity	Activity
    //   0	1356	2	paramResultReceiver	ResultReceiver
    //   0	1356	3	paramString1	String
    //   0	1356	4	paramString2	String
    //   0	1356	5	paramString3	String
    //   0	1356	6	paramInt	int
    //   0	1356	7	paramLong1	long
    //   0	1356	9	paramLong2	long
    //   0	1356	11	paramString4	String
    //   166	680	12	i	int
    //   561	767	13	j	int
    //   640	29	14	k	int
    //   297	998	15	bool	boolean
    //   208	441	16	str1	String
    //   712	3	16	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   799	509	16	localObject1	Object
    //   11	1341	17	localObject2	Object
    //   229	1053	18	str2	String
    //   314	361	19	localObject3	Object
    //   739	611	19	localException	Exception
    //   508	594	20	str3	String
    //   528	818	21	str4	String
    //   520	822	22	str5	String
    //   472	394	23	str6	String
    //   7	1248	24	localBundle	Bundle
    //   145	917	25	str7	String
    //   96	780	26	localJSONObject	JSONObject
    //   102	724	27	str8	String
    //   135	701	28	str9	String
    //   238	618	29	str10	String
    //   558	103	30	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   21	31	712	java/io/UnsupportedEncodingException
    //   267	289	739	java/lang/Exception
    //   289	299	739	java/lang/Exception
    //   428	467	752	java/lang/Exception
    //   467	474	752	java/lang/Exception
    //   530	538	1099	java/lang/Exception
    //   550	560	1099	java/lang/Exception
    //   587	595	1099	java/lang/Exception
    //   607	618	1099	java/lang/Exception
    //   630	642	1099	java/lang/Exception
    //   660	674	1099	java/lang/Exception
    //   87	168	1123	org/json/JSONException
    //   168	189	1123	org/json/JSONException
    //   189	210	1123	org/json/JSONException
    //   210	231	1123	org/json/JSONException
    //   231	261	1123	org/json/JSONException
    //   267	289	1123	org/json/JSONException
    //   289	299	1123	org/json/JSONException
    //   307	428	1123	org/json/JSONException
    //   428	467	1123	org/json/JSONException
    //   467	474	1123	org/json/JSONException
    //   474	491	1123	org/json/JSONException
    //   530	538	1123	org/json/JSONException
    //   550	560	1123	org/json/JSONException
    //   587	595	1123	org/json/JSONException
    //   607	618	1123	org/json/JSONException
    //   630	642	1123	org/json/JSONException
    //   660	674	1123	org/json/JSONException
    //   741	746	1123	org/json/JSONException
    //   754	782	1123	org/json/JSONException
    //   782	789	1123	org/json/JSONException
    //   792	933	1123	org/json/JSONException
    //   938	948	1123	org/json/JSONException
    //   952	993	1123	org/json/JSONException
    //   993	1040	1123	org/json/JSONException
    //   1040	1096	1123	org/json/JSONException
    //   1105	1116	1123	org/json/JSONException
    //   87	168	1190	java/lang/Exception
    //   168	189	1190	java/lang/Exception
    //   189	210	1190	java/lang/Exception
    //   210	231	1190	java/lang/Exception
    //   231	261	1190	java/lang/Exception
    //   307	428	1190	java/lang/Exception
    //   474	491	1190	java/lang/Exception
    //   741	746	1190	java/lang/Exception
    //   754	782	1190	java/lang/Exception
    //   782	789	1190	java/lang/Exception
    //   792	933	1190	java/lang/Exception
    //   938	948	1190	java/lang/Exception
    //   952	993	1190	java/lang/Exception
    //   993	1040	1190	java/lang/Exception
    //   1040	1096	1190	java/lang/Exception
    //   1105	1116	1190	java/lang/Exception
  }
  
  private String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('-');
    if (i != -1) {
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    Object localObject1 = "";
    String str5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    String str3 = "";
    String str2 = "";
    int j = paramString1.lastIndexOf("|channel#");
    Object localObject3 = localObject4;
    String str1 = str5;
    String str4;
    int i;
    if (j != -1)
    {
      str4 = paramString1.substring("|channel#".length() + j);
      i = paramString1.indexOf("|bargainor_id#");
      localObject3 = localObject4;
      str1 = str5;
      localObject1 = str4;
      if (i != -1)
      {
        str5 = paramString1.substring("|bargainor_id#".length() + i, j);
        j = paramString1.indexOf("appid#");
        localObject3 = localObject4;
        str1 = str5;
        localObject1 = str4;
        if (j != -1)
        {
          localObject3 = paramString1.substring("appid#".length() + j, i);
          localObject1 = str4;
          str1 = str5;
        }
      }
    }
    j = paramString2.lastIndexOf("|channel#");
    localObject4 = str2;
    paramString1 = str3;
    if (j != -1)
    {
      str4 = paramString2.substring("|channel#".length() + j);
      i = paramString2.indexOf("|bargainor_id#");
      localObject4 = str2;
      paramString1 = str3;
      localObject2 = str4;
      if (i != -1)
      {
        str3 = paramString2.substring("|bargainor_id#".length() + i, j);
        j = paramString2.indexOf("appid#");
        localObject4 = str2;
        paramString1 = str3;
        localObject2 = str4;
        if (j != -1)
        {
          localObject4 = paramString2.substring("appid#".length() + j, i);
          localObject2 = str4;
          paramString1 = str3;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramString2 = "appid#" + (String)localObject4;
      paramString2 = paramString2 + "|bargainor_id#";
      if (!TextUtils.isEmpty(str1)) {
        break label438;
      }
      paramString1 = paramString2 + paramString1;
      label362:
      paramString1 = paramString1 + "|channel#";
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label494;
      }
    }
    label438:
    label494:
    for (paramString1 = paramString1 + (String)localObject2;; paramString1 = paramString1 + (String)localObject1)
    {
      return paramString1;
      paramString2 = "appid#" + (String)localObject3;
      break;
      if (str1.compareTo("0") == 0)
      {
        paramString1 = paramString2 + paramString1;
        break label362;
      }
      paramString1 = paramString2 + str1;
      break label362;
    }
  }
  
  private void a()
  {
    if (getIntent() == null) {
      return;
    }
    Object localObject1 = getIntent().getStringExtra("title");
    Object localObject2 = getIntent().getStringExtra("content");
    String str1 = getIntent().getStringExtra("btn");
    String str2 = getIntent().getStringExtra("url");
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0);
    localQQCustomDialog.setTitle((String)localObject1);
    localQQCustomDialog.setMessage((CharSequence)localObject2);
    localQQCustomDialog.setCancelable(false);
    localObject2 = new tbr(this, str2);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = getResources().getString(2131432999);
    }
    localQQCustomDialog.setPositiveButton((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    localQQCustomDialog.show();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentIntent == null))
    {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("callbackSn");
    String str2 = paramBundle.getString("json");
    String str3 = paramBundle.getString("payparmas_url_appinfo");
    if ((this.jdField_b_of_type_Long == 0L) && ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 2)))
    {
      String str4 = a(paramInt);
      if (str4 != null)
      {
        this.jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", str4, "payinvoke", null, 0, null);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if (paramInt == 4) {
      paramBundle = a(this.app, this, null, str1, str2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("retCode", -1) == 0) {
          break label369;
        }
        paramBundle = paramBundle.getString("retJson");
        if (paramBundle != null) {
          a(str1, paramBundle);
        }
        if (this.jdField_b_of_type_Long != 0L) {
          VACDReportUtil.endReport(this.jdField_b_of_type_Long, "parseurl", null, 668801, paramBundle);
        }
      }
      return;
      if (paramInt == 6)
      {
        paramBundle = c(this.app, this, null, str1, str2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
      }
      else if (paramInt == 7)
      {
        paramBundle = b(this.app, this, null, str1, str2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
      }
      else if (paramInt == 8)
      {
        paramBundle = d(this.app, this, null, str1, str2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
      }
      else if (paramInt == 9)
      {
        paramBundle = (ResultReceiver)paramBundle.getParcelable("_qwallet_payresult_receiver");
        paramBundle = a(this.app, this, paramBundle, str1, str2, str3, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
      }
      else if (paramInt == 14)
      {
        paramBundle = e(this.app, this, null, str1, str2, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, null);
        continue;
        label369:
        if (paramInt == 9)
        {
          this.jdField_a_of_type_JavaLangString = paramBundle.getString("token");
          this.jdField_b_of_type_JavaLangString = paramBundle.getString("appid");
          this.jdField_c_of_type_JavaLangString = paramBundle.getString("channel");
          this.jdField_d_of_type_JavaLangString = paramBundle.getString("bargainor");
          return;
        }
        this.jdField_e_of_type_JavaLangString = paramBundle.getString("offerId");
        this.f = paramBundle.getString("aid");
        this.g = paramBundle.getString("orderId");
      }
      else
      {
        paramBundle = null;
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    setResult(paramInt1, paramString);
    a(paramInt1, paramString);
    finish();
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString2);
    localIntent.putExtras(localBundle);
    setResult(paramInt1, localIntent);
    a(paramInt1, localIntent);
    finish();
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putString("msg", paramString2);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString1 = new Intent();
    paramString1.putExtras(localBundle);
    setResult(paramInt1, paramString1);
    a(paramInt1, paramString1);
    finish();
  }
  
  private void a(Intent paramIntent)
  {
    setResult(-1, paramIntent);
    finish();
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool2 = false;
    if (1 == this.jdField_a_of_type_Int) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramBundle.getString("json")).optJSONObject("extra_data");
      if (localJSONObject != null)
      {
        boolean bool1;
        if (!localJSONObject.has("pskey"))
        {
          bool1 = bool2;
          if (!localJSONObject.has("p_skey_forbid")) {}
        }
        else
        {
          bool1 = bool2;
          if (localJSONObject.has("banned_user_buff")) {
            bool1 = true;
          }
        }
        this.jdField_e_of_type_Boolean = bool1;
        if (this.jdField_e_of_type_Boolean) {
          paramBundle.putBoolean("payparmas_from_is_login_state", false);
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay", 2, "isLockWithdraw = " + this.jdField_e_of_type_Boolean);
    }
  }
  
  private void a(QWalletPushManager.PCPayData paramPCPayData)
  {
    if (paramPCPayData == null)
    {
      finish();
      return;
    }
    paramPCPayData.jdField_c_of_type_Int = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramPCPayData.jdField_a_of_type_JavaLangString);
    localBundle.putString("callbackSn", "0");
    int i = QWalletPushManager.a(paramPCPayData.jdField_b_of_type_Int);
    switch (i)
    {
    case 10: 
    case 12: 
    case 13: 
    default: 
      finish();
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 14: 
      a(i, localBundle);
      return;
    case 11: 
      g(localBundle);
      return;
    }
    localBundle = getIntent().getExtras();
    localBundle.putString("json", paramPCPayData.jdField_a_of_type_JavaLangString);
    localBundle.putString("callbackSn", "0");
    e(localBundle);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData = paramEmojiPayReqData;
    this.jdField_e_of_type_JavaLangString = paramEmojiPayReqData.jdField_b_of_type_JavaLangString;
    this.f = a(paramEmojiPayReqData.h);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", paramEmojiPayReqData.jdField_b_of_type_JavaLangString);
    localBundle.putBoolean("isShowNum", false);
    localBundle.putString("userId", paramEmojiPayReqData.jdField_c_of_type_JavaLangString);
    localBundle.putString("userKey", paramEmojiPayReqData.jdField_d_of_type_JavaLangString);
    localBundle.putString("sessionId", paramEmojiPayReqData.jdField_e_of_type_JavaLangString);
    localBundle.putString("sessionType", paramEmojiPayReqData.f);
    localBundle.putString("zoneId", paramEmojiPayReqData.g);
    localBundle.putString("pf", paramEmojiPayReqData.h);
    localBundle.putString("pfKey", paramEmojiPayReqData.i);
    localBundle.putString("tokenUrl", paramEmojiPayReqData.j);
    localBundle.putInt("resId", 2130838901);
    localBundle.putString("discountId", paramEmojiPayReqData.k);
    localBundle.putString("other", paramEmojiPayReqData.l);
    localBundle.putString("payload", paramEmojiPayReqData.m);
    localBundle.putInt("PayInvokerId", 1);
    localBundle.putInt("payparmas_paytype", this.jdField_a_of_type_Int);
    QWalletPayBridge.launchService(this, this.app, localBundle);
  }
  
  private void a(DataFactory.EmojiPayReqData paramEmojiPayReqData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramEmojiPayReqData == null)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new DataFactory.EmojiPayRespData(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramEmojiPayReqData.a());
    localIntent.putExtras(paramString.a());
    setResult(-1, localIntent);
    a(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackSn", paramString1);
    localBundle.putString("result", paramString2);
    d(localBundle);
  }
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpay startActivity and request=" + paramBundle.toString() + ",requestCode=" + paramInt);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "startEmojimallPaycallbackid:" + paramString1 + "appid:" + paramString2 + "userId:" + paramString3 + "userKey:" + paramString4 + "zoneId:" + paramString5 + "pf:" + paramString6 + "pfKey:" + paramString7 + "tokenUrl:" + paramString8);
    }
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString8))) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(new DataFactory.EmojiPayReqData(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8).a());
    localIntent.putExtra("pay_requestcode", 1);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramActivity.startActivityForResult(localIntent, 1);
    return true;
  }
  
  private boolean a(DataFactory.EmojiPayReqData paramEmojiPayReqData)
  {
    return (paramEmojiPayReqData != null) && (!TextUtils.isEmpty(paramEmojiPayReqData.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramEmojiPayReqData.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramEmojiPayReqData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramEmojiPayReqData.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramEmojiPayReqData.j));
  }
  
  protected static Bundle b(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str6 = ((JSONObject)localObject).getString("offerId");
        String str8 = ((JSONObject)localObject).getString("userId");
        String str7 = ((JSONObject)localObject).getString("tokenUrl");
        if (((JSONObject)localObject).has("zoneId"))
        {
          str1 = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label810;
          }
          bool = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("unit")) {
            break label816;
          }
          str3 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("aid")) {
            break label822;
          }
          str2 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("discountId")) {
            break label829;
          }
          str4 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label836;
          }
          str5 = ((JSONObject)localObject).getString("other");
          if (((JSONObject)localObject).has("payload"))
          {
            localObject = ((JSONObject)localObject).getString("payload");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("offerId", str6);
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", false);
            paramString2.putBoolean("isShowNum", Boolean.valueOf(bool).booleanValue());
            if ((str3 != null) && (str3.length() > 0)) {
              paramString2.putString("unit", str3);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str2;
            paramString2.putString("userId", str8);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("zoneId", str1);
            paramString2.putString("pf", paramString1);
            paramString2.putString("pfKey", "pfKey");
            paramString2.putString("tokenUrl", str7);
            paramString2.putInt("resId", 0);
            paramString2.putString("discountId", str4);
            paramString2.putString("other", str5);
            paramString2.putString("payload", (String)localObject);
            paramString2.putInt("PayInvokerId", 7);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str6);
            localBundle.putString("aid", str2);
            localBundle.putString("orderId", str7);
            return localBundle;
          }
          localObject = "";
          continue;
        }
        String str1 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "buyGoods JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
        paramAppInterface.printStackTrace();
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "buyGoods Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods Exception'}");
        return localBundle;
      }
      continue;
      label810:
      boolean bool = true;
      continue;
      label816:
      String str3 = null;
      continue;
      label822:
      String str2 = "";
      continue;
      label829:
      String str4 = "";
      continue;
      label836:
      String str5 = "";
    }
  }
  
  private String b()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void b()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 231, null, getResources().getString(2131432258), getResources().getString(2131432257), null, null, new tbs(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) != 1) {
      paramIntent.putExtra("result", a());
    }
    d(paramIntent.getExtras());
  }
  
  private void b(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("discountId");
    String str5 = paramBundle.getString("other");
    String str6 = paramBundle.getString("payload");
    String str7 = paramBundle.getString("saveValue");
    boolean bool = paramBundle.getBoolean("isCanChange", true);
    this.jdField_e_of_type_JavaLangString = str1;
    this.f = a(str3);
    paramBundle = new Bundle();
    paramBundle.putString("setEnv", "release");
    paramBundle.putBoolean("setLogEnable", false);
    paramBundle.putString("offerId", str1);
    paramBundle.putString("userId", str2);
    paramBundle.putString("sessionId", "uin");
    paramBundle.putString("zoneId", "1");
    paramBundle.putString("pf", str3);
    paramBundle.putString("pfKey", "pfKey");
    paramBundle.putString("acctType", "common");
    paramBundle.putInt("resId", 2130843729);
    paramBundle.putString("discountId", str4);
    paramBundle.putString("other", str5);
    paramBundle.putString("payload", str6);
    paramBundle.putInt("PayInvokerId", 2);
    paramBundle.putInt("payparmas_paytype", this.jdField_a_of_type_Int);
    if ((str7 != null) && (str7.trim().length() > 0))
    {
      paramBundle.putString("saveValue", str7);
      paramBundle.putBoolean("isCanChange", bool);
    }
    QWalletPayBridge.launchService(this, this.app, paramBundle);
  }
  
  protected static Bundle c(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str7 = ((JSONObject)localObject).getString("offerId");
        String str8 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("zoneId"))
        {
          str1 = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("acctType")) {
            break label844;
          }
          str2 = ((JSONObject)localObject).getString("acctType");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label852;
          }
          bool1 = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label858;
          }
          str3 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label864;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("aid")) {
            break label870;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("discountId")) {
            break label877;
          }
          str5 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label884;
          }
          str6 = ((JSONObject)localObject).getString("other");
          if (((JSONObject)localObject).has("payload"))
          {
            localObject = ((JSONObject)localObject).getString("payload");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("offerId", str7);
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", true);
            paramString2.putBoolean("isShowNum", Boolean.valueOf(bool1).booleanValue());
            paramString2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str4;
            paramString2.putString("userId", str8);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("zoneId", str1);
            paramString2.putString("pf", paramString1);
            paramString2.putString("pfKey", "pfKey");
            paramString2.putString("acctType", str2);
            paramString2.putString("discountId", str5);
            paramString2.putString("other", str6);
            paramString2.putString("payload", (String)localObject);
            if ((str3 != null) && (str3.length() > 0))
            {
              paramString2.putString("saveValue", str3);
              paramString2.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            paramString2.putInt("resId", 0);
            paramString2.putInt("PayInvokerId", 6);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str7);
            localBundle.putString("aid", str4);
            return localBundle;
          }
          localObject = "";
          continue;
        }
        String str1 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeCurrency Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle;
      }
      continue;
      label844:
      String str2 = "common";
      continue;
      label852:
      boolean bool1 = true;
      continue;
      label858:
      String str3 = null;
      continue;
      label864:
      boolean bool2 = true;
      continue;
      label870:
      String str4 = "";
      continue;
      label877:
      String str5 = "";
      continue;
      label884:
      String str6 = "";
    }
  }
  
  private void c(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.jdField_b_of_type_Boolean) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData != null))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, j, k, m, n, i1, str);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqEmosmDataFactory$EmojiPayReqData, -1, -1, -1, -1, -1, "");
  }
  
  private void c(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("provideUin");
    String str5 = paramBundle.getString("provideType");
    String str6 = paramBundle.getString("discountId");
    String str7 = paramBundle.getString("other");
    paramBundle = paramBundle.getString("payload");
    this.jdField_e_of_type_JavaLangString = str1;
    this.f = a(str3);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", str1);
    localBundle.putString("userId", str2);
    localBundle.putString("sessionId", "uin");
    localBundle.putString("pf", str3);
    localBundle.putString("pfKey", "pfKey");
    localBundle.putString("serviceCode", "QQYFSC");
    localBundle.putString("serviceName", "腾讯文学包月VIP");
    localBundle.putInt("resId", 2130843729);
    localBundle.putString("saveValue", "3");
    localBundle.putBoolean("isCanChange", true);
    localBundle.putString("remark", "");
    localBundle.putString("provideUin", str4);
    localBundle.putString("provideType", str5);
    localBundle.putString("discountId", str6);
    localBundle.putString("other", str7);
    localBundle.putString("payload", paramBundle);
    localBundle.putInt("PayInvokerId", 3);
    localBundle.putInt("payparmas_paytype", this.jdField_a_of_type_Int);
    QWalletPayBridge.launchService(this, this.app, localBundle);
  }
  
  protected static Bundle d(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str9 = ((JSONObject)localObject).getString("offerId");
        String str10 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("channel"))
        {
          str1 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label834;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label840;
          }
          str3 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("aid")) {
            break label846;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("provideUin")) {
            break label853;
          }
          str5 = ((JSONObject)localObject).getString("provideUin");
          if (!((JSONObject)localObject).has("provideType")) {
            break label859;
          }
          str6 = ((JSONObject)localObject).getString("provideType");
          if (!((JSONObject)localObject).has("discountId")) {
            break label865;
          }
          str7 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label872;
          }
          str8 = ((JSONObject)localObject).getString("other");
          if (((JSONObject)localObject).has("payload"))
          {
            localObject = ((JSONObject)localObject).getString("payload");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("offerId", str9);
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", true);
            if ((str2 != null) && (str2.length() > 0)) {
              paramString2.putString("unit", str2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              paramString2.putString("payChannel", str1);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str4;
            paramString2.putString("userId", str10);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("pf", paramString1);
            paramString2.putString("pfKey", "pfKey");
            paramString2.putString("saveValue", str3);
            paramString2.putString("provideUin", str5);
            paramString2.putString("provideType", str6);
            paramString2.putString("discountId", str7);
            paramString2.putString("other", str8);
            paramString2.putString("payload", (String)localObject);
            paramString2.putInt("PayInvokerId", 8);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str9);
            localBundle.putString("aid", str4);
            return localBundle;
          }
          localObject = "";
          continue;
        }
        String str1 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "rechargeQb Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle;
      }
      continue;
      label834:
      String str2 = null;
      continue;
      label840:
      String str3 = null;
      continue;
      label846:
      String str4 = "";
      continue;
      label853:
      String str5 = null;
      continue;
      label859:
      String str6 = null;
      continue;
      label865:
      String str7 = "";
      continue;
      label872:
      String str8 = "";
    }
  }
  
  private void d(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.jdField_b_of_type_Boolean) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      a(j, str1, k, m, n, i1, str2);
      return;
    }
    a(-1, "", -1, -1, -1, -1, "");
  }
  
  private void d(Bundle paramBundle)
  {
    String str2 = null;
    String str1;
    if (paramBundle != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        int i = paramBundle.getInt("payRetCode", -1);
        long l = paramBundle.getLong("reportSeq", 0L);
        if ((this.jdField_b_of_type_Boolean) && (l > 0L)) {
          VACDReportUtil.endReport(l, "payEnd", null, i, null);
        }
      }
      str1 = paramBundle.getString("callbackSn");
      str2 = paramBundle.getString("result");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.payPayBridgeActivity", 2, "get callbackSn = " + str1);
      }
      String str3 = str1;
      if (TextUtils.isEmpty(str1)) {
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("callbackSn");
      }
      if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.payPayBridgeActivity", 2, "receiver back : " + paramBundle);
        }
        this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramBundle);
      }
      paramBundle = new Intent();
      paramBundle.putExtra("result", str2);
      paramBundle.putExtra("callbackSn", str3);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity tenpayResult:callbackSn=" + str3 + ",result=" + str2);
      }
      setResult(-1, paramBundle);
      a(-1, paramBundle);
      finish();
      return;
      str1 = null;
    }
  }
  
  protected static Bundle e(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str10 = ((JSONObject)localObject).getString("offerId");
        if (((JSONObject)localObject).has("isShowNum"))
        {
          bool1 = ((JSONObject)localObject).getBoolean("isShowNum");
          if (!((JSONObject)localObject).has("unit")) {
            break label1020;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          String str11 = ((JSONObject)localObject).getString("userId");
          String str12 = ((JSONObject)localObject).getString("serviceCode");
          String str13 = ((JSONObject)localObject).getString("serviceName");
          if (!((JSONObject)localObject).has("channel")) {
            break label1026;
          }
          str2 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label1032;
          }
          str3 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1038;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("remark")) {
            break label1044;
          }
          str4 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("autoPay")) {
            break label1051;
          }
          bool3 = ((JSONObject)localObject).getBoolean("autoPay");
          if (!((JSONObject)localObject).has("aid")) {
            break label1057;
          }
          str5 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("productId")) {
            break label1064;
          }
          str6 = ((JSONObject)localObject).getString("productId");
          if (!((JSONObject)localObject).has("couponId")) {
            break label1071;
          }
          str7 = ((JSONObject)localObject).getString("couponId");
          if (!((JSONObject)localObject).has("other")) {
            break label1078;
          }
          str8 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("payload")) {
            break label1085;
          }
          str9 = ((JSONObject)localObject).getString("payload");
          if (((JSONObject)localObject).has("pf"))
          {
            localObject = ((JSONObject)localObject).getString("pf");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", false);
            paramString2.putString("offerId", str10);
            paramString2.putBoolean("isShowNum", bool1);
            if ((str1 != null) && (str1.length() > 0)) {
              paramString2.putString("unit", str1);
            }
            if ((str2 != null) && (str2.length() > 0)) {
              paramString2.putString("payChannel", str2);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString2.putString("userId", str11);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("pf", (String)localObject);
            paramString2.putString("pfKey", "pfKey");
            if ((str3 != null) && (str3.length() > 0))
            {
              paramString2.putString("saveValue", str3);
              paramString2.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            paramString2.putInt("resId", 0);
            paramString2.putString("serviceCode", str12);
            paramString2.putString("serviceName", str13);
            paramString2.putString("remark", str4);
            paramString2.putBoolean("autoPay", Boolean.valueOf(bool3).booleanValue());
            paramString2.putString("productId", str6);
            paramString2.putString("couponId", str7);
            paramString2.putString("other", str8);
            paramString2.putString("payload", str9);
            paramString2.putInt("PayInvokerId", 14);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            if (paramResultReceiver != null)
            {
              paramString1 = Parcel.obtain();
              paramResultReceiver.writeToParcel(paramString1, 0);
              paramString1.setDataPosition(0);
              paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
              paramString1.recycle();
              paramString2.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
            }
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str10);
            localBundle.putString("aid", str5);
            return localBundle;
          }
          localObject = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str5;
          continue;
        }
        boolean bool1 = true;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "subscribeMonthCardPay JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "subscribeMonthCardPay Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay Exception'}");
        return localBundle;
      }
      continue;
      label1020:
      String str1 = null;
      continue;
      label1026:
      String str2 = null;
      continue;
      label1032:
      String str3 = null;
      continue;
      label1038:
      boolean bool2 = false;
      continue;
      label1044:
      String str4 = "";
      continue;
      label1051:
      boolean bool3 = true;
      continue;
      label1057:
      String str5 = "";
      continue;
      label1064:
      String str6 = "";
      continue;
      label1071:
      String str7 = "";
      continue;
      label1078:
      String str8 = "";
      continue;
      label1085:
      String str9 = "";
    }
  }
  
  private void e(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.jdField_b_of_type_Boolean) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      a(j, str1, k, m, n, i1, str2);
      return;
    }
    a(-1, "", -1, -1, -1, -1, "");
  }
  
  private void e(Bundle paramBundle)
  {
    int i = 1;
    String str2 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openTenpayView request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str2));
    }
    JSONObject localJSONObject;
    Object localObject1;
    String str3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramBundle.getString("json"));
        localObject2 = localJSONObject.optString("userId");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("0")) {}
        }
        else
        {
          localObject1 = this.app.c();
        }
        str3 = localJSONObject.getString("viewTag");
        if (QLog.isColorLevel()) {
          QLog.i(str3, 2, "openTenpayView json = " + localJSONObject);
        }
        if ((str3 == null) || (!jdField_a_of_type_JavaUtilHashSet.contains(str3)))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str3, 2, "openTenpayView viewTag is not allow");
          }
          a(str2, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
          return;
        }
        if (("transfer".compareTo(str3) != 0) && ("transferInput".compareTo(str3) != 0)) {
          break;
        }
        localObject1 = new Intent(this, TransactionActivity.class);
        ((Intent)localObject1).putExtra("callbackSn", str2);
        ((Intent)localObject1).putExtra("come_from", 1);
        ((Intent)localObject1).putExtra("tag", str3);
        if (localJSONObject.has("appInfo"))
        {
          paramBundle = localJSONObject.getString("appInfo");
          ((Intent)localObject1).putExtra("app_info", paramBundle);
          if (!localJSONObject.has("extra_data")) {
            break label1313;
          }
          paramBundle = localJSONObject.getString("extra_data");
          ((Intent)localObject1).putExtra("extra_data", paramBundle);
          ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "is_H5=true", 0, null));
          startActivityForResult((Intent)localObject1, 5);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openTenpayView Exception", paramBundle);
        }
        a(str2, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      paramBundle = "";
    }
    label553:
    label582:
    label732:
    Object localObject3;
    if ("makeHongbao".compareTo(str3) == 0)
    {
      paramBundle = localJSONObject.optJSONObject("extra_data");
      if ((paramBundle != null) && (paramBundle.optJSONObject("extra_info") != null))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("callbackSn", str2);
        ((Intent)localObject1).putExtra("come_from", 2);
        ((Intent)localObject1).putExtra("is_H5", true);
        ((Intent)localObject1).putExtra("extra_data", paramBundle.toString());
        ((Intent)localObject1).putExtra("forward_type", 18);
        ((Intent)localObject1).setClass(this, ForwardRecentActivity.class);
        startActivityForResult((Intent)localObject1, 5);
        return;
      }
      localObject1 = new Intent(this, SendHbActivity.class);
      ((Intent)localObject1).putExtra("callbackSn", str2);
      ((Intent)localObject1).putExtra("come_from", 2);
      ((Intent)localObject1).putExtra("is_H5", true);
      if (localJSONObject.has("appInfo"))
      {
        paramBundle = localJSONObject.getString("appInfo");
        ((Intent)localObject1).putExtra("app_info", paramBundle);
        if (!localJSONObject.has("extra_data")) {
          break label1325;
        }
        paramBundle = localJSONObject.getString("extra_data");
        ((Intent)localObject1).putExtra("extra_data", paramBundle);
        ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
        startActivityForResult((Intent)localObject1, 5);
      }
    }
    else
    {
      if ("parseqrcode".compareTo(str3) == 0)
      {
        localObject1 = new Intent(this, TenpayJumpActivity.class);
        ((Intent)localObject1).putExtra("callbackSn", str2);
        if (!localJSONObject.has("comeForm")) {
          break label1331;
        }
        i = localJSONObject.getInt("comeForm");
        label674:
        ((Intent)localObject1).putExtra("come_from", i);
        if (!localJSONObject.has("appInfo")) {
          break label1336;
        }
        paramBundle = localJSONObject.getString("appInfo");
        label703:
        ((Intent)localObject1).putExtra("app_info", paramBundle);
        if (!localJSONObject.has("extra_data")) {
          break label1342;
        }
        paramBundle = localJSONObject.getString("extra_data");
        ((Intent)localObject1).putExtra("extra_data", paramBundle);
        startActivityForResult((Intent)localObject1, 5);
        return;
      }
      String str4;
      if ("transferqrcode".compareTo(str3) == 0)
      {
        str4 = this.app.getCurrentNickname();
        localObject2 = localJSONObject.optJSONObject("extra_data");
        localObject3 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("name", str4);
        localJSONObject.put("extra_data", localObject3);
      }
      catch (Exception localException)
      {
        label817:
        break label817;
      }
      if ("graphb".compareTo(str3) == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
      localObject3 = new Bundle();
      if ((str3.equals("bindNewCard")) && (localJSONObject.has("bargainor_id"))) {
        ((Bundle)localObject3).putString("bargainor_id", localJSONObject.getString("bargainor_id"));
      }
      if (localJSONObject.has("comeForm")) {
        i = localJSONObject.getInt("comeForm");
      }
      ((Bundle)localObject3).putInt("come_from", i);
      if (!localJSONObject.has("appInfo")) {
        break label1348;
      }
      localObject2 = localJSONObject.getString("appInfo");
      label935:
      ((Bundle)localObject3).putString("app_info", (String)localObject2);
      if (!localJSONObject.has("extra_data")) {
        break label1355;
      }
      localObject2 = localJSONObject.getString("extra_data");
      label966:
      ((Bundle)localObject3).putString("extra_data", (String)localObject2);
      if (!localJSONObject.has("senderuin")) {
        break label1362;
      }
      localObject2 = localJSONObject.getString("senderuin");
      label997:
      ((Bundle)localObject3).putString("senderuin", (String)localObject2);
      if (!localJSONObject.has("sendernickname")) {
        break label1369;
      }
    }
    label1313:
    label1325:
    label1331:
    label1336:
    label1342:
    label1348:
    String str1;
    label1355:
    label1362:
    label1369:
    for (Object localObject2 = localJSONObject.getString("sendernickname");; str1 = "")
    {
      ((Bundle)localObject3).putString("sendernickname", (String)localObject2);
      this.h = str3;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("callbackSn", str2);
      ((Bundle)localObject2).putString("tag", str3);
      ((Bundle)localObject2).putString("uin", (String)localObject1);
      if (!TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
        ((Bundle)localObject2).putString("nick_name", this.app.getCurrentNickname());
      }
      ((Bundle)localObject2).putBundle("params", (Bundle)localObject3);
      ((Bundle)localObject2).putInt("PayInvokerId", 5);
      ((Bundle)localObject2).putInt("payparmas_paytype", this.jdField_a_of_type_Int);
      ((Bundle)localObject2).putBoolean("payparmas_is_lock_withdraw", this.jdField_e_of_type_Boolean);
      localObject1 = paramBundle.getString("json");
      if (this.jdField_b_of_type_Long == 0L)
      {
        this.jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", "view." + str3, "loadPluginStart", (String)localObject1, 0, null);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        ((Bundle)localObject2).putLong("vacreport_key_seq", this.jdField_b_of_type_Long);
        if (QLog.isDevelopLevel()) {
          QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
        }
        paramBundle = paramBundle.getBundle("extra_ext_data");
        if (paramBundle != null) {
          ((Bundle)localObject2).putBundle("extra_ext_data", paramBundle);
        }
        QWalletPayBridge.launchService(this, this.app, (Bundle)localObject2);
        return;
        VACDReportUtil.a(this.jdField_b_of_type_Long, null, "loadPluginStart", (String)localObject1, 0, null);
      }
      paramBundle = "";
      break;
      paramBundle = "";
      break label553;
      paramBundle = "";
      break label582;
      i = 5;
      break label674;
      paramBundle = "";
      break label703;
      paramBundle = "";
      break label732;
      str1 = "";
      break label935;
      str1 = "";
      break label966;
      str1 = "";
      break label997;
    }
  }
  
  protected static Bundle f(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    localBundle = new Bundle();
    try
    {
      Object localObject = new JSONObject(paramString2);
      String str7 = ((JSONObject)localObject).getString("payType");
      String str8 = ((JSONObject)localObject).getString("appId");
      String str9 = ((JSONObject)localObject).getString("autoJump");
      String str1;
      label92:
      String str2;
      label113:
      String str3;
      label134:
      String str4;
      label155:
      String str5;
      label176:
      String str6;
      if (((JSONObject)localObject).has("wxSignUrl"))
      {
        paramString2 = ((JSONObject)localObject).getString("wxSignUrl");
        if (!((JSONObject)localObject).has("extend")) {
          break label701;
        }
        str1 = ((JSONObject)localObject).getString("extend");
        if (!((JSONObject)localObject).has("bargainorId")) {
          break label707;
        }
        str2 = ((JSONObject)localObject).getString("bargainorId");
        if (!((JSONObject)localObject).has("tokenId")) {
          break label713;
        }
        str3 = ((JSONObject)localObject).getString("tokenId");
        if (!((JSONObject)localObject).has("nonceStr")) {
          break label719;
        }
        str4 = ((JSONObject)localObject).getString("nonceStr");
        if (!((JSONObject)localObject).has("timeStamp")) {
          break label725;
        }
        str5 = ((JSONObject)localObject).getString("timeStamp");
        if (!((JSONObject)localObject).has("packageValue")) {
          break label731;
        }
        str6 = ((JSONObject)localObject).getString("packageValue");
        label197:
        if (!((JSONObject)localObject).has("sign")) {
          break label737;
        }
      }
      label701:
      label707:
      label713:
      label719:
      label725:
      label731:
      label737:
      for (localObject = ((JSONObject)localObject).getString("sign");; localObject = null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("&pt=").append(str7);
        localStringBuilder.append("&ai=").append(str8);
        localStringBuilder.append("&aj=").append(str9);
        localStringBuilder.append("&wsu=").append(paramString2);
        localStringBuilder.append("&ex=").append(str1);
        localStringBuilder.append("&bi=").append(str2);
        localStringBuilder.append("&ti=").append(str3);
        localStringBuilder.append("&ns=").append(str4);
        localStringBuilder.append("&ts=").append(str5);
        localStringBuilder.append("&pv=").append(str6);
        localStringBuilder.append("&sign=").append((String)localObject);
        if (!TextUtils.isEmpty(paramString3)) {
          localStringBuilder.append("&url=").append(paramString3);
        }
        VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
        paramString3 = new Bundle();
        paramString3.putString("payType", str7);
        paramString3.putString("appId", str8);
        paramString3.putString("autoJump", str9);
        paramString3.putString("wxSignUrl", paramString2);
        paramString3.putString("extend", str1);
        paramString3.putString("bargainorId", str2);
        paramString3.putString("tokenId", str3);
        paramString3.putString("nonceStr", str4);
        paramString3.putString("timeStamp", str5);
        paramString3.putString("packageValue", str6);
        paramString3.putString("sign", (String)localObject);
        paramString3.putString("callbackSn", paramString1);
        paramString3.putInt("PayInvokerId", 17);
        paramString3.putInt("payparmas_paytype", paramInt);
        paramString3.putLong("payparmas_h5_start", paramLong1);
        paramString3.putLong("vacreport_key_seq", paramLong2);
        if (paramResultReceiver != null)
        {
          paramString1 = Parcel.obtain();
          paramResultReceiver.writeToParcel(paramString1, 0);
          paramString1.setDataPosition(0);
          paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString1);
          paramString1.recycle();
          paramString3.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
        }
        VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
        if (QLog.isDevelopLevel()) {
          QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
        }
        QWalletPayBridge.launchService(paramActivity, paramAppInterface, paramString3);
        localBundle.putInt("retCode", 0);
        return localBundle;
        paramString2 = null;
        break;
        str1 = null;
        break label92;
        str2 = null;
        break label113;
        str3 = null;
        break label134;
        str4 = null;
        break label155;
        str5 = null;
        break label176;
        str6 = null;
        break label197;
      }
      return localBundle;
    }
    catch (JSONException paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "launchWeChat JSONException:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle.putInt("retCode", -1);
      localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat JSONException'}");
      return localBundle;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "launchWeChat Exception:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle.putInt("retCode", -1);
      localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat Exception'}");
    }
  }
  
  private void f(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("payState", -1);
    int m = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int n = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.jdField_b_of_type_Boolean) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, n, null);
    }
    if (i == 1)
    {
      a(j, str1, str2, k, m);
      return;
    }
    a(-1, "", "", -1, -1);
  }
  
  private void f(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("offerId");
      String str2 = paramBundle.getString("userId");
      String str3 = paramBundle.getString("skey");
      String str4 = paramBundle.getString("serviceCode");
      String str5 = paramBundle.getString("serviceName");
      String str6 = paramBundle.getString("channel");
      String str7 = paramBundle.getString("uint");
      String str8 = paramBundle.getString("openMonth");
      boolean bool1 = paramBundle.getBoolean("isCanChange");
      String str9 = paramBundle.getString("provideUin");
      String str10 = paramBundle.getString("provideType");
      String str11 = paramBundle.getString("discountId");
      String str12 = paramBundle.getString("other");
      String str13 = paramBundle.getString("payload");
      boolean bool2 = paramBundle.getBoolean("autoPay", true);
      Object localObject = paramBundle.getString("aid");
      paramBundle = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + (String)localObject;
      this.jdField_e_of_type_JavaLangString = str1;
      this.f = ((String)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("setEnv", "release");
      ((Bundle)localObject).putBoolean("setLogEnable", true);
      ((Bundle)localObject).putString("offerId", str1);
      if ((str7 != null) && (str7.length() > 0)) {
        ((Bundle)localObject).putString("unit", str7);
      }
      if ((str6 != null) && (str6.length() > 0)) {
        ((Bundle)localObject).putString("payChannel", str6);
      }
      ((Bundle)localObject).putString("userId", str2);
      ((Bundle)localObject).putString("userKey", str3);
      ((Bundle)localObject).putString("sessionId", "uin");
      ((Bundle)localObject).putString("sessionType", "skey");
      ((Bundle)localObject).putString("pf", paramBundle);
      ((Bundle)localObject).putString("pfKey", "pfKey");
      ((Bundle)localObject).putString("serviceCode", str4);
      ((Bundle)localObject).putString("serviceName", str5);
      ((Bundle)localObject).putBoolean("autoPay", bool2);
      ((Bundle)localObject).putInt("resId", 0);
      if ((str8 != null) && (str8.length() > 0))
      {
        ((Bundle)localObject).putString("saveValue", str8);
        ((Bundle)localObject).putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
      }
      ((Bundle)localObject).putString("remark", "");
      ((Bundle)localObject).putString("provideUin", str9);
      ((Bundle)localObject).putString("provideType", str10);
      ((Bundle)localObject).putString("discountId", str11);
      ((Bundle)localObject).putString("other", str12);
      ((Bundle)localObject).putString("payload", str13);
      ((Bundle)localObject).putInt("PayInvokerId", 4);
      ((Bundle)localObject).putInt("payparmas_paytype", this.jdField_a_of_type_Int);
      QWalletPayBridge.launchService(this, this.app, (Bundle)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openService Exception:" + paramBundle.getMessage());
      }
      a(-5, "openService Exception", -1, -1);
      paramBundle.printStackTrace();
    }
  }
  
  private void g(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    Object localObject1 = paramIntent.getStringExtra("result");
    int k = paramIntent.getIntExtra("viewRetCode", -9);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 2, "onOpenTenpayViewResult mOpenViewTag=" + this.h + ",nPayResult=" + j + ",result=" + (String)localObject1 + ",viewRetCode=" + k);
    }
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject1).optJSONObject("retdata");
        if (localJSONObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("retdata", localJSONObject.toString());
          i = Integer.valueOf(localJSONObject.optString("exec_code", "-1")).intValue();
          if ((i == 1) || (i == 2) || (i == 3))
          {
            setResult(-1, localIntent);
            finish();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((k == 0) && (!TextUtils.isEmpty((CharSequence)localObject1)) && ("hbPackConfirm".equalsIgnoreCase(this.h))) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new JSONObject((String)localObject1).optString("retmsg"));
        if (localObject1 != null)
        {
          Object localObject2 = new JSONObject(((JSONObject)localObject1).optString("user_msg"));
          if ((localObject2 != null) && (((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")))
          {
            localObject1 = ((JSONObject)localObject2).getString("uin");
            switch (((JSONObject)localObject2).getInt("type"))
            {
            case 0: 
              if (i != -1)
              {
                localObject2 = AIOUtils.a(new Intent(this, SplashActivity.class), null);
                ((Intent)localObject2).putExtra("uin", (String)localObject1);
                ((Intent)localObject2).putExtra("uintype", i);
                ((Intent)localObject2).putExtra("isBack2Root", true);
                startActivity((Intent)localObject2);
              }
              break;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
        paramIntent.putExtra("payRetCode", k);
        paramIntent.putExtra("result", b());
        d(paramIntent.getExtras());
        return;
      }
      if (j == 1)
      {
        paramIntent.putExtra("payRetCode", k);
        d(paramIntent.getExtras());
        return;
        i = 0;
        continue;
        i = 3000;
        continue;
        i = 1;
        continue;
        i = 1000;
        continue;
        i = 1004;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private void g(Bundle paramBundle)
  {
    this.jdField_b_of_type_Boolean = true;
    String str1;
    if ((this.jdField_b_of_type_Long == 0L) && ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 2)))
    {
      str1 = a(this.jdField_b_of_type_Int);
      if (str1 != null)
      {
        this.jdField_b_of_type_Long = VACDReportUtil.a(null, "qqwallet", str1, "payinvoke", null, 0, null);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    String str18 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.payPayBridgeActivity", 2, "PayBridgeActivity openSVip request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str18));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str22 = ((JSONObject)localObject).getString("offerId");
        String str19 = ((JSONObject)localObject).getString("userId");
        String str20 = ((JSONObject)localObject).getString("serviceCode");
        String str21 = ((JSONObject)localObject).getString("serviceName");
        if (((JSONObject)localObject).has("channel"))
        {
          str1 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label1404;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("openMonth")) {
            break label1410;
          }
          str3 = ((JSONObject)localObject).getString("openMonth");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1416;
          }
          bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("isAutoPay")) {
            break label1422;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isAutoPay");
          if (!((JSONObject)localObject).has("remark")) {
            break label1428;
          }
          str4 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("aid")) {
            break label1435;
          }
          str5 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("actTitle")) {
            break label1442;
          }
          str6 = ((JSONObject)localObject).getString("actTitle");
          if (!((JSONObject)localObject).has("openType")) {
            break label1449;
          }
          i = ((JSONObject)localObject).getInt("openType");
          if (!((JSONObject)localObject).has("actHint")) {
            break label1454;
          }
          str7 = ((JSONObject)localObject).getString("actHint");
          if (!((JSONObject)localObject).has("actPayTotal")) {
            break label1460;
          }
          str8 = ((JSONObject)localObject).getString("actPayTotal");
          if (!((JSONObject)localObject).has("actPayDiscount")) {
            break label1466;
          }
          str9 = ((JSONObject)localObject).getString("actPayDiscount");
          if (!((JSONObject)localObject).has("actBtnTitle")) {
            break label1472;
          }
          str10 = ((JSONObject)localObject).getString("actBtnTitle");
          if (!((JSONObject)localObject).has("openServicePrice")) {
            break label1478;
          }
          str11 = ((JSONObject)localObject).getString("openServicePrice");
          if (!((JSONObject)localObject).has("upgradeServicePrice")) {
            break label1484;
          }
          str12 = ((JSONObject)localObject).getString("upgradeServicePrice");
          if (!((JSONObject)localObject).has("maxUpgradeMonth")) {
            break label1490;
          }
          j = ((JSONObject)localObject).getInt("maxUpgradeMonth");
          if (!((JSONObject)localObject).has("openTitle")) {
            break label1495;
          }
          str13 = ((JSONObject)localObject).getString("openTitle");
          if (!((JSONObject)localObject).has("upgradeTitle")) {
            break label1502;
          }
          str14 = ((JSONObject)localObject).getString("upgradeTitle");
          if (!((JSONObject)localObject).has("discountId")) {
            break label1509;
          }
          str15 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label1516;
          }
          str16 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("payload")) {
            break label1523;
          }
          str17 = ((JSONObject)localObject).getString("payload");
          if (((JSONObject)localObject).has("couponId"))
          {
            localObject = ((JSONObject)localObject).getString("couponId");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramBundle.getString("json"));
            paramBundle = paramBundle.getString("payparmas_h5_url");
            if (!TextUtils.isEmpty(paramBundle)) {
              localStringBuilder.append("&url=").append(paramBundle);
            }
            VACDReportUtil.a(this.jdField_b_of_type_Long, null, "parseurl", localStringBuilder.toString(), 0, null);
            this.jdField_e_of_type_JavaLangString = str22;
            this.f = str5;
            paramBundle = new Bundle();
            paramBundle.putString("offerId", str22);
            paramBundle.putString("setEnv", "release");
            paramBundle.putBoolean("setLogEnable", false);
            if ((str2 != null) && (str2.length() > 0)) {
              paramBundle.putString("unit", str2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              paramBundle.putString("payChannel", str1);
            }
            paramBundle.putString("callbackSn", str18);
            str1 = "qq_m_qq-2013-android-" + AppSetting.jdField_a_of_type_Int + "-" + str5;
            paramBundle.putString("userId", str19);
            paramBundle.putString("sessionId", "uin");
            paramBundle.putString("pf", str1);
            paramBundle.putString("pfKey", "pfKey");
            paramBundle.putString("serviceCode", str20);
            paramBundle.putString("serviceName", str21);
            paramBundle.putInt("resId", 0);
            if ((str3 != null) && (str3.length() > 0))
            {
              paramBundle.putString("openMonth", str3);
              paramBundle.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            paramBundle.putBoolean("isAutoPay", Boolean.valueOf(bool2).booleanValue());
            paramBundle.putString("remark", str4);
            paramBundle.putString("actTitle", str6);
            paramBundle.putInt("openType", i);
            paramBundle.putString("actHint", str7);
            paramBundle.putString("actPayTotal", str8);
            paramBundle.putString("actPayDiscount", str9);
            paramBundle.putString("actBtnTitle", str10);
            paramBundle.putString("openServicePrice", str11);
            paramBundle.putString("upgradeServicePrice", str12);
            paramBundle.putInt("maxUpgradeMonth", j);
            paramBundle.putString("openTitle", str13);
            paramBundle.putString("upgradeTitle", str14);
            paramBundle.putString("discountId", str15);
            paramBundle.putString("other", str16);
            paramBundle.putString("payload", str17);
            paramBundle.putString("couponId", (String)localObject);
            paramBundle.putInt("PayInvokerId", 11);
            paramBundle.putInt("payparmas_paytype", this.jdField_a_of_type_Int);
            paramBundle.putLong("payparmas_h5_start", this.jdField_a_of_type_Long);
            paramBundle.putLong("vacreport_key_seq", this.jdField_b_of_type_Long);
            VACDReportUtil.a(this.jdField_b_of_type_Long, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchService(this, this.app, paramBundle);
            return;
          }
          localObject = "";
          continue;
        }
        str1 = null;
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openSVip JSONException:" + paramBundle.getMessage());
        }
        paramBundle = new Bundle();
        paramBundle.putString("callbackSn", str18);
        paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
        paramBundle.putInt("payRetCode", -1);
        paramBundle.putLong("reportSeq", this.jdField_b_of_type_Long);
        d(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "openSVip Exception:" + paramBundle.getMessage());
        }
        paramBundle = new Bundle();
        paramBundle.putString("callbackSn", str18);
        paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
        paramBundle.putInt("payRetCode", -1);
        paramBundle.putLong("reportSeq", this.jdField_b_of_type_Long);
        d(paramBundle);
        return;
      }
      continue;
      label1404:
      String str2 = null;
      continue;
      label1410:
      String str3 = null;
      continue;
      label1416:
      boolean bool1 = true;
      continue;
      label1422:
      boolean bool2 = true;
      continue;
      label1428:
      String str4 = "";
      continue;
      label1435:
      String str5 = "";
      continue;
      label1442:
      String str6 = "";
      continue;
      label1449:
      int i = 0;
      continue;
      label1454:
      String str7 = null;
      continue;
      label1460:
      String str8 = null;
      continue;
      label1466:
      String str9 = null;
      continue;
      label1472:
      String str10 = null;
      continue;
      label1478:
      String str11 = null;
      continue;
      label1484:
      String str12 = null;
      continue;
      label1490:
      int j = 0;
      continue;
      label1495:
      String str13 = "";
      continue;
      label1502:
      String str14 = "";
      continue;
      label1509:
      String str15 = "";
      continue;
      label1516:
      String str16 = "";
      continue;
      label1523:
      String str17 = "";
    }
  }
  
  private void h(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) == 1)
    {
      d(paramIntent.getExtras());
      return;
    }
    paramIntent.putExtra("result", b());
    d(paramIntent.getExtras());
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (paramString1 == null)) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString1);
    localBundle.putString("callbackSn", paramString2);
    return a(paramActivity, paramInt, localBundle);
  }
  
  protected String a(int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (paramInt == 4) {
        return "openService-push";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-push";
      }
      if (paramInt == 7) {
        return "buyGoods-push";
      }
      if (paramInt == 8) {
        return "rechargeQb-push";
      }
      if (paramInt == 9) {
        return "pay-push";
      }
      if (paramInt == 14) {
        return "monthCardPay-push";
      }
      if (paramInt == 11) {
        return "openSVip-push";
      }
    }
    else
    {
      if (paramInt == 4) {
        return "openService-nt";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-nt";
      }
      if (paramInt == 7) {
        return "buyGoods-nt";
      }
      if (paramInt == 8) {
        return "rechargeQb-nt";
      }
      if (paramInt == 9) {
        return "pay-native";
      }
      if (paramInt == 14) {
        return "monthCardPay-nt";
      }
      if (paramInt == 11) {
        return "openSVip-nt";
      }
    }
    return null;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131492923);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " PayBridgeActivity.doOnCreate");
    }
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "PayBridgeActivity.doOnCreate extras null");
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    this.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)this.jdField_a_of_type_AndroidOsBundle.getParcelable("receiver"));
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay", 2, "PayBridgeActivity receiver = " + this.jdField_a_of_type_AndroidOsResultReceiver);
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("pay_requestcode", -1);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("payparmas_paytype", -1);
    a(this.jdField_a_of_type_AndroidOsBundle);
    if ((this.jdField_a_of_type_AndroidOsBundle.getBoolean("payparmas_from_is_login_state", true)) && ((this.app == null) || (this.app.getCurrentAccountUin() == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "PayBridgeActivity.doOnCreate app error");
      }
      finish();
      return false;
    }
    new QNotificationManager(this).cancel("Q.qwallet.payPayBridgeActivity", 128);
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("payparmas_from_pcpush", false);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("payparmas_h5_start", 0L);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("vacreport_key_seq", 0L);
    if (this.jdField_b_of_type_Int == 12)
    {
      if (GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.push", 2, "moveTaskToBack and startUnlockActivity...");
        }
        startUnlockActivity();
        super.finish();
        return false;
      }
      if (jdField_c_of_type_Boolean)
      {
        super.finish();
        return false;
      }
      jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      a(QWalletPushManager.a(this.jdField_a_of_type_Boolean));
      return false;
    }
    jdField_c_of_type_Boolean = true;
    if (this.jdField_b_of_type_Int == 1)
    {
      paramBundle = DataFactory.EmojiPayReqData.a(this.jdField_a_of_type_AndroidOsBundle);
      if ((paramBundle == null) || (!a(paramBundle)))
      {
        a(paramBundle, -1, 0, -1, -1, -1, "param error");
        if (paramBundle == null) {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror: reqData:null");
          }
        }
        for (;;)
        {
          jdField_c_of_type_Boolean = false;
          finish();
          return false;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.payPayBridgeActivity", 2, "emojimall pay paramerror:userid:" + paramBundle.jdField_c_of_type_JavaLangString + "userkey:" + paramBundle.jdField_d_of_type_JavaLangString + "sessionid:" + paramBundle.jdField_e_of_type_JavaLangString + "sessionType:" + paramBundle.f + "zoneId:" + paramBundle.g + "pf:" + paramBundle.h + "pfKey:" + paramBundle.i + "tokenUrl:" + paramBundle.j + "discountId:" + paramBundle.k + "other:" + paramBundle.l + "payload:" + paramBundle.m);
          }
        }
      }
      a(paramBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      b(this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      c(this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if ((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7) || (this.jdField_b_of_type_Int == 8) || (this.jdField_b_of_type_Int == 9) || (this.jdField_b_of_type_Int == 14))
    {
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 5)
    {
      e(this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 10)
    {
      f(this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 11)
    {
      g(this.jdField_a_of_type_AndroidOsBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 13)
    {
      paramBundle = new Bundle();
      paramBundle.putInt("PayInvokerId", 12);
      QWalletPayBridge.launchService(this, this.app, paramBundle);
      return false;
    }
    if (this.jdField_b_of_type_Int == 200)
    {
      b();
      return false;
    }
    if (this.jdField_b_of_type_Int == 201)
    {
      a();
      return false;
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 4, "doOnDestroy...");
    }
    super.doOnDestroy();
    jdField_c_of_type_Boolean = false;
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramBundle.getInt("mPayType", -1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("mPayTokenId");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("mPayAppId");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("mPayChannel");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("mPayBargainorId");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("mMidasOfferid");
    this.f = paramBundle.getString("mMidasAid");
    this.g = paramBundle.getString("mMidasOrderId");
    this.h = paramBundle.getString("mOpenViewTag");
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("mPayType", this.jdField_a_of_type_Int);
    paramBundle.putString("mPayTokenId", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("mPayAppId", this.jdField_b_of_type_JavaLangString);
    paramBundle.putString("mPayChannel", this.jdField_c_of_type_JavaLangString);
    paramBundle.putString("mPayBargainorId", this.jdField_d_of_type_JavaLangString);
    paramBundle.putString("mMidasOfferid", this.jdField_e_of_type_JavaLangString);
    paramBundle.putString("mMidasAid", this.f);
    paramBundle.putString("mMidasOrderId", this.g);
    paramBundle.putString("mOpenViewTag", this.h);
  }
  
  public void finish()
  {
    QWalletPushManager.a();
    int i = QWalletPushManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 2, "finish idlePayCount=" + i);
    }
    if (i <= 0)
    {
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_AndroidContentIntent != null)) {
        setResult(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
      }
      jdField_c_of_type_Boolean = false;
      super.finish();
      return;
    }
    Object localObject = new Intent(this, PayBridgeActivity.class);
    ((Intent)localObject).addFlags(536870912);
    startActivity((Intent)localObject);
    localObject = String.format(getString(2131432219), new Object[] { Integer.valueOf(i) });
    localObject = a(getString(2131436764), (String)localObject, null);
    ((Dialog)localObject).setCancelable(false);
    tbp localtbp = new tbp(this, (Dialog)localObject);
    ((Dialog)localObject).findViewById(2131364014).setOnClickListener(localtbp);
    ((Dialog)localObject).findViewById(2131364013).setOnClickListener(localtbp);
    ((Dialog)localObject).setOnDismissListener(new tbq(this));
    ((Dialog)localObject).show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -1;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.payPayBridgeActivity", 4, "PayBridgeActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (((paramIntent != null) && (paramInt1 == 3001)) || (paramInt2 == -1))
    {
      paramInt1 = i;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "" + System.currentTimeMillis() + " nInvokerId = " + paramInt1);
      }
      switch (paramInt1)
      {
      case 13: 
      case 15: 
      case 16: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown InvokerId : " + paramInt1);
        }
        finish();
        return;
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      case 14: 
      case 17: 
        b(paramIntent);
        return;
      case 1: 
        c(paramIntent);
        return;
      case 2: 
        d(paramIntent);
        return;
      case 3: 
        e(paramIntent);
        return;
      case 10: 
        f(paramIntent);
        return;
      case 5: 
        g(paramIntent);
        return;
      case 9: 
        h(paramIntent);
        return;
      }
      a(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.payPayBridgeActivity", 2, "QvipPayBridge Unknown data");
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */