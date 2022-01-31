import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.widget.soload.LoadExtResult;

class besk
  implements besg
{
  public long a;
  public besc a;
  public besg a;
  
  besk(besg parambesg, long paramLong, besc parambesc)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Besg = parambesg;
    this.jdField_a_of_type_Besc = parambesc;
  }
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
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
      awqx.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, 0, str, "", "", "");
      if ((this.jdField_a_of_type_Besg != null) && (paramInt != 8)) {
        this.jdField_a_of_type_Besg.a(paramInt, paramLoadExtResult);
      }
      besi.a(this.jdField_a_of_type_Besc);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besk
 * JD-Core Version:    0.7.0.1
 */