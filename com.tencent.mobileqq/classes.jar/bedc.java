import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bedc
  extends becv
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private aqrd jdField_a_of_type_Aqrd;
  
  public bedc(AppInterface paramAppInterface, Activity paramActivity, beby parambeby, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambeby, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public bedc(AppInterface paramAppInterface, Activity paramActivity, beby parambeby, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambeby, paramIntent, paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
  }
  
  public void b()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_Aqrd = new aqrd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aqrd.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Aqrd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedc
 * JD-Core Version:    0.7.0.1
 */