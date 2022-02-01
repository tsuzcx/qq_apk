import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qzone.util.QZLog;

public class bksq
  extends ReportDialog
{
  bksq(Context paramContext)
  {
    super(paramContext, 2131755682);
    setContentView(2131562264);
    getWindow().setFlags(1024, 2048);
  }
  
  public void a(String paramString)
  {
    ((TextView)findViewById(2131379001)).setText(paramString);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
  
  public void setTitle(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = getContext().getResources().getString(paramInt))
    {
      a(str);
      return;
    }
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException)
    {
      QZLog.w(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksq
 * JD-Core Version:    0.7.0.1
 */