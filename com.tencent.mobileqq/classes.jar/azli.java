import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class azli
  extends bdvu
{
  public azli(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    long l = parambdvv.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bdbg.a(new File(bdbg.b(l, 4))), "");
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azli
 * JD-Core Version:    0.7.0.1
 */