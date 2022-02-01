import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

final class aork
  extends aosv
{
  aork(String paramString, ArrayList paramArrayList)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("userInfo", null);
      if (!TextUtils.isEmpty(paramBundle)) {
        this.a.add(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aork
 * JD-Core Version:    0.7.0.1
 */