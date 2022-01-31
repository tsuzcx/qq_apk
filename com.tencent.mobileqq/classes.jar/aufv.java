import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class aufv
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public aufv(long paramLong, operation_red_touch_req paramoperation_red_touch_req)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.a = paramoperation_red_touch_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.asy_photo.OperationRedTouch";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "OperationRedTouch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aufv
 * JD-Core Version:    0.7.0.1
 */