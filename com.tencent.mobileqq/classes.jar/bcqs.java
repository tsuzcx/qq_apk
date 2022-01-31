import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

class bcqs
  implements axrt
{
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<bcqq> jdField_a_of_type_JavaLangRefWeakReference;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = -1;
  
  public bcqs(int paramInt1, bcqq parambcqq, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcqq);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
    }
    bcqq localbcqq = (bcqq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbcqq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
      }
      return;
    }
    Object localObject1;
    if ((paramaxsq == null) || (paramaxsq.jdField_a_of_type_Int != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("BigDataDownloadListener$onResp | resp = ").append(paramaxsq).append(" | mResult=");
        if (paramaxsq == null) {
          break label130;
        }
      }
      label130:
      for (i = paramaxsq.jdField_a_of_type_Int;; i = 0)
      {
        QLog.d("BigDataHandler", 2, i);
        localbcqq.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    Object localObject2;
    try
    {
      localObject2 = paramaxsq.jdField_a_of_type_ArrayOfByte;
      i = localObject2.length;
      if ((localObject2[0] != 40) || (localObject2[(i - 1)] != 41))
      {
        localObject1 = "unexpected body data, len=" + i + ", data=";
        localObject2 = localObject2.toString();
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
        localObject1 = localObject2;
        if (((String)localObject2).length() > 20) {
          localObject1 = ((String)localObject2).substring(0, 20);
        }
        localObject1 = (String)localObject1;
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + paramaxsq + " | mResult=" + (String)localObject1);
        }
        localbcqq.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    catch (Exception paramaxsq)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + paramaxsq.getMessage());
      }
      localbcqq.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    paramaxsq = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
    paramaxsq.readByte();
    int k = paramaxsq.readInt();
    int j = paramaxsq.readInt();
    if ((k > i) || (j > i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + k + ", bodyLen=" + j);
      }
      localbcqq.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + k + " | bodyLen=" + j);
    }
    if (k > 0)
    {
      localObject1 = new byte[k];
      paramaxsq.read((byte[])localObject1);
      localObject2 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
    }
    for (int i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();; i = 0)
    {
      if ((j > 0) && (i == 0))
      {
        localObject1 = new byte[j];
        paramaxsq.read((byte[])localObject1);
        paramaxsq = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
        localbcqq.a(this.jdField_a_of_type_Int, true, paramaxsq, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i);
      }
      localbcqq.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bcqs
 * JD-Core Version:    0.7.0.1
 */