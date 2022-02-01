import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class avua
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public avua(String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData = paramMsgBackupUserData;
    this.jdField_a_of_type_Int = paramInt;
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
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupConfirmQrRsp--");
    localStringBuilder.append(",token:").append(this.jdField_a_of_type_JavaLangString).append(",encryptKey:").append(this.b).append(",userData:").append(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData).append(",bizType:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avua
 * JD-Core Version:    0.7.0.1
 */