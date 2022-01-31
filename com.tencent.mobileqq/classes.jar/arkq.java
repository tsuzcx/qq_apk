import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class arkq
  implements aqwz
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<arko> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private arkq(arko paramarko, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramarko == null) {}
    for (paramarko = null;; paramarko = new WeakReference(paramarko))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramarko;
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
    for (arko localarko = null; (localarko == null) || (arko.a(localarko)); localarko = (arko)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!bkev.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (arko.a(localarko) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      arko.a(localarko, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    arko.a(localarko).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (arko localarko = null; (paramObject == null) || (localarko == null) || (arko.a(localarko)); localarko = (arko)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
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
    arko.a(localarko).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkq
 * JD-Core Version:    0.7.0.1
 */