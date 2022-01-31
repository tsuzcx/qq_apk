import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class amce
  implements Manager
{
  private amcg jdField_a_of_type_Amcg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private amcc[] jdField_a_of_type_ArrayOfAmcc = new amcc[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public amce(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amcg = new amcg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      amcc localamcc = a(k);
      if (localamcc != null)
      {
        localamcc.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localamcc.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localamcc.a(0);
      }
      i += 1;
    }
  }
  
  public amcc a(int paramInt)
  {
    amcc localamcc = this.jdField_a_of_type_ArrayOfAmcc[paramInt];
    if (localamcc == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfAmcc)
      {
        localamcc = this.jdField_a_of_type_ArrayOfAmcc[paramInt];
        if (localamcc != null) {
          return localamcc;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localamcc != null) && (this.jdField_a_of_type_ArrayOfAmcc[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfAmcc[paramInt] = localamcc;
          }
          if ((QLog.isColorLevel()) && (localamcc != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localamcc.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localamcc;
        }
      }
      Object localObject2 = new amcl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amcg);
      continue;
      localObject2 = new amcn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amcg);
      continue;
      return localObject2;
    }
  }
  
  public amcg a()
  {
    return this.jdField_a_of_type_Amcg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Amcg.a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    a(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAmcc)
      {
        amcc[] arrayOfamcc2 = this.jdField_a_of_type_ArrayOfAmcc;
        int j = arrayOfamcc2.length;
        i = 0;
        if (i < j)
        {
          amcc localamcc = arrayOfamcc2[i];
          if (localamcc != null) {
            localamcc.b();
          }
        }
        else
        {
          this.jdField_a_of_type_Amcg.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amce
 * JD-Core Version:    0.7.0.1
 */