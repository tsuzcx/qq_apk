import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bcam
  extends ameq
{
  public bcam(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, bbyf parambbyf)
  {
    super.a(paramBoolean, parambbyf);
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
      if ((!paramBoolean) || (parambbyf == null) || (parambbyf.b == null)) {
        break;
      }
      this.a.a = parambbyf;
      parambbyf = parambbyf.b;
      try
      {
        parambbyf = new JSONObject(parambbyf).getJSONArray("c");
        parambbyf = new JSONObject().put("c", parambbyf).toString();
        this.a.a(parambbyf);
        return;
      }
      catch (Exception parambbyf)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcam
 * JD-Core Version:    0.7.0.1
 */