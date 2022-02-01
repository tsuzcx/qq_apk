import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;

class aoev
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private oidb_0x88d.GroupInfo jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public aoev(aoep paramaoep, String paramString, long paramLong, int paramInt, byte... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aoev a()
  {
    Object localObject = new oidb_0x88d.RspBody();
    ((oidb_0x88d.RspBody)localObject).mergeFrom(this.jdField_a_of_type_ArrayOfByte);
    if ((this.jdField_a_of_type_Int != 0) && (((oidb_0x88d.RspBody)localObject).str_errorinfo.has())) {
      this.jdField_a_of_type_JavaLangString = String.valueOf(((oidb_0x88d.RspBody)localObject).str_errorinfo.get().toByteArray());
    }
    this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo = null;
    localObject = ((oidb_0x88d.RspBody)localObject).stzrspgroupinfo.get();
    int i;
    int j;
    label72:
    oidb_0x88d.RspGroupInfo localRspGroupInfo;
    if (localObject == null)
    {
      i = 0;
      j = 0;
      if ((this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo != null) || (j >= i)) {
        return this;
      }
      localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject).get(j);
      if ((localRspGroupInfo != null) && (localRspGroupInfo.uint64_group_code.get() == this.jdField_a_of_type_Long)) {
        break label134;
      }
    }
    for (;;)
    {
      j += 1;
      break label72;
      i = ((List)localObject).size();
      break;
      label134:
      this.jdField_a_of_type_Int = localRspGroupInfo.uint32_result.get();
      if ((this.jdField_a_of_type_Int == 0) && (localRspGroupInfo.stgroupinfo.has())) {
        this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo = ((oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get());
      }
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public oidb_0x88d.GroupInfo a()
  {
    return this.jdField_a_of_type_TencentImOidbCmd0x88dOidb_0x88d$GroupInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoev
 * JD-Core Version:    0.7.0.1
 */