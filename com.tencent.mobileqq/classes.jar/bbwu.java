import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

class bbwu
  extends yuh
{
  bbwu(bbwt parambbwt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getString("itemKey");
      } while (paramBundle == null);
      paramBundle = UUID.fromString(paramBundle);
      paramBundle = (TroopFileTransferManager.Item)this.a.jdField_a_of_type_JavaUtilMap.get(paramBundle);
    } while (paramBundle == null);
    bbwt.a(this.a, paramBundle, paramBoolean, paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwu
 * JD-Core Version:    0.7.0.1
 */