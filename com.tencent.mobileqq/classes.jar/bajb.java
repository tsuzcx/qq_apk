import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qassistant.audio.AudioUploadThread;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;
import java.util.HashMap;

public class bajb
  implements ITransactionCallback
{
  private final long jdField_a_of_type_Long = System.currentTimeMillis();
  
  public bajb(AudioUploadThread paramAudioUploadThread, String paramString, bajd parambajd) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    bakl.a("AudioUploadThread", "onFailed, duration:" + (l1 - l2) + ", retCode:" + paramInt);
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    bakl.a("AudioUploadThread", "onSuccess duration:" + l);
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    try
    {
      AudioUploadThread.a(this.jdField_a_of_type_ComTencentMobileqqQassistantAudioAudioUploadThread, this.jdField_a_of_type_Bajd, paramArrayOfByte, l);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      bakl.a("AudioUploadThread", "onSuccess, parse rsp error:" + paramArrayOfByte.getMessage());
      paramArrayOfByte.printStackTrace();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void onSwitch2BackupChannel()
  {
    bakl.a("AudioUploadThread", "onSwitch2BackupChannel");
  }
  
  public void onTransStart()
  {
    bakl.a("AudioUploadThread", "onTransStart");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bakl.a("AudioUploadThread", "onUpdateProgress transferedSize:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajb
 * JD-Core Version:    0.7.0.1
 */