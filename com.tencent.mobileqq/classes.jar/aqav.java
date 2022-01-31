import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aqav
  extends ampt
{
  aqav(aqau paramaqau, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("EnterpriseQQManager", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if (paramInt == 0) {
      paramInt = i;
    }
    aqaw localaqaw;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      aqau.a(this.a, d1);
      aqau.b(this.a, d2);
      aqau.a(this.a, System.currentTimeMillis());
      synchronized (aqau.a())
      {
        if ((aqau.a(this.a) == null) || (aqau.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = aqau.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localaqaw = (aqaw)localIterator1.next();
        } while (localaqaw == null);
        this.a.a(aqau.a(this.a), aqau.a(this.a), localaqaw.a, localaqaw.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      aqau.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      aqau.a(this.a, null);
      aqau.a(this.a, null);
      return;
      synchronized (aqau.a())
      {
        if ((aqau.a(this.a) == null) || (aqau.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = aqau.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localaqaw = (aqaw)localIterator2.next();
          if (localaqaw != null) {
            this.a.a(aqau.a(this.a), aqau.a(this.a), localaqaw.a, localaqaw.b, false, 0.0D, 0.0D);
          }
        }
      }
      aqau.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqav
 * JD-Core Version:    0.7.0.1
 */