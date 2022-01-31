import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class bcdn
  extends bcdg
{
  Activity jdField_a_of_type_AndroidAppActivity;
  private aoyb jdField_a_of_type_Aoyb;
  
  public bcdn(AppInterface paramAppInterface, Activity paramActivity, bccj parambccj, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, parambccj, paramIntent, paramTouchWebView);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public bcdn(AppInterface paramAppInterface, Activity paramActivity, bccj parambccj, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, parambccj, paramIntent, paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppInterface paramAppInterface, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("fromArkAppDownload", false);
    this.jdField_a_of_type_Aoyb = new aoyb(paramAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramTouchWebView);
    this.jdField_a_of_type_Aoyb.a(bool);
    paramTouchWebView.setDownloadListener(this.jdField_a_of_type_Aoyb);
    return super.a(paramTouchWebView, paramAppInterface, paramIntent);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdn
 * JD-Core Version:    0.7.0.1
 */