import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bnva
{
  private bnvb jdField_a_of_type_Bnvb;
  private ConcurrentHashMap<Integer, bnve> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bnve a(int paramInt)
  {
    return (bnve)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bnve parambnve)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambnve.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambnve.a), parambnve);
    if (this.jdField_a_of_type_Bnvb != null) {
      this.jdField_a_of_type_Bnvb.a();
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
 * Qualified Name:     bnva
 * JD-Core Version:    0.7.0.1
 */