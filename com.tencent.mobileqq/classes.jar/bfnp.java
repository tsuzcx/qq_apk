import android.os.Bundle;
import java.util.UUID;

class bfnp
  extends aahl
{
  bfnp(bfno parambfno) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != bfno.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      bfmf.a("TroopFileToTroopForwarder", bfmf.a, "[" + bfno.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    bfno.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnp
 * JD-Core Version:    0.7.0.1
 */