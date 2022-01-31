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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.4;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.os.MqqHandler;

public class arya
  implements afal, Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private final DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aryd(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private bdfq jdField_a_of_type_Bdfq;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public arya(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
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
    Map localMap = ((arzd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a(str);
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
    arzy.a("KEY_STAGE_2_TOTAL", false);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      azmj.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    arvh.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, new aryb(this, paramInt, paramString2));
  }
  
  public static void a(Activity paramActivity, afag paramafag)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "doSdkShare");
    if (TextUtils.isEmpty(paramActivity.getIntent().getStringExtra("key_b77_sdk_share")))
    {
      paramafag = (arzk)paramafag.a(13);
      if (paramafag != null) {
        paramafag.a(paramActivity.getIntent());
      }
    }
    do
    {
      return;
      paramActivity = (arya)paramafag.a(57);
    } while (paramActivity == null);
    paramActivity.a();
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.jdField_a_of_type_AndroidAppActivity);
    }
    arzy.a("KEY_STAGE_2_TOTAL", false);
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
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
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
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aryc(this, paramString);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_notify_aio_activity_by_b77"));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      Object localObject = azqu.a(this.jdField_a_of_type_AndroidOsBundle);
      if ((localObject instanceof AbsShareMsg))
      {
        localObject = (AbsShareMsg)localObject;
        this.jdField_a_of_type_Bdfq = arzk.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bdfq, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      }
    }
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    arzk.a(this.jdField_a_of_type_AndroidOsBundle, i, this.jdField_a_of_type_Long);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    f();
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.dismiss();
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
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755801);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371874)).setText(2131695284);
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
    case 5: 
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    d();
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
  }
  
  public int[] a()
  {
    return new int[] { 5, 11 };
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
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status");
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
      return true;
    }
    azmj.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    f();
    arvh.a(this.jdField_a_of_type_AndroidAppActivity, alpo.a(2131705173), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arya
 * JD-Core Version:    0.7.0.1
 */