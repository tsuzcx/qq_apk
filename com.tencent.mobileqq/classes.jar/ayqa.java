import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

public class ayqa
{
  public int a;
  private long a;
  
  public ayqa(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > ayqi.O;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 40001;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatus", 2, "[status] resetIfDead from: " + paramString + " hasDead: " + bool + " status: " + toString());
    }
    if (bool) {
      a();
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ayqa)paramObject;
    } while (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int);
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "AutoStatus{status=" + ayqi.a(this.jdField_a_of_type_Int) + ", updateTime=" + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Long)) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqa
 * JD-Core Version:    0.7.0.1
 */