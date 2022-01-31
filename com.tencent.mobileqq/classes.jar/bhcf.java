import GIFT_MALL_PROTOCOL.doufu_piece_req;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.Map;

public class bhcf
  extends QzoneExternalRequest
{
  private doufu_piece_req a;
  
  public bhcf(long paramLong, Map<String, String> paramMap)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.a = new doufu_piece_req(paramLong, paramMap);
  }
  
  public static doufu_piece_rsp a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramArrayOfInt = (doufu_piece_rsp)decode(paramArrayOfByte, "getDofuPieceInfo", paramArrayOfInt);
      paramArrayOfByte = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getDofuPieceInfo";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getDofuPieceInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhcf
 * JD-Core Version:    0.7.0.1
 */