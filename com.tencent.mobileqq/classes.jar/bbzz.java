import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bbzz
  extends ameq
{
  public bbzz(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(boolean paramBoolean, bbyf parambbyf)
  {
    super.a(paramBoolean, parambbyf);
    this.a.o();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("获取作业信息");
      if (!paramBoolean) {
        break label79;
      }
    }
    label79:
    for (String str = "成功";; str = "失败")
    {
      QLog.d("PublishHomeWorkFragment", 2, str);
      if ((!paramBoolean) || (parambbyf == null) || (parambbyf.b == null)) {
        break;
      }
      this.a.a(parambbyf);
      return;
    }
    this.a.getActivity().finish();
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.a(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "onGetHomeworkTroopIdentity: isSuccess:" + paramBoolean + ", identity:" + paramInt + ", course:" + paramString3);
    }
    if (!this.a.j)
    {
      if (!this.a.h) {
        this.a.b(paramString3);
      }
      this.a.a(paramInt, paramString3, paramString4);
      if (!paramBoolean) {
        break label142;
      }
      this.a.a = paramString3;
      this.a.b();
    }
    for (;;)
    {
      QLog.i("PublishHomeWorkFragment", 1, "init data success");
      this.a.f();
      return;
      label142:
      QQToast.a(this.a.getActivity(), alud.a(2131709221), 0).a();
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.b(paramBoolean, paramLong, paramInt);
    this.a.o();
    this.a.a(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzz
 * JD-Core Version:    0.7.0.1
 */