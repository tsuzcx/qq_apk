import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper.4;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper.5;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ArkJsonBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.MiniAppMsgBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RichMsgBody;

public class aqfv
  implements adif, Handler.Callback
{
  public static final String a;
  private int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long = 10000L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public final DialogInterface.OnClickListener a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  final auoq jdField_a_of_type_Auoq = new aqfw(this);
  private bbgu jdField_a_of_type_Bbgu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private bbgu jdField_b_of_type_Bbgu;
  private volatile boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long = -1L;
  private volatile boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131719425);
  }
  
  public aqfv(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aqfz(this);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardShareByServerHelper", 2, " init ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      }
    }
  }
  
  public static long a()
  {
    amtn localamtn = amto.a();
    if (localamtn == null) {
      QLog.e("ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration null == confBean");
    }
    long l;
    do
    {
      return 5000L;
      l = localamtn.a();
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "getVerifyAppinfoTimeoutDuration, timeoutDuration = ", Long.valueOf(l) });
    } while (l == 0L);
    return l;
  }
  
  public static bbgu a(Activity paramActivity, bbgu parambbgu, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, String paramString)
  {
    aqgj.b("KEY_STAGE_2_TOTAL");
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardShareByServerHelper", 2, " qbShowShareResultDialog error mActivity = null or finished");
      }
      paramActivity = null;
      return paramActivity;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getApplication().getString(2131719421);
    if (paramString != null) {}
    for (paramString = str + paramString;; paramString = str)
    {
      str = ((QQAppInterface)localObject).getApplication().getString(2131719427);
      localObject = ((QQAppInterface)localObject).getApplication().getString(2131719422);
      aqfx localaqfx = new aqfx(paramLong, paramInt, paramActivity);
      aqfy localaqfy = new aqfy(paramLong, paramInt, paramActivity, paramBaseChatPie);
      paramBaseChatPie = parambbgu;
      if (parambbgu == null) {
        paramBaseChatPie = bbdj.a(paramActivity, 232, null, str, paramString, (String)localObject, localaqfx, localaqfy);
      }
      paramBaseChatPie.setNegativeButton(paramString, localaqfy);
      paramBaseChatPie.setPositiveButton((String)localObject, localaqfx);
      try
      {
        paramBaseChatPie.show();
        return paramBaseChatPie;
      }
      catch (Throwable parambbgu)
      {
        paramActivity = paramBaseChatPie;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ForwardShareByServerHelper", 2, "qbShowShareResultDialog: failed. ", parambbgu);
      return paramBaseChatPie;
    }
  }
  
  private AbsStructMsg a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    Intent localIntent;
    do
    {
      return null;
      localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    } while (localIntent == null);
    return axva.a(localIntent.getByteArrayExtra("stuctmsg_bytes"));
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      paramString = MessageDigest.getInstance("MD5");
      paramString.update(paramContext[0].toByteArray());
      paramContext = bbea.a(paramString.digest());
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toLowerCase();
      paramString.reset();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return ajya.a(2131719421) + str;
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo)
  {
    int i = paramBundle.getInt("uintype");
    long l1 = paramBundle.getLong("req_share_id");
    int j = paramBundle.getInt("req_type");
    long l2 = ForwardUtils.a(paramBundle.getString("uin"));
    String str4 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    String str2 = paramBundle.getString("detail_url");
    String str3 = paramBundle.getString("image_url_remote");
    Object localObject1 = paramBundle.getString("res_pkg_name");
    Object localObject2 = paramBundle.getString("share_comment_message");
    String str5 = paramBundle.getString("share_comment_message_for_server");
    boolean bool = ArkFullScreenAppActivity.a(paramBundle);
    paramBundle = paramBundle.getString("shareArkInfo");
    if (QLog.isColorLevel()) {
      QLog.e("ForwardShareByServerHelper", 2, "notifyServerSendMesssage picture_url =" + str3 + "\n, appId=" + l1 + ", reqType = " + j + ", uinType = " + i + ", uin =" + l2 + "\n, title = " + str4 + ", summary = " + str1 + ", url = " + str2 + "\n, mRemoteImgUrl = " + paramString1 + ", pkgName =" + (String)localObject1 + ", commentText = " + (String)localObject2 + ", commentTextExt =" + str5 + "\n, displayArkJson + " + bool + ", arkInfo = " + paramBundle);
    }
    localObject2 = new oidb_cmd0xb77.ReqBody();
    ((oidb_cmd0xb77.ReqBody)localObject2).appid.set(l1);
    ((oidb_cmd0xb77.ReqBody)localObject2).app_type.set(1);
    ((oidb_cmd0xb77.ReqBody)localObject2).recv_uin.set(l2);
    if (i == 0)
    {
      ((oidb_cmd0xb77.ReqBody)localObject2).send_type.set(0);
      if (j != 1) {
        break label694;
      }
      label348:
      paramBundle = new oidb_cmd0xb77.ClientInfo();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramBundle.android_package_name.set((String)localObject1);
      }
      paramBundle.platform.set(1);
      localObject1 = a(BaseApplicationImpl.getContext(), (String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramBundle.android_signature.set((String)localObject1);
      }
      paramBundle.sdk_version.set("0.0.0");
      ((oidb_cmd0xb77.ReqBody)localObject2).client_info.set(paramBundle);
      localObject1 = new oidb_cmd0xb77.RichMsgBody();
      if (paramImageInfo != null) {
        ((oidb_cmd0xb77.RichMsgBody)localObject1).image_info.set(paramImageInfo);
      }
      if (!TextUtils.isEmpty(str4)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject1).title.set(str4);
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramBundle = str1;
        if (str1.contains(ajya.a(2131704818))) {
          paramBundle = str1.replace(ajya.a(2131704845), "");
        }
        ((oidb_cmd0xb77.RichMsgBody)localObject1).summary.set(paramBundle);
      }
      if (!TextUtils.isEmpty(str2)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject1).url.set(str2);
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label761;
      }
      ((oidb_cmd0xb77.RichMsgBody)localObject1).picture_url.set(paramString1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardShareByServerHelper", 2, "notifyServerSendMesssage picture_url =" + ((oidb_cmd0xb77.RichMsgBody)localObject1).picture_url.get());
      }
      if ((j == 2) && (!TextUtils.isEmpty(paramString2)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardShareByServerHelper", 2, "notifyServerSendMesssage musicUrl =" + paramString2);
        }
        ((oidb_cmd0xb77.RichMsgBody)localObject1).music_url.set(paramString2);
      }
      ((oidb_cmd0xb77.ReqBody)localObject2).rich_msg_body.set((MessageMicro)localObject1);
      return localObject2;
      if (i == 1)
      {
        ((oidb_cmd0xb77.ReqBody)localObject2).send_type.set(1);
        break;
      }
      if (i != 3000) {
        break;
      }
      ((oidb_cmd0xb77.ReqBody)localObject2).send_type.set(2);
      break;
      label694:
      if (j == 2)
      {
        ((oidb_cmd0xb77.ReqBody)localObject2).msg_style.set(4);
        break label348;
      }
      if (j == 4)
      {
        ((oidb_cmd0xb77.ReqBody)localObject2).msg_style.set(5);
        break label348;
      }
      if (j == 5)
      {
        ((oidb_cmd0xb77.ReqBody)localObject2).msg_style.set(6);
        break label348;
      }
      ((oidb_cmd0xb77.ReqBody)localObject2).msg_style.set(0);
      break label348;
      label761:
      if (!TextUtils.isEmpty(str3)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject1).picture_url.set(str3);
      } else if (QLog.isColorLevel()) {
        QLog.e("ForwardShareByServerHelper", 2, "richMsgBody picture_url not set");
      }
    }
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    nau.a((QQAppInterface)localObject1, "", "choose", paramLong, paramInt, "stay");
    bdes.a().a(((QQAppInterface)localObject1).getAccount(), "", String.valueOf(paramLong), "1000", "52", "0", false);
    Object localObject2 = paramActivity.getIntent();
    Object localObject3 = "com.tencent.tauth.opensdk.SHARE_SUCCESS_AND_STAY_QQ_" + ((Intent)localObject2).getLongExtra("activity_finish_run_appId", 0L);
    localObject1 = ((Intent)localObject2).getStringExtra("res_pkg_name");
    localObject3 = new Intent((String)localObject3);
    localObject2 = (Uri)((Intent)localObject2).getParcelableExtra("activity_finish_run_uriData");
    ((Intent)localObject3).setPackage((String)localObject1);
    ((Intent)localObject3).putExtra("uriData", (Parcelable)localObject2);
    paramActivity.sendBroadcast((Intent)localObject3);
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    nau.a(localQQAppInterface, "", "choose", paramLong, paramInt, "back");
    bdes.a().a(localQQAppInterface.getAccount(), "", String.valueOf(paramLong), "1000", "51", "0", false);
    nau.a(paramActivity, 0, "", "");
    if (paramBaseChatPie != null) {
      paramBaseChatPie.b(1);
    }
    if (paramActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        paramBaseChatPie = (PendingIntent)paramActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramBaseChatPie != null) && (!paramActivity.getIntent().getBooleanExtra("share_from_aio", false))) {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
          }
        }
        try
        {
          paramBaseChatPie.send();
          paramActivity.moveTaskToBack(true);
          return;
        }
        catch (PendingIntent.CanceledException paramBaseChatPie)
        {
          for (;;)
          {
            QLog.e("ForwardShareByServerHelper", 2, "failed to send PendingIntent", paramBaseChatPie);
          }
        }
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("ForwardShareByServerHelper", 1, "qbShowShareResultDialog ", paramActivity);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardShareByServerHelper", 2, "sdk_share:sdk callback= appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
      if (paramActivity.getIntent() != null)
      {
        paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      try
      {
        paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString1);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardShareByServerHelper", 2, paramActivity.getMessage());
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("app_name");
    paramBundle = axva.a(paramBundle);
    if ((paramBundle != null) && ((paramBundle instanceof AbsShareMsg))) {}
    for (paramBundle = (AbsShareMsg)paramBundle;; paramBundle = null)
    {
      this.jdField_a_of_type_Bbgu = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bbgu, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramBundle.mSourceAppid, paramBundle.mMsgServiceID, str);
      return;
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = a(paramBundle, paramString1, paramString2, null);
    a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, paramBundle, paramString1);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e("ForwardShareByServerHelper", 1, "notifyServerSendMesssage send runtime = null ");
      b(jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.jdField_c_of_type_Long);
    QLog.i("ForwardShareByServerHelper", 1, "notifyServerSendMesssage sendOIDBRequest");
    aqgj.a("KEY_STAGE_2_NORMAL_B77");
    mxf.a(paramString2, new aqgc(this, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  private void a(auoq paramauoq, AbsStructMsg paramAbsStructMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new WeakReference(paramauoq);
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_AndroidAppActivity == null))
    {
      QLog.e("ForwardShareByServerHelper", 1, " requestShareMessage error mExtra = " + this.jdField_a_of_type_AndroidOsBundle + ", app=" + localQQAppInterface + ", mActivity =" + this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      b(ajya.a(2131704802));
      QLog.e("ForwardShareByServerHelper", 1, " requestShareMessage net error");
      return;
    }
    paramauoq = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if (paramAbsStructMsg == null)
    {
      QLog.e("ForwardShareByServerHelper", 1, " requestShareMessage error structMsg = null ");
      return;
    }
    QLog.i("ForwardShareByServerHelper", 1, "requestShareMessage structMsg=" + paramAbsStructMsg.getXml());
    localObject = (auoq)((WeakReference)localObject).get();
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(93), 500L);
    aqgj.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, (AbsShareMsg)paramAbsStructMsg, paramauoq, i, str, (auoq)localObject);
  }
  
  static void a(OpenSdkShareModel paramOpenSdkShareModel, Bundle paramBundle, oidb_cmd0xb77.ReqBody paramReqBody)
  {
    if (paramOpenSdkShareModel != null)
    {
      paramBundle = new oidb_cmd0xb77.MiniAppMsgBody();
      paramBundle.mini_app_appid.set(Long.parseLong(paramOpenSdkShareModel.miniAppAppid));
      paramBundle.mini_app_path.set(paramOpenSdkShareModel.miniAppPath);
      paramBundle.web_page_url.set(paramOpenSdkShareModel.webPageUrl);
      paramBundle.title.set(paramOpenSdkShareModel.title);
      paramBundle.desc.set(paramOpenSdkShareModel.desc);
      paramBundle.json_str.set(paramOpenSdkShareModel.jsonStr);
      paramReqBody.mini_app_msg_body.set(paramBundle);
      paramReqBody.msg_style.set(10);
    }
    String str1;
    String str5;
    do
    {
      do
      {
        return;
      } while (!ArkFullScreenAppActivity.a(paramBundle));
      paramOpenSdkShareModel = paramBundle.getString("forward_ark_app_name");
      str1 = paramBundle.getString("forward_ark_app_view");
      String str2 = paramBundle.getString("forward_ark_app_desc");
      String str3 = paramBundle.getString("forward_ark_app_ver");
      String str4 = paramBundle.getString("forward_ark_app_prompt");
      str5 = paramBundle.getString("forward_ark_app_meta");
      String str6 = paramBundle.getString("forward_ark_app_config");
      paramBundle = paramBundle.getString("forward_ark_app_compat");
      if ((!TextUtils.isEmpty(paramOpenSdkShareModel)) && (!TextUtils.isEmpty(str1)))
      {
        paramOpenSdkShareModel = new ArkAppMessage(str4, paramOpenSdkShareModel, str2, str1, str3, str5, str6, paramBundle);
        paramBundle = new oidb_cmd0xb77.ArkJsonBody();
        paramBundle.json_str.set(paramOpenSdkShareModel.toAppXml());
        paramReqBody.ark_json_body.set(paramBundle);
        paramReqBody.msg_style.set(8);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ForwardShareByServerHelper", 2, "richMsgBody displayArk appName =" + paramOpenSdkShareModel + ", appView =" + str1 + ", appMeta =" + str5);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.jdField_a_of_type_AndroidAppActivity);
    }
    aqgj.a("KEY_STAGE_2_TOTAL", false);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardShareByServerHelper", 2, "jumpToErrorWeb: invoked. info: jumpUrl = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ForwardShareByServerHelper", 2, "jumpToErrorWeb: Failed. info: exception = ", paramString);
    }
  }
  
  public static boolean a()
  {
    amtn localamtn = amto.a();
    if (localamtn != null) {}
    for (boolean bool = localamtn.a();; bool = false)
    {
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "isServerShareOpen, openServerShare = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      axqy.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    a(paramInt, paramString1, paramString2);
  }
  
  private void b(String paramString)
  {
    QLog.d("ForwardShareByServerHelper", 1, new Object[] { "showOtherErrorDialog ", paramString });
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardShareByServerHelper.5(this, paramString));
  }
  
  public static boolean b()
  {
    amtn localamtn = amto.a();
    if (localamtn != null) {}
    for (boolean bool = localamtn.b();; bool = false)
    {
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "isOpenedSDKShareImageByServer, shareImageByServer = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!TextUtils.isEmpty(paramString))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        SessionInfo localSessionInfo = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
        myb.a().jdField_a_of_type_Boolean = true;
        aanz.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localSessionInfo, paramString);
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ForwardShareByServerHelper", 2, "sendCommentMsg exception", paramString);
        return;
      }
    }
    QLog.e("ForwardShareByServerHelper", 2, "sendCommentMsg null ");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      }
    }
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("ForwardShareByServerHelper", 2, " updateCurrentInfo mActivity = " + this.jdField_a_of_type_AndroidAppActivity + ", mExtra=" + this.jdField_a_of_type_AndroidOsBundle + ", mBaseChatPie =" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  private void e()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Object localObject3;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject3 = ((Bundle)localObject2).getString("app_name");
      if (!((Bundle)localObject2).getBoolean("refuse_show_share_result_dialog", false))
      {
        localObject1 = axva.a((Bundle)localObject2);
        if ((localObject1 == null) || (!(localObject1 instanceof AbsShareMsg))) {
          break label421;
        }
        localObject1 = (AbsShareMsg)localObject1;
        this.jdField_a_of_type_Bbgu = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bbgu, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, ((AbsShareMsg)localObject1).mSourceAppid, ((AbsShareMsg)localObject1).mMsgServiceID, (String)localObject3);
      }
    }
    if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("forward_mini_program_ark_from_sdk", false))) {
      axqy.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "1", "", "", "");
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
        String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
        switch (j)
        {
        default: 
          bdkd.a().a(0, "SHARE_TO_QQ", ((QQAppInterface)localObject3).getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
          if (this.jdField_a_of_type_Int == 1)
          {
            localObject1 = "1";
            break label431;
            label274:
            bdes.a().a(((QQAppInterface)localObject3).getAccount(), "", this.jdField_b_of_type_Long + "", "10", "12", "0", (String)localObject1, str2, (String)localObject2, false);
            if (!QLog.isColorLevel()) {
              break label448;
            }
            QLog.e("ForwardShareByServerHelper", 2, new Object[] { "shareToQQ success report:reportType=10,actType=12,result=0,type=", localObject1, ",toType=", localObject2 });
          }
          else if (this.jdField_a_of_type_Int == 2)
          {
            localObject1 = "3";
          }
          else
          {
            if (this.jdField_a_of_type_Int != 5) {
              break label464;
            }
            localObject1 = "2";
          }
          break;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ForwardShareByServerHelper", 1, "shareToQQ success report:", localException);
        return;
      }
      if (3000 == j)
      {
        localObject2 = "3";
        continue;
        label421:
        String str1 = null;
        break;
        i = 1;
        continue;
        for (;;)
        {
          label431:
          localObject2 = "1";
          if (j != 0) {
            break label471;
          }
          localObject2 = "1";
          break label274;
          label448:
          return;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          label464:
          str1 = "4";
        }
        label471:
        if (1 == j) {
          localObject2 = "2";
        }
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aqgb(this);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_notify_aio_activity"));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    c();
    if (this.jdField_a_of_type_Bbgu != null) {
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = -1L;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardShareByServerHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      }
      this.jdField_b_of_type_Boolean = true;
      return;
      a();
    } while (!QLog.isColorLevel());
    QLog.d("ForwardShareByServerHelper", 2, "onMoveToState DESTROY =");
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    aqgj.a("KEY_STAGE_2_TOTAL", false);
    if (this.jdField_b_of_type_Bbgu == null) {
      this.jdField_b_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    }
    this.jdField_b_of_type_Bbgu.setMessage(paramString1);
    paramString1 = new aqga(this, paramInt, paramString2);
    this.jdField_b_of_type_Bbgu.setPositiveButton(2131694794, paramString1);
    this.jdField_b_of_type_Bbgu.show();
  }
  
  public void a(Intent paramIntent)
  {
    QLog.d("ForwardShareByServerHelper", 1, "forwardShare");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        break label312;
      }
    }
    label312:
    for (boolean bool = ((Bundle)localObject).getBoolean("share_send_msg_by_server", false);; bool = false)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("req_type", 2147483647);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "forwardShare sendMsgByServer =", Boolean.valueOf(bool), ",mForwardSubType=", Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramIntent.getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
      if (bool)
      {
        localObject = a();
        String str1 = ForwardUtils.c(this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"));
        String str2 = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
        if ((localObject instanceof AbsShareMsg))
        {
          paramIntent = ((AbsShareMsg)localObject).mContentTitle;
          axqy.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, "", str1, str2, paramIntent);
          d();
          a(this.jdField_a_of_type_Auoq, (AbsStructMsg)localObject);
        }
      }
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.e("ForwardShareByServerHelper", 2, "forwardShare: intent.null ");
        return;
        paramIntent = "";
        break;
        paramIntent = paramIntent.getExtras();
      } while ((paramIntent == null) || (paramIntent.getBoolean("refuse_show_share_result_dialog", false)));
      localObject = paramIntent.getString("key_share_image_by_server");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(paramIntent);
        return;
      }
      localObject = aqcs.a((String)localObject);
      QLog.d("ForwardShareByServerHelper", 1, new Object[] { "forwardShare errorMsg = ", localObject });
      if (localObject == null)
      {
        f();
        return;
      }
      if (((String)localObject).length() == 0)
      {
        a(paramIntent);
        return;
      }
      b((String)localObject);
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 5, 11 };
  }
  
  public void b()
  {
    QLog.d("ForwardShareByServerHelper", 1, "showWaitDialog");
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
      {
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557)).setText(2131695126);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
    while (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    QLog.d("ForwardShareByServerHelper", 1, "hideWaiteDialog");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardShareByServerHelper.4(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
        {
          b();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(94), 10000L);
          return true;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ForwardShareByServerHelper", 2, "isRequestDone do not show dialog");
      return true;
    } while ((this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.jdField_b_of_type_Boolean));
    QLog.d("ForwardShareByServerHelper", 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
    axqy.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
    c();
    b(ajya.a(2131704801));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfv
 * JD-Core Version:    0.7.0.1
 */