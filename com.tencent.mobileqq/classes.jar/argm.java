import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class argm
  implements DialogInterface.OnClickListener
{
  argm(argh paramargh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    this.a.a.removeObserver(argh.a(this.a));
    Intent localIntent = new Intent(this.a.a.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.a.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argm
 * JD-Core Version:    0.7.0.1
 */