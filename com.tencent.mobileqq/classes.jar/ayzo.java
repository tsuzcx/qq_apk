import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ayzo
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ayzk> jdField_a_of_type_JavaUtilList;
  
  public ayzo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ayzp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilList.add(new ayzq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_JavaUtilList.add(new ayzr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModPushDispatcher", 2, String.format("process intValue=%s bytesValue=%s", new Object[] { Integer.valueOf(paramInt), Arrays.toString(paramByteStringMicro.toByteArray()) }));
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ayzk localayzk = (ayzk)localIterator.next();
        try
        {
          if (localayzk.a(paramInt)) {
            localayzk.a(paramInt, paramByteStringMicro);
          }
        }
        catch (Exception localException)
        {
          QLog.e("ProfileModPushDispatcher", 1, "process fail.", localException);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModPushDispatcher", 2, String.format("processBegin uin=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ayzk localayzk = (ayzk)localIterator.next();
        try
        {
          localayzk.a(paramLong);
        }
        catch (Exception localException)
        {
          QLog.e("ProfileModPushDispatcher", 1, "processBegin fail.", localException);
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModPushDispatcher", 2, "processEnd");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ayzk localayzk = (ayzk)localIterator.next();
        try
        {
          localayzk.a();
        }
        catch (Exception localException)
        {
          QLog.e("ProfileModPushDispatcher", 1, "processEnd fail.", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzo
 * JD-Core Version:    0.7.0.1
 */