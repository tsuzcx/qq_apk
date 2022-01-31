import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class behl
  extends behe
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private aqvm jdField_a_of_type_Aqvm;
  
  public behl(AppInterface paramAppInterface, Activity paramActivity, begh parambegh, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambegh, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public behl(AppInterface paramAppInterface, Activity paramActivity, begh parambegh, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambegh, paramIntent, paramActivity, paramBoolean);
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
    this.jdField_a_of_type_Aqvm = new aqvm(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aqvm.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Aqvm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behl
 * JD-Core Version:    0.7.0.1
 */