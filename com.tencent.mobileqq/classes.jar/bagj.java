import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import java.util.List;

public class bagj
  extends aodm
{
  public bagj(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (this.a.a == null) {
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
          if (bhbx.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, false);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    int k = 0;
    if (this.a.a == null) {
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
          if (bhbx.a(String.valueOf(paramList.get(j)), str)) {
            k = 1;
          }
          j += 1;
        }
      }
      if (k == 0) {
        break;
      }
      this.a.a(paramBoolean, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagj
 * JD-Core Version:    0.7.0.1
 */