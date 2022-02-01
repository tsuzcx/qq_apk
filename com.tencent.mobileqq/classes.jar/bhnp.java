import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class bhnp
  implements DialogInterface.OnClickListener
{
  public bhnp(WebViewFragment paramWebViewFragment, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhnp
 * JD-Core Version:    0.7.0.1
 */