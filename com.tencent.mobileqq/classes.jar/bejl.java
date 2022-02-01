import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;

public class bejl
{
  SparseArray<beji> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  bejl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(bejj.a.length);
  }
  
  beji a(int paramInt)
  {
    beji localbeji = (beji)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbeji != null) {
      ??? = localbeji;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localbeji;
        }
      } while (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null);
      ??? = localbeji;
    } while (localbeji == null);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
          break label167;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localbeji);
        return localbeji;
      }
      Object localObject2 = new bejt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new bejv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new beju(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label167:
      localObject2 = (beji)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
          beji localbeji = (beji)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          if (localbeji != null) {
            localbeji.a();
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
 * Qualified Name:     bejl
 * JD-Core Version:    0.7.0.1
 */