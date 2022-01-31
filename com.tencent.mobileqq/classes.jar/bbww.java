import android.os.Bundle;
import java.util.UUID;

class bbww
  extends yuh
{
  bbww(bbwv parambbwv) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != bbwv.a(this.a)) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (!paramBoolean) {
      bbvl.a("TroopFileToTroopForwarder", bbvl.a, "[" + bbwv.a(this.a) + "] onFowardToTroopResult isSuccess:false ");
    }
    bbwv.a(this.a, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbww
 * JD-Core Version:    0.7.0.1
 */