import android.os.Bundle;
import java.util.UUID;

class azuc
  extends xbc
{
  azuc(azub paramazub) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != azub.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "[" + azub.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    azub.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azuc
 * JD-Core Version:    0.7.0.1
 */