import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;

public class bejh
{
  SparseArray<beje> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  bejh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(bejf.a.length);
  }
  
  beje a(int paramInt)
  {
    beje localbeje = (beje)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbeje != null) {
      ??? = localbeje;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localbeje;
        }
      } while (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null);
      ??? = localbeje;
    } while (localbeje == null);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
          break label186;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbeje);
        return localbeje;
      }
      Object localObject2 = new bejr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label186:
      localObject2 = (beje)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
          beje localbeje = (beje)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          if (localbeje != null) {
            localbeje.a();
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
 * Qualified Name:     bejh
 * JD-Core Version:    0.7.0.1
 */