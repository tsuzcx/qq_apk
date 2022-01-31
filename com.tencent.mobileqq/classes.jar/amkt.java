import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.Window;
import com.tencent.qphone.base.util.BaseApplication;

public final class amkt
  implements Runnable
{
  public amkt(String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = new AlertDialog.Builder(BaseApplication.getContext());
    ((AlertDialog.Builder)localObject).setMessage(this.a).setTitle(this.b);
    localObject = ((AlertDialog.Builder)localObject).create();
    ((AlertDialog)localObject).getWindow().setType(2003);
    try
    {
      ((AlertDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkt
 * JD-Core Version:    0.7.0.1
 */