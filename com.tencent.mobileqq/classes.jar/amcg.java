import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class amcg
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<amcd> jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public amcg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(awbw paramawbw)
  {
    for (;;)
    {
      awby localawby;
      amcd localamcd;
      String str;
      amci localamci;
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "transSaveToDatabase writeRunable msgQueue size:" + this.jdField_a_of_type_JavaUtilVector.size());
        }
        if (this.jdField_a_of_type_JavaUtilVector.isEmpty()) {
          return;
        }
        Object localObject3 = (List)this.jdField_a_of_type_JavaUtilVector.clone();
        this.jdField_a_of_type_JavaUtilVector.clear();
        if (localObject3 == null) {
          break label477;
        }
        localObject2 = null;
        ??? = null;
        try
        {
          localawby = paramawbw.a();
          ??? = localawby;
          localObject2 = localawby;
          localawby.a();
          ??? = localawby;
          localObject2 = localawby;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramawbw)
        {
          localObject2 = ???;
          paramawbw.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramawbw.getMessage());
          if (??? == null) {
            break label477;
          }
          ((awby)???).b();
          return;
          paramawbw = finally;
          throw paramawbw;
          ??? = localawby;
          localObject2 = localawby;
          paramawbw.a(localamcd.jdField_a_of_type_Awbv);
          if (localamci == null) {
            continue;
          }
          ??? = localawby;
          localObject2 = localawby;
          localamci.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localawby;
        localObject2 = localawby;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localawby;
        localObject2 = localawby;
        localamcd = (amcd)((Iterator)localObject3).next();
        ??? = localawby;
        localObject2 = localawby;
        str = localamcd.jdField_a_of_type_Awbv.getTableName();
        ??? = localawby;
        localObject2 = localawby;
        localamci = localamcd.jdField_a_of_type_Amci;
        ??? = localawby;
        localObject2 = localawby;
        if (QLog.isColorLevel())
        {
          ??? = localawby;
          localObject2 = localawby;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localamcd.jdField_a_of_type_Int);
        }
        ??? = localawby;
        localObject2 = localawby;
        switch (localamcd.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localawby;
          localObject2 = localawby;
          paramawbw.b(localamcd.jdField_a_of_type_Awbv);
          if (localamci == null) {
            continue;
          }
          ??? = localawby;
          localObject2 = localawby;
          localamci.a(str);
        }
      }
      label351:
      ??? = localawby;
      label414:
      Object localObject2 = localawby;
      paramawbw.b(localamcd.jdField_a_of_type_Awbv);
      if (localamci != null)
      {
        ??? = localawby;
        localObject2 = localawby;
        localamci.b(str, 1);
        continue;
        label456:
        ??? = localawby;
        localObject2 = localawby;
        localawby.c();
        if (localawby != null) {
          localawby.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector<amcd> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(awbv arg1, int paramInt1, int paramInt2, amci paramamci)
  {
    paramamci = new amcd(???, paramInt1, paramInt2, paramamci);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramamci);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.db.Cache", 2, "addQueue after destroy");
          }
          b();
          return;
        }
      }
      switch (paramInt2)
      {
      case 2: 
      default: 
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause);
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "addMsgQueue write notify");
    }
    b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache", 2, "transSaveToDatabase");
    }
    awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localawbw);
    localawbw.a();
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcg
 * JD-Core Version:    0.7.0.1
 */