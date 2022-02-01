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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class auyp
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
    auyq localauyq;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("sdk_mult_share", false));
      avcw.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299011);
        QQToast.a(localQQAppInterface.getApp(), 2, 2131692401, 0).b(i);
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      localauyq = new auyq(paramIntent, i, paramActivity, localQQAppInterface);
      QLog.d("ForwardDialogMgr", 1, new Object[] { "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(i), ", count=", str });
      if (901503 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localauyq);
        return;
      }
      if (i == 0)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        a(paramActivity, paramIntent, anzj.a(2131718003), localauyq);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, anzj.a(2131718002), localauyq);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.a(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, localauyq);
        return;
      }
    } while (3 != i);
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
    a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localauyq);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = bhlq.a(paramActivity, 232, null, paramString, avcj.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), anzj.a(2131717998), paramOnClickListener, paramOnClickListener);
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
    bhqi localbhqi = new bhqi(paramActivity, 2131755824);
    localbhqi.setContentView(2131559016);
    localbhqi.a(localQQAppInterface, paramActivity, paramList, false);
    localbhqi.c(String.format(paramActivity.getResources().getString(2131717999), new Object[] { Integer.valueOf(paramList.size()) }));
    localbhqi.c();
    localbhqi.setNegativeButton(avcj.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localbhqi.setPositiveButton(anzj.a(2131717998), paramOnClickListener);
    localbhqi.findViewById(2131378954).setVisibility(8);
    localbhqi.show();
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ForwardDialogMgr", 1, new Object[] { "showOtherErrorDialog errorMsg=", paramString });
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
      return;
    }
    paramActivity = bhlq.a(paramActivity, 230);
    paramActivity.setMessage(paramString);
    paramActivity.setPositiveButton(2131694098, paramOnClickListener);
    paramActivity.show();
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new ReportDialog(paramActivity, 2131755824);
    this.a.setCancelable(false);
    this.a.setContentView(2131559572);
    paramActivity = anzj.a(2131718000);
    ((TextView)this.a.findViewById(2131372578)).setText(paramActivity);
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
 * Qualified Name:     auyp
 * JD-Core Version:    0.7.0.1
 */