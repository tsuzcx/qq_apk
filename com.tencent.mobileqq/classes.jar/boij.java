import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class boij
  extends bohr
  implements bohf
{
  private final CopyOnWriteArraySet<bohe> a;
  float b;
  public long b;
  public WeakReference<Activity> b;
  public boolean b;
  public ArrayList<bohe> c = new ArrayList();
  
  public boij(Object paramObject)
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
        bohe localbohe = (bohe)localIterator.next();
        f2 = localbohe.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("QTemplate", 2, "getProgress " + localbohe.toString() + " progress =" + f2);
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
        bohe localbohe = (bohe)localIterator.next();
        i = localbohe.a();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(i);
          localStringBuilder.append("|");
          localStringBuilder.append(localbohe.toString());
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
    if ((this instanceof boij))
    {
      localObject1 = (bohs)bogd.a(15);
      if (((bohs)localObject1).a(this, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "apply already" + toString());
        }
        ((bohs)localObject1).a(this, paramActivity, paramInt);
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
                ((Bundle)localObject3).putInt(bdax.b, 2);
                ((AppRuntime)localObject2).notifyObservers(bohp.class, 970, true, (Bundle)localObject3);
              }
            }
            else
            {
              localObject2 = localObject1.a[paramInt];
              if (localObject2 != null) {
                ((boij)localObject2).a(paramActivity, paramInt);
              }
              ((bohs)localObject1).a(this, paramActivity, paramInt);
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
              localObject3 = (bohe)((Iterator)localObject2).next();
              if ((localObject3 instanceof bohg))
              {
                ((List)localObject1).add(((bohg)localObject3).a);
                continue;
                if ((!"front".equals(((QIMTemplateItem)localObject3).f)) || (!bdav.c())) {
                  break;
                }
                localObject3 = new Bundle();
                ((Bundle)localObject3).putInt(bdax.b, 1);
                ((AppRuntime)localObject2).notifyObservers(bohp.class, 970, true, (Bundle)localObject3);
                break;
              }
              ((bohe)localObject3).a(paramActivity, paramInt);
            }
          } while (!(this instanceof boij));
          localObject2 = (bohj)bogd.a(5);
          if (((bohj)localObject2).a(paramInt).a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QCombo", 2, "apply " + toString() + ", " + paramInt + " comboApplyFilterAborted");
        return 0;
        localObject3 = ((bohj)localObject2).a;
      } while (localObject3 == null);
      Object localObject2 = ((bohj)localObject2).a(this, ((bpju)localObject3).a(paramInt).c);
      if (localObject2 != null) {
        bpjt.a().b((QIMFilterCategoryItem)localObject2, paramActivity, paramInt);
      }
      bpjt.a().a((QIMFilterCategoryItem)localObject2, paramInt);
      bohg.a(paramActivity, (List)localObject1, this, paramInt);
      paramActivity = this.jdField_a_of_type_JavaLangObject;
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) || (!((QIMTemplateItem)this.jdField_a_of_type_JavaLangObject).a()) || (paramInt == 1) || (paramInt == 3));
    ((boje)bogd.a().c(8)).a(paramInt);
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    bohj localbohj = (bohj)bogd.b(5);
    if (localbohj != null) {
      localbohj.a(this, paramInt);
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
      localObject2 = (bohe)((Iterator)localObject1).next();
      if (((localObject2 instanceof bois)) && ((paramInt == 2) || (paramInt == 4))) {
        ((bois)localObject2).c(paramActivity, paramInt);
      } else {
        ((bohe)localObject2).a(paramActivity, paramInt);
      }
    }
    bpjt.a().b(null, paramActivity, paramInt);
    localObject1 = (bohs)bogd.a(15);
    Object localObject2 = localObject1.a[paramInt];
    if ((localObject2 != null) && (((boij)localObject2).b().equals(b()))) {
      ((bohs)localObject1).a(null, paramActivity, paramInt);
    }
  }
  
  public void a(bohe parambohe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadStart " + toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
    }
  }
  
  public void a(bohe parambohe, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambohe);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadError " + toString() + ":" + parambohe.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
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
    bohj localbohj = (bohj)bogd.b(5);
    if (localbohj != null) {
      localbohj.a(this);
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
    ((bohs)bogd.a(15)).a(localQIMTemplateItem, paramActivity, paramInt);
    ((bohj)bogd.a(5)).a(paramInt).a(this);
  }
  
  public void b(bohe parambohe)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(parambohe);
    if (QLog.isColorLevel()) {
      QLog.i("QTemplate", 2, "onDownloadSuccess= " + toString() + ":" + parambohe.toString() + ", count=" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size());
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
    bohe localbohe;
    if (((Iterator)localObject).hasNext())
    {
      localbohe = (bohe)((Iterator)localObject).next();
      if (localbohe.a() == 2)
      {
        localbohe.a(this);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbohe);
        localbohe.b();
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "download " + toString() + "  " + localbohe.toString());
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
      if (localbohe.a() == 1)
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localbohe);
        localbohe.a(this);
        if (QLog.isColorLevel()) {
          QLog.i("QTemplate", 2, "downloading " + toString() + ":" + localbohe.toString());
        }
        k = 1;
        j = i;
        i = k;
        continue;
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
        {
          b(1);
          a();
          localObject = (bohj)bogd.b(5);
          if (localObject != null) {
            ((bohj)localObject).b(this);
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
  
  public void d(bohe parambohe)
  {
    this.c.add(parambohe);
    parambohe.c = (this.c.size() - 1);
    this.jdField_b_of_type_Float = (1.0F / this.c.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boij
 * JD-Core Version:    0.7.0.1
 */