import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class athf
  extends WtloginListener
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public athf(athd paramathd, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_Athd.a(this.jdField_a_of_type_JavaLangString, paramWUserSigInfo, this.b, paramInt1, this.c, this.d);
      return;
    }
    this.jdField_a_of_type_Athd.b(this.b, "getTicket fail code = " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athf
 * JD-Core Version:    0.7.0.1
 */