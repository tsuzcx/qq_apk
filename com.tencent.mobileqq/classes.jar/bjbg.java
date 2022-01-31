import android.support.annotation.NonNull;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import org.json.JSONObject;

public class bjbg
  extends bjaq
{
  public bjbg(ReaderHomePageActivity paramReaderHomePageActivity) {}
  
  public void a(@NonNull bjap parambjap)
  {
    parambjap = parambjap.a();
    if (parambjap == null) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = parambjap.getJSONObject("data").getInt("identity");
        parambjap = this.a;
        if (i == 2)
        {
          bool = true;
          bjbj.e(parambjap, bool);
          bjbl.d("ReaderHomePageActivity", "queryUserIdentityForTabSwitch: identity = " + i);
          return;
        }
      }
      catch (Exception parambjap)
      {
        bjbl.a("ReaderHomePageActivity", "queryUserIdentityForTabSwitch:", parambjap);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbg
 * JD-Core Version:    0.7.0.1
 */