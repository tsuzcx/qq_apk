import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Random;

public class bcxl
{
  private long jdField_a_of_type_Long = -1L;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 300 != 1) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Long == -1L) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("cost", l1 - l2 + "");
    localHashMap.put("layout", paramInt1 + "");
    localHashMap.put("first", paramInt2 + "");
    bctj.a(BaseApplication.getContext()).a(null, "structmsg_builder_getview", true, 0L, 0L, localHashMap, "", false);
    this.jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxl
 * JD-Core Version:    0.7.0.1
 */