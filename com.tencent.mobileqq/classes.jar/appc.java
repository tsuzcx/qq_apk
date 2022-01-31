import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.qphone.base.util.QLog;

public class appc
  extends akgd
{
  public appc(NowLiveFragment paramNowLiveFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt != 0)
    {
      bbmy.a(this.a.a, 1, ajjy.a(2131641883), 1).a();
      this.a.f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NowLiveFragment", 2, "startLocation finish" + System.currentTimeMillis());
    }
    this.a.a(paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appc
 * JD-Core Version:    0.7.0.1
 */