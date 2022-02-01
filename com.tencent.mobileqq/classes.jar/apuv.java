import android.os.Bundle;
import java.util.ArrayList;

final class apuv
  extends apvu
{
  apuv(String paramString, ArrayList paramArrayList)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("PSKey", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuv
 * JD-Core Version:    0.7.0.1
 */