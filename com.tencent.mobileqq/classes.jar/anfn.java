import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class anfn
  extends anfq
{
  anfn(anfj paramanfj, ajhm paramajhm, angh paramangh, Object paramObject)
  {
    super(paramanfj, paramajhm);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ??? = (ajhm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    int i = paramEmoticonResp.epId;
    int j = paramEmoticonResp.timestamp;
    Object localObject1 = (ArrayList)paramEmoticonResp.data;
    if ((this.jdField_a_of_type_Angh.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Angh.jdField_a_of_type_JavaLangString.equals(paramEmoticonResp.keySeq)))
    {
      ((ajhm)???).b(this);
      this.jdField_a_of_type_Angh.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Angh.jdField_a_of_type_Int = paramEmoticonResp.resultcode;
      this.jdField_a_of_type_Angh.b = paramEmoticonResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        if (!QLog.isColorLevel()) {
          break;
        }
        ??? = this.jdField_a_of_type_Anfj.jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */