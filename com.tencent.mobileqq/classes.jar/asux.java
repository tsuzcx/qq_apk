import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class asux
  extends apcq
{
  asux(asuw paramasuw, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    asuy localasuy;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      asuw.a(this.a, d1);
      asuw.b(this.a, d2);
      asuw.a(this.a, System.currentTimeMillis());
      synchronized (asuw.a())
      {
        if ((asuw.a(this.a) == null) || (asuw.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = asuw.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localasuy = (asuy)localIterator1.next();
        } while (localasuy == null);
        this.a.a(asuw.a(this.a), asuw.a(this.a), localasuy.a, localasuy.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      asuw.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      asuw.a(this.a, null);
      asuw.a(this.a, null);
      return;
      synchronized (asuw.a())
      {
        if ((asuw.a(this.a) == null) || (asuw.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = asuw.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localasuy = (asuy)localIterator2.next();
          if (localasuy != null) {
            this.a.a(asuw.a(this.a), asuw.a(this.a), localasuy.a, localasuy.b, false, 0.0D, 0.0D);
          }
        }
      }
      asuw.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asux
 * JD-Core Version:    0.7.0.1
 */