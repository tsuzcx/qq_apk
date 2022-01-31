import android.widget.TextView;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.fragment.DeleteFaceFragment.2.1.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class asbc
  extends avqt
{
  asbc(asbb paramasbb) {}
  
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
      QQToast.a(this.a.a.getActivity(), 1, this.a.a.getString(2131692193), 0).b(this.a.a.a());
      return;
    }
    QLog.e("DeleteFaceFragment", 1, "delete falied, activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbc
 * JD-Core Version:    0.7.0.1
 */