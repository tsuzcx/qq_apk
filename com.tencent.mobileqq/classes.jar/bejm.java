import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bejm
  extends andd
{
  public bejm(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onAssignHomework(boolean paramBoolean, long paramLong, int paramInt)
  {
    super.onAssignHomework(paramBoolean, paramLong, paramInt);
    this.a.o();
    this.a.a(paramBoolean, paramInt);
  }
  
  public void onGetHomeworkInfo(boolean paramBoolean, behv parambehv)
  {
    super.onGetHomeworkInfo(paramBoolean, parambehv);
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
      if ((!paramBoolean) || (parambehv == null) || (parambehv.b == null)) {
        break;
      }
      this.a.a(parambehv);
      return;
    }
    this.a.getActivity().finish();
  }
  
  protected void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super.onGetHomeworkTroopIdentity(paramBoolean, paramString1, paramString2, paramInt, paramString3, paramString4);
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
      QQToast.a(this.a.getActivity(), amtj.a(2131707938), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejm
 * JD-Core Version:    0.7.0.1
 */