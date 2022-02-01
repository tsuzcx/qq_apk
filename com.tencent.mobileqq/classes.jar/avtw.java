import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qphone.base.util.QLog;

public class avtw
  implements DialogInterface.OnClickListener
{
  public avtw(HotPicPageView paramHotPicPageView, avub paramavub) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Avub.a(-11);
    QLog.d("HotPicManagerHotPicPageView", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtw
 * JD-Core Version:    0.7.0.1
 */