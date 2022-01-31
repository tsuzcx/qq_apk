import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bndp
{
  private bndq jdField_a_of_type_Bndq;
  private ConcurrentHashMap<Integer, bndt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bndt a(int paramInt)
  {
    return (bndt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bndt parambndt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambndt.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambndt.a), parambndt);
    if (this.jdField_a_of_type_Bndq != null) {
      this.jdField_a_of_type_Bndq.a();
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
 * Qualified Name:     bndp
 * JD-Core Version:    0.7.0.1
 */