import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class asly
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public asly(int paramInt1, String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData = paramMsgBackupUserData;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public MsgBackupUserData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupQryStateRsp--");
    localStringBuilder.append(",state:").append(this.jdField_a_of_type_Int).append(",token:").append(this.jdField_a_of_type_JavaLangString).append(",encryptKey:").append(this.jdField_b_of_type_JavaLangString).append(",userData:").append(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData).append(",bizType:").append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asly
 * JD-Core Version:    0.7.0.1
 */