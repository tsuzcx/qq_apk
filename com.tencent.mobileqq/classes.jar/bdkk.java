import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class bdkk
  extends biht
{
  public bdkk(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    long l = parambihu.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bhkt.a(new File(bhkt.b(l, 4))), "");
  }
  
  public boolean onStart(bihu parambihu)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkk
 * JD-Core Version:    0.7.0.1
 */