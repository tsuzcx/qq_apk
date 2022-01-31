import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class amgt
  implements Manager
{
  private amgv jdField_a_of_type_Amgv;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private amgr[] jdField_a_of_type_ArrayOfAmgr = new amgr[4];
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[0];
  
  public amgt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amgv = new amgv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      amgr localamgr = a(k);
      if (localamgr != null)
      {
        localamgr.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localamgr.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localamgr.a(0);
      }
      i += 1;
    }
  }
  
  public amgr a(int paramInt)
  {
    amgr localamgr = this.jdField_a_of_type_ArrayOfAmgr[paramInt];
    if (localamgr == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfAmgr)
      {
        localamgr = this.jdField_a_of_type_ArrayOfAmgr[paramInt];
        if (localamgr != null) {
          return localamgr;
        }
        long l = System.currentTimeMillis();
        switch (paramInt)
        {
        case 2: 
          if ((localamgr != null) && (this.jdField_a_of_type_ArrayOfAmgr[paramInt] == null)) {
            this.jdField_a_of_type_ArrayOfAmgr[paramInt] = localamgr;
          }
          if ((QLog.isColorLevel()) && (localamgr != null)) {
            QLog.d("Q.db.Cache", 2, "get cache instance:" + localamgr.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
          }
          return localamgr;
        }
      }
      Object localObject2 = new amha(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amgv);
      continue;
      localObject2 = new amhc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amgv);
      continue;
      return localObject2;
    }
  }
  
  public amgv a()
  {
    return this.jdField_a_of_type_Amgv;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_Amgv.a();
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
      synchronized (this.jdField_a_of_type_ArrayOfAmgr)
      {
        amgr[] arrayOfamgr2 = this.jdField_a_of_type_ArrayOfAmgr;
        int j = arrayOfamgr2.length;
        i = 0;
        if (i < j)
        {
          amgr localamgr = arrayOfamgr2[i];
          if (localamgr != null) {
            localamgr.b();
          }
        }
        else
        {
          this.jdField_a_of_type_Amgv.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgt
 * JD-Core Version:    0.7.0.1
 */