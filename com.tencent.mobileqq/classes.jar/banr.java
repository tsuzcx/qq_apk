import android.os.Handler;
import android.os.Message;

class banr
  implements balr
{
  banr(banp parambanp) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (banp.b(this.a) != null)
    {
      Message localMessage = banp.b(this.a).obtainMessage(1002);
      localMessage.obj = paramArrayOfByte;
      banp.b(this.a).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banr
 * JD-Core Version:    0.7.0.1
 */