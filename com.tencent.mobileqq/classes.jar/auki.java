import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class auki
  implements auir
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<aukg> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private auki(aukg paramaukg, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramaukg == null) {}
    for (paramaukg = null;; paramaukg = new WeakReference(paramaukg))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramaukg;
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
    for (aukg localaukg = null; (localaukg == null) || (aukg.a(localaukg)); localaukg = (aukg)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!bmqx.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (aukg.a(localaukg) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      aukg.a(localaukg, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    aukg.a(localaukg).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (aukg localaukg = null; (paramObject == null) || (localaukg == null) || (aukg.a(localaukg)); localaukg = (aukg)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
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
    aukg.a(localaukg).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auki
 * JD-Core Version:    0.7.0.1
 */