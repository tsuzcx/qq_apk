import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bhop
  extends bhoi
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private atzf jdField_a_of_type_Atzf;
  
  public bhop(AppInterface paramAppInterface, Activity paramActivity, bhnj parambhnj, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambhnj, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  public bhop(AppInterface paramAppInterface, Activity paramActivity, bhnj parambhnj, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambhnj, paramIntent, paramActivity, paramBoolean);
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
    this.jdField_a_of_type_Atzf = new atzf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Atzf.a(bool);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(this.jdField_a_of_type_Atzf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhop
 * JD-Core Version:    0.7.0.1
 */