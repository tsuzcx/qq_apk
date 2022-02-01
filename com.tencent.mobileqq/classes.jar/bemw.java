import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class bemw
  implements DialogInterface.OnClickListener
{
  bemw(bemy parambemy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
    bemv.a().edit().putBoolean("KEY_WRITE_TOGETHER_IS_FIRST_USE_", false).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemw
 * JD-Core Version:    0.7.0.1
 */