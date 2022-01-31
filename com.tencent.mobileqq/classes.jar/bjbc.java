import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class bjbc
{
  private bjbd jdField_a_of_type_Bjbd;
  private ConcurrentHashMap<Integer, bjbg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bjbg a(int paramInt)
  {
    return (bjbg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(bjbg parambjbg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FrameAdapter", 2, "addFrame, index=" + parambjbg.a);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(Integer.valueOf(parambjbg.a), parambjbg);
    if (this.jdField_a_of_type_Bjbd != null) {
      this.jdField_a_of_type_Bjbd.a();
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
 * Qualified Name:     bjbc
 * JD-Core Version:    0.7.0.1
 */