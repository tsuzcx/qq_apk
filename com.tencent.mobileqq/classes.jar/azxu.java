import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class azxu
  extends akil
{
  public azxu(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, azvn paramazvn)
  {
    super.a(paramBoolean, paramazvn);
    this.a.l();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label123;
      }
    }
    for (String str = "成功";; str = "失败")
    {
      QLog.d("SubmitHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (paramazvn == null) || (paramazvn.b == null)) {
        break;
      }
      this.a.a = paramazvn;
      paramazvn = paramazvn.b;
      try
      {
        paramazvn = new JSONObject(paramazvn).getJSONArray("c");
        paramazvn = new JSONObject().put("c", paramazvn).toString();
        this.a.a(paramazvn);
        return;
      }
      catch (Exception paramazvn)
      {
        label123:
        this.a.a(3, null, null, null);
        return;
      }
    }
    this.a.a(3, null, null, null);
    this.a.a = null;
    this.a.getActivity().finish();
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    this.a.l();
    if (paramBoolean)
    {
      this.a.g();
      return;
    }
    if (paramInt == 1002)
    {
      this.a.a(2, null, null, null);
      return;
    }
    if (paramInt == 10022)
    {
      this.a.a(1, null, null, null);
      return;
    }
    this.a.a(3, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxu
 * JD-Core Version:    0.7.0.1
 */