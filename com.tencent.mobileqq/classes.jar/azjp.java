import android.content.Intent;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;

public abstract interface azjp
{
  public abstract azjz a(Intent paramIntent);
  
  public abstract azjz a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract azkn a(Intent paramIntent);
  
  public abstract CompressInfo a(Intent paramIntent);
  
  public abstract ArrayList<azjz> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjp
 * JD-Core Version:    0.7.0.1
 */