import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aoek
  extends akuo
{
  aoek(aoej paramaoej, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
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
    aoel localaoel;
    label219:
    while (paramInt != 0)
    {
      ??? = ???.a;
      double d1 = ???.a;
      double d2 = ???.b;
      aoej.a(this.a, d1);
      aoej.b(this.a, d2);
      aoej.a(this.a, System.currentTimeMillis());
      synchronized (aoej.a())
      {
        if ((aoej.a(this.a) == null) || (aoej.a(this.a).size() <= 0)) {
          break label219;
        }
        Iterator localIterator1 = aoej.a(this.a).iterator();
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localaoel = (aoel)localIterator1.next();
        } while (localaoel == null);
        this.a.a(aoej.a(this.a), aoej.a(this.a), localaoel.a, localaoel.b, true, d1, d2);
      }
      paramInt = 0;
      continue;
      aoej.a(this.a).clear();
    }
    label362:
    for (;;)
    {
      aoej.a(this.a, null);
      aoej.a(this.a, null);
      return;
      synchronized (aoej.a())
      {
        if ((aoej.a(this.a) == null) || (aoej.a(this.a).size() <= 0)) {
          break label362;
        }
        Iterator localIterator2 = aoej.a(this.a).iterator();
        while (localIterator2.hasNext())
        {
          localaoel = (aoel)localIterator2.next();
          if (localaoel != null) {
            this.a.a(aoej.a(this.a), aoej.a(this.a), localaoel.a, localaoel.b, false, 0.0D, 0.0D);
          }
        }
      }
      aoej.a(this.a).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoek
 * JD-Core Version:    0.7.0.1
 */