import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bfrc
  extends aofu
{
  public bfrc(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void onGetHomeworkInfo(boolean paramBoolean, bfoy parambfoy)
  {
    super.onGetHomeworkInfo(paramBoolean, parambfoy);
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
      if ((!paramBoolean) || (parambfoy == null) || (parambfoy.b == null)) {
        break;
      }
      this.a.a = parambfoy;
      parambfoy = parambfoy.b;
      try
      {
        parambfoy = new JSONObject(parambfoy).getJSONArray("c");
        parambfoy = new JSONObject().put("c", parambfoy).toString();
        this.a.a(parambfoy);
        return;
      }
      catch (Exception parambfoy)
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
  
  public void onSubmitHomework(boolean paramBoolean, int paramInt)
  {
    super.onSubmitHomework(paramBoolean, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrc
 * JD-Core Version:    0.7.0.1
 */