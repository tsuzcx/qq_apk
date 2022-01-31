import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class arkv
  implements DialogInterface.OnClickListener
{
  arkv(arkq paramarkq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b();
    this.a.a.removeObserver(arkq.a(this.a));
    Intent localIntent = new Intent(this.a.a.getApplication(), LiteActivity.class);
    localIntent.addFlags(67108864);
    this.a.a.getApplication().startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkv
 * JD-Core Version:    0.7.0.1
 */