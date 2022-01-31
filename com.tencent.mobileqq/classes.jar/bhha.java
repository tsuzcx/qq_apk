import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureSet.1;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class bhha
  extends bhgn
  implements bhgo
{
  float jdField_a_of_type_Float = 1.0F;
  public long a;
  public WeakReference<Activity> a;
  private final CopyOnWriteArraySet<bhgn> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public boolean a;
  public ArrayList<bhgn> b = new ArrayList();
  
  public bhha(Object paramObject)
  {
    super(paramObject);
  }
  
  public float a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        bhgn localbhgn = (bhgn)localIterator.next();
        f2 = localbhgn.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QCombo", 2, "getProgress " + localbhgn.toString() + " progress =" + f2);
        }
        f3 = this.jdField_a_of_type_Float;
      }
      return f1;
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  public int a()
  {
    int j = 0;
    int k = 1;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("getState = ");
      localStringBuilder.append(toString());
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      Iterator localIterator = this.b.iterator();
      int i;
      if (localIterator.hasNext())
      {
        bhgn localbhgn = (bhgn)localIterator.next();
        i = localbhgn.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localbhgn.toString());
          localStringBuilder.append("   ");
        }
        if (i == 2)
        {
          i = 0;
          j = 1;
        }
      }
      for (;;)
      {
        label125:
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, localStringBuilder.toString());
        }
        if (j != 0)
        {
          b(2);
          i = 2;
        }
        do
        {
          return i;
          if (i != 1) {
            break;
          }
          i = 1;
          break label125;
          if (i == 0) {
            break label211;
          }
          if (this.jdField_a_of_type_Int != 1) {
            b();
          }
          i = k;
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 60000L);
        b(2);
        a(5);
        return 2;
        label211:
        b(3);
        return 3;
        i = 0;
      }
      localStringBuilder = null;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this instanceof bhhh)) {
      if (bhgp.a((bhhh)this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "apply already" + toString());
        }
        bjac.a().a((bhhh)this, paramActivity, paramInt);
      }
    }
    label337:
    do
    {
      Object localObject1;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return 0;
            localObject2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject;
            if ((localObject2 != null) && (paramInt == 0))
            {
              localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if ("back".equals(((QIMFilterCategoryItem)localObject2).g))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(awij.b, 2);
                ((AppRuntime)localObject1).notifyObservers(bhgy.class, 970, true, (Bundle)localObject2);
              }
            }
            else
            {
              localObject1 = bjac.a().a[paramInt];
              if (localObject1 != null) {
                ((bhhh)localObject1).a(paramActivity, paramInt);
              }
              bjac.a().a((bhhh)this, paramActivity, paramInt);
              if (QLog.isColorLevel()) {
                QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt);
              }
              localObject1 = new ArrayList();
              localObject2 = this.b.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label337;
              }
              localObject3 = (bhgn)((Iterator)localObject2).next();
              if ((localObject3 instanceof bhgp))
              {
                ((List)localObject1).add(((bhgp)localObject3).a);
                continue;
                if ((!"front".equals(((QIMFilterCategoryItem)localObject2).g)) || (!awih.c())) {
                  break;
                }
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(awij.b, 1);
                ((AppRuntime)localObject1).notifyObservers(bhgy.class, 970, true, (Bundle)localObject2);
                break;
              }
              ((bhgn)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof bhhh));
          localObject2 = (bhgs)bhfm.a(5);
          if (localObject2.jdField_a_of_type_ArrayOfBhgw[paramInt].a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject2.jdField_a_of_type_ArrayOfBhgw[paramInt].a(null);
        localObject3 = ((bhgs)localObject2).jdField_a_of_type_Bjad;
      } while (localObject3 == null);
      Object localObject2 = ((bhgs)localObject2).a((bhhh)this, ((bjad)localObject3).a(paramInt).c);
      bjac.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      bjac.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      bhgp.a(paramActivity, (List)localObject1, this, paramInt);
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) || (!((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).c()) || (paramInt == 1) || (paramInt == 3));
    ((bhiu)bhfm.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    bhgs localbhgs = (bhgs)bhfm.b(5);
    if (localbhgs != null) {
      localbhgs.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "unApply " + toString() + ", " + paramInt);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bhgn)localIterator.next()).a(paramActivity, paramInt);
    }
  }
  
  public void a(bhgn parambhgn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(bhgn parambhgn, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambhgn);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadError " + toString() + ":" + parambhgn.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      b(2);
      a(paramInt);
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "download " + toString());
    }
    if (!badq.g(BaseApplicationImpl.getContext()))
    {
      a(6);
      return 2;
    }
    ThreadManager.getSubThreadHandler().post(new CaptureSet.1(this));
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return ((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).a;
    }
    return "unknown" + hashCode();
  }
  
  public void b()
  {
    super.b();
    bhgs localbhgs = (bhgs)bhfm.b(5);
    if (localbhgs != null) {
      localbhgs.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(bhgn parambhgn)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambhgn);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadSuccess= " + toString() + ":" + parambhgn.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (this.jdField_a_of_type_Boolean)
      {
        b(2);
        a(4);
      }
    }
    else {
      return;
    }
    b(3);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadFinish= " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    b();
  }
  
  public int c()
  {
    Object localObject = this.b.iterator();
    int j = 0;
    int i = 0;
    bhgn localbhgn;
    if (((Iterator)localObject).hasNext())
    {
      localbhgn = (bhgn)((Iterator)localObject).next();
      if (localbhgn.a() == 2)
      {
        localbhgn.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbhgn);
        localbhgn.b();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "download " + toString() + "  " + localbhgn.toString());
        }
        i = j;
        j = 1;
      }
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break;
      if (localbhgn.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbhgn);
        localbhgn.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "downloading " + toString() + ":" + localbhgn.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
        {
          b(1);
          a();
          localObject = (bhgs)bhfm.b(5);
          if (localObject != null) {
            ((bhgs)localObject).b(this);
          }
        }
        if ((i != 0) || (j != 0))
        {
          b(1);
          return 1;
        }
        b(3);
        b();
        return 3;
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public void c(bhgn parambhgn)
  {
    this.b.add(parambhgn);
    this.jdField_a_of_type_Float = (1.0F / this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhha
 * JD-Core Version:    0.7.0.1
 */