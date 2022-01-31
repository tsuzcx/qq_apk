import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class axpv
  extends bbwf
{
  public axpv(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    long l = parambbwg.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bbby.a(new File(bbby.b(l, 4))), "");
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpv
 * JD-Core Version:    0.7.0.1
 */