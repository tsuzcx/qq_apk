import android.os.Bundle;
import java.util.UUID;

class aytm
  extends wlz
{
  aytm(aytl paramaytl) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != aytl.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      aysb.a("TroopFileToTroopForwarder", aysb.a, "[" + aytl.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    aytl.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytm
 * JD-Core Version:    0.7.0.1
 */