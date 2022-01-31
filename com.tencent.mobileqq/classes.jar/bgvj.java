import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bgvj
  extends bgut
{
  public bgvj(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bgus parambgus)
  {
    parambgus = parambgus.a();
    if (parambgus == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambgus.getJSONObject("data").getInt("identity");
        parambgus = this.a;
        if (i == 2)
        {
          bool = true;
          bgvm.e(parambgus, bool);
          bgvo.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambgus)
      {
        bgvo.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambgus);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvj
 * JD-Core Version:    0.7.0.1
 */