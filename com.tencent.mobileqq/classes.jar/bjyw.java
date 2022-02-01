import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.filedownload.ui.ApkFileDownloadButton;

public class bjyw
  implements DialogInterface.OnClickListener
{
  public bjyw(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b(false, true);
    paramDialogInterface.dismiss();
    bjto.b(bjtq.a().a("203").k(this.a.a.a).j("5").l(this.a.a.c).m(this.a.a.d).a(this.a.a.h).b(this.a.a.f).g(this.a.a.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyw
 * JD-Core Version:    0.7.0.1
 */