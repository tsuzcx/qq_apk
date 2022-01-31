import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bkro
{
  private bkrp jdField_a_of_type_Bkrp;
  private ConcurrentHashMap<Integer, bkrs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bkrs a(int paramInt)
  {
    return (bkrs)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bkrs parambkrs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambkrs.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambkrs.a), parambkrs);
    if (this.jdField_a_of_type_Bkrp != null) {
      this.jdField_a_of_type_Bkrp.a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkro
 * JD-Core Version:    0.7.0.1
 */