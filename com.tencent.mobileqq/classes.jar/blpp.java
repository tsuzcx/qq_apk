import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class blpp
  extends blpb
{
  public blpp(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull blpa paramblpa)
  {
    paramblpa = paramblpa.a();
    if (paramblpa == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = paramblpa.getJSONObject("data").getInt("identity");
        paramblpa = this.a;
        if (i == 2)
        {
          bool = true;
          blps.e(paramblpa, bool);
          blpu.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception paramblpa)
      {
        blpu.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", paramblpa);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpp
 * JD-Core Version:    0.7.0.1
 */