import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x6e7.oidb_0x6e7.ReqBody;

public class arcy
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return "http://" + paramString1 + "/ftn_handler/" + paramString2 + "/?fname=" + bdcv.b(paramString3) + paramString5;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, arda paramarda)
  {
    if (paramLong < 0L) {
      return;
    }
    oidb_0x6e7.ReqBody localReqBody = new oidb_0x6e7.ReqBody();
    localReqBody.uint64_group_code.set(paramLong);
    localReqBody.str_app_src.set("android");
    localReqBody.str_version.set("8.3.3");
    mzy.b(paramQQAppInterface, new arcz(paramarda), localReqBody.toByteArray(), "OidbSvc.oidb_0x6e7", 1767, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcy
 * JD-Core Version:    0.7.0.1
 */