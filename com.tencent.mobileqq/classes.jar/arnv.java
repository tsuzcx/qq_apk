import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.diy.ResData;

public class arnv
  implements axmn
{
  public arnv(ChatBackgroundManager paramChatBackgroundManager) {}
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (paramInt2 == 4) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arnv
 * JD-Core Version:    0.7.0.1
 */