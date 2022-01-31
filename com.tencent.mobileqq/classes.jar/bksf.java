import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bksf
{
  private bksg jdField_a_of_type_Bksg;
  private ConcurrentHashMap<Integer, bksj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bksj a(int paramInt)
  {
    return (bksj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bksj parambksj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambksj.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambksj.a), parambksj);
    if (this.jdField_a_of_type_Bksg != null) {
      this.jdField_a_of_type_Bksg.a();
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
 * Qualified Name:     bksf
 * JD-Core Version:    0.7.0.1
 */