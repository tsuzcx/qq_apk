import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bmgh
  extends bmft
{
  public bmgh(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bmfs parambmfs)
  {
    parambmfs = parambmfs.a();
    if (parambmfs == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambmfs.getJSONObject("data").getInt("identity");
        parambmfs = this.a;
        if (i == 2)
        {
          bool = true;
          bmgk.e(parambmfs, bool);
          bmgm.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambmfs)
      {
        bmgm.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambmfs);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgh
 * JD-Core Version:    0.7.0.1
 */