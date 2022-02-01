import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1;

public class apxi
  extends apxx
{
  public apxi(ArkAiDictUpdateMgr.8 param8) {}
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new ArkAiDictUpdateMgr.8.1.1(this, paramArrayOfByte, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxi
 * JD-Core Version:    0.7.0.1
 */