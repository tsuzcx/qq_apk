import java.lang.ref.WeakReference;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class avzh
  extends WtloginListener
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<avzf> jdField_a_of_type_JavaLangRefWeakReference;
  private String b;
  private String c;
  private String d;
  
  public avzh(avzf paramavzf, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavzf);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (paramInt2 == 0) {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
        ((avzf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramWUserSigInfo, this.b, paramInt1, this.c, this.d);
      }
    }
    while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    ((avzf)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.b, "getTicket fail code = " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzh
 * JD-Core Version:    0.7.0.1
 */