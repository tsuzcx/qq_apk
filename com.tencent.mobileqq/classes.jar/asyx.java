import android.content.Intent;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import java.util.List;

public class asyx
  extends alxx
{
  public asyx(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.a == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.i(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      int k;
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        k = 0;
        while ((k == 0) && (j < i))
        {
          if (bdal.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", false);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.a == null)
    {
      this.a.finish();
      return;
    }
    String str = this.a.a.a;
    if (ProfileActivity.AllInOne.i(this.a.a)) {
      str = this.a.a();
    }
    for (;;)
    {
      if (paramList == null) {}
      for (int i = 0;; i = paramList.size())
      {
        int j = 0;
        while ((k == 0) && (j < i))
        {
          if (bdal.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k != 0)
      {
        paramList = new Intent();
        paramList.putExtra("isSuccess", paramBoolean);
        paramList.putExtra("isCancelShield", true);
        this.a.setResult(-1, paramList);
      }
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyx
 * JD-Core Version:    0.7.0.1
 */