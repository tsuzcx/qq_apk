import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class aozq
  implements aonc
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<aozo> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private aozq(aozo paramaozo, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramaozo == null) {}
    for (paramaozo = null;; paramaozo = new WeakReference(paramaozo))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramaozo;
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
    for (aozo localaozo = null; (localaozo == null) || (aozo.a(localaozo)); localaozo = (aozo)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!bgtg.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (aozo.a(localaozo) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      aozo.a(localaozo, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    aozo.a(localaozo).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (aozo localaozo = null; (paramObject == null) || (localaozo == null) || (aozo.a(localaozo)); localaozo = (aozo)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
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
    aozo.a(localaozo).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozq
 * JD-Core Version:    0.7.0.1
 */