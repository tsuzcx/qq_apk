import android.widget.TextView;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.fragment.DeleteFaceFragment.2.1.1;
import com.tencent.qphone.base.util.QLog;

public class apnx
  extends atdj
{
  apnx(apnw paramapnw) {}
  
  public void a()
  {
    if (this.a.a.getActivity() != null)
    {
      DeleteFaceFragment.a(this.a.a).postDelayed(new DeleteFaceFragment.2.1.1(this), 500L);
      return;
    }
    QLog.e("DeleteFaceFragment", 1, "delete success, activity is null");
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("DeleteFaceFragment", 1, "delete face error");
    if (this.a.a.getActivity() != null)
    {
      bbmy.a(this.a.a.getActivity(), 1, this.a.a.getString(2131626537), 0).b(this.a.a.a());
      return;
    }
    QLog.e("DeleteFaceFragment", 1, "delete falied, activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apnx
 * JD-Core Version:    0.7.0.1
 */