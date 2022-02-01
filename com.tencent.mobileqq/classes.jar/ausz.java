import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.4;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ausz
  implements agin, Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private final DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new autc(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public ausz(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
  }
  
  private void a()
  {
    b();
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_b77_sdk_share");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.removeExtra("key_b77_sdk_share");
    Map localMap = ((auuc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.SDK_SHARE)).a(str);
    if (localMap == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "initBroadcastReceiver");
      b(str);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(93), 500L);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
    a(localMap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    auuv.a("KEY_STAGE_2_TOTAL", false);
    auui.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, false);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      bdla.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    auqo.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, new auta(this, paramInt, paramString2));
  }
  
  public static void a(Activity paramActivity, agih paramagih)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "doSdkShare");
    if (TextUtils.isEmpty(paramActivity.getIntent().getStringExtra("key_b77_sdk_share")))
    {
      paramagih = (auui)paramagih.a(13);
      if (paramagih != null) {
        paramagih.a(paramActivity.getIntent());
      }
    }
    do
    {
      return;
      paramActivity = (ausz)paramagih.a(57);
    } while (paramActivity == null);
    paramActivity.a();
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.jdField_a_of_type_AndroidAppActivity);
    }
    auuv.a("KEY_STAGE_2_TOTAL", false);
    auui.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, false);
  }
  
  private void a(String paramString, Context paramContext)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpToErrorWeb: invoked. info: jumpUrl = ", paramString });
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
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "jumpToErrorWeb: Failed. info: exception = ", paramString);
    }
  }
  
  private void a(Map<String, Object> paramMap)
  {
    Integer localInteger1 = (Integer)paramMap.get("key_b77_error_code");
    Integer localInteger2 = (Integer)paramMap.get("key_b77_jump_result");
    String str1 = (String)paramMap.get("key_b77_jump_url");
    String str2 = (String)paramMap.get("key_b77_wording");
    paramMap = (String)paramMap.get("key_b77_develop_msg");
    if ((localInteger1 != null) && (localInteger1.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "errorCode=", localInteger1 });
      a(localInteger1.intValue(), str2, paramMap);
      return;
    }
    if ((localInteger2 != null) && (localInteger2.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpResult=", localInteger2 });
      a(str1);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "handleSendSuccess");
    c();
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp)
  {
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(bcrn.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", paramMessageForArkApp });
    return 25201 == ForwardUtils.parseInt(paramMessageForArkApp);
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp, Context paramContext)
  {
    String str = paramMessageForArkApp.getExtInfoFromExtStr(bcrn.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", str, ", uinseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    int i = ForwardUtils.parseInt(str);
    if ((i == 0) || (i == 25201) || (i == -2)) {
      return false;
    }
    str = paramMessageForArkApp.getExtInfoFromExtStr(bcrn.y);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "resendSdkFakeMsg fakeShareInfo empty");
      return false;
    }
    autd localautd = new autd();
    try
    {
      localautd.a(paramMessageForArkApp, paramContext, new JSONObject(str));
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "Exception", paramMessageForArkApp);
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
      }
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { " updateCurrentInfo mExtra=", this.jdField_a_of_type_AndroidOsBundle, ", mShareAppId=", Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new autb(this, paramString);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_notify_aio_activity_by_b77"));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      Object localObject = bdof.a(this.jdField_a_of_type_AndroidOsBundle);
      if ((localObject instanceof AbsShareMsg))
      {
        localObject = (AbsShareMsg)localObject;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = auui.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      }
    }
    auui.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog");
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidAppDialog.isShowing());
    this.jdField_a_of_type_AndroidAppDialog.show();
    return;
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755829);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559607);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740)).setText(2131694652);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void f()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "hideWaiteDialog");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardSDKB77AIOHelper.4(this));
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    d();
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
  }
  
  public int[] a()
  {
    return new int[] { 7, 14 };
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 93: 
      do
      {
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      e();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(94), 10000L);
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
      return true;
    }
    bdla.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    f();
    auqo.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131704269), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausz
 * JD-Core Version:    0.7.0.1
 */