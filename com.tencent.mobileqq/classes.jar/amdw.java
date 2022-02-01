import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;

class amdw
  implements DialogInterface.OnClickListener
{
  amdw(amdv paramamdv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdla.b(null, "dc00898", "", "", "0X800A0C7", "0X800A0C7", 0, 0, String.valueOf(SessionClearFragment.b(this.a.a)), String.valueOf(SessionClearFragment.c(this.a.a)), "", "");
    SessionClearFragment.a(this.a.a);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("extra_delete_total_file_size", SessionClearFragment.a(this.a.a).a());
    Activity localActivity = SessionClearFragment.a(this.a.a);
    SessionClearFragment.a(this.a.a);
    localActivity.setResult(-1, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */