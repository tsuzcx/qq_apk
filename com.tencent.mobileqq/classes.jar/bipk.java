import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bipk
  extends bipd
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private aura jdField_a_of_type_Aura;
  
  public bipk(AppInterface paramAppInterface, Activity paramActivity, bioe parambioe, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambioe, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public bipk(AppInterface paramAppInterface, Activity paramActivity, bioe parambioe, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambioe, paramIntent, paramActivity, paramBoolean);
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
    this.jdField_a_of_type_Aura = new aura(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Aura.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Aura);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipk
 * JD-Core Version:    0.7.0.1
 */