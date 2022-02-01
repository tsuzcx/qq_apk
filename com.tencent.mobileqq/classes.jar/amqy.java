import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x58b.cmd0x58b.CmdErrorCode;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoRsp;
import tencent.im.oidb.cmd0x58b.cmd0x58b.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class amqy
{
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, amra> jdField_a_of_type_JavaUtilHashMap;
  private List<cmd0x58b.GetConfInfoRsp> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public amqy(byte[] paramArrayOfByte, ArrayList<Object> paramArrayList, HashMap<String, amra> paramHashMap)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramHashMap;
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
  }
  
  public amqy a()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      if ((!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "sso check fail " + localOIDBSSOPkg.uint32_result.get());
        }
        this.jdField_a_of_type_Amqx.notifyUI(1001, false, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.dscs", 2, "merge fail " + localInvalidProtocolBufferMicroException1.toString());
      }
      this.jdField_a_of_type_Amqx.notifyUI(1001, false, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    cmd0x58b.RspBody localRspBody = new cmd0x58b.RspBody();
    try
    {
      localRspBody.mergeFrom(localInvalidProtocolBufferMicroException1.bytes_bodybuffer.get().toByteArray());
      if (localRspBody.msg_cmd_error_code.uint32_code.get() != 0)
      {
        this.jdField_a_of_type_Amqx.a(this.jdField_a_of_type_JavaUtilHashMap.values());
        this.jdField_a_of_type_Amqx.notifyUI(1001, false, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.dscs", 2, "rspBody merge fail " + localInvalidProtocolBufferMicroException2.toString());
      }
      this.jdField_a_of_type_Amqx.notifyUI(1001, false, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    Object localObject;
    if (localRspBody.msg_get_multi_conf_info.has())
    {
      localObject = (cmd0x58b.GetMultiConfInfoRsp)localRspBody.msg_get_multi_conf_info.get();
      if (localObject == null) {
        break label370;
      }
      if (!((cmd0x58b.GetMultiConfInfoRsp)localObject).msg_get_conf_info.has()) {
        break label365;
      }
      localObject = ((cmd0x58b.GetMultiConfInfoRsp)localObject).msg_get_conf_info.get();
    }
    label348:
    label365:
    label370:
    for (this.jdField_a_of_type_JavaUtilList = ((List)localObject);; this.jdField_a_of_type_JavaUtilList = null)
    {
      this.jdField_a_of_type_Boolean = false;
      return this;
      localObject = null;
      break;
      localObject = null;
      break label348;
    }
  }
  
  public List<cmd0x58b.GetConfInfoRsp> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqy
 * JD-Core Version:    0.7.0.1
 */