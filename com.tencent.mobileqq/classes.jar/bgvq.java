import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bgvq
  extends bgvj
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private atdi jdField_a_of_type_Atdi;
  
  public bgvq(AppInterface paramAppInterface, Activity paramActivity, bguk parambguk, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambguk, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public bgvq(AppInterface paramAppInterface, Activity paramActivity, bguk parambguk, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambguk, paramIntent, paramActivity, paramBoolean);
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
    this.jdField_a_of_type_Atdi = new atdi(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Atdi.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Atdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvq
 * JD-Core Version:    0.7.0.1
 */