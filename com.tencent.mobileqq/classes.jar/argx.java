import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class argx
  extends SosoInterface.OnLocationListener
{
  argx(argw paramargw, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    argy localargy;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.mLocation;
      double d1 = ???.mLat02;
      double d2 = ???.mLon02;
      argw.a(this.a, d1);
      argw.b(this.a, d2);
      argw.a(this.a, System.currentTimeMillis());
      synchronized (argw.a())
      {
        if ((argw.a(this.a) == null) || (argw.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = argw.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localargy = (argy)localIterator1.next();
        } while (localargy == null);
        this.a.a(argw.a(this.a), argw.a(this.a), localargy.a, localargy.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      argw.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      argw.a(this.a, null);
      argw.a(this.a, null);
      return;
      synchronized (argw.a())
      {
        if ((argw.a(this.a) == null) || (argw.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = argw.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localargy = (argy)localIterator2.next();
          if (localargy != null) {
            this.a.a(argw.a(this.a), argw.a(this.a), localargy.a, localargy.b, false, 0.0D, 0.0D);
          }
        }
      }
      argw.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argx
 * JD-Core Version:    0.7.0.1
 */