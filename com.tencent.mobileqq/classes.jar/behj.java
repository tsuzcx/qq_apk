import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

final class behj
  implements DialogInterface.OnClickListener
{
  behj(String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = behh.a();
    if (paramDialogInterface != null) {
      ((aoei)paramDialogInterface.getBusinessHandler(BusinessHandlerFactory.THEME_HANDLER)).a(this.a, this.b);
    }
    behh.a("0X800A5B6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behj
 * JD-Core Version:    0.7.0.1
 */