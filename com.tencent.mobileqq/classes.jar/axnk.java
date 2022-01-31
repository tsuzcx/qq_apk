import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadExtResult;

class axnk
  implements axng
{
  public long a;
  public axnc a;
  public axng a;
  
  axnk(axng paramaxng, long paramLong, axnc paramaxnc)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Axng = paramaxng;
    this.jdField_a_of_type_Axnc = paramaxnc;
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label97;
      }
    }
    label97:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        VACDReportUtil.endReport(this.jdField_a_of_type_Long, "load.end", str, i, null);
      }
      axqy.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      if ((this.jdField_a_of_type_Axng != null) && (paramInt != 8)) {
        this.jdField_a_of_type_Axng.onLoadResult(paramInt, paramLoadExtResult);
      }
      axni.a(this.jdField_a_of_type_Axnc);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnk
 * JD-Core Version:    0.7.0.1
 */