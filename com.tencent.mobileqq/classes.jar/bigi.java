import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bigi
  extends bigb
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private auhp jdField_a_of_type_Auhp;
  
  public bigi(AppInterface paramAppInterface, Activity paramActivity, bifc parambifc, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambifc, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public bigi(AppInterface paramAppInterface, Activity paramActivity, bifc parambifc, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambifc, paramIntent, paramActivity, paramBoolean);
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
    this.jdField_a_of_type_Auhp = new auhp(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Auhp.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Auhp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigi
 * JD-Core Version:    0.7.0.1
 */