import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webdownload.DownloadURLCheck.ReqDownloadUrlCheckRecmd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class aqrd
  implements DialogInterface.OnDismissListener, Handler.Callback, DownloadListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<Activity> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private WeakReference<TouchWebView> c;
  
  public aqrd(AppInterface paramAppInterface, Activity paramActivity, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.c = new WeakReference(paramTouchWebView);
    if (paramTouchWebView == null) {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "constructor: webview is null");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
        paramMessage = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      } while ((paramMessage == null) || (paramMessage.isFinishing()));
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramMessage);
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561636);
        this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363189).setBackgroundColor(0);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377552)).setText(alpo.a(2131716271));
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
    } while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing()));
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    return true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    Object localObject2 = (TouchWebView)this.c.get();
    Activity localActivity = (Activity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject2 == null) || (localActivity == null) || (localObject1 == null) || (localActivity.isFinishing())) {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "download failed, webview=" + localObject2 + ", act=" + localActivity + ", app=" + localObject1);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      if ((((TouchWebView)localObject2).getUrl() != null) && (((TouchWebView)localObject2).getUrl().equals(paramString1))) {
        bool = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start UniformDownloadActivity: " + paramString4);
        }
        if ("application/vnd.android.package-archive".equals(paramString4))
        {
          if (!bool) {
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
          }
          paramString2 = new DownloadURLCheck.ReqDownloadUrlCheckRecmd();
          paramString2.download_url.set(paramString1);
          paramString2.mime_type.set(paramString4);
          try
          {
            paramString2.uin.set(Long.parseLong(((AppInterface)localObject1).getCurrentAccountUin()));
            paramString3 = new NewIntent(localActivity.getApplicationContext(), atfx.class);
            paramString3.putExtra("extra_cmd", "QQApkSvc.check_download_url");
            paramString3.putExtra("extra_data", paramString2.toByteArray());
            paramString3.setObserver(new aqre(this, paramString1, paramLong, bool));
            ((AppInterface)localObject1).startServlet(paramString3);
            return;
            bool = false;
          }
          catch (NumberFormatException paramString3)
          {
            for (;;)
            {
              QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramString3, new Object[0]);
            }
          }
        }
      }
      localObject1 = ((TouchWebView)localObject2).getUrl();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("_filesize", paramLong);
      ((Bundle)localObject2).putString("param_user_agent", paramString2);
      ((Bundle)localObject2).putString("param_content_des", paramString3);
      ((Bundle)localObject2).putString("param_mime_type", paramString4);
      ((Bundle)localObject2).putString("param_refer_url", (String)localObject1);
      ((Bundle)localObject2).putBoolean("fromArkAppDownload", this.jdField_a_of_type_Boolean);
    } while ((!aqrb.a(localActivity, paramString1, (Bundle)localObject2)) || (!bool));
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrd
 * JD-Core Version:    0.7.0.1
 */