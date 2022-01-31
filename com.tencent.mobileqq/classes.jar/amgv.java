import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;

public class amgv
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Vector<amgs> jdField_a_of_type_JavaUtilVector;
  boolean jdField_a_of_type_Boolean = false;
  
  public amgv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(awgf paramawgf)
  {
    for (;;)
    {
      awgh localawgh;
      amgs localamgs;
      String str;
      amgx localamgx;
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
          localawgh = paramawgf.a();
          ??? = localawgh;
          localObject2 = localawgh;
          localawgh.a();
          ??? = localawgh;
          localObject2 = localawgh;
          localObject3 = ((List)localObject3).iterator();
        }
        catch (Exception paramawgf)
        {
          localObject2 = ???;
          paramawgf.printStackTrace();
          localObject2 = ???;
          if (!QLog.isColorLevel()) {
            break label351;
          }
          localObject2 = ???;
          QLog.w("Q.db.Cache", 2, "writeRunable write exception: " + paramawgf.getMessage());
          if (??? == null) {
            break label477;
          }
          ((awgh)???).b();
          return;
          paramawgf = finally;
          throw paramawgf;
          ??? = localawgh;
          localObject2 = localawgh;
          paramawgf.a(localamgs.jdField_a_of_type_Awge);
          if (localamgx == null) {
            continue;
          }
          ??? = localawgh;
          localObject2 = localawgh;
          localamgx.a(str, 1);
          continue;
        }
        finally
        {
          if (localObject2 == null) {
            break label414;
          }
          localObject2.b();
        }
        ??? = localawgh;
        localObject2 = localawgh;
        if (!((Iterator)localObject3).hasNext()) {
          break label456;
        }
        ??? = localawgh;
        localObject2 = localawgh;
        localamgs = (amgs)((Iterator)localObject3).next();
        ??? = localawgh;
        localObject2 = localawgh;
        str = localamgs.jdField_a_of_type_Awge.getTableName();
        ??? = localawgh;
        localObject2 = localawgh;
        localamgx = localamgs.jdField_a_of_type_Amgx;
        ??? = localawgh;
        localObject2 = localawgh;
        if (QLog.isColorLevel())
        {
          ??? = localawgh;
          localObject2 = localawgh;
          QLog.d("Q.db.Cache", 2, "writeRunable QueueItem.action: " + localamgs.jdField_a_of_type_Int);
        }
        ??? = localawgh;
        localObject2 = localawgh;
        switch (localamgs.jdField_a_of_type_Int)
        {
        case 0: 
          ??? = localawgh;
          localObject2 = localawgh;
          paramawgf.b(localamgs.jdField_a_of_type_Awge);
          if (localamgx == null) {
            continue;
          }
          ??? = localawgh;
          localObject2 = localawgh;
          localamgx.a(str);
        }
      }
      label351:
      ??? = localawgh;
      label414:
      Object localObject2 = localawgh;
      paramawgf.b(localamgs.jdField_a_of_type_Awge);
      if (localamgx != null)
      {
        ??? = localawgh;
        localObject2 = localawgh;
        localamgx.b(str, 1);
        continue;
        label456:
        ??? = localawgh;
        localObject2 = localawgh;
        localawgh.c();
        if (localawgh != null) {
          localawgh.b();
        }
        label477:
        return;
      }
    }
  }
  
  public Vector<amgs> a()
  {
    return this.jdField_a_of_type_JavaUtilVector;
  }
  
  public void a() {}
  
  public void a(awge arg1, int paramInt1, int paramInt2, amgx paramamgx)
  {
    paramamgx = new amgs(???, paramInt1, paramInt2, paramamgx);
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilVector)
      {
        this.jdField_a_of_type_JavaUtilVector.add(paramamgx);
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
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    a(localawgf);
    localawgf.a();
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
 * Qualified Name:     amgv
 * JD-Core Version:    0.7.0.1
 */