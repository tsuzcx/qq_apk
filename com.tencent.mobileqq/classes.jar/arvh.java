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
import java.util.ArrayList;
import java.util.List;

public class arvh
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
    arvi localarvi;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("sdk_mult_share", false));
      arzy.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914);
        QQToast.a(localQQAppInterface.getApp(), 2, 2131692838, 0).b(i);
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      localarvi = new arvi(paramIntent, i, paramActivity, localQQAppInterface);
      QLog.d("ForwardDialogMgr", 1, new Object[] { "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(i), ", count=", str });
      if (901503 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localarvi);
        return;
      }
      if (i == 0)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        a(paramActivity, paramIntent, alpo.a(2131719915), localarvi);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, alpo.a(2131719914), localarvi);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.a(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, localarvi);
        return;
      }
    } while (3 != i);
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
    a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localarvi);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = bdcd.a(paramActivity, 232, null, paramString, arzk.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), alpo.a(2131719910), paramOnClickListener, paramOnClickListener);
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
    bdgv localbdgv = new bdgv(paramActivity, 2131755801);
    localbdgv.setContentView(2131558950);
    localbdgv.a(localQQAppInterface, paramActivity, paramList, false);
    localbdgv.c(String.format(paramActivity.getResources().getString(2131719911), new Object[] { Integer.valueOf(paramList.size()) }));
    localbdgv.c();
    localbdgv.setNegativeButton(arzk.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localbdgv.setPositiveButton(alpo.a(2131719910), paramOnClickListener);
    localbdgv.findViewById(2131377901).setVisibility(8);
    localbdgv.show();
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
      return;
    }
    paramActivity = bdcd.a(paramActivity, 230);
    paramActivity.setMessage(paramString);
    paramActivity.setPositiveButton(2131694951, paramOnClickListener);
    paramActivity.show();
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new Dialog(paramActivity, 2131755801);
    this.a.setCancelable(false);
    this.a.setContentView(2131559438);
    paramActivity = alpo.a(2131719912);
    ((TextView)this.a.findViewById(2131371874)).setText(paramActivity);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvh
 * JD-Core Version:    0.7.0.1
 */