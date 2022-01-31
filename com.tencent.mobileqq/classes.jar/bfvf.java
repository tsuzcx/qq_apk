import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;

class bfvf
  implements bapx
{
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<bfvd> jdField_a_of_type_JavaLangRefWeakReference;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b = -1;
  
  public bfvf(int paramInt1, bfvd parambfvd, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambfvd);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
    }
    bfvd localbfvd = (bfvd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localbfvd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
      }
      return;
    }
    Object localObject1;
    if ((parambaqw == null) || (parambaqw.jdField_a_of_type_Int != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("BigDataDownloadListener$onResp | resp = ").append(parambaqw).append(" | mResult=");
        if (parambaqw == null) {
          break label130;
        }
      }
      label130:
      for (i = parambaqw.jdField_a_of_type_Int;; i = 0)
      {
        QLog.d("BigDataHandler", 2, i);
        localbfvd.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    Object localObject2;
    try
    {
      localObject2 = parambaqw.jdField_a_of_type_ArrayOfByte;
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
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + parambaqw + " | mResult=" + (String)localObject1);
        }
        localbfvd.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
    catch (Exception parambaqw)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + parambaqw.getMessage());
      }
      localbfvd.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    parambaqw = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
    parambaqw.readByte();
    int k = parambaqw.readInt();
    int j = parambaqw.readInt();
    if ((k > i) || (j > i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + k + ", bodyLen=" + j);
      }
      localbfvd.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + k + " | bodyLen=" + j);
    }
    if (k > 0)
    {
      localObject1 = new byte[k];
      parambaqw.read((byte[])localObject1);
      localObject2 = new im_msg_head.Head();
      ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
    }
    for (int i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();; i = 0)
    {
      if ((j > 0) && (i == 0))
      {
        localObject1 = new byte[j];
        parambaqw.read((byte[])localObject1);
        parambaqw = new Cryptor().decrypt((byte[])localObject1, this.jdField_a_of_type_ArrayOfByte);
        localbfvd.a(this.jdField_a_of_type_Int, true, parambaqw, this.b, this.jdField_a_of_type_JavaLangObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i);
      }
      localbfvd.a(this.jdField_a_of_type_Int, false, null, this.b, this.jdField_a_of_type_JavaLangObject);
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvf
 * JD-Core Version:    0.7.0.1
 */