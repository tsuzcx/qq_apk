import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;

public class bdqp
{
  SparseArray<bdqm> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  bdqp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(bdqn.a.length);
  }
  
  bdqm a(int paramInt)
  {
    bdqm localbdqm = (bdqm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbdqm != null) {
      ??? = localbdqm;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localbdqm;
        }
      } while (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null);
      ??? = localbdqm;
    } while (localbdqm == null);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
          break label167;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbdqm);
        return localbdqm;
      }
      Object localObject2 = new bdqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdqw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdqz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bdqy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label167:
      localObject2 = (bdqm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
          bdqm localbdqm = (bdqm)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          if (localbdqm != null) {
            localbdqm.a();
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
 * Qualified Name:     bdqp
 * JD-Core Version:    0.7.0.1
 */