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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aqbz
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
    aqca localaqca;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("sdk_mult_share", false));
      aqgj.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865);
        bcql.a(localQQAppInterface.getApp(), 2, 2131692756, 0).b(i);
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      localaqca = new aqca(paramIntent, i, paramActivity, localQQAppInterface);
      QLog.d("ForwardDialogMgr", 1, new Object[] { "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(i), ", count=", str });
      if (901503 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localaqca);
        return;
      }
      if (i == 0)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        a(paramActivity, paramIntent, ajya.a(2131719427), localaqca);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, ajya.a(2131719426), localaqca);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.a(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, localaqca);
        return;
      }
    } while (3 != i);
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
    a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), localaqca);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = bbdj.a(paramActivity, 232, null, paramString, aqfv.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), ajya.a(2131719422), paramOnClickListener, paramOnClickListener);
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
    bbhz localbbhz = new bbhz(paramActivity, 2131755791);
    localbbhz.setContentView(2131558913);
    localbbhz.a(localQQAppInterface, paramActivity, paramList, false);
    localbbhz.c(String.format(paramActivity.getResources().getString(2131719423), new Object[] { Integer.valueOf(paramList.size()) }));
    localbbhz.c();
    localbbhz.setNegativeButton(aqfv.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localbbhz.setPositiveButton(ajya.a(2131719422), paramOnClickListener);
    localbbhz.findViewById(2131377367).setVisibility(8);
    localbbhz.show();
  }
  
  private static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
      return;
    }
    paramActivity = bbdj.a(paramActivity, 230);
    paramActivity.setMessage(paramString);
    paramActivity.setPositiveButton(2131694794, paramOnClickListener);
    paramActivity.show();
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new Dialog(paramActivity, 2131755791);
    this.a.setCancelable(false);
    this.a.setContentView(2131559386);
    paramActivity = ajya.a(2131719424);
    ((TextView)this.a.findViewById(2131371557)).setText(paramActivity);
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
 * Qualified Name:     aqbz
 * JD-Core Version:    0.7.0.1
 */