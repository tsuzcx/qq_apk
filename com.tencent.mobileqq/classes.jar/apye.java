import android.os.Bundle;
import java.util.ArrayList;

final class apye
  extends apzd
{
  apye(String paramString, long paramLong, ArrayList paramArrayList)
  {
    super(paramString, paramLong);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("Nickname", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apye
 * JD-Core Version:    0.7.0.1
 */