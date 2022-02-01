import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class bcde
  extends bgod
{
  public bcde(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    long l = parambgoe.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bfua.a(new File(bfua.b(l, 4))), "");
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcde
 * JD-Core Version:    0.7.0.1
 */