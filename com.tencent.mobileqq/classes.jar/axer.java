import android.view.animation.AnimationUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class axer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private String jdField_a_of_type_JavaLangString;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  private final CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < 1) {
      return;
    }
    new axes(this).execute(new Void[0]);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (paramInt == 2)
      {
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_a_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Int > 0))
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long;
      paramInt = (int)Math.floor(this.jdField_a_of_type_Int * 1000 / ((float)l * 1.0F));
      this.jdField_a_of_type_JavaLangStringBuffer.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuffer.append("FPSCalculator ").append(this.jdField_a_of_type_JavaLangString).append(" frameCount :").append(this.jdField_a_of_type_Int).append(",diffTime :").append(l).append(" fps:").append(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("FPSCalculator", 2, this.jdField_a_of_type_JavaLangStringBuffer.toString());
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangStringBuffer.toString());
      if (((paramInt <= 0) || ("".equals(this.jdField_a_of_type_JavaLangString))) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 100)) {
        a();
      }
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axer
 * JD-Core Version:    0.7.0.1
 */