import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class apwm
  extends amle
{
  apwm(apwl paramapwl, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    apwn localapwn;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      apwl.a(this.a, d1);
      apwl.b(this.a, d2);
      apwl.a(this.a, System.currentTimeMillis());
      synchronized (apwl.a())
      {
        if ((apwl.a(this.a) == null) || (apwl.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = apwl.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localapwn = (apwn)localIterator1.next();
        } while (localapwn == null);
        this.a.a(apwl.a(this.a), apwl.a(this.a), localapwn.a, localapwn.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      apwl.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      apwl.a(this.a, null);
      apwl.a(this.a, null);
      return;
      synchronized (apwl.a())
      {
        if ((apwl.a(this.a) == null) || (apwl.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = apwl.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localapwn = (apwn)localIterator2.next();
          if (localapwn != null) {
            this.a.a(apwl.a(this.a), apwl.a(this.a), localapwn.a, localapwn.b, false, 0.0D, 0.0D);
          }
        }
      }
      apwl.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwm
 * JD-Core Version:    0.7.0.1
 */