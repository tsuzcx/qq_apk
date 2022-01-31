import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class aoqk
  extends aoql
{
  final byte[] a;
  final byte[] b;
  
  public aoqk(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    super(paramString1, paramString2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
    this.a = paramArrayOfByte5;
    this.b = paramArrayOfByte6;
  }
  
  public boolean a()
  {
    if (!super.a()) {}
    do
    {
      do
      {
        do
        {
          return false;
          if ((b() != null) && (b().length != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBuf10MMdd5 is err");
        return false;
        if ((this.a != null) && (this.a.length != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUuid is err");
      return false;
      if ((this.b != null) && (this.b.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUploadKey is err");
    return false;
    return true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append(" uuid:");
    if (this.a != null)
    {
      str = HexUtil.bytes2HexStr(this.a);
      localStringBuilder = localStringBuilder.append(str).append(" mBufUploadKey:");
      if (this.b == null) {
        break label76;
      }
    }
    label76:
    for (String str = HexUtil.bytes2HexStr(this.b);; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqk
 * JD-Core Version:    0.7.0.1
 */