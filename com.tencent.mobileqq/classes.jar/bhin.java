import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.receiver.WebProcessReceiver;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;

public class bhin
  extends bhlt
{
  private static int jdField_b_of_type_Int = 100;
  private static int jdField_c_of_type_Int = 110;
  private static int d = 120;
  private static int e = 121;
  private static int f = 122;
  private static int g = 177;
  private static int h = 200;
  private static int i = 220;
  private static int j = 232;
  protected Handler a;
  public boolean a;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private final int k = 30000;
  private int l;
  
  public bhin(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public static String a()
  {
    localObject3 = null;
    try
    {
      String str = AppLoaderFactory.g().getProcessName();
      localObject1 = localObject3;
      if (str.contains(":")) {
        localObject1 = str.substring(str.indexOf(":") + 1);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        QMLog.e("minisdk-start", "getSubProcessName exception!", localThrowable);
        Object localObject2 = localObject3;
      }
    }
    localObject3 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject3 = "mini";
    }
    return localObject3;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    QMLog.i("minisdk-start", "startTbs");
    int m = QbSdk.getTbsVersion(this.jdField_a_of_type_AndroidContentContext);
    int n = QbSdk.getTmpDirTbsVersion(this.jdField_a_of_type_AndroidContentContext);
    QMLog.i("minisdk-start", "tbsVersion=" + m + " tmpDirTbsVersion=" + n + ",data_directory_suffix:" + a());
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data_directory_suffix", a());
    QbSdk.initTbsSettings((Map)localObject);
    this.jdField_a_of_type_Boolean = false;
    if ((m > 0) || (n > 0))
    {
      c();
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      QMLog.i("minisdk-start", "X5 isn't completed， use system core。");
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      ((Intent)localObject).putExtra("isDownloadForeground", this.jdField_b_of_type_Boolean);
      ((Intent)localObject).putExtra("fromMiniApp", true);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
      c();
      return;
    }
    a().sendEmptyMessageDelayed(7, 30000L);
    this.l = 0;
    localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_AndroidContentContext.getPackageName() + "_preferences", 4);
    ((SharedPreferences)localObject).edit().remove("tbs_download_complete").commit();
    ((SharedPreferences)localObject).edit().remove("tbs_download_progress").commit();
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, WebProcessReceiver.class);
    ((Intent)localObject).setAction("action_download_tbs");
    ((Intent)localObject).putExtra("isDownloadForeground", this.jdField_b_of_type_Boolean);
    ((Intent)localObject).putExtra("fromMiniApp", true);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
    QMLog.d("minisdk-start", "start WebProcessReceiver isDownloadForeground" + this.jdField_b_of_type_Boolean);
    a().sendEmptyMessageDelayed(6, 1000L);
  }
  
  public void c()
  {
    a().removeMessages(7);
    super.c();
  }
  
  public void d()
  {
    int m = QbSdk.getTbsVersion(this.jdField_a_of_type_AndroidContentContext);
    int n = QbSdk.getTmpDirTbsVersion(this.jdField_a_of_type_AndroidContentContext);
    QMLog.d("minisdk-start", "getTbsVersion=" + m + " tmpDirTbsVersion=" + n);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_AndroidContentContext.getPackageName() + "_preferences", 4);
    int i1 = ((SharedPreferences)localObject).getInt("tbs_download_complete", -1);
    QMLog.i("minisdk-start", "tbs download result: " + i1);
    if (((i1 == j) || (i1 == i)) && ((m > 0) || (n > 0)))
    {
      a().removeMessages(6);
      c();
    }
    do
    {
      return;
      if (i1 != -1)
      {
        a().removeMessages(6);
        e();
        return;
      }
      m = ((SharedPreferences)localObject).getInt("tbs_download_progress", 0);
      QMLog.d("minisdk-start", "tbs download progress " + m);
      if (m > this.l)
      {
        this.l = m;
        a().removeMessages(7);
        a().sendEmptyMessageDelayed(7, 30000L);
        localObject = Message.obtain();
        ((Message)localObject).what = 3;
        ((Message)localObject).arg1 = m;
      }
    } while (c());
    a().sendEmptyMessageDelayed(6, 1000L);
  }
  
  public void e()
  {
    a().removeMessages(7);
    if (this.jdField_a_of_type_Boolean) {}
    QMLog.d("minisdk-start", "TbsAsyncTask failed! Work continue as same as succeed anyway. ");
    super.c();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d();
      continue;
      int m = QbSdk.getTbsVersion(this.jdField_a_of_type_AndroidContentContext);
      int n = QbSdk.getTmpDirTbsVersion(this.jdField_a_of_type_AndroidContentContext);
      QMLog.d("minisdk-start", "X5安装超时 tbsVersion=" + m + " tmpDirTbsVersion=" + n);
      if ((m > 0) || (n > 0))
      {
        c();
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhin
 * JD-Core Version:    0.7.0.1
 */