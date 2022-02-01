import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class asfj
  extends aopa
{
  asfj(asfi paramasfi, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    asfk localasfk;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      asfi.a(this.a, d1);
      asfi.b(this.a, d2);
      asfi.a(this.a, System.currentTimeMillis());
      synchronized (asfi.a())
      {
        if ((asfi.a(this.a) == null) || (asfi.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = asfi.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localasfk = (asfk)localIterator1.next();
        } while (localasfk == null);
        this.a.a(asfi.a(this.a), asfi.a(this.a), localasfk.a, localasfk.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      asfi.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      asfi.a(this.a, null);
      asfi.a(this.a, null);
      return;
      synchronized (asfi.a())
      {
        if ((asfi.a(this.a) == null) || (asfi.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = asfi.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localasfk = (asfk)localIterator2.next();
          if (localasfk != null) {
            this.a.a(asfi.a(this.a), asfi.a(this.a), localasfk.a, localasfk.b, false, 0.0D, 0.0D);
          }
        }
      }
      asfi.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfj
 * JD-Core Version:    0.7.0.1
 */