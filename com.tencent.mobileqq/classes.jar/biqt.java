import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.4.1;

public class biqt
  implements DialogInterface.OnClickListener
{
  biqt(biqq parambiqq, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.excute(new SwiftBrowserShareMenuHandler.4.1(this), 128, null, false);
    biqq.a(this.jdField_a_of_type_Biqq, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqt
 * JD-Core Version:    0.7.0.1
 */