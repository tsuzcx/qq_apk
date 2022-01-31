import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class axpx
  extends bbwt
{
  public axpx(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    long l = parambbwu.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bbcm.a(new File(bbcm.b(l, 4))), "");
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpx
 * JD-Core Version:    0.7.0.1
 */