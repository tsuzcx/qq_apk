import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class apro
  implements apeb
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<aprm> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private apro(aprm paramaprm, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramaprm == null) {}
    for (paramaprm = null;; paramaprm = new WeakReference(paramaprm))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramaprm;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (aprm localaprm = null; (localaprm == null) || (aprm.a(localaprm)); localaprm = (aprm)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!bicz.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (aprm.a(localaprm) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      aprm.a(localaprm, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    aprm.a(localaprm).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (aprm localaprm = null; (paramObject == null) || (localaprm == null) || (aprm.a(localaprm)); localaprm = (aprm)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    Object localObject = (String)paramObject;
    paramObject = localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramObject = localObject;
      if (!((String)localObject).contains("?weiyun_qr_code=1")) {
        paramObject = (String)localObject + "?weiyun_qr_code=1";
      }
    }
    localObject = new Message();
    ((Message)localObject).what = 5;
    ((Message)localObject).obj = new Object[] { paramObject, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString };
    aprm.a(localaprm).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apro
 * JD-Core Version:    0.7.0.1
 */