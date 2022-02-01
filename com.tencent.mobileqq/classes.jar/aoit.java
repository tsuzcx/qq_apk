import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class aoit
{
  private int jdField_a_of_type_Int;
  private oidb_sso.OIDBSSOPkg jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public aoit(aoip paramaoip, byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aoit a()
  {
    this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg = ((oidb_sso.OIDBSSOPkg)this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.mergeFrom(this.jdField_a_of_type_ArrayOfByte));
      if (this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg != null)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          QLog.d("TroopHandler", 2, "oidb_sso.OIDBSSOPkg(oidb_0x88d_7): {\n" + aode.proto2String(this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg) + "}");
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result " + this.jdField_a_of_type_Int);
        }
      }
      return this;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso parseFrom byte " + localInvalidProtocolBufferMicroException.toString());
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public oidb_sso.OIDBSSOPkg a()
  {
    return this.jdField_a_of_type_TencentImOidbOidb_sso$OIDBSSOPkg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoit
 * JD-Core Version:    0.7.0.1
 */