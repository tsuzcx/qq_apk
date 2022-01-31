import NS_MOBILE_OPERATION.operation_like_req;
import com.qq.taf.jce.JceStruct;

public class bfun
  extends bfpm
{
  private int a;
  public JceStruct a;
  
  public bfun(Long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    operation_like_req localoperation_like_req = new operation_like_req();
    localoperation_like_req.uin = paramLong.longValue();
    localoperation_like_req.action = paramInt1;
    localoperation_like_req.appid = paramInt2;
    localoperation_like_req.curkey = paramString1;
    localoperation_like_req.unikey = paramString2;
    this.jdField_a_of_type_ComQqTafJceJceStruct = localoperation_like_req;
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
    return "QzoneNewService.like";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return "like";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfun
 * JD-Core Version:    0.7.0.1
 */