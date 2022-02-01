import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bkuy
  extends bkuk
{
  public bkuy(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bkuj parambkuj)
  {
    parambkuj = parambkuj.a();
    if (parambkuj == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambkuj.getJSONObject("data").getInt("identity");
        parambkuj = this.a;
        if (i == 2)
        {
          bool = true;
          bkvb.e(parambkuj, bool);
          bkvd.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambkuj)
      {
        bkvd.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambkuj);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuy
 * JD-Core Version:    0.7.0.1
 */