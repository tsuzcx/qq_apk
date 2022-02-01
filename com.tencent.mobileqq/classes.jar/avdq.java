import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class avdq
  extends apcq
{
  public avdq(CommonTabFragment paramCommonTabFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonTabFragment", 2, "startLocation finish" + System.currentTimeMillis());
    }
    if (paramInt != 0)
    {
      QQToast.a(this.a.a, 1, anzj.a(2131701161), 1).a();
      this.a.e();
      return;
    }
    this.a.a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdq
 * JD-Core Version:    0.7.0.1
 */