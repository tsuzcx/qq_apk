import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class braz
{
  private brba jdField_a_of_type_Brba;
  private ConcurrentHashMap<Integer, brbd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public brbd a(int paramInt)
  {
    return (brbd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(brbd parambrbd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambrbd.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambrbd.a), parambrbd);
    if (this.jdField_a_of_type_Brba != null) {
      this.jdField_a_of_type_Brba.a();
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
 * Qualified Name:     braz
 * JD-Core Version:    0.7.0.1
 */