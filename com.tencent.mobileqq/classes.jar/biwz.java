import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class biwz
  extends biwj
{
  public biwz(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull biwi parambiwi)
  {
    parambiwi = parambiwi.a();
    if (parambiwi == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambiwi.getJSONObject("data").getInt("identity");
        parambiwi = this.a;
        if (i == 2)
        {
          bool = true;
          bixc.e(parambiwi, bool);
          bixe.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambiwi)
      {
        bixe.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambiwi);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwz
 * JD-Core Version:    0.7.0.1
 */