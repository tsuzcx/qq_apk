import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

class bfzm
  implements baug
{
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<bfzk> jdField_a_of_type_JavaLangRefWeakReference;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = -1;
  
  public bfzm(int paramInt1, bfzk parambfzk, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambfzk);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
    }
    bfzk localbfzk = (bfzk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbfzk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
      }
      return;
    }
    Object localObject1;
    if ((parambavf == null) || (parambavf.jdField_a_of_type_Int != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("BigDataDownloadListener$onResp | resp = ").append(parambavf).append(" | mResult=");
        if (parambavf == null) {
          break label130;
        }
      }
      label130:
      for (i = parambavf.jdField_a_of_type_Int;; i = 0)
      {
        QLog.d("BigDataHandler", 2, i);
        localbfzk.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    Object localObject2;
    try
    {
      localObject2 = parambavf.jdField_a_of_type_ArrayOfByte;
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
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + parambavf + " | mResult=" + (String)localObject1);
        }
        localbfzk.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    catch (Exception parambavf)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + parambavf.getMessage());
      }
      localbfzk.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    parambavf = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
    parambavf.readByte();
    int k = parambavf.readInt();
    int j = parambavf.readInt();
    if ((k > i) || (j > i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + k + ", bodyLen=" + j);
      }
      localbfzk.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + k + " | bodyLen=" + j);
    }
    if (k > 0)
    {
      localObject1 = new byte[k];
      parambavf.read((byte[])localObject1);
      localObject2 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
    }
    for (int i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();; i = 0)
    {
      if ((j > 0) && (i == 0))
      {
        localObject1 = new byte[j];
        parambavf.read((byte[])localObject1);
        parambavf = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
        localbfzk.a(this.jdField_a_of_type_Int, true, parambavf, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i);
      }
      localbfzk.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfzm
 * JD-Core Version:    0.7.0.1
 */