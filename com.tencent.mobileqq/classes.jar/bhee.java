import NS_USER_ACTION_REPORT.UserCommReport;

class bhee
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
  
  public bhee a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bhee a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */