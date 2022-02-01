import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_del_photo_wall_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class bmta
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public bmta(long paramLong1, long paramLong2, String paramString, Long paramLong)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
    mobile_sub_del_photo_wall_req localmobile_sub_del_photo_wall_req = new mobile_sub_del_photo_wall_req();
    PhotoWall localPhotoWall = new PhotoWall();
    localPhotoWall.photoId = paramString;
    localPhotoWall.ctime = paramLong.longValue();
    localmobile_sub_del_photo_wall_req.vecUrls = new ArrayList();
    localmobile_sub_del_photo_wall_req.vecUrls.add(localPhotoWall);
    this.a = localmobile_sub_del_photo_wall_req;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "delPhotoWall");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.delPhotoWall";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "delPhotoWall";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmta
 * JD-Core Version:    0.7.0.1
 */