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

public class bjcj
  extends bjbw
  implements bjbx
{
  float jdField_a_of_type_Float = 1.0F;
  public long a;
  public WeakReference<Activity> a;
  private final CopyOnWriteArraySet<bjbw> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public boolean a;
  public ArrayList<bjbw> b = new ArrayList();
  
  public bjcj(Object paramObject)
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
        bjbw localbjbw = (bjbw)localIterator.next();
        f2 = localbjbw.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QCombo", 2, "getProgress " + localbjbw.toString() + " progress =" + f2);
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
        bjbw localbjbw = (bjbw)localIterator.next();
        i = localbjbw.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localbjbw.toString());
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
    if ((this instanceof bjcq)) {
      if (bjby.a((bjcq)this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "apply already" + toString());
        }
        bkrf.a().a((bjcq)this, paramActivity, paramInt);
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
                ((Bundle)localObject2).putInt(axhr.b, 2);
                ((AppRuntime)localObject1).notifyObservers(bjch.class, 970, true, (Bundle)localObject2);
              }
            }
            else
            {
              localObject1 = bkrf.a().a[paramInt];
              if (localObject1 != null) {
                ((bjcq)localObject1).a(paramActivity, paramInt);
              }
              bkrf.a().a((bjcq)this, paramActivity, paramInt);
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
              localObject3 = (bjbw)((Iterator)localObject2).next();
              if ((localObject3 instanceof bjby))
              {
                ((List)localObject1).add(((bjby)localObject3).a);
                continue;
                if ((!"front".equals(((QIMFilterCategoryItem)localObject2).g)) || (!axhp.c())) {
                  break;
                }
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt(axhr.b, 1);
                ((AppRuntime)localObject1).notifyObservers(bjch.class, 970, true, (Bundle)localObject2);
                break;
              }
              ((bjbw)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof bjcq));
          localObject2 = (bjcb)bjav.a(5);
          if (localObject2.jdField_a_of_type_ArrayOfBjcf[paramInt].a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject2.jdField_a_of_type_ArrayOfBjcf[paramInt].a(null);
        localObject3 = ((bjcb)localObject2).jdField_a_of_type_Bkrg;
      } while (localObject3 == null);
      Object localObject2 = ((bjcb)localObject2).a((bjcq)this, ((bkrg)localObject3).a(paramInt).c);
      bkrf.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      bkrf.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      bjby.a(paramActivity, (List)localObject1, this, paramInt);
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) || (!((QIMFilterCategoryItem)this.jdField_a_of_type_JavaLangObject).c()) || (paramInt == 1) || (paramInt == 3));
    ((bjed)bjav.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    bjcb localbjcb = (bjcb)bjav.b(5);
    if (localbjcb != null) {
      localbjcb.a(this, paramInt);
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "unApply " + toString() + ", " + paramInt);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bjbw)localIterator.next()).a(paramActivity, paramInt);
    }
  }
  
  public void a(bjbw parambjbw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(bjbw parambjbw, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambjbw);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadError " + toString() + ":" + parambjbw.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    if (!bbfj.g(BaseApplicationImpl.getContext()))
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
    bjcb localbjcb = (bjcb)bjav.b(5);
    if (localbjcb != null) {
      localbjcb.a(this);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(bjbw parambjbw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambjbw);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "onDownloadSuccess= " + toString() + ":" + parambjbw.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    bjbw localbjbw;
    if (((Iterator)localObject).hasNext())
    {
      localbjbw = (bjbw)((Iterator)localObject).next();
      if (localbjbw.a() == 2)
      {
        localbjbw.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbjbw);
        localbjbw.b();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "download " + toString() + "  " + localbjbw.toString());
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
      if (localbjbw.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbjbw);
        localbjbw.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "downloading " + toString() + ":" + localbjbw.toString());
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
          localObject = (bjcb)bjav.b(5);
          if (localObject != null) {
            ((bjcb)localObject).b(this);
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
  
  public void c(bjbw parambjbw)
  {
    this.b.add(parambjbw);
    this.jdField_a_of_type_Float = (1.0F / this.b.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcj
 * JD-Core Version:    0.7.0.1
 */