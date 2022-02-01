import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bpks
{
  private bpkt jdField_a_of_type_Bpkt;
  private ConcurrentHashMap<Integer, bpkw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bpkw a(int paramInt)
  {
    return (bpkw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bpkw parambpkw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambpkw.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambpkw.a), parambpkw);
    if (this.jdField_a_of_type_Bpkt != null) {
      this.jdField_a_of_type_Bpkt.a();
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
 * Qualified Name:     bpks
 * JD-Core Version:    0.7.0.1
 */