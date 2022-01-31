import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;

public class asls
{
  private int jdField_a_of_type_Int;
  private MsgBackupUserData jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public asls(String paramString1, String paramString2, String paramString3, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData = paramMsgBackupUserData;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupGetQrRsp--");
    localStringBuilder.append(",qr_sig:").append(this.jdField_a_of_type_JavaLangString).append(",token:").append(this.b).append(",encryptKey:").append(this.c).append(",userData:").append(this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupUserData).append(",bizType:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asls
 * JD-Core Version:    0.7.0.1
 */