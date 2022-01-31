import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bceb
  extends bcdu
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private aoyf jdField_a_of_type_Aoyf;
  
  public bceb(AppInterface paramAppInterface, Activity paramActivity, bccx parambccx, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambccx, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bceb(AppInterface paramAppInterface, Activity paramActivity, bccx parambccx, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambccx, paramIntent, paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppInterface paramAppInterface, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_Aoyf = new aoyf(paramAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramTouchWebView);
    this.jdField_a_of_type_Aoyf.a(bool);
    paramTouchWebView.setDownloadListener(this.jdField_a_of_type_Aoyf);
    return super.a(paramTouchWebView, paramAppInterface, paramIntent);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bceb
 * JD-Core Version:    0.7.0.1
 */