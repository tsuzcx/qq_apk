import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class bdjz
  extends bhyn
{
  public bdjz(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    long l = parambhyo.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, bhcs.a(new File(bhcs.b(l, 4))), "");
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjz
 * JD-Core Version:    0.7.0.1
 */