import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bfmz
  extends bfmj
{
  public bfmz(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bfmi parambfmi)
  {
    parambfmi = parambfmi.a();
    if (parambfmi == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambfmi.getJSONObject("data").getInt("identity");
        parambfmi = this.a;
        if (i == 2)
        {
          bool = true;
          bfnc.d(parambfmi, bool);
          bfne.c("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambfmi)
      {
        bfne.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambfmi);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmz
 * JD-Core Version:    0.7.0.1
 */