import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bnib
{
  private bnic jdField_a_of_type_Bnic;
  private ConcurrentHashMap<Integer, bnif> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bnif a(int paramInt)
  {
    return (bnif)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bnif parambnif)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambnif.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambnif.a), parambnif);
    if (this.jdField_a_of_type_Bnic != null) {
      this.jdField_a_of_type_Bnic.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnib
 * JD-Core Version:    0.7.0.1
 */