import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class bkqr
  extends aqnu
{
  bkqr(bkqp parambkqp, Activity paramActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
    if ((0x80000000 & paramInt) != 0)
    {
      MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
      return;
    }
    MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqr
 * JD-Core Version:    0.7.0.1
 */