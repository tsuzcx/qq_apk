import android.os.Bundle;
import java.util.UUID;

class bfxb
  extends aavm
{
  bfxb(bfxa parambfxa) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != bfxa.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      bfvr.a("TroopFileToTroopForwarder", bfvr.a, "[" + bfxa.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    bfxa.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxb
 * JD-Core Version:    0.7.0.1
 */