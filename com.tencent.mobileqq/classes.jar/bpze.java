import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bpze
{
  private bpzf jdField_a_of_type_Bpzf;
  private ConcurrentHashMap<Integer, bpzi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bpzi a(int paramInt)
  {
    return (bpzi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bpzi parambpzi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambpzi.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambpzi.a), parambpzi);
    if (this.jdField_a_of_type_Bpzf != null) {
      this.jdField_a_of_type_Bpzf.a();
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
 * Qualified Name:     bpze
 * JD-Core Version:    0.7.0.1
 */