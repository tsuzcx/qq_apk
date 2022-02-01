import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class asld
  extends SosoInterface.OnLocationListener
{
  asld(aslc paramaslc, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    asle localasle;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.mLocation;
      double d1 = ???.mLat02;
      double d2 = ???.mLon02;
      aslc.a(this.a, d1);
      aslc.b(this.a, d2);
      aslc.a(this.a, System.currentTimeMillis());
      synchronized (aslc.a())
      {
        if ((aslc.a(this.a) == null) || (aslc.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = aslc.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localasle = (asle)localIterator1.next();
        } while (localasle == null);
        this.a.a(aslc.a(this.a), aslc.a(this.a), localasle.a, localasle.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      aslc.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      aslc.a(this.a, null);
      aslc.a(this.a, null);
      return;
      synchronized (aslc.a())
      {
        if ((aslc.a(this.a) == null) || (aslc.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = aslc.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localasle = (asle)localIterator2.next();
          if (localasle != null) {
            this.a.a(aslc.a(this.a), aslc.a(this.a), localasle.a, localasle.b, false, 0.0D, 0.0D);
          }
        }
      }
      aslc.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asld
 * JD-Core Version:    0.7.0.1
 */