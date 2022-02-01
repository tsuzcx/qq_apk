import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class autt
  implements ausc
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<autr> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private autt(autr paramautr, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramautr == null) {}
    for (paramautr = null;; paramautr = new WeakReference(paramautr))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramautr;
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
    for (autr localautr = null; (localautr == null) || (autr.a(localautr)); localautr = (autr)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!bnyz.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (autr.a(localautr) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      autr.a(localautr, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    autr.a(localautr).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (autr localautr = null; (paramObject == null) || (localautr == null) || (autr.a(localautr)); localautr = (autr)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
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
    autr.a(localautr).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autt
 * JD-Core Version:    0.7.0.1
 */