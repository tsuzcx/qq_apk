import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6.1;
import java.util.Map;
import java.util.UUID;

public class bcjc
  extends ypu
{
  public bcjc(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        return;
        paramString = paramBundle.getString("itemKey");
      } while (paramString == null);
      paramString = UUID.fromString(paramString);
      paramBundle = paramBundle.getString("fileId");
      paramString = (bbnr)this.a.a().b.get(paramString);
    } while ((paramString == null) || (paramInt1 != 0));
    ypf.a(this.a.a, this.a.e, paramString.a, paramString.b, TroopFileTransferManager.a(this.a));
    ThreadManager.executeOnSubThread(new TroopFileTransferManager.6.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjc
 * JD-Core Version:    0.7.0.1
 */