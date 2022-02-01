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

public class bpne
  extends bpmr
  implements bpms
{
  float jdField_a_of_type_Float = 1.0F;
  public long a;
  public WeakReference<Activity> a;
  private final CopyOnWriteArraySet<bpmr> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public boolean a;
  public ArrayList<bpmr> b = new ArrayList();
  
  public bpne(Object paramObject)
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
        bpmr localbpmr = (bpmr)localIterator.next();
        f2 = localbpmr.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QCombo", 2, "getProgress " + localbpmr.toString() + " progress =" + f2);
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
        bpmr localbpmr = (bpmr)localIterator.next();
        i = localbpmr.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localbpmr.toString());
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
    if ((this instanceof bpnm)) {
      if (bpmt.a((bpnm)this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "apply already" + toString());
        }
        bqzz.a().a((bpnm)this, paramActivity, paramInt);
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
                ((Bundle)localObject2).putInt(bday.b, 2);
                ((AppRuntime)localObject1).notifyObservers(bpnc.class, 970, true, (Bundle)localObject2);
              }
            }
            else
            {
              localObject1 = bqzz.a().a[paramInt];
              if (localObject1 != null) {
                ((bpnm)localObject1).a(paramActivity, paramInt);
              }
              bqzz.a().a((bpnm)this, paramActivity, paramInt);
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
              localObject3 = (bpmr)((Iterator)localObject2).next();
              if ((localObject3 instanceof bpmt))
              {
                ((List)localObject1).add(((bpmt)localObject3).a);
                continue;
                if ((!"front".equals(((QIMFilterCategoryItem)localObject2).g)) || (!bdaw.c())) {
                  break;
                }
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(bday.b, 1);
                ((AppRuntime)localObject1).notifyObservers(bpnc.class, 970, true, (Bundle)localObject2);
                break;
              }
              ((bpmr)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof bpnm));
          localObject2 = (bpmw)bplq.a(5);
          if (localObject2.jdField_a_of_type_ArrayOfBpna[paramInt].a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject2.jdField_a_of_type_ArrayOfBpna[paramInt].a(null);
        localObject3 = ((bpmw)localObject2).jdField_a_of_type_Braa;
      } while (localObject3 == null);
      Object localObject2 = ((bpmw)localObject2).a((bpnm)this, ((braa)localObject3).a(paramInt).c);
      bqzz.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      bqzz.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      bpmt.a(paramActivity, (List)localObject1, this, paramInt);
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) || (!((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).c()) || (paramInt == 1) || (paramInt == 3));
    ((bpoz)bplq.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    bpmw localbpmw = (bpmw)bplq.b(5);
    if (localbpmw != null) {
      localbpmw.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "unApply " + toString() + ", " + paramInt);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bpmr)localIterator.next()).a(paramActivity, paramInt);
    }
  }
  
  public void a(bpmr parambpmr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(bpmr parambpmr, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambpmr);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadError " + toString() + ":" + parambpmr.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    if (!bhnv.g(BaseApplicationImpl.getContext()))
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
    bpmw localbpmw = (bpmw)bplq.b(5);
    if (localbpmw != null) {
      localbpmw.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(bpmr parambpmr)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambpmr);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadSuccess= " + toString() + ":" + parambpmr.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    bpmr localbpmr;
    if (((Iterator)localObject).hasNext())
    {
      localbpmr = (bpmr)((Iterator)localObject).next();
      if (localbpmr.a() == 2)
      {
        localbpmr.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbpmr);
        localbpmr.b();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "download " + toString() + "  " + localbpmr.toString());
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
      if (localbpmr.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbpmr);
        localbpmr.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "downloading " + toString() + ":" + localbpmr.toString());
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
          localObject = (bpmw)bplq.b(5);
          if (localObject != null) {
            ((bpmw)localObject).b(this);
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
  
  public void c(bpmr parambpmr)
  {
    this.b.add(parambpmr);
    this.jdField_a_of_type_Float = (1.0F / this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpne
 * JD-Core Version:    0.7.0.1
 */