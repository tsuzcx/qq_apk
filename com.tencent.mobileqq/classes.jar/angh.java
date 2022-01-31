import cooperation.qzone.report.lp.LpReportInfo;
import cooperation.qzone.report.lp.LpReportManager;

public class angh
  implements Runnable
{
  int jdField_a_of_type_Int;
  LpReportInfo jdField_a_of_type_CooperationQzoneReportLpLpReportInfo;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public angh(LpReportManager paramLpReportManager, int paramInt, LpReportInfo paramLpReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo = paramLpReportInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    LpReportManager.access$000(this.jdField_a_of_type_CooperationQzoneReportLpLpReportManager, this.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo, this.jdField_a_of_type_Boolean, this.b);
    LpReportManager localLpReportManager = this.jdField_a_of_type_CooperationQzoneReportLpLpReportManager;
    localLpReportManager.mRunningTaskNum -= 1;
    LpReportManager.access$100(this.jdField_a_of_type_CooperationQzoneReportLpLpReportManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angh
 * JD-Core Version:    0.7.0.1
 */