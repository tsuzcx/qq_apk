import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;

public class befe
{
  public long a;
  private befh a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public befe(befh parambefh)
  {
    this.jdField_a_of_type_Befh = parambefh;
  }
  
  public void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_init_webview_plugin", true))) {
      this.jdField_a_of_type_Befh.preInitWebviewPlugin();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_get_key", true))) {
      WebAccelerateHelper.getInstance().preGetKey(paramIntent, paramAppInterface);
    }
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_Befh.buildLayout();
    long l1 = System.currentTimeMillis();
    this.b = (l1 - l2);
    this.jdField_a_of_type_Befh.buildContentView(paramBundle);
    l2 = System.currentTimeMillis();
    this.e = (l2 - l1);
    this.jdField_a_of_type_Befh.buildTitleBar();
    l1 = System.currentTimeMillis();
    this.c = (l1 - l2);
    this.jdField_a_of_type_Befh.buildBottomBar();
    l2 = System.currentTimeMillis();
    this.d = (l2 - l1);
    this.jdField_a_of_type_Befh.buildWebView(paramAppInterface);
    l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Long = (l1 - l2);
    this.jdField_a_of_type_Befh.buildData();
    this.f = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel()) {
      QLog.i("WebViewDirector", 2, "buildLayoutTime : " + this.b + ", buildContentTime " + this.e + ", buildTitleTime " + this.c + ", buildWebViewTime " + this.jdField_a_of_type_Long + ", buildBottomTime " + this.d + ", buildDataTime " + this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befe
 * JD-Core Version:    0.7.0.1
 */