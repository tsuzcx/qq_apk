import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet.1;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class blol
  extends blnt
  implements blnh
{
  private final CopyOnWriteArraySet<blng> a;
  float b;
  public long b;
  public WeakReference<Activity> b;
  public boolean b;
  public ArrayList<blng> c = new ArrayList();
  
  public blol(Object paramObject)
  {
    super(paramObject);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_b_of_type_Float = 1.0F;
  }
  
  public float a()
  {
    try
    {
      Iterator localIterator = this.c.iterator();
      float f2;
      float f3;
      for (float f1 = 0.0F; localIterator.hasNext(); f1 += f3 * f2)
      {
        blng localblng = (blng)localIterator.next();
        f2 = localblng.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QTemplate", 2, "getProgress " + localblng.toString() + " progress =" + f2);
        }
        f3 = this.jdField_b_of_type_Float;
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
      Iterator localIterator = this.c.iterator();
      int i;
      if (localIterator.hasNext())
      {
        blng localblng = (blng)localIterator.next();
        i = localblng.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localblng.toString());
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
          QLog.i("QTemplate", 2, localStringBuilder.toString());
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
        } while (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 15000L);
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
    Object localObject1;
    if ((this instanceof blol))
    {
      localObject1 = (blnu)blmf.a(15);
      if (((blnu)localObject1).a(this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "apply already" + toString());
        }
        ((blnu)localObject1).a(this, paramActivity, paramInt);
      }
    }
    label338:
    do
    {
      Object localObject3;
      do
      {
        do
        {
          do
          {
            return 0;
            localObject3 = (QIMTemplateItem)this.jdField_a_of_type_JavaLangObject;
            if ((localObject3 != null) && (paramInt == 0))
            {
              localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
              if ("back".equals(((QIMTemplateItem)localObject3).f))
              {
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(azcx.b, 2);
                ((AppRuntime)localObject2).notifyObservers(blnr.class, 970, true, (Bundle)localObject3);
              }
            }
            else
            {
              localObject2 = localObject1.a[paramInt];
              if (localObject2 != null) {
                ((blol)localObject2).a(paramActivity, paramInt);
              }
              ((blnu)localObject1).a(this, paramActivity, paramInt);
              if (QLog.isColorLevel()) {
                QLog.i("QTemplate", 2, "apply " + toString() + ", " + paramInt);
              }
              localObject1 = new ArrayList();
              localObject2 = this.c.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label338;
              }
              localObject3 = (blng)((Iterator)localObject2).next();
              if ((localObject3 instanceof blni))
              {
                ((List)localObject1).add(((blni)localObject3).a);
                continue;
                if ((!"front".equals(((QIMTemplateItem)localObject3).f)) || (!azcv.c())) {
                  break;
                }
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(azcx.b, 1);
                ((AppRuntime)localObject2).notifyObservers(blnr.class, 970, true, (Bundle)localObject3);
                break;
              }
              ((blng)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof blol));
          localObject2 = (blnl)blmf.a(5);
          if (((blnl)localObject2).a(paramInt).a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject3 = ((blnl)localObject2).a;
      } while (localObject3 == null);
      Object localObject2 = ((blnl)localObject2).a(this, ((bncq)localObject3).a(paramInt).c);
      if (localObject2 != null) {
        bncp.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      }
      bncp.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      blni.a(paramActivity, (List)localObject1, this, paramInt);
      paramActivity = this.jdField_a_of_type_JavaLangObject;
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) || (!((QIMTemplateItem)this.jdField_a_of_type_JavaLangObject).a()) || (paramInt == 1) || (paramInt == 3));
    ((blpo)blmf.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    blnl localblnl = (blnl)blmf.b(5);
    if (localblnl != null) {
      localblnl.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "unApply " + toString() + ", " + paramInt);
    }
    Object localObject1 = this.c.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (blng)((Iterator)localObject1).next();
      if (((localObject2 instanceof blpc)) && ((paramInt == 2) || (paramInt == 4))) {
        ((blpc)localObject2).c(paramActivity, paramInt);
      } else {
        ((blng)localObject2).a(paramActivity, paramInt);
      }
    }
    bncp.a().b(null, paramActivity, paramInt);
    localObject1 = (blnu)blmf.a(15);
    Object localObject2 = localObject1.a[paramInt];
    if ((localObject2 != null) && (((blol)localObject2).b().equals(b()))) {
      ((blnu)localObject1).a(null, paramActivity, paramInt);
    }
  }
  
  public void a(blng paramblng)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(blng paramblng, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramblng);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadError " + toString() + ":" + paramblng.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
      QLog.i("QTemplate", 2, "download " + toString());
    }
    if (!bdee.g(BaseApplicationImpl.getContext()))
    {
      a(6);
      return 2;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new TemplateSet.1(this));
    return 1;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {
      return ((QIMTemplateItem)this.jdField_a_of_type_JavaLangObject).a;
    }
    return "unknown" + hashCode();
  }
  
  public void b()
  {
    super.b();
    blnl localblnl = (blnl)blmf.b(5);
    if (localblnl != null) {
      localblnl.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "select " + toString());
    }
    QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)this.jdField_a_of_type_JavaLangObject;
    ((blnu)blmf.a(15)).a(localQIMTemplateItem, paramActivity, paramInt);
    ((blnl)blmf.a(5)).a(paramInt).a(this);
  }
  
  public void b(blng paramblng)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramblng);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadSuccess= " + toString() + ":" + paramblng.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
    {
      if (this.jdField_b_of_type_Boolean)
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
    Object localObject = this.c.iterator();
    int j = 0;
    int i = 0;
    blng localblng;
    if (((Iterator)localObject).hasNext())
    {
      localblng = (blng)((Iterator)localObject).next();
      if (localblng.a() == 2)
      {
        localblng.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localblng);
        localblng.b();
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "download " + toString() + "  " + localblng.toString());
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
      if (localblng.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localblng);
        localblng.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "downloading " + toString() + ":" + localblng.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
        {
          b(1);
          a();
          localObject = (blnl)blmf.b(5);
          if (localObject != null) {
            ((blnl)localObject).b(this);
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
  
  public void d(blng paramblng)
  {
    this.c.add(paramblng);
    paramblng.c = (this.c.size() - 1);
    this.jdField_b_of_type_Float = (1.0F / this.c.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blol
 * JD-Core Version:    0.7.0.1
 */