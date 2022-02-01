import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;

public class bdch
{
  SparseArray<bdce> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  bdch(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(bdcf.a.length);
  }
  
  bdce a(int paramInt)
  {
    bdce localbdce = (bdce)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbdce != null) {
      ??? = localbdce;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localbdce;
        }
      } while (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null);
      ??? = localbdce;
    } while (localbdce == null);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
          break label167;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbdce);
        return localbdce;
      }
      Object localObject2 = new bdcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdco(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdcr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdcq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label167:
      localObject2 = (bdce)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
  }
  
  void a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        i = 0;
        if (i < j)
        {
          bdce localbdce = (bdce)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          if (localbdce != null) {
            localbdce.a();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.clear();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdch
 * JD-Core Version:    0.7.0.1
 */