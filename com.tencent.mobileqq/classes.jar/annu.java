import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class annu
  extends akgd
{
  annu(annt paramannt, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    annv localannv;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      annt.a(this.a, d1);
      annt.b(this.a, d2);
      annt.a(this.a, System.currentTimeMillis());
      synchronized (annt.a())
      {
        if ((annt.a(this.a) == null) || (annt.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = annt.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localannv = (annv)localIterator1.next();
        } while (localannv == null);
        this.a.a(annt.a(this.a), annt.a(this.a), localannv.a, localannv.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      annt.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      annt.a(this.a, null);
      annt.a(this.a, null);
      return;
      synchronized (annt.a())
      {
        if ((annt.a(this.a) == null) || (annt.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = annt.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localannv = (annv)localIterator2.next();
          if (localannv != null) {
            this.a.a(annt.a(this.a), annt.a(this.a), localannv.a, localannv.b, false, 0.0D, 0.0D);
          }
        }
      }
      annt.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annu
 * JD-Core Version:    0.7.0.1
 */