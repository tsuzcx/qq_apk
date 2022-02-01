import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;

final class amck
  implements ambs
{
  amck(CmShowRenderView paramCmShowRenderView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onViewReady w:" + paramInt1);
    this.a.a("1669140032", "1174992642", 1.0F, 0, null);
    amci.a(this.a);
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
      amci.b(this.a);
      return;
    }
    if (paramInt2 == 101)
    {
      if (amci.a() < 3)
      {
        amci.b();
        amci.b(this.a);
        return;
      }
      amci.c(this.a);
      return;
    }
    amci.a(0);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amck
 * JD-Core Version:    0.7.0.1
 */