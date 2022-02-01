import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;

final class ands
  implements anda
{
  ands(CmShowRenderView paramCmShowRenderView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onViewReady w:" + paramInt1);
    this.a.a("1669140032", "1174992642", 1.0F, 0, null);
    andq.a(this.a);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("CmShowTest", 1, "onClick apolloId:" + paramString);
  }
  
  public void a(String paramString)
  {
    QLog.i("CmShowTest", 1, "onLongTouch name:" + paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onActionStart actionId:" + paramInt1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    QLog.i("CmShowTest", 1, "onActionComplete actionId:" + paramInt1 + " actionSeqId:" + paramInt2 + " playFragment:" + paramInt3);
    if (paramInt2 == 100)
    {
      andq.b(this.a);
      return;
    }
    if (paramInt2 == 101)
    {
      if (andq.a() < 3)
      {
        andq.b();
        andq.b(this.a);
        return;
      }
      andq.c(this.a);
      return;
    }
    andq.a(0);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */