import NS_USER_ACTION_REPORT.UserCommReport;

class bjkm
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public UserCommReport a()
  {
    UserCommReport localUserCommReport = new UserCommReport();
    localUserCommReport.uin = this.jdField_a_of_type_Long;
    localUserCommReport.platform = "AND";
    localUserCommReport.client_type = "SQ";
    localUserCommReport.network_type = this.jdField_a_of_type_JavaLangString;
    return localUserCommReport;
  }
  
  public bjkm a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bjkm a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjkm
 * JD-Core Version:    0.7.0.1
 */