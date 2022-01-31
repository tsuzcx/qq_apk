import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bgwa
  extends bgvk
{
  public bgwa(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bgvj parambgvj)
  {
    parambgvj = parambgvj.a();
    if (parambgvj == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambgvj.getJSONObject("data").getInt("identity");
        parambgvj = this.a;
        if (i == 2)
        {
          bool = true;
          bgwd.e(parambgvj, bool);
          bgwf.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambgvj)
      {
        bgwf.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambgvj);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwa
 * JD-Core Version:    0.7.0.1
 */