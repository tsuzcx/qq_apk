import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class auqo
{
  private Dialog a;
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("ForwardDialogMgr", 1, "-->showMultShareDialog: (null == activity) || activity.isFinishing()");
    }
    String str;
    QQAppInterface localQQAppInterface;
    int i;
    auqp localauqp;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("sdk_mult_share", false));
      auuv.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080);
        QQToast.a(localQQAppInterface.getApp(), 2, 2131692551, 0).b(i);
        ForwardUtils.report(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      localauqp = new auqp(paramIntent, i, paramActivity, localQQAppInterface);
      QLog.d("ForwardDialogMgr", 1, new Object[] { "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(i), ", count=", str });
      if (901503 == i)
      {
        ForwardUtils.report(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localauqp);
        return;
      }
      if (i == 0)
      {
        ForwardUtils.report(localQQAppInterface, "0X800A738", new String[] { str });
        a(paramActivity, paramIntent, anvx.a(2131718630), localauqp);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.report(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, anvx.a(2131718629), localauqp);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.report(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, localauqp);
        return;
      }
    } while (3 != i);
    ForwardUtils.report(localQQAppInterface, "0X800A739", new String[] { str });
    a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localauqp);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = bhdj.a(paramActivity, 232, null, paramString, auui.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), anvx.a(2131718625), paramOnClickListener, paramOnClickListener);
    try
    {
      paramActivity.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("ForwardDialogMgr", 1, "-->showShareResultDialog: failed. ", paramActivity);
    }
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, List<ResultRecord> paramList, DialogInterface.OnClickListener paramOnClickListener)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QQCustomDialogWtihForwardAvatar localQQCustomDialogWtihForwardAvatar = new QQCustomDialogWtihForwardAvatar(paramActivity, 2131755829);
    localQQCustomDialogWtihForwardAvatar.setContentView(2131559052);
    localQQCustomDialogWtihForwardAvatar.showForwardTargetAvatar(localQQAppInterface, paramActivity, paramList, false);
    localQQCustomDialogWtihForwardAvatar.setAvatarTitle(String.format(paramActivity.getResources().getString(2131718626), new Object[] { Integer.valueOf(paramList.size()) }));
    localQQCustomDialogWtihForwardAvatar.adjustMultiForwardMargins();
    localQQCustomDialogWtihForwardAvatar.setNegativeButton(auui.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.setPositiveButton(anvx.a(2131718625), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.findViewById(2131379019).setVisibility(8);
    localQQCustomDialogWtihForwardAvatar.show();
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ForwardDialogMgr", 1, new Object[] { "showOtherErrorDialog errorMsg=", paramString });
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
      return;
    }
    paramActivity = bhdj.a(paramActivity, 230);
    paramActivity.setMessage(paramString);
    paramActivity.setPositiveButton(2131694399, paramOnClickListener);
    paramActivity.show();
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new ReportDialog(paramActivity, 2131755829);
    this.a.setCancelable(false);
    this.a.setContentView(2131559607);
    paramActivity = anvx.a(2131718627);
    ((TextView)this.a.findViewById(2131372740)).setText(paramActivity);
    this.a.show();
  }
  
  void b(Activity paramActivity)
  {
    if ((!paramActivity.isFinishing()) && (this.a != null) && (this.a.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqo
 * JD-Core Version:    0.7.0.1
 */