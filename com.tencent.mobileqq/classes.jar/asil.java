import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class asil
  extends asio
{
  asil(asih paramasih, antu paramantu, asjh paramasjh, Object paramObject)
  {
    super(paramasih, paramantu);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ??? = (antu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    int i = paramEmoticonResp.epId;
    int j = paramEmoticonResp.timestamp;
    Object localObject1 = (ArrayList)paramEmoticonResp.data;
    if ((this.jdField_a_of_type_Asjh.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Asjh.jdField_a_of_type_JavaLangString.equals(paramEmoticonResp.keySeq)))
    {
      ((antu)???).b(this);
      this.jdField_a_of_type_Asjh.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Asjh.jdField_a_of_type_Int = paramEmoticonResp.resultcode;
      this.jdField_a_of_type_Asjh.b = paramEmoticonResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        if (!QLog.isColorLevel()) {
          break;
        }
        ??? = asih.a();
        StringBuilder localStringBuilder = new StringBuilder().append("fetchEmoticonEncryptKeys|net get key backepId=").append(i).append(" tstamp=").append(j).append(" list.size=");
        if (localObject1 == null)
        {
          localObject1 = "null";
          QLog.d((String)???, 2, localObject1 + " encryptSuccess=" + paramBoolean + " type=" + paramInt + " er.resultCode=" + paramEmoticonResp.resultcode);
          return;
        }
      }
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asil
 * JD-Core Version:    0.7.0.1
 */