import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadExtResult;

class axni
  implements axne
{
  public long a;
  public axna a;
  public axne a;
  
  axni(axne paramaxne, long paramLong, axna paramaxna)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Axne = paramaxne;
    this.jdField_a_of_type_Axna = paramaxna;
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
      axqw.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      if ((this.jdField_a_of_type_Axne != null) && (paramInt != 8)) {
        this.jdField_a_of_type_Axne.onLoadResult(paramInt, paramLoadExtResult);
      }
      axng.a(this.jdField_a_of_type_Axna);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axni
 * JD-Core Version:    0.7.0.1
 */