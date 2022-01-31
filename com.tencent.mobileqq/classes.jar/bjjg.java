import NS_QZONE_MQMSG.QzoneMessageReq;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public class bjjg
  extends bjdo
{
  private int a;
  public JceStruct a;
  
  public bjjg(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    QzoneMessageReq localQzoneMessageReq = new QzoneMessageReq();
    localQzoneMessageReq.uin = paramLong1;
    localQzoneMessageReq.trace_info = paramString;
    localQzoneMessageReq.num = paramLong2;
    localQzoneMessageReq.ext = new HashMap();
    localQzoneMessageReq.ext.put("qua", bjdm.a());
    localQzoneMessageReq.scence = paramInt;
    this.jdField_a_of_type_ComQqTafJceJceStruct = localQzoneMessageReq;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.GetNewMQmsg";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return "GetNewMQmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjg
 * JD-Core Version:    0.7.0.1
 */