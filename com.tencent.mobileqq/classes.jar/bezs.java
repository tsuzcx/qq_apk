import NS_MINI_REPORT.REPORT.StDcReportRsp;
import NS_MINI_REPORT.REPORT.StGameDcReportRsp;
import NS_MINI_REPORT.REPORT.StThirdDcReportRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import org.json.JSONObject;

public class bezs
  extends bfau
{
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  
  public bezs(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return "mini_app_dcreport";
  }
  
  public JSONObject a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      int i;
      if ("ThirdDcReport".equals(this.b))
      {
        paramArrayOfByte = new REPORT.StThirdDcReportRsp();
        paramArrayOfByte.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
        i = paramArrayOfByte.ret.get();
      }
      while (i == 0)
      {
        return new JSONObject();
        if ("GameDcReport".equals(this.b))
        {
          paramArrayOfByte = new REPORT.StGameDcReportRsp();
          paramArrayOfByte.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
          i = paramArrayOfByte.ret.get();
        }
        else
        {
          paramArrayOfByte = new REPORT.StDcReportRsp();
          paramArrayOfByte.mergeFrom(localStQWebRsp.busiBuff.get().toByteArray());
          i = paramArrayOfByte.ret.get();
        }
      }
      betc.a("ProtoBufRequest", "onResponse fail.retCode = " + i);
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      betc.a("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  protected String b()
  {
    if (this.b != null) {
      return this.b;
    }
    return "DcReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezs
 * JD-Core Version:    0.7.0.1
 */