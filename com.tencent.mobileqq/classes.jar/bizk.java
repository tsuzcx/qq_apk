import NS_MOBILE_PHOTO.get_albumlist_num_req;
import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class bizk
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public bizk(long paramLong, String paramString)
  {
    super.setRefer(paramString);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    paramString = new get_albumlist_num_req();
    paramString.uin = paramLong;
    this.a = paramString;
  }
  
  public static get_albumlist_num_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    get_albumlist_num_rsp localget_albumlist_num_rsp;
    do
    {
      return paramArrayOfByte;
      localget_albumlist_num_rsp = (get_albumlist_num_rsp)decode(paramArrayOfByte, "getAlbumListNum");
      paramArrayOfByte = localget_albumlist_num_rsp;
    } while (localget_albumlist_num_rsp != null);
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAlbumListNum";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAlbumListNum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bizk
 * JD-Core Version:    0.7.0.1
 */