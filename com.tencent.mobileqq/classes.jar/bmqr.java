import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bmqr
  extends bmqd
{
  public bmqr(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bmqc parambmqc)
  {
    parambmqc = parambmqc.a();
    if (parambmqc == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambmqc.getJSONObject("data").getInt("identity");
        parambmqc = this.a;
        if (i == 2)
        {
          bool = true;
          bmqu.e(parambmqc, bool);
          bmqw.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambmqc)
      {
        bmqw.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambmqc);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqr
 * JD-Core Version:    0.7.0.1
 */