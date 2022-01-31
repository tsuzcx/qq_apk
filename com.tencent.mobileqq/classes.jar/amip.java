import cooperation.qzone.report.lp.LpReport_PicInfo_dc02153;
import cooperation.qzone.report.lp.MachinelearningReport;

public class amip
  implements Runnable
{
  public amip(MachinelearningReport paramMachinelearningReport, LpReport_PicInfo_dc02153 paramLpReport_PicInfo_dc02153) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_CooperationQzoneReportLpLpReport_PicInfo_dc02153 != null)
    {
      this.jdField_a_of_type_CooperationQzoneReportLpLpReport_PicInfo_dc02153.recheckIfNeed();
      MachinelearningReport.access$000(this.jdField_a_of_type_CooperationQzoneReportLpMachinelearningReport, 16, this.jdField_a_of_type_CooperationQzoneReportLpLpReport_PicInfo_dc02153);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amip
 * JD-Core Version:    0.7.0.1
 */